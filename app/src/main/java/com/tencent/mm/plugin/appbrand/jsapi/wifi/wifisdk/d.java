package com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk;

import android.content.Context;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.WiFiConnector.2;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.a;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.b;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public final class d {
    private static boolean jvE = false;
    private static WeakReference<a> jvF = null;
    private static b jvG = null;
    private static a jvH;
    private static Context mContext;

    public static void bY(Context context) {
        if (!jvE && context != null) {
            mContext = context;
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (wifiManager != null) {
                c.bgP = wifiManager;
                jvE = true;
            }
        }
    }

    public static b ahI() {
        WifiInfo connectionInfo = c.getConnectionInfo();
        String str = "";
        if (!(connectionInfo == null || TextUtils.isEmpty(connectionInfo.getSSID()))) {
            str = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d.sW(connectionInfo.getSSID());
        }
        if (jvG != null && jvG.jvx.compareTo(r0) == 0) {
            return jvG;
        }
        if (connectionInfo == null) {
            return null;
        }
        ahJ();
        return jvG;
    }

    public static c ahJ() {
        c cVar = new c();
        jvG = null;
        if (jvE && c.isWifiEnabled()) {
            c.startScan();
            List<ScanResult> scanResults = c.getScanResults();
            cVar.jvD = new ArrayList();
            cVar.jey = "ok";
            if (scanResults != null) {
                String str;
                x.d("MicroMsg.WiFiManagerWrapper", "[getWifiList] ScanResult:%s, size:%d", new Object[]{scanResults, Integer.valueOf(scanResults.size())});
                WifiInfo connectionInfo = c.getConnectionInfo();
                x.d("MicroMsg.WiFiManagerWrapper", "[getWifiList] currentWiFiInfo:%s", new Object[]{connectionInfo});
                if (connectionInfo == null || TextUtils.isEmpty(connectionInfo.getSSID())) {
                    str = null;
                } else {
                    str = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d.sW(connectionInfo.getSSID());
                }
                for (ScanResult scanResult : scanResults) {
                    if (scanResult != null) {
                        int a = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d.a(scanResult);
                        if (a == 0 || a == 2) {
                            boolean z;
                            b bVar = new b();
                            bVar.jvx = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d.sW(scanResult.SSID);
                            bVar.jvy = scanResult.BSSID;
                            int i = scanResult.level;
                            i = i <= -100 ? 0 : i >= -55 ? 99 : (int) ((((float) (i + 100)) * 99.0f) / 45.0f);
                            bVar.jvz = i;
                            if (a == 2) {
                                z = true;
                            } else {
                                z = false;
                            }
                            bVar.jvA = z;
                            if (str == null || bVar.jvx.compareTo(str) != 0) {
                                i = 0;
                            } else {
                                i = 1;
                            }
                            if (i != 0) {
                                jvG = bVar;
                            }
                            cVar.jvD.add(bVar);
                        }
                    }
                }
            } else {
                x.e("MicroMsg.WiFiManagerWrapper", "wifiList is null");
            }
        } else if (jvE) {
            cVar.jey = "wifi is disable";
        } else {
            cVar.jey = "sdk not init";
        }
        return cVar;
    }

    public static void B(String str, String str2, String str3) {
        int i;
        WifiConfiguration wifiConfiguration;
        WifiConfiguration wifiConfiguration2 = null;
        if (jvF != null) {
            a aVar = (a) jvF.get();
            if (!(aVar == null || aVar.ahK())) {
                aVar.sV("duplicated request");
            }
        }
        a aVar2 = new a(jvH, mContext);
        new StringBuilder("ssid:").append(str).append(" bssid:").append(str2).append(" psw:").append(str3);
        aVar2.jvx = str;
        aVar2.jvy = str2;
        if (TextUtils.isEmpty(str3)) {
            i = 0;
        } else {
            i = 2;
        }
        if (str == null || str.length() <= 0) {
            wifiConfiguration = null;
        } else {
            wifiConfiguration = new WifiConfiguration();
            wifiConfiguration.allowedAuthAlgorithms.clear();
            wifiConfiguration.allowedGroupCiphers.clear();
            wifiConfiguration.allowedKeyManagement.clear();
            wifiConfiguration.allowedPairwiseCiphers.clear();
            wifiConfiguration.allowedProtocols.clear();
            wifiConfiguration.SSID = "\"" + str + "\"";
            wifiConfiguration.hiddenSSID = true;
            switch (i) {
                case 2:
                    if (str3.length() != 0) {
                        if (!str3.matches("[0-9A-Fa-f]{64}")) {
                            wifiConfiguration.preSharedKey = "\"" + str3 + '\"';
                            break;
                        } else {
                            wifiConfiguration.preSharedKey = str3;
                            break;
                        }
                    }
                    break;
                default:
                    wifiConfiguration.allowedKeyManagement.set(0);
                    break;
            }
            wifiConfiguration.status = 2;
        }
        List configuredNetworks = c.getConfiguredNetworks();
        if (configuredNetworks != null) {
            wifiConfiguration2 = b.a(str, i, configuredNetworks);
        }
        if (wifiConfiguration != null) {
            if (wifiConfiguration2 != null) {
                boolean z;
                if (b.aD(str, i)) {
                    c.saveConfiguration();
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    wifiConfiguration.networkId = b.b(wifiConfiguration);
                    if (wifiConfiguration.networkId == com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d.jvR) {
                        wifiConfiguration = wifiConfiguration2;
                    }
                }
            }
            if (wifiConfiguration.networkId == com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d.jvR) {
                wifiConfiguration.networkId = b.b(wifiConfiguration);
            }
            if (wifiConfiguration.networkId != com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d.jvR && aVar2.a(wifiConfiguration)) {
                aVar2.kL(1);
                aVar2.jvL = wifiConfiguration;
                if (!aVar2.jvt) {
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.net.wifi.supplicant.STATE_CHANGE");
                    intentFilter.addAction("android.net.wifi.STATE_CHANGE");
                    intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                    intentFilter.setPriority(Integer.MAX_VALUE);
                    aVar2.jvu = new 2(aVar2);
                    aVar2.jvI.registerReceiver(aVar2.jvu, intentFilter);
                    aVar2.jvt = true;
                }
                aVar2.mHandler.sendEmptyMessageDelayed(1, 13000);
                jvF = new WeakReference(aVar2);
            }
        }
        aVar2.e(false, "fail to connect wifi:invalid network id");
        jvF = new WeakReference(aVar2);
    }

    public static void a(a aVar) {
        jvH = aVar;
    }
}
