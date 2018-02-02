package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.qq.taf.jce.BuildConfig;
import com.tencent.smtt.sdk.v.b;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.a;
import com.tencent.smtt.utils.c;
import com.tencent.smtt.utils.f;
import com.tencent.smtt.utils.g;
import com.tencent.smtt.utils.j;
import com.tencent.smtt.utils.q;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.File;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public final class p {
    private static Context bks;
    private static String zXn;
    private static Handler zXo;
    private static String zXp;
    public static boolean zXq = false;
    private static Object zXr = new byte[0];
    private static l zXs;
    private static HandlerThread zXt;
    static boolean zXu;
    private static boolean zXv = false;
    private static boolean zXw = false;
    private static boolean zXx = false;
    private static long zXy = -1;

    protected static File HW(int i) {
        String[] cER = x.cER();
        File file = null;
        for (int i2 = 0; i2 < 4; i2++) {
            String str = cER[i2];
            if (!str.equals(bks.getApplicationInfo().packageName)) {
                file = new File(f.a(bks, str, 4, false), gK(bks) ? "x5.oversea.tbs.org" : "x5.tbs.org");
                if (!file.exists()) {
                    TbsLog.i("TbsDownload", "can not find local backup core file");
                } else if (a.c(bks, file) == i) {
                    TbsLog.i("TbsDownload", "local tbs version fond,path = " + file.getAbsolutePath());
                    break;
                } else {
                    TbsLog.i("TbsDownload", "version is not match");
                }
            }
        }
        return file;
    }

    protected static File HX(int i) {
        String[] cER = x.cER();
        File file = null;
        for (int i2 = 0; i2 < 4; i2++) {
            String str = cER[i2];
            File file2 = new File(f.a(bks, str, 4, false), gK(bks) ? "x5.oversea.tbs.org" : "x5.tbs.org");
            if (file2.exists() && a.c(bks, file2) == i) {
                TbsLog.i("TbsDownload", "local tbs version fond,path = " + file2.getAbsolutePath());
                return file2;
            }
            file = new File(f.a(bks, str, 4, false), "x5.tbs.decouple");
            if (file.exists() && a.c(bks, file) == i) {
                TbsLog.i("TbsDownload", "local tbs version fond,path = " + file.getAbsolutePath());
                return file;
            }
        }
        return file;
    }

    private static boolean a(Context context, boolean z, a aVar) {
        Matcher matcher = null;
        o gG = o.gG(context);
        if (VERSION.SDK_INT < 8) {
            gG.HU(-102);
            return false;
        }
        if (!gG.zXm.contains("is_oversea")) {
            if (z && !"com.tencent.mm".equals(context.getApplicationInfo().packageName)) {
                TbsLog.i("TbsDownload", "needDownload-oversea is true, but not WX");
                z = false;
            }
            gG.zXl.put("is_oversea", Boolean.valueOf(z));
            gG.commit();
            zXw = z;
            TbsLog.i("TbsDownload", "needDownload-first-called--isoversea = " + z);
        }
        if (!gK(context) || VERSION.SDK_INT == 16 || VERSION.SDK_INT == 17 || VERSION.SDK_INT == 18) {
            CharSequence string = gG.zXm.getString("device_cpuabi", matcher);
            zXp = string;
            if (!TextUtils.isEmpty(string)) {
                try {
                    matcher = Pattern.compile("i686|mips|x86_64").matcher(zXp);
                } catch (Exception e) {
                }
                if (matcher != null && matcher.find()) {
                    if (aVar != null) {
                        aVar.g(false, 0);
                    }
                    gG.HU(-104);
                    return false;
                }
            }
            return true;
        }
        TbsLog.i("TbsDownload", "needDownload- return false,  because of  version is " + VERSION.SDK_INT + ", and overea");
        if (aVar != null) {
            aVar.g(false, 0);
        }
        gG.HU(-103);
        return false;
    }

    public static boolean a(Context context, boolean z, boolean z2, a aVar) {
        TbsLog.initIfNeed(context);
        if (!t.zXT) {
            TbsLog.app_extra("TbsDownload", context);
            Context applicationContext = context.getApplicationContext();
            bks = applicationContext;
            o gG = o.gG(applicationContext);
            gG.HU(-100);
            if (!a(bks, z, aVar)) {
                return false;
            }
            cEt();
            if (zXv) {
                if (aVar != null) {
                    aVar.g(false, 0);
                }
                gG.HU(-105);
                return false;
            }
            boolean contains;
            boolean d = d(bks, z2, false);
            if (d) {
                TbsLog.i("TbsDownload", "[TbsDownloader.queryConfig]");
                zXo.removeMessages(100);
                Message obtain = Message.obtain(zXo, 100);
                if (aVar != null) {
                    obtain.obj = aVar;
                }
                obtain.arg1 = 0;
                obtain.arg1 = z2 ? 1 : 0;
                obtain.sendToTarget();
                gG.HU(-114);
            }
            zXo.removeMessages(102);
            Message.obtain(zXo, 102).sendToTarget();
            if (QbSdk.zVL || !x.hq(context)) {
                contains = gG.zXm.contains("tbs_needdownload");
                TbsLog.i("TbsDownload", "[TbsDownloader.needDownload] hasNeedDownloadKey=" + contains);
                contains = (contains || x.hq(context)) ? gG.zXm.getBoolean("tbs_needdownload", false) : true;
            } else {
                contains = false;
            }
            if (!contains) {
                int ha = t.cEF().ha(bks);
                if (d || ha <= 0) {
                    zXo.removeMessages(103);
                    if (ha > 0 || d) {
                        Message.obtain(zXo, 103, 1, 0, bks).sendToTarget();
                    } else {
                        Message.obtain(zXo, 103, 0, 0, bks).sendToTarget();
                    }
                    gG.HU(-121);
                } else {
                    gG.HU(-119);
                }
            } else if (cEy()) {
                gG.HU(-118);
            } else {
                contains = false;
            }
            if (!(d || aVar == null)) {
                aVar.g(false, 0);
            }
            TbsLog.i("TbsDownload", "[TbsDownloader.needDownload] needDownload=" + contains);
            return contains;
        } else if (aVar == null) {
            return false;
        } else {
            aVar.g(false, 0);
            return false;
        }
    }

    private static String abh(String str) {
        return str == null ? "" : str;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @TargetApi(11)
    private static boolean b(String str, int i, boolean z, boolean z2) {
        int i2;
        String str2;
        String str3;
        Object obj;
        int i3;
        Object obj2;
        boolean z3;
        int i4;
        long j;
        Object obj3;
        int gW;
        String str4;
        TbsLog.i("TbsDownload", "[TbsDownloader.readResponse] response=" + str);
        o gG = o.gG(bks);
        if (TextUtils.isEmpty(str)) {
            if (z) {
                gG.HU(-108);
            } else {
                gG.HU(-208);
            }
            return false;
        }
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.getInt("RET") != 0) {
            if (z) {
                gG.HU(-109);
            } else {
                gG.HU(-209);
            }
            return false;
        }
        Object obj4;
        int i5;
        int i6 = jSONObject.getInt("RESPONSECODE");
        CharSequence string = jSONObject.getString("DOWNLOADURL");
        String optString = jSONObject.optString("URLLIST", "");
        int i7 = jSONObject.getInt("TBSAPKSERVERVERSION");
        int i8 = jSONObject.getInt("DOWNLOADMAXFLOW");
        int i9 = jSONObject.getInt("DOWNLOAD_MIN_FREE_SPACE");
        int i10 = jSONObject.getInt("DOWNLOAD_SUCCESS_MAX_RETRYTIMES");
        int i11 = jSONObject.getInt("DOWNLOAD_FAILED_MAX_RETRYTIMES");
        long j2 = jSONObject.getLong("DOWNLOAD_SINGLE_TIMEOUT");
        long j3 = jSONObject.getLong("TBSAPKFILESIZE");
        long optLong = jSONObject.optLong("RETRY_INTERVAL", 0);
        int optInt = jSONObject.optInt("FLOWCTR", -1);
        int i12 = 0;
        try {
            i12 = jSONObject.getInt("USEBBACKUPVER");
        } catch (Exception e) {
        }
        gG.zXl.put("use_backup_version", Integer.valueOf(i12));
        if (z && QbSdk.zVU && x.hq(bks)) {
            try {
                q.cED().m(bks, "bugly_switch.txt", jSONObject.optInt("BUGLY", 0) == 1);
            } catch (Throwable th) {
                TbsLog.i("qbsdk", "throwable:" + th.toString());
            }
        }
        if (z) {
            try {
                boolean z4 = (jSONObject.optInt("TEMPLATESWITCH", 0) & 1) != 0;
                q.cED().m(bks, "cookie_switch.txt", z4);
                TbsLog.w("TbsDownload", "useCookieCompatiable:" + z4);
            } catch (Throwable th2) {
                TbsLog.i("qbsdk", "throwable:" + th2.toString());
            }
        }
        Object obj5 = null;
        int i13 = 0;
        int i14 = 0;
        String str5 = "";
        try {
            String string2 = jSONObject.getString("PKGMD5");
            try {
                Object obj6;
                i2 = jSONObject.getInt("RESETX5");
                try {
                    i13 = jSONObject.getInt("UPLOADLOG");
                    try {
                        if (jSONObject.has("RESETTOKEN")) {
                            obj6 = jSONObject.getInt("RESETTOKEN") != 0 ? 1 : null;
                        } else {
                            obj6 = null;
                        }
                    } catch (Exception e2) {
                        i14 = i13;
                        i13 = i2;
                        str2 = string2;
                        str3 = str5;
                        obj = null;
                        i3 = i13;
                        obj4 = obj5;
                        obj2 = obj;
                        i2 = i14;
                        str5 = str3;
                        z3 = true;
                        i12 = jSONObject.getInt("RESETDECOUPLECORE");
                        i4 = 0;
                        i4 = jSONObject.getInt("RESETTODECOUPLECORE");
                        synchronized (zXr) {
                            if (obj2 != null) {
                                gG.zXl.put("tbs_deskey_token", "");
                            }
                            gG.zXl.put("tbs_deskey_token", str5 + "&" + j.cFw());
                        }
                        if (i3 != 1) {
                            if (z) {
                                gG.HU(-210);
                            } else {
                                gG.HU(-110);
                            }
                            QbSdk.reset(bks, i4 != 1);
                            return false;
                        }
                        if (!z3) {
                            gG.nS(z3);
                        }
                        if (i12 == 1) {
                            QbSdk.resetDecoupleCore(bks);
                        }
                        if (i2 == 1) {
                            zXo.removeMessages(104);
                            Message.obtain(zXo, 104).sendToTarget();
                        }
                        if (optInt == 1) {
                            j = optLong <= 604800 ? 604800 : optLong;
                        }
                        j = 86400;
                        if (zXy >= 0) {
                            j = zXy;
                        }
                        gG.zXl.put("retry_interval", Long.valueOf(j));
                        i12 = 0;
                        i4 = 0;
                        if (z) {
                        }
                        try {
                            i4 = o.gG(bks).zXm.getInt("tbs_downloaddecouplecore", 0);
                        } catch (Exception e3) {
                        }
                        t.cEF();
                        i12 = t.gX(bks);
                        TbsLog.i("TbsDownload", "in response decoupleCoreVersion is " + i12);
                        gG.zXl.put("tbs_decouplecoreversion", Integer.valueOf(i12));
                        gG.zXl.put("tbs_downloaddecouplecore", Integer.valueOf(i4));
                        if (!x.hq(bks)) {
                            if (i12 > 0) {
                                t.cEF();
                                t.cEF().hc(bks);
                            }
                            if (i12 == 0) {
                                try {
                                    t.cEF();
                                    f.T(t.hf(bks));
                                } catch (Throwable th3) {
                                }
                            }
                        }
                        if (TextUtils.isEmpty(string)) {
                        }
                        TbsLog.i("TbsDownload", "in response responseCode is " + i6);
                        if (i6 != 0) {
                            gG.zXl.put("tbs_responsecode", Integer.valueOf(i6));
                            gG.zXl.put("tbs_needdownload", Boolean.valueOf(false));
                            if (z) {
                                gG.zXl.put("tbs_download_interrupt_code_reason", Integer.valueOf(-211));
                                gG.HU(-211);
                            } else {
                                gG.zXl.put("tbs_download_interrupt_code_reason", Integer.valueOf(-111));
                            }
                            gG.commit();
                            if (!x.hq(bks)) {
                                cEr();
                            }
                            return false;
                        }
                        i5 = o.gG(bks).zXm.getInt("tbs_download_version", 0);
                        if (i5 > i7) {
                            zXs.clearCache();
                            t.cEF();
                            t.he(bks);
                        }
                        obj3 = null;
                        if (!x.hq(bks)) {
                            t.cEF();
                            gW = t.gW(bks);
                            if (gW >= i7) {
                                obj3 = 1;
                            }
                            TbsLog.i("TbsDownload", "tmpCoreVersion is " + gW + " tbsDownloadVersion is" + i7);
                        }
                        if (i < i7) {
                        }
                        gG.zXl.put("tbs_needdownload", Boolean.valueOf(false));
                        if (z) {
                            i12 = -212;
                            if (TextUtils.isEmpty(string)) {
                                i12 = -217;
                            } else if (i7 <= 0) {
                                i12 = -218;
                            } else if (i >= i7) {
                                i12 = -219;
                            }
                            gG.zXl.put("tbs_download_interrupt_code_reason", Integer.valueOf(i12));
                            gG.HU(i12);
                        } else if (TextUtils.isEmpty(string)) {
                            gG.zXl.put("tbs_download_interrupt_code_reason", Integer.valueOf(-124));
                        } else if (i7 <= 0) {
                            gG.zXl.put("tbs_download_interrupt_code_reason", Integer.valueOf(-125));
                        } else if (i < i7) {
                            gG.zXl.put("tbs_download_interrupt_code_reason", Integer.valueOf(-127));
                        } else {
                            gG.zXl.put("tbs_download_interrupt_code_reason", Integer.valueOf(-112));
                        }
                        gG.commit();
                        TbsLog.i("TbsDownload", "version error or downloadUrl empty ,return ahead tbsLocalVersion=" + i + " tbsDownloadVersion=" + i7 + " tbsLastDownloadVersion=" + i5 + " downloadUrl=" + string);
                        return false;
                    }
                } catch (Exception e4) {
                    i13 = i2;
                    str2 = string2;
                    str4 = str5;
                    obj = null;
                    str3 = str4;
                    i3 = i13;
                    obj4 = obj5;
                    obj2 = obj;
                    i2 = i14;
                    str5 = str3;
                    z3 = true;
                    i12 = jSONObject.getInt("RESETDECOUPLECORE");
                    i4 = 0;
                    i4 = jSONObject.getInt("RESETTODECOUPLECORE");
                    synchronized (zXr) {
                        if (obj2 != null) {
                            gG.zXl.put("tbs_deskey_token", "");
                        }
                        gG.zXl.put("tbs_deskey_token", str5 + "&" + j.cFw());
                    }
                    if (i3 != 1) {
                        if (z3) {
                            gG.nS(z3);
                        }
                        if (i12 == 1) {
                            QbSdk.resetDecoupleCore(bks);
                        }
                        if (i2 == 1) {
                            zXo.removeMessages(104);
                            Message.obtain(zXo, 104).sendToTarget();
                        }
                        if (optInt == 1) {
                            if (optLong <= 604800) {
                            }
                        }
                        j = 86400;
                        if (zXy >= 0) {
                            j = zXy;
                        }
                        gG.zXl.put("retry_interval", Long.valueOf(j));
                        i12 = 0;
                        i4 = 0;
                        i12 = z ? o.gG(bks).zXm.getInt("tbs_decouplecoreversion", 0) : jSONObject.getInt("DECOUPLECOREVERSION");
                        i4 = o.gG(bks).zXm.getInt("tbs_downloaddecouplecore", 0);
                        t.cEF();
                        i12 = t.gX(bks);
                        TbsLog.i("TbsDownload", "in response decoupleCoreVersion is " + i12);
                        gG.zXl.put("tbs_decouplecoreversion", Integer.valueOf(i12));
                        gG.zXl.put("tbs_downloaddecouplecore", Integer.valueOf(i4));
                        if (x.hq(bks)) {
                            if (i12 > 0) {
                                t.cEF();
                                t.cEF().hc(bks);
                            }
                            if (i12 == 0) {
                                t.cEF();
                                f.T(t.hf(bks));
                            }
                        }
                        if (TextUtils.isEmpty(string)) {
                        }
                        TbsLog.i("TbsDownload", "in response responseCode is " + i6);
                        if (i6 != 0) {
                            i5 = o.gG(bks).zXm.getInt("tbs_download_version", 0);
                            if (i5 > i7) {
                                zXs.clearCache();
                                t.cEF();
                                t.he(bks);
                            }
                            obj3 = null;
                            if (x.hq(bks)) {
                                t.cEF();
                                gW = t.gW(bks);
                                if (gW >= i7) {
                                    obj3 = 1;
                                }
                                TbsLog.i("TbsDownload", "tmpCoreVersion is " + gW + " tbsDownloadVersion is" + i7);
                            }
                            if (i < i7) {
                            }
                            gG.zXl.put("tbs_needdownload", Boolean.valueOf(false));
                            if (z) {
                                i12 = -212;
                                if (TextUtils.isEmpty(string)) {
                                    i12 = -217;
                                } else if (i7 <= 0) {
                                    i12 = -218;
                                } else if (i >= i7) {
                                    i12 = -219;
                                }
                                gG.zXl.put("tbs_download_interrupt_code_reason", Integer.valueOf(i12));
                                gG.HU(i12);
                            } else if (TextUtils.isEmpty(string)) {
                                gG.zXl.put("tbs_download_interrupt_code_reason", Integer.valueOf(-124));
                            } else if (i7 <= 0) {
                                gG.zXl.put("tbs_download_interrupt_code_reason", Integer.valueOf(-125));
                            } else if (i < i7) {
                                gG.zXl.put("tbs_download_interrupt_code_reason", Integer.valueOf(-112));
                            } else {
                                gG.zXl.put("tbs_download_interrupt_code_reason", Integer.valueOf(-127));
                            }
                            gG.commit();
                            TbsLog.i("TbsDownload", "version error or downloadUrl empty ,return ahead tbsLocalVersion=" + i + " tbsDownloadVersion=" + i7 + " tbsLastDownloadVersion=" + i5 + " downloadUrl=" + string);
                            return false;
                        }
                        gG.zXl.put("tbs_responsecode", Integer.valueOf(i6));
                        gG.zXl.put("tbs_needdownload", Boolean.valueOf(false));
                        if (z) {
                            gG.zXl.put("tbs_download_interrupt_code_reason", Integer.valueOf(-211));
                            gG.HU(-211);
                        } else {
                            gG.zXl.put("tbs_download_interrupt_code_reason", Integer.valueOf(-111));
                        }
                        gG.commit();
                        if (x.hq(bks)) {
                            cEr();
                        }
                        return false;
                    }
                    if (z) {
                        gG.HU(-210);
                    } else {
                        gG.HU(-110);
                    }
                    if (i4 != 1) {
                    }
                    QbSdk.reset(bks, i4 != 1);
                    return false;
                }
                try {
                    if (jSONObject.has("SETTOKEN")) {
                        str5 = jSONObject.getString("SETTOKEN");
                    }
                    z4 = jSONObject.has("ENABLE_LOAD_RENAME_FILE_LOCK") ? jSONObject.getInt("ENABLE_LOAD_RENAME_FILE_LOCK") != 0 : true;
                    obj4 = string2;
                    i3 = i2;
                    i2 = i13;
                    obj2 = obj6;
                    z3 = z4;
                } catch (Exception e5) {
                    str3 = str5;
                    obj = obj6;
                    i14 = i13;
                    i13 = i2;
                    str2 = string2;
                    i3 = i13;
                    obj4 = obj5;
                    obj2 = obj;
                    i2 = i14;
                    str5 = str3;
                    z3 = true;
                    i12 = jSONObject.getInt("RESETDECOUPLECORE");
                    i4 = 0;
                    i4 = jSONObject.getInt("RESETTODECOUPLECORE");
                    synchronized (zXr) {
                        if (obj2 != null) {
                            gG.zXl.put("tbs_deskey_token", "");
                        }
                        gG.zXl.put("tbs_deskey_token", str5 + "&" + j.cFw());
                    }
                    if (i3 != 1) {
                        if (z) {
                            gG.HU(-110);
                        } else {
                            gG.HU(-210);
                        }
                        if (i4 != 1) {
                        }
                        QbSdk.reset(bks, i4 != 1);
                        return false;
                    }
                    if (z3) {
                        gG.nS(z3);
                    }
                    if (i12 == 1) {
                        QbSdk.resetDecoupleCore(bks);
                    }
                    if (i2 == 1) {
                        zXo.removeMessages(104);
                        Message.obtain(zXo, 104).sendToTarget();
                    }
                    if (optInt == 1) {
                        if (optLong <= 604800) {
                        }
                    }
                    j = 86400;
                    if (zXy >= 0) {
                        j = zXy;
                    }
                    gG.zXl.put("retry_interval", Long.valueOf(j));
                    i12 = 0;
                    i4 = 0;
                    if (z) {
                    }
                    i4 = o.gG(bks).zXm.getInt("tbs_downloaddecouplecore", 0);
                    t.cEF();
                    i12 = t.gX(bks);
                    TbsLog.i("TbsDownload", "in response decoupleCoreVersion is " + i12);
                    gG.zXl.put("tbs_decouplecoreversion", Integer.valueOf(i12));
                    gG.zXl.put("tbs_downloaddecouplecore", Integer.valueOf(i4));
                    if (x.hq(bks)) {
                        if (i12 > 0) {
                            t.cEF();
                            t.cEF().hc(bks);
                        }
                        if (i12 == 0) {
                            t.cEF();
                            f.T(t.hf(bks));
                        }
                    }
                    if (TextUtils.isEmpty(string)) {
                    }
                    TbsLog.i("TbsDownload", "in response responseCode is " + i6);
                    if (i6 != 0) {
                        gG.zXl.put("tbs_responsecode", Integer.valueOf(i6));
                        gG.zXl.put("tbs_needdownload", Boolean.valueOf(false));
                        if (z) {
                            gG.zXl.put("tbs_download_interrupt_code_reason", Integer.valueOf(-111));
                        } else {
                            gG.zXl.put("tbs_download_interrupt_code_reason", Integer.valueOf(-211));
                            gG.HU(-211);
                        }
                        gG.commit();
                        if (x.hq(bks)) {
                            cEr();
                        }
                        return false;
                    }
                    i5 = o.gG(bks).zXm.getInt("tbs_download_version", 0);
                    if (i5 > i7) {
                        zXs.clearCache();
                        t.cEF();
                        t.he(bks);
                    }
                    obj3 = null;
                    if (x.hq(bks)) {
                        t.cEF();
                        gW = t.gW(bks);
                        if (gW >= i7) {
                            obj3 = 1;
                        }
                        TbsLog.i("TbsDownload", "tmpCoreVersion is " + gW + " tbsDownloadVersion is" + i7);
                    }
                    if (i < i7) {
                    }
                    gG.zXl.put("tbs_needdownload", Boolean.valueOf(false));
                    if (z) {
                        i12 = -212;
                        if (TextUtils.isEmpty(string)) {
                            i12 = -217;
                        } else if (i7 <= 0) {
                            i12 = -218;
                        } else if (i >= i7) {
                            i12 = -219;
                        }
                        gG.zXl.put("tbs_download_interrupt_code_reason", Integer.valueOf(i12));
                        gG.HU(i12);
                    } else if (TextUtils.isEmpty(string)) {
                        gG.zXl.put("tbs_download_interrupt_code_reason", Integer.valueOf(-124));
                    } else if (i7 <= 0) {
                        gG.zXl.put("tbs_download_interrupt_code_reason", Integer.valueOf(-125));
                    } else if (i < i7) {
                        gG.zXl.put("tbs_download_interrupt_code_reason", Integer.valueOf(-127));
                    } else {
                        gG.zXl.put("tbs_download_interrupt_code_reason", Integer.valueOf(-112));
                    }
                    gG.commit();
                    TbsLog.i("TbsDownload", "version error or downloadUrl empty ,return ahead tbsLocalVersion=" + i + " tbsDownloadVersion=" + i7 + " tbsLastDownloadVersion=" + i5 + " downloadUrl=" + string);
                    return false;
                }
            } catch (Exception e6) {
                str2 = string2;
                str3 = str5;
                obj = null;
                i3 = i13;
                obj4 = obj5;
                obj2 = obj;
                i2 = i14;
                str5 = str3;
                z3 = true;
                i12 = jSONObject.getInt("RESETDECOUPLECORE");
                i4 = 0;
                i4 = jSONObject.getInt("RESETTODECOUPLECORE");
                synchronized (zXr) {
                    if (obj2 != null) {
                        gG.zXl.put("tbs_deskey_token", "");
                    }
                    gG.zXl.put("tbs_deskey_token", str5 + "&" + j.cFw());
                }
                if (i3 != 1) {
                    if (z3) {
                        gG.nS(z3);
                    }
                    if (i12 == 1) {
                        QbSdk.resetDecoupleCore(bks);
                    }
                    if (i2 == 1) {
                        zXo.removeMessages(104);
                        Message.obtain(zXo, 104).sendToTarget();
                    }
                    if (optInt == 1) {
                        if (optLong <= 604800) {
                        }
                    }
                    j = 86400;
                    if (zXy >= 0) {
                        j = zXy;
                    }
                    gG.zXl.put("retry_interval", Long.valueOf(j));
                    i12 = 0;
                    i4 = 0;
                    if (z) {
                    }
                    i4 = o.gG(bks).zXm.getInt("tbs_downloaddecouplecore", 0);
                    t.cEF();
                    i12 = t.gX(bks);
                    TbsLog.i("TbsDownload", "in response decoupleCoreVersion is " + i12);
                    gG.zXl.put("tbs_decouplecoreversion", Integer.valueOf(i12));
                    gG.zXl.put("tbs_downloaddecouplecore", Integer.valueOf(i4));
                    if (x.hq(bks)) {
                        if (i12 > 0) {
                            t.cEF();
                            t.cEF().hc(bks);
                        }
                        if (i12 == 0) {
                            t.cEF();
                            f.T(t.hf(bks));
                        }
                    }
                    if (TextUtils.isEmpty(string)) {
                    }
                    TbsLog.i("TbsDownload", "in response responseCode is " + i6);
                    if (i6 != 0) {
                        i5 = o.gG(bks).zXm.getInt("tbs_download_version", 0);
                        if (i5 > i7) {
                            zXs.clearCache();
                            t.cEF();
                            t.he(bks);
                        }
                        obj3 = null;
                        if (x.hq(bks)) {
                            t.cEF();
                            gW = t.gW(bks);
                            if (gW >= i7) {
                                obj3 = 1;
                            }
                            TbsLog.i("TbsDownload", "tmpCoreVersion is " + gW + " tbsDownloadVersion is" + i7);
                        }
                        if (i < i7) {
                        }
                        gG.zXl.put("tbs_needdownload", Boolean.valueOf(false));
                        if (z) {
                            i12 = -212;
                            if (TextUtils.isEmpty(string)) {
                                i12 = -217;
                            } else if (i7 <= 0) {
                                i12 = -218;
                            } else if (i >= i7) {
                                i12 = -219;
                            }
                            gG.zXl.put("tbs_download_interrupt_code_reason", Integer.valueOf(i12));
                            gG.HU(i12);
                        } else if (TextUtils.isEmpty(string)) {
                            gG.zXl.put("tbs_download_interrupt_code_reason", Integer.valueOf(-124));
                        } else if (i7 <= 0) {
                            gG.zXl.put("tbs_download_interrupt_code_reason", Integer.valueOf(-125));
                        } else if (i < i7) {
                            gG.zXl.put("tbs_download_interrupt_code_reason", Integer.valueOf(-112));
                        } else {
                            gG.zXl.put("tbs_download_interrupt_code_reason", Integer.valueOf(-127));
                        }
                        gG.commit();
                        TbsLog.i("TbsDownload", "version error or downloadUrl empty ,return ahead tbsLocalVersion=" + i + " tbsDownloadVersion=" + i7 + " tbsLastDownloadVersion=" + i5 + " downloadUrl=" + string);
                        return false;
                    }
                    gG.zXl.put("tbs_responsecode", Integer.valueOf(i6));
                    gG.zXl.put("tbs_needdownload", Boolean.valueOf(false));
                    if (z) {
                        gG.zXl.put("tbs_download_interrupt_code_reason", Integer.valueOf(-211));
                        gG.HU(-211);
                    } else {
                        gG.zXl.put("tbs_download_interrupt_code_reason", Integer.valueOf(-111));
                    }
                    gG.commit();
                    if (x.hq(bks)) {
                        cEr();
                    }
                    return false;
                }
                if (z) {
                    gG.HU(-210);
                } else {
                    gG.HU(-110);
                }
                if (i4 != 1) {
                }
                QbSdk.reset(bks, i4 != 1);
                return false;
            }
        } catch (Exception e7) {
            str4 = str5;
            obj = null;
            str3 = str4;
            i3 = i13;
            obj4 = obj5;
            obj2 = obj;
            i2 = i14;
            str5 = str3;
            z3 = true;
            i12 = jSONObject.getInt("RESETDECOUPLECORE");
            i4 = 0;
            i4 = jSONObject.getInt("RESETTODECOUPLECORE");
            synchronized (zXr) {
                if (obj2 != null) {
                    gG.zXl.put("tbs_deskey_token", "");
                }
                gG.zXl.put("tbs_deskey_token", str5 + "&" + j.cFw());
            }
            if (i3 != 1) {
                if (z3) {
                    gG.nS(z3);
                }
                if (i12 == 1) {
                    QbSdk.resetDecoupleCore(bks);
                }
                if (i2 == 1) {
                    zXo.removeMessages(104);
                    Message.obtain(zXo, 104).sendToTarget();
                }
                if (optInt == 1) {
                    if (optLong <= 604800) {
                    }
                }
                j = 86400;
                if (zXy >= 0) {
                    j = zXy;
                }
                gG.zXl.put("retry_interval", Long.valueOf(j));
                i12 = 0;
                i4 = 0;
                if (z) {
                }
                i4 = o.gG(bks).zXm.getInt("tbs_downloaddecouplecore", 0);
                t.cEF();
                i12 = t.gX(bks);
                TbsLog.i("TbsDownload", "in response decoupleCoreVersion is " + i12);
                gG.zXl.put("tbs_decouplecoreversion", Integer.valueOf(i12));
                gG.zXl.put("tbs_downloaddecouplecore", Integer.valueOf(i4));
                if (x.hq(bks)) {
                    if (i12 > 0) {
                        t.cEF();
                        t.cEF().hc(bks);
                    }
                    if (i12 == 0) {
                        t.cEF();
                        f.T(t.hf(bks));
                    }
                }
                if (TextUtils.isEmpty(string)) {
                }
                TbsLog.i("TbsDownload", "in response responseCode is " + i6);
                if (i6 != 0) {
                    i5 = o.gG(bks).zXm.getInt("tbs_download_version", 0);
                    if (i5 > i7) {
                        zXs.clearCache();
                        t.cEF();
                        t.he(bks);
                    }
                    obj3 = null;
                    if (x.hq(bks)) {
                        t.cEF();
                        gW = t.gW(bks);
                        if (gW >= i7) {
                            obj3 = 1;
                        }
                        TbsLog.i("TbsDownload", "tmpCoreVersion is " + gW + " tbsDownloadVersion is" + i7);
                    }
                    if (i < i7) {
                    }
                    gG.zXl.put("tbs_needdownload", Boolean.valueOf(false));
                    if (z) {
                        i12 = -212;
                        if (TextUtils.isEmpty(string)) {
                            i12 = -217;
                        } else if (i7 <= 0) {
                            i12 = -218;
                        } else if (i >= i7) {
                            i12 = -219;
                        }
                        gG.zXl.put("tbs_download_interrupt_code_reason", Integer.valueOf(i12));
                        gG.HU(i12);
                    } else if (TextUtils.isEmpty(string)) {
                        gG.zXl.put("tbs_download_interrupt_code_reason", Integer.valueOf(-124));
                    } else if (i7 <= 0) {
                        gG.zXl.put("tbs_download_interrupt_code_reason", Integer.valueOf(-125));
                    } else if (i < i7) {
                        gG.zXl.put("tbs_download_interrupt_code_reason", Integer.valueOf(-112));
                    } else {
                        gG.zXl.put("tbs_download_interrupt_code_reason", Integer.valueOf(-127));
                    }
                    gG.commit();
                    TbsLog.i("TbsDownload", "version error or downloadUrl empty ,return ahead tbsLocalVersion=" + i + " tbsDownloadVersion=" + i7 + " tbsLastDownloadVersion=" + i5 + " downloadUrl=" + string);
                    return false;
                }
                gG.zXl.put("tbs_responsecode", Integer.valueOf(i6));
                gG.zXl.put("tbs_needdownload", Boolean.valueOf(false));
                if (z) {
                    gG.zXl.put("tbs_download_interrupt_code_reason", Integer.valueOf(-211));
                    gG.HU(-211);
                } else {
                    gG.zXl.put("tbs_download_interrupt_code_reason", Integer.valueOf(-111));
                }
                gG.commit();
                if (x.hq(bks)) {
                    cEr();
                }
                return false;
            }
            if (z) {
                gG.HU(-210);
            } else {
                gG.HU(-110);
            }
            if (i4 != 1) {
            }
            QbSdk.reset(bks, i4 != 1);
            return false;
        }
        try {
            i12 = jSONObject.getInt("RESETDECOUPLECORE");
        } catch (Exception e8) {
            i12 = 0;
        }
        i4 = 0;
        try {
            i4 = jSONObject.getInt("RESETTODECOUPLECORE");
        } catch (Exception e9) {
        }
        synchronized (zXr) {
            if (obj2 != null) {
                gG.zXl.put("tbs_deskey_token", "");
            }
            if (!TextUtils.isEmpty(str5) && str5.length() == 96) {
                gG.zXl.put("tbs_deskey_token", str5 + "&" + j.cFw());
            }
        }
        if (i3 != 1) {
            if (z) {
                gG.HU(-110);
            } else {
                gG.HU(-210);
            }
            if (i4 != 1) {
            }
            QbSdk.reset(bks, i4 != 1);
            return false;
        }
        if (z3) {
            gG.nS(z3);
        }
        if (i12 == 1) {
            QbSdk.resetDecoupleCore(bks);
        }
        if (i2 == 1) {
            zXo.removeMessages(104);
            Message.obtain(zXo, 104).sendToTarget();
        }
        if (optInt == 1) {
            if (optLong <= 604800) {
            }
        }
        j = 86400;
        if (zXy >= 0) {
            j = zXy;
        }
        gG.zXl.put("retry_interval", Long.valueOf(j));
        i12 = 0;
        i4 = 0;
        if (z) {
        }
        i4 = o.gG(bks).zXm.getInt("tbs_downloaddecouplecore", 0);
        if (z && !x.hq(bks) && r2 == 0) {
            t.cEF();
            i12 = t.gX(bks);
        }
        TbsLog.i("TbsDownload", "in response decoupleCoreVersion is " + i12);
        gG.zXl.put("tbs_decouplecoreversion", Integer.valueOf(i12));
        gG.zXl.put("tbs_downloaddecouplecore", Integer.valueOf(i4));
        if (x.hq(bks)) {
            if (i12 > 0) {
                t.cEF();
                if (i12 != t.gX(bks) && i12 == t.cEF().gY(bks)) {
                    t.cEF().hc(bks);
                }
            }
            if (i12 == 0) {
                t.cEF();
                f.T(t.hf(bks));
            }
        }
        if (TextUtils.isEmpty(string) || !x.hq(bks)) {
            TbsLog.i("TbsDownload", "in response responseCode is " + i6);
            if (i6 != 0) {
                gG.zXl.put("tbs_responsecode", Integer.valueOf(i6));
                gG.zXl.put("tbs_needdownload", Boolean.valueOf(false));
                if (z) {
                    gG.zXl.put("tbs_download_interrupt_code_reason", Integer.valueOf(-111));
                } else {
                    gG.zXl.put("tbs_download_interrupt_code_reason", Integer.valueOf(-211));
                    gG.HU(-211);
                }
                gG.commit();
                if (x.hq(bks)) {
                    cEr();
                }
                return false;
            }
            i5 = o.gG(bks).zXm.getInt("tbs_download_version", 0);
            if (i5 > i7) {
                zXs.clearCache();
                t.cEF();
                t.he(bks);
            }
            obj3 = null;
            if (x.hq(bks)) {
                t.cEF();
                gW = t.gW(bks);
                if (gW >= i7) {
                    obj3 = 1;
                }
                TbsLog.i("TbsDownload", "tmpCoreVersion is " + gW + " tbsDownloadVersion is" + i7);
            }
            if ((i < i7 || TextUtils.isEmpty(string) || r2 != null) && i4 != 1) {
                gG.zXl.put("tbs_needdownload", Boolean.valueOf(false));
                if (z) {
                    i12 = -212;
                    if (TextUtils.isEmpty(string)) {
                        i12 = -217;
                    } else if (i7 <= 0) {
                        i12 = -218;
                    } else if (i >= i7) {
                        i12 = -219;
                    }
                    gG.zXl.put("tbs_download_interrupt_code_reason", Integer.valueOf(i12));
                    gG.HU(i12);
                } else if (TextUtils.isEmpty(string)) {
                    gG.zXl.put("tbs_download_interrupt_code_reason", Integer.valueOf(-124));
                } else if (i7 <= 0) {
                    gG.zXl.put("tbs_download_interrupt_code_reason", Integer.valueOf(-125));
                } else if (i < i7) {
                    gG.zXl.put("tbs_download_interrupt_code_reason", Integer.valueOf(-127));
                } else {
                    gG.zXl.put("tbs_download_interrupt_code_reason", Integer.valueOf(-112));
                }
                gG.commit();
                TbsLog.i("TbsDownload", "version error or downloadUrl empty ,return ahead tbsLocalVersion=" + i + " tbsDownloadVersion=" + i7 + " tbsLastDownloadVersion=" + i5 + " downloadUrl=" + string);
                return false;
            }
            if (!string.equals(gG.zXm.getString("tbs_downloadurl", null))) {
                zXs.clearCache();
                gG.zXl.put("tbs_download_failed_retrytimes", Integer.valueOf(0));
                gG.zXl.put("tbs_download_success_retrytimes", Integer.valueOf(0));
            }
            gG.zXl.put("tbs_download_version", Integer.valueOf(i7));
            TbsLog.i("TbsDownload", "put KEY_TBS_DOWNLOAD_V is " + i7);
            if (i7 > 0) {
                if (i4 == 1) {
                    gG.zXl.put("tbs_download_version_type", Integer.valueOf(1));
                } else {
                    gG.zXl.put("tbs_download_version_type", Integer.valueOf(0));
                }
                TbsLog.i("TbsDownload", "put KEY_TBS_DOWNLOAD_V_TYPE is " + i4);
            }
            gG.zXl.put("tbs_downloadurl", string);
            gG.zXl.put("tbs_downloadurl_list", optString);
            gG.zXl.put("tbs_responsecode", Integer.valueOf(i6));
            gG.zXl.put("tbs_download_maxflow", Integer.valueOf(i8));
            gG.zXl.put("tbs_download_min_free_space", Integer.valueOf(i9));
            gG.zXl.put("tbs_download_success_max_retrytimes", Integer.valueOf(i10));
            gG.zXl.put("tbs_download_failed_max_retrytimes", Integer.valueOf(i11));
            gG.zXl.put("tbs_single_timeout", Long.valueOf(j2));
            gG.zXl.put("tbs_apkfilesize", Long.valueOf(j3));
            gG.commit();
            if (obj4 != null) {
                gG.zXl.put("tbs_apk_md5", obj4);
            }
            if (z2 || !t.cEF().ap(bks, i7)) {
                b cEJ;
                if (!z2) {
                    l lVar = zXs;
                    z4 = i6 == 1 || i6 == 2;
                    if (lVar.nP(z4)) {
                        gG.zXl.put("tbs_needdownload", Boolean.valueOf(false));
                        v.hn(bks);
                        cEJ = v.cEJ();
                        cEJ.setErrorCode(100);
                        cEJ.abl("use local backup apk in needDownload" + zXs.zWX);
                        if (o.gG(bks).zXm.getInt("tbs_downloaddecouplecore", 0) == 1) {
                            v.hn(bks).a(v.a.zYi, cEJ);
                        } else {
                            v.hn(bks).a(v.a.zYf, cEJ);
                        }
                    }
                }
                if (o.gG(bks).zXm.getInt("tbs_download_version_type", 0) == 1 && zXs.cEa()) {
                    gG.zXl.put("tbs_needdownload", Boolean.valueOf(false));
                    v.hn(bks);
                    cEJ = v.cEJ();
                    cEJ.setErrorCode(100);
                    cEJ.abl("installDecoupleCoreFromBackup" + zXs.zWX);
                    if (o.gG(bks).zXm.getInt("tbs_downloaddecouplecore", 0) == 1) {
                        v.hn(bks).a(v.a.zYi, cEJ);
                    } else {
                        v.hn(bks).a(v.a.zYf, cEJ);
                    }
                } else {
                    if (!z) {
                        gG.HU(-216);
                    }
                    gG.zXl.put("tbs_needdownload", Boolean.valueOf(true));
                }
            } else {
                if (z) {
                    gG.zXl.put("tbs_download_interrupt_code_reason", Integer.valueOf(-113));
                } else {
                    gG.zXl.put("tbs_download_interrupt_code_reason", Integer.valueOf(-213));
                    gG.HU(-213);
                }
                gG.zXl.put("tbs_needdownload", Boolean.valueOf(false));
            }
            if (jSONObject.optInt("stop_pre_oat", 0) == 1) {
                gG.zXl.put("tbs_stop_preoat", Boolean.valueOf(true));
            }
            gG.commit();
            return true;
        }
        gG.zXl.put("tbs_needdownload", Boolean.valueOf(false));
        gG.commit();
        if (z) {
            x.c(bks, i7, false);
        }
        return false;
    }

    public static boolean cEq() {
        if (x.hq(bks) || o.gG(bks).zXm.getInt("tbs_downloaddecouplecore", 0) == 1) {
            return false;
        }
        if (System.currentTimeMillis() - o.gG(bks).zXm.getLong("last_download_decouple_core", 0) < 1000 * o.gG(bks).cEk()) {
            return false;
        }
        int i = o.gG(bks).zXm.getInt("tbs_decouplecoreversion", 0);
        if (i <= 0) {
            return false;
        }
        t.cEF();
        return (i == t.gX(bks) || o.gG(bks).zXm.getInt("tbs_download_version", 0) == i) ? false : true;
    }

    public static boolean cEr() {
        TbsLog.i("TbsDownload", "startDecoupleCoreIfNeeded ");
        if (x.hq(bks)) {
            return false;
        }
        TbsLog.i("TbsDownload", "startDecoupleCoreIfNeeded #1");
        if (o.gG(bks).zXm.getInt("tbs_downloaddecouplecore", 0) == 1) {
            return false;
        }
        TbsLog.i("TbsDownload", "startDecoupleCoreIfNeeded #2");
        long j = o.gG(bks).zXm.getLong("last_download_decouple_core", 0);
        if (System.currentTimeMillis() - j < 1000 * o.gG(bks).cEk()) {
            return false;
        }
        TbsLog.i("TbsDownload", "startDecoupleCoreIfNeeded #3");
        int i = o.gG(bks).zXm.getInt("tbs_decouplecoreversion", 0);
        if (i > 0) {
            t.cEF();
            if (i != t.gX(bks)) {
                if (o.gG(bks).zXm.getInt("tbs_download_version", 0) != i || o.gG(bks).zXm.getInt("tbs_download_version_type", 0) == 1) {
                    TbsLog.i("TbsDownload", "startDecoupleCoreIfNeeded #4");
                    zXu = true;
                    zXo.removeMessages(108);
                    Message obtain = Message.obtain(zXo, 108, QbSdk.zWf);
                    obtain.arg1 = 0;
                    obtain.sendToTarget();
                    o.gG(bks).zXl.put("last_download_decouple_core", Long.valueOf(System.currentTimeMillis()));
                    return true;
                }
                TbsLog.i("TbsDownload", "startDecoupleCoreIfNeeded no need, KEY_TBS_DOWNLOAD_V is " + o.gG(bks).zXm.getInt("tbs_download_version", 0) + " deCoupleCoreVersion is " + i + " KEY_TBS_DOWNLOAD_V_TYPE is " + o.gG(bks).zXm.getInt("tbs_download_version_type", 0));
                return false;
            }
        }
        StringBuilder append = new StringBuilder("startDecoupleCoreIfNeeded no need, deCoupleCoreVersion is ").append(i).append(" getTbsCoreShareDecoupleCoreVersion is ");
        t.cEF();
        TbsLog.i("TbsDownload", append.append(t.gX(bks)).toString());
        return false;
    }

    public static boolean cEs() {
        if (zXs != null) {
            l lVar = zXs;
            TbsLog.i("TbsDownload", "[TbsApkDownloader.isDownloadForeground] mIsDownloadForeground=" + lVar.zWW);
            if (lVar.zWW) {
                return true;
            }
        }
        return false;
    }

    private static synchronized void cEt() {
        synchronized (p.class) {
            if (zXt == null) {
                zXt = r.cEE();
                try {
                    zXs = new l(bks);
                    zXo = new 1(zXt.getLooper());
                } catch (Exception e) {
                    zXv = true;
                    TbsLog.e("TbsDownload", "TbsApkDownloader init has Exception");
                }
            }
        }
    }

    private static boolean cEu() {
        try {
            return o.gG(bks).zXm.getString("last_thirdapp_sendrequest_coreversion", "").equals(cEv().toString());
        } catch (Exception e) {
            return false;
        }
    }

    private static JSONArray cEv() {
        int i = 0;
        if (!x.hq(bks)) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        Object cER = x.cER();
        String packageName = bks.getApplicationContext().getPackageName();
        if (packageName.equals(x.hs(bks))) {
            Object obj = new String[5];
            System.arraycopy(cER, 0, obj, 0, 4);
            obj[4] = packageName;
        }
        if (x.cEQ() == null) {
            return jSONArray;
        }
        t.cEF();
        int abi = t.abi(x.cEQ());
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            if (jSONArray.optInt(i2) == abi) {
                i = 1;
                break;
            }
        }
        if (i == 0) {
            jSONArray.put(abi);
        }
        return jSONArray;
    }

    public static long cEw() {
        return zXy;
    }

    static String cEx() {
        if (!TextUtils.isEmpty(zXn)) {
            return zXn;
        }
        String str;
        Locale locale = Locale.getDefault();
        StringBuffer stringBuffer = new StringBuffer();
        String str2 = VERSION.RELEASE;
        try {
            str = new String(str2.getBytes("UTF-8"), "ISO8859-1");
        } catch (Exception e) {
            str = str2;
        }
        if (str.length() > 0) {
            stringBuffer.append(str);
        } else {
            stringBuffer.append(BuildConfig.VERSION_NAME);
        }
        stringBuffer.append("; ");
        str = locale.getLanguage();
        if (str != null) {
            stringBuffer.append(str.toLowerCase());
            str = locale.getCountry();
            if (str != null) {
                stringBuffer.append("-");
                stringBuffer.append(str.toLowerCase());
            }
        } else {
            stringBuffer.append("en");
        }
        if ("REL".equals(VERSION.CODENAME)) {
            str2 = Build.MODEL;
            try {
                str = new String(str2.getBytes("UTF-8"), "ISO8859-1");
            } catch (Exception e2) {
                str = str2;
            }
            if (str.length() > 0) {
                stringBuffer.append("; ");
                stringBuffer.append(str);
            }
        }
        str = (Build.ID == null ? "" : Build.ID).replaceAll("[一-龥]", "");
        if (str.length() > 0) {
            stringBuffer.append(" Build/");
            stringBuffer.append(str);
        }
        str = String.format("Mozilla/5.0 (Linux; U; Android %s) AppleWebKit/533.1 (KHTML, like Gecko)Version/4.0 Mobile Safari/533.1", new Object[]{stringBuffer});
        zXn = str;
        return str;
    }

    private static boolean cEy() {
        o gG = o.gG(bks);
        if (gG.zXm.getInt("tbs_download_success_retrytimes", 0) >= gG.cEm()) {
            TbsLog.i("TbsDownload", "[TbsDownloader.needStartDownload] out of success retrytimes", true);
            gG.HU(-115);
            return false;
        } else if (gG.zXm.getInt("tbs_download_failed_retrytimes", 0) >= gG.cEn()) {
            TbsLog.i("TbsDownload", "[TbsDownloader.needStartDownload] out of failed retrytimes", true);
            gG.HU(-116);
            return false;
        } else if (f.hS(bks)) {
            if (System.currentTimeMillis() - gG.zXm.getLong("tbs_downloadstarttime", 0) <= 86400000) {
                long j = gG.zXm.getLong("tbs_downloadflow", 0);
                TbsLog.i("TbsDownload", "[TbsDownloader.needStartDownload] downloadFlow=" + j);
                if (j >= gG.cEj()) {
                    TbsLog.i("TbsDownload", "[TbsDownloader.needStartDownload] failed because you exceeded max flow!", true);
                    gG.HU(-120);
                    return false;
                }
            }
            return true;
        } else {
            TbsLog.i("TbsDownload", "[TbsDownloader.needStartDownload] local rom freespace limit", true);
            gG.HU(-117);
            return false;
        }
    }

    private static JSONArray cEz() {
        JSONArray jSONArray = new JSONArray();
        String[] cER = x.cER();
        for (int i = 0; i < 4; i++) {
            File file = new File(f.a(bks, cER[i], 4, false), gK(bks) ? "x5.oversea.tbs.org" : "x5.tbs.org");
            if (file.exists()) {
                long c = (long) a.c(bks, file);
                if (c > 0) {
                    boolean z;
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        if (((long) jSONArray.optInt(i2)) == c) {
                            z = true;
                            break;
                        }
                    }
                    z = false;
                    if (!z) {
                        jSONArray.put(c);
                    }
                }
            }
        }
        return jSONArray;
    }

    private static boolean d(Context context, boolean z, boolean z2) {
        boolean z3;
        b cEJ;
        o gG = o.gG(context);
        String str = null;
        if (!z) {
            String string = gG.zXm.getString("app_versionname", null);
            int i = gG.zXm.getInt("app_versioncode", 0);
            String string2 = gG.zXm.getString("app_metadata", null);
            String appVersionName = c.getAppVersionName(bks);
            int appVersionCode = c.getAppVersionCode(bks);
            String bO = c.bO(bks, "com.tencent.mm.BuildInfo.CLIENT_VERSION");
            TbsLog.i("TbsDownload", "[TbsDownloader.needSendQueryRequest] appVersionName=" + appVersionName + " oldAppVersionName=" + string + " appVersionCode=" + appVersionCode + " oldAppVersionCode=" + i + " appMetadata=" + bO + " oldAppVersionMetadata=" + string2);
            long currentTimeMillis = System.currentTimeMillis();
            long j = gG.zXm.getLong("last_check", 0);
            TbsLog.i("TbsDownload", "[TbsDownloader.needSendQueryRequest] timeLastCheck=" + j + " timeNow=" + currentTimeMillis);
            if (z2) {
                boolean contains = gG.zXm.contains("last_check");
                TbsLog.i("TbsDownload", "[TbsDownloader.needSendQueryRequest] hasLaskCheckKey=" + contains);
                if (contains && j == 0) {
                    j = currentTimeMillis;
                }
            }
            long cEk = gG.cEk();
            TbsLog.i("TbsDownload", "retryInterval = " + cEk + " s");
            if (currentTimeMillis - j <= cEk * 1000) {
                if (x.hq(bks) && x.cEX() == 0 && !cEu()) {
                    z3 = true;
                    f.T(bks.getDir("tbs", 0));
                    t.zXQ.set(Integer.valueOf(0));
                    v.hn(bks);
                    cEJ = v.cEJ();
                    cEJ.setErrorCode(-119);
                    cEJ.abl(str);
                    v.hn(bks).a(v.a.zYf, cEJ);
                    return z3;
                }
                String str2;
                if (appVersionName == null || appVersionCode == 0 || bO == null) {
                    if (x.hq(bks)) {
                        str2 = "timeNow - timeLastCheck is " + (currentTimeMillis - j) + " TbsShareManager.findCoreForThirdPartyApp(sAppContext) is " + x.cEX() + " sendRequestWithSameHostCoreVersion() is " + cEu() + " appVersionName is " + appVersionName + " appVersionCode is " + appVersionCode + " appMetadata is " + bO + " oldAppVersionName is " + string + " oldAppVersionCode is " + i + " oldAppVersionMetadata is " + string2;
                    }
                    str2 = null;
                } else {
                    if (!(appVersionName.equals(string) && appVersionCode == i && bO.equals(string2))) {
                        z3 = true;
                        if (!z3 && x.hq(bks)) {
                            v.hn(bks);
                            cEJ = v.cEJ();
                            cEJ.setErrorCode(-119);
                            cEJ.abl(str);
                            v.hn(bks).a(v.a.zYf, cEJ);
                        }
                        return z3;
                    }
                    str2 = null;
                }
                str = str2;
                z3 = false;
                v.hn(bks);
                cEJ = v.cEJ();
                cEJ.setErrorCode(-119);
                cEJ.abl(str);
                v.hn(bks).a(v.a.zYf, cEJ);
                return z3;
            }
        }
        z3 = true;
        v.hn(bks);
        cEJ = v.cEJ();
        cEJ.setErrorCode(-119);
        cEJ.abl(str);
        v.hn(bks).a(v.a.zYf, cEJ);
        return z3;
    }

    private static JSONObject e(boolean z, boolean z2, boolean z3) {
        Object simCountryIso;
        JSONObject jSONObject;
        int ha;
        int i;
        JSONArray cEz;
        l lVar;
        File gC;
        boolean z4;
        boolean booleanValue;
        Object obj = null;
        TbsLog.i("TbsDownload", "[TbsDownloader.postJsonData]isQuery: " + z + " forDecoupleCore is " + z3);
        o gG = o.gG(bks);
        String cEx = cEx();
        String hN = c.hN(bks);
        String ab = c.ab(bks);
        String hP = c.hP(bks);
        String str = "";
        String str2 = "";
        String id = TimeZone.getDefault().getID();
        if (id != null) {
            Object obj2 = id;
        } else {
            String str3 = str;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) bks.getSystemService("phone");
            if (telephonyManager != null) {
                simCountryIso = telephonyManager.getSimCountryIso();
                if (simCountryIso == null) {
                    str = str2;
                }
                jSONObject = new JSONObject();
                jSONObject.put("TIMEZONEID", obj2);
                jSONObject.put("COUNTRYISO", simCountryIso);
                jSONObject.put("PROTOCOLVERSION", 1);
                if (x.hq(bks)) {
                    ha = t.cEF().ha(bks);
                    if (ha == 0 && t.cEF().gZ(bks)) {
                        ha = -1;
                    }
                    TbsLog.i("TbsDownload", "[TbsDownloader.postJsonData] tbsLocalVersion=" + ha + " isDownloadForeground=" + z2);
                    if (z2) {
                        i = ha;
                        if (z) {
                            jSONObject.put("FUNCTION", i != 0 ? 0 : 1);
                        } else {
                            jSONObject.put("FUNCTION", 2);
                        }
                        if (x.hq(bks)) {
                            cEz = cEz();
                            if (com.tencent.smtt.utils.b.hL(bks) != 3 && cEz.length() != 0 && i == 0 && z) {
                                jSONObject.put("TBSBACKUPARR", cEz);
                            }
                        } else {
                            cEz = cEv();
                            jSONObject.put("TBSVLARR", cEz);
                            gG.zXl.put("last_thirdapp_sendrequest_coreversion", cEz.toString());
                            gG.commit();
                            if (QbSdk.zVL) {
                                jSONObject.put("THIRDREQ", 1);
                            }
                        }
                        jSONObject.put("APPN", bks.getPackageName());
                        jSONObject.put("APPVN", abh(gG.zXm.getString("app_versionname", null)));
                        jSONObject.put("APPVC", gG.zXm.getInt("app_versioncode", 0));
                        jSONObject.put("APPMETA", abh(gG.zXm.getString("app_metadata", null)));
                        jSONObject.put("TBSSDKV", 43603);
                        jSONObject.put("TBSV", i);
                        jSONObject.put("DOWNLOADDECOUPLECORE", z3 ? 1 : 0);
                        gG.zXl.put("tbs_downloaddecouplecore", Integer.valueOf(z3 ? 1 : 0));
                        gG.commit();
                        if (i != 0) {
                            str3 = "TBSBACKUPV";
                            lVar = zXs;
                            gC = l.gC(lVar.mContext);
                            if (gC != null) {
                                ha = 0;
                            } else {
                                ha = a.c(lVar.mContext, new File(gC, gK(lVar.mContext) ? "x5.oversea.tbs.org" : "x5.tbs.org"));
                            }
                            jSONObject.put(str3, ha);
                        }
                        jSONObject.put("CPU", zXp);
                        jSONObject.put("UA", cEx);
                        jSONObject.put("IMSI", abh(hN));
                        jSONObject.put("IMEI", abh(ab));
                        jSONObject.put("ANDROID_ID", abh(hP));
                        if (!x.hq(bks)) {
                            if (i == 0) {
                                jSONObject.put("STATUS", QbSdk.am(bks, i) ? 0 : 1);
                            } else {
                                jSONObject.put("STATUS", 0);
                            }
                            t.cEF();
                            jSONObject.put("TBSDV", t.gX(bks));
                        }
                        z4 = o.gG(bks).zXm.getBoolean("request_full_package", false);
                        simCountryIso = QbSdk.b(bks, "can_unlzma", null);
                        booleanValue = (simCountryIso == null && (simCountryIso instanceof Boolean)) ? ((Boolean) simCountryIso).booleanValue() : false;
                        if (booleanValue && !z4) {
                            obj = 1;
                        }
                        if (obj != null) {
                            jSONObject.put("REQUEST_LZMA", 1);
                        }
                        if (gK(bks)) {
                            jSONObject.put("OVERSEA", 1);
                        }
                        if (z2) {
                            jSONObject.put("DOWNLOAD_FOREGROUND", 1);
                        }
                        TbsLog.i("TbsDownload", "[TbsDownloader.postJsonData] jsonData=" + jSONObject.toString());
                        return jSONObject;
                    } else if (!t.cEF().gZ(bks)) {
                        ha = 0;
                    }
                } else {
                    ha = QbSdk.zVL ? x.cEW() : o.gG(bks).zXm.getInt("tbs_download_version", 0);
                }
                i = ha;
                if (z) {
                    if (i != 0) {
                    }
                    jSONObject.put("FUNCTION", i != 0 ? 0 : 1);
                } else {
                    jSONObject.put("FUNCTION", 2);
                }
                if (x.hq(bks)) {
                    cEz = cEz();
                    jSONObject.put("TBSBACKUPARR", cEz);
                } else {
                    cEz = cEv();
                    jSONObject.put("TBSVLARR", cEz);
                    gG.zXl.put("last_thirdapp_sendrequest_coreversion", cEz.toString());
                    gG.commit();
                    if (QbSdk.zVL) {
                        jSONObject.put("THIRDREQ", 1);
                    }
                }
                jSONObject.put("APPN", bks.getPackageName());
                jSONObject.put("APPVN", abh(gG.zXm.getString("app_versionname", null)));
                jSONObject.put("APPVC", gG.zXm.getInt("app_versioncode", 0));
                jSONObject.put("APPMETA", abh(gG.zXm.getString("app_metadata", null)));
                jSONObject.put("TBSSDKV", 43603);
                jSONObject.put("TBSV", i);
                if (z3) {
                }
                jSONObject.put("DOWNLOADDECOUPLECORE", z3 ? 1 : 0);
                if (z3) {
                }
                gG.zXl.put("tbs_downloaddecouplecore", Integer.valueOf(z3 ? 1 : 0));
                gG.commit();
                if (i != 0) {
                    str3 = "TBSBACKUPV";
                    lVar = zXs;
                    gC = l.gC(lVar.mContext);
                    if (gC != null) {
                        if (gK(lVar.mContext)) {
                        }
                        ha = a.c(lVar.mContext, new File(gC, gK(lVar.mContext) ? "x5.oversea.tbs.org" : "x5.tbs.org"));
                    } else {
                        ha = 0;
                    }
                    jSONObject.put(str3, ha);
                }
                jSONObject.put("CPU", zXp);
                jSONObject.put("UA", cEx);
                jSONObject.put("IMSI", abh(hN));
                jSONObject.put("IMEI", abh(ab));
                jSONObject.put("ANDROID_ID", abh(hP));
                if (x.hq(bks)) {
                    if (i == 0) {
                        jSONObject.put("STATUS", 0);
                    } else {
                        if (QbSdk.am(bks, i)) {
                        }
                        jSONObject.put("STATUS", QbSdk.am(bks, i) ? 0 : 1);
                    }
                    t.cEF();
                    jSONObject.put("TBSDV", t.gX(bks));
                }
                z4 = o.gG(bks).zXm.getBoolean("request_full_package", false);
                simCountryIso = QbSdk.b(bks, "can_unlzma", null);
                if (simCountryIso == null) {
                }
                obj = 1;
                if (obj != null) {
                    jSONObject.put("REQUEST_LZMA", 1);
                }
                if (gK(bks)) {
                    jSONObject.put("OVERSEA", 1);
                }
                if (z2) {
                    jSONObject.put("DOWNLOAD_FOREGROUND", 1);
                }
                TbsLog.i("TbsDownload", "[TbsDownloader.postJsonData] jsonData=" + jSONObject.toString());
                return jSONObject;
            }
        } catch (Exception e) {
        }
        str = id;
        if (simCountryIso == null) {
            str = str2;
        }
        jSONObject = new JSONObject();
        try {
            jSONObject.put("TIMEZONEID", obj2);
            jSONObject.put("COUNTRYISO", simCountryIso);
            jSONObject.put("PROTOCOLVERSION", 1);
            if (x.hq(bks)) {
                ha = t.cEF().ha(bks);
                ha = -1;
                TbsLog.i("TbsDownload", "[TbsDownloader.postJsonData] tbsLocalVersion=" + ha + " isDownloadForeground=" + z2);
                if (z2) {
                    i = ha;
                    if (z) {
                        jSONObject.put("FUNCTION", 2);
                    } else {
                        if (i != 0) {
                        }
                        jSONObject.put("FUNCTION", i != 0 ? 0 : 1);
                    }
                    if (x.hq(bks)) {
                        cEz = cEv();
                        jSONObject.put("TBSVLARR", cEz);
                        gG.zXl.put("last_thirdapp_sendrequest_coreversion", cEz.toString());
                        gG.commit();
                        if (QbSdk.zVL) {
                            jSONObject.put("THIRDREQ", 1);
                        }
                    } else {
                        cEz = cEz();
                        jSONObject.put("TBSBACKUPARR", cEz);
                    }
                    jSONObject.put("APPN", bks.getPackageName());
                    jSONObject.put("APPVN", abh(gG.zXm.getString("app_versionname", null)));
                    jSONObject.put("APPVC", gG.zXm.getInt("app_versioncode", 0));
                    jSONObject.put("APPMETA", abh(gG.zXm.getString("app_metadata", null)));
                    jSONObject.put("TBSSDKV", 43603);
                    jSONObject.put("TBSV", i);
                    if (z3) {
                    }
                    jSONObject.put("DOWNLOADDECOUPLECORE", z3 ? 1 : 0);
                    if (z3) {
                    }
                    gG.zXl.put("tbs_downloaddecouplecore", Integer.valueOf(z3 ? 1 : 0));
                    gG.commit();
                    if (i != 0) {
                        str3 = "TBSBACKUPV";
                        lVar = zXs;
                        gC = l.gC(lVar.mContext);
                        if (gC != null) {
                            ha = 0;
                        } else {
                            if (gK(lVar.mContext)) {
                            }
                            ha = a.c(lVar.mContext, new File(gC, gK(lVar.mContext) ? "x5.oversea.tbs.org" : "x5.tbs.org"));
                        }
                        jSONObject.put(str3, ha);
                    }
                    jSONObject.put("CPU", zXp);
                    jSONObject.put("UA", cEx);
                    jSONObject.put("IMSI", abh(hN));
                    jSONObject.put("IMEI", abh(ab));
                    jSONObject.put("ANDROID_ID", abh(hP));
                    if (x.hq(bks)) {
                        if (i == 0) {
                            if (QbSdk.am(bks, i)) {
                            }
                            jSONObject.put("STATUS", QbSdk.am(bks, i) ? 0 : 1);
                        } else {
                            jSONObject.put("STATUS", 0);
                        }
                        t.cEF();
                        jSONObject.put("TBSDV", t.gX(bks));
                    }
                    z4 = o.gG(bks).zXm.getBoolean("request_full_package", false);
                    simCountryIso = QbSdk.b(bks, "can_unlzma", null);
                    if (simCountryIso == null) {
                    }
                    obj = 1;
                    if (obj != null) {
                        jSONObject.put("REQUEST_LZMA", 1);
                    }
                    if (gK(bks)) {
                        jSONObject.put("OVERSEA", 1);
                    }
                    if (z2) {
                        jSONObject.put("DOWNLOAD_FOREGROUND", 1);
                    }
                    TbsLog.i("TbsDownload", "[TbsDownloader.postJsonData] jsonData=" + jSONObject.toString());
                    return jSONObject;
                } else if (t.cEF().gZ(bks)) {
                    ha = 0;
                }
            } else if (QbSdk.zVL) {
            }
            i = ha;
            if (z) {
                if (i != 0) {
                }
                jSONObject.put("FUNCTION", i != 0 ? 0 : 1);
            } else {
                jSONObject.put("FUNCTION", 2);
            }
            if (x.hq(bks)) {
                cEz = cEz();
                jSONObject.put("TBSBACKUPARR", cEz);
            } else {
                cEz = cEv();
                jSONObject.put("TBSVLARR", cEz);
                gG.zXl.put("last_thirdapp_sendrequest_coreversion", cEz.toString());
                gG.commit();
                if (QbSdk.zVL) {
                    jSONObject.put("THIRDREQ", 1);
                }
            }
            jSONObject.put("APPN", bks.getPackageName());
            jSONObject.put("APPVN", abh(gG.zXm.getString("app_versionname", null)));
            jSONObject.put("APPVC", gG.zXm.getInt("app_versioncode", 0));
            jSONObject.put("APPMETA", abh(gG.zXm.getString("app_metadata", null)));
            jSONObject.put("TBSSDKV", 43603);
            jSONObject.put("TBSV", i);
            if (z3) {
            }
            jSONObject.put("DOWNLOADDECOUPLECORE", z3 ? 1 : 0);
            if (z3) {
            }
            gG.zXl.put("tbs_downloaddecouplecore", Integer.valueOf(z3 ? 1 : 0));
            gG.commit();
            if (i != 0) {
                str3 = "TBSBACKUPV";
                lVar = zXs;
                gC = l.gC(lVar.mContext);
                if (gC != null) {
                    if (gK(lVar.mContext)) {
                    }
                    ha = a.c(lVar.mContext, new File(gC, gK(lVar.mContext) ? "x5.oversea.tbs.org" : "x5.tbs.org"));
                } else {
                    ha = 0;
                }
                jSONObject.put(str3, ha);
            }
            jSONObject.put("CPU", zXp);
            jSONObject.put("UA", cEx);
            jSONObject.put("IMSI", abh(hN));
            jSONObject.put("IMEI", abh(ab));
            jSONObject.put("ANDROID_ID", abh(hP));
            if (x.hq(bks)) {
                if (i == 0) {
                    jSONObject.put("STATUS", 0);
                } else {
                    if (QbSdk.am(bks, i)) {
                    }
                    jSONObject.put("STATUS", QbSdk.am(bks, i) ? 0 : 1);
                }
                t.cEF();
                jSONObject.put("TBSDV", t.gX(bks));
            }
            z4 = o.gG(bks).zXm.getBoolean("request_full_package", false);
            simCountryIso = QbSdk.b(bks, "can_unlzma", null);
            if (simCountryIso == null) {
            }
            obj = 1;
            if (obj != null) {
                jSONObject.put("REQUEST_LZMA", 1);
            }
            if (gK(bks)) {
                jSONObject.put("OVERSEA", 1);
            }
            if (z2) {
                jSONObject.put("DOWNLOAD_FOREGROUND", 1);
            }
        } catch (Exception e2) {
        }
        TbsLog.i("TbsDownload", "[TbsDownloader.postJsonData] jsonData=" + jSONObject.toString());
        return jSONObject;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean f(boolean z, boolean z2, boolean z3) {
        boolean z4 = false;
        TbsLog.i("TbsDownload", "[TbsDownloader.sendRequest]isQuery: " + z + " forDecoupleCore is " + z3);
        if (t.cEF().gO(bks)) {
            TbsLog.i("TbsDownload", "[TbsDownloader.sendRequest] -- isTbsLocalInstalled!");
        } else {
            JSONObject e;
            int i;
            o gG = o.gG(bks);
            File file = new File(f.ar(bks, 1), gK(bks) ? "x5.oversea.tbs.org" : "x5.tbs.org");
            File file2 = new File(f.ar(bks, 2), gK(bks) ? "x5.oversea.tbs.org" : "x5.tbs.org");
            File file3 = new File(f.ar(bks, 3), gK(bks) ? "x5.oversea.tbs.org" : "x5.tbs.org");
            File file4 = new File(f.ar(bks, 4), gK(bks) ? "x5.oversea.tbs.org" : "x5.tbs.org");
            if (!file4.exists()) {
                if (file3.exists()) {
                    file3.renameTo(file4);
                } else if (file2.exists()) {
                    file2.renameTo(file4);
                } else if (file.exists()) {
                    file.renameTo(file4);
                }
            }
            if (zXp == null) {
                zXp = c.cFm();
                gG.zXl.put("device_cpuabi", zXp);
                gG.commit();
            }
            if (!TextUtils.isEmpty(zXp)) {
                Matcher matcher = null;
                try {
                    matcher = Pattern.compile("i686|mips|x86_64").matcher(zXp);
                } catch (Exception e2) {
                }
                if (matcher != null && matcher.find()) {
                    if (x.hq(bks)) {
                        v.hn(bks);
                        b cEJ = v.cEJ();
                        if (z) {
                            gG.HU(-104);
                            cEJ.setErrorCode(-104);
                        } else {
                            gG.HU(-205);
                            cEJ.setErrorCode(-205);
                        }
                        cEJ.abl("mycpu is " + zXp);
                        v.hn(bks).a(v.a.zYf, cEJ);
                    } else if (z) {
                        gG.HU(-104);
                    } else {
                        gG.HU(-205);
                    }
                    int i2 = 1;
                    e = e(z, z2, z3);
                    i = e.getInt("TBSV");
                    if (!(i2 == 0 && i == -1)) {
                        gG.zXl.put("last_check", Long.valueOf(System.currentTimeMillis()));
                        gG.zXl.put("app_versionname", c.getAppVersionName(bks));
                        gG.zXl.put("app_versioncode", Integer.valueOf(c.getAppVersionCode(bks)));
                        gG.zXl.put("app_metadata", c.bO(bks, "com.tencent.mm.BuildInfo.CLIENT_VERSION"));
                        gG.commit();
                    }
                    if (i != -1) {
                        try {
                            String str = q.hZ(bks).Abj;
                            TbsLog.i("TbsDownload", "[TbsDownloader.sendRequest] postUrl=" + str);
                            z4 = b(g.a(str, e.toString().getBytes(ProtocolPackage.ServerEncoding), new 2(z, gG), false), i, z, z2);
                        } catch (Throwable th) {
                            if (z) {
                                gG.HU(-106);
                            } else {
                                gG.HU(-206);
                            }
                        }
                    }
                }
            }
            boolean z5 = z4;
            e = e(z, z2, z3);
            try {
                i = e.getInt("TBSV");
            } catch (Exception e3) {
                i = -1;
            }
            gG.zXl.put("last_check", Long.valueOf(System.currentTimeMillis()));
            gG.zXl.put("app_versionname", c.getAppVersionName(bks));
            gG.zXl.put("app_versioncode", Integer.valueOf(c.getAppVersionCode(bks)));
            gG.zXl.put("app_metadata", c.bO(bks, "com.tencent.mm.BuildInfo.CLIENT_VERSION"));
            gG.commit();
        }
        return z4;
    }

    public static boolean gH(Context context) {
        return a(context, false, false, null);
    }

    public static void gI(Context context) {
        t(context, false);
    }

    public static int gJ(Context context) {
        t.cEF();
        return t.gX(context);
    }

    public static synchronized boolean gK(Context context) {
        boolean z;
        synchronized (p.class) {
            if (!zXx) {
                zXx = true;
                o gG = o.gG(context);
                if (gG.zXm.contains("is_oversea")) {
                    zXw = gG.zXm.getBoolean("is_oversea", false);
                    TbsLog.i("TbsDownload", "[TbsDownloader.getOverSea]  first called. sOverSea = " + zXw);
                }
                TbsLog.i("TbsDownload", "[TbsDownloader.getOverSea]  sOverSea = " + zXw);
            }
            z = zXw;
        }
        return z;
    }

    @TargetApi(11)
    static void gL(Context context) {
        o gG = o.gG(context);
        try {
            gG.zXl.clear();
            Editor edit = gG.zXm.edit();
            edit.clear();
            edit.commit();
        } catch (Exception e) {
        }
        try {
            edit = v.hn(context).cEO().edit();
            edit.clear();
            edit.commit();
        } catch (Exception e2) {
        }
        l.gE(context);
        (VERSION.SDK_INT >= 11 ? context.getSharedPreferences("tbs_extension_config", 4) : context.getSharedPreferences("tbs_extension_config", 0)).edit().clear().commit();
        (VERSION.SDK_INT >= 11 ? context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4) : context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0)).edit().clear().commit();
    }

    public static synchronized boolean isDownloading() {
        boolean z;
        synchronized (p.class) {
            TbsLog.i("TbsDownload", "[TbsDownloader.isDownloading] is " + zXu);
            z = zXu;
        }
        return z;
    }

    public static boolean s(Context context, boolean z) {
        boolean z2 = true;
        bks = context.getApplicationContext();
        TbsLog.initIfNeed(context);
        if (!a(bks, z, null)) {
            return false;
        }
        int ha = t.cEF().ha(context);
        TbsLog.i("TbsDownload", "[TbsDownloader.needSendRequest] localTbsVersion=" + ha);
        if (ha > 0) {
            return false;
        }
        if (d(bks, false, true)) {
            return true;
        }
        o gG = o.gG(bks);
        boolean contains = gG.zXm.contains("tbs_needdownload");
        TbsLog.i("TbsDownload", "[TbsDownloader.needSendRequest] hasNeedDownloadKey=" + contains);
        boolean z3 = !contains ? true : gG.zXm.getBoolean("tbs_needdownload", false);
        TbsLog.i("TbsDownload", "[TbsDownloader.needSendRequest] needDownload=" + z3);
        if (!(z3 && cEy())) {
            z2 = false;
        }
        TbsLog.i("TbsDownload", "[TbsDownloader.needSendRequest] ret=" + z2);
        return z2;
    }

    public static void stopDownload() {
        if (!zXv) {
            TbsLog.i("TbsDownload", "[TbsDownloader.stopDownload]");
            if (zXs != null) {
                zXs.stopDownload();
            }
            if (zXo != null) {
                zXo.removeMessages(100);
                zXo.removeMessages(101);
                zXo.removeMessages(108);
            }
        }
    }

    public static synchronized void t(Context context, boolean z) {
        int i = 1;
        synchronized (p.class) {
            TbsLog.i("TbsDownload", "[TbsDownloader.startDownload] sAppContext=" + bks);
            if (!t.zXT) {
                zXu = true;
                Context applicationContext = context.getApplicationContext();
                bks = applicationContext;
                o.gG(applicationContext).HU(-200);
                if (VERSION.SDK_INT < 8) {
                    QbSdk.zWf.ly(110);
                    o.gG(bks).HU(-201);
                } else {
                    cEt();
                    if (zXv) {
                        QbSdk.zWf.ly(121);
                        o.gG(bks).HU(-202);
                    } else {
                        if (z) {
                            stopDownload();
                        }
                        zXo.removeMessages(101);
                        zXo.removeMessages(100);
                        Message obtain = Message.obtain(zXo, 101, QbSdk.zWf);
                        if (!z) {
                            i = 0;
                        }
                        obtain.arg1 = i;
                        obtain.sendToTarget();
                    }
                }
            }
        }
    }
}
