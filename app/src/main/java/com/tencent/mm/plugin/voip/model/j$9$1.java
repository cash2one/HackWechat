package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.g.a.tm;
import com.tencent.mm.plugin.voip.b.b;
import com.tencent.mm.plugin.voip.model.j.9;

class j$9$1 implements Runnable {
    final /* synthetic */ tm smC;
    final /* synthetic */ 9 smD;

    j$9$1(9 9, tm tmVar) {
        this.smD = 9;
        this.smC = tmVar;
    }

    public final void run() {
        switch (this.smC.fMb.fpr) {
            case 1:
                if (b.yT(j.a(this.smD.smu).mState)) {
                    this.smD.smu.bGM();
                    return;
                } else {
                    this.smD.smu.bGO();
                    return;
                }
            case 2:
                if (b.yT(j.a(this.smD.smu).mState)) {
                    this.smD.smu.bGL();
                    return;
                } else {
                    this.smD.smu.bGN();
                    return;
                }
            case 3:
                this.smD.smu.bGJ();
                return;
            default:
                return;
        }
    }
}
