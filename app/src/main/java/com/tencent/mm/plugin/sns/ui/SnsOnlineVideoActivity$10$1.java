package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity.10;
import com.tencent.mm.ui.tools.g$b;

class SnsOnlineVideoActivity$10$1 implements g$b {
    final /* synthetic */ 10 rEH;

    SnsOnlineVideoActivity$10$1(10 10) {
        this.rEH = 10;
    }

    public final void onAnimationStart() {
    }

    public final void onAnimationEnd() {
        if (SnsOnlineVideoActivity.c(this.rEH.rEF) != null) {
            SnsOnlineVideoActivity.c(this.rEH.rEF).onResume();
        }
    }
}
