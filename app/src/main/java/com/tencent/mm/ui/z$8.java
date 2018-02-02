package com.tencent.mm.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

class z$8 implements AnimationListener {
    final /* synthetic */ z xLL;
    final /* synthetic */ Runnable xLS;

    z$8(z zVar, Runnable runnable) {
        this.xLL = zVar;
        this.xLS = runnable;
    }

    public final void onAnimationStart(Animation animation) {
        this.xLL.isAnimating = true;
        ar.Dm().cfC();
        ag.Df(-8);
        this.xLL.w(true, 0);
        x.i("MicroMsg.LauncherUI.NewChattingTabUI", "klem pop out onAnimationStart");
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        this.xLL.isAnimating = false;
        this.xLL.xLA.setVisibility(8);
        ar.Dm().cfE();
        ag.Df(0);
        this.xLS.run();
        this.xLL.tryResetChattingSwipeStatus();
        x.i("MicroMsg.LauncherUI.NewChattingTabUI", "klem pop out onAnimationEnd");
    }
}
