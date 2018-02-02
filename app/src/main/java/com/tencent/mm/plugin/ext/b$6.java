package com.tencent.mm.plugin.ext;

import com.tencent.mm.pluginsdk.model.j;
import com.tencent.mm.pluginsdk.model.j.a;
import com.tencent.mm.pluginsdk.model.j.b;
import com.tencent.mm.pluginsdk.model.m;
import com.tencent.mm.protocal.c.ahe;
import com.tencent.mm.protocal.c.brn;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bj;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.Iterator;

class b$6 implements a {
    final /* synthetic */ b lZF;

    b$6(b bVar) {
        this.lZF = bVar;
    }

    public final void a(m mVar) {
        if (mVar != null) {
            ahe com_tencent_mm_protocal_c_ahe;
            if (mVar.lMW == null) {
                com_tencent_mm_protocal_c_ahe = null;
            } else {
                com_tencent_mm_protocal_c_ahe = (ahe) mVar.lMW.hmh.hmo;
            }
            Iterator it = com_tencent_mm_protocal_c_ahe.woz.iterator();
            int i = 0;
            while (it.hasNext()) {
                brn com_tencent_mm_protocal_c_brn = (brn) it.next();
                x.v("MicroMsg.SubCoreExt", "AppId[%s], UserName[%s], Xml[%s]", new Object[]{mVar.vdx, com_tencent_mm_protocal_c_brn.ksU, com_tencent_mm_protocal_c_brn.wTm});
                if (!(bh.ov(com_tencent_mm_protocal_c_brn.ksU) || bh.ov(com_tencent_mm_protocal_c_brn.wTm))) {
                    ar.Hg();
                    com.tencent.mm.l.a WM = c.EY().WM(com_tencent_mm_protocal_c_brn.ksU);
                    if (WM == null || ((int) WM.gJd) <= 0) {
                        x.e("MicroMsg.SubCoreExt", "contact is null");
                    } else if (WM.cia()) {
                        x.w("MicroMsg.SubCoreExt", "isBizContact");
                    } else {
                        b Ru = j.Ru(com_tencent_mm_protocal_c_brn.wTm);
                        if (!(Ru == null || bh.ov(Ru.vdr))) {
                            x.v("MicroMsg.SubCoreExt", "AppId[%s], openId[%s]", new Object[]{mVar.vdx, Ru.vdr});
                            b.aFC().a(new bj(mVar.vdx, com_tencent_mm_protocal_c_brn.ksU, Ru.vdr));
                            i = 1;
                        }
                    }
                }
            }
            if (i != 0) {
                this.lZF.aFG();
            }
        }
    }
}
