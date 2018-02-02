package com.tencent.mm.plugin.sight.encode.ui;

import android.view.animation.AnimationUtils;
import com.tencent.mm.R;

class MainSightForwardContainerView$4 implements Runnable {
    final /* synthetic */ MainSightForwardContainerView qwN;

    MainSightForwardContainerView$4(MainSightForwardContainerView mainSightForwardContainerView) {
        this.qwN = mainSightForwardContainerView;
    }

    public final void run() {
        if (!MainSightForwardContainerView.b(this.qwN) || (MainSightForwardContainerView.a(this.qwN) != null && MainSightForwardContainerView.a(this.qwN).qxi.btA())) {
            MainSightForwardContainerView.c(this.qwN);
            return;
        }
        MainSightForwardContainerView.d(this.qwN).setVisibility(0);
        if (MainSightForwardContainerView.a(this.qwN) != null && !MainSightForwardContainerView.a(this.qwN).btI() && MainSightForwardContainerView.e(this.qwN).getVisibility() != 0) {
            MainSightForwardContainerView.e(this.qwN).setVisibility(0);
            MainSightForwardContainerView.e(this.qwN).startAnimation(AnimationUtils.loadAnimation(MainSightForwardContainerView.f(this.qwN), R.a.bpZ));
        }
    }
}
