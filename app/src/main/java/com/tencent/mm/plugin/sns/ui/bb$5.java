package com.tencent.mm.plugin.sns.ui;

import android.view.View.OnDragListener;

class bb$5 implements Runnable {
    final /* synthetic */ bb rLm;

    bb$5(bb bbVar) {
        this.rLm = bbVar;
    }

    public final void run() {
        OnDragListener 1 = new 1(this);
        if (this.rLm.raX != null) {
            this.rLm.raX.setOnDragListener(1);
        }
    }
}
