package com.tencent.mm.plugin.sns.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class SnsAdNativeLandingPagesUI$9 extends BroadcastReceiver {
    final /* synthetic */ SnsAdNativeLandingPagesUI ryv;

    SnsAdNativeLandingPagesUI$9(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        this.ryv = snsAdNativeLandingPagesUI;
    }

    public final void onReceive(Context context, Intent intent) {
        SnsAdNativeLandingPagesUI.b(this.ryv);
    }
}
