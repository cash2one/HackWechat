package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.voip.b.a;
import com.tencent.mm.plugin.voip.model.d;
import com.tencent.mm.protocal.c.btf;
import com.tencent.mm.protocal.c.buo;
import com.tencent.mm.z.ar;

class a$1 implements e {
    final /* synthetic */ a snG;

    a$1(a aVar) {
        this.snG = aVar;
    }

    public final void a(int i, int i2, String str, k kVar) {
        a.et(this.snG.TAG, "ack response:" + i + " errCode:" + i2 + " status:" + this.snG.skx.mStatus);
        if (this.snG.skx.mStatus == 1) {
            a.et(this.snG.TAG, "reject ok!");
        } else if (this.snG.skx.mStatus != 3) {
            a.es(this.snG.TAG, "ack response not within WAITCONNECT, ignored.");
        } else if (i == 0) {
            btf com_tencent_mm_protocal_c_btf = (btf) this.snG.bHN();
            if (com_tencent_mm_protocal_c_btf.wUl != 1) {
                a.et(this.snG.TAG, "onVoipAckResp: do not use preconnect");
                return;
            }
            this.snG.skx.sjG = true;
            this.snG.skx.ske.soF = 1;
            this.snG.skx.ske.nDx = com_tencent_mm_protocal_c_btf.wbh;
            this.snG.skx.ske.nDy = com_tencent_mm_protocal_c_btf.wbi;
            this.snG.skx.ske.nDF = com_tencent_mm_protocal_c_btf.wUr;
            this.snG.skx.ske.som = com_tencent_mm_protocal_c_btf.wUv;
            this.snG.skx.ske.son = com_tencent_mm_protocal_c_btf.wUw;
            this.snG.skx.yA(com_tencent_mm_protocal_c_btf.wUt);
            a.et(this.snG.TAG, "ack ok, roomid =" + this.snG.skx.ske.nDx + ",memberid = " + this.snG.skx.ske.nDF);
            final buo com_tencent_mm_protocal_c_buo = com_tencent_mm_protocal_c_btf.wUs;
            if (com_tencent_mm_protocal_c_buo.nDT > 0) {
                com_tencent_mm_protocal_c_buo.nDT--;
                a.et(this.snG.TAG, "zhengxue[ENCRYPT] got encryptStrategy[" + com_tencent_mm_protocal_c_buo.nDT + "] from ackresp relaydata");
            } else {
                com_tencent_mm_protocal_c_buo.nDT = 1;
                a.et(this.snG.TAG, "zhengxue[LOGIC]:got no EncryptStrategy in ackresp mrdata");
            }
            a.et(this.snG.TAG, "ack with switchtcpcnt  =" + this.snG.skx.ske.sol + " RedirectReqThreshold =" + com_tencent_mm_protocal_c_buo.wVX + " BothSideSwitchFlag =" + com_tencent_mm_protocal_c_buo.wVY + " WifiScanInterval =" + com_tencent_mm_protocal_c_btf.wUw);
            this.snG.skx.ske.spd = com_tencent_mm_protocal_c_buo.wVY;
            this.snG.skx.yz(com_tencent_mm_protocal_c_buo.wVC);
            this.snG.skx.aL(com_tencent_mm_protocal_c_buo.wUm.vKf.wJD.toByteArray());
            if (!(com_tencent_mm_protocal_c_buo.wVJ == null || com_tencent_mm_protocal_c_buo.wVJ.wJD == null || com_tencent_mm_protocal_c_buo.wVV == null || com_tencent_mm_protocal_c_buo.wVV.wJD == null)) {
                this.snG.skx.a(com_tencent_mm_protocal_c_buo.wVJ.wJD.toByteArray(), com_tencent_mm_protocal_c_buo.wVI, com_tencent_mm_protocal_c_buo.nDT, com_tencent_mm_protocal_c_buo.wVV.wJD.toByteArray());
            }
            this.snG.skx.i(com_tencent_mm_protocal_c_buo.wVM, com_tencent_mm_protocal_c_buo.wVN, com_tencent_mm_protocal_c_buo.wVO, com_tencent_mm_protocal_c_buo.wVP, com_tencent_mm_protocal_c_buo.wVQ);
            this.snG.skx.aM(com_tencent_mm_protocal_c_buo.wUn.vKf.wJD.toByteArray());
            ar.Dm().F(new Runnable(this) {
                final /* synthetic */ a$1 snI;

                public final void run() {
                    this.snI.snG.skx.a(com_tencent_mm_protocal_c_buo.wVD, com_tencent_mm_protocal_c_buo.wVE, com_tencent_mm_protocal_c_buo.wVL);
                    this.snI.snG.skx.yy(com_tencent_mm_protocal_c_buo.wVU);
                    this.snI.snG.skx.yx(com_tencent_mm_protocal_c_buo.wVX);
                    if (!(com_tencent_mm_protocal_c_buo.wVS == null || com_tencent_mm_protocal_c_buo.wVT == null)) {
                        this.snI.snG.skx.b(com_tencent_mm_protocal_c_buo.wVR, com_tencent_mm_protocal_c_buo.wVS.wJD.toByteArray(), com_tencent_mm_protocal_c_buo.wVT.wJD.toByteArray());
                    }
                    d.bGj().bHy();
                    a.et(this.snI.snG.TAG, "ack success, try connect channel");
                    this.snI.snG.skx.bGz();
                }
            });
        } else if (i == 4) {
            this.snG.skx.ske.spH.skR = 12;
            this.snG.skx.ske.spH.skS = i2;
            this.snG.skx.p(1, i2, "");
        } else {
            this.snG.skx.ske.spH.skR = 12;
            this.snG.skx.ske.spH.skS = i2;
            this.snG.skx.p(1, -9004, "");
        }
    }
}
