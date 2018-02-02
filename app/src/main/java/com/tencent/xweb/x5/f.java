package com.tencent.xweb.x5;

import android.content.Context;
import android.webkit.ValueCallback;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.ah;
import com.tencent.xweb.x5.a.d;
import java.net.URL;
import java.nio.ByteBuffer;
import org.xwalk.core.Log;

public final class f implements com.tencent.xweb.c.f {
    private ah ArK;
    private Context mContext;

    public f(Context context) {
        this.mContext = context;
        Log.i("MicroMsg.X5JsRuntime", "create X5V8JsRuntime");
    }

    public final void init(int i) {
        this.ArK = new ah(this.mContext);
    }

    public final void pause() {
        if (this.ArK.wD != null) {
            ah.a("pause", new Class[]{Object.class}, this.ArK.wD);
        }
    }

    public final void resume() {
        if (this.ArK.wD != null) {
            ah.a("resume", new Class[]{Object.class}, this.ArK.wD);
        }
    }

    public final boolean BZ() {
        return ah.hF(this.mContext) && QbSdk.getTbsVersion(this.mContext) >= 43600;
    }

    public final void cleanup() {
        ah ahVar = this.ArK;
        if (ahVar.wD != null) {
            ah.a("destroyX5JsCore", new Class[]{Object.class}, ahVar.wD);
            ahVar.wD = null;
        } else if (ahVar.zVo != null) {
            ahVar.zVo.clearHistory();
            ahVar.zVo.clearCache(true);
            ahVar.zVo.loadUrl("about:blank");
            ahVar.zVo.freeMemory();
            ahVar.zVo.pauseTimers();
            ahVar.zVo.destroy();
            ahVar.zVo = null;
        }
    }

    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        this.ArK.evaluateJavascript(str, new d(valueCallback));
    }

    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback, URL url) {
        this.ArK.evaluateJavascript(str, new d(valueCallback));
    }

    public final void addJavascriptInterface(Object obj, String str) {
        ah ahVar = this.ArK;
        if (ahVar.wD != null) {
            ah.a("addJavascriptInterface", new Class[]{Object.class, String.class, Object.class}, obj, str, ahVar.wD);
        } else if (ahVar.zVo != null) {
            ahVar.zVo.addJavascriptInterface(obj, str);
            ahVar.zVo.loadUrl("about:blank");
        }
    }

    public final int getNativeBufferId() {
        return this.ArK.getNativeBufferId();
    }

    public final void setNativeBuffer(int i, ByteBuffer byteBuffer) {
        this.ArK.setNativeBuffer(i, byteBuffer);
    }

    public final ByteBuffer ef(int i) {
        return this.ArK.ef(i);
    }

    public final boolean cIB() {
        return ah.hG(this.mContext);
    }

    public final void a(com.tencent.xweb.d dVar) {
    }
}
