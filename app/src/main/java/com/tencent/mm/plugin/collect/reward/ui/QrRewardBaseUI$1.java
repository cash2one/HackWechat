package com.tencent.mm.plugin.collect.reward.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class QrRewardBaseUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ QrRewardBaseUI ljF;

    QrRewardBaseUI$1(QrRewardBaseUI qrRewardBaseUI) {
        this.ljF = qrRewardBaseUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.ljF.aWs();
        QrRewardBaseUI.a(this.ljF);
        this.ljF.finish();
        return false;
    }
}
