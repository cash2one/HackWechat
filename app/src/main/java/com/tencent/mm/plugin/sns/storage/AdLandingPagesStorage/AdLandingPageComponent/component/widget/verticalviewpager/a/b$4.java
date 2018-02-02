package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;

class b$4 implements AnimationListener {
    final /* synthetic */ b rnf;

    b$4(b bVar) {
        this.rnf = bVar;
    }

    public final void onAnimationStart(Animation animation) {
        x.d("ContentFragment", "onAnimationStart show nextBtn");
        b.a(this.rnf).rnr = true;
    }

    public final void onAnimationEnd(Animation animation) {
        new af().postDelayed(new 1(this), 200);
    }

    public final void onAnimationRepeat(Animation animation) {
    }
}
