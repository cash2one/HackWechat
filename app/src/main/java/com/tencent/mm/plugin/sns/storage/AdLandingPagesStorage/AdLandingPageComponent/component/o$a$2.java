package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.o.a;
import com.tencent.mm.sdk.platformtools.af;

class o$a$2 implements AnimationListener {
    final /* synthetic */ ImageView rkm;
    final /* synthetic */ a rkn;

    o$a$2(a aVar, ImageView imageView) {
        this.rkn = aVar;
        this.rkm = imageView;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        new af().postDelayed(new 1(this), 200);
    }

    public final void onAnimationRepeat(Animation animation) {
    }
}
