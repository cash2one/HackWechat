package com.tencent.mm.ui;

import android.view.View;
import android.view.animation.AnimationUtils;
import com.tencent.mm.R;

class h$10 implements Runnable {
    final /* synthetic */ View xFC;
    final /* synthetic */ h xFs;

    h$10(h hVar, View view) {
        this.xFs = hVar;
        this.xFC = view;
    }

    public final void run() {
        this.xFC.setVisibility(8);
        this.xFC.startAnimation(AnimationUtils.loadAnimation(this.xFs.getContext(), R.a.bqa));
    }
}
