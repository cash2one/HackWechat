package com.tencent.mm.plugin.freewifi;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import com.tencent.mm.R;
import com.tencent.mm.ar.b;
import com.tencent.mm.ar.b.a;
import com.tencent.mm.modelfriend.m$a;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.protocal.c.rb;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.bindmobile.BindMContactUI;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.net.ConnectException;
import java.net.NetworkInterface;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

public final class m {
    private static SimpleDateFormat kmq = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");

    public static boolean AA(String str) {
        return str == null || str.length() == 0;
    }

    public static String AB(String str) {
        if (AA(str)) {
            return "";
        }
        if (str.startsWith("\"") && str.endsWith("\"")) {
            return str.substring(1, str.length() - 1);
        }
        return str;
    }

    public static boolean aLh() {
        String by = bh.by(ac.getContext());
        return by != null && by.toLowerCase().startsWith(ac.getPackageName());
    }

    public static void C(Intent intent) {
        if (AA(intent.getStringExtra("free_wifi_sessionkey"))) {
            d(intent, aLi());
        }
    }

    public static String aLi() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static void d(Intent intent, String str) {
        intent.putExtra("free_wifi_sessionkey", str);
        intent.putExtra("ConstantsFreeWifi.FREE_WIFI_LOG_STEP_ID", 0);
    }

    public static String D(Intent intent) {
        return AC(intent.getStringExtra("free_wifi_sessionkey"));
    }

    public static int E(Intent intent) {
        int intExtra = intent.getIntExtra("ConstantsFreeWifi.FREE_WIFI_LOG_STEP_ID", 0) + 1;
        intent.putExtra("ConstantsFreeWifi.FREE_WIFI_LOG_STEP_ID", intExtra);
        return intExtra;
    }

    public static int F(Intent intent) {
        return intent.getIntExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 0);
    }

    public static int G(Intent intent) {
        return intent.getIntExtra("free_wifi_channel_id", 0);
    }

    public static String H(Intent intent) {
        return intent.getStringExtra("free_wifi_ap_key");
    }

    public static String AC(String str) {
        return str == null ? "" : str;
    }

    public static String AD(String str) {
        if (aLl()) {
            WifiManager wifiManager = (WifiManager) ac.getContext().getSystemService("wifi");
            if (wifiManager == null) {
                return "";
            }
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            if (connectionInfo == null) {
                return "";
            }
            String ssid = connectionInfo.getSSID();
            if (AA(ssid)) {
                x.i(str, "getConnectedWifiSsid() is empty");
                return "";
            }
            x.i(str, "getConnectedWifiSsid()=" + AB(ssid));
            return AB(ssid);
        }
        x.i(str, "wifi not connected. getConnectedWifiSsid() is empty");
        return "";
    }

    public static String AE(String str) {
        if (aLl()) {
            WifiManager wifiManager = (WifiManager) ac.getContext().getSystemService("wifi");
            if (wifiManager == null) {
                return "";
            }
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            if (connectionInfo == null) {
                return "";
            }
            String toLowerCase = AC(connectionInfo.getBSSID()).toLowerCase();
            x.i(str, "getConnectedWifiBssid()=" + toLowerCase);
            return toLowerCase;
        }
        x.i(str, "wifi not connected. getConnectedWifiBssid() is empty");
        return "";
    }

    public static String AF(String str) {
        WifiManager wifiManager = (WifiManager) ac.getContext().getSystemService("wifi");
        if (wifiManager == null) {
            x.e(str, "error wifiManager is null!!");
            return "";
        }
        WifiInfo connectionInfo = wifiManager.getConnectionInfo();
        if (connectionInfo == null) {
            x.e(str, "error wifiInfo is null!!");
            return "";
        }
        String macAddress = connectionInfo.getMacAddress();
        if (VERSION.SDK_INT > 22 && (macAddress == null || macAddress.equals("02:00:00:00:00:00"))) {
            macAddress = aLj();
        }
        macAddress = AC(macAddress).toLowerCase();
        x.i(str, "getConnectedWifiClientMac()=" + macAddress);
        return macAddress;
    }

    public static String aLj() {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            String str = "wlan0";
            if (NetworkInterface.getNetworkInterfaces() != null) {
                for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                    if (networkInterface.getName().equalsIgnoreCase(str)) {
                        byte[] hardwareAddress = networkInterface.getHardwareAddress();
                        if (hardwareAddress == null) {
                            x.d("MicroMsg.FreeWifi.Utils", "et mobile mac from net time cost :" + (System.currentTimeMillis() - currentTimeMillis));
                            return "02:00:00:00:00:00";
                        }
                        StringBuilder stringBuilder = new StringBuilder();
                        int length = hardwareAddress.length;
                        for (int i = 0; i < length; i++) {
                            stringBuilder.append(String.format("%02X:", new Object[]{Byte.valueOf(hardwareAddress[i])}));
                        }
                        if (stringBuilder.length() > 0) {
                            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                        }
                        x.d("MicroMsg.FreeWifi.Utils", "et mobile mac from net time cost :" + (System.currentTimeMillis() - currentTimeMillis));
                        return stringBuilder.toString();
                    }
                }
            }
        } catch (Exception e) {
            x.e("MicroMsg.FreeWifi.Utils", "get mobile mac from net fail!" + e);
        }
        x.d("MicroMsg.FreeWifi.Utils", "et mobile mac from net time cost :" + (System.currentTimeMillis() - currentTimeMillis));
        return "02:00:00:00:00:00";
    }

    public static String e(Exception exception) {
        Writer stringWriter = new StringWriter();
        exception.printStackTrace(new PrintWriter(stringWriter));
        String AC = AC(stringWriter.toString());
        if (AC.length() > WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
            return AC.substring(0, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        }
        return AC;
    }

    public static String f(Exception exception) {
        Writer stringWriter = new StringWriter();
        exception.printStackTrace(new PrintWriter(stringWriter));
        return AC(stringWriter.toString());
    }

    public static String a(int i, k$b com_tencent_mm_plugin_freewifi_k_b, int i2) {
        Object format;
        x.i("MicroMsg.FreeWifi.Utils", "getUiErrorCode, protocol=%d, stageName=%s, stageCode=%d, errocode=%d", Integer.valueOf(i), com_tencent_mm_plugin_freewifi_k_b.name, Long.valueOf(com_tencent_mm_plugin_freewifi_k_b.mDi), Integer.valueOf(i2));
        int abs = Math.abs(i2);
        StringBuilder append = new StringBuilder().append(String.format("%02d", new Object[]{Integer.valueOf(i)})).append(String.format("%03d", new Object[]{Long.valueOf(com_tencent_mm_plugin_freewifi_k_b.mDi)}));
        if (abs <= 999) {
            format = String.format("%03d", new Object[]{Integer.valueOf(abs)});
        } else {
            format = Integer.valueOf(abs);
        }
        return append.append(format).toString();
    }

    public static void a(Intent intent, String str, int i, int i2, FreeWifiFrontPageUI freeWifiFrontPageUI, String str2) {
        a(intent, str, i, i2, new 1(str2, freeWifiFrontPageUI, i), str2);
    }

    public static void a(Intent intent, String str, int i, int i2, a aVar, String str2) {
        j.aLR().aLz().post(new 2(str2, str, intent, i, i2, aVar));
    }

    public static int aLk() {
        m$a NN = com.tencent.mm.modelfriend.m.NN();
        if (NN == m$a.NO_INIT || NN == m$a.SET_MOBILE) {
            return 1;
        }
        ar.Hg();
        String str = (String) c.CU().get(6, null);
        if (AA(str)) {
            return 1;
        }
        Object De;
        if (str.startsWith("+")) {
            De = ao.De(str);
        } else {
            De = "86";
        }
        if ("86".equals(De)) {
            return 2;
        }
        return 3;
    }

    public static void cG(Context context) {
        Intent intent = new Intent(context, BindMContactUI.class);
        intent.putExtra("is_bind_for_safe_device", false);
        intent.putExtra("is_bind_for_change_mobile", false);
        String simCountryIso = ((TelephonyManager) context.getSystemService("phone")).getSimCountryIso();
        if (!bh.ov(simCountryIso)) {
            a h = b.h(context, simCountryIso, context.getString(R.l.bZb));
            if (h != null) {
                intent.putExtra("country_name", h.hEx);
                intent.putExtra("couttry_code", h.hEw);
            }
        }
        MMWizardActivity.A(context, intent);
    }

    public static boolean cz(int i, int i2) {
        if (i == 0 && i2 == 0) {
            return true;
        }
        return false;
    }

    public static boolean cA(int i, int i2) {
        if (i != 4 || i2 > -30000 || i2 <= -31000) {
            return false;
        }
        return true;
    }

    public static int g(Exception exception) {
        if (exception instanceof SocketTimeoutException) {
            String f = f(exception);
            if (f.indexOf(".read") != -1) {
                return 105;
            }
            if (f.indexOf(".connect") != -1) {
                return 104;
            }
            return 101;
        } else if (exception instanceof ConnectException) {
            return 106;
        } else {
            if (exception instanceof UnknownHostException) {
                return 102;
            }
            return 101;
        }
    }

    public static boolean k(Map<String, String> map, String str) {
        x.i(str, "CLIENT_VERSION=" + d.vAz);
        String str2 = (String) map.get(".sysmsg.apply_versions.version_desc.$minInclude");
        String str3 = (String) map.get(".sysmsg.apply_versions.version_desc.$maxInclude");
        x.i(str, "checkMsgPushedVersion. min0=%s,max0=%s", str2, str3);
        if (AA(str2) && AA(str3)) {
            return false;
        }
        if (cy(str2, str3)) {
            return true;
        }
        int i = 1;
        while (true) {
            str2 = (String) map.get(".sysmsg.apply_versions.version_desc#" + i + ".$minInclude");
            str3 = (String) map.get(".sysmsg.apply_versions.version_desc#" + i + ".$maxInclude");
            x.i(str, "checkMsgPushedVersion. min" + i + "=%s,max" + i + "=%s", str2, str3);
            if (AA(str2) && AA(str3)) {
                return false;
            }
            if (cy(str2, str3)) {
                return true;
            }
            i++;
        }
    }

    private static boolean cy(String str, String str2) {
        int i = bh.getInt(str, 0);
        int i2 = bh.getInt(str2, 0);
        if (i == 0 && i2 != 0 && d.vAz <= i2) {
            return true;
        }
        if (i != 0 && i2 == 0 && d.vAz >= i) {
            return true;
        }
        if (i == 0 || i2 == 0 || d.vAz < i || d.vAz > i2) {
            return false;
        }
        return true;
    }

    public static boolean aLl() {
        if (((ConnectivityManager) ac.getContext().getSystemService("connectivity")).getNetworkInfo(1).isConnected()) {
            x.i("TAG", "isWifiConnected()=true");
            return true;
        }
        x.i("TAG", "isWifiConnected()=false");
        return false;
    }

    public static rb aLm() {
        rb rbVar = new rb();
        rbVar.deviceBrand = d.vAs;
        if (d.mCb == null || d.mCb.equals("")) {
            rbVar.vZe = AF("MicroMsg.FreeWifi.Utils");
        } else {
            rbVar.vZe = d.mCb;
        }
        rbVar.deviceModel = d.vAt;
        rbVar.osName = d.vAv;
        rbVar.osVersion = d.vAw;
        return rbVar;
    }

    public static String a(String str, LinkedHashMap<String, Class> linkedHashMap, i iVar, String str2) {
        String str3;
        if (linkedHashMap.size() == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str).append("\r\n");
        StringBuilder stringBuilder2 = new StringBuilder();
        for (Entry key : linkedHashMap.entrySet()) {
            stringBuilder2.append((String) key.getKey()).append(",");
        }
        if (stringBuilder2.length() > 0) {
            stringBuilder2.delete(stringBuilder2.length() - 1, stringBuilder2.length());
        }
        String str4 = "select " + stringBuilder2.toString() + " from " + str;
        for (Entry key2 : linkedHashMap.entrySet()) {
            stringBuilder.append((String) key2.getKey()).append("\t");
        }
        stringBuilder.append("\r\n");
        Cursor rawQuery = iVar.rawQuery(str4, new String[0]);
        while (rawQuery.moveToNext()) {
            int i = 0;
            for (Entry key22 : linkedHashMap.entrySet()) {
                Class cls = (Class) key22.getValue();
                if (cls == String.class) {
                    stringBuilder.append(rawQuery.getString(i));
                } else if (cls == Integer.TYPE) {
                    stringBuilder.append(rawQuery.getInt(i));
                } else {
                    try {
                        if (cls == Long.TYPE) {
                            stringBuilder.append(rawQuery.getLong(i));
                        } else if (cls == Float.TYPE) {
                            stringBuilder.append(rawQuery.getFloat(i));
                        } else if (cls == Double.TYPE) {
                            stringBuilder.append(rawQuery.getDouble(i));
                        } else {
                            x.e(str2, "unkonwn type " + cls.toString());
                            stringBuilder.append(rawQuery.getString(i));
                        }
                    } catch (Exception e) {
                        x.i(str2, "print " + str + "error." + e.getMessage());
                        str3 = "";
                        return str3;
                    } finally {
                        rawQuery.close();
                    }
                }
                stringBuilder.append("\t");
                i++;
            }
            stringBuilder.append("\r\n");
        }
        x.i(str2, stringBuilder.toString());
        str3 = stringBuilder.toString();
        return str3;
    }

    public static void AG(String str) {
        x.i("FreeWifi", str);
    }
}
