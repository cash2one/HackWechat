package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.ui.SnsUploadUI.10;

class SnsUploadUI$10$2 implements Runnable {
    final /* synthetic */ 10 rLU;

    SnsUploadUI$10$2(10 10) {
        this.rLU = 10;
    }

    public final void run() {
        SnsUploadSayFooter c = SnsUploadUI.c(this.rLU.rLR);
        if (!c.bCe()) {
            c.setVisibility(8);
        }
        SnsUploadUI.c(this.rLU.rLR).postInvalidate();
        SnsUploadUI.e(this.rLU.rLR).postInvalidate();
    }
}
