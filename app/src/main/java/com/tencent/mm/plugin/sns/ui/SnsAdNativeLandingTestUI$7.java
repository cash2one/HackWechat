package com.tencent.mm.plugin.sns.ui;

import android.util.DisplayMetrics;
import com.tencent.mm.ui.MMActivity;

class SnsAdNativeLandingTestUI$7 implements Runnable {
    final /* synthetic */ SnsAdNativeLandingTestUI ryI;

    SnsAdNativeLandingTestUI$7(SnsAdNativeLandingTestUI snsAdNativeLandingTestUI) {
        this.ryI = snsAdNativeLandingTestUI;
    }

    public final void run() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (this.ryI.mController.xIM instanceof MMActivity) {
            ((MMActivity) this.ryI.mController.xIM).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            SnsAdNativeLandingTestUI.a(this.ryI).wj(displayMetrics.widthPixels);
        }
        SnsAdNativeLandingTestUI.a(this.ryI).requestLayout();
        SnsAdNativeLandingTestUI.a(this.ryI).postInvalidate();
    }
}
