package com.tencent.mm.plugin.radar.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import b.c.b.e;
import com.tencent.mm.plugin.radar.ui.RadarStateView.b;

public final class RadarStateView$b$a implements AnimationListener {
    final /* synthetic */ b pyZ;

    RadarStateView$b$a(b bVar) {
        this.pyZ = bVar;
    }

    public final void onAnimationStart(Animation animation) {
        e.i(animation, "animation");
    }

    public final void onAnimationEnd(Animation animation) {
        e.i(animation, "animation");
        RadarStateView.b(this.pyZ.pyY);
        this.pyZ.pyY.setVisibility(8);
    }

    public final void onAnimationRepeat(Animation animation) {
        e.i(animation, "animation");
    }
}
