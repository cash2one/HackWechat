package com.tencent.mm.plugin.voip;

import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.g.a.sp;
import com.tencent.mm.g.a.sp.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.voip.model.d;
import com.tencent.mm.plugin.voip.model.h;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.m;
import com.tencent.mm.plugin.voip.model.n;
import com.tencent.mm.protocal.c.buj;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.nio.ByteBuffer;

public final class a extends c<sp> {
    public a() {
        this.xen = sp.class.getName().hashCode();
    }

    private static boolean a(sp spVar) {
        boolean z = true;
        if ((spVar instanceof sp) && ar.Hj()) {
            m bGj;
            Object obj;
            Object obj2;
            buj com_tencent_mm_protocal_c_buj;
            n nVar;
            switch (spVar.fKq.fuL) {
                case 1:
                    d.bGj();
                    com.tencent.mm.plugin.voip.model.i.a MC = m.MC(spVar.fKq.content);
                    if (MC != null) {
                        if (!MC.bGI()) {
                            if (MC.slD != com.tencent.mm.plugin.voip.model.i.a.slJ) {
                                z = false;
                            }
                            if (z) {
                                spVar.fKr.type = 3;
                                break;
                            }
                        }
                        spVar.fKr.type = 2;
                        break;
                    }
                    break;
                case 2:
                    spVar.fKr.fKs = d.bGj().fju;
                    break;
                case 3:
                    bGj = d.bGj();
                    obj = spVar.fKq.fKk;
                    if (obj != null && obj.length >= 10 && obj[0] == (byte) 1) {
                        obj2 = new byte[(obj.length - 1)];
                        System.arraycopy(obj, 1, obj2, 0, obj2.length);
                        h hVar = bGj.smS.siL.ske.spH;
                        hVar.slx = System.currentTimeMillis();
                        com.tencent.mm.plugin.voip.b.a.eu("MicroMsg.VoipDailReport", "devin:recvInvite:" + hVar.slx);
                        try {
                            buj com_tencent_mm_protocal_c_buj2 = (buj) new buj().aF(obj2);
                            x.d("MicroMsg.Voip.VoipService", "doTaskCallin in onInviteNotify");
                            if (!bGj.smS.bHA()) {
                                g.pQN.a(11523, true, true, new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_buj2.wbh), Long.valueOf(com_tencent_mm_protocal_c_buj2.wbi), Integer.valueOf(com_tencent_mm_protocal_c_buj2.wVl), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis())});
                                bGj.a(com_tencent_mm_protocal_c_buj2);
                                break;
                            }
                            g.pQN.a(11523, true, true, new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_buj2.wbh), Long.valueOf(com_tencent_mm_protocal_c_buj2.wbi), Integer.valueOf(com_tencent_mm_protocal_c_buj2.wVl), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis())});
                            break;
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.Voip.VoipService", e, "", new Object[0]);
                            break;
                        }
                    }
                case 4:
                    b bVar = spVar.fKr;
                    m bGj2 = d.bGj();
                    Context context = ac.getContext();
                    if (bGj2.fju && bGj2.snd && !bGj2.sne) {
                        x.d("MicroMsg.Voip.VoipService", "isVideoCalling " + bGj2.smU + " isAudioCalling " + bGj2.smV);
                        if (!bh.ov(bGj2.talker)) {
                            ar.Hg();
                            if (com.tencent.mm.z.c.EY().WO(bGj2.talker) != null) {
                                m.a(context, bGj2.talker, true, bGj2.smU, true);
                                bVar.fKt = z;
                                break;
                            }
                        }
                    }
                    z = false;
                    bVar.fKt = z;
                case 5:
                    if (!com.tencent.mm.p.a.AW()) {
                        if (spVar.fKq.fKl != 2) {
                            if (spVar.fKq.fKl != 3) {
                                if (spVar.fKq.fKl == 4) {
                                    l.aD(spVar.fKq.context, spVar.fKq.talker);
                                    break;
                                }
                            }
                            l.aC(spVar.fKq.context, spVar.fKq.talker);
                            break;
                        }
                        l.aB(spVar.fKq.context, spVar.fKq.talker);
                        break;
                    }
                    com.tencent.mm.ui.base.h.h(spVar.fKq.context, R.l.ewq, R.l.dGO);
                    break;
                    break;
                case 6:
                    bGj = d.bGj();
                    byte[] bArr = spVar.fKq.fKk;
                    if (bArr != null) {
                        x.i("MicroMsg.Voip.VoipService", "____voipNotify with data size:" + bArr.length);
                        int i = ByteBuffer.wrap(bArr, 0, 4).getInt();
                        long j = ByteBuffer.wrap(bArr, 4, 8).getLong();
                        x.i("MicroMsg.Voip.VoipService", "voipNotify roomid:" + i + " roomkey:" + j);
                        if (bGj.snf == null) {
                            x.i("MicroMsg.Voip.VoipServiceEx", "current roomid:%d, params roomid:%d", new Object[]{Integer.valueOf(bGj.smS.siL.ske.nDx), Integer.valueOf(i)});
                            if (i == 0 || r5.siL.ske.nDx != i) {
                                z = false;
                            }
                            if (!z) {
                                x.e("MicroMsg.Voip.VoipService", "voipSyncStatus ignored , not current roomid");
                                break;
                            }
                        }
                        if (bArr.length > 12) {
                            bGj.b(m.M(bArr, bArr.length - 12), i, j);
                        }
                        n nVar2 = bGj.smS;
                        com.tencent.mm.plugin.voip.b.a.et("MicroMsg.Voip.VoipServiceEx", com.tencent.mm.compatible.util.g.zh() + " need doSync by notify, status:" + nVar2.siL.mStatus);
                        nVar2.siL.skh.a(null, false, 7);
                        break;
                    }
                    x.i("MicroMsg.Voip.VoipService", "sidney:notify content null");
                    break;
                case 9:
                    bGj = d.bGj();
                    obj = spVar.fKq.fKk;
                    if (!bh.bw(obj) && obj[0] == (byte) 3) {
                        try {
                            x.i("MicroMsg.Voip.VoipService", "onCancelNotify");
                            obj2 = new byte[(obj.length - 1)];
                            System.arraycopy(obj, 1, obj2, 0, obj2.length);
                            com_tencent_mm_protocal_c_buj = new buj();
                            com_tencent_mm_protocal_c_buj.aF(obj2);
                            bGj.yG(com_tencent_mm_protocal_c_buj.wbh);
                            if (!(bGj.snf == null || com_tencent_mm_protocal_c_buj.wbh != bGj.snf.wbh || bGj.oGv.cfK())) {
                                bGj.snf = null;
                                bGj.sng = 0;
                                bGj.oGv.TG();
                            }
                            nVar = bGj.smS;
                            x.i("MicroMsg.Voip.VoipServiceEx", "onCancelInviteNotify, roomId: %s", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_buj.wbh)});
                            if (nVar.siL.skj != null && com_tencent_mm_protocal_c_buj.wbh == nVar.siL.skj.wbh) {
                                nVar.bHF();
                                nVar.siL.shutdown();
                                break;
                            }
                        } catch (Exception e2) {
                            x.e("MicroMsg.Voip.VoipService", "onCancelNotify error: %s", new Object[]{e2.getMessage()});
                            break;
                        }
                    }
                case 10:
                    bGj = d.bGj();
                    obj = spVar.fKq.fKk;
                    if (!bh.bw(obj) && obj[0] == (byte) 2) {
                        try {
                            x.i("MicroMsg.Voip.VoipService", "onAnswerNotify");
                            obj2 = new byte[(obj.length - 1)];
                            System.arraycopy(obj, 1, obj2, 0, obj2.length);
                            com_tencent_mm_protocal_c_buj = new buj();
                            com_tencent_mm_protocal_c_buj.aF(obj2);
                            nVar = bGj.smS;
                            x.i("MicroMsg.Voip.VoipServiceEx", "onAnswerNotify, roomId: %s", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_buj.wbh)});
                            if (com_tencent_mm_protocal_c_buj.wbh == nVar.siL.skj.wbh) {
                                if (!nVar.siL.fDV) {
                                    x.i("MicroMsg.Voip.VoipServiceEx", "onAnswerNotify, not accept, hangout");
                                    nVar.bHF();
                                    nVar.siL.shutdown();
                                    break;
                                }
                                x.i("MicroMsg.Voip.VoipServiceEx", "onAnswerNotify, already accept, ignore it");
                                break;
                            }
                        } catch (Exception e22) {
                            x.e("MicroMsg.Voip.VoipService", "onAnswerNotify error: %s", new Object[]{e22.getMessage()});
                            break;
                        }
                    }
                    break;
                default:
                    break;
            }
        }
        return false;
    }
}
