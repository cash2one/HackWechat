package com.tencent.mm.plugin.freewifi.model;

import android.content.Intent;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;
import java.util.Map;

public final class d {
    private static Map<Integer, String> mEd = new 1();

    public static int AI(String str) {
        if (bh.ov(str)) {
            x.d("MicroMsg.FreeWifi.FreeWifiManager", "Illegal SSID");
            return 0;
        }
        c AR = j.aLO().AR(str);
        if (AR == null || !str.equalsIgnoreCase(AR.field_ssid)) {
            return 0;
        }
        if (AR.field_connectState == 2 && AR.field_expiredTime > 0 && AR.field_expiredTime - bh.Wo() <= 0) {
            AR.field_connectState = 1;
            boolean c = j.aLO().c(AR, new String[0]);
            x.i("MicroMsg.FreeWifi.FreeWifiManager", "Expired, re-auth, expired time : %d, current time : %d, ret : %b", new Object[]{Long.valueOf(AR.field_expiredTime), Long.valueOf(bh.Wo()), Boolean.valueOf(c)});
        }
        return AR.field_connectState;
    }

    public static void release() {
    }

    public static boolean AJ(String str) {
        x.i("MicroMsg.FreeWifi.FreeWifiManager", "check is wechat free wifi, ssid : %s", new Object[]{str});
        if (bh.ov(str)) {
            x.e("MicroMsg.FreeWifi.FreeWifiManager", "ssid is null or nil");
            return false;
        }
        String aLD = aLD();
        if (bh.ov(aLD) || !aLD.equals(str)) {
            return false;
        }
        return true;
    }

    public static int AK(String str) {
        WifiManager wifiManager = (WifiManager) ac.getContext().getSystemService("wifi");
        if (wifiManager == null) {
            x.e("MicroMsg.FreeWifi.FreeWifiManager", "addWifiNetWork, get wifi manager failed");
            return -11;
        }
        int AM = AM(str);
        if (AM > 0) {
            x.i("MicroMsg.FreeWifi.FreeWifiManager", "addWifiNetWork, the network has exsited, just enable it");
        } else {
            WifiConfiguration wifiConfiguration = new WifiConfiguration();
            wifiConfiguration.allowedAuthAlgorithms.clear();
            wifiConfiguration.allowedGroupCiphers.clear();
            wifiConfiguration.allowedKeyManagement.clear();
            wifiConfiguration.allowedPairwiseCiphers.clear();
            wifiConfiguration.allowedProtocols.clear();
            wifiConfiguration.SSID = "\"" + str + "\"";
            x.i("MicroMsg.FreeWifi.FreeWifiManager", "check is the same ssid is exist, %b", new Object[]{Boolean.valueOf(AL(str))});
            wifiConfiguration.allowedKeyManagement.set(0);
            wifiConfiguration.wepTxKeyIndex = 0;
            AM = wifiManager.addNetwork(wifiConfiguration);
        }
        x.i("MicroMsg.FreeWifi.FreeWifiManager", "addWifiNetWork netid : %d, result : %b", new Object[]{Integer.valueOf(AM), Boolean.valueOf(wifiManager.enableNetwork(AM, true))});
        if (wifiManager.enableNetwork(AM, true)) {
            return 0;
        }
        return -14;
    }

    public static int d(String str, String str2, int i, boolean z) {
        x.i("MicroMsg.FreeWifi.FreeWifiManager", "addWifiNetWork by encrypt, ssid is : %s, password : %s, cryptType :%d, hideSSID = %b", new Object[]{str, str2, Integer.valueOf(i), Boolean.valueOf(z)});
        if (bh.ov(str)) {
            x.e("MicroMsg.FreeWifi.FreeWifiManager", "addWifiNetWork by encrypt alg failed, ssid is null");
            return -12;
        } else if (i == 0) {
            return AK(str);
        } else {
            if (bh.ov(str2)) {
                x.e("MicroMsg.FreeWifi.FreeWifiManager", "encrypt type is not none, while password is null");
                return -15;
            }
            WifiManager wifiManager = (WifiManager) ac.getContext().getSystemService("wifi");
            if (wifiManager == null) {
                x.e("MicroMsg.FreeWifi.FreeWifiManager", "addWifiNetWork by encrypt alg, get wifi manager failed");
                return -11;
            }
            int addNetwork;
            WifiConfiguration wifiConfiguration;
            if (f.fM(21)) {
                if (!bh.ov(str)) {
                    List<WifiConfiguration> configuredNetworks = ((WifiManager) ac.getContext().getSystemService("wifi")).getConfiguredNetworks();
                    if (configuredNetworks != null) {
                        x.i("MicroMsg.FreeWifi.FreeWifiManager", "get wificonfiguration list size : %d", new Object[]{Integer.valueOf(configuredNetworks.size())});
                        for (WifiConfiguration wifiConfiguration2 : configuredNetworks) {
                            if (wifiConfiguration2.SSID.equals("\"" + str + "\"")) {
                                break;
                            }
                        }
                    }
                    x.e("MicroMsg.FreeWifi.FreeWifiManager", "get wifi list is null");
                } else {
                    x.e("MicroMsg.FreeWifi.FreeWifiManager", "null or nill ssid");
                }
                wifiConfiguration2 = null;
                if (wifiConfiguration2 == null) {
                    wifiConfiguration2 = s(str, str2, i);
                    wifiConfiguration2.hiddenSSID = z;
                    addNetwork = wifiManager.addNetwork(wifiConfiguration2);
                } else {
                    if (wifiConfiguration2 != null) {
                        wifiConfiguration2.SSID = "\"" + str + "\"";
                        wifiConfiguration2.status = 2;
                        switch (i) {
                            case 1:
                                wifiConfiguration2.wepKeys = new String[]{"\"" + str2 + "\""};
                                wifiConfiguration2.allowedKeyManagement.set(0);
                                break;
                            case 2:
                            case 3:
                                wifiConfiguration2.preSharedKey = "\"" + str2 + "\"";
                                wifiConfiguration2.allowedKeyManagement.set(1);
                                break;
                            default:
                                x.e("MicroMsg.FreeWifi.FreeWifiManager", "unsupport encrypt type : %d", new Object[]{Integer.valueOf(i)});
                                break;
                        }
                    }
                    wifiConfiguration2.hiddenSSID = z;
                    addNetwork = wifiConfiguration2.networkId;
                }
                wifiManager.saveConfiguration();
            } else {
                addNetwork = AM(str);
                if (addNetwork > 0) {
                    boolean removeNetwork = wifiManager.removeNetwork(addNetwork);
                    x.i("MicroMsg.FreeWifi.FreeWifiManager", "this network has exist : %s, try to remove it : %b", new Object[]{str, Boolean.valueOf(removeNetwork)});
                }
                wifiConfiguration2 = s(str, str2, i);
                wifiConfiguration2.hiddenSSID = z;
                addNetwork = wifiManager.addNetwork(wifiConfiguration2);
                wifiManager.saveConfiguration();
            }
            x.i("MicroMsg.FreeWifi.FreeWifiManager", "addWifiNetWork by encrypt alg, netid : %d, result : %b", new Object[]{Integer.valueOf(addNetwork), Boolean.valueOf(wifiManager.enableNetwork(addNetwork, true))});
            if (wifiManager.enableNetwork(addNetwork, true)) {
                return 0;
            }
            return -14;
        }
    }

    private static WifiConfiguration s(String str, String str2, int i) {
        WifiConfiguration wifiConfiguration = new WifiConfiguration();
        wifiConfiguration.SSID = "\"" + str + "\"";
        wifiConfiguration.status = 2;
        switch (i) {
            case 1:
                wifiConfiguration.wepKeys = new String[]{"\"" + str2 + "\""};
                wifiConfiguration.allowedKeyManagement.set(0);
                break;
            case 2:
            case 3:
                wifiConfiguration.preSharedKey = "\"" + str2 + "\"";
                wifiConfiguration.allowedKeyManagement.set(1);
                break;
            default:
                x.e("MicroMsg.FreeWifi.FreeWifiManager", "unsupport encrypt type : %d", new Object[]{Integer.valueOf(i)});
                break;
        }
        return wifiConfiguration;
    }

    public static boolean isWifiEnabled() {
        WifiManager wifiManager = (WifiManager) ac.getContext().getSystemService("wifi");
        if (wifiManager == null) {
            x.e("MicroMsg.FreeWifi.FreeWifiManager", "get wifi manager failed");
            return false;
        }
        x.i("MicroMsg.FreeWifi.FreeWifiManager", "is wifi enalbe now : %b", new Object[]{Boolean.valueOf(wifiManager.isWifiEnabled())});
        return wifiManager.isWifiEnabled();
    }

    public static boolean aLA() {
        WifiManager wifiManager = (WifiManager) ac.getContext().getSystemService("wifi");
        if (wifiManager != null) {
            return wifiManager.setWifiEnabled(true);
        }
        x.e("MicroMsg.FreeWifi.FreeWifiManager", "get wifi manager failed");
        return false;
    }

    public static boolean AL(String str) {
        int AM = AM(str);
        x.i("MicroMsg.FreeWifi.FreeWifiManager", "get network id by ssid :%s, netid is %d", new Object[]{str, Integer.valueOf(AM)});
        if (AM == -1) {
            x.i("MicroMsg.FreeWifi.FreeWifiManager", "ssid is not exist : %s", new Object[]{str});
            return false;
        }
        WifiManager wifiManager = (WifiManager) ac.getContext().getSystemService("wifi");
        boolean removeNetwork = wifiManager.removeNetwork(AM);
        wifiManager.saveConfiguration();
        x.i("MicroMsg.FreeWifi.FreeWifiManager", "remove ssid : %s, ret = %b", new Object[]{str, Boolean.valueOf(removeNetwork)});
        return removeNetwork;
    }

    private static int AM(String str) {
        if (bh.ov(str)) {
            x.e("MicroMsg.FreeWifi.FreeWifiManager", "null or nill ssid");
            return -1;
        }
        List<WifiConfiguration> configuredNetworks = ((WifiManager) ac.getContext().getSystemService("wifi")).getConfiguredNetworks();
        if (configuredNetworks == null) {
            x.e("MicroMsg.FreeWifi.FreeWifiManager", "get wifi list is null");
            return -1;
        }
        x.i("MicroMsg.FreeWifi.FreeWifiManager", "get wificonfiguration list size : %d", new Object[]{Integer.valueOf(configuredNetworks.size())});
        for (WifiConfiguration wifiConfiguration : configuredNetworks) {
            if (wifiConfiguration.SSID.equals("\"" + str + "\"")) {
                return wifiConfiguration.networkId;
            }
        }
        return -1;
    }

    public static String pW(int i) {
        String str = (String) mEd.get(Integer.valueOf(i));
        if (str == null) {
            return "";
        }
        return str;
    }

    public static void a(String str, int i, Intent intent) {
        x.i("MicroMsg.FreeWifi.FreeWifiManager", "sessionKey=%s, step=%d, method=FreeWifiManager.updateConnectState, desc=it changes the connect state of the model to %s. state=%d", new Object[]{m.D(intent), Integer.valueOf(m.E(intent)), pW(i), Integer.valueOf(i)});
        c AR = j.aLO().AR(str);
        if (AR != null) {
            AR.field_connectState = i;
            boolean c = j.aLO().c(AR, new String[0]);
            x.i("MicroMsg.FreeWifi.FreeWifiManager", "update %s, connect state : %d, return : %b", new Object[]{str, Integer.valueOf(i), Boolean.valueOf(c)});
        }
    }

    public static String aLB() {
        if (an.getNetType(ac.getContext()) == 0) {
            WifiInfo aLE = aLE();
            if (!(aLE == null || aLE.getBSSID() == null)) {
                x.i("MicroMsg.FreeWifi.FreeWifiManager", "getConnectWifiMacAddress, get bssid now : %s", new Object[]{aLE.getBSSID()});
                return aLE.getBSSID();
            }
        }
        return null;
    }

    public static int aLC() {
        if (an.getNetType(ac.getContext()) == 0) {
            WifiInfo aLE = aLE();
            if (aLE != null) {
                x.i("MicroMsg.FreeWifi.FreeWifiManager", "getConnectWifiSignal, get rssi now : %d", new Object[]{Integer.valueOf(aLE.getRssi())});
                return aLE.getRssi();
            }
        }
        return 0;
    }

    public static String aLD() {
        x.i("MicroMsg.FreeWifi.FreeWifiManager", "networkType = %d", new Object[]{Integer.valueOf(an.getNetType(ac.getContext()))});
        if (an.getNetType(ac.getContext()) == 0) {
            WifiInfo aLE = aLE();
            if (!(aLE == null || aLE.getSSID() == null)) {
                x.i("MicroMsg.FreeWifi.FreeWifiManager", "get ssid now : %s", new Object[]{aLE.getSSID().replace("\"", "")});
                return aLE.getSSID().replace("\"", "");
            }
        }
        return null;
    }

    public static WifiInfo aLE() {
        WifiManager wifiManager = (WifiManager) ac.getContext().getSystemService("wifi");
        if (wifiManager == null) {
            x.e("MicroMsg.FreeWifi.FreeWifiManager", "get wifi manager failed");
            return null;
        }
        try {
            return wifiManager.getConnectionInfo();
        } catch (Exception e) {
            x.e("MicroMsg.FreeWifi.FreeWifiManager", "getConnectionInfo failed : %s", new Object[]{e.getMessage()});
            return null;
        }
    }

    public static String aLF() {
        WifiManager wifiManager = (WifiManager) ac.getContext().getSystemService("wifi");
        if (wifiManager == null) {
            x.e("MicroMsg.FreeWifi.FreeWifiManager", "get wifi manager failed");
            return "";
        }
        try {
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            if (connectionInfo == null) {
                return "";
            }
            String bssid = connectionInfo.getBSSID();
            if (bssid == null) {
                return "";
            }
            return bssid;
        } catch (Exception e) {
            x.e("MicroMsg.FreeWifi.FreeWifiManager", "getConnectWifiBssid failed : %s", new Object[]{e.getMessage()});
            return "";
        }
    }

    public static String aLG() {
        WifiManager wifiManager = (WifiManager) ac.getContext().getSystemService("wifi");
        if (wifiManager == null) {
            x.e("MicroMsg.FreeWifi.FreeWifiManager", "get wifi manager failed");
            return "";
        }
        try {
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            if (connectionInfo == null) {
                return "";
            }
            String ssid = connectionInfo.getSSID();
            if (ssid == null) {
                return "";
            }
            return m.AB(ssid);
        } catch (Exception e) {
            x.e("MicroMsg.FreeWifi.FreeWifiManager", "getConnectWifiBssid failed : %s", new Object[]{e.getMessage()});
            return "";
        }
    }

    public static int getNetworkType() {
        return an.getNetType(ac.getContext());
    }
}
