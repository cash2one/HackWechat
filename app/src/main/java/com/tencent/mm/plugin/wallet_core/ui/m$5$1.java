package com.tencent.mm.plugin.wallet_core.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mm.plugin.wallet_core.ui.m.5;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class m$5$1 implements AnimationListener {
    final /* synthetic */ 5 sVW;

    m$5$1(5 5) {
        this.sVW = 5;
    }

    public final void onAnimationStart(Animation animation) {
        x.i("MicroMsg.WalletPwdDialog", "hy: on flash start");
        ag.y(new Runnable(this) {
            final /* synthetic */ m$5$1 sVX;

            {
                this.sVX = r1;
            }

            public final void run() {
                this.sVX.sVW.sVV.sVL.setVisibility(0);
            }
        });
    }

    public final void onAnimationEnd(Animation animation) {
        x.i("MicroMsg.WalletPwdDialog", "hy: on flash end");
        ag.y(new 2(this));
    }

    public final void onAnimationRepeat(Animation animation) {
    }
}
