package c.t.m.g;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.util.Base64;
import java.util.Collections;
import java.util.List;

public final class eh {
    public static boolean a = false;
    private static long b = 0;
    private static boolean c = false;

    public static boolean a(cr crVar) {
        try {
            WifiManager wifiManager = crVar.f;
            if (wifiManager == null || !wifiManager.isWifiEnabled()) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    public static int a(WifiManager wifiManager) {
        int i = 4;
        if (wifiManager != null) {
            try {
                i = wifiManager.getWifiState();
            } catch (Throwable th) {
            }
        }
        return i;
    }

    @SuppressLint({"NewApi"})
    public static boolean b(cr crVar) {
        boolean z = false;
        WifiManager wifiManager = crVar.f;
        if (wifiManager != null) {
            try {
                if (VERSION.SDK_INT < 23 || Secure.getInt(crVar.a.getContentResolver(), "location_mode") != 0) {
                    z = wifiManager.isWifiEnabled();
                    if (!z && VERSION.SDK_INT >= 18) {
                        z = wifiManager.isScanAlwaysAvailable();
                    }
                }
            } catch (Throwable th) {
                if (th instanceof SecurityException) {
                    a = true;
                }
            }
        }
        return z;
    }

    public static synchronized boolean b(WifiManager wifiManager) {
        boolean z;
        synchronized (eh.class) {
            z = false;
            if (wifiManager != null) {
                try {
                    if (System.currentTimeMillis() - b > 3000) {
                        z = wifiManager.startScan();
                        c = z;
                        b = System.currentTimeMillis();
                    } else {
                        z = c;
                    }
                } catch (Exception e) {
                    a = true;
                }
            }
        }
        return z;
    }

    public static List<ScanResult> c(WifiManager wifiManager) {
        List<ScanResult> list = null;
        if (wifiManager != null) {
            try {
                list = wifiManager.getScanResults();
                a = false;
            } catch (Exception e) {
                a = true;
            }
        }
        if (list == null) {
            return Collections.emptyList();
        }
        return list;
    }

    public static String c(cr crVar) {
        Context context = crVar.a;
        if (context == null) {
            return "{}";
        }
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (wifiManager == null || connectivityManager == null) {
                return "{}";
            }
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
            if (connectionInfo == null || networkInfo == null || !networkInfo.isConnected()) {
                return "{}";
            }
            String bssid = connectionInfo.getBSSID();
            if (bssid == null || bssid.equals("000000000000") || bssid.equals("00-00-00-00-00-00") || bssid.equals("00:00:00:00:00:00")) {
                return "{}";
            }
            int rssi = connectionInfo.getRssi();
            if (rssi < -100 || rssi > -20) {
                return "{}";
            }
            String replace = connectionInfo.getSSID().replace("\"", "").replace("|", "");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("{");
            stringBuilder.append("\"mac\":\"");
            stringBuilder.append(bssid);
            stringBuilder.append("\",\"rssi\":");
            stringBuilder.append(rssi);
            stringBuilder.append(",\"ssid\":\"");
            stringBuilder.append(replace);
            stringBuilder.append("\"}");
            return stringBuilder.toString();
        } catch (Exception e) {
            return "{}";
        }
    }

    public static String a(List<ScanResult> list) {
        if (list == null || list.size() == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        for (ScanResult scanResult : list) {
            if (!(scanResult.SSID == null || scanResult.SSID.length() == 0)) {
                try {
                    CharSequence stringBuilder2 = new StringBuilder();
                    stringBuilder2.append('|');
                    stringBuilder2.append(scanResult.BSSID).append(',');
                    stringBuilder2.append(Base64.encodeToString(scanResult.SSID.getBytes("UTF-8"), 2)).append(',');
                    stringBuilder2.append(scanResult.frequency).append(',');
                    stringBuilder2.append(Base64.encodeToString(scanResult.capabilities.getBytes("UTF-8"), 2));
                    stringBuilder.append(stringBuilder2);
                    i++;
                } catch (Throwable th) {
                }
            }
        }
        stringBuilder.insert(0, "1|" + i);
        return stringBuilder.toString();
    }
}
