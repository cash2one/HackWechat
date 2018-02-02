package com.tencent.mm.plugin.facedetect.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class b$3 implements Runnable {
    final /* synthetic */ b mkI;

    b$3(b bVar) {
        this.mkI = bVar;
    }

    public final void run() {
        this.mkI.miV.setAnimationListener(new AnimationListener(this) {
            final /* synthetic */ b$3 mkJ;

            {
                this.mkJ = r1;
            }

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                this.mkJ.mkI.ltB.setVisibility(8);
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
        this.mkI.ltB.startAnimation(this.mkI.miV);
    }
}
