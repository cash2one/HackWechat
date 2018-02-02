package com.tencent.mm.plugin.qmessage.a;

import com.tencent.mm.ae.d;
import com.tencent.mm.ae.d.a;
import com.tencent.mm.ae.d.b;
import com.tencent.mm.aq.e;
import com.tencent.mm.aq.g;
import com.tencent.mm.aq.o;
import com.tencent.mm.g.b.af;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.bw;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.c;
import java.util.Map;
import junit.framework.Assert;

public final class f implements d {
    public final b b(a aVar) {
        bw bwVar = aVar.hmq;
        if (bwVar == null) {
            x.e("MicroMsg.QMsgExtension", "onPreAddMessage cmdAM is null");
            return null;
        } else if (bwVar.ngq == 36 || bwVar.ngq == 39) {
            cf cfVar;
            int i;
            au auVar;
            String a = n.a(bwVar.vGZ);
            String a2 = n.a(bwVar.vGX);
            String a3 = n.a(bwVar.vGY);
            x.d("MicroMsg.QMsgExtension", "parseQMsg content:" + a);
            ar.Hg();
            String str = (String) c.CU().get(2, null);
            String str2 = str.equals(a2) ? a3 : a2;
            ar.Hg();
            cf F = c.Fa().F(str2, bwVar.vHe);
            x.d("MicroMsg.QMsgExtension", "dkmsgid parseQMsg svrid:%d localid:%d", new Object[]{Long.valueOf(bwVar.vHe), Long.valueOf(F.field_msgId)});
            if (F.field_msgId != 0 && F.field_createTime + 604800000 < ba.n(a2, (long) bwVar.pbl)) {
                x.w("MicroMsg.QMsgExtension", "dkmsgid prepareMsgInfo msg Too Old Remove it. svrid:%d localid:%d", new Object[]{Long.valueOf(bwVar.vHe), Long.valueOf(F.field_msgId)});
                ba.aK(F.field_msgId);
                F.ao(0);
            }
            if (F.field_msgId == 0) {
                F = new au();
                F.ap(bwVar.vHe);
                F.aq(ba.n(a2, (long) bwVar.pbl));
                cfVar = F;
            } else {
                cfVar = F;
            }
            cfVar.setType(bwVar.ngq);
            cfVar.dS(str2);
            d HD = g.bjY().HD(str2);
            if (HD == null || bh.ou(HD.getUsername()).length() <= 0) {
                HD = new d();
                HD.username = str2;
                HD.pnt = 1;
                HD.fDt = 9;
                if (!g.bjY().a(HD)) {
                    x.e("MicroMsg.QMsgExtension", "parseQMsg : insert QContact failed : username = " + HD.getUsername());
                }
            }
            long j = -1;
            if (bwVar.vHa == 2 && cfVar.field_msgId == 0) {
                byte[] a4 = n.a(bwVar.vHb);
                PString pString = new PString();
                PInt pInt = new PInt();
                PInt pInt2 = new PInt();
                g Pw = o.Pw();
                int i2 = bwVar.vHa;
                j = Pw.a(a4, bwVar.vHe, false, "", pString, pInt, pInt2);
                if (j > 0) {
                    cfVar.dT(pString.value);
                    cfVar.fc(pInt.value);
                    cfVar.fd(pInt2.value);
                }
            }
            long j2 = j;
            if (bwVar.ngq == 36) {
                Object obj;
                af xVar;
                Assert.assertTrue(true);
                Assert.assertTrue(bh.ou(a).length() > 0);
                Assert.assertTrue(bh.ou(cfVar.field_talker).length() > 0);
                ar.Hg();
                af WO = c.EY().WO(cfVar.field_talker);
                if (WO == null || bh.ou(WO.field_username).length() <= 0) {
                    obj = 1;
                    xVar = new com.tencent.mm.storage.x(cfVar.field_talker);
                } else {
                    obj = null;
                    xVar = WO;
                }
                a aVar2 = new a((byte) 0);
                Map y = bi.y(a, "msg");
                if (y != null) {
                    aVar2.gBL = (String) y.get(".msg.from.displayname");
                    aVar2.content = (String) y.get(".msg.content.t");
                }
                xVar.da(aVar2.gBL == null ? "" : aVar2.gBL);
                cfVar.setContent(aVar2.content == null ? "" : aVar2.content);
                if (obj != null) {
                    ar.Hg();
                    c.EY().R(xVar);
                } else {
                    ar.Hg();
                    c.EY().a(xVar.field_username, xVar);
                }
            }
            ar.Hg();
            Object obj2 = (c.Fg().has(a2) || str.equals(a2)) ? 1 : null;
            if (obj2 != null) {
                cfVar.eR(1);
                i = bwVar.ktm;
                auVar = cfVar;
            } else {
                cfVar.eR(0);
                if (bwVar.ktm > 3) {
                    i = bwVar.ktm;
                    F = cfVar;
                } else {
                    i = 3;
                    F = cfVar;
                }
            }
            auVar.eQ(i);
            cfVar.dY(bwVar.vHc);
            ba.a(cfVar, aVar);
            if (cfVar.field_msgId == 0) {
                cfVar.ao(ba.i(cfVar));
                if (bwVar.vHa == 2) {
                    e b = o.Pw().b(Long.valueOf(j2));
                    b.bf((long) ((int) cfVar.field_msgId));
                    o.Pw().a(Long.valueOf(j2), b);
                }
                return new b(cfVar, true);
            }
            ar.Hg();
            c.Fa().b(bwVar.vHe, cfVar);
            return new b(cfVar, false);
        } else {
            x.e("MicroMsg.QMsgExtension", "onPreAddMessage cmdAM.type:%d", new Object[]{Integer.valueOf(bwVar.ngq)});
            return null;
        }
    }

    public final void h(au auVar) {
        o.Pw().o(auVar);
    }
}
