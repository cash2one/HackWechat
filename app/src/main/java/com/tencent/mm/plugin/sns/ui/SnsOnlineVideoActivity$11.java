package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.ui.tools.g.b;

class SnsOnlineVideoActivity$11 implements b {
    final /* synthetic */ SnsOnlineVideoActivity rEF;

    SnsOnlineVideoActivity$11(SnsOnlineVideoActivity snsOnlineVideoActivity) {
        this.rEF = snsOnlineVideoActivity;
    }

    public final void onAnimationStart() {
    }

    public final void onAnimationEnd() {
        new af().post(new 1(this));
    }
}
