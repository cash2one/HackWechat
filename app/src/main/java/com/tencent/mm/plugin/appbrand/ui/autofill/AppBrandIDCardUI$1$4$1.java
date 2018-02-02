package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.content.Intent;
import android.widget.Toast;
import com.tencent.mm.ae.b;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI.1.4;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.bmi;
import com.tencent.mm.sdk.platformtools.x;

class AppBrandIDCardUI$1$4$1 implements a {
    final /* synthetic */ String jNS;
    final /* synthetic */ 4 jNT;

    AppBrandIDCardUI$1$4$1(4 4, String str) {
        this.jNT = 4;
        this.jNS = str;
    }

    public final void a(int i, int i2, String str, b bVar) {
        if (AppBrandIDCardUI.c(this.jNT.jNR.jNQ) != null && AppBrandIDCardUI.c(this.jNT.jNR.jNQ).isShowing()) {
            AppBrandIDCardUI.c(this.jNT.jNR.jNQ).dismiss();
        }
        if (i == 0 && i2 == 0 && bVar.hmh.hmo != null) {
            bmi com_tencent_mm_protocal_c_bmi = (bmi) bVar.hmh.hmo;
            if (com_tencent_mm_protocal_c_bmi.wKN == null) {
                x.e("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.auth_base_response is err");
                Toast.makeText(this.jNT.jNR.jNQ, this.jNT.jNR.jNQ.getString(j.izy), 0).show();
                return;
            }
            x.i("MicroMsg.AppBrandIDCardUI", "resp.auth_status:%d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bmi.vJs)});
            switch (com_tencent_mm_protocal_c_bmi.vJs) {
                case 0:
                    x.d("MicroMsg.AppBrandIDCardUI", "resq.auth_token", new Object[]{com_tencent_mm_protocal_c_bmi.wPO});
                    g.pQN.h(14943, new Object[]{AppBrandIDCardUI.a(this.jNT.jNR.jNQ), Integer.valueOf(9), AppBrandIDCardUI.f(this.jNT.jNR.jNQ).frP});
                    Intent intent = new Intent();
                    intent.putExtra("intent_err_code", com_tencent_mm_protocal_c_bmi.wKN.fxK);
                    intent.putExtra("intent_auth_token", com_tencent_mm_protocal_c_bmi.wPO);
                    this.jNT.jNR.jNQ.setResult(-1, intent);
                    this.jNT.jNR.jNQ.finish();
                    return;
                case 1:
                    g.pQN.h(14943, new Object[]{AppBrandIDCardUI.a(this.jNT.jNR.jNQ), Integer.valueOf(5), AppBrandIDCardUI.f(this.jNT.jNR.jNQ).frP});
                    AppBrandIDCardUI.a(this.jNT.jNR.jNQ, this.jNS);
                    AppBrandIDCardUI.a(this.jNT.jNR.jNQ, com_tencent_mm_protocal_c_bmi.wPN);
                    AppBrandIDCardUI.g(this.jNT.jNR.jNQ);
                    return;
                default:
                    return;
            }
        }
        x.e("MicroMsg.AppBrandIDCardUI", "SubmitAuthorizeUserID cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, bVar.hmh.hmo});
    }
}
