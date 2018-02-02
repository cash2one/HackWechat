package com.tencent.mm.ui.chatting.gallery;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.ui.chatting.gallery.j.4;

class j$4$2 implements Runnable {
    final /* synthetic */ int jup;
    final /* synthetic */ int qvu;
    final /* synthetic */ 4 yGD;

    j$4$2(4 4, int i, int i2) {
        this.yGD = 4;
        this.qvu = i;
        this.jup = i2;
    }

    public final void run() {
        g gVar = g.pQN;
        Object[] objArr = new Object[8];
        objArr[0] = Integer.valueOf(this.yGD.yGA.yGy);
        objArr[1] = Integer.valueOf(this.qvu <= 0 ? this.yGD.yGA.rkQ * 1000 : this.qvu);
        objArr[2] = Integer.valueOf(this.jup);
        objArr[3] = Integer.valueOf(1);
        objArr[4] = this.yGD.yGA.fzO;
        objArr[5] = Integer.valueOf(this.yGD.yGA.yGz);
        objArr[6] = this.yGD.yGA.fzR;
        objArr[7] = Long.valueOf(this.yGD.yGA.hVE);
        gVar.h(12084, objArr);
    }
}
