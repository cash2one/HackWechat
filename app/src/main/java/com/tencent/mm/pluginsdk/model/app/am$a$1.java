package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.g.b.cf;
import com.tencent.mm.pluginsdk.model.app.z.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.g;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.c;
import com.tencent.mm.z.s;

class am$a$1 implements a {
    final /* synthetic */ au heZ;
    final /* synthetic */ String iTD;
    final /* synthetic */ b vfj;
    final /* synthetic */ long vfk;
    final /* synthetic */ am.a vfl;

    am$a$1(am.a aVar, b bVar, au auVar, long j, String str) {
        this.vfl = aVar;
        this.vfj = bVar;
        this.heZ = auVar;
        this.vfk = j;
        this.iTD = str;
    }

    public final void a(String str, String str2, String str3, String str4, String str5, long j) {
        this.vfj.field_signature = str3;
        this.vfj.field_fakeAeskey = str4;
        this.vfj.field_fakeSignature = str5;
        this.vfj.field_lastModifyTime = bh.Wp();
        String str6 = this.heZ.field_content;
        if (s.eV(this.heZ.field_talker)) {
            int hO = ba.hO(this.heZ.field_content);
            if (hO != -1) {
                str6 = (this.heZ.field_content + " ").substring(hO + 2).trim();
            }
        }
        g.a fT = g.a.fT(bh.VH(str6));
        if (fT != null) {
            fT.filemd5 = str;
            fT.hbp = str2;
            fT.hbb = (int) j;
            ar.Hg();
            cf dH = c.Fa().dH(this.vfj.field_msgInfoId);
            dH.setContent(g.a.a(fT, null, null));
            ar.Hg();
            c.Fa().a(dH.field_msgId, dH);
        }
        an.aqd().c(this.vfj, new String[0]);
        ar.CG().a(new ak(this.vfk, null, this.iTD), 0);
    }
}
