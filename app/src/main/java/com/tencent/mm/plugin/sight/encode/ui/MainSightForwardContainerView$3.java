package com.tencent.mm.plugin.sight.encode.ui;

import android.view.animation.TranslateAnimation;

class MainSightForwardContainerView$3 implements Runnable {
    final /* synthetic */ MainSightForwardContainerView qwN;

    public MainSightForwardContainerView$3(MainSightForwardContainerView mainSightForwardContainerView) {
        this.qwN = mainSightForwardContainerView;
    }

    public final void run() {
        MainSightSelectContactView a = MainSightForwardContainerView.a(this.qwN);
        a.qwD = false;
        a.Fv.clearAnimation();
        a.Fv.clearFocus();
        a.Fv.setAdapter(a.qxk);
        a.z(false, true);
        a.setVisibility(0);
        if (a.qxj == null) {
            a.qxj = new TranslateAnimation(0.0f, 0.0f, (float) a.qxh, 0.0f);
            a.qxj.setDuration(300);
        }
        a.Fv.startAnimation(a.qxj);
    }
}
