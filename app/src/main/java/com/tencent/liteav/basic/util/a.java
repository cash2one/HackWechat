package com.tencent.liteav.basic.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Process;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.rtmp.TXLiveConstants;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.util.UUID;

public class a {
    private static float a = 0.0f;
    private static float b = 0.0f;
    private static float c = 0.0f;
    private static float d = 0.0f;
    private static float e = 0.0f;
    private static float f = 0.0f;
    private static boolean g = true;
    private static int[] h = new int[2];
    private static long i = 0;
    private static String j = "";
    private static final Object k = new Object();
    private static boolean l = false;

    private static long f() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/stat")), 1000);
            String readLine = bufferedReader.readLine();
            bufferedReader.close();
            String[] split = readLine.split(" ");
            if (split == null || TextUtils.isEmpty(split[13])) {
                return 0;
            }
            return Long.parseLong(split[16]) + ((Long.parseLong(split[13]) + Long.parseLong(split[14])) + Long.parseLong(split[15]));
        } catch (Exception e) {
            return 0;
        }
    }

    private static void g() {
        long parseLong;
        long j = 0;
        try {
            if (VERSION.SDK_INT < 26) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/stat")), 1000);
                String readLine = bufferedReader.readLine();
                bufferedReader.close();
                String[] split = readLine.split(" ");
                parseLong = (((((Long.parseLong(split[2]) + Long.parseLong(split[3])) + Long.parseLong(split[4])) + Long.parseLong(split[6])) + Long.parseLong(split[5])) + Long.parseLong(split[7])) + Long.parseLong(split[8]);
                try {
                    j = Long.parseLong(split[6]) + Long.parseLong(split[5]);
                } catch (Exception e) {
                }
            } else {
                parseLong = j;
            }
        } catch (Exception e2) {
            parseLong = j;
        }
        if (g) {
            a = (float) parseLong;
            e = (float) j;
            return;
        }
        b = (float) parseLong;
        f = (float) j;
    }

    public static int[] a() {
        float f = 0.0f;
        if (i != 0 && TXCTimeUtil.getTimeTick() - i < 2000) {
            return h;
        }
        int[] iArr = new int[2];
        if (g) {
            c = (float) f();
            g();
            g = false;
            iArr[0] = 0;
            iArr[1] = 0;
            return iArr;
        }
        float f2;
        d = (float) f();
        g();
        if (b != a) {
            f2 = ((d - c) * 100.0f) / (b - a);
            f = (((b - a) - (f - e)) * 100.0f) / (b - a);
        } else {
            f2 = 0.0f;
        }
        a = b;
        c = d;
        e = f;
        iArr[0] = (int) (f2 * 10.0f);
        iArr[1] = (int) (f * 10.0f);
        h[0] = iArr[0];
        h[1] = iArr[1];
        i = TXCTimeUtil.getTimeTick();
        return iArr;
    }

    public static String a(Context context) {
        return TXCDRApi.getSimulateIDFA(context);
    }

    public static String b(Context context) {
        String str = "";
        if (context == null) {
            return str;
        }
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
        } catch (Exception e) {
            return str;
        }
    }

    public static int c(Context context) {
        if (context == null) {
            return 255;
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return 255;
        }
        if (activeNetworkInfo.getType() == 9) {
            return 5;
        }
        if (activeNetworkInfo.getType() == 1) {
            return 1;
        }
        if (activeNetworkInfo.getType() != 0) {
            return 255;
        }
        switch (telephonyManager.getNetworkType()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return 4;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return 3;
            case 13:
                return 2;
            default:
                return 2;
        }
    }

    public static String b() {
        return Build.MODEL;
    }

    public static String c() {
        return UUID.randomUUID().toString();
    }

    public static String d(Context context) {
        return TXCDRApi.getDevUUID(context, TXCDRApi.getSimulateIDFA(context));
    }

    public static void a(WeakReference<com.tencent.liteav.basic.c.a> weakReference, long j, int i, String str) {
        Bundle bundle = new Bundle();
        bundle.putLong("EVT_USERID", j);
        bundle.putInt("EVT_ID", i);
        bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
        if (str != null) {
            bundle.putCharSequence(TXLiveConstants.EVT_DESCRIPTION, str);
        }
        a((WeakReference) weakReference, i, bundle);
    }

    public static void a(WeakReference<com.tencent.liteav.basic.c.a> weakReference, int i, String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("EVT_ID", i);
        bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
        if (str != null) {
            bundle.putCharSequence(TXLiveConstants.EVT_DESCRIPTION, str);
        }
        a((WeakReference) weakReference, i, bundle);
    }

    public static void a(WeakReference<com.tencent.liteav.basic.c.a> weakReference, int i, Bundle bundle) {
        if (weakReference != null) {
            com.tencent.liteav.basic.c.a aVar = (com.tencent.liteav.basic.c.a) weakReference.get();
            if (aVar != null) {
                aVar.onNotifyEvent(i, bundle);
            }
        }
    }

    public static void a(WeakReference<com.tencent.liteav.basic.c.a> weakReference, long j, int i, Bundle bundle) {
        if (weakReference != null) {
            com.tencent.liteav.basic.c.a aVar = (com.tencent.liteav.basic.c.a) weakReference.get();
            if (aVar != null) {
                bundle.putLong("EVT_USERID", j);
                aVar.onNotifyEvent(i, bundle);
            }
        }
    }

    public static com.tencent.liteav.basic.d.a a(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8 = 0;
        if (i * i4 >= i2 * i3) {
            i5 = i2;
            i6 = (i2 * i3) / i4;
        } else {
            i5 = (i * i4) / i3;
            i6 = i;
        }
        if (i > i6) {
            i7 = (i - i6) >> 1;
        } else {
            i7 = 0;
        }
        if (i2 > i5) {
            i8 = (i2 - i5) >> 1;
        }
        return new com.tencent.liteav.basic.d.a(i7, i8, i6, i5);
    }

    public static void d() {
        synchronized (k) {
            if (!l) {
                a("stlport_shared");
                a("saturn");
                a("txffmpeg");
                a("liteavsdk");
                l = true;
            }
        }
    }

    public static void a(String str) {
        try {
            System.loadLibrary(str);
        } catch (Error e) {
            new StringBuilder("load library : ").append(e.toString());
            a(j, str);
        } catch (Exception e2) {
            new StringBuilder("load library : ").append(e2.toString());
            a(j, str);
        }
    }

    private static void a(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str)) {
                System.load(str + "/lib" + str2 + ".so");
            }
        } catch (Error e) {
            new StringBuilder("load library : ").append(e.toString());
        } catch (Exception e2) {
            new StringBuilder("load library : ").append(e2.toString());
        }
    }

    public static void b(String str) {
        j = str;
    }

    public static String e() {
        return j;
    }
}
