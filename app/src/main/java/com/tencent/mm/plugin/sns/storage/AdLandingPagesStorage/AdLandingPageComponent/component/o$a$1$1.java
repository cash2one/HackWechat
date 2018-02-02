package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.o.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.o.a.1;
import java.math.BigInteger;

class o$a$1$1 implements AnimationListener {
    final /* synthetic */ 1 rko;

    o$a$1$1(1 1) {
        this.rko = 1;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        long longValue = new BigInteger((String) this.rko.rkm.getTag()).longValue();
        if (longValue >= 3) {
            Animation alphaAnimation = new AlphaAnimation(0.8f, 0.0f);
            alphaAnimation.setDuration((long) this.rko.rkn.rkj);
            alphaAnimation.setInterpolator(new DecelerateInterpolator(1.2f));
            alphaAnimation.setAnimationListener(new 1(this));
            this.rko.rkm.startAnimation(alphaAnimation);
            return;
        }
        this.rko.rkm.setTag(String.valueOf(longValue + 1));
        a.a(this.rko.rkn, this.rko.rkm);
    }

    public final void onAnimationRepeat(Animation animation) {
    }
}
