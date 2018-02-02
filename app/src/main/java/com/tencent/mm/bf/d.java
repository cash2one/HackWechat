package com.tencent.mm.bf;

import com.tencent.mm.ad.h;
import com.tencent.mm.g.a.fm;
import com.tencent.mm.g.b.af;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.bw;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.au.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.e;

public final class d extends e {
    protected final au a(bw bwVar, String str, String str2, String str3) {
        String a = n.a(bwVar.vGZ);
        if (a == null || a.length() <= 0) {
            x.e("MicroMsg.FMessageExtension", "possible friend msg : content is null");
        } else {
            a Xr = a.Xr(a);
            if (!(Xr.xzj == null && Xr.xzk == null) && (Xr.scene == 10 || Xr.scene == 11)) {
                b fmVar = new fm();
                fmVar.fuM.fuO = Xr.xzj;
                fmVar.fuM.fuP = Xr.xzk;
                com.tencent.mm.sdk.b.a.xef.m(fmVar);
                if (fmVar.fuN.fuQ) {
                    x.v("MicroMsg.FMessageExtension", "possible mobile friend is not in local address book");
                }
            }
            if (Xr.pjS > 0) {
                com.tencent.mm.ad.b.c(Xr.pjS, Xr.xzi);
            }
            if (bh.ou(Xr.rYX).length() > 0) {
                h hVar = new h();
                hVar.username = Xr.rYX;
                hVar.fWe = 3;
                hVar.bA(true);
                hVar.fDt = -1;
                hVar.hly = Xr.xzl;
                hVar.hlx = Xr.xzm;
                hVar.fDt = -1;
                x.d("MicroMsg.FMessageExtension", "dkhurl user:[%s] big:[%s] sm:[%s]", new Object[]{Xr.rYX, hVar.JG(), hVar.JH()});
                com.tencent.mm.ad.n.JQ().a(hVar);
            }
            f fVar = new f();
            fVar.field_createTime = e.n(str, (long) bwVar.pbl);
            fVar.field_isSend = 0;
            fVar.field_msgContent = n.a(bwVar.vGZ);
            fVar.field_svrId = bwVar.vHe;
            fVar.field_talker = Xr.rYX;
            fVar.field_type = 0;
            b mU = l.Tx().mU(fVar.field_talker);
            if (mU != null) {
                x.d("MicroMsg.FMessageExtension", "getByEncryptTalker success. encryptTalker = " + fVar.field_talker + " , real talker = " + mU.field_talker);
                fVar.field_encryptTalker = fVar.field_talker;
                fVar.field_talker = mU.field_talker;
            }
            ar.Hg();
            af WO = c.EY().WO(fVar.field_talker);
            if (WO == null || !com.tencent.mm.l.a.fZ(WO.field_type) || WO.gJd <= 0) {
                l.Tw().a(fVar);
            } else {
                x.d("MicroMsg.FMessageExtension", "The biz contact whose talker is " + fVar.field_talker + " has already been in user's contact list");
            }
        }
        return null;
    }
}
