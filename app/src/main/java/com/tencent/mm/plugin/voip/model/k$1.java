package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class k$1 implements a {
    final /* synthetic */ k smP;

    k$1(k kVar) {
        this.smP = kVar;
    }

    public final boolean uF() {
        if (!this.smP.smJ) {
            return false;
        }
        int i;
        byte[] bArr = new byte[4];
        if (this.smP.smF.setAppCmd(10, bArr, 4) < 0) {
            x.d("MicroMsg.VoipNetStatusChecker", "get netStatus failed");
            i = -1;
        } else {
            i = bh.aG(bArr);
            x.d("MicroMsg.VoipNetStatusChecker", "netStatus: %d", Integer.valueOf(i));
        }
        if (i != -1) {
            this.smP.smI = i;
            this.smP.smL = this.smP.smI + this.smP.smL;
            k kVar = this.smP;
            kVar.smM++;
            kVar = this.smP;
            if (kVar.smI < 5) {
                kVar.smK = 0;
                if (!kVar.smG) {
                    kVar.smG = true;
                    x.d("MicroMsg.VoipNetStatusChecker", "go to bad net status");
                    if (kVar.smH != null) {
                        kVar.smH.aSW();
                    }
                }
            } else if (kVar.smG) {
                if (kVar.smK <= 0) {
                    x.d("MicroMsg.VoipNetStatusChecker", "ignore this good net status");
                    kVar.smK++;
                } else {
                    kVar.smG = false;
                    x.d("MicroMsg.VoipNetStatusChecker", "go to good net status");
                    if (kVar.smH != null) {
                        kVar.smH.aSX();
                    }
                }
            }
        }
        return true;
    }
}
