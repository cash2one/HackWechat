package com.tencent.xweb.xwalk;

import android.os.Handler;
import android.os.HandlerThread;
import android.webkit.ValueCallback;
import com.tencent.xweb.c.f;
import com.tencent.xweb.d;
import java.net.URL;
import java.nio.ByteBuffer;

public final class b implements f {
    XWAppBrandEngine AsO;
    HandlerThread AsP = new HandlerThread("v8_worker");
    private Handler AsQ;
    boolean AsR = false;

    public b() {
        this.AsP.start();
        this.AsQ = new Handler(this.AsP.getLooper());
    }

    public final void init(int i) {
        this.AsQ.post(new 1(this));
    }

    public final void pause() {
        if (!this.AsR) {
            this.AsR = true;
            this.AsQ.post(new 2(this));
        }
    }

    public final void resume() {
        this.AsR = false;
    }

    public final void cleanup() {
        this.AsQ.post(new 3(this));
    }

    public final boolean BZ() {
        return true;
    }

    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        this.AsQ.post(new 4(this, str, valueCallback));
    }

    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback, URL url) {
        evaluateJavascript(str, valueCallback);
    }

    public final void addJavascriptInterface(Object obj, String str) {
        this.AsQ.post(new 5(this, obj, str));
    }

    public final int getNativeBufferId() {
        if (this.AsO == null) {
            return 0;
        }
        XWAppBrandEngine xWAppBrandEngine = this.AsO;
        return xWAppBrandEngine.getNativeBufferId(xWAppBrandEngine.mInstance);
    }

    public final void setNativeBuffer(int i, ByteBuffer byteBuffer) {
        XWAppBrandEngine xWAppBrandEngine = this.AsO;
        if (byteBuffer != null) {
            if (!byteBuffer.isDirect()) {
                ByteBuffer allocateDirect = ByteBuffer.allocateDirect(byteBuffer.capacity());
                byteBuffer.rewind();
                allocateDirect.put(byteBuffer);
                byteBuffer = allocateDirect;
            }
            xWAppBrandEngine.setNativeBuffer(xWAppBrandEngine.mInstance, i, byteBuffer);
        }
    }

    public final ByteBuffer ef(int i) {
        XWAppBrandEngine xWAppBrandEngine = this.AsO;
        ByteBuffer nativeBuffer = xWAppBrandEngine.getNativeBuffer(xWAppBrandEngine.mInstance, i);
        return nativeBuffer == null ? ByteBuffer.allocate(0) : nativeBuffer;
    }

    public final boolean cIB() {
        return true;
    }

    public final void a(d dVar) {
    }
}
