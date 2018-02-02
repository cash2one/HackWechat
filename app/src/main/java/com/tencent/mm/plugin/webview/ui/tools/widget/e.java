package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import com.tencent.mm.plugin.webview.a;
import com.tencent.mm.plugin.webview.model.aa;
import com.tencent.mm.plugin.webview.model.ag;
import com.tencent.mm.plugin.webview.modelcache.o;
import com.tencent.mm.plugin.webview.stub.WebViewStubService;
import com.tencent.mm.plugin.webview.stub.c;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.b;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.f;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.f$a;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bc;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.xweb.WebView;
import com.tencent.xweb.h;
import com.tencent.xweb.l;
import com.tencent.xweb.m;
import com.tencent.xweb.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class e extends p {
    protected Activity iQz;
    public MMWebView juE;
    af mHandler;
    private Set<String> mZb;
    public String mZd;
    public String mZe;
    private String mZi;
    public boolean mZk;
    public d tFi;
    com.tencent.mm.plugin.webview.ui.tools.jsapi.d tFj;
    private f tFm;
    public com.tencent.mm.plugin.webview.ui.tools.e tGR;
    protected b tKc;
    public a tKd;
    private ag tKe;
    public String tKf;
    private String tKg;
    private List<b> tKh;
    private final Map<String, String> tKi;
    public boolean tKj;
    public boolean tKk;
    private boolean tKl;
    public Map<String, String> tKm;
    public c tKn;
    public g tKo;
    private final Map<String, Map<String, String>> tzG;

    static /* synthetic */ boolean a(e eVar, c cVar) {
        int type = cVar.getType();
        int bRK = cVar.bRK();
        int bRL = cVar.bRL();
        cVar.KM();
        Bundle data = cVar.getData();
        if (data == null) {
            data = new Bundle();
        }
        if (eVar.juE != null) {
            if (!eVar.iQz.isFinishing() && eVar.tGR != null) {
                x.i("MicroMsg.MMWebViewClient", "get hash code = %d, self hash code = %d", Integer.valueOf(data.getInt("scene_end_listener_hash_code")), Integer.valueOf(eVar.juE.hashCode()));
                x.i("MicroMsg.MMWebViewClient", "edw onSceneEnd, type = " + type + ", errCode = " + bRL + ", errType = " + bRK);
                if (data.getInt("scene_end_listener_hash_code") == eVar.juE.hashCode()) {
                    switch (type) {
                        case 233:
                            b bVar = eVar.tKc;
                            bVar.tBz--;
                            if (bVar.tBz <= 0) {
                                bVar.tKp.AI(233);
                            }
                            JsapiPermissionWrapper jsapiPermissionWrapper = new JsapiPermissionWrapper(data.getByteArray("geta8key_result_jsapi_perm_control_bytes"));
                            GeneralControlWrapper generalControlWrapper = new GeneralControlWrapper(data.getInt("geta8key_result_general_ctrl_b1"));
                            int i = data.getInt("geta8key_result_reason");
                            x.i("MicroMsg.MMWebViewClient", "edw geta8key onSceneEnd, req reason = " + i);
                            switch (i) {
                                case 0:
                                case 2:
                                    if ((bRK == 0 && bRL == 0) || (bRK == 4 && bRL == -2005)) {
                                        eVar.a(data.getString("geta8key_result_req_url"), data.getString("geta8key_result_full_url"), jsapiPermissionWrapper, generalControlWrapper);
                                        eVar.ab(data);
                                        break;
                                    }
                                case 1:
                                case 5:
                                    if (bRK != 0 || bRL != 0) {
                                        if (bRK != 4 || bRL != -2005) {
                                            if (bRK != 0 && bRL == -3300) {
                                                eVar.tKl = true;
                                                break;
                                            }
                                        }
                                        eVar.juE.stopLoading();
                                        eVar.a(data.getString("geta8key_result_req_url"), data.getString("geta8key_result_full_url"), jsapiPermissionWrapper, generalControlWrapper);
                                        eVar.ab(data);
                                        break;
                                    }
                                    String string = data.getString("geta8key_result_req_url");
                                    eVar.tGR.b(string, jsapiPermissionWrapper, generalControlWrapper);
                                    eVar.mZb.remove(string);
                                    break;
                                    break;
                                default:
                                    break;
                            }
                            break;
                        default:
                            break;
                    }
                }
                x.e("MicroMsg.MMWebViewClient", "hash code not equal");
            } else {
                x.w("MicroMsg.MMWebViewClient", "onSceneEnd, isFinishing, do nothing");
            }
        } else {
            x.w("MicroMsg.MMWebViewClient", "onSceneEnd, viewWV is null, do nothing");
        }
        return true;
    }

    public e() {
        this.tFm = null;
        this.tFj = null;
        this.mZk = false;
        this.mZi = "";
        this.mZb = new HashSet();
        this.tKc = new b(this);
        this.tKd = new a(null);
        this.tKe = new ag();
        this.tKf = null;
        this.mZd = null;
        this.tKg = null;
        this.tKh = new ArrayList();
        this.tKi = new HashMap();
        this.tzG = new ConcurrentHashMap();
        this.tKj = false;
        this.tKk = false;
        this.tKl = false;
        this.tKn = new c(this);
        this.tKo = new 4(this);
    }

    public e(MMWebView mMWebView) {
        this(mMWebView, false);
    }

    public e(MMWebView mMWebView, boolean z) {
        this.tFm = null;
        this.tFj = null;
        this.mZk = false;
        this.mZi = "";
        this.mZb = new HashSet();
        this.tKc = new b(this);
        this.tKd = new a(null);
        this.tKe = new ag();
        this.tKf = null;
        this.mZd = null;
        this.tKg = null;
        this.tKh = new ArrayList();
        this.tKi = new HashMap();
        this.tzG = new ConcurrentHashMap();
        this.tKj = false;
        this.tKk = false;
        this.tKl = false;
        this.tKn = new c(this);
        this.tKo = new 4(this);
        this.iQz = (Activity) mMWebView.getContext();
        this.juE = mMWebView;
        this.mHandler = new af();
        this.tGR = new com.tencent.mm.plugin.webview.ui.tools.e(this.iQz, mMWebView);
        this.mZk = z;
    }

    public void Pz(String str) {
    }

    public void a(d dVar, com.tencent.mm.plugin.webview.ui.tools.e eVar) {
    }

    public g ahF() {
        return null;
    }

    public int ahG() {
        return 0;
    }

    public void a(com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar) {
    }

    public void a(f fVar) {
    }

    public void e(Bundle bundle, String str) {
    }

    public boolean Pl(String str) {
        if (this.juE != null) {
            return o.a(str, this.tFi, this.juE.hashCode());
        }
        return false;
    }

    public boolean HV(String str) {
        return false;
    }

    public void a(WebView webView, String str, Bitmap bitmap) {
    }

    public void e(WebView webView, String str) {
    }

    public void bUe() {
    }

    public final boolean PM(String str) {
        for (b bVar : this.tKh) {
            if (bVar.BT(str)) {
                x.i("MicroMsg.MMWebViewClient", "url handled, ret = " + bVar.BU(str) + ", url = " + str);
                return true;
            }
        }
        return HV(str);
    }

    public final boolean b(WebView webView, final String str) {
        x.i("MicroMsg.MMWebViewClient", "edw opt, shouldOverride url = " + str);
        if (this.tFi == null) {
            x.e("MicroMsg.MMWebViewClient", "Service not ready yet, make sure url loading happens after service connected");
            return true;
        } else if (!aa.Oj(str)) {
            x.f("MicroMsg.MMWebViewClient", "shouldOverrideUrlLoading, URL load failed, url = " + str);
            Pz(str);
            return true;
        } else if (str.equals(this.tKg)) {
            this.tKg = "";
            return true;
        } else {
            boolean PM = PM(str);
            if (!PM && str.startsWith("weixin://")) {
                x.e("MicroMsg.MMWebViewClient", "shouldOverrideUrlLoading, can not deal with this weixin scheme, stop directly, url = %s", str);
                return true;
            } else if (PM) {
                return true;
            } else {
                int BI = this.tKd.BI(str);
                if ((BI != 0 && BI != 2) || this.mZk) {
                    return false;
                }
                x.i("MicroMsg.MMWebViewClient", "edw shouldOverride, should not continue, reason = " + BI);
                if (Pl(str)) {
                    this.juE.stopLoading();
                    this.juE.post(new Runnable(this) {
                        final /* synthetic */ e tKp;

                        public final void run() {
                            this.tKp.BO(str);
                        }
                    });
                } else {
                    this.juE.stopLoading();
                }
                if (str.equals(this.mZi)) {
                    x.w("MicroMsg.MMWebViewClient", "shouldOverride, url equals lastGetA8KeyUrl, not trigger geta8key");
                    return false;
                }
                aR(str, true);
                return true;
            }
        }
    }

    public final void a(WebView webView, String str, boolean z) {
        x.i("MicroMsg.MMWebViewClient", "doUpdateVisitedHistory, url = %s, isReload = %b", str, Boolean.valueOf(z));
        super.a(webView, str, z);
        String url = webView.getUrl();
        if (this.mZk) {
            aR(url, false);
        }
        if (this.tGR != null && !this.tGR.has(url)) {
            x.i("MicroMsg.MMWebViewClient", "doUpdateVisitedHistory start geta8key, url = %s", url);
            aR(url, false);
        }
    }

    public final void b(WebView webView, String str, Bitmap bitmap) {
        x.d("MicroMsg.MMWebViewClient", "onPageStarted url = %s", str);
        if (Py(str)) {
            if (!this.tKj) {
                webView.stopLoading();
            }
        } else if (!aa.Oj(str)) {
            x.f("MicroMsg.MMWebViewClient", "onPageStarted, canLoadUrl fail, url = " + str);
            Pz(str);
        } else if (PM(str)) {
            this.tKg = str;
        } else {
            this.mZd = str;
            super.b(webView, str, bitmap);
            this.tFm.bUg();
            if (Pl(str)) {
                this.juE.evaluateJavascript("javascript:(function(){ window.isWeixinCached=true; })()", null);
                if (this.tFj != null) {
                    this.tFj.o((String) this.tKi.get(str), (Map) this.tzG.get(str));
                }
            }
            aR(str, false);
            a(webView, str, bitmap);
        }
    }

    public final void a(WebView webView, String str) {
        x.d("MicroMsg.MMWebViewClient", "onPageFinished url = %s", str);
        if (this.tFi != null) {
            super.a(webView, str);
            if (aa.Oj(str)) {
                this.tKg = "";
                if (str.equals("file:///android_asset/jsapi/wxjs.js")) {
                    x.i("MicroMsg.MMWebViewClient", "onPageFinished, js is finished loaded");
                    e(webView, str);
                    return;
                }
                this.tFm.bUh();
                e(webView, str);
                return;
            }
            x.f("MicroMsg.MMWebViewClient", "onPageFinished, canLoadUrl fail, url = " + str);
            Pz(str);
        }
    }

    public final void a(WebView webView, h hVar, SslError sslError) {
        super.a(webView, hVar, sslError);
    }

    public final void a(WebView webView, int i, String str, String str2) {
        super.a(webView, i, str, str2);
    }

    public void f(WebView webView, String str) {
        x.i("MicroMsg.MMWebViewClient", "edw onLoadResource opt, url = " + str);
        super.f(webView, str);
    }

    public m c(WebView webView, String str) {
        x.i("MicroMsg.MMWebViewClient", "shouldInterceptRequest, url = %s", str);
        return this.tKe.a(str, true, this.tFi);
    }

    public m a(WebView webView, l lVar) {
        if (lVar == null || lVar.getUrl() == null || bh.ov(lVar.getUrl().toString())) {
            return super.a(webView, lVar);
        }
        x.i("MicroMsg.MMWebViewClient", "shouldInterceptRequest, url = %s, method = %s, isForMainFrame = %b", lVar.getUrl(), lVar.getMethod(), Boolean.valueOf(lVar.isForMainFrame()));
        return this.tKe.a(lVar.getUrl().toString(), false, this.tFi);
    }

    public m a(WebView webView, l lVar, Bundle bundle) {
        if (lVar == null || lVar.getUrl() == null || bh.ov(lVar.getUrl().toString())) {
            return super.a(webView, lVar, bundle);
        }
        x.i("MicroMsg.MMWebViewClient", "shouldInterceptRequest, url = %s, method = %s, isForMainFrame = %b", lVar.getUrl(), lVar.getMethod(), Boolean.valueOf(lVar.isForMainFrame()));
        if (WebView.getCurWebType() != WebView.c.AqC || MMWebView.getTbsCoreVersion(this.iQz) > 36541) {
            try {
                int i = bundle.getInt("resourceType");
                if (i == 1 || i == 7) {
                    x.i("MicroMsg.MMWebViewClient", "get resoutce type is iframe : %d, start geta8key", Integer.valueOf(i));
                    f(lVar.getUrl().toString(), false, 5);
                }
            } catch (Exception e) {
                x.w("MicroMsg.MMWebViewClient", "get resource type failed Exception ; %s", e.getMessage());
            } catch (Throwable th) {
                x.w("MicroMsg.MMWebViewClient", "get resource type failed Throwable ; %s", th.getMessage());
            }
        }
        return this.tKe.a(lVar.getUrl().toString(), true, this.tFi);
    }

    public final void cleanup() {
        if (this.tKn != null) {
            try {
                this.iQz.unbindService(this.tKn);
            } catch (Exception e) {
                x.e("MicroMsg.MMWebViewClient", e.getMessage());
            }
        }
        if (this.tFj != null) {
            this.tFj.detach();
        }
        if (this.tFm != null) {
            this.tFm.detach();
        }
        AI(233);
        try {
            this.tFi.Au(this.juE.hashCode());
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.MMWebViewClient", e2, "", new Object[0]);
        }
        bUe();
    }

    public final void bUP() {
        int i;
        Map hashMap = new HashMap();
        hashMap.put("init_url", this.tKf);
        hashMap.put("webview_type", "1");
        hashMap.put("init_font_size", "1");
        this.tFj = new com.tencent.mm.plugin.webview.ui.tools.jsapi.d(this.juE, this.tGR, hashMap, this.tFi, this.juE.hashCode());
        this.tFj.tGP = null;
        this.juE.addJavascriptInterface(this.tFj, "__wx");
        this.tKh.add(this.tFj);
        this.tKh.add(new com.tencent.mm.plugin.webview.ui.tools.jsapi.e(this.juE, this.tFj));
        this.tFm = new f(this.juE, this.tFi, this.tFj, new f$a(this) {
            final /* synthetic */ e tKp;

            {
                this.tKp = r1;
            }

            public final void bTk() {
                this.tKp.a(this.tKp.tFj);
            }
        }, false);
        a(this.tFm);
        try {
            i = bh.getInt(this.tFi.OR("WebviewDisableDigestVerify"), 0);
        } catch (Exception e) {
            x.w("MicroMsg.MMWebViewClient", "getting js digest verification config fails, ex = " + e.getMessage());
            i = 0;
        }
        x.i("MicroMsg.MMWebViewClient", "js digest verification config = %d", Integer.valueOf(i));
        if (i == 0 && this.iQz.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).getBoolean("wvsha1", true)) {
            this.tFj.bUm();
            this.tKe.tsD = this.tFj.tGT;
        }
    }

    public void bUf() {
        try {
            this.tFi.a(this.tKf, true, null);
        } catch (Exception e) {
            x.w("MicroMsg.MMWebViewClient", "postBinded, jumpToActivity, ex = " + e.getMessage());
        }
        if (!PM(this.tKf)) {
            Uri parse = Uri.parse(this.tKf);
            if (parse.getScheme() == null) {
                this.tKf += "http://";
                parse = Uri.parse(this.tKf);
            }
            if (parse.getScheme().startsWith("http")) {
                x.i("MicroMsg.MMWebViewClient", "uri scheme not startwith http, scheme = " + parse.getScheme());
                this.tKd = new a(this.tKj ? "" : this.tKf);
                this.tKj = false;
                if (this.mZk || this.tGR.has(this.tKf)) {
                    this.juE.loadUrl(this.tKf);
                } else {
                    aR(this.tKf, false);
                }
            } else if (aa.Oj(this.tKf)) {
                this.juE.loadUrl(this.tKf);
            } else {
                Pz(this.tKf);
            }
        }
    }

    private void bSx() {
        x.i("MicroMsg.MMWebViewClient", "tryBindService");
        this.iQz.bindService(new Intent(this.iQz, WebViewStubService.class), this.tKn, 1);
    }

    public boolean Py(String str) {
        if (this.tFi != null) {
            return false;
        }
        this.tKf = str;
        bSx();
        return true;
    }

    public void BO(String str) {
        Map hashMap = new HashMap(2);
        hashMap.put("Pragma", "no-cache");
        hashMap.put("Cache-Control", "no-cache");
        this.juE.loadUrl(str, hashMap);
    }

    public final void aR(String str, boolean z) {
        f(str, z, ahG());
    }

    private void f(String str, boolean z, int i) {
        boolean z2 = false;
        if (!this.iQz.isFinishing()) {
            if (this.tGR == null) {
                x.e("MicroMsg.MMWebViewClient", "startGetA8Key fail, after onDestroy");
            } else if (this.mZk) {
                x.i("MicroMsg.MMWebViewClient", "edw startGetA8Key, nevergeta8key");
                this.tGR.b(str, null, null);
            } else {
                boolean z3;
                if (this.tFi != null && this.mZb.contains(str) && Pl(str)) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if ((this.tGR.has(str) || r0) && !z) {
                    x.i("MicroMsg.MMWebViewClient", "edw startGetA8Key no need, wvPerm already has value, url = " + str);
                    return;
                }
                String str2 = "";
                int BI = this.tKd.BI(str);
                x.i("MicroMsg.MMWebViewClient", "edw startGetA8Key, url = " + str + ", scene = " + i + ", username = " + str2 + ", reason = " + BI + ", force = " + z);
                x.i("MicroMsg.MMWebViewClient", "edw startGetA8Key, begin, set a default permission");
                this.mZb.add(str);
                this.tGR.b(str, null, null);
                this.tKk = true;
                b bVar = this.tKc;
                if (bVar.tBz == 0) {
                    e eVar = bVar.tKp;
                    try {
                        Bundle bundle = new Bundle();
                        bundle.putInt("scene_end_type", 233);
                        bundle.putInt("scene_end_listener_hash_code", eVar.juE.hashCode());
                        eVar.tFi.a(5, bundle, eVar.juE.hashCode());
                    } catch (Exception e) {
                        x.e("MicroMsg.MMWebViewClient", "addSceneEnd, ex = " + e.getMessage());
                    }
                }
                bVar.tBz++;
                Bundle bundle2 = new Bundle();
                bundle2.putString("geta8key_data_req_url", str);
                bundle2.putString("geta8key_data_username", str2);
                bundle2.putInt("geta8key_data_scene", i);
                bundle2.putInt("geta8key_data_reason", BI);
                if (this.juE.isX5Kernel) {
                    bundle2.putInt("geta8key_data_flag", 1);
                } else {
                    bundle2.putInt("geta8key_data_flag", z2);
                }
                bundle2.putString("geta8key_data_net_type", s.bQV());
                this.mZi = str;
                e(bundle2, str);
                try {
                    z2 = this.tFi.r(233, bundle2);
                } catch (Exception e2) {
                    x.w("MicroMsg.MMWebViewClient", "startGetA8Key, ex = " + e2.getMessage());
                }
                x.i("MicroMsg.MMWebViewClient", "startGetA8Key, doScene ret = " + z2);
            }
        }
    }

    private void AI(int i) {
        try {
            if (this.tFi != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("scene_end_type", 233);
                bundle.putInt("scene_end_listener_hash_code", this.juE.hashCode());
                this.tFi.a(6, bundle, this.juE.hashCode());
            }
        } catch (Exception e) {
            x.e("MicroMsg.MMWebViewClient", "removeSceneEnd, ex = " + e.getMessage());
        }
    }

    private void n(String str, Map<String, String> map) {
        String az = bh.az(aPk(), this.tKf);
        if (bh.ov(az)) {
            x.e("MicroMsg.MMWebViewClient", "after getA8Key, currentURL is null or nil, wtf");
            this.juE.loadUrl(str);
        } else if (this.tFj == null) {
            if (map.size() > 0) {
                this.juE.loadUrl(str, map);
            } else {
                this.juE.loadUrl(str);
            }
        } else if (!bh.ou(str).contains("#wechat_redirect")) {
            if (!eQ(az, str)) {
                String OC = com.tencent.mm.plugin.webview.modelcache.p.OC(az);
                String OC2 = com.tencent.mm.plugin.webview.modelcache.p.OC(str);
                Object obj = (bh.ov(OC2) || bh.ov(OC) || !OC2.equals(OC) || this.tFi == null || !Pl(az)) ? null : 1;
                if (obj == null) {
                    if (map.size() > 0) {
                        this.juE.loadUrl(str, map);
                        return;
                    } else {
                        this.juE.loadUrl(str);
                        return;
                    }
                }
            }
            this.tKi.put(az, str);
            this.tzG.put(az, map);
            this.tFj.o(str, map);
        } else if (map.size() > 0) {
            this.juE.loadUrl(str, map);
        } else {
            this.juE.loadUrl(str);
        }
    }

    private boolean eQ(String str, String str2) {
        if (bh.ov(str) || bh.ov(str2)) {
            return false;
        }
        if (a.tkS.matcher(str).matches() && a.tkS.matcher(str2).matches()) {
            String replaceFirst = str.replaceFirst("http://", "").replaceFirst("https://", "");
            int indexOf = replaceFirst.indexOf(35);
            if (indexOf > 0) {
                replaceFirst = replaceFirst.substring(0, indexOf);
            }
            if (str2.replaceFirst("http://", "").replaceFirst("https://", "").startsWith(replaceFirst) && this.tFi != null && Pl(str)) {
                return true;
            }
        }
        return false;
    }

    private boolean ab(Bundle bundle) {
        x.d("MicroMsg.MMWebViewClient", "[cpan] process a8 key:%d", Long.valueOf(System.currentTimeMillis()));
        int i = bundle.getInt("geta8key_result_action_code");
        String string = bundle.getString("geta8key_result_title");
        String string2 = bundle.getString("geta8key_result_full_url");
        String string3 = bundle.getString("geta8key_result_content");
        x.i("MicroMsg.MMWebViewClient", "processGetA8Key, actionCode = " + i + ", title = " + string + ", fullUrl = " + string2 + ", content = " + string3);
        String[] stringArray = bundle.getStringArray("geta8key_result_http_header_key_list");
        String[] stringArray2 = bundle.getStringArray("geta8key_result_http_header_value_list");
        Map hashMap = new HashMap();
        if (stringArray != null && stringArray2 != null && stringArray.length > 0 && stringArray2.length > 0 && stringArray.length == stringArray2.length) {
            for (int i2 = 0; i2 < stringArray.length; i2++) {
                hashMap.put(stringArray[i2], stringArray2[i2]);
            }
        }
        this.tKm = hashMap;
        switch (i) {
            case 1:
                x.i("MicroMsg.MMWebViewClient", "getA8key-text: " + string3);
                if (string3 == null || string3.length() == 0) {
                    x.e("MicroMsg.MMWebViewClient", "getA8key-text fail, invalid content");
                    return false;
                }
                this.juE.getSettings().setJavaScriptEnabled(false);
                this.juE.loadData(string3, "text/html", ProtocolPackage.ServerEncoding);
                return true;
            case 2:
            case 7:
                x.i("MicroMsg.MMWebViewClient", "getA8key-webview/no-notice: title = " + string + ", fullUrl = " + string2);
                if (string2 == null || string2.length() == 0) {
                    x.e("MicroMsg.MMWebViewClient", "getA8key-webview fail, invalid fullUrl");
                    return false;
                } else if (aa.Oj(string2)) {
                    n(string2, hashMap);
                    return true;
                } else {
                    x.f("MicroMsg.MMWebViewClient", "processGetA8Key qrcode, canLoadUrl fail, url = " + string2);
                    Pz(string2);
                    return true;
                }
            case 6:
                x.i("MicroMsg.MMWebViewClient", "getA8key-special_webview: fullUrl = " + string2);
                if (string2 == null || string2.length() == 0) {
                    x.e("MicroMsg.MMWebViewClient", "getA8key-special_webview fail, invalid fullUrl");
                    return false;
                } else if (aa.Oj(string2)) {
                    this.juE.loadUrl(string2);
                    return true;
                } else {
                    x.f("MicroMsg.MMWebViewClient", "processGetA8Key special, canLoadUrl fail, url = " + string2);
                    Pz(string2);
                    return true;
                }
            default:
                x.i("MicroMsg.MMWebViewClient", "qrcode-getA8key-not_catch: action code = " + i);
                return false;
        }
    }

    private void a(String str, String str2, JsapiPermissionWrapper jsapiPermissionWrapper, GeneralControlWrapper generalControlWrapper) {
        if (!bh.ov(str2)) {
            this.tGR.b(str2, jsapiPermissionWrapper, generalControlWrapper);
            this.mZb.remove(str2);
            this.tKk = false;
            this.mZe = str2;
        }
        if (eQ(str, str2)) {
            this.tGR.b(str, jsapiPermissionWrapper, generalControlWrapper);
            this.mZb.remove(str);
        } else if (this.tFi != null && !bh.ov(str) && Pl(str2)) {
            this.tGR.b(str, jsapiPermissionWrapper, generalControlWrapper);
            this.mZb.remove(str);
        }
    }

    String aPk() {
        if (!bh.ov(this.mZd)) {
            return this.mZd;
        }
        if (this.mHandler == null) {
            return null;
        }
        if (Thread.currentThread().getId() == this.mHandler.getLooper().getThread().getId()) {
            return this.juE == null ? "" : this.juE.getUrl();
        } else {
            return (String) new bc<String>(this, "") {
                final /* synthetic */ e tKp;

                protected final /* synthetic */ Object run() {
                    return this.tKp.juE == null ? "" : this.tKp.juE.getUrl();
                }
            }.b(this.mHandler);
        }
    }
}
