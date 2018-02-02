package com.tencent.mm.plugin.radar.ui;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import b.c.a.a;
import b.c.b.f;

final class RadarTipsView$e extends f implements a<Animation> {
    final /* synthetic */ RadarTipsView pzA;

    RadarTipsView$e(RadarTipsView radarTipsView) {
        this.pzA = radarTipsView;
    }

    public final /* synthetic */ Object invoke() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.pzA.getContext(), com.tencent.mm.plugin.radar.a.a.pvq);
        loadAnimation.setAnimationListener(new a(this));
        return loadAnimation;
    }
}
