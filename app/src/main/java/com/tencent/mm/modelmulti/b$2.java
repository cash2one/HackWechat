package com.tencent.mm.modelmulti;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.u;
import com.tencent.mm.g.b.aj;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.report.d;
import com.tencent.mm.protocal.c.aas;
import com.tencent.mm.protocal.c.aat;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.LinkedList;

class b$2 implements a {
    final /* synthetic */ b hEG;

    b$2(b bVar) {
        this.hEG = bVar;
    }

    public final boolean uF() {
        x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr pusherTry onTimerExpired tryStartNetscene");
        b bVar = this.hEG;
        long Wp = t.Wp();
        if (bVar.hkG && Wp - bVar.hkQ > 300000) {
            x.w("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene Not Callback too long:%d . Force Run Now", new Object[]{Long.valueOf(Wp - bVar.hkQ)});
            bVar.hkG = false;
        }
        if (bVar.hkG) {
            x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene netSceneRunning: " + bVar.hkG + " ret");
        } else {
            b.a aVar;
            String str = null;
            b.a aVar2 = null;
            if (!bVar.hEC.isEmpty()) {
                aVar = (b.a) bVar.hEC.poll();
                str = aVar.hEI;
                aVar2 = aVar;
            }
            if (aVar2 == null) {
                synchronized (bVar.hEB) {
                    x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene needGetInfosMap size[%d], content[%s]", new Object[]{Integer.valueOf(bVar.hEB.size()), bVar.hEB});
                    if (bVar.hED == null || t.ov(bVar.hED.PU())) {
                        bVar.hEB.clear();
                        bVar.hED = null;
                        x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene currentListener is or its chatroomid is null ret");
                    } else {
                        str = bVar.hED.PU();
                        LinkedList linkedList = (LinkedList) bVar.hEB.get(str);
                        if (linkedList == null || linkedList.size() == 0) {
                            String str2 = "MicroMsg.GetChatRoomMsgService";
                            String str3 = "summerbadcr tryStartNetscene current talker[%s] no infos and ret infos size:%d";
                            Object[] objArr = new Object[2];
                            objArr[0] = str;
                            objArr[1] = Integer.valueOf(linkedList == null ? -1 : linkedList.size());
                            x.i(str2, str3, objArr);
                        } else {
                            while (!linkedList.isEmpty()) {
                                b.a aVar3 = (b.a) linkedList.poll();
                                if (aVar3 == null) {
                                    break;
                                }
                                ar.Hg();
                                cf G = c.Fa().G(str, (long) aVar3.hEK);
                                if (G.field_msgId == 0) {
                                    x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene get nextInfo in map not in db:" + aVar3);
                                    aVar = aVar3;
                                    break;
                                } else if ((G.field_flag & 1) != 0) {
                                    x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene get nextInfo in map in db but fault: " + aVar3 + " flag:" + G.field_flag + " seq:" + G.field_msgSeq);
                                    aVar = aVar3;
                                    break;
                                } else {
                                    x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene get nextInfo in map in db but not fault: " + aVar3 + " flag:" + G.field_flag + " seq:" + G.field_msgSeq);
                                }
                            }
                            aVar = aVar2;
                            if (aVar == null && !t.ov(str)) {
                                ar.Hg();
                                aj WY = c.Fd().WY(str);
                                if (WY != null) {
                                    long j = WY.field_lastSeq;
                                    long j2 = WY.field_firstUnDeliverSeq;
                                    int i = WY.field_UnDeliverCount;
                                    x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene filterSeq[%d], lastSeq[%d], undeliverCount[%d]", new Object[]{Long.valueOf(j2), Long.valueOf(j), Integer.valueOf(i)});
                                    if (j != 0) {
                                        ar.Hg();
                                        if (c.Fa().G(str, j).field_msgId == 0) {
                                            aVar = new b.a(str, (int) j2, (int) j, i, 1);
                                            x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene get nextInfo in db:" + aVar);
                                        } else {
                                            if (i > 0) {
                                                WY.eO(0);
                                                ar.Hg();
                                                c.Fd().a(WY, str);
                                            }
                                            x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene get nextInfo in db but has get msg id:%d, svrId:%d, undeliverCount[%d]", new Object[]{Long.valueOf(r5.field_msgId), Long.valueOf(r5.field_msgSvrId), Integer.valueOf(WY.field_UnDeliverCount)});
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } else {
                aVar = aVar2;
            }
            x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene nextInfo:" + aVar);
            if (aVar == null) {
                bVar.hyD.J(500, 500);
            } else {
                bVar.hkG = true;
                bVar.hkQ = Wp;
                com.tencent.mm.bq.a com_tencent_mm_protocal_c_aas = new aas();
                com_tencent_mm_protocal_c_aas.wjI = n.os(str);
                com_tencent_mm_protocal_c_aas.vHf = aVar.hEK;
                if (aVar.hEK == 0) {
                    com_tencent_mm_protocal_c_aas.wjJ = 0;
                    if (aVar.hEL != 0) {
                        x.w("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene msgSeq is 0 but needCount[%d], stack[%s]!", new Object[]{Integer.valueOf(aVar.hEL), t.Ws()});
                    }
                } else {
                    com_tencent_mm_protocal_c_aas.wjJ = 18;
                }
                com_tencent_mm_protocal_c_aas.wjK = aVar.hEM;
                com_tencent_mm_protocal_c_aas.wjM = aVar.hEJ;
                if ((com_tencent_mm_protocal_c_aas.wjK != 0 && com_tencent_mm_protocal_c_aas.wjM > com_tencent_mm_protocal_c_aas.vHf) || (com_tencent_mm_protocal_c_aas.wjK == 0 && com_tencent_mm_protocal_c_aas.wjM < com_tencent_mm_protocal_c_aas.vHf)) {
                    x.w("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene FilterSeq msgSeq UpDownFlag not match[%d][%d][%d], stack[%s]!", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_aas.wjM), Integer.valueOf(com_tencent_mm_protocal_c_aas.vHf), Integer.valueOf(com_tencent_mm_protocal_c_aas.wjK), t.Ws()});
                    d.pPH.a(403, com_tencent_mm_protocal_c_aas.wjK == 0 ? 0 : 1, 1, false);
                    if (bVar.hED != null) {
                        bVar.hED.ia(1);
                    }
                }
                if (com_tencent_mm_protocal_c_aas.wjK != 0 && com_tencent_mm_protocal_c_aas.wjM == 0 && aVar.hEL < 18) {
                    if (aVar.hEL > 0) {
                        com_tencent_mm_protocal_c_aas.wjJ = aVar.hEL;
                    } else {
                        com_tencent_mm_protocal_c_aas.wjJ = 1;
                        d.pPH.a(403, 3, 1, false);
                    }
                    x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene UpDownFlag FilterSeq 0 fix need nextInfo: %d req: %d", new Object[]{Integer.valueOf(aVar.hEL), Integer.valueOf(com_tencent_mm_protocal_c_aas.wjJ)});
                }
                x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene FilterSeq[%d], MsgSeq[%d], NeedCount[%d], UpDownFlag[%d], ClearFlag[%d]", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_aas.wjM), Integer.valueOf(com_tencent_mm_protocal_c_aas.vHf), Integer.valueOf(com_tencent_mm_protocal_c_aas.wjJ), Integer.valueOf(com_tencent_mm_protocal_c_aas.wjK), Integer.valueOf(com_tencent_mm_protocal_c_aas.wjL)});
                b.a aVar4 = new b.a();
                aVar4.hmj = com_tencent_mm_protocal_c_aas;
                aVar4.hmk = new aat();
                aVar4.uri = "/cgi-bin/micromsg-bin/getcrmsg";
                aVar4.hmi = 805;
                aVar4.hml = 0;
                aVar4.hmm = 0;
                d.pPH.a(403, com_tencent_mm_protocal_c_aas.vHf == 0 ? 9 : 8, 1, false);
                u.a(aVar4.JZ(), new b$3(bVar), true);
            }
        }
        return false;
    }
}
