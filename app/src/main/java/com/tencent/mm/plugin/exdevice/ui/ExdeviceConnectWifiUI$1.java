package com.tencent.mm.plugin.exdevice.ui;

import android.text.Selection;
import android.text.Spannable;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class ExdeviceConnectWifiUI$1 implements Runnable {
    final /* synthetic */ ExdeviceConnectWifiUI lTI;

    ExdeviceConnectWifiUI$1(ExdeviceConnectWifiUI exdeviceConnectWifiUI) {
        this.lTI = exdeviceConnectWifiUI;
    }

    public final void run() {
        if (bh.ov(ExdeviceConnectWifiUI.a(this.lTI))) {
            ExdeviceConnectWifiUI.c(this.lTI).setText(ExdeviceConnectWifiUI.b(this.lTI).lOf);
            Spannable text = ExdeviceConnectWifiUI.c(this.lTI).getText();
            if (text != null) {
                Selection.setSelection(text, text.length());
                return;
            }
            return;
        }
        x.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "User has input password.");
    }
}
