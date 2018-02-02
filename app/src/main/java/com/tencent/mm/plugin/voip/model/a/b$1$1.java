package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.plugin.voip.b.a;
import com.tencent.mm.plugin.voip.model.a.b.1;
import com.tencent.mm.protocal.c.buo;
import com.tencent.mm.sdk.platformtools.x;

class b$1$1 implements Runnable {
    final /* synthetic */ buo snH;
    final /* synthetic */ 1 snK;

    b$1$1(1 1, buo com_tencent_mm_protocal_c_buo) {
        this.snK = 1;
        this.snH = com_tencent_mm_protocal_c_buo;
    }

    public final void run() {
        this.snK.snJ.skx.a(this.snH.wVD, this.snH.wVE, this.snH.wVL);
        if (this.snH.wUm.vKf.wJD != null) {
            this.snK.snJ.skx.aL(this.snH.wUm.vKf.wJD.toByteArray());
        } else {
            x.e(this.snK.snJ.TAG, "multiRelayData.PeerId.Buffer.getBuffer() is null");
        }
        if (!(this.snH.wVJ == null || this.snH.wVJ.wJD == null || this.snH.wVV == null || this.snH.wVV.wJD == null)) {
            this.snK.snJ.skx.a(this.snH.wVJ.wJD.toByteArray(), this.snH.wVI, this.snH.nDT, this.snH.wVV.wJD.toByteArray());
        }
        this.snK.snJ.skx.i(this.snH.wVM, this.snH.wVN, this.snH.wVO, this.snH.wVP, this.snH.wVQ);
        this.snK.snJ.skx.yy(this.snH.wVU);
        if (!(this.snH.wVS == null || this.snH.wVT == null || this.snH.wVS.wJD == null || this.snH.wVT.wJD == null)) {
            this.snK.snJ.skx.b(this.snH.wVR, this.snH.wVS.wJD.toByteArray(), this.snH.wVT.wJD.toByteArray());
        }
        if (this.snH.wUn.vKf.wJD != null) {
            this.snK.snJ.skx.aM(this.snH.wUn.vKf.wJD.toByteArray());
        } else {
            x.e(this.snK.snJ.TAG, "multiRelayData.CapInfo.Buffer.getBuffer() is null");
        }
        this.snK.snJ.skx.yx(this.snH.wVX);
        this.snK.snJ.skx.ske.spd = this.snH.wVY;
        if (this.snK.snJ.skx.sjG) {
            this.snK.snJ.skx.sjG = false;
            if (this.snK.snJ.skx.sjC) {
                a.et(this.snK.snJ.TAG, "channel pre-connect already success, start talk");
                this.snK.snJ.skx.bGu();
            } else if (this.snK.snJ.skx.sjF) {
                a.et(this.snK.snJ.TAG, "channel pre-connect already failed");
                this.snK.snJ.skx.p(1, -9000, "");
                return;
            } else {
                a.et(this.snK.snJ.TAG, "channel pre-connect still connecting...");
            }
        } else {
            x.i(this.snK.snJ.TAG, "isPreConnect is false");
        }
        this.snK.snJ.skx.bGB();
        this.snK.snJ.skx.bGz();
    }
}
