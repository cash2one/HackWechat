package com.tencent.mm.plugin.webview.ui.tools;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.g.a.ts;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.webview.model.aj;
import com.tencent.mm.plugin.webview.model.aj$e;
import com.tencent.mm.plugin.webview.model.aj.c;
import com.tencent.mm.plugin.webview.model.aj.f;
import com.tencent.mm.plugin.webview.model.aj.l;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.68;
import com.tencent.mm.pluginsdk.d;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.WebView;
import com.tencent.xweb.h;
import com.tencent.xweb.m;
import com.tencent.xweb.p;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import junit.framework.Assert;

protected class WebViewUI$i extends p {
    final /* synthetic */ WebViewUI tAv;

    public WebViewUI$i(WebViewUI webViewUI) {
        this.tAv = webViewUI;
    }

    public boolean OZ(String str) {
        x.i("MicroMsg.WebViewUI", "edw mmShouldOverride");
        if (str.startsWith("weixinping://iframe") || str.startsWith("weixinpreinject://iframe")) {
            return true;
        }
        if (WebViewUI.m(this.tAv, str)) {
            x.i("MicroMsg.WebViewUI", "custom scheme url deal success, url = " + str);
            return true;
        }
        WebViewUI.n(this.tAv, str);
        return false;
    }

    public final boolean b(WebView webView, String str) {
        x.i("MicroMsg.WebViewUI", "edw opt, shouldOverride url = " + str);
        if (!WebViewUI.g(this.tAv, str)) {
            x.f("MicroMsg.WebViewUI", "shouldOverrideUrlLoading, canLoadUrl fail, url = " + str);
            WebViewUI.V(this.tAv);
            return true;
        } else if (s.eE(str, "about:blank")) {
            x.e("MicroMsg.WebViewUI", "shouldOverride, url is about:blank");
            return true;
        } else {
            try {
                if (str.startsWith("weixin://jump/") || str.startsWith("weixin://scanqrcode/")) {
                    this.tAv.Pn(str);
                    return true;
                } else if (str.startsWith("weixin://dl/business") && d.j(Uri.parse(str))) {
                    String host = Uri.parse(this.tAv.fIG).getHost();
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.addCategory("android.intent.category.BROWSABLE");
                    intent.setData(Uri.parse(str + "&domain=" + host));
                    r1 = this.tAv.getIntent().getIntExtra("pay_channel", -1);
                    if (r1 != -1) {
                        x.i("MicroMsg.WebViewUI", "%s do deeplink, bypass pay channel: %s", new Object[]{str, Integer.valueOf(r1)});
                        intent.putExtra("pay_channel", r1);
                    }
                    intent.putExtra("translate_link_scene", 13);
                    this.tAv.startActivity(intent);
                    return true;
                } else if (str.startsWith("weixinpreinject://iframe") && WebViewUI.N(this.tAv) != null) {
                    x.i("MicroMsg.WebViewUI", "preInjectJsBridge,accept preinject_Iframe and continue preinjectjsbridge");
                    if (!str.equals(WebViewUI.ax(this.tAv))) {
                        WebViewUI.o(this.tAv, "");
                        return true;
                    } else if (!this.tAv.BU(str)) {
                        return true;
                    } else {
                        if (str.startsWith("weixin://")) {
                            x.e("MicroMsg.WebViewUI", "shouldOverrideUrlLoading, can not deal with this weixin scheme, stop directly, url = %s", new Object[]{str});
                            return true;
                        }
                        r1 = this.tAv.tzd.BI(str);
                        if (r1 == 0) {
                        }
                        x.i("MicroMsg.WebViewUI", "edw shouldOverride, should not continue, reason = " + r1);
                        if (this.tAv.Pl(str)) {
                            this.tAv.ptK.stopLoading();
                            this.tAv.ptK.post(new 1(this, str));
                        } else {
                            this.tAv.ptK.stopLoading();
                        }
                        if (str.equals(WebViewUI.D(this.tAv))) {
                            x.w("MicroMsg.WebViewUI", "shouldOverride, url equals lastGetA8KeyUrl, not trigger geta8key");
                            return OZ(str);
                        }
                        WebViewUI.a(this.tAv, str, true, r1);
                        return true;
                    }
                } else if (str.startsWith("weixin://dl/login/common_view") || str.startsWith("weixin://dl/login/phone_view")) {
                    if ((this.tAv.fIG.startsWith("https://support.weixin.qq.com/security") || str.startsWith("https://support.wechat.com/security")) && WebViewUI.aw(this.tAv)) {
                        d.aT(this.tAv.mController.xIM, str);
                        this.tAv.finish();
                        return true;
                    }
                    if (!str.equals(WebViewUI.ax(this.tAv))) {
                        WebViewUI.o(this.tAv, "");
                        return true;
                    } else if (!this.tAv.BU(str)) {
                        return true;
                    } else {
                        if (str.startsWith("weixin://")) {
                            x.e("MicroMsg.WebViewUI", "shouldOverrideUrlLoading, can not deal with this weixin scheme, stop directly, url = %s", new Object[]{str});
                            return true;
                        }
                        r1 = this.tAv.tzd.BI(str);
                        if (r1 == 0 && r1 != 2 && (r1 != 8 || WebViewUI.ay(this.tAv))) {
                            return OZ(str);
                        }
                        x.i("MicroMsg.WebViewUI", "edw shouldOverride, should not continue, reason = " + r1);
                        if (this.tAv.Pl(str)) {
                            this.tAv.ptK.stopLoading();
                            this.tAv.ptK.post(new 1(this, str));
                        } else {
                            this.tAv.ptK.stopLoading();
                        }
                        if (str.equals(WebViewUI.D(this.tAv))) {
                            x.w("MicroMsg.WebViewUI", "shouldOverride, url equals lastGetA8KeyUrl, not trigger geta8key");
                            return OZ(str);
                        }
                        WebViewUI.a(this.tAv, str, true, r1);
                        return true;
                    }
                } else if (str.startsWith("weixin://webview/initReady/")) {
                    return true;
                } else {
                    if (str.startsWith("weixin://webview/preInjectJSBridge/")) {
                        return true;
                    }
                    if (!str.equals(WebViewUI.ax(this.tAv))) {
                        WebViewUI.o(this.tAv, "");
                        return true;
                    } else if (!this.tAv.BU(str)) {
                        return true;
                    } else {
                        if (str.startsWith("weixin://")) {
                            r1 = this.tAv.tzd.BI(str);
                            if (r1 == 0) {
                            }
                            x.i("MicroMsg.WebViewUI", "edw shouldOverride, should not continue, reason = " + r1);
                            if (this.tAv.Pl(str)) {
                                this.tAv.ptK.stopLoading();
                            } else {
                                this.tAv.ptK.stopLoading();
                                this.tAv.ptK.post(new 1(this, str));
                            }
                            if (str.equals(WebViewUI.D(this.tAv))) {
                                WebViewUI.a(this.tAv, str, true, r1);
                                return true;
                            }
                            x.w("MicroMsg.WebViewUI", "shouldOverride, url equals lastGetA8KeyUrl, not trigger geta8key");
                            return OZ(str);
                        }
                        x.e("MicroMsg.WebViewUI", "shouldOverrideUrlLoading, can not deal with this weixin scheme, stop directly, url = %s", new Object[]{str});
                        return true;
                    }
                }
            } catch (Exception e) {
                x.w("MicroMsg.WebViewUI", "shouldOverride, jumpToActivity, ex = " + e.getMessage());
                if (this.tAv.juR == null) {
                    x.e("MicroMsg.WebViewUI", "wvPerm is null, maybe has detach");
                    return true;
                }
            }
        }
    }

    public final void a(WebView webView, String str, boolean z) {
        x.i("MicroMsg.WebViewUI", "doUpdateVisitedHistory, url = %s, isReload = %b", new Object[]{str, Boolean.valueOf(z)});
        super.a(webView, str, z);
        if (s.eE(str, "about:blank")) {
            x.e("MicroMsg.WebViewUI", "doUpdateVisitedHistory, url is about:blank");
            return;
        }
        String url = webView.getUrl();
        if (WebViewUI.ay(this.tAv)) {
            this.tAv.j(url, false, -1);
        }
        if (!(this.tAv.juR == null || this.tAv.juR.has(url))) {
            x.i("MicroMsg.WebViewUI", "doUpdateVisitedHistory start geta8key, url = %s", new Object[]{url});
            this.tAv.j(url, false, -1);
            this.tAv.J(true, false);
            WebViewUI.f(this.tAv, true);
        }
        WebViewUI.o(this.tAv).bSu();
        WebViewUI.n(this.tAv, str);
    }

    public void b(WebView webView, String str, Bitmap bitmap) {
        super.b(webView, str, bitmap);
        x.i("MicroMsg.WebViewUI", "edw onPageStarted opt, url = " + str);
        g.pQN.a(155, 0, 1, false);
        if (this.tAv.bSN()) {
            if (TextUtils.isEmpty(str) || !str.equals(webView.getUrl())) {
                x.v("MicroMsg.WebViewUI", "onPageStarted call when preload url %s, webview.url %s", new Object[]{str, webView.getUrl()});
            } else {
                x.i("MicroMsg.WebViewUI", "onPageStarted call with same url when preload");
                this.tAv.bSO();
                if (WebViewUI.N(this.tAv) != null) {
                    WebViewUI.N(this.tAv).tEd = false;
                }
                this.tAv.bTd();
            }
        }
        if (b.ceK() && "http://www.dktest-mmcrash.com/".equals(str)) {
            Assert.assertTrue("test errlog in tools " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), false);
        }
        WebViewUI.p(this.tAv, WebViewUI.F(this.tAv));
        this.tAv.f(str, bh.Wo(), 1);
        this.tAv.trN.bRa().ttj = WebViewUI.j(this.tAv);
        WebViewUI.n(this.tAv, str);
        g gVar = g.tyi;
        x.v("MicroMsg.WebViewReportUtil", "onPageStarted url %s, currUrl %s, traceid %s", new Object[]{str, gVar.tyj, gVar.rea});
        String str2 = gVar.tyj;
        gVar.tyj = str;
        if (!bh.ov(gVar.rea)) {
            gVar.d(1, str2, 0);
        }
        x.d("MicroMsg.WebViewUI", "onPageStarted preUrl : %s, curUrl : %s.", new Object[]{WebViewUI.j(this.tAv), WebViewUI.F(this.tAv)});
        if (WebViewUI.g(this.tAv, str)) {
            WebViewUI.o(this.tAv).bSu();
            WebViewUI.o(this.tAv).Pk(str);
            if (this.tAv.BU(str)) {
                WebViewUI.o(this.tAv, str);
                return;
            }
            WebViewUI.N(this.tAv).bUg();
            this.tAv.setProgressBarIndeterminateVisibility(false);
            if (this.tAv.Pl(str)) {
                WebViewUI.g(this.tAv, true);
                this.tAv.tyo.finish();
                this.tAv.ptK.evaluateJavascript("javascript:(function(){ window.isWeixinCached=true; })()", null);
                if (this.tAv.tlx != null) {
                    this.tAv.tlx.o((String) WebViewUI.az(this.tAv).get(str), (Map) WebViewUI.aA(this.tAv).get(str));
                }
            } else {
                WebViewUI.g(this.tAv, false);
                if (!WebViewUI.d(this.tAv)) {
                    this.tAv.tyo.start();
                }
            }
            WebViewUI.q(this.tAv, str);
            if (WebViewUI.x.tBD.equals(this.tAv.j(str, false, -1))) {
                WebViewUI.u(this.tAv).OI(str);
            }
            this.tAv.J(true, false);
            WebViewUI.f(this.tAv, false);
            l bQY = this.tAv.trN.bQY();
            int J = WebViewUI.J(this.tAv);
            String i = WebViewUI.i(this.tAv);
            bQY.fMy = J;
            bQY.ttb = i;
            if (bh.ov(str)) {
                x.e("MicroMsg.WebviewReporter", "WebviewOpenUrl.startLoadUrl failed, url is null");
            } else if (!bQY.ttn.containsKey(str)) {
                bQY.ttn.put(str, Long.valueOf(bh.Wp()));
            }
            WebViewUI.aB(this.tAv);
            return;
        }
        x.f("MicroMsg.WebViewUI", "onPageStarted, canLoadUrl fail, url = " + str);
        WebViewUI.V(this.tAv);
    }

    public void a(WebView webView, String str) {
        super.a(webView, str);
        WebViewUI.aC(this.tAv);
        if (!WebViewUI.aD(this.tAv)) {
            WebViewUI.aE(this.tAv);
            this.tAv.trN.bRc().tsU = true;
        }
        x.i("MicroMsg.WebViewUI", "edw onPageFinished opt, url = %s", new Object[]{str});
        c bRh = this.tAv.trN.bRh();
        if (bRh.moK && !bRh.tsW) {
            try {
                Uri parse = Uri.parse(str);
                if (str.startsWith("http")) {
                    String host = parse.getHost();
                    if (host != null && host.equalsIgnoreCase("v.html5.qq.com")) {
                        g.pQN.a(283, 0, 1, true);
                        bRh.tsW = true;
                        x.i("MicroMsg.WebviewReporter.DomainReporter", "onPageFinished, domain visit reported, url = %s", new Object[]{str});
                    }
                } else {
                    x.i("MicroMsg.WebviewReporter.DomainReporter", "onPageFinished, url not startswith http");
                }
            } catch (Exception e) {
                x.e("MicroMsg.WebviewReporter.DomainReporter", "onPageFinished, parse url fail, url = %s", new Object[]{str});
            }
        }
        g gVar = g.tyi;
        x.v("MicroMsg.WebViewReportUtil", "onPageFinished traceid %s", new Object[]{gVar.rea});
        if (!bh.ov(gVar.rea)) {
            gVar.pY(2);
        }
        if (this.tAv.ptK == null) {
            x.w("MicroMsg.WebViewUI", "onPageFinished, webview has been destroyed, skip");
            return;
        }
        WebViewUI.u(this.tAv).OI(str);
        String title = this.tAv.ptK.getTitle();
        x.i("MicroMsg.WebViewUI", "onPageFinished, old title = %s, new title = %s, fixedTitle = %b, showTitle = %b, loadUrl = %s", new Object[]{this.tAv.mController.getMMTitle(), title, Boolean.valueOf(this.tAv.tyn), Boolean.valueOf(WebViewUI.r(this.tAv)), WebViewUI.F(this.tAv)});
        if (this.tAv.ptK.isX5Kernel && !bh.ov(title) && title.length() > 0 && !title.equals(this.tAv.mController.getMMTitle()) && !title.startsWith("http") && ((WebViewUI.F(this.tAv) == null || !WebViewUI.F(this.tAv).equals(title)) && !this.tAv.tyn && WebViewUI.r(this.tAv))) {
            x.d("MicroMsg.WebViewUI", "onPageFinished, update old title while goback");
            this.tAv.setMMTitle(title);
        }
        WebViewUI.o(this.tAv).Pk(this.tAv.aPk());
        boolean booleanExtra = this.tAv.getIntent().getBooleanExtra("shouldForceViewPort", false);
        x.d("MicroMsg.WebViewUI", "hy: shouldForceViewPort: " + booleanExtra);
        if (booleanExtra) {
            webView.evaluateJavascript(this.tAv.getIntent().getStringExtra("view_port_code"), null);
        }
        WebViewUI.aF(this.tAv);
        if (WebViewUI.g(this.tAv, str)) {
            this.tAv.setProgressBarIndeterminateVisibility(false);
            this.tAv.tyo.finish();
            WebViewUI.o(this.tAv, "");
            if (str.equals("file:///android_asset/jsapi/wxjs.js")) {
                x.i("MicroMsg.WebViewUI", "onPageFinished, js is finished loaded");
                return;
            }
            x.i("MicroMsg.WebViewUI", "onPageFinished, inject url" + WebViewUI.aG(this.tAv));
            WebViewUI.N(this.tAv).bUh();
            if (!(this.tAv.juR == null || this.tAv.juR.Pj(str) == null)) {
                WebViewUI.a(this.tAv, this.tAv.juR.Pj(str).gn(34), this.tAv.juR.Pj(str).gn(75));
            }
            WebViewUI.a(this.tAv, WebViewUI.bTh());
            l bQY = this.tAv.trN.bQY();
            if (bh.ov(str)) {
                x.e("MicroMsg.WebviewReporter", "WebviewOpenUrl.stopLoadUrl failed, url is null");
            } else if (bQY.ttn.containsKey(str)) {
                bQY.ttn.put(str, Long.valueOf(bh.Wp() - ((Long) bQY.ttn.get(str)).longValue()));
            }
            aj$e bQZ = this.tAv.trN.bQZ();
            if (bh.ov(str)) {
                x.e("MicroMsg.WebviewReporter", "WebViewRenderReporter.onPageFinish failed, url is null");
            } else if (bQZ.tsZ.containsKey(str)) {
                bQZ.tsZ.put(str, Long.valueOf(bh.Wp() - ((Long) bQZ.tsZ.get(str)).longValue()));
            }
            f bRb = this.tAv.trN.bRb();
            com.tencent.mm.plugin.webview.stub.d dVar = this.tAv.juQ;
            if (!(dVar == null || bRb.kGh)) {
                bRb.kGh = true;
                int bQU = aj.bQU();
                long Wp = bh.Wp() - bRb.startTime;
                if (Wp >= 0 && Wp <= 180000) {
                    String str2 = bRb.ttb;
                    Object[] objArr = new Object[11];
                    objArr[0] = Integer.valueOf(4);
                    objArr[1] = Long.valueOf(Wp);
                    objArr[2] = Integer.valueOf(bQU);
                    objArr[3] = bRb.url == null ? bRb.url : bRb.url.replace(",", "!");
                    objArr[4] = Integer.valueOf(0);
                    objArr[5] = Integer.valueOf(0);
                    objArr[6] = Integer.valueOf(0);
                    objArr[7] = Integer.valueOf(aj.bl());
                    objArr[8] = Integer.valueOf(aj.JM());
                    objArr[9] = Integer.valueOf(bRb.fMy);
                    objArr[10] = bRb.ttb;
                    aj.a(dVar, str2, objArr);
                    x.i("MicroMsg.WebviewReporter", "WebViewTotalTimeReporter.report url : %s, cost time : %d, netType : %d, %d, %d, getA8KeyScene:%d, prePublishid:%s", new Object[]{bRb.url, Long.valueOf(Wp), Integer.valueOf(bQU), Integer.valueOf(aj.bl()), Integer.valueOf(aj.JM()), Integer.valueOf(bRb.fMy), bRb.ttb});
                }
            }
            if (!WebViewUI.e(this.tAv).containsKey(str)) {
                WebViewUI.e(this.tAv).put(str, Boolean.valueOf(this.tAv.cmU()));
            }
            this.tAv.kt(((Boolean) WebViewUI.e(this.tAv).get(str)).booleanValue());
            Boolean bool = (Boolean) WebViewUI.s(this.tAv).get(str);
            if (bool == null || !bool.booleanValue()) {
                this.tAv.showOptionMenu(0, true);
            } else {
                this.tAv.showOptionMenu(0, false);
            }
            if (WebViewUI.aq(this.tAv) && bh.ov(WebViewUI.ar(this.tAv))) {
                WebViewUI.r(this.tAv, WebViewUI.F(this.tAv));
            }
            WebViewUI.b(this.tAv, bh.Wo());
            a.xef.m(new ts());
            return;
        }
        x.f("MicroMsg.WebViewUI", "onPageFinished, canLoadUrl fail, url = " + str);
        WebViewUI.V(this.tAv);
    }

    @TargetApi(8)
    public final void a(WebView webView, h hVar, SslError sslError) {
        String F = webView.getUrl() == null ? WebViewUI.F(this.tAv) : webView.getUrl();
        g.pQN.a(155, 1, 1, false);
        g.pQN.a(155, 30, 1, false);
        if (WebViewUI.aH(this.tAv) == null) {
            WebViewUI.a(this.tAv, new b(this.tAv, this.tAv.ptK));
        }
        WebViewUI.aH(this.tAv).a(F, hVar, sslError);
    }

    public void a(WebView webView, int i, String str, String str2) {
        boolean isConnected = an.isConnected(this.tAv);
        x.e("MicroMsg.WebViewUI", "edw onReceivedError, failingUrl = %s, errorCode = %d, desc = %s, isNetworkConnected = %b", new Object[]{str2, Integer.valueOf(i), str, Boolean.valueOf(isConnected)});
        g.pQN.a(155, 1, 1, false);
        g.pQN.a(155, (long) a.Ax(i), 1, false);
        super.a(webView, i, str, str2);
        g.tyi.AG(i);
        if (WebViewUI.aI(this.tAv)) {
            this.tAv.finish();
        }
    }

    public final void f(WebView webView, String str) {
        x.i("MicroMsg.WebViewUI", "edw onLoadResource opt, url = " + str);
        if (WebViewUI.g(this.tAv, str)) {
            aj$e bQZ = this.tAv.trN.bQZ();
            if (bh.ov(str)) {
                x.e("MicroMsg.WebviewReporter", "WebViewRenderReporter.onLoadResource failed, url is null");
            } else if (!(bh.ov(bQZ.jIW) || str.equals(bQZ.jIW) || !bQZ.tta)) {
                if (bQZ.tsY.containsKey(bQZ.jIW)) {
                    bQZ.tsY.put(bQZ.jIW, Long.valueOf(bh.Wp() - ((Long) bQZ.tsY.get(bQZ.jIW)).longValue()));
                }
                bQZ.tta = false;
            }
            super.f(webView, str);
            return;
        }
        x.f("MicroMsg.WebViewUI", "onLoadResource, canLoadUrl fail, url = " + str);
        super.f(webView, str);
        WebViewUI.V(this.tAv);
    }

    public m c(WebView webView, String str) {
        x.i("MicroMsg.WebViewUI", "shouldInterceptRequest, url = %s", new Object[]{str});
        if (Pt(str)) {
            return null;
        }
        return Pu(str);
    }

    public m a(WebView webView, com.tencent.xweb.l lVar) {
        if (lVar == null || lVar.getUrl() == null || bh.ov(lVar.getUrl().toString())) {
            return super.a(webView, lVar);
        }
        x.i("MicroMsg.WebViewUI", "shouldInterceptRequest, url = %s, method = %s, isForMainFrame = %b", new Object[]{lVar.getUrl(), lVar.getMethod(), Boolean.valueOf(lVar.isForMainFrame())});
        if (Pt(lVar.getUrl().toString())) {
            return null;
        }
        return Pu(lVar.getUrl().toString());
    }

    public m a(WebView webView, com.tencent.xweb.l lVar, Bundle bundle) {
        if (lVar == null || lVar.getUrl() == null || bh.ov(lVar.getUrl().toString())) {
            return super.a(webView, lVar);
        }
        x.i("MicroMsg.WebViewUI", "shouldInterceptRequest, url = %s, method = %s, isForMainFrame = %b", new Object[]{lVar.getUrl(), lVar.getMethod(), Boolean.valueOf(lVar.isForMainFrame())});
        if (Pt(lVar.getUrl().toString())) {
            return null;
        }
        if (WebView.getCurWebType() != WebView.c.WV_KIND_X5 || WebView.getTbsCoreVersion(this.tAv) > 36541) {
            try {
                int i = bundle.getInt("resourceType");
                if ((i == 1 || i == 7) && !WebViewUI.aJ(this.tAv)) {
                    x.i("MicroMsg.WebViewUI", "get resoutce type is iframe : %d, start geta8key", new Object[]{Integer.valueOf(i)});
                    WebViewUI.a(this.tAv, lVar.getUrl().toString(), false, 5);
                }
            } catch (Exception e) {
                x.w("MicroMsg.WebViewUI", "get resource type failed Exception ; %s", new Object[]{e.getMessage()});
            } catch (Throwable th) {
                x.w("MicroMsg.WebViewUI", "get resource type failed Throwable ; %s", new Object[]{th.getMessage()});
            }
        }
        return Pu(lVar.getUrl().toString());
    }

    private boolean Pt(String str) {
        if (WebViewUI.g(this.tAv, str)) {
            return false;
        }
        x.f("MicroMsg.WebViewUI", "shouldOverrideUrlLoading, canLoadUrl fail, url = " + str);
        WebViewUI.V(this.tAv);
        return true;
    }

    private m Pu(String str) {
        String aPk = this.tAv.aPk();
        m a = WebViewUI.n(this.tAv).a(str, !WebViewUI.aK(this.tAv), this.tAv.juQ);
        if (a == null) {
            return null;
        }
        if (!str.equals(aPk) && !WebViewUI.a(this.tAv, aPk, str)) {
            return a;
        }
        WebViewUI.a(this.tAv).post(new Runnable(this) {
            final /* synthetic */ WebViewUI$i tBw;

            {
                this.tBw = r1;
            }

            public final void run() {
                if (this.tBw.tAv.ptK != null) {
                    this.tBw.tAv.ptK.evaluateJavascript("javascript:(function(){ window.isWeixinCached=true; })()", null);
                }
                WebViewUI webViewUI = this.tBw.tAv;
                Runnable 68 = new 68(webViewUI);
                if (Thread.currentThread().getId() == webViewUI.handler.getLooper().getThread().getId()) {
                    68.run();
                } else {
                    webViewUI.handler.post(68);
                }
            }
        });
        return a;
    }
}
