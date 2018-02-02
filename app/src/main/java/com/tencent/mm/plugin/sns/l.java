package com.tencent.mm.plugin.sns;

import android.util.Base64;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.modelstat.p;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.blt;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.g.a;
import com.tencent.mm.z.u.b;

public final class l implements i {
    public final void b(String str, d dVar) {
        p.b(str, dVar);
    }

    public final String a(String str, PString pString) {
        return p.a(str, pString);
    }

    public final void a(String str, b bVar, au auVar) {
        if (auVar.aNc()) {
            a fT = a.fT(auVar.field_content);
            if (fT != null && !bh.ov(fT.fGG)) {
                bVar.o(str, fT.fGG);
            }
        }
    }

    public final void V(au auVar) {
        String z = p.z(auVar);
        if (z != null) {
            byte[] decode = Base64.decode(z, 0);
            blt com_tencent_mm_protocal_c_blt = new blt();
            try {
                com_tencent_mm_protocal_c_blt.aF(decode);
                if (com_tencent_mm_protocal_c_blt.wPl != null) {
                    Object obj;
                    if (auVar.field_talker.endsWith("@chatroom")) {
                        obj = p.a.hSL.value;
                    } else {
                        String str = p.a.hSK.value;
                    }
                    x.i("MicroMsg.SnsStatExtUtil", "report adPageExposure(13235): scene(%s), statExtStr:%s(id=%s, uxinfo=%s)", new Object[]{obj, z, com_tencent_mm_protocal_c_blt.wPl.wPo, com_tencent_mm_protocal_c_blt.wPl.wPp});
                    ((c) g.h(c.class)).h(13235, obj, com_tencent_mm_protocal_c_blt.wPl.wPo, com_tencent_mm_protocal_c_blt.wPl.wPp);
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.SnsStatExtUtil", e, "", new Object[0]);
            }
        }
    }

    public final String z(au auVar) {
        return p.z(auVar);
    }
}
