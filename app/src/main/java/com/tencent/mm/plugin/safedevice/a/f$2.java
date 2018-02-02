package com.tencent.mm.plugin.safedevice.a;

import com.tencent.mm.g.a.rz;
import com.tencent.mm.protocal.c.aex;
import com.tencent.mm.protocal.c.bdf;
import com.tencent.mm.protocal.c.gy;
import com.tencent.mm.protocal.c.ha;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class f$2 extends c<rz> {
    final /* synthetic */ f pRm;

    f$2(f fVar) {
        this.pRm = fVar;
        this.xen = rz.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        bdf com_tencent_mm_protocal_c_bdf = ((rz) bVar).fJI.fJJ;
        if (com_tencent_mm_protocal_c_bdf == null) {
            x.e("MicroMsg.SafeDeviceStorageLogic", "null resp");
        } else if (com_tencent_mm_protocal_c_bdf instanceof gy) {
            gy gyVar = (gy) com_tencent_mm_protocal_c_bdf;
            if (gyVar != null) {
                e.a(gyVar.vMv);
            }
        } else if (com_tencent_mm_protocal_c_bdf instanceof ha) {
            ha haVar = (ha) com_tencent_mm_protocal_c_bdf;
            if (haVar != null) {
                e.a(haVar.vMv);
            }
        } else if (com_tencent_mm_protocal_c_bdf instanceof aex) {
            aex com_tencent_mm_protocal_c_aex = (aex) com_tencent_mm_protocal_c_bdf;
            if (!(com_tencent_mm_protocal_c_aex == null || com_tencent_mm_protocal_c_aex.wmN == null)) {
                e.a(com_tencent_mm_protocal_c_aex.wmN.vMv);
            }
        }
        return false;
    }
}
