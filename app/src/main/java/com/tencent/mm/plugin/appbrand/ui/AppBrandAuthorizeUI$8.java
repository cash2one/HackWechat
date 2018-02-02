package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.k;
import com.tencent.mm.ae.u.a;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.protocal.c.caz;
import com.tencent.mm.sdk.platformtools.x;

class AppBrandAuthorizeUI$8 implements a {
    final /* synthetic */ AppBrandAuthorizeUI jKs;

    AppBrandAuthorizeUI$8(AppBrandAuthorizeUI appBrandAuthorizeUI) {
        this.jKs = appBrandAuthorizeUI;
    }

    public final int a(int i, int i2, String str, b bVar, k kVar) {
        x.d("MicroMsg.AppBrandAuthorizeUI", "WxaAppModAuthReq errType = %d, errCode = %d ,errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i == 0 && i2 == 0) {
            caz com_tencent_mm_protocal_c_caz = (caz) bVar.hmh.hmo;
            if (com_tencent_mm_protocal_c_caz == null) {
                x.e("MicroMsg.AppBrandAuthorizeUI", "WxaAppModAuthReq failed, response is null!");
            } else {
                int i3 = com_tencent_mm_protocal_c_caz.wZW.errCode;
                String str2 = com_tencent_mm_protocal_c_caz.wZW.fnL;
                if (i3 == 0) {
                    x.d("MicroMsg.AppBrandAuthorizeUI", "WxaAppModAuthReq OK!");
                    try {
                        q.qQ(AppBrandAuthorizeUI.d(this.jKs));
                    } catch (Exception e) {
                    }
                } else {
                    x.e("MicroMsg.AppBrandAuthorizeUI", "WxaAppModAuthReq error %s", new Object[]{str2});
                }
            }
        }
        return 0;
    }
}
