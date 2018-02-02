package com.tencent.mm.plugin.appbrand.dynamic.e;

import android.content.Context;
import android.os.Looper;
import android.util.Pair;
import android.webkit.ValueCallback;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.u.b.d;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.xweb.WebView;
import com.tencent.xweb.p;
import java.util.Iterator;
import java.util.LinkedList;

@JgClassChecked(author = 30, fComment = "checked", lastDate = "20170320", reviewer = 30, vComment = {EType.JSEXECUTECHECK})
public class b extends WebView implements d {
    private final LinkedList<Pair<String, ValueCallback<String>>> iTT = new LinkedList();
    private boolean iTU = false;
    private p iTV = new p(this) {
        final /* synthetic */ b iTX;

        {
            this.iTX = r1;
        }

        public final void a(WebView webView, String str) {
            synchronized (this.iTX.iTT) {
                Iterator it = this.iTX.iTT.iterator();
                while (it.hasNext()) {
                    Pair pair = (Pair) it.next();
                    this.iTX.a((String) pair.first, (ValueCallback) pair.second);
                }
                this.iTX.iTT.clear();
                this.iTX.iTU = true;
            }
        }

        public final boolean b(WebView webView, String str) {
            return true;
        }
    };
    private Context mContext;
    private af mHandler;
    private volatile boolean qG = false;

    public b(Context context, Object obj, String str, String str2) {
        super(context);
        this.mContext = context;
        this.mHandler = new af(Looper.getMainLooper());
        getSettings().setJavaScriptEnabled(true);
        getSettings().setUserAgentString(s.aL(this.mContext, getSettings().getUserAgentString()));
        setWebViewClient(this.iTV);
        if (!(obj == null || bh.ov(str))) {
            addJavascriptInterface(obj, str);
        }
        setWillNotDraw(true);
        loadDataWithBaseURL(str2, "<html>\n  <head>\n    <meta http-equiv=\"Content-Security-Policy\" content=\"default-src 'none';script-src 'unsafe-eval';\">\n  </head>\n  <body></body>\n</html>", "text/html", ProtocolPackage.ServerEncoding, null);
    }

    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        synchronized (this.iTT) {
            if (this.iTU) {
                a(str, valueCallback);
                return;
            }
            this.iTT.add(new Pair(str, valueCallback));
        }
    }

    private void a(String str, ValueCallback<String> valueCallback) {
        if (!this.qG) {
            Runnable 1 = new 1(this, str, valueCallback);
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                1.run();
            } else {
                this.mHandler.post(1);
            }
        }
    }

    public final void cleanup() {
        this.qG = true;
        destroy();
    }

    public void pause() {
    }

    public void resume() {
    }

    public boolean BZ() {
        return false;
    }

    public final boolean Ca() {
        return true;
    }
}
