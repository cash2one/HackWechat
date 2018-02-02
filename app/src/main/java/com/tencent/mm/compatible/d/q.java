package com.tencent.mm.compatible.d;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import com.tencent.mm.a.g;
import com.tencent.mm.g.a.cd;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Pattern;

public final class q {
    public static o gFT = new o();
    public static c gFU = new c();
    public static b gFV = new b();
    public static v gFW = new v();
    public static z gFX = new z();
    public static s gFY = new s();
    public static u gFZ = new u();
    public static x gGa = new x();
    public static t gGb = new t();
    public static a gGc = new a();
    private static int gGd = -1;
    public static k gGe = new k();
    public static p gGf = new p();
    private static String gGg = null;

    class a implements FileFilter {
        a() {
        }

        public final boolean accept(File file) {
            if (Pattern.matches("cpu[0-9]+", file.getName())) {
                return true;
            }
            return false;
        }
    }

    public static String yE() {
        String str = (String) l.yn().get(258);
        if (str == null) {
            str = getDeviceID(ac.getContext());
            if (str == null) {
                str = "1234567890ABCDEF";
            }
            l.yn().set(258, str);
        }
        return str;
    }

    public static String getDeviceID(Context context) {
        if (context == null) {
            return null;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                return null;
            }
            String deviceId = telephonyManager.getDeviceId();
            return deviceId == null ? null : deviceId.trim();
        } catch (SecurityException e) {
            x.e("MicroMsg.DeviceInfo", "getDeviceId failed, security exception");
            return null;
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.DeviceInfo", e2, "", new Object[0]);
            return null;
        }
    }

    public static String yF() {
        return bf(false);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static String bf(boolean z) {
        if (z || gGg == null) {
            String str;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(Secure.getString(ac.getContext().getContentResolver(), "android_id"));
            if (!z) {
                str = (String) l.yn().get(256);
            }
            str = yI();
            l.yn().set(256, str);
            stringBuilder.append(str);
            str = (String) l.yn().get(259);
            if (str != null) {
                x.d("MicroMsg.DeviceInfo", "getHardWareId from file " + str);
            } else {
                str = Build.MANUFACTURER + Build.MODEL + n.yu();
                l.yn().set(259, str);
                x.d("MicroMsg.DeviceInfo", "getHardWareId " + str);
            }
            stringBuilder.append(str);
            gGg = "A" + g.s(stringBuilder.toString().getBytes()).substring(0, 15);
            x.w("MicroMsg.DeviceInfo", "guid:%s, dev=%s", gGg, str);
        }
        return gGg;
    }

    public static String yG() {
        WifiManager wifiManager = (WifiManager) ac.getContext().getSystemService("wifi");
        WifiInfo connectionInfo = wifiManager == null ? null : wifiManager.getConnectionInfo();
        return connectionInfo != null ? connectionInfo.getMacAddress() : null;
    }

    public static String yH() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter != null) {
            return defaultAdapter.getAddress();
        }
        return null;
    }

    private static String yI() {
        String str;
        String eX = bh.eX(ac.getContext());
        if (eX == null || eX.length() <= 0) {
            Random random = new Random();
            random.setSeed(System.currentTimeMillis());
            str = "A";
            int i = 0;
            while (i < 15) {
                i++;
                str = str + ((char) (random.nextInt(25) + 65));
            }
        } else {
            str = ("A" + eX + "123456789ABCDEF").substring(0, 15);
        }
        x.w("MicroMsg.DeviceInfo", "generated deviceId=" + str);
        return str;
    }

    public static void eI(String str) {
        x.i("MicroMsg.DeviceInfo", "update deviceInfo %s", str);
        if (str != null && str.length() > 0 && str.hashCode() != gGd) {
            gGd = str.hashCode();
            gFT.reset();
            gFU.reset();
            gFV.reset();
            gGe.reset();
            gFW.reset();
            gFX.reset();
            s sVar = gFY;
            sVar.gGh = 0;
            sVar.gGi = 0;
            u uVar = gFZ;
            uVar.gGv = "";
            uVar.gGw = null;
            gGa.fIP = false;
            gGb.reset();
            a aVar = gGc;
            aVar.gCE = false;
            aVar.gCF = "";
            r rVar = new r();
            if (r.a(str, gFT, gFU, gFV, gGe, gFW, gFX, gFY, gFZ, gGa, gGb, gGc)) {
                x.d("MicroMsg.DeviceInfo", "steve: mCameraInfo.mNeedEnhance = " + gFU.gEs);
                com.tencent.mm.sdk.b.a.xef.m(new cd());
            }
        }
    }

    public static String yJ() {
        return Build.MODEL;
    }

    public static String aI(Context context) {
        try {
            x.i("MicroMsg.DeviceInfo", "lm: getManufacturer CurrentLanguage is %s", w.eL(context));
            if (gFZ == null || gFZ.gGw == null || gFZ.gGw.size() == 0) {
                x.i("MicroMsg.DeviceInfo", "lm: getManufacturer return is %s", Build.MANUFACTURER);
                return Build.MANUFACTURER;
            }
            String str = (String) gFZ.gGw.get(".manufacturerName." + w.eL(context));
            x.i("MicroMsg.DeviceInfo", "lm: getManufacturer is %s", str);
            if (!bh.ov(str)) {
                return str;
            }
            str = (String) gFZ.gGw.get(".manufacturerName.en");
            x.i("MicroMsg.DeviceInfo", "lm: getManufacturer is %s", str);
            if (bh.ov(str)) {
                return Build.MANUFACTURER;
            }
            return str;
        } catch (Exception e) {
            return Build.MANUFACTURER;
        }
    }

    public static String aJ(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getSimOperatorName();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.DeviceInfo", e, "getMobileSPType", new Object[0]);
            return "";
        }
    }

    public static String getSimCountryIso() {
        TelephonyManager telephonyManager = (TelephonyManager) ac.getContext().getSystemService("phone");
        if (telephonyManager == null) {
            return null;
        }
        x.i("MicroMsg.DeviceInfo", "get isoCode:[%s]", telephonyManager.getSimCountryIso());
        return telephonyManager.getSimCountryIso();
    }

    public static String[] yK() {
        BufferedReader bufferedReader;
        Throwable th;
        String[] strArr = new String[]{"", "0"};
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/cpuinfo"), 8192);
            try {
                String[] split = bh.ou(bufferedReader.readLine()).split("\\s+");
                for (int i = 2; i < split.length; i++) {
                    strArr[0] = strArr[0] + split[i] + " ";
                }
                strArr[1] = bh.ou(bufferedReader.readLine()).split("\\s+")[2];
                try {
                    bufferedReader.close();
                } catch (Exception e) {
                }
            } catch (IOException e2) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception e3) {
                    }
                }
                return strArr;
            } catch (Throwable th2) {
                Throwable th3 = th2;
                bufferedReader2 = bufferedReader;
                th = th3;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (Exception e4) {
                    }
                }
                throw th;
            }
        } catch (IOException e5) {
            bufferedReader = null;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            return strArr;
        } catch (Throwable th4) {
            th = th4;
            if (bufferedReader2 != null) {
                bufferedReader2.close();
            }
            throw th;
        }
        return strArr;
    }

    public static String getAndroidId() {
        x.i("MicroMsg.DeviceInfo", "androidid:[%s]", Secure.getString(ac.getContext().getContentResolver(), "android_id"));
        return Secure.getString(ac.getContext().getContentResolver(), "android_id");
    }

    public static String yL() {
        String str = null;
        try {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter != null && defaultAdapter.isEnabled()) {
                str = defaultAdapter.getAddress();
            }
            return bh.ou(str);
        } catch (Throwable e) {
            x.e("MicroMsg.DeviceInfo", "getBlueToothAddress failed: %s", bh.i(e));
            return "";
        }
    }

    @SuppressLint({"NewApi"})
    public static String yM() {
        String str = null;
        try {
            if (VERSION.SDK_INT >= 14) {
                str = Build.getRadioVersion();
            } else {
                str = Build.RADIO;
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Crash", e, "May cause dvmFindCatchBlock crash!", new Object[0]);
            throw ((IncompatibleClassChangeError) new IncompatibleClassChangeError("May cause dvmFindCatchBlock crash!").initCause(e));
        } catch (Throwable th) {
        }
        return bh.ou(str);
    }

    public static String yN() {
        return VERSION.RELEASE;
    }

    public static String yO() {
        try {
            return bh.ou(((TelephonyManager) ac.getContext().getSystemService("phone")).getSubscriberId());
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.DeviceInfo", e, "getPhoneIMSI", new Object[0]);
            return "";
        }
    }

    public static String yP() {
        try {
            return bh.ou(((TelephonyManager) ac.getContext().getSystemService("phone")).getSimSerialNumber());
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.DeviceInfo", e, "getPhoneICCID", new Object[0]);
            return "";
        }
    }

    @SuppressLint({"NewApi"})
    public static String yQ() {
        String str = null;
        if (VERSION.SDK_INT >= 9) {
            str = Build.SERIAL;
        }
        return bh.ou(str);
    }

    public static Map<String, String> yR() {
        Closeable bufferedReader;
        Throwable e;
        Map<String, String> hashMap = new HashMap();
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/cpuinfo"), "UTF-8"));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    } else if (!readLine.trim().equals("")) {
                        String[] split = readLine.split(":");
                        if (split.length > 1) {
                            hashMap.put(split[0].trim().toLowerCase(), split[1].trim());
                        }
                    }
                } catch (IOException e2) {
                    e = e2;
                }
            }
            bh.d(bufferedReader);
        } catch (IOException e3) {
            e = e3;
            bufferedReader = null;
            try {
                x.printErrStackTrace("MicroMsg.DeviceInfo", e, "getInfoMapOfCpu() failed.", new Object[0]);
                bh.d(bufferedReader);
                return hashMap;
            } catch (Throwable th) {
                e = th;
                bh.d(bufferedReader);
                throw e;
            }
        } catch (Throwable th2) {
            e = th2;
            bufferedReader = null;
            bh.d(bufferedReader);
            throw e;
        }
        return hashMap;
    }

    public static int yS() {
        try {
            return new File("/sys/devices/system/cpu").listFiles(new a()).length;
        } catch (Exception e) {
            return 1;
        }
    }

    public static String yT() {
        return "android-" + Build.MODEL + "-" + VERSION.SDK_INT;
    }
}
