package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class FreeWifiCopyPwdUI$2 implements OnClickListener {
    final /* synthetic */ FreeWifiCopyPwdUI mGY;

    FreeWifiCopyPwdUI$2(FreeWifiCopyPwdUI freeWifiCopyPwdUI) {
        this.mGY = freeWifiCopyPwdUI;
    }

    public final void onClick(View view) {
        this.mGY.startActivityForResult(new Intent("android.settings.WIFI_SETTINGS"), FreeWifiCopyPwdUI.mGS);
    }
}
