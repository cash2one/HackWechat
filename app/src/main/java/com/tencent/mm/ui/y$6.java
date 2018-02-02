package com.tencent.mm.ui;

import android.view.View;
import android.view.animation.AnimationUtils;
import com.tencent.mm.R;

class y$6 implements Runnable {
    final /* synthetic */ View xFC;
    final /* synthetic */ y xKX;

    y$6(y yVar, View view) {
        this.xKX = yVar;
        this.xFC = view;
    }

    public final void run() {
        this.xFC.setVisibility(8);
        this.xFC.startAnimation(AnimationUtils.loadAnimation(this.xKX.getContext(), R.a.bqa));
    }
}
