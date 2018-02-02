package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;

class SnsAdNativeLandingTestUI$6 implements OnClickListener {
    final /* synthetic */ SnsAdNativeLandingTestUI ryI;

    SnsAdNativeLandingTestUI$6(SnsAdNativeLandingTestUI snsAdNativeLandingTestUI) {
        this.ryI = snsAdNativeLandingTestUI;
    }

    public final void onClick(View view) {
        if (!"".equals(SnsAdNativeLandingTestUI.a(this.ryI).quA.qtl) && SnsAdNativeLandingTestUI.a(this.ryI).quA.qtl != null) {
            if (this.ryI.ryH.getVisibility() == 0) {
                this.ryI.ryH.setVisibility(4);
            } else {
                this.ryI.ryH.setVisibility(0);
            }
        }
    }
}
