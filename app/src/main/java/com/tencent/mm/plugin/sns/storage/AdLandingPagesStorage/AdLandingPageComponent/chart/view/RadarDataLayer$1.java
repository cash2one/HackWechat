package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import java.util.Map.Entry;

class RadarDataLayer$1 implements AnimatorUpdateListener {
    final /* synthetic */ RadarDataLayer riy;

    RadarDataLayer$1(RadarDataLayer radarDataLayer) {
        this.riy = radarDataLayer;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        for (Entry entry : RadarDataLayer.a(this.riy).entrySet()) {
            RadarDataLayer.b(this.riy).put(entry.getKey(), Float.valueOf(((Float) entry.getValue()).floatValue() * floatValue));
            this.riy.invalidate();
        }
    }
}
