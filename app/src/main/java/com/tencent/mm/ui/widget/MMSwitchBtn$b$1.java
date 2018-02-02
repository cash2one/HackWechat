package com.tencent.mm.ui.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mm.ui.widget.MMSwitchBtn.b;

class MMSwitchBtn$b$1 implements AnimationListener {
    final /* synthetic */ MMSwitchBtn zvt;
    final /* synthetic */ b zvu;

    MMSwitchBtn$b$1(b bVar, MMSwitchBtn mMSwitchBtn) {
        this.zvu = bVar;
        this.zvt = mMSwitchBtn;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        boolean z = true;
        if (MMSwitchBtn.a(this.zvu.zvs) != (this.zvu.direction == 1)) {
            MMSwitchBtn mMSwitchBtn = this.zvu.zvs;
            if (this.zvu.direction != 1) {
                z = false;
            }
            MMSwitchBtn.a(mMSwitchBtn, z);
            this.zvu.zvs.post(new 1(this));
        }
        MMSwitchBtn.c(this.zvu.zvs);
    }
}
