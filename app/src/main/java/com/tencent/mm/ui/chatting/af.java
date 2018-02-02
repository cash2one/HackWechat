package com.tencent.mm.ui.chatting;

import com.tencent.mm.g.a.nt;
import com.tencent.mm.g.a.nu;
import com.tencent.mm.g.a.oq;
import com.tencent.mm.g.a.os;
import com.tencent.mm.g.a.sh;
import com.tencent.mm.modelmulti.j;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import com.tencent.mm.z.s;

public final class af {
    public static void aD(au auVar) {
        x.i("MicroMsg.ResendMsgLogic", "resendVoiceMsg, msgId:%d", new Object[]{Long.valueOf(auVar.field_msgId)});
        if (s.ha(auVar.field_talker)) {
            b nuVar = new nu();
            nuVar.fFN.fnB = auVar;
            a.xef.m(nuVar);
            return;
        }
        nuVar = new nt();
        nuVar.fFM.fnB = auVar;
        a.xef.m(nuVar);
    }

    public static void aE(au auVar) {
        b oqVar = new oq();
        long hR = ba.hR(auVar.field_talker);
        x.i("MicroMsg.ResendMsgLogic", "resendMsgImage, msgId:%d, time[%d - > %d]", new Object[]{Long.valueOf(auVar.field_msgId), Long.valueOf(auVar.field_createTime), Long.valueOf(hR)});
        if (hR == auVar.field_createTime) {
            hR++;
        }
        auVar.aq(hR);
        ar.Hg();
        c.Fa().a(auVar.field_msgId, auVar);
        oqVar.fGH.fnB = auVar;
        a.xef.m(oqVar);
    }

    public static void aF(au auVar) {
        x.i("MicroMsg.ResendMsgLogic", "resendEmoji, msgId:%d", new Object[]{Long.valueOf(auVar.field_msgId)});
        b shVar = new sh();
        shVar.fKb.fnB = auVar;
        a.xef.m(shVar);
    }

    public static void aG(au auVar) {
        x.i("MicroMsg.ResendMsgLogic", "resendAppMsgEmoji, msgId:%d", new Object[]{Long.valueOf(auVar.field_msgId)});
        long hR = ba.hR(auVar.field_talker);
        if (hR == auVar.field_createTime) {
            hR++;
        }
        auVar.aq(hR);
        ar.Hg();
        c.Fa().a(auVar.field_msgId, auVar);
        com.tencent.mm.sdk.e.c fo = an.aqd().fo(auVar.field_msgId);
        if (fo == null || fo.field_msgInfoId != auVar.field_msgId) {
            x.d("MicroMsg.ResendMsgLogic", "resendAppMsgEmoji, directly send app mag");
            an.bYU();
            am.a.ft(auVar.field_msgId);
            return;
        }
        x.d("MicroMsg.ResendMsgLogic", "resendAppMsgEmoji, upload app attach first");
        fo.field_status = 101;
        fo.field_offset = 0;
        fo.field_lastModifyTime = System.currentTimeMillis() / 1000;
        an.aqd().c(fo, new String[0]);
        an.bYU().run();
    }

    public static void aH(au auVar) {
        x.i("MicroMsg.ResendMsgLogic", "resendTextMsg, msgId:%d", new Object[]{Long.valueOf(auVar.field_msgId)});
        aK(auVar);
    }

    public static void aI(au auVar) {
        x.i("MicroMsg.ResendMsgLogic", "resendLocation, msgId:%d", new Object[]{Long.valueOf(auVar.field_msgId)});
        aK(auVar);
    }

    public static void aJ(au auVar) {
        x.i("MicroMsg.ResendMsgLogic", "resendCardMsg, msgId:%d", new Object[]{Long.valueOf(auVar.field_msgId)});
        aK(auVar);
    }

    private static void aK(au auVar) {
        long j = auVar.field_msgId;
        if (j == -1) {
            x.e("MicroMsg.ResendMsgLogic", "sendMsgInternal failed msgId " + j);
        } else if (!auVar.field_talker.equals("medianote") || (q.FW() & 16384) != 0) {
            x.d("MicroMsg.ResendMsgLogic", "sendMsgInternal, start send msgId: %d", new Object[]{Long.valueOf(j)});
            if (!ar.CG().a(new j(j), 0)) {
                x.e("MicroMsg.ResendMsgLogic", "sendMsgInternal, doScene return false, directly mark msg to failed");
                auVar.eQ(5);
                ar.Hg();
                c.Fa().a(auVar.field_msgId, auVar);
                b osVar = new os();
                osVar.fGK.fnB = auVar;
                a.xef.m(osVar);
            }
        }
    }
}
