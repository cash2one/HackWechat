package com.tencent.mm.plugin.voip_cs.b.c;

import android.telephony.TelephonyManager;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip_cs.b.c;
import com.tencent.mm.protocal.c.btv;
import com.tencent.mm.protocal.c.btw;
import com.tencent.mm.protocal.c.btx;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.util.LinkedList;

public final class e extends k implements com.tencent.mm.network.k {
    public b gJQ;
    private com.tencent.mm.ae.e gJT;

    public e(long j, long j2) {
        int i;
        com.tencent.mm.plugin.voip.model.k bHh;
        byte[] bArr;
        a aVar = new a();
        aVar.hmj = new btw();
        aVar.hmk = new btx();
        aVar.uri = "/cgi-bin/micromsg-bin/csvoipreport";
        aVar.hmi = 312;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        btw com_tencent_mm_protocal_c_btw = (btw) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_btw.wUT = j;
        com_tencent_mm_protocal_c_btw.wbi = j2;
        LinkedList linkedList = com_tencent_mm_protocal_c_btw.wVj;
        c bIU = com.tencent.mm.plugin.voip_cs.b.b.bIU();
        btv com_tencent_mm_protocal_c_btv = new btv();
        com_tencent_mm_protocal_c_btv.ktN = 1;
        com_tencent_mm_protocal_c_btv.wVi = bIU.nFf;
        x.i("MicroMsg.VoipCSReportHelper", "getVoipCSChannelReportData, result: %s", new Object[]{com_tencent_mm_protocal_c_btv.wVi});
        linkedList.add(com_tencent_mm_protocal_c_btv);
        com_tencent_mm_protocal_c_btw.wVj.add(com.tencent.mm.plugin.voip_cs.b.b.bIU().bIW());
        LinkedList linkedList2 = com_tencent_mm_protocal_c_btw.wVj;
        c bIU2 = com.tencent.mm.plugin.voip_cs.b.b.bIU();
        btv com_tencent_mm_protocal_c_btv2 = new btv();
        com_tencent_mm_protocal_c_btv2.ktN = 3;
        bIU2.sou = ar.Hh().xW();
        bIU2.yY(com.tencent.mm.plugin.voip_cs.b.a.a.bJa().snl.bIH());
        int i2 = bIU2.saT & 255;
        bIU2.spG = i2;
        bIU2.spG = i2;
        bIU2.swB = com.tencent.mm.plugin.voip_cs.b.b.bIS().nEG.field_audioDuration;
        bIU2.swC = com.tencent.mm.plugin.voip_cs.b.b.bIS().nEG.field_videoDuration;
        if (bIU2.swf != 1 && bIU2.swN != 1) {
            bIU2.swt = 1;
        } else if (bIU2.swf != 1) {
            bIU2.swt = 2;
        } else if (bIU2.swN != 1) {
            bIU2.swt = 3;
        } else {
            bIU2.swt = 0;
        }
        bIU2.swm = com.tencent.mm.plugin.voip.b.a.getNetType(ac.getContext());
        v2protocal com_tencent_mm_plugin_voip_model_v2protocal = com.tencent.mm.plugin.voip_cs.b.b.bIS().nEG;
        com_tencent_mm_plugin_voip_model_v2protocal.setJNIAppCmd(1, com_tencent_mm_plugin_voip_model_v2protocal.spo, com_tencent_mm_plugin_voip_model_v2protocal.spo.length);
        i2 = (int) (v2protocal.aP(com_tencent_mm_plugin_voip_model_v2protocal.spo) / 1000);
        i2 = (bIU2.swI == 0 || i2 <= bIU2.swI) ? 0 : i2 - bIU2.swI;
        bIU2.swA = (long) i2;
        com_tencent_mm_protocal_c_btv2.wVi = bIU2.soo + "," + bIU2.swj + "," + bIU2.nDy + "," + bIU2.swk + "," + bIU2.swl + "," + bIU2.sob + "," + bIU2.swm + "," + bIU2.swn + "," + bIU2.swo + "," + bIU2.swp + "," + bIU2.sou + "," + bIU2.sot + "," + bIU2.swq + "," + bIU2.swr + "," + bIU2.sws + "," + bIU2.swt + "," + bIU2.swu + "," + bIU2.swv + "," + bIU2.sww + "," + bIU2.swx + "," + bIU2.swy + "," + bIU2.swz + "," + bIU2.swA + "," + bIU2.nEV + "," + bIU2.swB + "," + bIU2.swC + "," + bIU2.channelStrategy + "," + bIU2.spG + "," + bIU2.sov + "," + bIU2.swD + "," + bIU2.swE + "," + bIU2.swF + "," + bIU2.deviceModel + "," + bIU2.swG + "," + bIU2.swH;
        x.i("MicroMsg.VoipCSReportHelper", "getVoipCSClientReportData, result: %s", new Object[]{com_tencent_mm_protocal_c_btv2.wVi});
        linkedList2.add(com_tencent_mm_protocal_c_btv2);
        linkedList = com_tencent_mm_protocal_c_btw.wVj;
        bIU = com.tencent.mm.plugin.voip_cs.b.b.bIU();
        com_tencent_mm_protocal_c_btv = new btv();
        com_tencent_mm_protocal_c_btv.ktN = 4;
        bIU.networkType = c.getNetType(ac.getContext());
        String simOperator = ((TelephonyManager) ac.getContext().getSystemService("phone")).getSimOperator();
        if (simOperator != null) {
            if (simOperator.equals("46000") || simOperator.equals("46002") || simOperator.equals("46007")) {
                i = 1;
                bIU.swg = i;
                bIU.svX = (int) (System.currentTimeMillis() / 1000);
                bIU.swh = c.bIX();
                bIU.sou = ar.Hh().xW();
                bHh = com.tencent.mm.plugin.voip.model.k.bHh();
                bIU.swi = bHh.smM != 0 ? bHh.smL / bHh.smM : -1;
                if (bIU.swi == -1) {
                    bArr = new byte[4];
                    if (com.tencent.mm.plugin.voip_cs.b.b.bIS().nEG.setAppCmd(10, bArr, 4) < 0) {
                        bIU.swi = 0;
                        x.d("MicroMsg.VoipCSReportHelper", "get netStatus failed");
                    } else {
                        bIU.swi = bh.aG(bArr);
                    }
                }
                x.i("MicroMsg.VoipCSReportHelper", "getVoipCSThirdPartData Report dataType=%d, dataTime=%s, isClickClose=%d, clickCloseTime=%s, videoFps=%d, videoRate=%d, cameraPixelWidth=%d, cameraPixelHeight=%d, recordPixelWidth=%d, recordPixelHeight=%d, cameraState=%d, networkType=%s, mobileType=%s, mobileNetworkType=%s, networkQuality=%d", new Object[]{Integer.valueOf(bIU.bjS), Integer.valueOf(bIU.svX), Integer.valueOf(bIU.svY), Integer.valueOf(bIU.svZ), Integer.valueOf(bIU.videoFps), Integer.valueOf(bIU.swa), Integer.valueOf(bIU.swb), Integer.valueOf(bIU.swc), Integer.valueOf(bIU.swd), Integer.valueOf(bIU.swe), Integer.valueOf(bIU.swf), Integer.valueOf(bIU.networkType), Integer.valueOf(bIU.swg), Integer.valueOf(bIU.swh), Integer.valueOf(bIU.swi)});
                com_tencent_mm_protocal_c_btv.wVi = bIU.bjS + "," + bIU.svX + "," + bIU.svY + "," + bIU.svZ + "," + bIU.videoFps + "," + bIU.swa + "," + bIU.swb + "," + bIU.swc + "," + bIU.swd + "," + bIU.swe + "," + bIU.swf + "," + bIU.networkType + "," + bIU.swg + "," + bIU.swh + "," + bIU.swi + "," + bIU.swj + "," + bIU.nDy;
                x.d("MicroMsg.VoipCSReportHelper", "getVoipCSThirdPartData, result: " + com_tencent_mm_protocal_c_btv.wVi);
                linkedList.add(com_tencent_mm_protocal_c_btv);
            }
            if (simOperator.equals("46001")) {
                i = 3;
            } else if (simOperator.equals("46003")) {
                i = 2;
            }
            bIU.swg = i;
            bIU.svX = (int) (System.currentTimeMillis() / 1000);
            bIU.swh = c.bIX();
            bIU.sou = ar.Hh().xW();
            bHh = com.tencent.mm.plugin.voip.model.k.bHh();
            if (bHh.smM != 0) {
            }
            bIU.swi = bHh.smM != 0 ? bHh.smL / bHh.smM : -1;
            if (bIU.swi == -1) {
                bArr = new byte[4];
                if (com.tencent.mm.plugin.voip_cs.b.b.bIS().nEG.setAppCmd(10, bArr, 4) < 0) {
                    bIU.swi = bh.aG(bArr);
                } else {
                    bIU.swi = 0;
                    x.d("MicroMsg.VoipCSReportHelper", "get netStatus failed");
                }
            }
            x.i("MicroMsg.VoipCSReportHelper", "getVoipCSThirdPartData Report dataType=%d, dataTime=%s, isClickClose=%d, clickCloseTime=%s, videoFps=%d, videoRate=%d, cameraPixelWidth=%d, cameraPixelHeight=%d, recordPixelWidth=%d, recordPixelHeight=%d, cameraState=%d, networkType=%s, mobileType=%s, mobileNetworkType=%s, networkQuality=%d", new Object[]{Integer.valueOf(bIU.bjS), Integer.valueOf(bIU.svX), Integer.valueOf(bIU.svY), Integer.valueOf(bIU.svZ), Integer.valueOf(bIU.videoFps), Integer.valueOf(bIU.swa), Integer.valueOf(bIU.swb), Integer.valueOf(bIU.swc), Integer.valueOf(bIU.swd), Integer.valueOf(bIU.swe), Integer.valueOf(bIU.swf), Integer.valueOf(bIU.networkType), Integer.valueOf(bIU.swg), Integer.valueOf(bIU.swh), Integer.valueOf(bIU.swi)});
            com_tencent_mm_protocal_c_btv.wVi = bIU.bjS + "," + bIU.svX + "," + bIU.svY + "," + bIU.svZ + "," + bIU.videoFps + "," + bIU.swa + "," + bIU.swb + "," + bIU.swc + "," + bIU.swd + "," + bIU.swe + "," + bIU.swf + "," + bIU.networkType + "," + bIU.swg + "," + bIU.swh + "," + bIU.swi + "," + bIU.swj + "," + bIU.nDy;
            x.d("MicroMsg.VoipCSReportHelper", "getVoipCSThirdPartData, result: " + com_tencent_mm_protocal_c_btv.wVi);
            linkedList.add(com_tencent_mm_protocal_c_btv);
        }
        i = 0;
        bIU.swg = i;
        bIU.svX = (int) (System.currentTimeMillis() / 1000);
        bIU.swh = c.bIX();
        bIU.sou = ar.Hh().xW();
        bHh = com.tencent.mm.plugin.voip.model.k.bHh();
        if (bHh.smM != 0) {
        }
        bIU.swi = bHh.smM != 0 ? bHh.smL / bHh.smM : -1;
        if (bIU.swi == -1) {
            bArr = new byte[4];
            if (com.tencent.mm.plugin.voip_cs.b.b.bIS().nEG.setAppCmd(10, bArr, 4) < 0) {
                bIU.swi = 0;
                x.d("MicroMsg.VoipCSReportHelper", "get netStatus failed");
            } else {
                bIU.swi = bh.aG(bArr);
            }
        }
        x.i("MicroMsg.VoipCSReportHelper", "getVoipCSThirdPartData Report dataType=%d, dataTime=%s, isClickClose=%d, clickCloseTime=%s, videoFps=%d, videoRate=%d, cameraPixelWidth=%d, cameraPixelHeight=%d, recordPixelWidth=%d, recordPixelHeight=%d, cameraState=%d, networkType=%s, mobileType=%s, mobileNetworkType=%s, networkQuality=%d", new Object[]{Integer.valueOf(bIU.bjS), Integer.valueOf(bIU.svX), Integer.valueOf(bIU.svY), Integer.valueOf(bIU.svZ), Integer.valueOf(bIU.videoFps), Integer.valueOf(bIU.swa), Integer.valueOf(bIU.swb), Integer.valueOf(bIU.swc), Integer.valueOf(bIU.swd), Integer.valueOf(bIU.swe), Integer.valueOf(bIU.swf), Integer.valueOf(bIU.networkType), Integer.valueOf(bIU.swg), Integer.valueOf(bIU.swh), Integer.valueOf(bIU.swi)});
        com_tencent_mm_protocal_c_btv.wVi = bIU.bjS + "," + bIU.svX + "," + bIU.svY + "," + bIU.svZ + "," + bIU.videoFps + "," + bIU.swa + "," + bIU.swb + "," + bIU.swc + "," + bIU.swd + "," + bIU.swe + "," + bIU.swf + "," + bIU.networkType + "," + bIU.swg + "," + bIU.swh + "," + bIU.swi + "," + bIU.swj + "," + bIU.nDy;
        x.d("MicroMsg.VoipCSReportHelper", "getVoipCSThirdPartData, result: " + com_tencent_mm_protocal_c_btv.wVi);
        linkedList.add(com_tencent_mm_protocal_c_btv);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneVoipCSReport", "onGYNetEnd, errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 312;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ae.e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
