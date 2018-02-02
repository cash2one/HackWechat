package com.tencent.mm.plugin.mmsight.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.mm.sdk.platformtools.x;

class MMSightRecordButton$9 extends AnimatorListenerAdapter {
    final /* synthetic */ MMSightRecordButton oBt;
    final /* synthetic */ long oBw;

    MMSightRecordButton$9(MMSightRecordButton mMSightRecordButton, long j) {
        this.oBt = mMSightRecordButton;
        this.oBw = j;
    }

    public final void onAnimationEnd(Animator animator) {
        if (MMSightRecordButton.g(this.oBt) > 0 && this.oBw <= 500) {
            x.i("MicroMsg.MMSightRecordButton", "on Simple Tap, isDispatchSimpleTap: %s, isDispatchLongPress: %s", new Object[]{Boolean.valueOf(MMSightRecordButton.a(this.oBt)), Boolean.valueOf(MMSightRecordButton.b(this.oBt))});
            MMSightRecordButton.h(this.oBt);
            if (!MMSightRecordButton.b(this.oBt) && MMSightRecordButton.i(this.oBt) != null) {
                MMSightRecordButton.i(this.oBt).bby();
            }
        } else if (MMSightRecordButton.b(this.oBt)) {
            x.i("MicroMsg.MMSightRecordButton", "on Long Press finish");
            if (MMSightRecordButton.d(this.oBt) != null) {
                MMSightRecordButton.d(this.oBt).bbx();
            }
        } else {
            x.i("MicroMsg.MMSightRecordButton", "error action up");
            if (MMSightRecordButton.j(this.oBt) != null) {
                MMSightRecordButton.j(this.oBt).bbu();
            }
        }
    }
}
