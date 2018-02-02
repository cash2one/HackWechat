package com.tencent.mm.plugin.sns.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.LinearLayout;

class av$7 implements AnimationListener {
    boolean rAK = false;
    final /* synthetic */ LinearLayout rAL;
    final /* synthetic */ av rHD;
    final /* synthetic */ Runnable rHF;

    av$7(av avVar, LinearLayout linearLayout, Runnable runnable) {
        this.rHD = avVar;
        this.rAL = linearLayout;
        this.rHF = runnable;
    }

    public final void onAnimationEnd(Animation animation) {
        if (this.rAL != null) {
            this.rAL.setPressed(false);
        }
        if (!this.rAK) {
            this.rAK = true;
            if ((this.rHD.fmM instanceof u) && ((u) this.rHD.fmM).bzr()) {
                this.rHD.rHo.notifyDataSetChanged();
            }
        }
        if (this.rHF != null) {
            this.rHF.run();
        }
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationStart(Animation animation) {
    }
}
