package com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal;

import android.net.wifi.WifiConfiguration;
import java.util.List;

public final class b {
    public static int b(WifiConfiguration wifiConfiguration) {
        if (wifiConfiguration == null || wifiConfiguration.networkId >= 0) {
            return -1;
        }
        wifiConfiguration.networkId = c.addNetwork(wifiConfiguration);
        return wifiConfiguration.networkId;
    }

    public static boolean aD(String str, int i) {
        boolean z = false;
        if (str != null && str.length() > 0) {
            List<WifiConfiguration> configuredNetworks = c.getConfiguredNetworks();
            if (configuredNetworks != null) {
                boolean z2 = false;
                for (WifiConfiguration wifiConfiguration : configuredNetworks) {
                    if (d.sW(wifiConfiguration.SSID).compareTo(str) == 0 && d.c(wifiConfiguration) == i) {
                        z = z2 | c.removeNetwork(wifiConfiguration.networkId);
                    } else {
                        z = z2;
                    }
                    z2 = z;
                }
                z = z2;
            }
            if (z) {
                c.saveConfiguration();
            }
        }
        return z;
    }

    public static WifiConfiguration a(String str, int i, List<WifiConfiguration> list) {
        if (list != null) {
            for (WifiConfiguration wifiConfiguration : list) {
                if (d.sW(wifiConfiguration.SSID).compareTo(str) == 0 && d.c(wifiConfiguration) == i) {
                    return wifiConfiguration;
                }
            }
        }
        return null;
    }

    public static boolean kM(int i) {
        if (!c.removeNetwork(i) && !c.disableNetwork(i)) {
            return false;
        }
        c.saveConfiguration();
        return true;
    }
}
