package com.tencent.mm.plugin.radar.ui;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import b.c.a.a;
import b.c.b.f;

final class RadarStateView$b extends f implements a<Animation> {
    final /* synthetic */ RadarStateView pyY;

    RadarStateView$b(RadarStateView radarStateView) {
        this.pyY = radarStateView;
    }

    public final /* synthetic */ Object invoke() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.pyY.getContext(), com.tencent.mm.plugin.radar.a.a.pvn);
        loadAnimation.setAnimationListener(new a(this));
        return loadAnimation;
    }
}
