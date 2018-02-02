package com.tencent.mm.plugin.radar.ui;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import b.c.a.a;
import b.c.b.f;

final class RadarTipsView$d extends f implements a<Animation> {
    final /* synthetic */ RadarTipsView pzA;

    RadarTipsView$d(RadarTipsView radarTipsView) {
        this.pzA = radarTipsView;
    }

    public final /* synthetic */ Object invoke() {
        return AnimationUtils.loadAnimation(this.pzA.getContext(), com.tencent.mm.plugin.radar.a.a.pvp);
    }
}
