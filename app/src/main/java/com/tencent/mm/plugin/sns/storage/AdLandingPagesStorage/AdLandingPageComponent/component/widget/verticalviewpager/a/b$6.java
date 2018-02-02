package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b.b;
import com.tencent.mm.sdk.platformtools.x;

class b$6 implements AnimationListener {
    final /* synthetic */ b rnf;
    final /* synthetic */ b rnl;

    b$6(b bVar, b bVar2) {
        this.rnf = bVar;
        this.rnl = bVar2;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        if (this.rnl.rnq.getVisibility() != 0) {
            x.d("ContentFragment", "nextBtn not visible");
            return;
        }
        Animation animationSet = new AnimationSet(true);
        Animation translateAnimation = new TranslateAnimation(0.0f, 0.0f, -10.0f, 0.0f);
        translateAnimation.setDuration((long) b.j(this.rnf));
        translateAnimation.setInterpolator(new DecelerateInterpolator(1.2f));
        translateAnimation.setStartTime((long) b.j(this.rnf));
        animationSet.addAnimation(translateAnimation);
        translateAnimation = new AlphaAnimation(0.3f, 0.8f);
        translateAnimation.setDuration((long) b.j(this.rnf));
        translateAnimation.setInterpolator(new DecelerateInterpolator(1.2f));
        translateAnimation.setStartTime((long) b.j(this.rnf));
        animationSet.addAnimation(translateAnimation);
        animationSet.setAnimationListener(new 1(this));
        this.rnl.rnq.startAnimation(animationSet);
    }

    public final void onAnimationRepeat(Animation animation) {
    }
}
