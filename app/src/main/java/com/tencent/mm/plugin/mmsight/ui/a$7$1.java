package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.mm.plugin.mmsight.ui.a.7;

class a$7$1 implements Runnable {
    final /* synthetic */ 7 oBY;

    a$7$1(7 7) {
        this.oBY = 7;
    }

    public final void run() {
        if (this.oBY.oBU.ilH != null) {
            this.oBY.oBU.ilH.dismiss();
        }
        if (this.oBY.oBU.oBM != null) {
            this.oBY.oBU.oBM.onError();
        }
    }
}
