package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.k;
import com.tencent.mm.ae.u.a;
import com.tencent.mm.protocal.c.cap;
import com.tencent.mm.sdk.platformtools.x;

class AppBrandAuthorizeUI$7 implements a {
    final /* synthetic */ AppBrandAuthorizeUI jKs;

    AppBrandAuthorizeUI$7(AppBrandAuthorizeUI appBrandAuthorizeUI) {
        this.jKs = appBrandAuthorizeUI;
    }

    public final int a(int i, int i2, String str, b bVar, k kVar) {
        x.d("MicroMsg.AppBrandAuthorizeUI", "WxaAppGetAuthInfoReq errType = %d, errCode = %d ,errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i == 0 && i2 == 0) {
            cap com_tencent_mm_protocal_c_cap = (cap) bVar.hmh.hmo;
            if (com_tencent_mm_protocal_c_cap == null) {
                AppBrandAuthorizeUI.c(this.jKs);
                x.e("MicroMsg.AppBrandAuthorizeUI", "WxaAppGetAuthInfoReq failed, response is null!");
            } else {
                int i3 = com_tencent_mm_protocal_c_cap.wZW.errCode;
                String str2 = com_tencent_mm_protocal_c_cap.wZW.fnL;
                if (i3 == 0) {
                    this.jKs.jKl = com_tencent_mm_protocal_c_cap.wZX;
                    AppBrandAuthorizeUI.a(this.jKs, this.jKs.jKl);
                } else {
                    AppBrandAuthorizeUI.c(this.jKs);
                    x.e("MicroMsg.AppBrandAuthorizeUI", "WxaAppGetAuthInfoReq error %s", new Object[]{str2});
                }
            }
        } else {
            AppBrandAuthorizeUI.c(this.jKs);
        }
        return 0;
    }
}
