package com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal;

import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import java.util.List;

public final class c {
    public static WifiManager bgP;

    public static List<WifiConfiguration> getConfiguredNetworks() {
        try {
            return bgP.getConfiguredNetworks();
        } catch (Throwable th) {
            th.toString();
            return null;
        }
    }

    public static int addNetwork(WifiConfiguration wifiConfiguration) {
        try {
            return bgP.addNetwork(wifiConfiguration);
        } catch (Throwable th) {
            th.toString();
            return d.jvR;
        }
    }

    public static boolean removeNetwork(int i) {
        try {
            return bgP.removeNetwork(i);
        } catch (Throwable th) {
            th.toString();
            return false;
        }
    }

    public static boolean kN(int i) {
        try {
            return bgP.enableNetwork(i, true);
        } catch (Throwable th) {
            th.toString();
            return false;
        }
    }

    public static boolean disableNetwork(int i) {
        try {
            return bgP.disableNetwork(i);
        } catch (Throwable th) {
            th.toString();
            return false;
        }
    }

    public static boolean startScan() {
        try {
            return bgP.startScan();
        } catch (Throwable th) {
            th.toString();
            return false;
        }
    }

    public static WifiInfo getConnectionInfo() {
        try {
            return bgP.getConnectionInfo();
        } catch (Throwable th) {
            th.toString();
            return null;
        }
    }

    public static List<ScanResult> getScanResults() {
        try {
            return bgP.getScanResults();
        } catch (Throwable th) {
            th.toString();
            return null;
        }
    }

    public static boolean saveConfiguration() {
        try {
            return bgP.saveConfiguration();
        } catch (Throwable th) {
            th.toString();
            return false;
        }
    }

    public static boolean isWifiEnabled() {
        try {
            return bgP.isWifiEnabled();
        } catch (Throwable th) {
            th.toString();
            return false;
        }
    }
}
