package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.voip.b.a;
import com.tencent.mm.protocal.c.btj;
import com.tencent.mm.protocal.c.buo;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

class b$1 implements e {
    final /* synthetic */ b snJ;

    b$1(b bVar) {
        this.snJ = bVar;
    }

    public final void a(int i, int i2, String str, k kVar) {
        a.et(this.snJ.TAG, "Anwser response:" + i + " errCode:" + i2 + " status:" + this.snJ.skx.mStatus);
        if (this.snJ.skx.mStatus == 1) {
            a.et(this.snJ.TAG, "reject ok!");
        } else if (this.snJ.skx.mStatus != 4) {
            a.es(this.snJ.TAG, "Anwser response not within WAITCONNECT, ignored.");
        } else if (i == 0) {
            btj com_tencent_mm_protocal_c_btj = (btj) this.snJ.bHN();
            this.snJ.skx.ske.nDx = com_tencent_mm_protocal_c_btj.wbh;
            this.snJ.skx.ske.nDy = com_tencent_mm_protocal_c_btj.wbi;
            this.snJ.skx.ske.nDF = com_tencent_mm_protocal_c_btj.wUr;
            this.snJ.skx.ske.soH = com_tencent_mm_protocal_c_btj.wUD;
            this.snJ.skx.ske.soI = com_tencent_mm_protocal_c_btj.wUE;
            this.snJ.skx.ske.soJ = com_tencent_mm_protocal_c_btj.wUF;
            this.snJ.skx.ske.soK = com_tencent_mm_protocal_c_btj.wUG;
            this.snJ.skx.ske.soM = com_tencent_mm_protocal_c_btj.wUI;
            this.snJ.skx.ske.soL = com_tencent_mm_protocal_c_btj.wUN;
            this.snJ.skx.ske.som = com_tencent_mm_protocal_c_btj.wUv;
            this.snJ.skx.ske.soN = com_tencent_mm_protocal_c_btj.wUP;
            this.snJ.skx.yA(com_tencent_mm_protocal_c_btj.wUt);
            this.snJ.skx.ske.son = com_tencent_mm_protocal_c_btj.wUw;
            a.et(this.snJ.TAG, "onAnwserResp: audioTsdfBeyond3G = " + this.snJ.skx.ske.soH + ",audioTsdEdge = " + this.snJ.skx.ske.soI + ",passthroughQosAlgorithm = " + this.snJ.skx.ske.soJ + ",fastPlayRepair = " + this.snJ.skx.ske.soK + ", audioDtx = " + this.snJ.skx.ske.soM + ", switchtcppktCnt=" + this.snJ.skx.ske.sol + ", SvrCfgListV=" + this.snJ.skx.ske.soL + ", setMaxBRForRelay=" + this.snJ.skx.ske.soN + ", RedirectreqThreshold=" + com_tencent_mm_protocal_c_btj.wUs.wVX + ", BothSideSwitchFlag=" + com_tencent_mm_protocal_c_btj.wUs.wVY + ", WifiScanInterval=" + com_tencent_mm_protocal_c_btj.wUw);
            this.snJ.skx.ske.soO = com_tencent_mm_protocal_c_btj.wUM;
            this.snJ.skx.ske.soP = com_tencent_mm_protocal_c_btj.wUQ;
            a.et(this.snJ.TAG, "answerResp AudioAecMode5 = " + this.snJ.skx.ske.soO);
            this.snJ.skx.sjE = true;
            a.et(this.snJ.TAG, "answer ok, roomid =" + this.snJ.skx.ske.nDx + ",memberid = " + this.snJ.skx.ske.nDF);
            buo com_tencent_mm_protocal_c_buo = com_tencent_mm_protocal_c_btj.wUs;
            if (com_tencent_mm_protocal_c_buo.nDT > 0) {
                com_tencent_mm_protocal_c_buo.nDT--;
                a.et(this.snJ.TAG, "zhengxue[ENCRYPT] got encryptStrategy[" + com_tencent_mm_protocal_c_buo.nDT + "] from answerresp relaydata");
            } else {
                com_tencent_mm_protocal_c_buo.nDT = 1;
                a.et(this.snJ.TAG, "zhengxue[LOGIC]:got no EncryptStrategy in answerresp mrdata");
            }
            a.et(this.snJ.TAG, "answer with relayData peerid.length =" + com_tencent_mm_protocal_c_buo.wUm.vKf.wJB);
            a.et(this.snJ.TAG, "answer with relayData capinfo.length =" + com_tencent_mm_protocal_c_buo.wUn.vKf.wJB);
            this.snJ.skx.yz(com_tencent_mm_protocal_c_buo.wVC);
            try {
                ar.Dm().F(new 1(this, com_tencent_mm_protocal_c_buo));
            } catch (Exception e) {
                x.e(this.snJ.TAG, "get proxy ip fail..");
            }
        } else if (i == 4) {
            this.snJ.skx.ske.spH.skR = 12;
            this.snJ.skx.ske.spH.skS = i2;
            this.snJ.skx.p(1, i2, "");
        } else {
            this.snJ.skx.ske.spH.skR = 12;
            this.snJ.skx.ske.spH.skS = i2;
            this.snJ.skx.p(1, -9004, "");
        }
    }
}
