package com.tencent.mm.plugin.freewifi.model;

import android.net.wifi.WifiInfo;
import android.os.Build.VERSION;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.x;

public final class f {
    private b mEg;

    private static class a {
        private static f mEh = new f();
    }

    private f() {
    }

    public final synchronized void aLH() {
        if (this.mEg != null) {
            x.i("MicroMsg.FreeWifi.FreeWifiNetChangeManager.onNetworkChangeFreeWifi", "last WifiInfo stored in memmory : ssid=%s, bssid=%s ", new Object[]{this.mEg.mEi, this.mEg.mEj});
        } else {
            x.i("MicroMsg.FreeWifi.FreeWifiNetChangeManager.onNetworkChangeFreeWifi", "last WifiInfo stored in memmory is null.");
        }
        this.mEg = null;
        x.i("MicroMsg.FreeWifi.FreeWifiNetChangeManager.onNetworkChangeFreeWifi", "new WifiInfo stored in memmory is null.");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean a(WifiInfo wifiInfo) {
        boolean z = false;
        synchronized (this) {
            if (wifiInfo != null) {
                if (!(wifiInfo.getSSID() == null || wifiInfo.getBSSID() == null || wifiInfo.getMacAddress() == null)) {
                    if (this.mEg != null) {
                        x.i("MicroMsg.FreeWifi.FreeWifiNetChangeManager.onNetworkChangeFreeWifi", "last WifiInfo stored in memmory : ssid=%s, bssid=%s ", new Object[]{this.mEg.mEi, this.mEg.mEj});
                        if (m.AB(wifiInfo.getSSID()).equals(this.mEg.mEi)) {
                        }
                    } else {
                        x.i("MicroMsg.FreeWifi.FreeWifiNetChangeManager.onNetworkChangeFreeWifi", "last WifiInfo stored in memmory is null.");
                    }
                    String macAddress = wifiInfo.getMacAddress();
                    if (VERSION.SDK_INT > 22 && (macAddress == null || macAddress.equals("02:00:00:00:00:00"))) {
                        macAddress = m.aLj();
                    }
                    this.mEg = new b(m.AB(wifiInfo.getSSID()), wifiInfo.getBSSID(), macAddress, System.currentTimeMillis(), (byte) 0);
                    x.i("MicroMsg.FreeWifi.FreeWifiNetChangeManager.onNetworkChangeFreeWifi", "new WifiInfo stored in memmory : ssid=%s, bssid=%s ", new Object[]{this.mEg.mEi, this.mEg.mEj});
                    z = true;
                }
            }
            x.i("MicroMsg.FreeWifi.FreeWifiNetChangeManager.onNetworkChangeFreeWifi", "WifiInfo got Currently is null. Cannot compared with last WifiInfo.");
        }
        return z;
    }

    public final synchronized b aLI() {
        return this.mEg;
    }

    public final synchronized void aLJ() {
        if (this.mEg != null) {
            b bVar;
            b bVar2 = this.mEg;
            if (bVar2.mEl) {
                bVar = bVar2;
            } else {
                bVar = new b(bVar2.mEi, bVar2.mEj, bVar2.mEk, bVar2.mDY);
                bVar.mEl = true;
            }
            this.mEg = bVar;
        }
    }
}
