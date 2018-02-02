package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.ui.tools.g.b;

class SnsSightPlayerUI$4 implements b {
    final /* synthetic */ SnsSightPlayerUI rGv;

    SnsSightPlayerUI$4(SnsSightPlayerUI snsSightPlayerUI) {
        this.rGv = snsSightPlayerUI;
    }

    public final void onAnimationStart() {
        if (SnsSightPlayerUI.p(this.rGv) != null) {
            SnsSightPlayerUI.p(this.rGv).setVisibility(8);
        }
    }

    public final void onAnimationEnd() {
        new af().post(new 1(this));
    }
}
