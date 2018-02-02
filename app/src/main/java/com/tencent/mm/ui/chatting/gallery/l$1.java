package com.tencent.mm.ui.chatting.gallery;

import com.tencent.mm.modelvideo.t;

class l$1 implements Runnable {
    final /* synthetic */ l yGV;

    l$1(l lVar) {
        this.yGV = lVar;
    }

    public final void run() {
        if (this.yGV.yGT != null) {
            if (this.yGV.iH(t.y(this.yGV.hTA, this.yGV.filename))) {
                if (this.yGV.rvt == 0 && this.yGV.rvv == 0) {
                    this.yGV.bzW();
                }
                this.yGV.yGT.aI(this.yGV.filename, true);
                this.yGV.hTG = true;
            }
        }
    }
}
