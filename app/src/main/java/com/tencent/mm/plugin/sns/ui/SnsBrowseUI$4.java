package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.tools.g$b;

class SnsBrowseUI$4 implements g$b {
    final /* synthetic */ SnsBrowseUI rzl;

    SnsBrowseUI$4(SnsBrowseUI snsBrowseUI) {
        this.rzl = snsBrowseUI;
    }

    public final void onAnimationStart() {
        SnsInfoFlip snsInfoFlip = this.rzl.ryY;
        if (snsInfoFlip.rCh != null) {
            snsInfoFlip.rCh.setVisibility(8);
        }
        SnsBrowseUI.e(this.rzl).postDelayed(new Runnable(this) {
            final /* synthetic */ SnsBrowseUI$4 rzo;

            {
                this.rzo = r1;
            }

            public final void run() {
                SnsInfoFlip snsInfoFlip = this.rzo.rzl.ryY;
                if (snsInfoFlip.rBU != null) {
                    View selectedView = snsInfoFlip.rBU.getSelectedView();
                    if (selectedView instanceof MultiTouchImageView) {
                        ((MultiTouchImageView) selectedView).cpS();
                    }
                }
            }
        }, 20);
    }

    public final void onAnimationEnd() {
        SnsBrowseUI.e(this.rzl).post(new 2(this));
    }
}
