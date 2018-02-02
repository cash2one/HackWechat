package com.tencent.mm.plugin.sns.ui;

import android.view.View.OnDragListener;

class SnsUploadUI$11 implements Runnable {
    final /* synthetic */ SnsUploadUI rLR;

    SnsUploadUI$11(SnsUploadUI snsUploadUI) {
        this.rLR = snsUploadUI;
    }

    public final void run() {
        OnDragListener 1 = new 1(this);
        if (SnsUploadUI.g(this.rLR) != null) {
            SnsUploadUI.g(this.rLR).setOnDragListener(1);
        }
    }
}
