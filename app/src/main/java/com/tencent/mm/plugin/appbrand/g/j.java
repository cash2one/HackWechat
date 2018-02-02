package com.tencent.mm.plugin.appbrand.g;

import android.content.Context;
import android.os.Looper;
import android.util.Pair;
import android.webkit.ValueCallback;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.xweb.WebView;
import com.tencent.xweb.d;
import com.tencent.xweb.p;
import java.net.URL;
import java.util.LinkedList;

public final class j extends WebView implements b, e {
    private final LinkedList<Pair<String, ValueCallback<String>>> iTT = new LinkedList();
    private boolean iTU = false;
    private p iTV = new 2(this);
    private boolean jvW = false;
    private Context mContext;
    private af mHandler;
    private volatile boolean qG = false;

    public j(Context context) {
        super(context);
        this.mContext = context;
        this.mHandler = new af(Looper.getMainLooper());
        getSettings().setJavaScriptEnabled(true);
        getSettings().setUserAgentString(s.aL(this.mContext, getSettings().getUserAgentString()));
        setWebViewClient(this.iTV);
        setWillNotDraw(true);
    }

    public final void addJavascriptInterface(Object obj, String str) {
        if (obj != null && !bh.ov(str)) {
            super.addJavascriptInterface(obj, str);
        }
    }

    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (!this.jvW) {
            this.jvW = true;
            loadDataWithBaseURL("https://servicewechat.com/js-engine", "<html>\n  <head>\n    <meta http-equiv=\"Content-Security-Policy\" content=\"default-src 'none';script-src 'unsafe-eval';\">\n  </head>\n  <body></body>\n</html>", "text/html", ProtocolPackage.ServerEncoding, null);
        }
        synchronized (this.iTT) {
            if (this.iTU) {
                a(str, valueCallback);
                return;
            }
            this.iTT.add(new Pair(str, valueCallback));
        }
    }

    public final void a(URL url, String str, ValueCallback<String> valueCallback) {
        evaluateJavascript(str, valueCallback);
    }

    public final void a(d dVar) {
    }

    private void a(final String str, final ValueCallback<String> valueCallback) {
        if (!this.qG) {
            Runnable anonymousClass1 = new Runnable(this) {
                final /* synthetic */ j jvX;

                public final void run() {
                    super.evaluateJavascript(str, valueCallback);
                }
            };
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                anonymousClass1.run();
            } else {
                this.mHandler.post(anonymousClass1);
            }
        }
    }

    public final void destroy() {
        this.qG = true;
        super.destroy();
    }

    public final <T extends c> T v(Class<T> cls) {
        return cls.isInstance(this) ? this : null;
    }

    public final void sX(String str) {
        evaluateJavascript("document.title=\"" + str + "\"", null);
    }
}
