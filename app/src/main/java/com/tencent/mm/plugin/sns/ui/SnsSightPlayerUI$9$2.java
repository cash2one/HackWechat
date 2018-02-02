package com.tencent.mm.plugin.sns.ui;

import android.view.animation.AnimationUtils;
import com.tencent.mm.plugin.sns.i.a;
import com.tencent.mm.plugin.sns.ui.SnsSightPlayerUI.9;

class SnsSightPlayerUI$9$2 implements Runnable {
    final /* synthetic */ 9 rGz;

    SnsSightPlayerUI$9$2(9 9) {
        this.rGz = 9;
    }

    public final void run() {
        if (SnsSightPlayerUI.j(this.rGz.rGv).getVisibility() != 0) {
            SnsSightPlayerUI.j(this.rGz.rGv).setVisibility(0);
            SnsSightPlayerUI.j(this.rGz.rGv).startAnimation(AnimationUtils.loadAnimation(this.rGz.rGv.mController.xIM, a.bpZ));
        }
    }
}
