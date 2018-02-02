package com.tencent.mm.plugin.appbrand.ui.autofill;

import com.tencent.mm.ae.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.g.b.b;
import com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI.1;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.bmh;
import com.tencent.mm.protocal.c.bmi;
import com.tencent.mm.sdk.platformtools.x;

class AppBrandIDCardUI$1$4 implements b {
    final /* synthetic */ 1 jNR;

    AppBrandIDCardUI$1$4(1 1) {
        this.jNR = 1;
    }

    public final void d(boolean z, String str) {
        if (z) {
            g.pQN.h(14943, new Object[]{AppBrandIDCardUI.a(this.jNR.jNQ), Integer.valueOf(4), AppBrandIDCardUI.f(this.jNR.jNQ).frP});
            a aVar = new a();
            aVar.hmj = new bmh();
            aVar.hmk = new bmi();
            aVar.uri = "/cgi-bin/mmbiz-bin/userdata/submitauthorizeuserid";
            aVar.hmi = 1721;
            aVar.hml = 0;
            aVar.hmm = 0;
            com.tencent.mm.ae.b JZ = aVar.JZ();
            bmh com_tencent_mm_protocal_c_bmh = (bmh) JZ.hmg.hmo;
            com_tencent_mm_protocal_c_bmh.fFm = AppBrandIDCardUI.a(this.jNR.jNQ);
            com_tencent_mm_protocal_c_bmh.wKL = AppBrandIDCardUI.b(this.jNR.jNQ);
            com_tencent_mm_protocal_c_bmh.wKM = str;
            com_tencent_mm_protocal_c_bmh.frP = AppBrandIDCardUI.f(this.jNR.jNQ).frP;
            AppBrandIDCardUI.c(this.jNR.jNQ).show();
            com.tencent.mm.ipcinvoker.wx_extension.b.a(JZ, new 1(this, str));
        }
        x.i("MicroMsg.AppBrandIDCardUI", "verifyOk:%b", new Object[]{Boolean.valueOf(z)});
    }
}
