package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.g.a.pj;
import com.tencent.mm.g.b.aj;
import com.tencent.mm.modelmulti.b.a;
import com.tencent.mm.modelmulti.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.report.d;
import com.tencent.mm.protocal.c.bx;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

class w$1 extends c<pj> {
    final /* synthetic */ w yBn;

    w$1(w wVar) {
        this.yBn = wVar;
        this.xen = pj.class.getName().hashCode();
    }

    private boolean a(pj pjVar) {
        byte[] bArr = pjVar.fHn.data;
        if (bArr != null) {
            bx bxVar = new bx();
            try {
                bxVar.aF(bArr);
                final String a = n.a(bxVar.vHg);
                x.i("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr SilenceNotifyEvent callback chatRoomId[%s], current talker[%s]", new Object[]{a, w.a(this.yBn).csi().field_username});
                if (!bh.ov(a) && a.equals(w.a(this.yBn).csi().field_username)) {
                    final int i = bxVar.vHf;
                    final int i2 = bxVar.vHh;
                    ar.Dm().F(new Runnable(this) {
                        final /* synthetic */ w$1 yBq;

                        public final void run() {
                            int i;
                            int i2;
                            long j;
                            x.i("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr SilenceNotifyEvent in chatting lastSeq[%d], undeliverCount[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                            long j2 = (long) i;
                            long j3 = (long) i;
                            int i3 = i2;
                            ar.Hg();
                            aj WY = com.tencent.mm.z.c.Fd().WY(a);
                            if (WY == null || WY.field_lastSeq != ((long) i) || WY.field_UnDeliverCount <= 1) {
                                d.pPH.a(403, 4, 1, false);
                                i = 0;
                                i2 = i3;
                                j = j2;
                            } else {
                                int i4 = WY.field_UnDeliverCount;
                                long j4 = WY.field_firstUnDeliverSeq;
                                if (WY.field_lastSeq - j4 >= ((long) i4)) {
                                    x.i("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr SilenceNotifyEvent in chatting change up [%d, %d, %d, %d]", new Object[]{Long.valueOf(j4), Long.valueOf(j3), Integer.valueOf(i4), Integer.valueOf(1)});
                                    d.pPH.a(403, 2, 1, false);
                                    i = 1;
                                    i2 = i4;
                                    j = j4;
                                } else {
                                    d.pPH.a(403, 4, 1, false);
                                    i = 0;
                                    i2 = i3;
                                    j = j2;
                                }
                            }
                            this.yBq.yBn.yBi = false;
                            q.Qd().a(new a(a, (int) j, (int) j3, i2, i), this.yBq.yBn);
                        }
                    });
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.ChattingUI.SilenceMsgImp", e, "summerbadcr SilenceNotifyEvent callback parse:", new Object[0]);
            }
        } else {
            x.e("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr silenceNotifyListener callback event data is null");
        }
        return false;
    }
}
