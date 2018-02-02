package com.tencent.tinker.loader.shareutil;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Process;
import com.tencent.wcdb.FileUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ShareTinkerInternals {
    private static final boolean AlT = abO(System.getProperty("java.vm.version"));
    private static final boolean AlU = cHk();
    private static Boolean AlV = null;
    private static String AlW = null;
    private static String AlX = null;
    private static String processName = null;

    public static boolean cHg() {
        return AlT || VERSION.SDK_INT >= 21;
    }

    public static boolean cHh() {
        return AlU && VERSION.SDK_INT < 24;
    }

    public static boolean cHi() {
        return VERSION.SDK_INT > 25;
    }

    public static String cHj() {
        if (AlX != null) {
            return AlX;
        }
        AlX = (String) Class.forName("dalvik.system.VMRuntime").getDeclaredMethod("getCurrentInstructionSet", new Class[0]).invoke(null, new Object[0]);
        new StringBuilder("getCurrentInstructionSet:").append(AlX);
        return AlX;
    }

    public static boolean abN(String str) {
        String str2 = Build.FINGERPRINT;
        if (str == null || str.equals("") || str2 == null || str2.equals("")) {
            new StringBuilder("fingerprint empty:").append(str).append(",current:").append(str2);
            return false;
        } else if (str.equals(str2)) {
            return false;
        } else {
            new StringBuilder("system OTA,fingerprint not equal:").append(str).append(",").append(str2);
            return true;
        }
    }

    public static ShareDexDiffPatchInfo a(ShareDexDiffPatchInfo shareDexDiffPatchInfo, int i) {
        if (!shareDexDiffPatchInfo.Akx.startsWith("test.dex")) {
            return null;
        }
        String str;
        if (i != 1) {
            str = "classes" + i + ".dex";
        } else {
            str = "classes.dex";
        }
        return new ShareDexDiffPatchInfo(str, shareDexDiffPatchInfo.path, shareDexDiffPatchInfo.Aky, shareDexDiffPatchInfo.Akz, shareDexDiffPatchInfo.AkC, shareDexDiffPatchInfo.AkA, shareDexDiffPatchInfo.AkB, shareDexDiffPatchInfo.AkD);
    }

    public static boolean ov(String str) {
        if (str == null || str.length() <= 0) {
            return true;
        }
        return false;
    }

    public static int a(Context context, int i, File file, ShareSecurityCheck shareSecurityCheck) {
        int i2;
        if (shareSecurityCheck.ak(file)) {
            String iC = iC(context);
            if (iC == null) {
                i2 = -5;
            } else {
                HashMap cHf = shareSecurityCheck.cHf();
                if (cHf == null) {
                    i2 = -2;
                } else {
                    String str = (String) cHf.get("TINKER_ID");
                    if (str == null) {
                        i2 = -6;
                    } else if (iC.equals(str)) {
                        i2 = 0;
                    } else {
                        new StringBuilder("tinkerId is not equal, base is ").append(iC).append(", but patch is ").append(str);
                        i2 = -7;
                    }
                }
            }
        } else {
            i2 = -1;
        }
        if (i2 != 0) {
            return i2;
        }
        Object obj;
        if (i == 7) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            cHf = shareSecurityCheck.AlR;
            if (!IS(i) && cHf.containsKey("assets/dex_meta.txt")) {
                return -9;
            }
            if (!IT(i) && cHf.containsKey("assets/so_meta.txt")) {
                return -9;
            }
            if (!IU(i) && cHf.containsKey("assets/res_meta.txt")) {
                return -9;
            }
        }
        return 0;
    }

    public static Properties al(File file) {
        ZipFile zipFile;
        Object inputStream;
        Throwable th;
        IOException e;
        ZipFile zipFile2;
        Throwable th2;
        if (!file.isFile() || file.length() == 0) {
            return null;
        }
        try {
            zipFile = new ZipFile(file);
            try {
                ZipEntry entry = zipFile.getEntry("assets/package_meta.txt");
                if (entry == null) {
                    SharePatchFileUtil.a(zipFile);
                    return null;
                }
                try {
                    inputStream = zipFile.getInputStream(entry);
                    try {
                        Properties properties = new Properties();
                        properties.load(inputStream);
                        SharePatchFileUtil.cy(inputStream);
                        SharePatchFileUtil.a(zipFile);
                        return properties;
                    } catch (Throwable th3) {
                        th = th3;
                        SharePatchFileUtil.cy(inputStream);
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    inputStream = null;
                    SharePatchFileUtil.cy(inputStream);
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                zipFile2 = zipFile;
                try {
                    new StringBuilder("fastGetPatchPackageMeta exception:").append(e.getMessage());
                    SharePatchFileUtil.a(zipFile2);
                    return null;
                } catch (Throwable th5) {
                    th2 = th5;
                    zipFile = zipFile2;
                    SharePatchFileUtil.a(zipFile);
                    throw th2;
                }
            } catch (Throwable th6) {
                th2 = th6;
                SharePatchFileUtil.a(zipFile);
                throw th2;
            }
        } catch (IOException e3) {
            e = e3;
            zipFile2 = null;
            new StringBuilder("fastGetPatchPackageMeta exception:").append(e.getMessage());
            SharePatchFileUtil.a(zipFile2);
            return null;
        } catch (Throwable th7) {
            zipFile = null;
            th2 = th7;
            SharePatchFileUtil.a(zipFile);
            throw th2;
        }
    }

    private static String iC(Context context) {
        if (AlW != null) {
            return AlW;
        }
        try {
            Object obj = context.getPackageManager().getApplicationInfo(context.getPackageName(), FileUtils.S_IWUSR).metaData.get("TINKER_ID");
            if (obj != null) {
                AlW = String.valueOf(obj);
            } else {
                AlW = null;
            }
            return AlW;
        } catch (Exception e) {
            new StringBuilder("getManifestTinkerID exception:").append(e.getMessage());
            return null;
        }
    }

    public static boolean IS(int i) {
        return (i & 1) != 0;
    }

    public static boolean IT(int i) {
        return (i & 2) != 0;
    }

    public static boolean IU(int i) {
        return (i & 4) != 0;
    }

    public static String IV(int i) {
        switch (i) {
            case 1:
                return "patch_file";
            case 2:
                return "patch_info";
            case 3:
                return "dex";
            case 4:
                return "dex_opt";
            case 5:
                return "lib";
            case 6:
                return "resource";
            default:
                return "unknown";
        }
    }

    public static void iD(Context context) {
        context.getSharedPreferences("tinker_share_config", 4).edit().putBoolean("tinker_enable_1.9.4", false).commit();
    }

    public static boolean iE(Context context) {
        if (context == null) {
            return false;
        }
        return context.getSharedPreferences("tinker_share_config", 4).getBoolean("tinker_enable_1.9.4", true);
    }

    public static boolean IW(int i) {
        return i != 0;
    }

    public static boolean iF(Context context) {
        String str = null;
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (applicationInfo != null) {
            str = applicationInfo.processName;
        }
        if (ov(str)) {
            str = context.getPackageName();
        }
        Object iI = iI(context);
        if (iI == null || iI.length() == 0) {
            iI = "";
        }
        return str.equals(iI);
    }

    public static boolean iG(Context context) {
        if (AlV != null) {
            return AlV.booleanValue();
        }
        Boolean valueOf = Boolean.valueOf(iI(context).endsWith(":patch"));
        AlV = valueOf;
        return valueOf.booleanValue();
    }

    public static String bW(Context context, String str) {
        if (!str.equals("changing")) {
            return str;
        }
        if (iF(context)) {
            return "odex";
        }
        return "interpet";
    }

    public static void iH(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager != null) {
            List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses != null) {
                for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.uid == Process.myUid() && runningAppProcessInfo.pid != Process.myPid()) {
                        Process.killProcess(runningAppProcessInfo.pid);
                    }
                }
            }
        }
    }

    public static String iI(Context context) {
        if (processName != null) {
            return processName;
        }
        String iJ = iJ(context);
        processName = iJ;
        return iJ;
    }

    private static String iJ(Context context) {
        FileInputStream fileInputStream;
        Throwable th;
        int myPid = Process.myPid();
        if (context == null || myPid <= 0) {
            return "";
        }
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager != null) {
            List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses != null) {
                RunningAppProcessInfo runningAppProcessInfo;
                try {
                    for (RunningAppProcessInfo runningAppProcessInfo2 : runningAppProcesses) {
                        if (runningAppProcessInfo2.pid == myPid) {
                            break;
                        }
                    }
                    runningAppProcessInfo2 = null;
                } catch (Exception e) {
                    Exception e2;
                    new StringBuilder("getProcessNameInternal exception:").append(e2.getMessage());
                    runningAppProcessInfo2 = null;
                }
                if (runningAppProcessInfo2 != null) {
                    return runningAppProcessInfo2.processName;
                }
            }
        }
        byte[] bArr = new byte[FileUtils.S_IWUSR];
        try {
            fileInputStream = new FileInputStream("/proc/" + myPid + "/cmdline");
            try {
                int read = fileInputStream.read(bArr);
                if (read > 0) {
                    int i = 0;
                    while (i < read) {
                        if ((bArr[i] & 255) > FileUtils.S_IWUSR || bArr[i] <= (byte) 0) {
                            read = i;
                            break;
                        }
                        i++;
                    }
                    String str = new String(bArr, 0, read);
                    try {
                        fileInputStream.close();
                        return str;
                    } catch (Exception e3) {
                        return str;
                    }
                }
                try {
                    fileInputStream.close();
                } catch (Exception e4) {
                }
                return "";
            } catch (Exception e5) {
                e2 = e5;
                try {
                    new StringBuilder("getProcessNameInternal exception:").append(e2.getMessage());
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e6) {
                        }
                    }
                    return "";
                } catch (Throwable th2) {
                    th = th2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e7) {
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e8) {
            e2 = e8;
            fileInputStream = null;
            new StringBuilder("getProcessNameInternal exception:").append(e2.getMessage());
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            return "";
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
    }

    private static boolean abO(String str) {
        if (str == null) {
            return false;
        }
        Matcher matcher = Pattern.compile("(\\d+)\\.(\\d+)(\\.\\d+)?").matcher(str);
        if (!matcher.matches()) {
            return false;
        }
        try {
            int parseInt = Integer.parseInt(matcher.group(1));
            int parseInt2 = Integer.parseInt(matcher.group(2));
            if (parseInt > 2 || (parseInt == 2 && parseInt2 > 0)) {
                return true;
            }
            return false;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean cHk() {
        try {
            Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", new Class[]{String.class});
            String str = (String) declaredMethod.invoke(null, new Object[]{"dalvik.vm.usejit"});
            String str2 = (String) declaredMethod.invoke(null, new Object[]{"dalvik.vm.usejitprofiles"});
            if (!ov(str) && ov(str2) && str.equals("true")) {
                return true;
            }
        } catch (Throwable th) {
            new StringBuilder("isVmJitInternal ex:").append(th);
        }
        return false;
    }

    public static String j(Throwable th) {
        if (th == null) {
            return "";
        }
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        while (true) {
            try {
                Throwable cause = th.getCause();
                if (cause == null) {
                    break;
                }
                th = cause;
            } finally {
                SharePatchFileUtil.cy(printStream);
            }
        }
        th.printStackTrace(printStream);
        String Vg = Vg(byteArrayOutputStream.toString());
        return Vg;
    }

    private static String Vg(String str) {
        if (str == null) {
            return null;
        }
        char[] toCharArray = str.toCharArray();
        if (toCharArray == null) {
            return null;
        }
        char c;
        int i = 0;
        while (i < toCharArray.length) {
            if (toCharArray[i] > '') {
                toCharArray[i] = '\u0000';
                c = '\u0001';
                break;
            }
            i++;
        }
        c = '\u0000';
        if (c != '\u0000') {
            return new String(toCharArray, 0, i);
        }
        return str;
    }
}
