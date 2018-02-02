package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.ui.SnsUploadUI.10;

class SnsUploadUI$10$1 implements Runnable {
    final /* synthetic */ 10 rLU;

    SnsUploadUI$10$1(10 10) {
        this.rLU = 10;
    }

    public final void run() {
        SnsUploadSayFooter c = SnsUploadUI.c(this.rLU.rLR);
        c.setVisibility(0);
        if (c.oku != null) {
            c.oku.setImageResource(e.qzU);
        }
        SnsUploadUI.c(this.rLU.rLR).postInvalidate();
        SnsUploadUI.d(this.rLU.rLR).postInvalidate();
    }
}
