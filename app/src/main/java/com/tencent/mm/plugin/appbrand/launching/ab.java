package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.compatible.loader.a;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.appcache.ae;
import com.tencent.mm.plugin.appbrand.appcache.u;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.plugin.appbrand.i.c;
import com.tencent.mm.protocal.c.aoa;
import com.tencent.mm.protocal.c.cam;
import com.tencent.mm.protocal.c.cbl;
import com.tencent.mm.protocal.c.cbs;
import com.tencent.mm.sdk.platformtools.bh;

final class ab extends x<u> {
    final String appId;
    final int fIm;
    final int fIs;
    final int iKd;
    final String iNW;
    final AppBrandLaunchReferrer iNZ;
    final int jhr;
    final String jxA;
    final int jxz;

    public final /* synthetic */ Object call() {
        return aib();
    }

    ab(String str, int i, int i2, int i3, String str2, AppBrandLaunchReferrer appBrandLaunchReferrer, String str3, int i4) {
        int i5 = 0;
        this.appId = str;
        this.iKd = i;
        this.fIs = i2;
        this.jxz = i3;
        this.iNW = str2;
        this.iNZ = appBrandLaunchReferrer;
        this.jxA = str3;
        ae a = f.Zo().a(str, i, new String[]{"version"});
        if (a != null) {
            i5 = a.field_version;
        }
        this.fIm = i5;
        if (i4 < 0) {
            i4 = u.ZM();
        }
        this.jhr = i4;
    }

    public final u aib() {
        int i = 0;
        u uVar = new u();
        uVar.field_appId = this.appId;
        t Zi = f.Zi();
        if (Zi == null) {
            return null;
        }
        boolean z;
        cbl com_tencent_mm_protocal_c_cbl;
        cbs com_tencent_mm_protocal_c_cbs;
        cam com_tencent_mm_protocal_c_cam = new cam();
        com_tencent_mm_protocal_c_cam.wtc = this.iKd;
        com_tencent_mm_protocal_c_cam.vNa = this.fIm;
        com_tencent_mm_protocal_c_cam.rYW = this.jxz;
        com_tencent_mm_protocal_c_cam.wwC = this.iNW;
        com_tencent_mm_protocal_c_cam.wwB = 0;
        com_tencent_mm_protocal_c_cam.wwA = this.fIs;
        if (1055 == this.jxz) {
            z = true;
        } else if (1037 == this.jxz) {
            z = true;
        } else {
            int[] iArr = AppBrandGlobalSystemConfig.abS().iNv;
            z = iArr != null && a.b(iArr, this.jxz);
        }
        if (!z) {
            if (Zi.a(uVar, new String[]{"appId"})) {
                if (uVar.field_jsapiInfo != null) {
                    i = 1;
                }
                if (!(i == 0 || uVar.field_launchAction == null || 1 != uVar.field_launchAction.vEe)) {
                    if (1086 != this.jxz) {
                        new e(this.appId, com_tencent_mm_protocal_c_cam, this.jxA, this.jhr).ahU();
                    } else {
                        f.Zm().s(q.qS(this.appId), this.iKd, 1086);
                    }
                    return uVar;
                }
            }
        }
        if (this.iNZ == null || 1 != this.iNZ.iOd) {
            com_tencent_mm_protocal_c_cbl = null;
        } else {
            com_tencent_mm_protocal_c_cbl = new cbl();
            com_tencent_mm_protocal_c_cbl.wsW = this.iNZ.appId;
            com_tencent_mm_protocal_c_cbl.wsQ = this.iNZ.fqd;
        }
        if (this.iNZ == null || 2 != this.iNZ.iOd) {
            com_tencent_mm_protocal_c_cbs = null;
        } else {
            cbs com_tencent_mm_protocal_c_cbs2 = new cbs();
            com_tencent_mm_protocal_c_cbs2.nkv = this.iNZ.appId;
            com_tencent_mm_protocal_c_cbs2.nfX = this.iNZ.url;
            com_tencent_mm_protocal_c_cbs = com_tencent_mm_protocal_c_cbs2;
        }
        long Wp = bh.Wp();
        e eVar = new e(this.appId, true, com_tencent_mm_protocal_c_cam, com_tencent_mm_protocal_c_cbs, com_tencent_mm_protocal_c_cbl, this.jxA, this.jhr);
        eVar.jxH = true;
        com.tencent.mm.ae.a.a c = c.c(eVar.gJQ);
        eVar.a(c.errType, c.errCode, c.fnL, (aoa) c.fJJ);
        s.a(s$a.SYNC_LAUNCH, this.appId, this.fIm, this.iKd, this.jxz, bh.Wp() - Wp);
        return eVar.jxG;
    }

    final String getTag() {
        return "MicroMsg.AppBrand.PrepareStepCheckLaunchInfo";
    }
}
