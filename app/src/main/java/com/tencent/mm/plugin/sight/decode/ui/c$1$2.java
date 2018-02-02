package com.tencent.mm.plugin.sight.decode.ui;

import android.view.animation.AnimationUtils;
import com.tencent.mm.plugin.ah.a.a;
import com.tencent.mm.plugin.sight.decode.ui.c.1;

class c$1$2 implements Runnable {
    final /* synthetic */ 1 quV;

    c$1$2(1 1) {
        this.quV = 1;
    }

    public final void run() {
        c.d(this.quV.quU).setVisibility(0);
        c.d(this.quV.quU).startAnimation(AnimationUtils.loadAnimation(this.quV.quU.getContext(), a.bpZ));
    }
}
