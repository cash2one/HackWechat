package com.tencent.mm.plugin.sns.ui;

import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;

class SnsSightPlayerUI$14 implements Runnable {
    final /* synthetic */ SnsSightPlayerUI rGv;

    SnsSightPlayerUI$14(SnsSightPlayerUI snsSightPlayerUI) {
        this.rGv = snsSightPlayerUI;
    }

    public final void run() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.rGv.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        if (SnsSightPlayerUI.f(this.rGv) instanceof VideoSightView) {
            ((VideoSightView) SnsSightPlayerUI.f(this.rGv)).wj(displayMetrics.widthPixels);
        }
        ((View) SnsSightPlayerUI.f(this.rGv)).requestLayout();
        ((View) SnsSightPlayerUI.f(this.rGv)).postInvalidate();
    }
}
