package com.tencent.mm.plugin.appbrand.jsapi.n;

import android.content.Context;
import android.net.Uri;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.jsapi.n.c.b;
import com.tencent.mm.plugin.appbrand.jsapi.n.c.c;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.q.f;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.a.n;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.MMFalseProgressBar;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.o;
import org.json.JSONObject;

public final class a extends FrameLayout implements c {
    p jcr;
    private b juD;
    public MMWebView juE;
    private MMFalseProgressBar juF;
    private final b juG;
    private String juH = "";
    private boolean juI = true;
    boolean juJ = false;
    private o juK = new 2(this);
    private com.tencent.xweb.x5.a.a.a.a.b juL = new 3(this);
    private String mAppId;

    public a(Context context, e eVar, p pVar) {
        super(context);
        this.mAppId = eVar.mAppId;
        this.juD = new b();
        this.juD.a(pVar);
        this.jcr = pVar;
        this.juE = com.tencent.mm.plugin.webview.ui.tools.widget.c.a.tKa.cn(context);
        this.juE.getSettings().cIw();
        this.juE.getSettings().setJavaScriptEnabled(true);
        this.juE.getSettings().setMediaPlaybackRequiresUserGesture(false);
        this.juE.getSettings().cIy();
        this.juE.getSettings().setUserAgentString(s.aL(getContext(), this.juE.getSettings().getUserAgentString()) + " miniProgram");
        this.juE.getView().setHorizontalScrollBarEnabled(false);
        this.juE.getView().setVerticalScrollBarEnabled(false);
        this.juE.getSettings().setBuiltInZoomControls(true);
        this.juE.getSettings().setUseWideViewPort(true);
        this.juE.getSettings().setLoadWithOverviewMode(true);
        this.juE.getSettings().cIr();
        this.juE.getSettings().cIq();
        this.juE.getSettings().setGeolocationEnabled(true);
        this.juE.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        this.juE.getSettings().cIu();
        this.juE.getSettings().setAppCachePath(getContext().getDir("webviewcache", 0).getAbsolutePath());
        this.juE.getSettings().cIt();
        this.juE.getSettings().cIv();
        this.juE.getSettings().setDatabasePath(com.tencent.mm.loader.stub.a.gZJ + "databases/");
        this.juE.zvH = pVar.jDT;
        this.juE.cyW();
        this.juE.setWebViewCallbackClient(this.juK);
        if (this.juE.isX5Kernel) {
            this.juE.setWebViewClientExtension(this.juL);
        }
        addView(this.juE, new LayoutParams(-1, -1));
        this.juF = new MMFalseProgressBar(context);
        this.juF.setProgressDrawable(com.tencent.mm.bv.a.b(context, f.itl));
        addView(this.juF, new LayoutParams(-1, com.tencent.mm.bv.a.fromDPToPix(context, 3)));
        this.juG = ((com.tencent.mm.plugin.appbrand.jsapi.n.c.a) g.h(com.tencent.mm.plugin.appbrand.jsapi.n.c.a.class)).a(this);
        this.jcr.a(new 1(this));
        ahC().jIX = true;
    }

    public final String getAppId() {
        return this.mAppId;
    }

    public final MMWebView ahy() {
        return this.juE;
    }

    public final void runOnUiThread(Runnable runnable) {
        post(runnable);
    }

    public final void t(JSONObject jSONObject) {
        this.juD.mData = jSONObject.toString();
        this.juD.afs();
    }

    public final void sQ(String str) {
        this.jcr.rS(str);
    }

    public final void ahz() {
        ahB();
        this.juF.start();
    }

    public final void sR(String str) {
        ahB();
        this.juF.finish();
        if (!(this.juI || this.juJ)) {
            n ahC = ahC();
            p pVar = this.jcr;
            String str2 = this.juH;
            ahC.jIc = (String) ahC.jIV.peekFirst();
            ahC.jId = 2;
            ahC.jIe = str;
            ahC.jIV.push(str2);
            ahC.k(pVar);
        }
        this.juI = false;
        this.juJ = false;
        this.juH = str;
        if (!bh.ov(str)) {
            if (!bh.ov(Uri.parse(str).getHost())) {
                this.jcr.tJ(getContext().getString(j.eWX, new Object[]{r0}));
                return;
            }
        }
        this.jcr.tJ("");
    }

    public final void ahA() {
        this.jcr.irP.iqC.aiS();
    }

    private void ahB() {
        this.juE.evaluateJavascript("window.__wxjs_environment = \"miniprogram\";", null);
    }

    final n ahC() {
        return this.jcr.irP.iqC.jDm.jHq;
    }

    public final String[] ahD() {
        p pVar = this.jcr;
        e eVar = pVar.irP;
        AppBrandStatObject appBrandStatObject = eVar.iqH;
        h e = h.e(eVar);
        a ajb = pVar.ajb();
        String[] strArr = new String[19];
        strArr[0] = appBrandStatObject.scene;
        strArr[1] = appBrandStatObject.fnp;
        strArr[2] = eVar.mAppId;
        strArr[3] = eVar.iqx.iOI.iGL;
        strArr[4] = e.irG;
        strArr[5] = (eVar.iqx.iOI.iGK + 1);
        strArr[6] = appBrandStatObject.jHc;
        strArr[7] = pVar.getURL();
        strArr[8] = ajb == null ? "" : ajb.juE.getUrl();
        strArr[9] = com.tencent.mm.plugin.appbrand.report.a.ce(pVar.mContext);
        strArr[10] = "";
        strArr[11] = "";
        strArr[12] = "";
        strArr[13] = "";
        strArr[14] = "";
        strArr[15] = "";
        strArr[16] = appBrandStatObject.fIs;
        strArr[17] = appBrandStatObject.fIt;
        strArr[18] = (eVar.iqw.fnv + 1000);
        return strArr;
    }
}
