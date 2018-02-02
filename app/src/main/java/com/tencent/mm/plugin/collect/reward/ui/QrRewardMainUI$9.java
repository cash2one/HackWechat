package com.tencent.mm.plugin.collect.reward.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;

class QrRewardMainUI$9 implements OnClickListener {
    final /* synthetic */ QrRewardMainUI lkA;

    QrRewardMainUI$9(QrRewardMainUI qrRewardMainUI) {
        this.lkA = qrRewardMainUI;
    }

    public final void onClick(View view) {
        x.d("MicroMsg.QrRewardMainUI", "open click");
        QrRewardMainUI.a(this.lkA, true);
        g.pQN.h(14721, new Object[]{Integer.valueOf(1), Integer.valueOf(1)});
    }
}
