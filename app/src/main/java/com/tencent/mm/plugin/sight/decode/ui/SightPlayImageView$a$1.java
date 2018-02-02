package com.tencent.mm.plugin.sight.decode.ui;

import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView.a;

class SightPlayImageView$a$1 implements Runnable {
    final /* synthetic */ SightPlayImageView quK;
    final /* synthetic */ LayoutParams quL;
    final /* synthetic */ a quM;

    SightPlayImageView$a$1(a aVar, SightPlayImageView sightPlayImageView, LayoutParams layoutParams) {
        this.quM = aVar;
        this.quK = sightPlayImageView;
        this.quL = layoutParams;
    }

    public final void run() {
        this.quK.setLayoutParams(this.quL);
    }
}
