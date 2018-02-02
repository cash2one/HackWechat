package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.content.Intent;
import com.tencent.mm.ae.b;
import com.tencent.mm.bm.d;
import com.tencent.mm.ipcinvoker.wx_extension.b$a;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.bgd;
import com.tencent.mm.protocal.c.bge;
import com.tencent.mm.protocal.c.bij;
import com.tencent.mm.protocal.c.bik;
import com.tencent.mm.protocal.c.bsi;
import com.tencent.mm.protocal.c.bsj;
import com.tencent.mm.protocal.c.ec;
import com.tencent.mm.protocal.c.ed;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import org.json.JSONObject;

class AppBrandIDCardUI$1 implements a {
    final /* synthetic */ AppBrandIDCardUI jNQ;

    AppBrandIDCardUI$1(AppBrandIDCardUI appBrandIDCardUI) {
        this.jNQ = appBrandIDCardUI;
    }

    public final void akX() {
        b.a aVar = new b.a();
        aVar.hmj = new bij();
        aVar.hmk = new bik();
        aVar.uri = "/cgi-bin/mmbiz-bin/userdata/showauthorizeuserid";
        aVar.hmi = 1774;
        aVar.hml = 0;
        aVar.hmm = 0;
        b JZ = aVar.JZ();
        bij com_tencent_mm_protocal_c_bij = (bij) JZ.hmg.hmo;
        com_tencent_mm_protocal_c_bij.fFm = AppBrandIDCardUI.a(this.jNQ);
        com_tencent_mm_protocal_c_bij.wKL = AppBrandIDCardUI.b(this.jNQ);
        com.tencent.mm.ipcinvoker.wx_extension.b.a(JZ, new b$a(this) {
            final /* synthetic */ AppBrandIDCardUI$1 jNR;

            {
                this.jNR = r1;
            }

            public final void a(int i, int i2, String str, b bVar) {
                if (AppBrandIDCardUI.c(this.jNR.jNQ) != null && AppBrandIDCardUI.c(this.jNR.jNQ).isShowing()) {
                    AppBrandIDCardUI.c(this.jNR.jNQ).dismiss();
                }
                Intent intent;
                if (i == 0 && i2 == 0 && bVar.hmh.hmo != null) {
                    bik com_tencent_mm_protocal_c_bik = (bik) bVar.hmh.hmo;
                    if (com_tencent_mm_protocal_c_bik.wKN == null) {
                        x.e("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.auth_base_response is err");
                        intent = new Intent();
                        intent.putExtra("intent_err_code", 40000);
                        intent.putExtra("intent_err_msg", "network err");
                        this.jNR.jNQ.setResult(1, intent);
                        this.jNR.jNQ.finish();
                        return;
                    }
                    x.e("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.auth_base_response.err_code is %d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bik.wKN.fxK)});
                    x.i("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.show_status:%d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bik.wLO)});
                    switch (com_tencent_mm_protocal_c_bik.wLO) {
                        case 0:
                            if (com_tencent_mm_protocal_c_bik.wKN.fxK != 0) {
                                x.e("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.auth_base_response is not ok");
                                intent = new Intent();
                                intent.putExtra("intent_err_code", com_tencent_mm_protocal_c_bik.wKN.fxK);
                                intent.putExtra("intent_err_msg", com_tencent_mm_protocal_c_bik.wKN.fxL);
                                this.jNR.jNQ.setResult(1, intent);
                                this.jNR.jNQ.finish();
                                return;
                            }
                            AppBrandIDCardUI.a(this.jNR.jNQ, com_tencent_mm_protocal_c_bik);
                            AppBrandIDCardUI.d(this.jNR.jNQ);
                            return;
                        case 1:
                            x.i("MicroMsg.AppBrandIDCardUI", "showAlert errCode:%d, errMsg:%s", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bik.wKN.fxK), com_tencent_mm_protocal_c_bik.wKN.fxL});
                            AppBrandIDCardUI$1 appBrandIDCardUI$1 = this.jNR;
                            h.a(appBrandIDCardUI$1.jNQ, false, com_tencent_mm_protocal_c_bik.wLP.desc, com_tencent_mm_protocal_c_bik.wLP.title, appBrandIDCardUI$1.jNQ.getString(j.izz), "", new 2(appBrandIDCardUI$1, com_tencent_mm_protocal_c_bik.wKN.fxK, com_tencent_mm_protocal_c_bik.wKN.fxL), new 3(appBrandIDCardUI$1));
                            return;
                        default:
                            x.e("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.show_status error");
                            return;
                    }
                }
                x.e("MicroMsg.AppBrandIDCardUI", "getIDCardInfo cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, bVar.hmh.hmo});
                intent = new Intent();
                intent.putExtra("intent_err_code", 40000);
                intent.putExtra("intent_err_msg", "network err");
                this.jNR.jNQ.setResult(1, intent);
                this.jNR.jNQ.finish();
            }
        });
    }

    public final void onSwipeBack() {
        this.jNQ.onSwipeBack();
    }

    public final void back() {
        AppBrandIDCardUI.e(this.jNQ);
    }

    public final void ur(String str) {
        x.i("MicroMsg.AppBrandIDCardUI", "protocalUrl click");
        uu(str);
    }

    public final void us(String str) {
        x.i("MicroMsg.AppBrandIDCardUI", "urlJump click");
        uu(str);
    }

    public final void ut(String str) {
        x.i("MicroMsg.AppBrandIDCardUI", "url2Jump click");
        uu(str);
    }

    private void uu(String str) {
        if (bh.ov(str)) {
            x.e("MicroMsg.AppBrandIDCardUI", "url is null");
            return;
        }
        x.v("MicroMsg.AppBrandIDCardUI", "goToWebview url: " + str);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("forceHideShare", true);
        d.b(this.jNQ, "webview", ".ui.tools.WebViewUI", intent);
    }

    public final void akY() {
        x.i("MicroMsg.AppBrandIDCardUI", "verifyPassword");
        g.pQN.h(14943, new Object[]{AppBrandIDCardUI.a(this.jNQ), Integer.valueOf(2), AppBrandIDCardUI.f(this.jNQ).frP});
        if (AppBrandIDCardUI.f(this.jNQ).wLW == null) {
            x.e("MicroMsg.AppBrandIDCardUI", "showAuthorizeUserIDResp.verify_pay_req is null");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appId", AppBrandIDCardUI.f(this.jNQ).wLW.fFm);
            jSONObject.put("timeStamp", AppBrandIDCardUI.f(this.jNQ).wLW.fqD);
            jSONObject.put("nonceStr", AppBrandIDCardUI.f(this.jNQ).wLW.wsG);
            jSONObject.put("package", AppBrandIDCardUI.f(this.jNQ).wLW.wTU);
            jSONObject.put("signType", AppBrandIDCardUI.f(this.jNQ).wLW.kUd);
            jSONObject.put("paySign", AppBrandIDCardUI.f(this.jNQ).wLW.wsp);
            g.pQN.h(14943, new Object[]{AppBrandIDCardUI.a(this.jNQ), Integer.valueOf(3), AppBrandIDCardUI.f(this.jNQ).frP});
            com.tencent.mm.plugin.appbrand.jsapi.g.a.joW.a(this.jNQ, jSONObject, new 4(this));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AppBrandIDCardUI", e, "", new Object[0]);
        }
    }

    public final void akZ() {
        g.pQN.h(14943, new Object[]{AppBrandIDCardUI.a(this.jNQ), Integer.valueOf(6), AppBrandIDCardUI.f(this.jNQ).frP});
    }

    public final void a(ec ecVar) {
        g.pQN.h(14943, new Object[]{AppBrandIDCardUI.a(this.jNQ), Integer.valueOf(7), AppBrandIDCardUI.f(this.jNQ).frP});
        x.i("MicroMsg.AppBrandIDCardUI", "sendSms");
        b.a aVar = new b.a();
        aVar.hmj = new bgd();
        aVar.hmk = new bge();
        aVar.uri = "/cgi-bin/mmbiz-bin/userdata/sendsms";
        aVar.hmi = 1762;
        aVar.hml = 0;
        aVar.hmm = 0;
        b JZ = aVar.JZ();
        bgd com_tencent_mm_protocal_c_bgd = (bgd) JZ.hmg.hmo;
        com_tencent_mm_protocal_c_bgd.fFm = AppBrandIDCardUI.a(this.jNQ);
        com_tencent_mm_protocal_c_bgd.wKL = AppBrandIDCardUI.b(this.jNQ);
        com_tencent_mm_protocal_c_bgd.wKM = AppBrandIDCardUI.h(this.jNQ);
        com_tencent_mm_protocal_c_bgd.vJt = ecVar.vJt;
        com_tencent_mm_protocal_c_bgd.oZz = ecVar.oZz;
        com_tencent_mm_protocal_c_bgd.frP = AppBrandIDCardUI.f(this.jNQ).frP;
        com.tencent.mm.ipcinvoker.wx_extension.b.a(JZ, new 5(this));
    }

    public final void a(String str, ec ecVar) {
        if (bh.ov(str)) {
            x.e("MicroMsg.AppBrandIDCardUI", "verifyCode is null, err, return");
        } else if (bh.ov(ecVar.vJt)) {
            x.e("MicroMsg.AppBrandIDCardUI", "phoneId is null, err, return");
        } else {
            x.i("MicroMsg.AppBrandIDCardUI", "verifySms");
            b.a aVar = new b.a();
            aVar.hmj = new bsi();
            aVar.hmk = new bsj();
            aVar.uri = "/cgi-bin/mmbiz-bin/userdata/verifysmscode";
            aVar.hmi = 1721;
            aVar.hml = 0;
            aVar.hmm = 0;
            b JZ = aVar.JZ();
            bsi com_tencent_mm_protocal_c_bsi = (bsi) JZ.hmg.hmo;
            com_tencent_mm_protocal_c_bsi.fFm = AppBrandIDCardUI.a(this.jNQ);
            com_tencent_mm_protocal_c_bsi.wKL = AppBrandIDCardUI.b(this.jNQ);
            com_tencent_mm_protocal_c_bsi.wKM = AppBrandIDCardUI.h(this.jNQ);
            com_tencent_mm_protocal_c_bsi.vJt = ecVar.vJt;
            com_tencent_mm_protocal_c_bsi.frP = AppBrandIDCardUI.f(this.jNQ).frP;
            com_tencent_mm_protocal_c_bsi.sPk = str;
            com_tencent_mm_protocal_c_bsi.wKO = AppBrandIDCardUI.i(this.jNQ);
            com_tencent_mm_protocal_c_bsi.oZz = ecVar.oZz;
            com.tencent.mm.ipcinvoker.wx_extension.b.a(JZ, new 6(this));
        }
    }

    public final bik ala() {
        return AppBrandIDCardUI.f(this.jNQ);
    }

    public final ed alb() {
        return AppBrandIDCardUI.j(this.jNQ);
    }
}
