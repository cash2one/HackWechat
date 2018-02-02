package com.tencent.mm.ui.snackbar;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class SnackContainer$1 implements AnimationListener {
    final /* synthetic */ SnackContainer zfQ;

    SnackContainer$1(SnackContainer snackContainer) {
        this.zfQ = snackContainer;
    }

    public final void onAnimationStart(Animation animation) {
        if (!this.zfQ.isEmpty() && SnackContainer.a(this.zfQ).peek() != null && ((SnackContainer$a) SnackContainer.a(this.zfQ).peek()).zfV != null) {
            a.nm(false);
            ((SnackContainer$a) SnackContainer.a(this.zfQ).peek()).zfV.aON();
        }
    }

    public final void onAnimationEnd(Animation animation) {
        this.zfQ.removeAllViews();
        if (!SnackContainer.a(this.zfQ).isEmpty()) {
            SnackContainer.b((SnackContainer$a) SnackContainer.a(this.zfQ).poll());
        }
        if (this.zfQ.isEmpty()) {
            this.zfQ.setVisibility(8);
        } else {
            SnackContainer.a(this.zfQ, (SnackContainer$a) SnackContainer.a(this.zfQ).peek());
        }
    }

    public final void onAnimationRepeat(Animation animation) {
    }
}
