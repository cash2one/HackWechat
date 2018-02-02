package com.tencent.mm.plugin.mmsight.ui.progressbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class b$2 extends AnimatorListenerAdapter {
    final /* synthetic */ b oEi;

    b$2(b bVar) {
        this.oEi = bVar;
    }

    public final void onAnimationStart(Animator animator) {
        this.oEi.oDU = true;
    }

    public final void onAnimationEnd(Animator animator) {
        this.oEi.oDU = true;
        if (this.oEi.oDV != null) {
            this.oEi.oDV.a(this.oEi.oDT);
        }
    }
}
