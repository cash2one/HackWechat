package com.tencent.mm.plugin.collect.reward.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class QrRewardMainUI$11 implements OnClickListener {
    final /* synthetic */ QrRewardMainUI lkA;

    QrRewardMainUI$11(QrRewardMainUI qrRewardMainUI) {
        this.lkA = qrRewardMainUI;
    }

    public final void onClick(View view) {
        x.d("MicroMsg.QrRewardMainUI", "click avatar");
        this.lkA.aWs();
        QrRewardMainUI.a(this.lkA);
    }
}
