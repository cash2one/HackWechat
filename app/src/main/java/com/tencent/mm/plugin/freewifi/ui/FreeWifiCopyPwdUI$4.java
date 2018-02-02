package com.tencent.mm.plugin.freewifi.ui;

import android.os.Message;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiCopyPwdUI.b;
import com.tencent.mm.sdk.platformtools.af;

class FreeWifiCopyPwdUI$4 extends af {
    final /* synthetic */ FreeWifiCopyPwdUI mGY;

    FreeWifiCopyPwdUI$4(FreeWifiCopyPwdUI freeWifiCopyPwdUI) {
        this.mGY = freeWifiCopyPwdUI;
    }

    public final void handleMessage(Message message) {
        b bVar = (b) message.obj;
        if (bVar.mHc == FreeWifiCopyPwdUI.b(this.mGY)) {
            FreeWifiCopyPwdUI.a(this.mGY, bVar.data);
        } else {
            FreeWifiCopyPwdUI.b(this.mGY, bVar.data);
        }
    }
}
