package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.ae.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.appusage.j.a;
import com.tencent.mm.protocal.c.aiu;
import com.tencent.mm.protocal.c.aiv;
import com.tencent.mm.protocal.c.cax;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.w;
import java.util.List;

public enum k {
    ;
    
    public static Integer iJV;

    static {
        iJV = null;
    }

    static void a(int i, int i2, int i3, b bVar) {
        if (bVar != null && (((aiu) bVar.hmg.hmo).condition & 2) != 0) {
            aiv com_tencent_mm_protocal_c_aiv = (aiv) bVar.hmh.hmo;
            if (i2 == 0 && i3 == 0 && com_tencent_mm_protocal_c_aiv != null) {
                if (f.Zn() != null) {
                    j Zn = f.Zn();
                    List<cax> list = com_tencent_mm_protocal_c_aiv.wqr;
                    long dz = Zn.iGs.dz(Thread.currentThread().getId());
                    Zn.iGs.delete("AppBrandStarApp", "", null);
                    a aVar = new a();
                    for (cax com_tencent_mm_protocal_c_cax : list) {
                        if (!bh.ov(com_tencent_mm_protocal_c_cax.username)) {
                            aVar.field_username = com_tencent_mm_protocal_c_cax.username;
                            aVar.field_versionType = com_tencent_mm_protocal_c_cax.vOu;
                            aVar.field_updateTime = (long) com_tencent_mm_protocal_c_cax.vUc;
                            Zn.iGs.insert("AppBrandStarApp", null, aVar.vI());
                        }
                    }
                    Zn.iGs.fS(dz);
                    Zn.b("batch", 3, list);
                    l.a(i, null, com_tencent_mm_protocal_c_aiv.wqr);
                }
                g.Dj().CU().a(w.a.xrK, Boolean.valueOf((com_tencent_mm_protocal_c_aiv.status & 1) > 0));
            }
        }
    }
}
