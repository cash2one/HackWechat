package com.tencent.mm.plugin.offline.ui;

import com.tencent.mm.ui.r;

class OfflineAlertView$5 extends r {
    final /* synthetic */ Runnable oXB;
    final /* synthetic */ OfflineAlertView oXD;

    OfflineAlertView$5(OfflineAlertView offlineAlertView, Runnable runnable) {
        this.oXD = offlineAlertView;
        this.oXB = runnable;
    }

    public final void ayX() {
        this.oXB.run();
    }
}
