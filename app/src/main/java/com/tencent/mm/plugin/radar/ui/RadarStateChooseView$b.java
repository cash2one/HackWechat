package com.tencent.mm.plugin.radar.ui;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import b.c.a.a;
import b.c.b.e;
import b.c.b.f;

final class RadarStateChooseView$b extends f implements a<Animation> {
    final /* synthetic */ RadarStateChooseView pyR;

    RadarStateChooseView$b(RadarStateChooseView radarStateChooseView) {
        this.pyR = radarStateChooseView;
    }

    public final /* synthetic */ Object invoke() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.pyR.getContext(), com.tencent.mm.plugin.radar.a.a.pvl);
        loadAnimation.setAnimationListener(new a(this));
        e.h(loadAnimation, "AnimationUtils.loadAnima…\n            })\n        }");
        return loadAnimation;
    }
}
