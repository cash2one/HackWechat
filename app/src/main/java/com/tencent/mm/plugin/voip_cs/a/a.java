package com.tencent.mm.plugin.voip_cs.a;

import com.tencent.mm.g.a.sn;
import com.tencent.mm.plugin.voip_cs.b.b;
import com.tencent.mm.plugin.voip_cs.b.d;
import com.tencent.mm.protocal.c.bts;
import com.tencent.mm.protocal.c.btz;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.io.IOException;

public final class a extends c<sn> {
    public a() {
        this.xen = sn.class.getName().hashCode();
    }

    private static boolean a(sn snVar) {
        if ((snVar instanceof sn) && ar.Hj()) {
            d bIT = b.bIT();
            Object obj = snVar.fKj.fKk;
            if (!(obj == null || obj.length == 0)) {
                Object obj2 = new byte[(obj.length - 1)];
                System.arraycopy(obj, 1, obj2, 0, obj2.length);
                bts com_tencent_mm_protocal_c_bts = new bts();
                try {
                    com_tencent_mm_protocal_c_bts.aF(obj2);
                    x.i("MicroMsg.voipcs.VoipCSService", "notify status = " + com_tencent_mm_protocal_c_bts.wVf + ",notifySeq = " + bIT.swP);
                    btz com_tencent_mm_protocal_c_btz = new btz();
                    com_tencent_mm_protocal_c_btz.wUT = com_tencent_mm_protocal_c_bts.wUT;
                    com_tencent_mm_protocal_c_btz.wbi = com_tencent_mm_protocal_c_bts.wbi;
                    com_tencent_mm_protocal_c_btz.wVd = com_tencent_mm_protocal_c_bts.wVd;
                    com_tencent_mm_protocal_c_btz.wVf = com_tencent_mm_protocal_c_bts.wVf;
                    com_tencent_mm_protocal_c_btz.wVg = com_tencent_mm_protocal_c_bts.wVg;
                    com_tencent_mm_protocal_c_btz.wVh = com_tencent_mm_protocal_c_bts.wVh;
                    com_tencent_mm_protocal_c_btz.wVe = com_tencent_mm_protocal_c_bts.wVe;
                    bIT.a(com_tencent_mm_protocal_c_btz);
                } catch (IOException e) {
                    x.e("MicroMsg.voipcs.VoipCSService", "csNotify.parseFrom content error!", new Object[]{e});
                }
            }
        }
        return false;
    }
}
