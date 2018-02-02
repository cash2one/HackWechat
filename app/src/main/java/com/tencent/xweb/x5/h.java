package com.tencent.xweb.x5;

import android.content.Context;
import android.webkit.ValueCallback;
import com.tencent.smtt.sdk.c;
import com.tencent.smtt.sdk.c.1;
import com.tencent.smtt.sdk.f.a;
import com.tencent.xweb.c.f;
import com.tencent.xweb.d;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.Iterator;
import org.xwalk.core.Log;

public final class h implements f {
    private c ArS;
    private a ArT;
    d jwz;
    private Context mContext;

    public h(Context context) {
        this.mContext = context;
        Log.i("MicroMsg.X5V8JsRuntime", "create X5V8JsRuntime");
    }

    public final void init(int i) {
        this.ArS = new c(this.mContext);
        this.ArT = new a();
        this.ArS.addJavascriptInterface(this.ArT, "nativeBufferCompat");
        this.ArS.evaluateJavascript("function getNativeBufferId() {   if (nativeBufferCompat) {       return nativeBufferCompat.getNativeBufferId();   }   return -1;}function setNativeBuffer(id, bytes) {   if (nativeBufferCompat) {       return nativeBufferCompat.setNativeBuffer(id, bytes);   }}function getNativeBuffer(id) {   if (nativeBufferCompat) {       return nativeBufferCompat.getNativeBuffer(id);   }}", new a.d(new 1(this)), null);
        c cVar = this.ArS;
        cVar.zVr = new 2(this);
        cVar.zVq.setExceptionHandler(new 1(cVar));
    }

    public final void pause() {
        com.tencent.smtt.sdk.f fVar = this.ArS.zVp;
        if (fVar.zVw != null) {
            fVar.zVw.onPause();
            return;
        }
        Iterator it = fVar.zVx.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference.get() != null) {
                a aVar = (a) weakReference.get();
                if (aVar.zVo != null) {
                    aVar.zVo.onPause();
                }
            }
        }
    }

    public final void resume() {
        com.tencent.smtt.sdk.f fVar = this.ArS.zVp;
        if (fVar.zVw != null) {
            fVar.zVw.onResume();
            return;
        }
        Iterator it = fVar.zVx.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference.get() != null) {
                a aVar = (a) weakReference.get();
                if (aVar.zVo != null) {
                    aVar.zVo.onResume();
                }
            }
        }
    }

    public final boolean BZ() {
        return true;
    }

    public final void cleanup() {
        this.ArS.zVq.destroy();
        this.ArT.jww.clear();
    }

    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        this.ArS.evaluateJavascript(str, new a.d(valueCallback), null);
    }

    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback, URL url) {
        Log.i("MicroMsg.X5V8JsRuntime", String.format("evaluateJavascriptWithURL(%s)", new Object[]{url}));
        this.ArS.evaluateJavascript(str, new a.d(valueCallback), url);
    }

    public final void addJavascriptInterface(Object obj, String str) {
        this.ArS.addJavascriptInterface(obj, str);
    }

    public final int getNativeBufferId() {
        return this.ArT.getNativeBufferId();
    }

    public final void setNativeBuffer(int i, ByteBuffer byteBuffer) {
        byte[] bArr;
        a aVar = this.ArT;
        if (byteBuffer == null) {
            bArr = new byte[0];
        } else if (byteBuffer.isDirect()) {
            int position = byteBuffer.position();
            byteBuffer.position(0);
            bArr = new byte[byteBuffer.remaining()];
            byteBuffer.get(bArr);
            byteBuffer.position(position);
        } else {
            bArr = byteBuffer.array();
        }
        aVar.setNativeBuffer(i, bArr);
    }

    public final ByteBuffer ef(int i) {
        byte[] nativeBuffer = this.ArT.getNativeBuffer(i);
        if (nativeBuffer == null || nativeBuffer.length <= 0) {
            return null;
        }
        return ByteBuffer.wrap(nativeBuffer);
    }

    public final boolean cIB() {
        return true;
    }

    public final void a(d dVar) {
        this.jwz = dVar;
    }
}
