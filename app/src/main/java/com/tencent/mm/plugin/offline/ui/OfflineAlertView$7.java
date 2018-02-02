package com.tencent.mm.plugin.offline.ui;

import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mm.sdk.platformtools.x;

class OfflineAlertView$7 implements Runnable {
    final /* synthetic */ View oXA;
    final /* synthetic */ OfflineAlertView oXD;

    OfflineAlertView$7(OfflineAlertView offlineAlertView, View view) {
        this.oXD = offlineAlertView;
        this.oXA = view;
    }

    public final void run() {
        x.i("MicroMsg.OfflineAlertView", "qrCodeView.getHeight%s %s", new Object[]{Integer.valueOf(this.oXA.getHeight()), Integer.valueOf(this.oXA.getMeasuredHeight())});
        LayoutParams layoutParams = (LayoutParams) OfflineAlertView.a(this.oXD).getLayoutParams();
        if (this.oXA.getHeight() > 0) {
            layoutParams.height = this.oXA.getHeight();
            OfflineAlertView.a(this.oXD).setLayoutParams(layoutParams);
            OfflineAlertView.a(this.oXD).invalidate();
        }
        if (OfflineAlertView.b(this.oXD) != null) {
            OfflineAlertView.b(this.oXD).onShow();
        }
    }
}
