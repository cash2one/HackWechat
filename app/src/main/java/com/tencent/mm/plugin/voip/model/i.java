package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.ae.d;
import com.tencent.mm.ae.d.a;
import com.tencent.mm.ae.d.b;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.k.f;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.messenger.foundation.a.a.c;
import com.tencent.mm.protocal.c.bw;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import java.util.Map;

public final class i implements d {
    public final b b(a aVar) {
        bw bwVar = aVar.hmq;
        String a = n.a(bwVar.vGX);
        String a2 = n.a(bwVar.vGY);
        String a3 = n.a(bwVar.vGZ);
        x.d("MicroMsg.VoipExtension", "voip msg, from: %s, content: %s", new Object[]{a, a3});
        ar.Hg();
        c Fa = com.tencent.mm.z.c.Fa();
        ar.Hg();
        String str = (String) com.tencent.mm.z.c.CU().get(2, "");
        if (str.length() <= 0) {
            return null;
        }
        cf cfVar;
        cf F = Fa.F(str.equals(a) ? a2 : a, bwVar.vHe);
        if (F.field_msgId == 0) {
            F = new au();
            F.ap(bwVar.vHe);
            F.aq(ba.n(a, (long) bwVar.pbl));
            cfVar = F;
        } else {
            cfVar = F;
        }
        d.bGj();
        a MC = m.MC(a3);
        if (MC == null) {
            x.e("MicroMsg.VoipExtension", "parse voip message failed, voipMessage is null!");
            try {
                Map y = bi.y(a3, "voipwarnmsg");
                if (!(y == null || y.get(".voipwarnmsg.type") == null || bh.getInt((String) y.get(".voipwarnmsg.type"), 0) != 1)) {
                    str = (String) y.get(".voipwarnmsg.warntips");
                    if (!(str == null || str.equals(""))) {
                        x.i("MicroMsg.VoipExtension", "got risk tips back:" + str);
                        if (y.get(".voipwarnmsg.roomid") != null) {
                            if (!f.zp()) {
                                x.i("MicroMsg.VoipExtension", "set voipmsg not notification...");
                            } else if (bh.getInt((String) y.get(".voipwarnmsg.roomid"), 0) != d.bGj().smS.siL.ske.nDx) {
                                x.i("MicroMsg.VoipExtension", "wrong roomid,now return..");
                                return null;
                            }
                        }
                        d.bGj().smq = str;
                        d.bGj().MD(str);
                    }
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.VoipExtension", e, "", new Object[0]);
                x.e("MicroMsg.VoipExtension", "parse voip message error: %s", new Object[]{e.getMessage()});
            }
            return null;
        }
        if ((MC.status == a.slF ? 1 : null) != null) {
            x.i("MicroMsg.VoipExtension", "recv voip cancel message");
            m bGj = d.bGj();
            if (!(a3 == null || a3.length() == 0)) {
                a aVar2 = new a();
                if (aVar2.parse(a3) && aVar2.status == 2) {
                    bGj.yG(aVar2.slB);
                    n nVar = bGj.smS;
                    x.i("MicroMsg.Voip.VoipServiceEx", "onCancelInviteMessage, roomId: " + aVar2.slB);
                    if (nVar.siL.skj != null && aVar2.slB == nVar.siL.skj.wbh) {
                        nVar.bHF();
                        nVar.siL.shutdown();
                    }
                }
            }
            if (MC.slB == d.bGj().smY) {
                x.i("MicroMsg.VoipExtension", "already ignore the invite, don't add the message to db");
                return null;
            }
            cfVar.setType(bwVar.ngq);
            cfVar.setContent(MC.bGI() ? au.xzd : au.xzc);
            cfVar.eR(0);
            cfVar.dS(a);
            cfVar.eQ(bwVar.ktm > 3 ? bwVar.ktm : 3);
            cfVar.dY(null);
            ba.a(cfVar, aVar);
            x.d("MicroMsg.VoipExtension", "voipMessage==null: %b", new Object[]{MC});
            if (cfVar.field_msgId == 0) {
                a aVar3;
                if (MC == null) {
                    aVar3 = new a();
                    aVar3.parse(a3);
                } else {
                    aVar3 = MC;
                }
                x.d("MicroMsg.VoipExtension", "add or update msg, roomid: %s", new Object[]{Integer.valueOf(aVar3.slB)});
                if (d.bGj().smX.get(Integer.valueOf(aVar3.slB)) == null) {
                    cfVar.ao(ba.i(cfVar));
                    d.bGj().smX.put(Integer.valueOf(aVar3.slB), Long.valueOf(cfVar.field_msgId));
                } else {
                    ar.Hg();
                    com.tencent.mm.z.c.Fa().a(((Long) d.bGj().smX.get(Integer.valueOf(aVar3.slB))).longValue(), cfVar);
                }
                return new b(cfVar, true);
            }
            ar.Hg();
            com.tencent.mm.z.c.Fa().b(bwVar.vHe, cfVar);
            return new b(cfVar, false);
        }
        if ((MC.status == a.slH ? 1 : null) != null) {
            return null;
        }
        if ((MC.status == a.slE ? 1 : null) == null) {
            return null;
        }
        x.i("MicroMsg.VoipExtension", "recv voip invite delay");
        d.bGj().N(MC.slB, MC.slC);
        return null;
    }

    public final void h(au auVar) {
    }
}
