package com.tencent.mm.plugin.radar.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mm.plugin.radar.ui.RadarTipsView.e;

public final class RadarTipsView$e$a implements AnimationListener {
    final /* synthetic */ e pzB;

    RadarTipsView$e$a(e eVar) {
        this.pzB = eVar;
    }

    public final void onAnimationStart(Animation animation) {
        b.c.b.e.i(animation, "animation");
    }

    public final void onAnimationEnd(Animation animation) {
        b.c.b.e.i(animation, "animation");
        if (!RadarTipsView.a(this.pzB.pzA)) {
            RadarTipsView.b(this.pzB.pzA).sendEmptyMessage(0);
        }
    }

    public final void onAnimationRepeat(Animation animation) {
        b.c.b.e.i(animation, "animation");
    }
}
