package com.tencent.mm.bf;

import com.tencent.mm.ad.h;
import com.tencent.mm.ae.d;
import com.tencent.mm.ae.d.a;
import com.tencent.mm.ae.d.b;
import com.tencent.mm.g.a.is;
import com.tencent.mm.g.a.md;
import com.tencent.mm.g.b.af;
import com.tencent.mm.protocal.c.bw;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.z.ak;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import com.tencent.mm.z.s;

public final class n implements d {
    public final b b(a aVar) {
        int i = 0;
        bw bwVar = aVar.hmq;
        String a = com.tencent.mm.platformtools.n.a(bwVar.vGX);
        if ("fmessage".equals(a) || bwVar.ngq == 37) {
            String a2 = com.tencent.mm.platformtools.n.a(bwVar.vGZ);
            final au.d Xu = au.d.Xu(a2);
            String FS = q.FS();
            if (Xu.rYX == null || !Xu.rYX.equals(FS)) {
                String str;
                h hVar = new h();
                hVar.username = Xu.rYX;
                hVar.fWe = 3;
                hVar.bA(true);
                hVar.fDt = -1;
                hVar.hly = Xu.xzl;
                hVar.hlx = Xu.xzm;
                x.d("MicroMsg.VerifyMessageExtension", "dkhurl user:[%s] big:[%s] sm:[%s]", new Object[]{Xu.rYX, hVar.JG(), hVar.JH()});
                com.tencent.mm.ad.n.JQ().a(hVar);
                if (!bh.ov(Xu.rYX)) {
                    if (Xu.scene == 18) {
                        l.Ty().a(bwVar, Xu);
                        ar.Hg();
                        c.CU().set(73729, Integer.valueOf(1));
                        ar.Hg();
                        af WO = c.EY().WO(Xu.xzu);
                        if (WO == null || ((int) WO.gJd) <= 0) {
                            ak.a.hfL.a(Xu.xzu, null, new ak.b.a(this) {
                                final /* synthetic */ n hTm;

                                public final void v(String str, boolean z) {
                                    ar.Hg();
                                    x.d("MicroMsg.VerifyMessageExtension", String.valueOf(c.EY().WO(Xu.xzu)));
                                    com.tencent.mm.sdk.b.b isVar = new is();
                                    isVar.fzh.fzi = Xu.xzu;
                                    isVar.fzh.type = 1;
                                    com.tencent.mm.sdk.b.a.xef.m(isVar);
                                }
                            });
                        } else {
                            str = WO.field_username;
                            if (!(str == null || s.gD(str))) {
                                WO.setUsername(Xu.xzu);
                                WO.di(null);
                                ar.Hg();
                                c.EY().a(str, WO);
                            }
                            com.tencent.mm.sdk.b.b isVar = new is();
                            isVar.fzh.fzi = Xu.xzu;
                            isVar.fzh.type = 1;
                            com.tencent.mm.sdk.b.a.xef.m(isVar);
                        }
                    } else if (ba.gS(Xu.scene)) {
                        l.Tz().a(bwVar, Xu);
                        ar.Hg();
                        c.CU().set(73730, Integer.valueOf(1));
                    } else if (Xu.scene == 48) {
                        com.tencent.mm.sdk.b.b mdVar = new md();
                        mdVar.fDN.fDP = a2;
                        mdVar.fDN.talker = Xu.rYX;
                        com.tencent.mm.sdk.b.a.xef.m(mdVar);
                    }
                }
                f fVar = new f();
                fVar.field_createTime = e.n(a, (long) bwVar.pbl);
                if (bwVar.ktm == 4) {
                    i = 2;
                }
                fVar.field_isSend = i + 0;
                fVar.field_msgContent = com.tencent.mm.platformtools.n.a(bwVar.vGZ);
                fVar.field_svrId = bwVar.vHe;
                fVar.field_talker = Xu.rYX;
                ar.Hg();
                com.tencent.mm.l.a WO2 = c.EY().WO(Xu.chatroomName);
                if (!(WO2 == null || ((int) WO2.gJd) == -1)) {
                    fVar.field_chatroomName = Xu.chatroomName;
                }
                switch (Xu.fuL) {
                    case 2:
                        fVar.field_type = 1;
                        break;
                    case 5:
                        fVar.field_type = 2;
                        break;
                    case 6:
                        fVar.field_type = 3;
                        break;
                    default:
                        fVar.field_type = 1;
                        break;
                }
                if (bh.ov(Xu.xzu)) {
                    x.e("MicroMsg.VerifyMessageExtension", "it should not go in here");
                    b mU = l.Tx().mU(fVar.field_talker);
                    if (mU != null) {
                        fVar.field_encryptTalker = mU.field_talker;
                        fVar.field_talker = mU.field_talker;
                    }
                    l.Tw().a(fVar);
                } else {
                    fVar.field_encryptTalker = Xu.xzu;
                    if (l.Tx().mT(Xu.xzu) != null) {
                        g Tw = l.Tw();
                        str = fVar.field_encryptTalker;
                        Tw.gJP.fx("fmessage_msginfo", "update fmessage_msginfo set talker = '" + bh.ot(fVar.field_talker) + "'  where talker = '" + bh.ot(str) + "'");
                        l.Tx().d(0, fVar.field_encryptTalker);
                    }
                    l.Tw().a(fVar);
                }
            } else {
                x.d("MicroMsg.VerifyMessageExtension", "onPreAddMessage, verify scene:%d, content:%s", new Object[]{Integer.valueOf(Xu.scene), a2});
                x.e("MicroMsg.VerifyMessageExtension", "fromUserName is self, simply drop this msg");
            }
        }
        return null;
    }

    public final void h(au auVar) {
    }
}
