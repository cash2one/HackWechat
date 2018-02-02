package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI.5;
import com.tencent.mm.plugin.sns.ui.b.b;
import com.tencent.mm.sdk.platformtools.af;

class SnsAdNativeLandingPagesUI$5$1 implements b {
    final /* synthetic */ 5 ryw;

    SnsAdNativeLandingPagesUI$5$1(5 5) {
        this.ryw = 5;
    }

    public final void onAnimationStart() {
        SnsAdNativeLandingPagesUI.J(this.ryw.ryv).setVisibility(8);
    }

    public final void onAnimationEnd() {
        new af().post(new Runnable(this) {
            final /* synthetic */ SnsAdNativeLandingPagesUI$5$1 ryx;

            {
                this.ryx = r1;
            }

            public final void run() {
                this.ryx.ryw.ryv.finish();
                this.ryx.ryw.ryv.overridePendingTransition(0, 0);
            }
        });
    }
}
