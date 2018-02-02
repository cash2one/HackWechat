package com.tencent.mm.modelvoice;

import com.tencent.mm.ae.d;
import com.tencent.mm.ae.d.a;
import com.tencent.mm.ae.d.b;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.protocal.c.bw;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.au;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.q;
import com.tencent.mm.z.s;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class r implements d {
    private static Set<c> hXJ = new HashSet();

    public static void c(c cVar) {
        if (!hXJ.contains(cVar)) {
            hXJ.add(cVar);
        }
    }

    public static void b(c cVar) {
        hXJ.remove(cVar);
    }

    public final b b(a aVar) {
        bw bwVar = aVar.hmq;
        if (bwVar == null) {
            x.e("MicroMsg.VoiceMsgExtension", "onPreAddMessage cmdAM is null , give up.");
            return null;
        }
        String a;
        p bw;
        x.i("MicroMsg.VoiceMsgExtension", "summerbadcr parseVoiceMsg srvId:" + bwVar.vHe);
        String a2 = n.a(bwVar.vGX);
        if (a2.equals(q.FS())) {
            a = n.a(bwVar.vGY);
        } else {
            a = a2;
        }
        cf F = ((h) g.h(h.class)).aZi().F(a, bwVar.vHe);
        if (F.field_msgId != 0 && F.field_createTime + 604800000 < ba.n(a, (long) bwVar.pbl)) {
            x.w("MicroMsg.VoiceMsgExtension", "dkmsgid prepareMsgInfo msg Too Old Remove it. svrid:%d", new Object[]{Long.valueOf(bwVar.vHe)});
            ba.o(a, bwVar.vHe);
            bw = m.UD().bw(bwVar.vHe);
            if (!(bw == null || bh.ov(bw.fileName))) {
                q.nZ(bw.fileName);
            }
        }
        bw = new p();
        bw.fDC = a;
        bw.hVE = (long) bwVar.pbl;
        bw.fFo = bwVar.vHe;
        bw.gjF = bwVar.vHc;
        x.d("MicroMsg.VoiceMsgExtension", "voiceMsgExtension, onPreAddMessage.(MsgSource : %s)", new Object[]{bwVar.vHc});
        String a3 = n.a(bwVar.vGZ);
        if (s.eV(a2)) {
            a2 = ba.hQ(a3);
            x.i("MicroMsg.VoiceMsgExtension", "chatroom voicemsg, new content=" + a2);
        } else {
            a2 = a3;
        }
        Map y = bi.y(a2, "msg");
        if (y == null) {
            com.tencent.mm.plugin.report.service.g.pQN.a(111, 227, 1, false);
            return null;
        }
        try {
            bw.hUp = Integer.valueOf((String) y.get(".msg.voicemsg.$length")).intValue();
            bw.clientId = (String) y.get(".msg.voicemsg.$clientmsgid");
            int intValue = Integer.valueOf((String) y.get(".msg.voicemsg.$endflag")).intValue();
            int intValue2 = Integer.valueOf((String) y.get(".msg.voicemsg.$cancelflag")).intValue();
            bw.hXC = Integer.valueOf((String) y.get(".msg.voicemsg.$voicelength")).intValue();
            bw.hVz = (String) y.get(".msg.voicemsg.$fromusername");
            String str = (String) y.get(".msg.commenturl");
            bw.hWC = Integer.valueOf(bh.az((String) y.get(".msg.voicemsg.$forwardflag"), "0")).intValue();
            bw.hWv = (String) y.get(".msg.voicemsg.$voiceformat");
            bw.hXD = bh.getLong((String) y.get(".msg.voicemsg.$bufid"), 0);
            if (intValue2 == 1) {
                x.v("MicroMsg.VoiceMsgExtension", "cancelFlag = 1 srvId:" + bwVar.vHe);
                bw = m.UD().bw(bw.fFo);
                if (bw != null) {
                    q.nX(bw.fileName);
                }
                return null;
            }
            cf F2;
            if (intValue == 1) {
                x.v("MicroMsg.VoiceMsgExtension", "endFlag = 1 srvId:" + bwVar.vHe);
                bw.hlp = bw.hUp;
            }
            bw.fDt = 284334;
            byte[] a4 = n.a(bwVar.vHb);
            if (a4 != null) {
                x.d("MicroMsg.VoiceMsgExtension", "Voice Buf Len:" + a4.length + " srvId:" + bwVar.vHe);
            }
            if (q.a(bw, a4, bwVar.ktm, str, bwVar.vHc, aVar) > 0) {
                x.i("MicroMsg.VoiceMsgExtension", "summerbadcr parseVoiceMsg setRecvSync[%d], svrId[%d], msgseq[%d]", new Object[]{Integer.valueOf(q.a(bw, a4, bwVar.ktm, str, bwVar.vHc, aVar)), Long.valueOf(bwVar.vHe), Integer.valueOf(bwVar.vHf)});
                com.tencent.mm.plugin.report.service.g.pQN.a(111, 228, 1, false);
                F2 = ((h) g.h(h.class)).aZi().F(bw.fDC, bw.fFo);
                F2.Dq(0);
                for (c 1 : hXJ) {
                    ag.y(new 1(this, 1, bw));
                }
            } else {
                x.i("MicroMsg.VoiceMsgExtension", "summerbadcr parseVoiceMsg setRecvSync[%d], svrId[%d], msgseq[%d], stack[%s]", new Object[]{Integer.valueOf(q.a(bw, a4, bwVar.ktm, str, bwVar.vHc, aVar)), Long.valueOf(bwVar.vHe), Integer.valueOf(bwVar.vHf), bh.cgy()});
                F2 = null;
            }
            if (F2 != null) {
                ae WY = ((h) g.h(h.class)).Fd().WY(a);
                if (WY != null) {
                    WY.AU();
                    ((h) g.h(h.class)).Fd().a(WY, a);
                }
            }
            boolean z = F2 != null && F2.field_msgId > 0;
            return new b(F2, z);
        } catch (Throwable e) {
            com.tencent.mm.plugin.report.service.g.pQN.a(111, 227, 1, false);
            x.e("MicroMsg.VoiceMsgExtension", "parsing voice msg xml failed");
            x.e("MicroMsg.VoiceMsgExtension", "exception:%s", new Object[]{bh.i(e)});
            return null;
        }
    }

    public final void h(au auVar) {
        x.d("MicroMsg.VoiceMsgExtension", "onPreDelMessage " + auVar.field_imgPath + " " + auVar.field_talker);
        if (!s.ha(auVar.field_talker)) {
            q.nZ(auVar.field_imgPath);
        }
    }
}
