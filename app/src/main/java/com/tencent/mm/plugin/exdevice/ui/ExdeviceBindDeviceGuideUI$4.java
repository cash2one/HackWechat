package com.tencent.mm.plugin.exdevice.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.g.a.e.a;
import com.tencent.mm.sdk.platformtools.x;

class ExdeviceBindDeviceGuideUI$4 extends BroadcastReceiver {
    final /* synthetic */ ExdeviceBindDeviceGuideUI lSn;

    ExdeviceBindDeviceGuideUI$4(ExdeviceBindDeviceGuideUI exdeviceBindDeviceGuideUI) {
        this.lSn = exdeviceBindDeviceGuideUI;
    }

    public final void onReceive(Context context, Intent intent) {
        x.i("MicroMsg.ExdeviceBindDeviceGuideUI", "Action broadcast receive...");
        if (intent != null) {
            String action = intent.getAction();
            x.d("MicroMsg.ExdeviceBindDeviceGuideUI", "Receiver action(%s)", action);
            int intExtra;
            if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(action) && ExdeviceBindDeviceGuideUI.m(this.lSn)) {
                intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1);
                if (intExtra == 12) {
                    if (!ExdeviceBindDeviceGuideUI.o(this.lSn) || ExdeviceBindDeviceGuideUI.p(this.lSn).isProviderEnabled("gps")) {
                        ExdeviceBindDeviceGuideUI.a(this.lSn, 2);
                        return;
                    }
                } else if (intExtra == 10) {
                    ExdeviceBindDeviceGuideUI.a(this.lSn, 3);
                    return;
                } else {
                    return;
                }
            } else if ("android.net.wifi.WIFI_STATE_CHANGED".equals(action) && ExdeviceBindDeviceGuideUI.n(this.lSn)) {
                intExtra = intent.getIntExtra("wifi_state", -1);
                x.i("MicroMsg.ExdeviceBindDeviceGuideUI", "Wifi state changed action: wifiState(%d)", Integer.valueOf(intExtra));
                if (intExtra == 3) {
                    ExdeviceBindDeviceGuideUI.a(this.lSn, 1);
                    return;
                } else if (intExtra == 1) {
                    ExdeviceBindDeviceGuideUI.a(this.lSn, 5);
                    return;
                } else {
                    return;
                }
            } else if (!ExdeviceBindDeviceGuideUI.o(this.lSn) || !"android.location.MODE_CHANGED".equals(action)) {
                return;
            } else {
                if (ExdeviceBindDeviceGuideUI.p(this.lSn).isProviderEnabled("gps")) {
                    if (a.arv()) {
                        ExdeviceBindDeviceGuideUI.a(this.lSn, 2);
                        return;
                    } else {
                        ExdeviceBindDeviceGuideUI.a(this.lSn, 3);
                        return;
                    }
                }
            }
            ExdeviceBindDeviceGuideUI.a(this.lSn, 6);
        }
    }
}
