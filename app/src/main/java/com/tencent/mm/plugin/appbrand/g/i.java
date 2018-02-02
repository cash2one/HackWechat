package com.tencent.mm.plugin.appbrand.g;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.WebView;
import com.tencent.xweb.d;
import com.tencent.xweb.g;
import com.tencent.xweb.g.a;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.concurrent.CountDownLatch;

public final class i implements b, d, g {
    private volatile boolean iTN = false;
    private volatile boolean iTO = false;
    private volatile CountDownLatch iTP;
    g jvT;
    private Handler mHandler;

    public i(Context context) {
        this.jvT = g.a(a.ApS, "appbrand", context);
        this.jvT.addJavascriptInterface(this, "WeixinJsThreadCaller");
        this.mHandler = new Handler(Looper.getMainLooper());
    }

    public final void addJavascriptInterface(Object obj, String str) {
        this.jvT.addJavascriptInterface(obj, str);
    }

    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (!this.iTN) {
            Runnable 1 = new 1(this, str, valueCallback);
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                1.run();
            } else {
                this.mHandler.post(1);
            }
        }
    }

    public final void a(final URL url, final String str, final ValueCallback<String> valueCallback) {
        if (!this.iTN) {
            Runnable anonymousClass2 = new Runnable(this) {
                final /* synthetic */ i jvU;

                public final void run() {
                    g a = this.jvU.jvT;
                    URL url = url;
                    String str = str;
                    ValueCallback valueCallback = valueCallback;
                    if (!a.iTN) {
                        a.ApP.evaluateJavascript(str, valueCallback, url);
                    }
                }
            };
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                anonymousClass2.run();
            } else {
                this.mHandler.post(anonymousClass2);
            }
        }
    }

    public final void a(d dVar) {
        this.jvT.ApP.a(dVar);
    }

    public final void destroy() {
        if (!this.iTN) {
            this.jvT.cleanup();
        }
        this.iTN = true;
    }

    public final <T extends c> T v(Class<T> cls) {
        if (!cls.isInstance(this)) {
            return null;
        }
        if (cls != d.class || this.jvT.ApP.cIB()) {
            return this;
        }
        return null;
    }

    public final void pause() {
        if (this.jvT.BZ()) {
            this.jvT.pause();
            return;
        }
        this.iTO = true;
        evaluateJavascript("var ret = WeixinJsThreadCaller.callFromJsThread();", new 3(this));
    }

    public final void resume() {
        if (this.jvT.BZ()) {
            this.jvT.resume();
            return;
        }
        this.iTO = false;
        if (this.iTP != null) {
            this.iTP.countDown();
            this.iTP = null;
        }
    }

    public final int getNativeBufferId() {
        return this.jvT.ApP.getNativeBufferId();
    }

    public final void setNativeBuffer(int i, ByteBuffer byteBuffer) {
        this.jvT.ApP.setNativeBuffer(i, byteBuffer);
    }

    public final ByteBuffer ef(int i) {
        return this.jvT.ApP.ef(i);
    }

    public final boolean adU() {
        if (g.cIm() != a.ApX || WebView.getTbsCoreVersion(ac.getContext()) < 43600) {
            return false;
        }
        return true;
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final int callFromJsThread() {
        x.d("MicroMsg.AppBrandMessBasedJsEngine", "enter callFromJsThread, pendingPause %b", new Object[]{Boolean.valueOf(this.iTO)});
        if (this.iTO) {
            x.i("MicroMsg.AppBrandMessBasedJsEngine", "pause await threadId %d", new Object[]{Long.valueOf(Thread.currentThread().getId())});
            this.iTO = false;
            this.iTP = new CountDownLatch(1);
            try {
                this.iTP.await();
            } catch (InterruptedException e) {
                x.e("MicroMsg.AppBrandMessBasedJsEngine", "pause await e = %s", new Object[]{e});
            }
        }
        return 1;
    }
}
