package com.tencent.mm.modelmulti;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.k;
import com.tencent.mm.ae.u.a;
import com.tencent.mm.g.b.aj;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.report.d;
import com.tencent.mm.protocal.c.aas;
import com.tencent.mm.protocal.c.aat;
import com.tencent.mm.protocal.c.bw;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.Collections;
import java.util.LinkedList;

class b$3 implements a {
    final /* synthetic */ b hEG;

    b$3(b bVar) {
        this.hEG = bVar;
    }

    public final int a(int i, int i2, String str, b bVar, k kVar) {
        x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr callback [%d,%d,%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (kVar.getType() != 805) {
            return 0;
        }
        d.pPH.a(403, 10, 1, false);
        this.hEG.hkG = false;
        if (i == 0 && i2 == 0 && bVar != null) {
            aas com_tencent_mm_protocal_c_aas = (aas) bVar.hmg.hmo;
            aat com_tencent_mm_protocal_c_aat = (aat) bVar.hmh.hmo;
            String a = n.a(com_tencent_mm_protocal_c_aas.wjI);
            String str2;
            if (com_tencent_mm_protocal_c_aas.vHf == 0) {
                String str3 = "MicroMsg.GetChatRoomMsgService";
                str2 = "summerbadcr clear chatroomId[%s], resp size[%d], ContinueFlag[%d]";
                Object[] objArr = new Object[3];
                objArr[0] = a;
                objArr[1] = Integer.valueOf(com_tencent_mm_protocal_c_aat.wjN == null ? -1 : com_tencent_mm_protocal_c_aat.wjN.size());
                objArr[2] = Integer.valueOf(com_tencent_mm_protocal_c_aat.vPq);
                x.i(str3, str2, objArr);
                if (this.hEG.hyD.cfK()) {
                    this.hEG.hyD.J(500, 500);
                }
                d.pPH.a(403, 12, 1, false);
                return 0;
            }
            int cfD;
            String str4;
            int i3;
            x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr callback req chatroomId[%s], resp ContinueFlag[%d]", new Object[]{a, Integer.valueOf(com_tencent_mm_protocal_c_aat.vPq)});
            b bVar2 = this.hEG;
            boolean z = HardCoderJNI.hcReceiveMsgEnable;
            int i4 = HardCoderJNI.hcReceiveMsgDelay;
            int i5 = HardCoderJNI.hcReceiveMsgCPU;
            int i6 = HardCoderJNI.hcReceiveMsgIO;
            if (HardCoderJNI.hcReceiveMsgThr) {
                cfD = g.Dm().cfD();
            } else {
                cfD = 0;
            }
            bVar2.hEF = HardCoderJNI.startPerformance(z, i4, i5, i6, cfD, HardCoderJNI.hcReceiveMsgTimeout, 201, HardCoderJNI.hcReceiveMsgAction, "MicroMsg.GetChatRoomMsgService");
            synchronized (this.hEG.hEB) {
                if (this.hEG.hED == null || t.ov(this.hEG.hED.PU())) {
                    this.hEG.hEB.clear();
                    this.hEG.hED = null;
                    x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr callback currentListener is or its chatroomid is null so clear map");
                    d.pPH.a(403, 15, 1, false);
                } else if (this.hEG.hED.PU().equals(a)) {
                    d.pPH.a(403, 13, 1, false);
                    LinkedList linkedList = com_tencent_mm_protocal_c_aat.wjN;
                    str4 = "MicroMsg.GetChatRoomMsgService";
                    String str5 = "summerbadcr callback currentListener still in and resp.ContinueFlag[%d], size[%d]";
                    Object[] objArr2 = new Object[2];
                    objArr2[0] = Integer.valueOf(com_tencent_mm_protocal_c_aat.vPq);
                    objArr2[1] = Integer.valueOf(linkedList == null ? -1 : linkedList.size());
                    x.i(str4, str5, objArr2);
                    if (!(com_tencent_mm_protocal_c_aat.vPq <= 0 || linkedList == null || linkedList.isEmpty())) {
                        i5 = ((bw) linkedList.getFirst()).vHf;
                        i3 = ((bw) linkedList.getLast()).vHf;
                        x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr callback ContinueFlag[%d], list size[%d],firstSeq[%d], lastSeq[%d], UpDownFlag[%d]", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_aat.vPq), Integer.valueOf(linkedList.size()), Integer.valueOf(i5), Integer.valueOf(i3), Integer.valueOf(com_tencent_mm_protocal_c_aas.wjK)});
                    }
                } else {
                    x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr callback currentListener changed current[%s], old[%s]", new Object[]{this.hEG.hED.PU(), a});
                    d.pPH.a(403, 14, 1, false);
                }
            }
            if (this.hEG.hyD.cfK()) {
                this.hEG.hyD.J(500, 500);
            }
            if (com_tencent_mm_protocal_c_aat.wjN == null || com_tencent_mm_protocal_c_aat.wjN.isEmpty()) {
                d.pPH.a(403, 19, 1, false);
                str2 = "MicroMsg.GetChatRoomMsgService";
                str4 = "summerbadcr callback resp.AddMsgList is null[%b], empty[%b]";
                Object[] objArr3 = new Object[2];
                objArr3[0] = Boolean.valueOf(this.hEG.hyz == null);
                objArr3[1] = Boolean.valueOf(this.hEG.hyz != null ? this.hEG.hyz.isEmpty() : true);
                x.i(str2, str4, objArr3);
                if (com_tencent_mm_protocal_c_aat.vPq == 0 && com_tencent_mm_protocal_c_aas.wjK != 0) {
                    ar.Hg();
                    cf G = c.Fa().G(a, (long) com_tencent_mm_protocal_c_aas.vHf);
                    int i7;
                    if (G.field_msgSeq == ((long) com_tencent_mm_protocal_c_aas.vHf)) {
                        i7 = G.field_flag;
                        x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr callback resp.AddMsgList is empty reset Fault[%d, %d, %d, %d, %d, %d, %d]", new Object[]{Integer.valueOf(G.field_flag), Integer.valueOf(G.field_isSend), Long.valueOf(G.field_msgId), Long.valueOf(G.field_msgSvrId), Long.valueOf(G.field_msgSeq), Long.valueOf(G.field_createTime), Integer.valueOf(G.getType())});
                        if ((i7 & 1) != 0) {
                            long j;
                            G.fa(i7 & -2);
                            ar.Hg();
                            c.Fa().a(G.field_msgId, G);
                            d dVar = d.pPH;
                            if (t.bz(G.field_createTime) < 259200000) {
                                j = 36;
                            } else {
                                j = 37;
                            }
                            dVar.a(403, j, 1, false);
                        }
                    } else {
                        ar.Hg();
                        aj WY = c.Fd().WY(a);
                        if (WY != null) {
                            ar.Hg();
                            cf Ey = c.Fa().Ey(a);
                            if (Ey != null) {
                                x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr callback resp.AddMsgList is empty need reset lastseq by last receive id[%d] svrid[%d], flag[%d] createtime[%d] seq[%d -> %d]", new Object[]{Long.valueOf(Ey.field_msgId), Long.valueOf(Ey.field_msgSvrId), Integer.valueOf(Ey.field_flag), Long.valueOf(Ey.field_createTime), Long.valueOf(WY.field_lastSeq), Long.valueOf(Ey.field_msgSeq)});
                                WY.al(Ey.field_msgSeq);
                            } else {
                                x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr callback resp.AddMsgList is empty but no receive msg!");
                                WY.al(0);
                            }
                            WY.eW(0);
                            ar.Hg();
                            i7 = c.Fd().a(WY, WY.field_username, false);
                            x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr callback resp.AddMsgList is empty and update conv ret:%d", new Object[]{Integer.valueOf(i7)});
                        } else {
                            x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr callback resp.AddMsgList but conv is null!");
                        }
                    }
                }
            } else {
                boolean z2;
                boolean z3;
                b.b bVar3 = new b.b(this.hEG);
                bVar3.hEI = a;
                bVar3.hEM = com_tencent_mm_protocal_c_aas.wjK;
                bVar3.hEP = com_tencent_mm_protocal_c_aat.vPq;
                if (com_tencent_mm_protocal_c_aat.vPq == 0) {
                    bVar3.hEO = false;
                    d.pPH.a(403, 21, 1, false);
                } else {
                    d.pPH.a(403, 20, 1, false);
                }
                ar.Hg();
                aj WY2 = c.Fd().WY(a);
                if (com_tencent_mm_protocal_c_aas.wjK != 0) {
                    d.pPH.a(403, 18, (long) com_tencent_mm_protocal_c_aat.wjN.size(), false);
                    i4 = (WY2 == null ? 0 : WY2.field_UnDeliverCount) - com_tencent_mm_protocal_c_aat.wjN.size();
                    if (i4 < 0) {
                        i4 = 0;
                    }
                    if (WY2 != null) {
                        WY2.eW(i4);
                        ar.Hg();
                        i5 = c.Fd().a(WY2, WY2.field_username, false);
                        x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr callback up and FilterSeq 0 but NeedCount:%d, oldUnDeliverCount:%d, newUnDeliverCount:%d, ret:%d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_aas.wjJ), Integer.valueOf(i3), Integer.valueOf(WY2.field_UnDeliverCount), Integer.valueOf(i5)});
                    }
                    if (WY2 == null && i4 == 0) {
                        bVar3.hEO = false;
                    }
                } else {
                    if (com_tencent_mm_protocal_c_aas.wjM <= 0 || com_tencent_mm_protocal_c_aas.wjM != com_tencent_mm_protocal_c_aas.vHf) {
                        d.pPH.a(403, 16, (long) com_tencent_mm_protocal_c_aat.wjN.size(), false);
                    } else {
                        d.pPH.a(403, 17, (long) com_tencent_mm_protocal_c_aat.wjN.size(), false);
                    }
                    if (WY2 != null) {
                        i4 = WY2.field_UnDeliverCount;
                        if (i4 > 0) {
                            i3 = i4 - com_tencent_mm_protocal_c_aat.wjN.size();
                            if (i3 < 0) {
                                i3 = 0;
                            }
                            WY2.eW(i3);
                            ar.Hg();
                            i3 = c.Fd().a(WY2, WY2.field_username, false);
                            x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr callback down NeedCount:%d, oldUnDeliverCount:%d, newUnDeliverCount:%d, ret:%d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_aas.wjJ), Integer.valueOf(i4), Integer.valueOf(WY2.field_UnDeliverCount), Integer.valueOf(i3)});
                        }
                    }
                }
                ar.Hg();
                i5 = (int) c.FJ().Er(a);
                if (i5 != 0) {
                    z2 = false;
                    while (!com_tencent_mm_protocal_c_aat.wjN.isEmpty() && ((bw) com_tencent_mm_protocal_c_aat.wjN.peek()).vHf <= i5) {
                        com_tencent_mm_protocal_c_aat.wjN.poll();
                        z2 = true;
                    }
                } else {
                    z2 = false;
                }
                if (z2) {
                    bVar3.hEO = false;
                }
                if (com_tencent_mm_protocal_c_aas.wjK == 0 || com_tencent_mm_protocal_c_aat.wjN.isEmpty()) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                if (com_tencent_mm_protocal_c_aat.wjN.size() > 1 && z3) {
                    Collections.reverse(com_tencent_mm_protocal_c_aat.wjN);
                }
                if (!com_tencent_mm_protocal_c_aat.wjN.isEmpty()) {
                    bVar3.hEN = com_tencent_mm_protocal_c_aat.wjN;
                    this.hEG.hyz.add(bVar3);
                    x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr callback add resp to respList size[%d], dealFault[%b], lastDeleteSeq[%d], needReverse[%b], removed[%b]", new Object[]{Integer.valueOf(this.hEG.hyz.size()), Boolean.valueOf(bVar3.hEO), Integer.valueOf(i5), Boolean.valueOf(z3), Boolean.valueOf(z2)});
                }
            }
            if (this.hEG.hyz.isEmpty() || !this.hEG.hyE.cfK()) {
                if (this.hEG.hED != null) {
                    x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr callback resp.AddMsgList is empty[%b] stopped[%b] at last", new Object[]{Boolean.valueOf(this.hEG.hyz.isEmpty()), Boolean.valueOf(this.hEG.hyE.cfK())});
                    this.hEG.hED.ia(1);
                }
                HardCoderJNI.stopPerformace(HardCoderJNI.hcReceiveMsgEnable, this.hEG.hEF);
            } else {
                this.hEG.hyE.J(50, 50);
            }
            return 0;
        }
        x.e("MicroMsg.GetChatRoomMsgService", "summerbadcr callback errType:" + i + " errCode:" + i2 + " will retry");
        if (this.hEG.hED != null) {
            x.e("MicroMsg.GetChatRoomMsgService", "summerbadcr callback err as ret errType, errcode[%d, %d]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            this.hEG.hED.ia(1);
        }
        d.pPH.a(403, 11, 1, false);
        this.hEG.hyD.J(5000, 5000);
        return 0;
    }
}
