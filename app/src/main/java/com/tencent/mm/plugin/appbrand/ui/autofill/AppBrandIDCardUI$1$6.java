package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.content.Intent;
import android.widget.Toast;
import com.tencent.mm.ae.b;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI.1;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.bsj;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class AppBrandIDCardUI$1$6 implements a {
    final /* synthetic */ 1 jNR;

    AppBrandIDCardUI$1$6(1 1) {
        this.jNR = 1;
    }

    public final void a(int i, int i2, String str, b bVar) {
        if (i == 0 && i2 == 0 && bVar.hmh.hmo != null) {
            bsj com_tencent_mm_protocal_c_bsj = (bsj) bVar.hmh.hmo;
            if (com_tencent_mm_protocal_c_bsj.wKN != null) {
                x.i("MicroMsg.AppBrandIDCardUI", "VerifySmsCodeResp.auth_base_response errcode:%s, errMsg:%s", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bsj.wKN.fxK), bh.ou(com_tencent_mm_protocal_c_bsj.wKN.fxL)});
                g.pQN.h(14943, new Object[]{AppBrandIDCardUI.a(this.jNR.jNQ), Integer.valueOf(8), AppBrandIDCardUI.f(this.jNR.jNQ).frP});
                if (com_tencent_mm_protocal_c_bsj.wKN.fxK == 0) {
                    g.pQN.h(14943, new Object[]{AppBrandIDCardUI.a(this.jNR.jNQ), Integer.valueOf(9), AppBrandIDCardUI.f(this.jNR.jNQ).frP});
                    x.i("MicroMsg.AppBrandIDCardUI", "verify success");
                    x.d("MicroMsg.AppBrandIDCardUI", "resq.auth_token", new Object[]{com_tencent_mm_protocal_c_bsj.wPO});
                    Intent intent = new Intent();
                    intent.putExtra("intent_err_code", com_tencent_mm_protocal_c_bsj.wKN.fxK);
                    intent.putExtra("intent_auth_token", com_tencent_mm_protocal_c_bsj.wPO);
                    this.jNR.jNQ.setResult(-1, intent);
                    this.jNR.jNQ.finish();
                    return;
                } else if (com_tencent_mm_protocal_c_bsj.wKN.fxK == 40013) {
                    1.a(this.jNR, this.jNR.jNQ.getString(j.izD));
                    return;
                } else {
                    1.a(this.jNR, this.jNR.jNQ.getString(j.izC));
                    return;
                }
            }
            x.e("MicroMsg.AppBrandIDCardUI", "VerifySmsCodeResp.auth_base_response is null");
            return;
        }
        x.e("MicroMsg.AppBrandIDCardUI", "SubmitAuthorizeUserID cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, bVar.hmh.hmo});
        Toast.makeText(this.jNR.jNQ, this.jNR.jNQ.getString(j.izy), 0).show();
    }
}
