package android.support.v7.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class SwitchCompat$1 implements AnimationListener {
    final /* synthetic */ boolean Zg;
    final /* synthetic */ SwitchCompat Zh;

    SwitchCompat$1(SwitchCompat switchCompat, boolean z) {
        this.Zh = switchCompat;
        this.Zg = z;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        if (SwitchCompat.a(this.Zh) == animation) {
            SwitchCompat.a(this.Zh, this.Zg ? 1.0f : 0.0f);
            SwitchCompat.b(this.Zh);
        }
    }

    public final void onAnimationRepeat(Animation animation) {
    }
}
