package com.tencent.mm.plugin.mmsight.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.1;
import com.tencent.mm.sdk.platformtools.x;

class MMSightRecordButton$1$1 extends AnimatorListenerAdapter {
    final /* synthetic */ 1 oBu;

    MMSightRecordButton$1$1(1 1) {
        this.oBu = 1;
    }

    public final void onAnimationEnd(Animator animator) {
        x.k("MicroMsg.MMSightRecordButton", "call onProgressFinish", new Object[0]);
        if (this.oBu.oBs != null) {
            this.oBu.oBs.bbs();
        }
    }
}
