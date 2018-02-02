package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;

class SnsNotInterestUI$2 implements OnClickListener {
    final /* synthetic */ SnsNotInterestUI rEr;

    SnsNotInterestUI$2(SnsNotInterestUI snsNotInterestUI) {
        this.rEr = snsNotInterestUI;
    }

    public final void onClick(View view) {
        SnsNotInterestUI.a(this.rEr).requestFocus();
        this.rEr.aWs();
    }
}
