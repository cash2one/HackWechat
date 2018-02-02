package com.tencent.mm.plugin.radar.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import b.c.b.e;
import com.tencent.mm.plugin.radar.ui.RadarStateChooseView.b;

public final class RadarStateChooseView$b$a implements AnimationListener {
    final /* synthetic */ b pyS;

    RadarStateChooseView$b$a(b bVar) {
        this.pyS = bVar;
    }

    public final void onAnimationStart(Animation animation) {
        e.i(animation, "animation");
    }

    public final void onAnimationEnd(Animation animation) {
        e.i(animation, "animation");
        RadarStateChooseView.a(this.pyS.pyR);
        this.pyS.pyR.setVisibility(8);
    }

    public final void onAnimationRepeat(Animation animation) {
        e.i(animation, "animation");
    }
}
