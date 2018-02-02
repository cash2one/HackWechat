package com.tencent.mm.modelmulti;

import com.tencent.mm.ae.d;
import com.tencent.mm.g.b.aj;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.modelmulti.b.b;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.bbom.q;
import com.tencent.mm.plugin.messenger.foundation.a.g;
import com.tencent.mm.protocal.c.bw;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.HashMap;
import java.util.LinkedList;

class b$4 implements a {
    final /* synthetic */ b hEG;
    private g hEH;

    b$4(b bVar) {
        this.hEG = bVar;
    }

    public final boolean uF() {
        ar.Hg();
        c.Fa().Et("MicroMsg.GetChatRoomMsgService" + this.hEG.hashCode());
        if (this.hEG.hyz.isEmpty()) {
            x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler queue maybe this time is null and return!");
            ar.Hg();
            c.Fa().Eu("MicroMsg.GetChatRoomMsgService" + this.hEG.hashCode());
            HardCoderJNI.stopPerformace(HardCoderJNI.hcReceiveMsgEnable, this.hEG.hEF);
            return false;
        }
        boolean z;
        long Wp = t.Wp();
        int i = (this.hEG.hkG ? 9 : 18) + 1;
        x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler start maxCnt[%d]", new Object[]{Integer.valueOf(i)});
        int i2 = 0;
        while (i2 < i) {
            b bVar = (b) this.hEG.hyz.peek();
            if (bVar == null) {
                x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler queue maybe this time is null and break! currentListener[%s]", new Object[]{this.hEG.hED});
                ar.Hg();
                c.Fa().Eu("MicroMsg.GetChatRoomMsgService" + this.hEG.hashCode());
                z = false;
                if (this.hEG.hED != null) {
                    this.hEG.hED.ia(0);
                }
                HardCoderJNI.stopPerformace(HardCoderJNI.hcReceiveMsgEnable, this.hEG.hEF);
                this.hEG.hyD.J(0, 0);
            } else {
                LinkedList linkedList = bVar.hEN;
                int size = linkedList.size();
                int i3 = size - 1;
                int i4 = bVar.hyM;
                if (size <= i4) {
                    this.hEG.hyz.poll();
                    if (this.hEG.hyz.isEmpty()) {
                        b.e(new HashMap(this.hEG.hEE), bVar.hEI);
                        ar.Hg();
                        c.Fa().Eu("MicroMsg.GetChatRoomMsgService" + this.hEG.hashCode());
                        String str = "MicroMsg.GetChatRoomMsgService";
                        String str2 = "summerbadcr respHandler resp proc fin gr.curIdx:%d size:%d and retList is empty break currentListener[%s], needCallBack[%b]";
                        Object[] objArr = new Object[4];
                        objArr[0] = Integer.valueOf(i4);
                        objArr[1] = Integer.valueOf(size);
                        objArr[2] = this.hEG.hED;
                        objArr[3] = Boolean.valueOf(this.hEG.hED == null ? false : this.hEG.hED.PV());
                        x.i(str, str2, objArr);
                        z = false;
                        if (this.hEG.hED != null) {
                            this.hEG.hED.ia(0);
                        }
                        this.hEG.hyD.J(0, 0);
                    } else {
                        x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler resp proc fin gr.curIdx:%d size:%d and retList is not empty continue next", new Object[]{Integer.valueOf(i4), Integer.valueOf(size)});
                    }
                } else {
                    boolean z2;
                    int i5;
                    cf G;
                    long j;
                    cf G2;
                    bw bwVar = (bw) linkedList.get(i4);
                    x.d("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler process curIdx[%d] last[%d] dealFault[%b] MsgSeq[%d], CreateTime[%d], MsgType[%d]", new Object[]{Integer.valueOf(i4), Integer.valueOf(i3), Boolean.valueOf(bVar.hEO), Integer.valueOf(bwVar.vHf), Integer.valueOf(bwVar.pbl), Integer.valueOf(bwVar.ngq)});
                    boolean z3 = false;
                    int i6 = -1;
                    if (bVar.hEO && i4 == i3) {
                        if (bVar.hEP != 0) {
                            z2 = true;
                            i5 = -1;
                        } else {
                            ar.Hg();
                            if (c.Fa().G(bVar.hEI, (long) bwVar.vHf).field_msgId == 0) {
                                ar.Hg();
                                aj WY = c.Fd().WY(bVar.hEI);
                                if (WY == null) {
                                    z2 = true;
                                    i5 = -1;
                                } else {
                                    if (!(bVar.hEM == 0 || WY.field_firstUnDeliverSeq == ((long) bwVar.vHf)) || (bVar.hEM == 0 && WY.field_lastSeq != ((long) bwVar.vHf))) {
                                        z3 = true;
                                        i6 = WY.field_UnDeliverCount;
                                    }
                                    z2 = z3;
                                    i5 = i6;
                                }
                            } else {
                                x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler process existed curIdx == last[%d], MsgSeq[%d], flag[%d]", new Object[]{Integer.valueOf(i4), Long.valueOf(c.Fa().G(bVar.hEI, (long) bwVar.vHf).field_msgSeq), Integer.valueOf(c.Fa().G(bVar.hEI, (long) bwVar.vHf).field_flag)});
                            }
                        }
                        x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler process fault[%b] curIdx[%d] last[%d], upFlag[%d]，MsgSeq[%d]", new Object[]{Boolean.valueOf(z2), Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(bVar.hEM), Integer.valueOf(bwVar.vHf)});
                        if (this.hEH == null) {
                            this.hEH = (g) com.tencent.mm.kernel.g.h(g.class);
                        }
                        this.hEH.a(new d.a(bwVar, true, z2, bVar.hEM == 0), new q(true));
                        if (z2 && r5 == 0 && size > 1 && bVar.hEM == 0) {
                            ar.Hg();
                            G = c.Fa().G(bVar.hEI, (long) bwVar.vHf);
                            i5 = G.field_flag;
                            j = G.field_createTime;
                            x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler process check fault meet size[%d], seq[%d], flag[%d], creatTime[%d]", new Object[]{Integer.valueOf(size), Integer.valueOf(bwVar.vHf), Integer.valueOf(i5), Long.valueOf(j)});
                            if ((i5 & 4) == 0) {
                                ar.Hg();
                                G2 = c.Fa().G(bVar.hEI, (long) (bwVar.vHf + 1));
                                if (G2.field_msgId == 0 && G2.field_msgSeq == ((long) (bwVar.vHf + 1))) {
                                    x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler process check fault meet seq[%d], creatTime[%d], flag[%d]", new Object[]{Long.valueOf(G2.field_msgSeq), Long.valueOf(G2.field_createTime), Integer.valueOf(G2.field_flag)});
                                    if ((G2.field_flag & 4) != 0) {
                                        G.fa(G.field_flag & -2);
                                        ar.Hg();
                                        c.Fa().a(G.field_msgId, G);
                                        G2.fa(G2.field_flag & -2);
                                        ar.Hg();
                                        c.Fa().a(G2.field_msgId, G2);
                                        x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler process check fault meet update succ!");
                                        com.tencent.mm.plugin.report.d.pPH.a(403, 34, 1, false);
                                    }
                                } else {
                                    x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler process check fault meet nextinfo is null[%b], id[%d], seq[%d]", new Object[]{Boolean.valueOf(false), Long.valueOf(G2.field_msgId), Long.valueOf(G2.field_msgSeq)});
                                }
                            }
                        }
                        bVar.hyM++;
                    }
                    z2 = false;
                    i5 = -1;
                    x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler process fault[%b] curIdx[%d] last[%d], upFlag[%d]，MsgSeq[%d]", new Object[]{Boolean.valueOf(z2), Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(bVar.hEM), Integer.valueOf(bwVar.vHf)});
                    if (this.hEH == null) {
                        this.hEH = (g) com.tencent.mm.kernel.g.h(g.class);
                    }
                    if (bVar.hEM == 0) {
                    }
                    this.hEH.a(new d.a(bwVar, true, z2, bVar.hEM == 0), new q(true));
                    ar.Hg();
                    G = c.Fa().G(bVar.hEI, (long) bwVar.vHf);
                    i5 = G.field_flag;
                    j = G.field_createTime;
                    x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler process check fault meet size[%d], seq[%d], flag[%d], creatTime[%d]", new Object[]{Integer.valueOf(size), Integer.valueOf(bwVar.vHf), Integer.valueOf(i5), Long.valueOf(j)});
                    if ((i5 & 4) == 0) {
                        ar.Hg();
                        G2 = c.Fa().G(bVar.hEI, (long) (bwVar.vHf + 1));
                        if (G2.field_msgId == 0) {
                        }
                        x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler process check fault meet nextinfo is null[%b], id[%d], seq[%d]", new Object[]{Boolean.valueOf(false), Long.valueOf(G2.field_msgId), Long.valueOf(G2.field_msgSeq)});
                    }
                    bVar.hyM++;
                }
                i2++;
            }
            x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler onTimerExpired netSceneRunning:" + this.hEG.hkG + " ret:" + z + " maxCnt:" + i + " take:" + (t.Wp() - Wp) + "ms");
            return z;
        }
        z = true;
        x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler onTimerExpired netSceneRunning:" + this.hEG.hkG + " ret:" + z + " maxCnt:" + i + " take:" + (t.Wp() - Wp) + "ms");
        return z;
    }
}
