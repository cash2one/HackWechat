package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.g.b.aj;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.modelmulti.b;
import com.tencent.mm.modelmulti.b.c;
import com.tencent.mm.modelmulti.q;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.as.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.z.ar;

public final class w implements c, a {
    public static int yBh = 350;
    public p fhr;
    public boolean yBi = false;
    public boolean yBj = false;
    public int yBk = -1;
    public boolean yBl = true;
    public com.tencent.mm.sdk.b.c yBm = new 1(this);

    public w(p pVar) {
        this.fhr = pVar;
    }

    public final String PU() {
        if (this.fhr.cse()) {
            return this.fhr.csi().field_username;
        }
        return "";
    }

    public final void ia(int i) {
        x.i("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr onGetFinish retcode[%d] thread[%d], dealHistoryGetMsg[%b], needCheckHistoryTips[%b]", new Object[]{Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()), Boolean.valueOf(this.yBi), Boolean.valueOf(this.yBj)});
        if (i == 0 && this.yBi) {
            ar.Hg();
            aj WY = com.tencent.mm.z.c.Fd().WY(this.fhr.csi().field_username);
            if (WY != null) {
                int i2 = WY.field_unReadCount;
                int i3 = WY.field_UnDeliverCount;
                ar.Hg();
                x.i("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr onGetFinish unReadCount[%d] unDeliverCount[%d] beforemsgCount[%d], msgCount[%d] pos[%d]", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(this.yBk), Integer.valueOf(com.tencent.mm.z.c.Fa().EM(this.fhr.csi().field_username)), Integer.valueOf((com.tencent.mm.z.c.Fa().EM(this.fhr.csi().field_username) - this.yBk) - i2)});
                ag.y(new 4(this, r3));
                return;
            }
            return;
        }
        ag.y(new 3(this));
    }

    public final boolean PV() {
        return this.yBi;
    }

    public final void a(final ae aeVar, as asVar) {
        x.i("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr onMsgChangeNotify cvs.getUsername[%s] tid[%d]", new Object[]{aeVar.field_username, Long.valueOf(Thread.currentThread().getId())});
        if (this.fhr.cse() && this.fhr.csi().field_username.equals(aeVar.field_username)) {
            int i = aeVar.field_msgCount;
            int i2 = this.fhr.csy().hKb;
            x.i("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr onMsgChangeNotify newCvsCount[%d], total[%d], dealHistoryGetMsg[%b], UnDeliverCount[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(this.yBi), Integer.valueOf(aeVar.field_UnDeliverCount)});
            if (i >= i2) {
                cf cfVar;
                if (i > i2) {
                    cfVar = aeVar.xye;
                } else {
                    au auVar = (au) this.fhr.csy().getItem(0);
                }
                if (cfVar != null && cfVar.field_msgId != 0) {
                    int i3 = cfVar.field_flag;
                    x.i("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr onMsgChangeNotify receive get msg svrId[%d], seq[%d], flag[%d], stack[%s]", new Object[]{Long.valueOf(cfVar.field_msgSvrId), Long.valueOf(cfVar.field_msgSeq), Integer.valueOf(i3), bh.cgy()});
                    if ((i3 & 2) == 0) {
                        return;
                    }
                    int firstVisiblePosition;
                    int i4;
                    if ((i3 & 4) == 0) {
                        x.i("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr onMsgChangeNotify down dealHistoryGetMsg: %b", new Object[]{Boolean.valueOf(this.yBi)});
                        if (this.yBi) {
                            x.i("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr onMsgChangeNotify down but dealHistoryGetMsg so ignore");
                            return;
                        }
                        firstVisiblePosition = this.fhr.csx().getFirstVisiblePosition();
                        i3 = this.fhr.csy().getCount();
                        this.fhr.csy().crK();
                        i4 = i - i2;
                        x.i("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr onMsgChangeNotify down talker[%s],firstVisiblePosition:%d, new oldTotal[%d,%d,%d], now preCount:[%d,%d,%d] fromcount:%d, needCheckHistoryTips:%b", new Object[]{this.fhr.csi().field_username, Integer.valueOf(firstVisiblePosition), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(this.fhr.csy().getCount()), Integer.valueOf(i3), Integer.valueOf(this.fhr.csy().getCount() - i3), Integer.valueOf(this.fhr.csy().ldH), Boolean.valueOf(this.yBj)});
                        if (this.fhr.csy().getCount() - i3 > 1) {
                            this.fhr.csx().setAdapter(this.fhr.csy());
                            this.fhr.csx().setSelection(firstVisiblePosition);
                            return;
                        }
                        return;
                    }
                    firstVisiblePosition = this.fhr.csy().getCount();
                    this.fhr.csy().crK();
                    int i5 = i - i2;
                    i4 = this.fhr.csy().getCount() - firstVisiblePosition;
                    x.i("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr onMsgChangeNotify up talker[%s],new oldTotal[%d,%d,%d], now preCount:[%d,%d,%d] fromcount:%d needCheckHistoryTips:%b", new Object[]{this.fhr.csi().field_username, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i5), Integer.valueOf(this.fhr.csy().getCount()), Integer.valueOf(firstVisiblePosition), Integer.valueOf(i4), Integer.valueOf(this.fhr.csy().ldH), Boolean.valueOf(this.yBj)});
                    if (i4 <= 0 || i5 != i4 || this.fhr.csy().ldH < 0) {
                        x.i("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr onMsgChangeNotify up incTotal incCount[%d, %d, %d] keep same", new Object[]{Integer.valueOf(i5), Integer.valueOf(i4), Integer.valueOf(this.fhr.csy().ldH)});
                    } else {
                        this.fhr.csy().Fw(i4);
                        x.i("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr onMsgChangeNotify up nowCount > preCount on set select:%d position %d", new Object[]{Integer.valueOf(i4), Integer.valueOf(i4 + 1)});
                        t.a(this.fhr.csx(), i4 + 1, this.fhr.csO() + this.fhr.csz().ycr, false);
                    }
                    this.fhr.csz().mq(false);
                    this.fhr.csy().yty = true;
                    if (aeVar.field_UnDeliverCount <= 0) {
                        this.fhr.csU();
                    }
                    if (this.yBj) {
                        this.yBj = false;
                        this.fhr.csz().mn(this.fhr.csy().crN());
                        this.fhr.csz().mo(this.fhr.csD());
                        this.fhr.csz().mr(false);
                        x.i("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr onMsgChangeNotify set needCheckHistoryTips[%b]", new Object[]{Boolean.valueOf(this.yBj)});
                        this.fhr.css().postDelayed(new Runnable(this) {
                            final /* synthetic */ w yBn;

                            public final void run() {
                                x.i("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr onMsgChangeNotify updateGoBacktoHistroyMessage up UnDeliver:%d, UnRead:%d", new Object[]{Integer.valueOf(aeVar.field_UnDeliverCount), Integer.valueOf(aeVar.field_unReadCount)});
                                this.yBn.fhr.a(aeVar, true);
                            }
                        }, 500);
                    }
                }
            }
        }
    }

    public final void aQ(au auVar) {
        long j = 0;
        if (auVar != null && auVar.field_msgId != 0) {
            int i;
            long j2 = auVar.field_msgSeq;
            boolean z = (auVar.field_flag & 4) != 0;
            int i2 = 18;
            ar.Hg();
            aj WY = com.tencent.mm.z.c.Fd().WY(this.fhr.csi().field_username);
            if (WY != null) {
                long j3 = z ? WY.field_firstUnDeliverSeq : WY.field_lastSeq;
                if (z && j3 == 0) {
                    i2 = WY.field_UnDeliverCount;
                    j = j3;
                } else {
                    j = j3;
                }
            }
            x.i("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr getChatroomMsgWithFaultMsg filterSeq[%d], lastSeq[%d], needCount[%d], flag[%d], up[%b]", new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(auVar.field_flag), Boolean.valueOf(z)});
            this.yBi = false;
            String str = this.fhr.csi().field_username;
            int i3 = (int) j;
            int i4 = (int) j2;
            if (z) {
                i = 1;
            } else {
                i = 0;
            }
            q.Qd().a(new b.a(str, i3, i4, i2, i), (c) this);
        }
    }
}
