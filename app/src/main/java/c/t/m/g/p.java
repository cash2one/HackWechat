package c.t.m.g;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class p {
    private static volatile boolean a = true;
    private static String b = "";
    private static String c = "";
    private static String d = "";
    private static volatile int e = 0;
    private static volatile boolean f = false;
    private static volatile int g = -1;
    private static Map<String, d> h = new ConcurrentHashMap();
    private static BroadcastReceiver i = new t();
    private static String j = "";
    private static String k = "cmwap";
    private static String l = "3gwap";
    private static String m = "uniwap";
    private static String n = "ctwap";

    public static void a() {
        m.i().post(new u());
    }

    public static synchronized String b() {
        String str;
        synchronized (p.class) {
            switch (e) {
                case 1:
                    str = "ssid_" + c + d;
                    break;
                case 2:
                case 3:
                case 4:
                    str = "apn_" + b;
                    break;
                default:
                    str = "unknown";
                    break;
            }
        }
        return str;
    }

    public static String c() {
        String str = "";
        switch (e) {
            case 1:
                return "wifi";
            case 2:
                return "2g";
            case 3:
                return "3g";
            case 4:
                return "4g";
            default:
                return str;
        }
    }

    public static synchronized String d() {
        String str;
        synchronized (p.class) {
            switch (e) {
                case 1:
                    str = "wifi";
                    break;
                case 2:
                case 3:
                case 4:
                    str = b;
                    break;
                default:
                    str = "null";
                    break;
            }
        }
        return str;
    }

    public static synchronized void e() {
        synchronized (p.class) {
            int subtype;
            int i = e;
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) m.a().getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected()) {
                    a = true;
                    int type = activeNetworkInfo.getType();
                    if (type == 1) {
                        e = 1;
                        g = 0;
                        f = false;
                        WifiInfo connectionInfo = ((WifiManager) m.a().getSystemService("wifi")).getConnectionInfo();
                        c = connectionInfo.getSSID();
                        d = connectionInfo.getBSSID();
                    } else {
                        String extraInfo = activeNetworkInfo.getExtraInfo();
                        if (extraInfo != null) {
                            b = extraInfo.trim().toLowerCase();
                            if (type == 0) {
                                subtype = activeNetworkInfo.getSubtype();
                                g = subtype;
                                if (subtype == 1 || subtype == 2 || subtype == 4) {
                                    e = 2;
                                } else if (subtype == 13 || subtype == 19) {
                                    e = 4;
                                } else {
                                    e = 3;
                                }
                                boolean contains = b.contains("wap");
                                f = contains;
                                if (contains) {
                                    if (b.contains(l)) {
                                        j = "10.0.0.172";
                                    } else if (b.contains(k)) {
                                        j = "10.0.0.172";
                                    } else if (b.contains(m)) {
                                        j = "10.0.0.172";
                                    } else if (b.contains(n)) {
                                        j = "10.0.0.200";
                                    } else {
                                        j = "";
                                    }
                                }
                            } else {
                                b = "unknown";
                                e = 0;
                                g = -1;
                                f = false;
                            }
                        } else {
                            b = "unknown";
                            e = 0;
                            g = -1;
                            f = false;
                        }
                    }
                } else {
                    b = "unknown";
                    e = 0;
                    g = -1;
                    f = false;
                    a = false;
                }
                if (i != e) {
                    synchronized (h) {
                        for (d dVar : h.values()) {
                            if (dVar != null) {
                                subtype = e;
                                b();
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                if (i != e) {
                    synchronized (h) {
                        for (d dVar2 : h.values()) {
                            if (dVar2 != null) {
                                subtype = e;
                                b();
                            }
                        }
                    }
                }
            }
        }
        return;
    }

    public static String f() {
        String str = "unknown";
        if (g == -1) {
            return str;
        }
        switch (g) {
            case 0:
                return "wifi";
            case 1:
                return "GPRS";
            case 2:
                return "EDGE";
            case 3:
                return "UMTS";
            case 4:
                return "CDMA";
            case 5:
                return "EVDO_0";
            case 6:
                return "EVDO_A";
            case 7:
                return "1xRTT";
            case 8:
                return "HSDPA";
            case 9:
                return "HSUPA";
            case 10:
                return "HSPA";
            case 11:
                return "iDen";
            case 12:
                return "EVDO_B";
            case 13:
                return "LTE";
            case 14:
                return "EHRPD";
            case 15:
                return "HSPAP";
            default:
                return str;
        }
    }

    public static int g() {
        return e;
    }

    public static boolean h() {
        return a;
    }

    public static boolean i() {
        return f;
    }

    public static Integer j() {
        e();
        int i = (e == 2 || e == 3 || e == 4) ? 1 : 0;
        if (i != 0) {
            String simOperator;
            Integer valueOf;
            Context a = m.a();
            String str = b;
            TelephonyManager telephonyManager = (TelephonyManager) a.getSystemService("phone");
            if (telephonyManager != null && telephonyManager.getSimState() == 5) {
                simOperator = telephonyManager.getSimOperator();
                if (simOperator.length() > 0) {
                    if (simOperator.equals("46000") || simOperator.equals("46002")) {
                        valueOf = Integer.valueOf(1);
                        i = valueOf.intValue();
                    } else {
                        if (simOperator.equals("46001")) {
                            valueOf = Integer.valueOf(2);
                        } else if (simOperator.equals("46003")) {
                            valueOf = Integer.valueOf(3);
                        }
                        i = valueOf.intValue();
                    }
                }
            }
            if (str != null) {
                simOperator = str.toLowerCase();
                if (simOperator.contains("cmnet") || simOperator.contains("cmwap")) {
                    valueOf = Integer.valueOf(1);
                    i = valueOf.intValue();
                } else if (simOperator.contains("uninet") || simOperator.contains("uniwap") || simOperator.contains("3gnet") || simOperator.contains("3gwap")) {
                    valueOf = Integer.valueOf(2);
                    i = valueOf.intValue();
                } else if (simOperator.contains("ctnet") || simOperator.contains("ctwap")) {
                    valueOf = Integer.valueOf(3);
                    i = valueOf.intValue();
                }
            }
            valueOf = Integer.valueOf(0);
            i = valueOf.intValue();
        } else {
            i = 0;
        }
        return Integer.valueOf(i);
    }

    public static boolean l() {
        try {
            PowerManager powerManager = (PowerManager) m.a().getSystemService("power");
            if (VERSION.SDK_INT >= 23 && powerManager != null) {
                return ((Boolean) PowerManager.class.getDeclaredMethod("isDeviceIdleMode", new Class[0]).invoke(powerManager, new Object[0])).booleanValue();
            }
        } catch (Throwable th) {
        }
        return false;
    }

    public static Proxy k() {
        return (!f || TextUtils.isEmpty(j)) ? null : new Proxy(Type.HTTP, new InetSocketAddress(j, 80));
    }
}
