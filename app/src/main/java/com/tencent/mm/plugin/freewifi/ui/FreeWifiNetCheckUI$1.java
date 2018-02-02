package com.tencent.mm.plugin.freewifi.ui;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.af;

class FreeWifiNetCheckUI$1 extends af {
    int i = 0;
    final /* synthetic */ FreeWifiNetCheckUI mIe;

    FreeWifiNetCheckUI$1(FreeWifiNetCheckUI freeWifiNetCheckUI) {
        this.mIe = freeWifiNetCheckUI;
    }

    public final void handleMessage(Message message) {
        if (message.what == 1) {
            if (this.i >= FreeWifiNetCheckUI.a(this.mIe).length) {
                this.i = 0;
            }
            this.mIe.mHO.setImageResource(FreeWifiNetCheckUI.a(this.mIe)[this.i]);
            this.i++;
        } else if (message.what == 2) {
            this.mIe.mHO.setImageResource(FreeWifiNetCheckUI.a(this.mIe)[FreeWifiNetCheckUI.a(this.mIe).length - 1]);
        }
        super.handleMessage(message);
    }
}
