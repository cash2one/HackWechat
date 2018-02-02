package com.tencent.mm.plugin.appbrand.page;

import a.a;
import android.animation.Animator;
import android.content.Context;
import android.net.http.SslCertificate;
import android.net.http.SslError;
import android.os.Looper;
import android.util.Base64;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.tencent.mm.plugin.appbrand.appcache.ah;
import com.tencent.mm.plugin.appbrand.appcache.v;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.g.b;
import com.tencent.mm.plugin.appbrand.g.c;
import com.tencent.mm.plugin.appbrand.j.l;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.d;
import com.tencent.xweb.h;
import com.tencent.xweb.j;
import com.tencent.xweb.o;
import com.tencent.xweb.p;
import java.net.URL;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONObject;

public final class t extends MMWebView implements b {
    private LinkedList<Pair<String, ValueCallback<String>>> iQk;
    boolean iTU;
    private p iTV;
    public String iZW;
    e irP;
    public String jET;
    w jEU;
    v jEV;
    l jEW;
    public Animator jEX;
    private long jEY;
    long jEZ;
    c jEb;
    private long jFa;
    public boolean jFb;
    private boolean jFc;
    boolean jFd;
    public String jFe;
    long jFf;
    private String jFg;
    private String jFh;
    private j jFi;
    private o juK;
    private com.tencent.xweb.x5.a.a.a.a.b juL;
    String mAppId;

    static /* synthetic */ void a(t tVar, h hVar, SslError sslError) {
        if (tVar.jEW == null) {
            hVar.cancel();
            return;
        }
        int i;
        if (sslError.getPrimaryError() == 3) {
            SslCertificate certificate = sslError.getCertificate();
            x.d("MicroMsg.AppBrandWebView", "subjectDN: " + certificate.getIssuedTo().getDName());
            try {
                certificate.getClass().getDeclaredField("mX509Certificate").setAccessible(true);
                try {
                    tVar.jEW.checkServerTrusted(new X509Certificate[]{(X509Certificate) r3.get(certificate)}, "generic");
                    i = 1;
                } catch (Exception e) {
                    x.e("MicroMsg.AppBrandWebView", "Certificate check failed: " + e);
                    i = 0;
                }
            } catch (Exception e2) {
                x.e("MicroMsg.AppBrandWebView", "Certificate check failed: ", new Object[]{e2});
            }
            if (i == 0) {
                hVar.proceed();
            } else {
                hVar.cancel();
            }
        }
        i = 0;
        if (i == 0) {
            hVar.cancel();
        } else {
            hVar.proceed();
        }
    }

    public t(Context context) {
        super(context);
        this.iTU = false;
        this.jFb = false;
        this.jFc = false;
        this.jFd = true;
        this.jFg = null;
        this.jFh = null;
        this.iTV = new 6(this);
        this.jFi = new j(this) {
            final /* synthetic */ t jFj;

            {
                this.jFj = r1;
            }

            public final void onShowCustomView(View view, CustomViewCallback customViewCallback) {
                try {
                    if (this.jFj.jEb != null) {
                        this.jFj.jEb.r(view, 90);
                        this.jFj.jEb.jCM = customViewCallback;
                    }
                } catch (Exception e) {
                    x.e("MicroMsg.AppBrandWebView", "onShowCustomView error " + e.getMessage());
                }
            }

            public final void onHideCustomView() {
                try {
                    if (this.jFj.jEb != null) {
                        this.jFj.jEb.aiK();
                    }
                } catch (Exception e) {
                    x.e("MicroMsg.AppBrandWebView", "onHideCustomView error " + e.getMessage());
                }
            }
        };
        this.juK = new 8(this);
        this.juL = new 9(this);
        this.gGO = true;
        this.isX5Kernel = getX5WebViewExtension() != null;
        this.iQk = new LinkedList();
        this.jEY = System.currentTimeMillis();
        MMWebView.ge(getContext());
        getSettings().cIw();
        getSettings().setJavaScriptEnabled(true);
        getSettings().setMediaPlaybackRequiresUserGesture(false);
        getSettings().cIy();
        getSettings().setUserAgentString(s.aL(getContext(), getSettings().getUserAgentString()));
        this.jFe = getSettings().getUserAgentString();
        getView().setHorizontalScrollBarEnabled(false);
        getView().setVerticalScrollBarEnabled(false);
        setWebViewClient(this.iTV);
        setWebChromeClient(this.jFi);
        setWebViewCallbackClient(this.juK);
        if (this.isX5Kernel) {
            setWebViewClientExtension(this.juL);
            try {
                a.cB(getX5WebViewExtension()).n("setEnableAutoPageDiscarding", Boolean.valueOf(false));
                a.cB(getX5WebViewExtension()).n("setEnableAutoPageRestoration", Boolean.valueOf(false));
            } catch (Exception e) {
                x.e("MicroMsg.AppBrandWebView", "DisableAutoPageDiscarding error " + e);
            }
        }
        x.i("MicroMsg.AppBrandWebView", "Is the current broswer kernel X5, " + this.isX5Kernel);
        setBackgroundColor(-1);
        setLayoutParams(new LayoutParams(-1, -1));
        setOnLongClickListener(new 1(this));
        setDownloadListener(new 2(this));
    }

    public final void init() {
        loadUrl(ajq());
    }

    public final void tM(String str) {
        if (!bh.ov(str) && com.tencent.mm.sdk.a.b.ceK()) {
            evaluateJavascript("document.title=\"" + str + "\"", null);
        }
    }

    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (this.iTU) {
            Runnable 3 = new 3(this, str, valueCallback);
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                3.run();
                return;
            } else {
                ag.y(3);
                return;
            }
        }
        this.iQk.add(new Pair(str, valueCallback));
    }

    public final void a(URL url, String str, ValueCallback<String> valueCallback) {
        evaluateJavascript(str, valueCallback);
    }

    public final void a(d dVar) {
    }

    private void ajn() {
        Iterator it = this.iQk.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            super.evaluateJavascript((String) pair.first, (ValueCallback) pair.second);
        }
        this.iQk.clear();
    }

    public final <T extends c> T v(Class<T> cls) {
        return null;
    }

    public final void destroy() {
        super.destroy();
        if (this.jEX != null) {
            this.jEX.cancel();
            this.jEX = null;
        }
    }

    final void ajo() {
        JSONObject jSONObject = new JSONObject();
        if (this.irP != null) {
            a(jSONObject, "appType", Integer.valueOf(this.irP.iqw.fnv));
        } else if (this.jFb) {
            a(jSONObject, "preload", Boolean.valueOf(true));
        }
        a(jSONObject, "clientVersion", Integer.valueOf(com.tencent.mm.protocal.d.vAz));
        JSONObject jSONObject2 = new JSONObject();
        a(jSONObject2, "width", Float.valueOf(((float) getResources().getDisplayMetrics().widthPixels) / getResources().getDisplayMetrics().density));
        a(jSONObject2, "pixelRatio", Float.valueOf(getResources().getDisplayMetrics().density));
        evaluateJavascript(String.format("var __wxConfig = %s;\nvar __deviceInfo__ = %s\n", new Object[]{jSONObject.toString(), jSONObject2.toString()}), null);
        String str = "";
        if (!this.jFc) {
            this.jFc = true;
            str = str + com.tencent.mm.plugin.appbrand.p.c.uy("wxa_library/android.js") + v.pE("WAWebview.js");
        }
        if (this.irP != null) {
            StringBuilder append = new StringBuilder().append(str);
            str = "";
            if (this.irP.iqx.iOi && !this.irP.YA()) {
                str = v.pE("WAVConsole.js");
            }
            append = append.append(str);
            str = "";
            if (AppBrandPerformanceManager.tT(this.mAppId)) {
                str = v.pE("WAPerf.js");
            }
            append = append.append(str);
            str = "";
            if (this.irP.YA()) {
                str = ";" + v.pE("WARemoteDebug.js");
            }
            str = append.append(str).toString();
        }
        if (bh.ov(str)) {
            x.v("MicroMsg.AppBrandWebView", "execInitScript, js null");
        } else {
            g.pQN.a(370, 1, 1, false);
            com.tencent.mm.plugin.appbrand.q.h.a(this, str, new 4(this));
        }
        if (this.irP != null && this.mAppId != null) {
            this.irP.iqM.o(3, this.jFa - this.jEY);
            com.tencent.mm.plugin.appbrand.performance.a.a(this.mAppId, "Native", "WebViewInit+PageFrameLoad", this.jEY, this.jFa, "");
            if (this.iZW != null) {
                x.i("MicroMsg.AppBrandWebView", "Inject page on frame load finished");
                tN(this.iZW);
            }
            ajn();
        }
    }

    private static void a(JSONObject jSONObject, String str, Object obj) {
        try {
            jSONObject.put(str, obj);
        } catch (Exception e) {
            x.e("MicroMsg.AppBrandWebView", e.getMessage());
        }
    }

    private String ajp() {
        if (this.jFg == null) {
            this.jFg = "https://servicewechat.com/";
            if (this.jFb) {
                this.jFg += "preload/";
            } else {
                this.jFg += this.mAppId + "/" + this.irP.iqx.iOI.iGL + "/";
            }
        }
        return this.jFg;
    }

    private String ajq() {
        if (this.jFh == null) {
            this.jFh = ajp() + "page-frame.html";
        }
        return this.jFh;
    }

    final void tN(String str) {
        this.jEZ = System.currentTimeMillis();
        String a = ah.a(this.irP, str);
        if (bh.ov(a)) {
            x.e("MicroMsg.AppBrandWebView", "Cache content empty, abort inject");
            return;
        }
        String str2;
        String pt;
        if (this.irP.iqP.YV()) {
            str2 = "" + ";" + ah.a(this.irP, "/app-wxss.js");
            pt = this.irP.iqP.pt(this.iZW);
            pt = str2 + ";" + ah.a(this.irP, pt + (pt.endsWith("/") ? "" : "/") + "page-frame.js");
        } else {
            pt = this.jFb ? tO(ah.a(this.irP, "/page-frame.html")) : "";
        }
        int indexOf = a.indexOf("<style>");
        int indexOf2 = a.indexOf("</style>");
        str2 = (indexOf == -1 || indexOf2 == (-indexOf)) ? "" : a.substring(indexOf + 7, indexOf2);
        String encodeToString = Base64.encodeToString(str2.getBytes(), 2);
        indexOf = a.indexOf("<page>");
        int indexOf3 = a.indexOf("</page>");
        str2 = (indexOf == -1 || indexOf3 == (-indexOf)) ? "" : a.substring(indexOf + 6, indexOf3);
        str2 = Base64.encodeToString(str2.getBytes(), 2);
        a = tO(a);
        evaluateJavascript(String.format("var style = document.createElement('style');style.innerHTML = atob(\"%s\");document.head.appendChild(style);var page = document.createElement('page');page.innerHTML = atob(\"%s\");document.body.appendChild(page);%s;%s", new Object[]{encodeToString, str2, pt, a}), null);
    }

    private static String tO(String str) {
        String str2 = "";
        int i = 0;
        while (true) {
            int indexOf = str.indexOf("<script>", i);
            int indexOf2 = str.indexOf("</script>", i);
            if (indexOf == -1 || indexOf2 == -1 || indexOf2 <= indexOf) {
                return str2;
            }
            str2 = str2 + (i > 0 ? ";" : "") + str.substring(indexOf + 8, indexOf2);
            i = indexOf2 + 9;
        }
        return str2;
    }
}
