package com.tencent.mm.plugin.game.gamewebview.e;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.webkit.ValueCallback;
import com.tencent.mm.compatible.loader.c;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.game.gamewebview.c.a;
import com.tencent.mm.plugin.game.gamewebview.model.g;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.j;
import com.tencent.xweb.o;
import com.tencent.xweb.p;
import java.lang.Thread.State;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONObject;

public final class b extends MMWebView {
    private boolean iTU;
    private Context mContext;
    private d mWh;
    public com.tencent.xweb.x5.a.a.a.a.b naA;
    private c naB;
    private boolean naC;
    private b naD = new b(this, (byte) 0);
    private c naE = new c(this, (byte) 0);
    private a naF = new a(this, (byte) 0);
    private LinkedList<String> naG = new LinkedList();
    private com.tencent.xweb.x5.a.a.a.a.b naH = new 3(this);
    private g naw = new g();
    private p nax;
    private j nay;
    private o naz;

    static /* synthetic */ void d(b bVar) {
        Iterator it = bVar.naG.iterator();
        while (it.hasNext()) {
            bVar.evaluateJavascript((String) it.next(), null);
        }
        bVar.naG.clear();
    }

    public b(Context context, d dVar) {
        boolean z;
        boolean booleanExtra;
        boolean booleanExtra2;
        super(context);
        this.mContext = context;
        this.mWh = dVar;
        this.naB = new c(this.mWh);
        MMWebView.ge(this.mContext);
        this.gGO = true;
        if (getX5WebViewExtension() != null) {
            z = true;
        } else {
            z = false;
        }
        this.isX5Kernel = z;
        x.i("MicroMsg.GameWebView", "isX5Kernel = " + this.isX5Kernel);
        if (!(this.isX5Kernel || com.tencent.mm.compatible.util.d.fM(19))) {
            try {
                x.d("MicroMsg.GameWebView", "tryInterruptAwaitingWebCoreThread, mSysWebView = %s", new Object[]{new c(this, "mSysWebView", null).get()});
                x.d("MicroMsg.GameWebView", "tryInterruptAwaitingWebCoreThread, mWebViewClassic = %s", new Object[]{new c(r0, "mProvider", null).get()});
                x.d("MicroMsg.GameWebView", "tryInterruptAwaitingWebCoreThread, mWebViewCore = %s", new Object[]{new c(r0, "mWebViewCore", null).get()});
                x.d("MicroMsg.GameWebView", "tryInterruptAwaitingWebCoreThread, sWebCoreHandler = %s", new Object[]{new c(r0, "sWebCoreHandler", null).get()});
                x.d("MicroMsg.GameWebView", "tryInterruptAwaitingWebCoreThread, mLooper = %s", new Object[]{new c(r0, "mLooper", null).get()});
                Object obj = new c(obj, "mThread", null).get();
                x.d("MicroMsg.GameWebView", "tryInterruptAwaitingWebCoreThread, mThread = %s", new Object[]{obj});
                if (obj instanceof Thread) {
                    Thread thread = (Thread) obj;
                    x.i("MicroMsg.GameWebView", "tryInterruptAwaitingWebCoreThread, webCoreThread.getState = %s", new Object[]{thread.getState()});
                    if (thread.getState() == State.WAITING) {
                        thread.interrupt();
                    }
                }
            } catch (Exception e) {
                x.e("MicroMsg.GameWebView", "tryInterruptAwaitingWebCoreThread, exception = %s", new Object[]{e});
            }
        }
        if (this.mContext instanceof Activity) {
            booleanExtra = ((Activity) this.mContext).getIntent().getBooleanExtra("usePlugin", true);
            booleanExtra2 = ((Activity) this.mContext).getIntent().getBooleanExtra("zoom", true);
            z = ((Activity) this.mContext).getIntent().getBooleanExtra("zoom", true);
        } else {
            z = true;
            booleanExtra2 = true;
            booleanExtra = true;
        }
        getSettings().cIw();
        getSettings().setJavaScriptEnabled(z);
        getSettings().setPluginsEnabled(booleanExtra);
        getSettings().setBuiltInZoomControls(booleanExtra2);
        getSettings().setMediaPlaybackRequiresUserGesture(true);
        getSettings().cIy();
        getSettings().setUserAgentString(s.aL(getContext(), getSettings().getUserAgentString()));
        getSettings().setUseWideViewPort(true);
        getSettings().setLoadWithOverviewMode(true);
        getSettings().cIr();
        getSettings().cIq();
        getSettings().setGeolocationEnabled(true);
        getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        getSettings().cIy();
        getSettings().cIu();
        getSettings().setAppCachePath(this.mContext.getDir("webviewcache", 0).getAbsolutePath());
        getSettings().cIt();
        getSettings().cIv();
        getSettings().setDatabasePath(e.gZJ + "databases/");
        com.tencent.xweb.b.cIj().cIk();
        com.tencent.xweb.b.cIj().b(this);
        getView().setHorizontalScrollBarEnabled(false);
        getView().setVerticalScrollBarEnabled(false);
        WindowManager windowManager = (WindowManager) ac.getContext().getSystemService("window");
        try {
            Field declaredField = WebView.class.getDeclaredField("mWebViewCore").getType().getDeclaredField("mBrowserFrame").getType().getDeclaredField("sConfigCallback");
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(null);
            if (obj2 != null) {
                declaredField = declaredField.getType().getDeclaredField("mWindowManager");
                declaredField.setAccessible(true);
                declaredField.set(obj2, windowManager);
            }
        } catch (Exception e2) {
        }
        super.setWebChromeClient(this.naF);
        super.setWebViewClient(this.naE);
        if (this.isX5Kernel) {
            super.setWebViewCallbackClient(this.naD);
            super.setWebViewClientExtension(this.naH);
        }
        x.i("MicroMsg.GameWebView", "Is the current broswer kernel X5, " + this.isX5Kernel);
        setBackgroundColor(-1);
        setLayoutParams(new LayoutParams(-1, -1));
        requestFocus(130);
        String X = com.tencent.mm.plugin.game.gamewebview.a.d.X(this.mContext, getSettings().getUserAgentString());
        x.i("MicroMsg.GameWebView", "UserAgent = " + X);
        getSettings().setUserAgentString(X);
        a.mXW = X;
        cyV();
        if (getX5WebViewExtension() != null) {
            com.tencent.mm.pluginsdk.ui.tools.j.pY(7);
            com.tencent.mm.plugin.report.service.g.pQN.a(64, 64, 1, 0, 1, 1, false);
            return;
        }
        com.tencent.mm.plugin.report.service.g.pQN.a(64, 0, 1, false);
    }

    public final void destroy() {
        if (com.tencent.xweb.c.iO(ac.getContext()) != null) {
            x.i("MicroMsg.GameWebView", "now force sync the cookie between ram and db");
            com.tencent.xweb.c.sync();
        }
        if (VERSION.SDK_INT >= 11) {
            removeJavascriptInterface("MicroMsg");
            removeJavascriptInterface("JsApi");
        }
        try {
            super.setWebChromeClient(null);
            super.setWebChromeClient(null);
            super.setOnTouchListener(null);
            super.setOnLongClickListener(null);
            setVisibility(8);
            removeAllViews();
            clearView();
            super.destroy();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.GameWebView", e, "", new Object[0]);
        }
    }

    public final void setWebViewClient(p pVar) {
        this.nax = pVar;
    }

    public final void setWebChromeClient(j jVar) {
        this.nay = jVar;
    }

    public final void setWebViewCallbackClient(o oVar) {
        this.naz = oVar;
    }

    public final void fA(boolean z) {
        String convertStreamToString;
        try {
            convertStreamToString = bh.convertStreamToString(getContext().getAssets().open("game_jsapi/jsbridge.js"));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.GameWebView", e, "", new Object[0]);
            convertStreamToString = null;
        }
        if (convertStreamToString == null) {
            x.e("MicroMsg.GameWebView", "injectJavaScript fail, jsContent is null");
            com.tencent.mm.plugin.report.service.g.pQN.a(609, 4, 1, false);
            return;
        }
        evaluateJavascript("javascript:" + convertStreamToString, new 1(this));
        x.i("MicroMsg.GameWebView", "injectJavaScript done");
        com.tencent.mm.plugin.report.service.g.pQN.a(609, 1, 1, false);
        if (z) {
            cJ("sys:init", "");
        }
    }

    public final void cJ(String str, String str2) {
        if (bh.ov(str2)) {
            str2 = "{}";
        }
        x.d("MicroMsg.GameWebView", "dispatch, event: %s, data size: %d", new Object[]{str, Integer.valueOf(str2.length())});
        Object[] objArr = new Object[3];
        objArr[0] = str;
        objArr[1] = str2;
        Map hashMap = new HashMap();
        hashMap.put("nativeTime", Long.valueOf(System.currentTimeMillis()));
        objArr[2] = new JSONObject(hashMap).toString();
        String format = String.format("typeof WeixinJSBridge !== 'undefined' && WeixinJSBridge.subscribeHandler(\"%s\", %s, undefined, %s)", objArr);
        if (this.iTU) {
            evaluateJavascript(format, null);
            return;
        }
        x.d("MicroMsg.GameWebView", "not page finish, add js to queue, %s", new Object[]{format});
        this.naG.add(format);
    }

    @SuppressLint({"DefaultLocale"})
    public final void E(int i, String str) {
        if (bh.ov(str)) {
            str = "{}";
        }
        x.d("MicroMsg.GameWebView", "callback, callbackId: %d, data size: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(str.length())});
        evaluateJavascript(String.format("typeof WeixinJSBridge !== 'undefined' && WeixinJSBridge.invokeCallbackHandler(%d, %s)", new Object[]{Integer.valueOf(i), str}), null);
    }

    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        super.evaluateJavascript(str, valueCallback);
    }
}
