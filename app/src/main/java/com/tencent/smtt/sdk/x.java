package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.c;
import com.tencent.smtt.utils.f;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public final class x {
    private static Context bks;
    private static boolean zYH;
    private static String zYI = null;
    public static boolean zYJ = false;
    private static String zYK = null;
    private static int zYL = 0;
    private static String zYM = null;
    private static boolean zYN = false;
    private static boolean zYO = false;
    private static String zYP = null;
    private static boolean zYQ = false;
    private static boolean zYR = false;

    private static void a(Context context, TbsLinuxToolsJni tbsLinuxToolsJni, File file) {
        if (file != null && file.exists() && file.isDirectory()) {
            tbsLinuxToolsJni.fX(file.getAbsolutePath(), "755");
            for (File file2 : file.listFiles()) {
                if (file2.isFile()) {
                    if (file2.getAbsolutePath().indexOf(".so") > 0) {
                        tbsLinuxToolsJni.fX(file2.getAbsolutePath(), "755");
                    } else {
                        tbsLinuxToolsJni.fX(file2.getAbsolutePath(), "644");
                    }
                } else if (file2.isDirectory()) {
                    a(context, tbsLinuxToolsJni, file2);
                } else {
                    TbsLog.e("TbsShareManager", "unknown file type.", true);
                }
            }
        }
    }

    private static void b(Context context, String str, String str2, String str3, String str4) {
        BufferedOutputStream bufferedOutputStream;
        BufferedInputStream bufferedInputStream;
        Throwable th;
        int i = 0;
        BufferedOutputStream bufferedOutputStream2 = null;
        BufferedInputStream bufferedInputStream2 = null;
        BufferedOutputStream bufferedOutputStream3 = null;
        try {
            File bM = bM(context, "core_info");
            if (bM == null) {
                o.gG(bks).HU(-405);
                if (null != null) {
                    try {
                        bufferedInputStream2.close();
                    } catch (Exception e) {
                    }
                }
                if (null != null) {
                    try {
                        bufferedOutputStream3.close();
                        return;
                    } catch (Exception e2) {
                        return;
                    }
                }
                return;
            }
            Properties properties;
            bufferedInputStream2 = new BufferedInputStream(new FileInputStream(bM));
            try {
                properties = new Properties();
                properties.load(bufferedInputStream2);
                try {
                    i = Integer.parseInt(str);
                } catch (Exception e3) {
                }
                if (i != 0) {
                    properties.setProperty("core_version", str);
                    properties.setProperty("core_disabled", "false");
                    properties.setProperty("core_packagename", str2);
                    properties.setProperty("core_path", str3);
                    properties.setProperty("app_version", str4);
                } else {
                    properties.setProperty("core_disabled", "true");
                }
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(bM));
            } catch (Throwable th2) {
                Throwable th3 = th2;
                bufferedOutputStream = null;
                th = th3;
                if (bufferedInputStream2 != null) {
                    try {
                        bufferedInputStream2.close();
                    } catch (Exception e4) {
                    }
                }
                if (bufferedOutputStream != null) {
                    try {
                        bufferedOutputStream.close();
                    } catch (Exception e5) {
                    }
                }
                throw th;
            }
            try {
                properties.store(bufferedOutputStream, null);
                zYR = false;
                o.gG(bks).HU(-406);
                if (bufferedInputStream2 != null) {
                    try {
                        bufferedInputStream2.close();
                    } catch (Exception e6) {
                    }
                }
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
            } catch (Throwable th4) {
                th = th4;
                if (bufferedInputStream2 != null) {
                    bufferedInputStream2.close();
                }
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
                throw th;
            }
        } catch (Throwable th22) {
            bufferedInputStream2 = null;
            th = th22;
            bufferedOutputStream = null;
            if (bufferedInputStream2 != null) {
                bufferedInputStream2.close();
            }
            if (bufferedOutputStream != null) {
                bufferedOutputStream.close();
            }
            throw th;
        }
    }

    private static File bM(Context context, String str) {
        t.cEF();
        File hh = t.hh(context);
        if (hh == null) {
            return null;
        }
        File file = new File(hh, str);
        if (file.exists()) {
            return file;
        }
        try {
            file.createNewFile();
            return file;
        } catch (IOException e) {
            return null;
        }
    }

    private static Context bN(Context context, String str) {
        Context context2 = null;
        try {
            context2 = context.createPackageContext(str, 2);
        } catch (NameNotFoundException e) {
        } catch (Exception e2) {
        }
        return context2;
    }

    public static synchronized void c(Context context, int i, boolean z) {
        Throwable th;
        BufferedOutputStream bufferedOutputStream = null;
        synchronized (x.class) {
            if (i == 0) {
                hr(context);
                o.gG(bks).HU(-401);
            } else {
                int ht = ht(context);
                if (ht < 0) {
                    o.gG(bks).HU(-402);
                } else if (i == ht) {
                    BufferedInputStream bufferedInputStream = null;
                    BufferedOutputStream bufferedOutputStream2 = null;
                    BufferedInputStream bufferedInputStream2;
                    BufferedOutputStream bufferedOutputStream3;
                    try {
                        File bM = bM(context, "core_info");
                        if (bM == null) {
                            if (null != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (Exception e) {
                                }
                            }
                            if (null != null) {
                                try {
                                    bufferedOutputStream2.close();
                                } catch (Exception e2) {
                                }
                            }
                            o.gG(bks).HU(-403);
                        } else {
                            Properties properties;
                            bufferedInputStream2 = new BufferedInputStream(new FileInputStream(bM));
                            try {
                                properties = new Properties();
                                properties.load(bufferedInputStream2);
                                properties.setProperty("core_disabled", "false");
                                if (z) {
                                    t.cEF();
                                    r1 = t.hg(context).getAbsolutePath();
                                    r6 = context.getApplicationContext().getPackageName();
                                    r7 = c.getAppVersionCode(context);
                                    properties.setProperty("core_packagename", r6);
                                    properties.setProperty("core_path", r1);
                                    properties.setProperty("app_version", String.valueOf(r7));
                                }
                                bufferedOutputStream3 = new BufferedOutputStream(new FileOutputStream(bM));
                            } catch (Throwable th2) {
                                Throwable th3 = th2;
                                bufferedOutputStream3 = null;
                                th = th3;
                                if (bufferedInputStream2 != null) {
                                    try {
                                        bufferedInputStream2.close();
                                    } catch (Exception e3) {
                                    }
                                }
                                if (bufferedOutputStream3 != null) {
                                    try {
                                        bufferedOutputStream3.close();
                                    } catch (Exception e4) {
                                    }
                                }
                                throw th;
                            }
                            try {
                                properties.store(bufferedOutputStream3, null);
                                if (bufferedInputStream2 != null) {
                                    try {
                                        bufferedInputStream2.close();
                                    } catch (Exception e5) {
                                    }
                                }
                                if (bufferedOutputStream3 != null) {
                                    bufferedOutputStream3.close();
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                if (bufferedInputStream2 != null) {
                                    bufferedInputStream2.close();
                                }
                                if (bufferedOutputStream3 != null) {
                                    bufferedOutputStream3.close();
                                }
                                throw th;
                            }
                            o.gG(bks).HU(-403);
                        }
                    } catch (Throwable th22) {
                        bufferedInputStream2 = null;
                        th = th22;
                        bufferedOutputStream3 = null;
                        if (bufferedInputStream2 != null) {
                            bufferedInputStream2.close();
                        }
                        if (bufferedOutputStream3 != null) {
                            bufferedOutputStream3.close();
                        }
                        throw th;
                    }
                } else if (i >= ht || i >= 43300) {
                    File bM2;
                    TbsLinuxToolsJni tbsLinuxToolsJni;
                    Context bN;
                    String[] cER = cER();
                    String[] strArr;
                    if (z) {
                        strArr = new String[]{context.getApplicationContext().getPackageName()};
                    } else {
                        strArr = cER;
                    }
                    if (zYI != null) {
                        t.cEF();
                        if (i == t.abi(zYI)) {
                            b(context, Integer.toString(i), "AppDefined", zYI, Integer.toString(1));
                            try {
                                bM2 = bM(context, "core_info");
                                if (!(zYO || bM2 == null)) {
                                    tbsLinuxToolsJni = new TbsLinuxToolsJni(bks);
                                    tbsLinuxToolsJni.fX(bM2.getAbsolutePath(), "644");
                                    t.cEF();
                                    tbsLinuxToolsJni.fX(t.hh(context).getAbsolutePath(), "755");
                                    zYO = true;
                                }
                            } catch (Throwable th5) {
                            }
                        } else {
                            t.cEF();
                            if (i > t.abi(zYI)) {
                                for (String str : r2) {
                                    if (i == 0) {
                                        bN = bN(context, str);
                                        t.cEF();
                                        r6 = t.hg(bN).getAbsolutePath();
                                        c.getAppVersionCode(context);
                                        t.cEF();
                                        if (t.gS(bN)) {
                                            try {
                                                f.a(new File(r6), new File(zYI), new 1());
                                                b(context, Integer.toString(i), "AppDefined", zYI, Integer.toString(1));
                                                bM2 = bM(context, "core_info");
                                                if (!(zYO || bM2 == null)) {
                                                    tbsLinuxToolsJni = new TbsLinuxToolsJni(bks);
                                                    tbsLinuxToolsJni.fX(bM2.getAbsolutePath(), "644");
                                                    t.cEF();
                                                    tbsLinuxToolsJni.fX(t.hh(context).getAbsolutePath(), "755");
                                                    zYO = true;
                                                }
                                            } catch (Throwable th6) {
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    for (String str2 : r2) {
                        if (i == 0) {
                            bN = bN(context, str2);
                            t.cEF();
                            r6 = t.hg(bN).getAbsolutePath();
                            r7 = c.getAppVersionCode(context);
                            t.cEF();
                            if (t.gS(bN)) {
                                if (!str2.equals(context.getApplicationContext().getPackageName())) {
                                    TbsLog.i("TbsShareManager", "thirdAPP pre--> delete old core_share Directory:" + i);
                                    t.cEF();
                                    try {
                                        f.T(t.hg(context));
                                        TbsLog.i("TbsShareManager", "thirdAPP success--> delete old core_share Directory");
                                    } catch (Throwable th7) {
                                    }
                                }
                                b(context, Integer.toString(i), str2, r6, Integer.toString(r7));
                                try {
                                    bM2 = bM(context, "core_info");
                                    if (!(zYO || bM2 == null)) {
                                        tbsLinuxToolsJni = new TbsLinuxToolsJni(bks);
                                        tbsLinuxToolsJni.fX(bM2.getAbsolutePath(), "644");
                                        t.cEF();
                                        tbsLinuxToolsJni.fX(t.hh(context).getAbsolutePath(), "755");
                                        zYO = true;
                                    }
                                } catch (Throwable th8) {
                                }
                            }
                        } else if (i == 0) {
                            bN = bN(context, str2);
                            t.cEF();
                            r6 = t.hf(bN).getAbsolutePath();
                            r7 = c.getAppVersionCode(context);
                            t.cEF();
                            if (t.gS(bN)) {
                                if (!str2.equals(context.getApplicationContext().getPackageName())) {
                                    TbsLog.i("TbsShareManager", "thirdAPP pre--> delete old core_share Directory:" + i);
                                    t.cEF();
                                    try {
                                        f.T(t.hg(context));
                                        TbsLog.i("TbsShareManager", "thirdAPP success--> delete old core_share Directory");
                                    } catch (Throwable th9) {
                                    }
                                }
                                b(context, Integer.toString(i), str2, r6, Integer.toString(r7));
                                try {
                                    bM2 = bM(context, "core_info");
                                    if (!(zYO || bM2 == null)) {
                                        tbsLinuxToolsJni = new TbsLinuxToolsJni(bks);
                                        tbsLinuxToolsJni.fX(bM2.getAbsolutePath(), "644");
                                        t.cEF();
                                        tbsLinuxToolsJni.fX(t.hh(context).getAbsolutePath(), "755");
                                        zYO = true;
                                    }
                                } catch (Throwable th10) {
                                }
                            }
                        } else {
                            continue;
                        }
                    }
                } else {
                    hr(context);
                    o.gG(bks).HU(-404);
                }
            }
        }
    }

    public static String cEQ() {
        return zYI;
    }

    public static String[] cER() {
        return new String[]{"com.tencent.tbs", "com.tencent.mm", "com.tencent.mobileqq", "com.qzone"};
    }

    public static long cES() {
        String[] cER = cER();
        for (int i = 0; i < 4; i++) {
            String str = cER[i];
            if (!(str.equalsIgnoreCase("com.tencent.mm") || str.equalsIgnoreCase("com.tencent.mobileqq"))) {
                str.equalsIgnoreCase("com.qzone");
            }
        }
        return 0;
    }

    public static boolean cET() {
        return zYN;
    }

    static String cEU() {
        return zYK;
    }

    static int cEV() {
        return zYL;
    }

    static int cEW() {
        return zYL;
    }

    public static int cEX() {
        return zYL;
    }

    public static boolean cEY() {
        return zYQ;
    }

    static boolean cEZ() {
        TbsLog.addLog(TbsLog.TBSLOG_CODE_SDK_UNAVAIL_X5CORE, null, new Object[0]);
        return false;
    }

    static String getTbsResourcesPath(Context context) {
        try {
            hu(context);
            if (zYK == null || TextUtils.isEmpty(zYK)) {
                return null;
            }
            StringBuilder stringBuilder = new StringBuilder(zYK);
            stringBuilder.append(File.separator);
            stringBuilder.append("res.apk");
            return stringBuilder.toString();
        } catch (Throwable th) {
            new StringBuilder("getTbsResourcesPath exception: ").append(Log.getStackTraceString(th));
            return null;
        }
    }

    static void ho(Context context) {
        try {
            TbsLinuxToolsJni tbsLinuxToolsJni = new TbsLinuxToolsJni(context);
            t.cEF();
            a(context, tbsLinuxToolsJni, t.hg(context));
            t.cEF();
            tbsLinuxToolsJni.fX(t.hh(context).getAbsolutePath(), "755");
        } catch (Throwable th) {
        }
    }

    static void hp(Context context) {
        try {
            TbsLinuxToolsJni tbsLinuxToolsJni = new TbsLinuxToolsJni(context);
            t.cEF();
            a(context, tbsLinuxToolsJni, t.hf(context));
        } catch (Throwable th) {
        }
    }

    public static boolean hq(Context context) {
        try {
            if (bks != null && bks.equals(context.getApplicationContext())) {
                return zYH;
            }
            Context applicationContext = context.getApplicationContext();
            bks = applicationContext;
            String packageName = applicationContext.getPackageName();
            String[] cER = cER();
            for (int i = 0; i < 4; i++) {
                if (packageName.equals(cER[i])) {
                    zYH = false;
                    return false;
                }
            }
            zYH = true;
            return true;
        } catch (Throwable th) {
        }
    }

    private static boolean hr(Context context) {
        if (context == null) {
            return false;
        }
        b(context, Integer.toString(0), "", "", Integer.toString(0));
        return true;
    }

    static synchronized String hs(Context context) {
        String str;
        Throwable th;
        synchronized (x.class) {
            BufferedInputStream bufferedInputStream = null;
            BufferedInputStream bufferedInputStream2;
            try {
                File bM = bM(context, "core_info");
                if (bM == null) {
                    if (null != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (Exception e) {
                        }
                    }
                    str = null;
                } else {
                    bufferedInputStream2 = new BufferedInputStream(new FileInputStream(bM));
                    try {
                        Properties properties = new Properties();
                        properties.load(bufferedInputStream2);
                        str = properties.getProperty("core_packagename", "");
                        if ("".equals(str)) {
                            if (bufferedInputStream2 != null) {
                                try {
                                    bufferedInputStream2.close();
                                } catch (Exception e2) {
                                }
                            }
                            str = null;
                        } else if (bufferedInputStream2 != null) {
                            try {
                                bufferedInputStream2.close();
                            } catch (Exception e3) {
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (bufferedInputStream2 != null) {
                            try {
                                bufferedInputStream2.close();
                            } catch (Exception e4) {
                            }
                        }
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedInputStream2 = null;
                if (bufferedInputStream2 != null) {
                    bufferedInputStream2.close();
                }
                throw th;
            }
        }
        return str;
    }

    private static synchronized int ht(Context context) {
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2;
        Throwable th;
        int i = 0;
        synchronized (x.class) {
            BufferedInputStream bufferedInputStream3 = null;
            try {
                File bM = bM(context, "core_info");
                if (bM == null) {
                    if (bufferedInputStream3 != null) {
                        try {
                            bufferedInputStream3.close();
                        } catch (Exception e) {
                        }
                    }
                } else {
                    bufferedInputStream = new BufferedInputStream(new FileInputStream(bM));
                    try {
                        Properties properties = new Properties();
                        properties.load(bufferedInputStream);
                        String property = properties.getProperty("core_version", "");
                        if ("".equals(property)) {
                            if (bufferedInputStream != null) {
                                bufferedInputStream.close();
                            }
                        } else {
                            i = Math.max(Integer.parseInt(property), 0);
                            if (bufferedInputStream != null) {
                                bufferedInputStream.close();
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (Exception e2) {
                            }
                        }
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedInputStream = bufferedInputStream3;
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                throw th;
            }
        }
        return i;
    }

    private static synchronized void hu(Context context) {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        synchronized (x.class) {
            if (!zYR) {
                BufferedInputStream bufferedInputStream2 = null;
                try {
                    File bM = bM(context, "core_info");
                    if (bM != null) {
                        bufferedInputStream = new BufferedInputStream(new FileInputStream(bM));
                        try {
                            Properties properties = new Properties();
                            properties.load(bufferedInputStream);
                            String property = properties.getProperty("core_version", "");
                            if (!"".equals(property)) {
                                zYL = Math.max(Integer.parseInt(property), 0);
                            }
                            property = properties.getProperty("core_packagename", "");
                            if (!"".equals(property)) {
                                zYM = property;
                            }
                            if (!(zYM == null || bks == null)) {
                                if (zYM.equals(bks.getPackageName())) {
                                    zYQ = true;
                                } else {
                                    zYQ = false;
                                }
                            }
                            property = properties.getProperty("core_path", "");
                            if (!"".equals(property)) {
                                zYK = property;
                            }
                            property = properties.getProperty("app_version", "");
                            if (!"".equals(property)) {
                                zYP = property;
                            }
                            zYN = Boolean.parseBoolean(properties.getProperty("core_disabled", "false"));
                            zYR = true;
                            if (bufferedInputStream != null) {
                                bufferedInputStream.close();
                            }
                        } catch (Throwable th2) {
                            Throwable th3 = th2;
                            bufferedInputStream2 = bufferedInputStream;
                            th = th3;
                            if (bufferedInputStream2 != null) {
                                try {
                                    bufferedInputStream2.close();
                                } catch (Exception e) {
                                }
                            }
                            throw th;
                        }
                    } else if (bufferedInputStream2 != null) {
                        try {
                            bufferedInputStream2.close();
                        } catch (Exception e2) {
                        }
                    }
                } catch (Throwable th4) {
                    th = th4;
                    if (bufferedInputStream2 != null) {
                        bufferedInputStream2.close();
                    }
                    throw th;
                }
            }
        }
        return;
    }

    public static void z(Context context, boolean z) {
        try {
            if (hq(context)) {
                t.cEF();
                File hh = t.hh(context);
                if (hh == null) {
                    return;
                }
                if (!z || !new File(hh, "core_info").exists()) {
                    if (zYI != null) {
                        t.cEF();
                        int abi = t.abi(zYI);
                        if (abi > 0) {
                            zYK = zYI;
                            zYM = "AppDefined";
                            zYL = abi;
                            b(context, Integer.toString(zYL), zYM, zYK, Integer.toString(1));
                            return;
                        }
                    }
                    cER();
                }
            }
        } catch (Exception e) {
        }
    }
}
