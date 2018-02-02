package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.widget.Toast;
import com.tencent.mm.ae.b;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI.1;
import com.tencent.mm.protocal.c.bge;
import com.tencent.mm.sdk.platformtools.x;

class AppBrandIDCardUI$1$5 implements a {
    final /* synthetic */ 1 jNR;

    AppBrandIDCardUI$1$5(1 1) {
        this.jNR = 1;
    }

    public final void a(int i, int i2, String str, b bVar) {
        if (i == 0 && i2 == 0 && bVar.hmh.hmo != null) {
            bge com_tencent_mm_protocal_c_bge = (bge) bVar.hmh.hmo;
            if (com_tencent_mm_protocal_c_bge.wKN != null) {
                x.i("MicroMsg.AppBrandIDCardUI", "SendSmsResp.auth_base_response.err_code:%d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bge.wKN.fxK)});
                if (com_tencent_mm_protocal_c_bge.wKN.fxK == 0) {
                    this.jNR.jNQ.jNP = com_tencent_mm_protocal_c_bge.wKO;
                    x.i("MicroMsg.AppBrandIDCardUI", "send success, verifyToken:%s", new Object[]{com_tencent_mm_protocal_c_bge.wKO});
                    return;
                }
                1.a(this.jNR, this.jNR.jNQ.getString(j.izE));
                return;
            }
            x.i("MicroMsg.AppBrandIDCardUI", "SendSmsResp.auth_base_response is null");
            1.a(this.jNR, this.jNR.jNQ.getString(j.izE));
            return;
        }
        x.e("MicroMsg.AppBrandIDCardUI", "sendSms cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, bVar.hmh.hmo});
        Toast.makeText(this.jNR.jNQ, this.jNR.jNQ.getString(j.izy), 0).show();
    }
}
