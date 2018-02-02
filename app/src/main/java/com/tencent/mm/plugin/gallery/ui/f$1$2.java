package com.tencent.mm.plugin.gallery.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mm.plugin.gallery.a.a;
import com.tencent.mm.plugin.gallery.ui.f.1;

class f$1$2 implements AnimationListener {
    final /* synthetic */ 1 mUI;

    f$1$2(1 1) {
        this.mUI = 1;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        a.swap(f.d(this.mUI.mUF), f.e(this.mUI.mUF), f.f(this.mUI.mUF));
        if (f.a(this.mUI.mUF) == null) {
            return;
        }
        if (this.mUI.fJA > f.e(this.mUI.mUF) && this.mUI.fJA <= f.f(this.mUI.mUF)) {
            f.a(this.mUI.mUF).L(f.e(this.mUI.mUF), f.f(this.mUI.mUF), this.mUI.fJA - 1);
        } else if (this.mUI.fJA < f.e(this.mUI.mUF) && this.mUI.fJA >= f.f(this.mUI.mUF)) {
            f.a(this.mUI.mUF).L(f.e(this.mUI.mUF), f.f(this.mUI.mUF), this.mUI.fJA + 1);
        } else if (f.e(this.mUI.mUF) == this.mUI.fJA) {
            f.a(this.mUI.mUF).L(f.e(this.mUI.mUF), f.f(this.mUI.mUF), f.f(this.mUI.mUF));
        } else {
            f.a(this.mUI.mUF).L(f.e(this.mUI.mUF), f.f(this.mUI.mUF), this.mUI.fJA);
        }
    }

    public final void onAnimationRepeat(Animation animation) {
    }
}
