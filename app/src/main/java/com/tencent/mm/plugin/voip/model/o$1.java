package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.plugin.voip.b.a;
import com.tencent.mm.protocal.c.amx;
import com.tencent.mm.protocal.c.buo;
import com.tencent.mm.protocal.c.but;
import com.tencent.mm.sdk.platformtools.x;

class o$1 implements Runnable {
    final /* synthetic */ but snD;
    final /* synthetic */ o snE;

    o$1(o oVar, but com_tencent_mm_protocal_c_but) {
        this.snE = oVar;
        this.snD = com_tencent_mm_protocal_c_but;
    }

    public final void run() {
        a.et("MicroMsg.Voip.VoipSyncHandle", "__onMultiRelayData begin");
        try {
            buo com_tencent_mm_protocal_c_buo = (buo) new buo().aF(this.snD.vKf.wJD.toByteArray());
            if (!(com_tencent_mm_protocal_c_buo.wUm == null || com_tencent_mm_protocal_c_buo.wUm.vKf == null || com_tencent_mm_protocal_c_buo.wUm.vKf.wJD == null)) {
                this.snE.snA.wUm = com_tencent_mm_protocal_c_buo.wUm;
            }
            if (!(com_tencent_mm_protocal_c_buo.wUn.vKf == null || com_tencent_mm_protocal_c_buo.wUn.vKf.wJD == null)) {
                this.snE.snA.wUn = com_tencent_mm_protocal_c_buo.wUn;
            }
            if (com_tencent_mm_protocal_c_buo.wVC != 0) {
                this.snE.snA.wVC = com_tencent_mm_protocal_c_buo.wVC;
            }
            if (!(com_tencent_mm_protocal_c_buo.wVD == null || com_tencent_mm_protocal_c_buo.wVD.wUx == 0)) {
                this.snE.snA.wVD = com_tencent_mm_protocal_c_buo.wVD;
            }
            if (!(com_tencent_mm_protocal_c_buo.wVE == null || com_tencent_mm_protocal_c_buo.wVE.wUx == 0)) {
                this.snE.snA.wVE = com_tencent_mm_protocal_c_buo.wVE;
            }
            if (com_tencent_mm_protocal_c_buo.wVG != 0) {
                this.snE.snA.wVG = com_tencent_mm_protocal_c_buo.wVG;
            }
            if (com_tencent_mm_protocal_c_buo.wVH != 0) {
                this.snE.snA.wVH = com_tencent_mm_protocal_c_buo.wVH;
            }
            if (com_tencent_mm_protocal_c_buo.wVL.wUx != 0) {
                this.snE.snA.wVL = com_tencent_mm_protocal_c_buo.wVL;
            }
            if (com_tencent_mm_protocal_c_buo.wVM > 0) {
                this.snE.snA.wVM = com_tencent_mm_protocal_c_buo.wVM;
            } else {
                this.snE.snA.wVM = 0;
                a.et("MicroMsg.Voip.VoipSyncHandle", "zhengxue[LOGIC]:got no ARQstrategy in mrdata");
            }
            if (com_tencent_mm_protocal_c_buo.nDT > 0) {
                this.snE.snA.nDT = com_tencent_mm_protocal_c_buo.nDT - 1;
                a.et("MicroMsg.Voip.VoipSyncHandle", "zhengxue[ENCRYPT] got encryptStrategy[" + this.snE.snA.nDT + "] from relaydata");
            } else {
                this.snE.snA.nDT = 1;
                a.et("MicroMsg.Voip.VoipSyncHandle", "zhengxue[LOGIC]:got no EncryptStrategy in mrdata");
            }
            if (com_tencent_mm_protocal_c_buo.wVN > 0) {
                this.snE.snA.wVN = com_tencent_mm_protocal_c_buo.wVN;
                this.snE.snA.wVO = com_tencent_mm_protocal_c_buo.wVO;
                this.snE.snA.wVP = com_tencent_mm_protocal_c_buo.wVP;
                this.snE.snA.wVQ = com_tencent_mm_protocal_c_buo.wVQ;
                a.et("MicroMsg.Voip.VoipSyncHandle", "zhengxue[LOGIC]:got ARQCacheLen: " + com_tencent_mm_protocal_c_buo.wVN + ", ARQRttThreshold: " + com_tencent_mm_protocal_c_buo.wVO + ", ARQUsedRateThreshold: " + com_tencent_mm_protocal_c_buo.wVP + ", ARQRespRateThreshold: " + com_tencent_mm_protocal_c_buo.wVQ);
            } else {
                a.et("MicroMsg.Voip.VoipSyncHandle", "zhengxue[LOGIC]:got no ARQKeyParameters in mrdata");
            }
            if (com_tencent_mm_protocal_c_buo.wVU > 0) {
                this.snE.snA.wVU = com_tencent_mm_protocal_c_buo.wVU;
            } else {
                this.snE.snA.wVU = 0;
                a.et("MicroMsg.Voip.VoipSyncHandle", "zhengxue[LOGIC]:got no QosStrategy in mrdata");
            }
            this.snE.snA.wVX = com_tencent_mm_protocal_c_buo.wVX;
            if (com_tencent_mm_protocal_c_buo.wVZ != null) {
                this.snE.snA.wVZ = com_tencent_mm_protocal_c_buo.wVZ;
            }
            int i = (this.snE.snA.wUm == null || this.snE.snA.wUm.vKf == null || this.snE.snA.wUm.vKf.wJD == null || this.snE.snA.wVC == 0 || this.snE.snA.wUn == null || this.snE.snA.wUn.vKf == null || this.snE.snA.wUn.vKf.wJD == null || this.snE.snA.wVD == null || this.snE.snA.wVD.wUx == 0 || this.snE.snA.wVE == null || this.snE.snA.wVE.wUx == 0 || this.snE.snA.wVL == null || this.snE.snA.wVL.wUx == 0) ? 0 : 1;
            if (i == 0) {
                a.et("MicroMsg.Voip.VoipSyncHandle", "__onMultiRelayData end");
                return;
            }
            a.et("MicroMsg.Voip.VoipSyncHandle", "multiRelayData recv all, update. RedirectReqThreshold = " + this.snE.snA.wVX + " BothSideSwitchFlag = " + com_tencent_mm_protocal_c_buo.wVY);
            this.snE.siL.yz(this.snE.snA.wVC);
            this.snE.siL.aL(this.snE.snA.wUm.vKf.wJD.toByteArray());
            if (!(com_tencent_mm_protocal_c_buo.wVJ == null || com_tencent_mm_protocal_c_buo.wVJ.wJD == null || com_tencent_mm_protocal_c_buo.wVV == null || com_tencent_mm_protocal_c_buo.wVV.wJD == null)) {
                this.snE.siL.a(com_tencent_mm_protocal_c_buo.wVJ.wJD.toByteArray(), com_tencent_mm_protocal_c_buo.wVI, this.snE.snA.nDT, com_tencent_mm_protocal_c_buo.wVV.wJD.toByteArray());
            }
            if (d.bGj().bHp() != 0) {
                this.snE.siL.aM(this.snE.snA.wUn.vKf.wJD.toByteArray());
            }
            this.snE.siL.a(this.snE.snA.wVD, this.snE.snA.wVE, this.snE.snA.wVL);
            this.snE.siL.i(this.snE.snA.wVM, this.snE.snA.wVN, this.snE.snA.wVO, this.snE.snA.wVP, this.snE.snA.wVQ);
            this.snE.siL.yy(this.snE.snA.wVU);
            e eVar = this.snE.siL;
            int i2 = this.snE.snA.wVG;
            int i3 = this.snE.snA.wVH;
            eVar.ske.soj = i2;
            eVar.ske.sok = i3;
            this.snE.siL.yx(this.snE.snA.wVX);
            this.snE.siL.ske.spd = com_tencent_mm_protocal_c_buo.wVY;
            if (!(com_tencent_mm_protocal_c_buo.wVS == null || com_tencent_mm_protocal_c_buo.wVS.wJD == null || com_tencent_mm_protocal_c_buo.wVT == null || com_tencent_mm_protocal_c_buo.wVT.wJD == null)) {
                this.snE.siL.b(com_tencent_mm_protocal_c_buo.wVR, com_tencent_mm_protocal_c_buo.wVS.wJD.toByteArray(), com_tencent_mm_protocal_c_buo.wVT.wJD.toByteArray());
            }
            eVar = this.snE.siL;
            amx com_tencent_mm_protocal_c_amx = this.snE.snA.wVZ;
            v2protocal com_tencent_mm_plugin_voip_model_v2protocal = eVar.ske;
            a.eu("MicroMsg.Voip", "v2protocal updateJbmBitrateRsSvrParam BitrateFlag : " + com_tencent_mm_protocal_c_amx.wts + " Bitrate: " + com_tencent_mm_protocal_c_amx.wtt);
            com_tencent_mm_plugin_voip_model_v2protocal.field_jbmParamArraySize = 27;
            com_tencent_mm_plugin_voip_model_v2protocal.field_jbmBitratRsSvrParamArray = new int[com_tencent_mm_plugin_voip_model_v2protocal.field_jbmParamArraySize];
            com_tencent_mm_plugin_voip_model_v2protocal.field_jbmBitratRsSvrParamArray[0] = com_tencent_mm_protocal_c_amx.wtr;
            com_tencent_mm_plugin_voip_model_v2protocal.field_jbmBitratRsSvrParamArray[1] = com_tencent_mm_protocal_c_amx.wts;
            com_tencent_mm_plugin_voip_model_v2protocal.field_jbmBitratRsSvrParamArray[2] = com_tencent_mm_protocal_c_amx.wtt;
            com_tencent_mm_plugin_voip_model_v2protocal.field_jbmBitratRsSvrParamArray[3] = com_tencent_mm_protocal_c_amx.wtu;
            com_tencent_mm_plugin_voip_model_v2protocal.field_jbmBitratRsSvrParamArray[4] = com_tencent_mm_protocal_c_amx.wtv;
            com_tencent_mm_plugin_voip_model_v2protocal.field_jbmBitratRsSvrParamArray[5] = com_tencent_mm_protocal_c_amx.wtw;
            com_tencent_mm_plugin_voip_model_v2protocal.field_jbmBitratRsSvrParamArray[6] = com_tencent_mm_protocal_c_amx.wtx;
            com_tencent_mm_plugin_voip_model_v2protocal.field_jbmBitratRsSvrParamArray[7] = com_tencent_mm_protocal_c_amx.wtA;
            com_tencent_mm_plugin_voip_model_v2protocal.field_jbmBitratRsSvrParamArray[8] = com_tencent_mm_protocal_c_amx.wtB;
            com_tencent_mm_plugin_voip_model_v2protocal.field_jbmBitratRsSvrParamArray[9] = com_tencent_mm_protocal_c_amx.wtE;
            com_tencent_mm_plugin_voip_model_v2protocal.field_jbmBitratRsSvrParamArray[10] = com_tencent_mm_protocal_c_amx.wtF;
            com_tencent_mm_plugin_voip_model_v2protocal.field_jbmBitratRsSvrParamArray[11] = com_tencent_mm_protocal_c_amx.wtI;
            com_tencent_mm_plugin_voip_model_v2protocal.field_jbmBitratRsSvrParamArray[12] = com_tencent_mm_protocal_c_amx.wtJ;
            com_tencent_mm_plugin_voip_model_v2protocal.field_jbmBitratRsSvrParamArray[13] = com_tencent_mm_protocal_c_amx.wtM;
            com_tencent_mm_plugin_voip_model_v2protocal.field_jbmBitratRsSvrParamArray[14] = com_tencent_mm_protocal_c_amx.wtN;
            com_tencent_mm_plugin_voip_model_v2protocal.field_jbmBitratRsSvrParamArray[15] = com_tencent_mm_protocal_c_amx.wtQ;
            com_tencent_mm_plugin_voip_model_v2protocal.field_jbmBitratRsSvrParamArray[16] = com_tencent_mm_protocal_c_amx.wtR;
            com_tencent_mm_plugin_voip_model_v2protocal.field_jbmBitratRsSvrParamArray[17] = com_tencent_mm_protocal_c_amx.wtU;
            com_tencent_mm_plugin_voip_model_v2protocal.field_jbmBitratRsSvrParamArray[18] = com_tencent_mm_protocal_c_amx.wtV;
            com_tencent_mm_plugin_voip_model_v2protocal.field_jbmBitratRsSvrParamArray[19] = com_tencent_mm_protocal_c_amx.wtY;
            com_tencent_mm_plugin_voip_model_v2protocal.field_jbmBitratRsSvrParamArray[20] = com_tencent_mm_protocal_c_amx.wtZ;
            com_tencent_mm_plugin_voip_model_v2protocal.field_jbmBitratRsSvrParamArray[21] = com_tencent_mm_protocal_c_amx.wuc;
            com_tencent_mm_plugin_voip_model_v2protocal.field_jbmBitratRsSvrParamArray[22] = com_tencent_mm_protocal_c_amx.wud;
            com_tencent_mm_plugin_voip_model_v2protocal.field_jbmBitratRsSvrParamArray[23] = com_tencent_mm_protocal_c_amx.wug;
            com_tencent_mm_plugin_voip_model_v2protocal.field_jbmBitratRsSvrParamArray[24] = com_tencent_mm_protocal_c_amx.wuh;
            com_tencent_mm_plugin_voip_model_v2protocal.field_jbmBitratRsSvrParamArray[25] = com_tencent_mm_protocal_c_amx.wuk;
            com_tencent_mm_plugin_voip_model_v2protocal.field_jbmBitratRsSvrParamArray[26] = com_tencent_mm_protocal_c_amx.wul;
            com_tencent_mm_plugin_voip_model_v2protocal.field_jbmParamDoubleArraySize = 20;
            com_tencent_mm_plugin_voip_model_v2protocal.field_jbmBitratRsSvrParamDoubleArray = new double[com_tencent_mm_plugin_voip_model_v2protocal.field_jbmParamDoubleArraySize];
            com_tencent_mm_plugin_voip_model_v2protocal.field_jbmBitratRsSvrParamDoubleArray[0] = com_tencent_mm_protocal_c_amx.wty;
            com_tencent_mm_plugin_voip_model_v2protocal.field_jbmBitratRsSvrParamDoubleArray[1] = com_tencent_mm_protocal_c_amx.wtz;
            com_tencent_mm_plugin_voip_model_v2protocal.field_jbmBitratRsSvrParamDoubleArray[2] = com_tencent_mm_protocal_c_amx.wtC;
            com_tencent_mm_plugin_voip_model_v2protocal.field_jbmBitratRsSvrParamDoubleArray[3] = com_tencent_mm_protocal_c_amx.wtD;
            com_tencent_mm_plugin_voip_model_v2protocal.field_jbmBitratRsSvrParamDoubleArray[4] = com_tencent_mm_protocal_c_amx.wtG;
            com_tencent_mm_plugin_voip_model_v2protocal.field_jbmBitratRsSvrParamDoubleArray[5] = com_tencent_mm_protocal_c_amx.wtH;
            com_tencent_mm_plugin_voip_model_v2protocal.field_jbmBitratRsSvrParamDoubleArray[6] = com_tencent_mm_protocal_c_amx.wtK;
            com_tencent_mm_plugin_voip_model_v2protocal.field_jbmBitratRsSvrParamDoubleArray[7] = com_tencent_mm_protocal_c_amx.wtL;
            com_tencent_mm_plugin_voip_model_v2protocal.field_jbmBitratRsSvrParamDoubleArray[8] = com_tencent_mm_protocal_c_amx.wtO;
            com_tencent_mm_plugin_voip_model_v2protocal.field_jbmBitratRsSvrParamDoubleArray[9] = com_tencent_mm_protocal_c_amx.wtP;
            com_tencent_mm_plugin_voip_model_v2protocal.field_jbmBitratRsSvrParamDoubleArray[10] = com_tencent_mm_protocal_c_amx.wtS;
            com_tencent_mm_plugin_voip_model_v2protocal.field_jbmBitratRsSvrParamDoubleArray[11] = com_tencent_mm_protocal_c_amx.wtT;
            com_tencent_mm_plugin_voip_model_v2protocal.field_jbmBitratRsSvrParamDoubleArray[12] = com_tencent_mm_protocal_c_amx.wtW;
            com_tencent_mm_plugin_voip_model_v2protocal.field_jbmBitratRsSvrParamDoubleArray[13] = com_tencent_mm_protocal_c_amx.wtX;
            com_tencent_mm_plugin_voip_model_v2protocal.field_jbmBitratRsSvrParamDoubleArray[14] = com_tencent_mm_protocal_c_amx.wua;
            com_tencent_mm_plugin_voip_model_v2protocal.field_jbmBitratRsSvrParamDoubleArray[15] = com_tencent_mm_protocal_c_amx.wub;
            com_tencent_mm_plugin_voip_model_v2protocal.field_jbmBitratRsSvrParamDoubleArray[16] = com_tencent_mm_protocal_c_amx.wue;
            com_tencent_mm_plugin_voip_model_v2protocal.field_jbmBitratRsSvrParamDoubleArray[17] = com_tencent_mm_protocal_c_amx.wuf;
            com_tencent_mm_plugin_voip_model_v2protocal.field_jbmBitratRsSvrParamDoubleArray[18] = com_tencent_mm_protocal_c_amx.wui;
            com_tencent_mm_plugin_voip_model_v2protocal.field_jbmBitratRsSvrParamDoubleArray[19] = com_tencent_mm_protocal_c_amx.wuj;
            this.snE.siL.bGz();
            a.et("MicroMsg.Voip.VoipSyncHandle", "__onMultiRelayData end");
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", e, "", new Object[0]);
        }
    }
}
