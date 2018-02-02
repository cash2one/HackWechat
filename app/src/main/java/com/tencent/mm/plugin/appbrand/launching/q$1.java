package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.ae.a$a;
import com.tencent.mm.plugin.appbrand.appcache.aj;
import com.tencent.mm.plugin.appbrand.appcache.f;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.protocal.c.aim;
import com.tencent.mm.protocal.c.ain;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;

class q$1 implements a<Void, a$a<ain>> {
    final /* synthetic */ aim jxX;
    final /* synthetic */ q jxY;

    q$1(q qVar, aim com_tencent_mm_protocal_c_aim) {
        this.jxY = qVar;
        this.jxX = com_tencent_mm_protocal_c_aim;
    }

    public final /* synthetic */ Object call(Object obj) {
        a$a com_tencent_mm_ae_a_a = (a$a) obj;
        if (com_tencent_mm_ae_a_a.errCode == 0 && com_tencent_mm_ae_a_a.errType == 0 && com_tencent_mm_ae_a_a.fJJ != null) {
            q qVar = this.jxY;
            aim com_tencent_mm_protocal_c_aim = this.jxX;
            ain com_tencent_mm_protocal_c_ain = (ain) com_tencent_mm_ae_a_a.fJJ;
            aj.a com_tencent_mm_plugin_appbrand_launching_q_2 = new q$2(qVar);
            x.i("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "%s downloadPkg, patch_url(%s), full_url(%s)", qVar.ahX(), com_tencent_mm_protocal_c_ain.fyG, com_tencent_mm_protocal_c_ain.url);
            boolean b = (com_tencent_mm_protocal_c_aim.wpL <= 0 || bh.ov(com_tencent_mm_protocal_c_ain.fyG)) ? aj.b(qVar.jxU.toString(), 0, qVar.jxW, com_tencent_mm_protocal_c_ain.url, com_tencent_mm_plugin_appbrand_launching_q_2) : f.a(qVar.jxU.toString(), com_tencent_mm_protocal_c_aim.wpL, qVar.jxW, com_tencent_mm_protocal_c_ain.fyG, com_tencent_mm_plugin_appbrand_launching_q_2);
            if (!b) {
                x.e("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "%s start downloadPkg failed", qVar.ahX());
                qVar.d(null);
            }
        } else {
            x.e("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "%s, getDownloadURL failed %d, %d", this.jxY.ahX(), Integer.valueOf(com_tencent_mm_ae_a_a.errType), Integer.valueOf(com_tencent_mm_ae_a_a.errCode));
            y.ta(y.getMMString(j.iAT, new Object[]{Integer.valueOf(com_tencent_mm_ae_a_a.errType), Integer.valueOf(com_tencent_mm_ae_a_a.errCode)}));
            this.jxY.d(null);
        }
        return zBS;
    }
}
