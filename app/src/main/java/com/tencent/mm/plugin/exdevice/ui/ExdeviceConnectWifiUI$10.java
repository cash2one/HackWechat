package com.tencent.mm.plugin.exdevice.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectWifiUI.b;

class ExdeviceConnectWifiUI$10 implements OnMenuItemClickListener {
    final /* synthetic */ ExdeviceConnectWifiUI lTI;

    ExdeviceConnectWifiUI$10(ExdeviceConnectWifiUI exdeviceConnectWifiUI) {
        this.lTI = exdeviceConnectWifiUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (!ExdeviceConnectWifiUI.h(this.lTI)) {
            boolean z;
            Intent intent = new Intent();
            String str = "is_wifi_connected";
            if (ExdeviceConnectWifiUI.d(this.lTI) != b.lTT) {
                z = true;
            } else {
                z = false;
            }
            intent.putExtra(str, z);
            this.lTI.setResult(0, intent);
            this.lTI.finish();
        }
        return false;
    }
}
