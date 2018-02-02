package com.tencent.mm.plugin.card.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.aod;
import com.tencent.mm.protocal.c.km;
import com.tencent.mm.protocal.c.kn;
import com.tencent.mm.protocal.c.kq;
import com.tencent.mm.protocal.c.ol;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.List;

public final class w extends k implements com.tencent.mm.network.k {
    private final b gJQ;
    private e gJT;
    private byte[] hFw;
    private int kLX = 0;

    public w(int i) {
        x.d("MicroMsg.NetSceneCardSync", "<init>, selector = %d", new Object[]{Integer.valueOf(1)});
        a aVar = new a();
        aVar.hmj = new km();
        aVar.hmk = new kn();
        aVar.uri = "/cgi-bin/micromsg-bin/cardsync";
        aVar.hmi = 558;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        aod com_tencent_mm_protocal_c_aod = new aod();
        ar.Hg();
        com_tencent_mm_protocal_c_aod.kNf = (String) c.CU().get(com.tencent.mm.storage.w.a.xoh, null);
        com_tencent_mm_protocal_c_aod.latitude = (double) am.auG().gyz;
        com_tencent_mm_protocal_c_aod.longitude = (double) am.auG().gyA;
        km kmVar = (km) this.gJQ.hmg.hmo;
        kmVar.vRz = 1;
        kmVar.vRB = com_tencent_mm_protocal_c_aod;
        kmVar.vRC = i;
        this.kLX = i;
    }

    public final int getType() {
        return 558;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        km kmVar = (km) this.gJQ.hmg.hmo;
        ar.Hg();
        this.hFw = bh.VD(bh.ou((String) c.CU().get(282880, null)));
        if (this.hFw == null || this.hFw.length == 0) {
            x.e("MicroMsg.NetSceneCardSync", "doScene, keyBuf is null, init card sync~~~");
        }
        kmVar.vRA = n.N(this.hFw);
        String str = "MicroMsg.NetSceneCardSync";
        String str2 = "doScene, keyBuf.length = %d";
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(this.hFw == null ? 0 : this.hFw.length);
        x.i(str, str2, objArr);
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneCardSync", "onGYNetEnd, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            kn knVar = (kn) this.gJQ.hmh.hmo;
            if (knVar.vRE == 1) {
                x.i("MicroMsg.NetSceneCardSync", "need do getCardsLayoutScene");
            }
            this.hFw = n.a(knVar.vRA, new byte[0]);
            List<ol> list = knVar.vRD == null ? null : knVar.vRD.ksP;
            String str2 = "MicroMsg.NetSceneCardSync";
            String str3 = "onGYNetEnd, cmd list size = %d, synckey length = %d, continueFlag = %d";
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(list == null ? 0 : list.size());
            objArr[1] = Integer.valueOf(this.hFw == null ? 0 : this.hFw.length);
            objArr[2] = Integer.valueOf(knVar.vPq);
            x.i(str2, str3, objArr);
            if (list == null || list.size() <= 0) {
                x.i("MicroMsg.NetSceneCardSync", "cmdList == null or size is 0");
                com.tencent.mm.plugin.card.a.b auz = am.auz();
                x.i("MicroMsg.BatchGetCardMgr", "retryAll, getNow = %b", new Object[]{Boolean.valueOf(true)});
                synchronized (auz.gSF) {
                    auz.kIs.addAll(auz.kIt);
                    auz.kIt.clear();
                }
                auz.atO();
            } else {
                int i4 = 0;
                for (ol a : list) {
                    int i5;
                    if (a(a)) {
                        i5 = i4;
                    } else {
                        i5 = i4 + 1;
                    }
                    i4 = i5;
                }
                x.i("MicroMsg.NetSceneCardSync", "onGYNetEnd, %d fail cmds", new Object[]{Integer.valueOf(i4)});
                am.auz().atO();
            }
            ar.Hg();
            c.CU().set(282880, bh.by(this.hFw));
            if (knVar.vPq > 0) {
                x.d("MicroMsg.NetSceneCardSync", "onGYNetEnd, should continue, continueFlag = %d", new Object[]{Integer.valueOf(knVar.vPq)});
                if (a(this.hmA, this.gJT) <= 0) {
                    x.e("MicroMsg.NetSceneCardSync", "onGYNetEnd, doScene again fail, ret = %d", new Object[]{Integer.valueOf(a(this.hmA, this.gJT))});
                    this.gJT.a(3, -1, str, this);
                    return;
                }
                return;
            }
            this.gJT.a(0, 0, str, this);
            return;
        }
        x.e("MicroMsg.NetSceneCardSync", "onGYNetEnd, card sync fail, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.gJT.a(i2, i3, str, this);
    }

    private static boolean a(ol olVar) {
        if (olVar == null) {
            x.e("MicroMsg.NetSceneCardSync", "processCmdItem fail, null cmd");
            return false;
        }
        byte[] a = n.a(olVar.vXq);
        if (a == null || a.length == 0) {
            x.e("MicroMsg.NetSceneCardSync", "processCmdItem fail, null buf");
            return false;
        }
        x.d("MicroMsg.NetSceneCardSync", "processCmdItem, buf length = %d, cmdId = %d", new Object[]{Integer.valueOf(a.length), Integer.valueOf(olVar.vXp)});
        try {
            switch (olVar.vXp) {
                case 1:
                    kq kqVar = (kq) new kq().aF(a);
                    x.i("MicroMsg.NetSceneCardSync", "processCmdIem, card user item, Status = %d", new Object[]{Integer.valueOf(kqVar.ktm)});
                    switch (kqVar.ktm) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 7:
                            com.tencent.mm.plugin.card.a.b auz = am.auz();
                            if (kqVar != null) {
                                long j;
                                CardInfo wf = am.auA().wf(kqVar.vSu);
                                String str = "MicroMsg.BatchGetCardMgr";
                                String str2 = "pushCardUserItem, cardUserId = %s, localSeq = %d, svrSeq = %d";
                                Object[] objArr = new Object[3];
                                objArr[0] = kqVar.vSu;
                                if (wf == null) {
                                    j = 0;
                                } else {
                                    j = wf.field_updateSeq;
                                }
                                objArr[1] = Long.valueOf(j);
                                objArr[2] = Long.valueOf(kqVar.vSv);
                                x.i(str, str2, objArr);
                                if (wf != null && wf.field_updateSeq == kqVar.vSv) {
                                    x.e("MicroMsg.BatchGetCardMgr", "push CardUserItem fail, card.field_updateSeq == item.UpdateSequence");
                                    break;
                                }
                                com.tencent.mm.sdk.e.c a2 = ak.a(kqVar);
                                synchronized (auz.gSF) {
                                    if (!auz.kIs.contains(a2)) {
                                        if (!auz.kIt.contains(a2)) {
                                            auz.kIs.add(a2);
                                            boolean b = am.auB().b(a2);
                                            x.i("MicroMsg.BatchGetCardMgr", "pushCardUserItem, insertRet = %b", new Object[]{Boolean.valueOf(b)});
                                            break;
                                        }
                                        break;
                                    }
                                    break;
                                }
                            }
                            x.e("MicroMsg.BatchGetCardMgr", "push fail, CardUserItem is null");
                            break;
                            break;
                        case 6:
                            break;
                        default:
                            x.e("MicroMsg.NetSceneCardSync", "processCmdIem, card user item, unknown StateFlag = %d", new Object[]{Integer.valueOf(kqVar.vSw)});
                            return false;
                    }
                    return true;
                default:
                    x.w("MicroMsg.NetSceneCardSync", "processCmdItem, unknown cmdId = %d", new Object[]{Integer.valueOf(olVar.vXp)});
                    return false;
            }
        } catch (Exception e) {
            x.e("MicroMsg.NetSceneCardSync", "processCmdItem fail, ex = %s", new Object[]{e.getMessage()});
            return false;
        }
        x.e("MicroMsg.NetSceneCardSync", "processCmdItem fail, ex = %s", new Object[]{e.getMessage()});
        return false;
    }
}
