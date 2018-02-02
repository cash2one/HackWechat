package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.mm.plugin.mmsight.ui.a.4;

class a$4$1 implements Runnable {
    final /* synthetic */ 4 oBX;

    a$4$1(4 4) {
        this.oBX = 4;
    }

    public final void run() {
        if (this.oBX.oBU.ilH != null) {
            this.oBX.oBU.ilH.dismiss();
        }
        if (this.oBX.oBU.oBM != null) {
            this.oBX.oBU.oBM.onError();
        }
    }
}
