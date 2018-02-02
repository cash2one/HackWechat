package com.tencent.xweb.xwalk;

import android.os.Handler;
import android.os.HandlerThread;
import android.webkit.ValueCallback;
import com.tencent.xweb.c.f;
import com.tencent.xweb.d;
import java.net.URL;
import java.nio.ByteBuffer;
import org.xwalk.core.XWalkV8;

public final class g implements f {
    HandlerThread AsP = new HandlerThread("j2v8");
    private Handler AsQ;
    XWalkV8 Atd;

    public g() {
        this.AsP.start();
        this.AsQ = new Handler(this.AsP.getLooper());
    }

    public final void init(int i) {
        this.AsQ.post(new 1(this, i));
    }

    public final void pause() {
    }

    public final void resume() {
    }

    public final void cleanup() {
        this.AsQ.post(new 2(this));
    }

    public final boolean BZ() {
        return false;
    }

    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        this.AsQ.post(new 3(this, str, valueCallback));
    }

    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback, URL url) {
        evaluateJavascript(str, valueCallback);
    }

    public final void addJavascriptInterface(Object obj, String str) {
        this.AsQ.post(new 4(this, obj, str));
    }

    public final int getNativeBufferId() {
        return 0;
    }

    public final void setNativeBuffer(int i, ByteBuffer byteBuffer) {
    }

    public final ByteBuffer ef(int i) {
        return null;
    }

    public final boolean cIB() {
        return false;
    }

    public final void a(d dVar) {
    }
}
