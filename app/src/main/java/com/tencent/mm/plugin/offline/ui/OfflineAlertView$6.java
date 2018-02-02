package com.tencent.mm.plugin.offline.ui;

import com.tencent.mm.ui.r;

class OfflineAlertView$6 extends r {
    final /* synthetic */ Runnable oXC;
    final /* synthetic */ OfflineAlertView oXD;

    OfflineAlertView$6(OfflineAlertView offlineAlertView, Runnable runnable) {
        this.oXD = offlineAlertView;
        this.oXC = runnable;
    }

    public final void ayX() {
        this.oXC.run();
    }
}
