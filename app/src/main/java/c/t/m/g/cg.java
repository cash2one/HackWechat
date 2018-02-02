package c.t.m.g;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public final class cg {
    private static String a = "";
    private static String b = "";
    private static String c = "";
    private static String d = "";

    public static int a(int i, int i2) {
        return Math.min(Math.max(i, 0), i2);
    }

    public static int a(int i, int i2, int i3, int i4) {
        return ((i < i2 || i > i3) && i4 >= i2 && i4 <= i3) ? i4 : Math.min(Math.max(i, i2), i3);
    }

    public static String a() {
        Object obj = 1;
        try {
            String str = a;
            if (str != null) {
                if (str.trim().length() != 0) {
                    obj = null;
                }
            }
            if (obj != null) {
                TelephonyManager telephonyManager = (TelephonyManager) m.a().getSystemService("phone");
                if (telephonyManager != null) {
                    String deviceId = telephonyManager.getDeviceId();
                    if (deviceId == null) {
                        deviceId = "NOIMEI";
                    }
                    a = deviceId;
                }
            }
        } catch (Throwable th) {
        }
        return a;
    }

    public static String a(int i) {
        Throwable th;
        String str = null;
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/" + i + "/cmdline"));
            try {
                String readLine = bufferedReader.readLine();
                str = !TextUtils.isEmpty(readLine) ? readLine.trim() : readLine;
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                }
            } catch (Exception e2) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e3) {
                    }
                }
                return str;
            } catch (Throwable th2) {
                th = th2;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e4) {
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            bufferedReader = null;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            return str;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            bufferedReader = null;
            th = th4;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            throw th;
        }
        return str;
    }

    public static String a(long j, String str) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(j);
            return simpleDateFormat.format(instance.getTime());
        } catch (Exception e) {
            return "";
        }
    }

    public static String a(Context context, int i) {
        ActivityManager activityManager;
        List runningAppProcesses;
        int size;
        int i2;
        RunningAppProcessInfo runningAppProcessInfo;
        String str;
        Object systemService = context.getSystemService("activity");
        if (systemService != null) {
            try {
                activityManager = (ActivityManager) systemService;
            } catch (Throwable th) {
            }
            if (activityManager == null) {
                return null;
            }
            runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses != null && runningAppProcesses.size() > 0) {
                size = runningAppProcesses.size();
                for (i2 = 0; i2 < size; i2++) {
                    runningAppProcessInfo = (RunningAppProcessInfo) runningAppProcesses.get(i2);
                    if (runningAppProcessInfo == null && runningAppProcessInfo.pid == i) {
                        str = runningAppProcessInfo.processName;
                        break;
                    }
                }
            }
            str = null;
            return str;
        }
        activityManager = null;
        if (activityManager == null) {
            return null;
        }
        runningAppProcesses = activityManager.getRunningAppProcesses();
        size = runningAppProcesses.size();
        for (i2 = 0; i2 < size; i2++) {
            runningAppProcessInfo = (RunningAppProcessInfo) runningAppProcesses.get(i2);
            if (runningAppProcessInfo == null) {
            }
        }
        str = null;
        return str;
    }

    public static String a(Throwable th) {
        Object stackTraceString = Log.getStackTraceString(th);
        if (TextUtils.isEmpty(stackTraceString)) {
            return "";
        }
        String[] split = stackTraceString.split("\n");
        return split.length >= 2 ? split[0] + split[1] : split.length == 1 ? split[0] : "";
    }

    private static String a(InetAddress inetAddress) {
        try {
            byte[] address = inetAddress.getAddress();
            StringBuilder stringBuilder = new StringBuilder();
            int i = 0;
            while (i < address.length) {
                stringBuilder.append("." + (address[i] < (byte) 0 ? address[i] + 256 : address[i]));
                i++;
            }
            return stringBuilder.substring(1);
        } catch (Throwable th) {
            return "";
        }
    }

    public static boolean a(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static boolean a(byte[] bArr) {
        return bArr == null || bArr.length <= 0;
    }

    public static String b() {
        Object obj = 1;
        try {
            String str = b;
            if (str != null) {
                if (str.trim().length() != 0) {
                    obj = null;
                }
            }
            if (obj != null) {
                TelephonyManager telephonyManager = (TelephonyManager) m.a().getSystemService("phone");
                if (telephonyManager != null) {
                    String subscriberId = telephonyManager.getSubscriberId();
                    if (subscriberId == null) {
                        subscriberId = "NOIMSI";
                    }
                    b = subscriberId;
                }
            }
        } catch (Throwable th) {
        }
        return b;
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (Throwable th) {
            return "";
        }
    }

    public static String b(byte[] bArr) {
        if (bArr == null) {
            return "null";
        }
        int length = bArr.length;
        if (bArr == null) {
            return "null";
        }
        int min = Math.min(length, bArr.length);
        StringBuffer stringBuffer = new StringBuffer("size:" + min + ",content:");
        for (length = 0; length < min; length++) {
            stringBuffer.append(Integer.toHexString((bArr[length] >> 4) & 15));
            stringBuffer.append(Integer.toHexString(bArr[length] & 15));
        }
        return stringBuffer.toString();
    }

    public static String c() {
        Object obj = 1;
        try {
            String str = c;
            if (str != null) {
                if (str.trim().length() != 0) {
                    obj = null;
                }
            }
            if (obj != null) {
                WifiManager wifiManager = (WifiManager) m.a().getSystemService("wifi");
                if (wifiManager != null) {
                    WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                    if (connectionInfo != null) {
                        String macAddress = connectionInfo.getMacAddress();
                        if (macAddress == null) {
                            macAddress = "NOMAC";
                        }
                        c = macAddress;
                    }
                }
            }
        } catch (Throwable th) {
        }
        return c;
    }

    public static String c(String str) {
        String str2 = "";
        try {
            str2 = a(InetAddress.getByName(str));
        } catch (Throwable th) {
        }
        return str2;
    }

    public static String d() {
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append(a());
        stringBuilder.append(c());
        stringBuilder.append(System.currentTimeMillis());
        stringBuilder.append(b());
        stringBuilder.append((int) (Math.random() * 2.147483647E9d));
        return cf.a(stringBuilder.toString());
    }

    public static boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String[] split = str.split("\\.");
        if (split.length != 4) {
            return false;
        }
        int length = split.length;
        int i = 0;
        while (i < length) {
            try {
                int parseInt = Integer.parseInt(split[i]);
                if (parseInt < 0 || parseInt > 255) {
                    return false;
                }
                i++;
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }

    public static String e() {
        Object obj = 1;
        try {
            String str = d;
            if (str != null) {
                if (str.trim().length() != 0) {
                    obj = null;
                }
            }
            if (obj != null) {
                d = Secure.getString(m.a().getContentResolver(), "android_id");
            }
            return d;
        } catch (Throwable th) {
            return "";
        }
    }

    public static String f() {
        try {
            return "35" + (Build.BOARD.length() % 10) + (Build.BRAND.length() % 10) + (Build.CPU_ABI.length() % 10) + (Build.DEVICE.length() % 10) + (Build.DISPLAY.length() % 10) + (Build.HOST.length() % 10) + (Build.ID.length() % 10) + (Build.MANUFACTURER.length() % 10) + (Build.MODEL.length() % 10) + (Build.PRODUCT.length() % 10) + (Build.TAGS.length() % 10) + (Build.TYPE.length() % 10) + (Build.USER.length() % 10);
        } catch (Throwable th) {
            return "";
        }
    }
}
