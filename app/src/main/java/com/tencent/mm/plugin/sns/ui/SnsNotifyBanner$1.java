package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;

class SnsNotifyBanner$1 implements OnClickListener {
    final /* synthetic */ SnsNotifyBanner rEv;

    SnsNotifyBanner$1(SnsNotifyBanner snsNotifyBanner) {
        this.rEv = snsNotifyBanner;
    }

    public final void onClick(View view) {
        this.rEv.setVisibility(8);
    }
}
