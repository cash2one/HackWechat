package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.g.b.cf;
import com.tencent.mm.modelmulti.b$a;
import com.tencent.mm.modelmulti.q;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ae;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class w$8 implements Runnable {
    final /* synthetic */ int hvX;
    final /* synthetic */ w yBn;
    final /* synthetic */ int yBu;
    final /* synthetic */ ae ywT;

    public w$8(w wVar, int i, ae aeVar, int i2) {
        this.yBn = wVar;
        this.yBu = i;
        this.ywT = aeVar;
        this.hvX = i2;
    }

    public final void run() {
        x.i("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr mGoBackToHistryMsgLayout try get undeliver msg from firstseq[%d]", new Object[]{Integer.valueOf(this.yBu)});
        ar.Hg();
        if (c.Fa().G(this.ywT.field_username, (long) this.yBu).field_msgId > 0) {
            x.i("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr mGoBackToHistryMsgLayout first msg exist just do nothing [%d] [%d]", new Object[]{Long.valueOf(c.Fa().G(this.ywT.field_username, (long) this.yBu).field_msgId), Long.valueOf(c.Fa().G(this.ywT.field_username, (long) this.yBu).field_msgSeq)});
            ag.y(new 1(this));
            return;
        }
        long j;
        long j2 = this.ywT.field_lastSeq;
        ar.Hg();
        cf EU = c.Fa().EU(this.ywT.field_username);
        if (EU == null || EU.field_msgId <= 0) {
            j = j2;
        } else {
            j = EU.field_msgSeq;
        }
        this.yBn.yBi = true;
        x.i("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr mGoBackToHistryMsgLayout get msg mUnreadMessageBeforeCheckHistory[%d], filterSeq[%d], firstSeq[%d]", new Object[]{Integer.valueOf(this.yBn.yBk), Long.valueOf(j), Integer.valueOf(this.yBu)});
        q.Qd().a(new b$a(this.ywT.field_username, (int) j, this.yBu, 18, 0), this.yBn);
    }
}
