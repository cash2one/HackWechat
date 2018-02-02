package com.tencent.mm.plugin.exdevice.ui;

import android.net.wifi.WifiInfo;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.sdk.platformtools.x;

class ExdeviceConnectWifiUI$2 implements Runnable {
    final /* synthetic */ ExdeviceConnectWifiUI lTI;
    final /* synthetic */ String lTJ;
    final /* synthetic */ String lTK;
    final /* synthetic */ WifiInfo lTL;

    ExdeviceConnectWifiUI$2(ExdeviceConnectWifiUI exdeviceConnectWifiUI, String str, String str2, WifiInfo wifiInfo) {
        this.lTI = exdeviceConnectWifiUI;
        this.lTJ = str;
        this.lTK = str2;
        this.lTL = wifiInfo;
    }

    public final void run() {
        ExdeviceConnectWifiUI.f(this.lTI).acquire();
        int startAirKissWithInter = Java2CExDevice.startAirKissWithInter(this.lTJ, this.lTK, ExdeviceConnectWifiUI.l(this.lTI), 60000, ExdeviceConnectWifiUI.m(this.lTI), ExdeviceConnectWifiUI.n(this.lTI));
        x.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "Start AirKiss result (%d). input ssid = %s, ssid by system = %s, bssid by system = %s", new Object[]{Integer.valueOf(startAirKissWithInter), this.lTK, this.lTL.getSSID(), this.lTL.getBSSID()});
    }
}
