package com.tencent.smtt.sdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.ValueCallback;
import android.webkit.WebIconDatabase;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.webkit.WebViewDatabase;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.plugin.appbrand.jsapi.au;
import com.tencent.mm.plugin.appbrand.jsapi.bq;
import com.tencent.mm.plugin.appbrand.jsapi.contact.e;
import com.tencent.mm.plugin.appbrand.jsapi.media.f;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.d;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiGetOpenDeviceId;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.sdk.p.a;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.c;
import com.tencent.smtt.utils.o;
import com.tencent.smtt.utils.t;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.xwalk.core.XWalkUpdater;

@SuppressLint({"NewApi"})
public class QbSdk {
    public static final int EXTENSION_INIT_FAILURE = -99999;
    public static final String LOGIN_TYPE_KEY_PARTNER_CALL_POS = "PosID";
    public static final String LOGIN_TYPE_KEY_PARTNER_ID = "ChannelID";
    public static final String PARAM_KEY_FEATUREID = "param_key_featureid";
    public static final String PARAM_KEY_FUNCTIONID = "param_key_functionid";
    public static final String PARAM_KEY_POSITIONID = "param_key_positionid";
    public static final int QBMODE = 2;
    public static final String SVNVERSION = "jnizz";
    public static final int TBSMODE = 1;
    public static final String TID_QQNumber_Prefix = "QQ:";
    public static final int VERSION = 1;
    public static boolean sIsVersionPrinted = false;
    static long sWifiConnectedTime = 0;
    private static int zVF = 0;
    private static String zVG = "";
    private static Class<?> zVH;
    private static Object zVI;
    static boolean zVJ = false;
    static boolean zVK = false;
    static boolean zVL = true;
    private static boolean zVM = false;
    private static String[] zVN;
    private static String zVO = "NULL";
    private static String zVP = "UNKNOWN";
    static String zVQ;
    static boolean zVR = false;
    static long zVS = 0;
    static Object zVT = new Object();
    static boolean zVU = true;
    private static int zVV = 0;
    private static int zVW = 170;
    private static String zVX = null;
    private static String zVY = null;
    static volatile boolean zVZ = zVJ;
    private static boolean zWa = true;
    private static u zWb = null;
    private static u zWc = null;
    private static boolean zWd = false;
    private static boolean zWe = false;
    static u zWf = new 6();
    static Map<String, Object> zWg = null;

    static boolean am(Context context, int i) {
        if (gy(context)) {
            Object b = o.b(zVI, "isX5Disabled", new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE}, new Object[]{Integer.valueOf(i), Integer.valueOf(43603), Integer.valueOf(HardCoderJNI.sHCENCODEVIDEOTIMEOUT)});
            if (b != null) {
                return ((Boolean) b).booleanValue();
            }
            b = o.b(zVI, "isX5Disabled", new Class[]{Integer.TYPE, Integer.TYPE}, new Object[]{Integer.valueOf(i), Integer.valueOf(43603)});
            if (b != null) {
                return ((Boolean) b).booleanValue();
            }
        }
        return true;
    }

    static Object b(Context context, String str, Bundle bundle) {
        if (!gx(context)) {
            return Integer.valueOf(EXTENSION_INIT_FAILURE);
        }
        Object b = o.b(zVI, "miscCall", new Class[]{String.class, Bundle.class}, new Object[]{str, bundle});
        return b == null ? null : b;
    }

    static synchronized void bG(Context context, String str) {
        synchronized (QbSdk.class) {
            if (!zVJ) {
                zVJ = true;
                zVP = "forceSysWebViewInner: " + str;
                TbsLog.e("QbSdk", "QbSdk.SysWebViewForcedInner..." + zVP);
                m.cEf().a(context, 401, new Throwable(zVP));
            }
        }
    }

    static String cDR() {
        return zVG;
    }

    protected static String cDS() {
        af cFg = af.cFg();
        if (cFg != null && cFg.cFh()) {
            Object invokeStaticMethod = cFg.cFi().zZb.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getGUID", new Class[0], new Object[0]);
            if (invokeStaticMethod != null && (invokeStaticMethod instanceof String)) {
                return (String) invokeStaticMethod;
            }
        }
        return null;
    }

    public static boolean canLoadVideo(Context context) {
        Object b = o.b(zVI, "canLoadVideo", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(0)});
        if (b == null) {
            m.cEf().ao(context, d.CTRL_INDEX);
        } else if (!((Boolean) b).booleanValue()) {
            m.cEf().ao(context, bq.CTRL_INDEX);
        }
        return b == null ? false : ((Boolean) b).booleanValue();
    }

    public static boolean canLoadX5(Context context) {
        return r(context, false);
    }

    public static boolean canLoadX5FirstTimeThirdApp(Context context) {
        try {
            if (zVH == null) {
                t.cEF();
                File hg = t.hg(context);
                if (hg == null) {
                    TbsLog.e("QbSdk", "QbSdk canLoadX5FirstTimeThirdApp (false) optDir == null");
                    return false;
                }
                File file = new File(x.cEU(), "tbs_sdk_extension_dex.jar");
                if (file.exists()) {
                    String cEQ = x.cEQ() != null ? x.cEQ() : hg.getAbsolutePath();
                    TbsLog.i("QbSdk", "QbSdk init optDirExtension #2 is " + cEQ);
                    zVH = new DexLoader(file.getParent(), context, new String[]{file.getAbsolutePath()}, cEQ, null).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
                } else {
                    TbsLog.e("QbSdk", "QbSdk canLoadX5FirstTimeThirdApp (false) dexFile.exists()=false", true);
                    return false;
                }
            }
            if (zVI == null) {
                if (x.cEQ() == null) {
                    v.hn(context.getApplicationContext()).bd(GameJsApiGetOpenDeviceId.CTRL_BYTE, "host context is null!");
                    return false;
                }
                zVH.getConstructor(new Class[]{Context.class, Context.class});
                zVI = zVH.getConstructor(new Class[]{Context.class, Context.class, String.class}).newInstance(new Object[]{context, null, x.cEQ()});
            }
            Object b = o.b(zVI, "canLoadX5CoreForThirdApp", new Class[0], new Object[0]);
            return (b == null || !(b instanceof Boolean)) ? false : ((Boolean) b).booleanValue();
        } catch (Throwable th) {
            TbsLog.e("QbSdk", "canLoadX5FirstTimeThirdApp sys WebView: " + Log.getStackTraceString(th));
            return false;
        }
    }

    public static void canOpenFile(Context context, String str, ab<Boolean> abVar) {
        new 1(context, str, abVar).start();
    }

    public static boolean canOpenMimeFileType(Context context, String str) {
        return !q(context, false) ? false : false;
    }

    public static boolean canOpenWebPlus(Context context) {
        BufferedInputStream bufferedInputStream;
        InputStream fileInputStream;
        Throwable th;
        BufferedInputStream bufferedInputStream2;
        InputStream inputStream = null;
        if (zVV == 0) {
            zVV = a.cDO();
        }
        TbsLog.i("QbSdk", "canOpenWebPlus - totalRAM: " + zVV);
        if (VERSION.SDK_INT < 7 || zVV < zVW || context == null) {
            return false;
        }
        try {
            t.cEF();
            bufferedInputStream = new BufferedInputStream(new FileInputStream(new File(t.hg(context), "tbs.conf")));
            try {
                Properties properties = new Properties();
                properties.load(bufferedInputStream);
                String property = properties.getProperty("android_sdk_max_supported");
                String property2 = properties.getProperty("android_sdk_min_supported");
                int parseInt = Integer.parseInt(property);
                int parseInt2 = Integer.parseInt(property2);
                int parseInt3 = Integer.parseInt(VERSION.SDK);
                if (parseInt3 > parseInt || parseInt3 < parseInt2) {
                    TbsLog.i("QbSdk", "canOpenWebPlus - sdkVersion: " + parseInt3);
                    try {
                        bufferedInputStream.close();
                        return false;
                    } catch (Exception e) {
                        return false;
                    }
                }
                boolean z;
                parseInt = Integer.parseInt(properties.getProperty("tbs_core_version"));
                try {
                    bufferedInputStream.close();
                } catch (Exception e2) {
                }
                try {
                    fileInputStream = new FileInputStream(new File(t.hi(context), "tbs_extension.conf"));
                    try {
                        Properties properties2 = new Properties();
                        properties2.load(fileInputStream);
                        int parseInt4 = Integer.parseInt(properties2.getProperty("tbs_local_version"));
                        parseInt2 = Integer.parseInt(properties2.getProperty("app_versioncode_for_switch"));
                        if (parseInt == 88888888 || parseInt4 == 88888888) {
                            z = false;
                        } else if (parseInt > parseInt4) {
                            z = false;
                        } else if (parseInt == parseInt4) {
                            if (parseInt2 > 0) {
                                if (parseInt2 != c.getAppVersionCode(context)) {
                                    z = false;
                                }
                            }
                            z = Boolean.parseBoolean(properties2.getProperty("x5_disabled")) && !o.gG(context.getApplicationContext()).zXm.getBoolean("switch_backupcore_enable", false);
                        } else {
                            z = false;
                        }
                        try {
                            fileInputStream.close();
                        } catch (Exception e3) {
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileInputStream = null;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw th;
                }
                if (z) {
                }
            } catch (Throwable th4) {
                try {
                    TbsLog.i("QbSdk", "canOpenWebPlus - canLoadX5 Exception");
                    if (bufferedInputStream != null) {
                        return false;
                    }
                    try {
                        bufferedInputStream.close();
                        return false;
                    } catch (Exception e4) {
                        return false;
                    }
                } catch (Throwable th5) {
                    bufferedInputStream2 = bufferedInputStream;
                    th = th5;
                    if (bufferedInputStream2 != null) {
                        try {
                            bufferedInputStream2.close();
                        } catch (Exception e5) {
                        }
                    }
                    throw th;
                }
            }
        } catch (Throwable th6) {
            th = th6;
            if (bufferedInputStream2 != null) {
                bufferedInputStream2.close();
            }
            throw th;
        }
    }

    public static boolean canUseVideoFeatrue(Context context, int i) {
        Object b = o.b(zVI, "canUseVideoFeatrue", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(i)});
        return (b == null || !(b instanceof Boolean)) ? false : ((Boolean) b).booleanValue();
    }

    public static void clear(Context context) {
    }

    public static void clearAllWebViewCache(Context context, boolean z) {
        try {
            WebView webView = new WebView(context);
            if (VERSION.SDK_INT >= 11) {
                webView.removeJavascriptInterface("searchBoxJavaBridge_");
                webView.removeJavascriptInterface("accessibility");
                webView.removeJavascriptInterface("accessibilityTraversal");
            }
            webView.clearCache(true);
            if (z) {
                CookieSyncManager.createInstance(context);
                CookieManager.getInstance().removeAllCookie();
            }
            WebViewDatabase.getInstance(context).clearUsernamePassword();
            WebViewDatabase.getInstance(context).clearHttpAuthUsernamePassword();
            WebViewDatabase.getInstance(context).clearFormData();
            WebStorage.getInstance().deleteAllData();
            WebIconDatabase.getInstance().removeAllIcons();
        } catch (Throwable th) {
            TbsLog.e("QbSdk", "clearAllWebViewCache exception 1 -- " + Log.getStackTraceString(th));
        }
        ag cFi;
        try {
            if (new WebView(context).getWebViewClientExtension() != null) {
                af cFg = af.cFg();
                if (cFg != null && cFg.cFh()) {
                    cFi = cFg.cFi();
                    TbsLog.w("desktop", " tbsWizard clearAllX5Cache");
                    if (z) {
                        cFi.zZb.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "clearAllCache", new Class[]{Context.class}, new Object[]{context});
                        return;
                    }
                    cFi.zZb.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "clearAllCache", new Class[]{Context.class, Boolean.TYPE}, new Object[]{context, Boolean.valueOf(z)});
                }
            }
        } catch (Exception e) {
            cFi.zZb.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearUsernamePassword", new Class[]{Context.class}, new Object[]{context});
            cFi.zZb.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearHttpAuthUsernamePassword", new Class[]{Context.class}, new Object[]{context});
            cFi.zZb.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearFormData", new Class[]{Context.class}, new Object[]{context});
            cFi.zZb.invokeStaticMethod("com.tencent.smtt.webkit.CacheManager", "removeAllCacheFiles", null, new Object[0]);
            cFi.zZb.invokeStaticMethod("com.tencent.smtt.webkit.CacheManager", "clearLocalStorage", null, new Object[0]);
            Object invokeStaticMethod = cFi.zZb.invokeStaticMethod("com.tencent.smtt.net.http.DnsManager", "getInstance", null, new Object[0]);
            if (invokeStaticMethod != null) {
                cFi.zZb.invokeMethod(invokeStaticMethod, "com.tencent.smtt.net.http.DnsManager", "removeAllDns", null, new Object[0]);
            }
            invokeStaticMethod = cFi.zZb.invokeStaticMethod("com.tencent.smtt.webkit.SmttPermanentPermissions", "getInstance", null, new Object[0]);
            if (invokeStaticMethod != null) {
                cFi.zZb.invokeMethod(invokeStaticMethod, "com.tencent.smtt.webkit.SmttPermanentPermissions", "clearAllPermanentPermission", null, new Object[0]);
            }
            cFi.zZb.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "removeAllIcons", null, new Object[0]);
        } catch (Throwable th2) {
        }
    }

    public static void closeFileReader(Context context) {
        af cFg = af.cFg();
        cFg.b(context, null);
        if (cFg.cFh()) {
            cFg.cFi().zZb.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "closeFileReader", new Class[0], new Object[0]);
        }
    }

    public static boolean createMiniQBShortCut(Context context, String str, String str2, Drawable drawable) {
        if (context == null) {
            return false;
        }
        if (p.gK(context)) {
            return false;
        }
        if (isMiniQBShortCutExist(context, str, str2)) {
            return false;
        }
        af cFg = af.cFg();
        if (cFg == null || !cFg.cFh()) {
            return false;
        }
        Bitmap bitmap = null;
        if (drawable instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) drawable).getBitmap();
        }
        DexLoader dexLoader = cFg.cFi().zZb;
        TbsLog.e("QbSdk", "qbsdk createMiniQBShortCut");
        Object invokeStaticMethod = dexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createMiniQBShortCut", new Class[]{Context.class, String.class, String.class, Bitmap.class}, new Object[]{context, str, str2, bitmap});
        TbsLog.e("QbSdk", "qbsdk after createMiniQBShortCut ret: " + invokeStaticMethod);
        return invokeStaticMethod != null;
    }

    public static boolean deleteMiniQBShortCut(Context context, String str, String str2) {
        if (context == null || p.gK(context)) {
            return false;
        }
        af cFg = af.cFg();
        if (cFg == null || !cFg.cFh()) {
            return false;
        }
        return cFg.cFi().zZb.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "deleteMiniQBShortCut", new Class[]{Context.class, String.class, String.class}, new Object[]{context, str, str2}) != null;
    }

    public static void disAllowThirdAppDownload() {
        zVL = false;
    }

    static Bundle e(Context context, Bundle bundle) {
        if (gx(context)) {
            Object b = o.b(zVI, "incrUpdate", new Class[]{Context.class, Bundle.class}, new Object[]{context, bundle});
            if (b != null) {
                return (Bundle) b;
            }
            v.hn(context).bc(f.CTRL_INDEX, "incrUpdate return null!");
            return null;
        }
        v.hn(context).bc(f.CTRL_INDEX, "initForPatch return false!");
        return null;
    }

    public static void fileInfoDetect(Context context, String str, ValueCallback<String> valueCallback) {
        af cFg = af.cFg();
        if (cFg != null && cFg.cFh()) {
            try {
                cFg.cFi().zZb.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "fileInfoDetect", new Class[]{Context.class, String.class, ValueCallback.class}, new Object[]{context, str, valueCallback});
            } catch (Throwable th) {
            }
        }
    }

    public static void forceSysWebView() {
        zVK = true;
        zVO = "SysWebViewForcedByOuter: " + Log.getStackTraceString(new Throwable());
        TbsLog.e("QbSdk", "sys WebView: SysWebViewForcedByOuter");
    }

    public static long getApkFileSize(Context context) {
        return context != null ? o.gG(context.getApplicationContext()).zXm.getLong("tbs_apkfilesize", 0) : 0;
    }

    public static String[] getDexLoaderFileList(Context context, Context context2, String str) {
        int i = 0;
        if (zVN instanceof String[]) {
            int length = zVN.length;
            String[] strArr = new String[length];
            while (i < length) {
                strArr[i] = str + zVN[i];
                i++;
            }
            return strArr;
        }
        Object b = o.b(zVI, "getJarFiles", new Class[]{Context.class, Context.class, String.class}, new Object[]{context, context2, str});
        if (!(b instanceof String[])) {
            b = new String[]{""};
        }
        return (String[]) b;
    }

    public static boolean getDownloadWithoutWifi() {
        return zWd;
    }

    public static boolean getIsSysWebViewForcedByOuter() {
        return zVK;
    }

    public static String getMiniQBVersion(Context context) {
        af cFg = af.cFg();
        cFg.b(context, null);
        if (cFg == null || !cFg.cFh()) {
            return null;
        }
        Object invokeStaticMethod = cFg.cFi().zZb.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getMiniQBVersion", new Class[0], new Object[0]);
        return invokeStaticMethod == null ? null : (String) invokeStaticMethod;
    }

    public static String getQQBuildNumber() {
        return zVY;
    }

    public static boolean getTBSInstalling() {
        return zWe;
    }

    public static String getTID() {
        return zVX;
    }

    public static String getTbsResourcesPath(Context context) {
        return x.getTbsResourcesPath(context);
    }

    public static int getTbsVersion(Context context) {
        if (x.hq(context)) {
            return x.cEW();
        }
        int gY = t.cEF().gY(context);
        if (gY != 0 || n.gF(context).abf("install_status") != 3) {
            return gY;
        }
        reset(context);
        return gY;
    }

    private static boolean gx(Context context) {
        try {
            if (zVH != null) {
                return true;
            }
            t.cEF();
            File hg = t.hg(context);
            if (hg == null) {
                TbsLog.e("QbSdk", "QbSdk initExtension (false) optDir == null");
                return false;
            }
            File file = new File(hg, "tbs_sdk_extension_dex.jar");
            if (file.exists()) {
                Class loadClass = new DexLoader(file.getParent(), context, new String[]{file.getAbsolutePath()}, hg.getAbsolutePath(), null).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
                zVH = loadClass;
                zVI = loadClass.getConstructor(new Class[]{Context.class, Context.class}).newInstance(new Object[]{context, context});
                return true;
            }
            TbsLog.e("QbSdk", "QbSdk initExtension (false) dexFile.exists()=false", true);
            return false;
        } catch (Throwable th) {
            TbsLog.e("QbSdk", "initExtension sys WebView: " + Log.getStackTraceString(th));
            return false;
        }
    }

    private static boolean gy(Context context) {
        try {
            if (zVH != null) {
                return true;
            }
            t.cEF();
            File hg = t.hg(context);
            if (hg == null) {
                TbsLog.e("QbSdk", "QbSdk initForX5DisableConfig (false) optDir == null");
                return false;
            } else if (x.hq(context)) {
                m.cEf().ao(context, 304);
                return false;
            } else {
                t.cEF();
                File file = new File(t.hg(context), "tbs_sdk_extension_dex.jar");
                if (file.exists()) {
                    String cEQ = x.cEQ() != null ? x.cEQ() : hg.getAbsolutePath();
                    TbsLog.i("QbSdk", "QbSdk init optDirExtension #3 is " + cEQ);
                    Class loadClass = new DexLoader(file.getParent(), context, new String[]{file.getAbsolutePath()}, cEQ, null).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
                    zVH = loadClass;
                    Constructor constructor = loadClass.getConstructor(new Class[]{Context.class, Context.class});
                    if (!x.hq(context)) {
                        zVI = constructor.newInstance(new Object[]{context, context});
                    } else if (x.cEQ() == null) {
                        v.hn(context.getApplicationContext()).bd(GameJsApiGetOpenDeviceId.CTRL_BYTE, "host context is null!");
                        return false;
                    } else {
                        zVI = zVH.getConstructor(new Class[]{Context.class, Context.class, String.class}).newInstance(new Object[]{context, null, x.cEQ()});
                    }
                    o.b(zVI, "putInfo", new Class[]{String.class, String.class, String.class, String.class}, new Object[]{c.bjM, c.Aai, c.Aaj, c.bpq});
                    o.b(zVI, "setClientVersion", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(1)});
                    return true;
                }
                m.cEf().a(context, au.CTRL_INDEX, new Exception("initForX5DisableConfig failure -- tbs_sdk_extension_dex.jar is not exist!"));
                return false;
            }
        } catch (Throwable th) {
            TbsLog.e("QbSdk", "initForX5DisableConfig sys WebView: " + Log.getStackTraceString(th));
            return false;
        }
    }

    public static void initBuglyAsync(boolean z) {
        zVU = z;
    }

    public static void initTbsSettings(Map<String, Object> map) {
        if (zWg == null) {
            zWg = map;
            return;
        }
        try {
            zWg.putAll(map);
        } catch (Exception e) {
        }
    }

    public static void initX5Environment(final Context context, final a aVar) {
        if (context != null) {
            zWc = new u() {
                public final void kO(int i) {
                }

                public final void ly(int i) {
                }

                public final void lz(int i) {
                    QbSdk.preInit(context, aVar);
                }
            };
            if (x.hq(context)) {
                t.cEF().x(context, true);
            }
            p.a(context, false, false, new a() {
                public final void g(boolean z, int i) {
                    if (x.cEX() != 0 || x.cET()) {
                        if (QbSdk.zVU && x.hq(context)) {
                            q.cED().gM(context);
                        }
                        QbSdk.preInit(context, aVar);
                        return;
                    }
                    x.z(context, false);
                    if (QbSdk.zVU && x.hq(context)) {
                        q.cED().gM(context);
                    }
                }
            });
        }
    }

    public static boolean installLocalQbApk(Context context, String str, String str2, Bundle bundle) {
        h nO = h.nO(true);
        nO.a(context, null);
        if (nO == null || !nO.zWn) {
            return false;
        }
        Object invokeStaticMethod = nO.cDV().zZb.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "installLocalQbApk", new Class[]{Context.class, String.class, String.class, Bundle.class}, new Object[]{context, str, str2, bundle});
        return invokeStaticMethod == null ? false : ((Boolean) invokeStaticMethod).booleanValue();
    }

    public static boolean intentDispatch(WebView webView, Intent intent, String str, String str2) {
        if (webView == null) {
            return false;
        }
        if (str.startsWith("mttbrowser://miniqb/ch=icon?")) {
            Context context = webView.getContext();
            int indexOf = str.indexOf("url=");
            String substring = indexOf > 0 ? str.substring(indexOf + 4) : null;
            HashMap hashMap = new HashMap();
            Object obj = "unknown";
            try {
                obj = context.getApplicationInfo().packageName;
            } catch (Exception e) {
            }
            hashMap.put(LOGIN_TYPE_KEY_PARTNER_ID, obj);
            hashMap.put(LOGIN_TYPE_KEY_PARTNER_CALL_POS, "14004");
            if (com.tencent.smtt.sdk.a.c.a(context, "miniqb://home".equals(substring) ? "qb://navicard/addCard?cardId=168&cardName=168" : substring, hashMap, "QbSdk.startMiniQBToLoadUrl", null) != 0) {
                af cFg = af.cFg();
                if (cFg != null && cFg.cFh() && cFg.cFi().a(context, substring, null, str2, null) == 0) {
                    return true;
                }
                webView.loadUrl(substring);
            }
        } else {
            webView.loadUrl(str);
        }
        return false;
    }

    public static boolean isMiniQBShortCutExist(Context context, String str, String str2) {
        if (context == null) {
            return false;
        }
        if (p.gK(context)) {
            return false;
        }
        af cFg = af.cFg();
        if (cFg == null || !cFg.cFh()) {
            return false;
        }
        Object invokeStaticMethod = cFg.cFi().zZb.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "isMiniQBShortCutExist", new Class[]{Context.class, String.class}, new Object[]{context, str});
        if (invokeStaticMethod == null) {
            return false;
        }
        return (invokeStaticMethod instanceof Boolean ? (Boolean) invokeStaticMethod : Boolean.valueOf(false)).booleanValue();
    }

    public static boolean isTbsCoreInited() {
        h nO = h.nO(false);
        return nO != null && nO.zWo;
    }

    public static boolean isX5DisabledSync(Context context) {
        if (n.gF(context).abf("install_status") == 2) {
            int i = 1;
        } else {
            boolean z = false;
        }
        if (i != 0) {
            return false;
        }
        if (!gy(context)) {
            return true;
        }
        i = t.cEF().gY(context);
        Object b = o.b(zVI, "isX5DisabledSync", new Class[]{Integer.TYPE, Integer.TYPE}, new Object[]{Integer.valueOf(i), Integer.valueOf(43603)});
        return b != null ? ((Boolean) b).booleanValue() : true;
    }

    public static synchronized void preInit(Context context) {
        synchronized (QbSdk.class) {
            preInit(context, null);
        }
    }

    public static synchronized void preInit(Context context, a aVar) {
        synchronized (QbSdk.class) {
            TbsLog.initIfNeed(context);
            zVZ = zVJ;
            if (!zVM) {
                Thread 3 = new 3(context, new 2(Looper.getMainLooper(), aVar, context));
                3.setName("tbs_preinit");
                3.setPriority(10);
                3.start();
                zVM = true;
            }
        }
    }

    @SuppressLint({"NewApi"})
    private static boolean q(Context context, boolean z) {
        int i;
        Throwable th;
        Editor edit;
        File cEg;
        File hg;
        String absolutePath;
        Class loadClass;
        Constructor constructor;
        int i2 = -1;
        TbsLog.initIfNeed(context);
        if (!sIsVersionPrinted) {
            TbsLog.i("QbSdk", "svn revision: jnizz; SDK_VERSION_CODE: 43603; SDK_VERSION_NAME: 3.6.0.1140");
            sIsVersionPrinted = true;
        }
        if (zVJ && !z) {
            TbsLog.e("QbSdk", "QbSdk init: " + zVP, false);
            m.cEf().a(context, e.CTRL_INDEX, new Throwable(zVP));
            return false;
        } else if (zVK) {
            TbsLog.e("QbSdk", "QbSdk init mIsSysWebViewForcedByOuter = true", true);
            m.cEf().a(context, com.tencent.mm.plugin.appbrand.jsapi.a.e.CTRL_INDEX, new Throwable(zVO));
            return false;
        } else {
            if (!zWa) {
                zWa = true;
                SharedPreferences sharedPreferences;
                int i3;
                int i4;
                try {
                    sharedPreferences = VERSION.SDK_INT >= 11 ? context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4) : context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0);
                    try {
                        i3 = sharedPreferences.getInt("tbs_preload_x5_recorder", -1);
                        if (i3 >= 0) {
                            i3++;
                            if (i3 <= 4) {
                                i = i3;
                            }
                        } else {
                            i = i3;
                            i3 = -1;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        i3 = -1;
                        i4 = -1;
                        TbsLog.e("QbSdk", "tbs_preload_x5_counter Inc exception:" + Log.getStackTraceString(th));
                        i = -1;
                        if (i <= 3) {
                            try {
                                i = sharedPreferences.getInt("tbs_preload_x5_version", -1);
                                edit = sharedPreferences.edit();
                                if (i != i4) {
                                    t.cEF();
                                    com.tencent.smtt.utils.f.e(t.hg(context), false);
                                    n.gF(context);
                                    cEg = n.cEg();
                                    if (cEg != null) {
                                        com.tencent.smtt.utils.f.e(cEg, false);
                                    }
                                    TbsLog.e("QbSdk", "QbSdk - preload_x5_check: tbs core " + i4 + " is deleted!");
                                } else {
                                    TbsLog.e("QbSdk", "QbSdk - preload_x5_check -- reset exception core_ver:" + i4 + "; value:" + i);
                                }
                                edit.putInt("tbs_precheck_disable_version", i);
                                edit.commit();
                            } catch (Throwable th3) {
                                TbsLog.e("QbSdk", "tbs_preload_x5_counter disable version exception:" + Log.getStackTraceString(th3));
                            }
                        } else {
                            TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- before creation!");
                            af.cFg().b(context, null);
                            TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- after creation!");
                            i2 = 0;
                            try {
                                i = sharedPreferences.getInt("tbs_preload_x5_counter", -1);
                                if (i > 0) {
                                    sharedPreferences.edit().putInt("tbs_preload_x5_counter", i - 1).commit();
                                }
                            } catch (Throwable th32) {
                                TbsLog.e("QbSdk", "tbs_preload_x5_counter Dec exception:" + Log.getStackTraceString(th32));
                            }
                            TbsLog.i("QbSdk", "QbSdk -- preload_x5_check result:" + i2);
                        }
                        t.cEF();
                        hg = t.hg(context);
                        if (hg == null) {
                            if (!x.hq(context)) {
                                if (zVF != 0) {
                                    i = 0;
                                } else {
                                    i = t.cEF().b(true, context);
                                    if (zVF != i) {
                                        zVH = null;
                                        zVI = null;
                                        TbsLog.e("QbSdk", "QbSdk init (false) not isThirdPartyApp tbsCoreInstalledVer=" + i, true);
                                        TbsLog.e("QbSdk", "QbSdk init (false) not isThirdPartyApp sTbsVersion=" + zVF, true);
                                        m.cEf().a(context, 303, new Throwable("sTbsVersion: " + zVF + "; tbsCoreInstalledVer: " + i));
                                        return false;
                                    }
                                }
                                zVF = i;
                            }
                            if (zVH != null) {
                                return true;
                            }
                            if (x.hq(context)) {
                                t.cEF();
                                cEg = new File(t.hg(context), "tbs_sdk_extension_dex.jar");
                                if (cEg.exists()) {
                                    try {
                                        TbsLog.e("QbSdk", "QbSdk init (false) tbs_sdk_extension_dex.jar is not exist!");
                                        i = t.cEF().gY(context);
                                        if (new File(cEg.getParentFile(), "tbs_jars_fusion_dex.jar").exists()) {
                                            if (i > 0) {
                                                m.cEf().a(context, 4122, new Exception("tbs_sdk_extension_dex not exist(without fusion dex)!" + i));
                                            } else {
                                                m.cEf().a(context, 4121, new Exception("tbs_sdk_extension_dex not exist(without fusion dex)!" + i));
                                            }
                                        } else if (i > 0) {
                                            m.cEf().a(context, 4132, new Exception("tbs_sdk_extension_dex not exist(with fusion dex)!" + i));
                                        } else {
                                            m.cEf().a(context, 4131, new Exception("tbs_sdk_extension_dex not exist(with fusion dex)!" + i));
                                        }
                                    } catch (Throwable th4) {
                                    }
                                    return false;
                                }
                                absolutePath = x.cEQ() != null ? hg.getAbsolutePath() : x.cEQ();
                                TbsLog.i("QbSdk", "QbSdk init optDirExtension #1 is " + absolutePath);
                                loadClass = new DexLoader(cEg.getParent(), context, new String[]{cEg.getAbsolutePath()}, absolutePath, null).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
                                zVH = loadClass;
                                constructor = loadClass.getConstructor(new Class[]{Context.class, Context.class});
                                if (!x.hq(context)) {
                                    zVI = constructor.newInstance(new Object[]{context, context});
                                } else if (x.cEQ() == null) {
                                    zVI = zVH.getConstructor(new Class[]{Context.class, Context.class, String.class}).newInstance(new Object[]{context, null, x.cEQ()});
                                } else {
                                    v.hn(context.getApplicationContext()).bd(GameJsApiGetOpenDeviceId.CTRL_BYTE, "host context is null!");
                                    return false;
                                }
                                o.b(zVI, "putInfo", new Class[]{String.class, String.class, String.class, String.class}, new Object[]{c.bjM, c.Aai, c.Aaj, c.bpq});
                                o.b(zVI, "setClientVersion", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(1)});
                                return true;
                            }
                            m.cEf().a(context, 304, new Throwable("isShareTbsCoreAvailable false!"));
                            return false;
                        }
                        TbsLog.e("QbSdk", "QbSdk init (false) optDir == null");
                        m.cEf().a(context, 312, new Throwable("QbSdk.init (false) TbsCoreShareDir is null"));
                        return false;
                    }
                    try {
                        i4 = t.cEF().gY(context);
                        if (i4 > 0) {
                            if (i <= 4) {
                                try {
                                    sharedPreferences.edit().putInt("tbs_preload_x5_recorder", i).commit();
                                } catch (Throwable th5) {
                                    th32 = th5;
                                    TbsLog.e("QbSdk", "tbs_preload_x5_counter Inc exception:" + Log.getStackTraceString(th32));
                                    i = -1;
                                    if (i <= 3) {
                                        TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- before creation!");
                                        af.cFg().b(context, null);
                                        TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- after creation!");
                                        i2 = 0;
                                        i = sharedPreferences.getInt("tbs_preload_x5_counter", -1);
                                        if (i > 0) {
                                            sharedPreferences.edit().putInt("tbs_preload_x5_counter", i - 1).commit();
                                        }
                                        TbsLog.i("QbSdk", "QbSdk -- preload_x5_check result:" + i2);
                                    } else {
                                        i = sharedPreferences.getInt("tbs_preload_x5_version", -1);
                                        edit = sharedPreferences.edit();
                                        if (i != i4) {
                                            TbsLog.e("QbSdk", "QbSdk - preload_x5_check -- reset exception core_ver:" + i4 + "; value:" + i);
                                        } else {
                                            t.cEF();
                                            com.tencent.smtt.utils.f.e(t.hg(context), false);
                                            n.gF(context);
                                            cEg = n.cEg();
                                            if (cEg != null) {
                                                com.tencent.smtt.utils.f.e(cEg, false);
                                            }
                                            TbsLog.e("QbSdk", "QbSdk - preload_x5_check: tbs core " + i4 + " is deleted!");
                                        }
                                        edit.putInt("tbs_precheck_disable_version", i);
                                        edit.commit();
                                    }
                                    t.cEF();
                                    hg = t.hg(context);
                                    if (hg == null) {
                                        TbsLog.e("QbSdk", "QbSdk init (false) optDir == null");
                                        m.cEf().a(context, 312, new Throwable("QbSdk.init (false) TbsCoreShareDir is null"));
                                        return false;
                                    }
                                    if (x.hq(context)) {
                                        if (zVF != 0) {
                                            i = t.cEF().b(true, context);
                                            if (zVF != i) {
                                                zVH = null;
                                                zVI = null;
                                                TbsLog.e("QbSdk", "QbSdk init (false) not isThirdPartyApp tbsCoreInstalledVer=" + i, true);
                                                TbsLog.e("QbSdk", "QbSdk init (false) not isThirdPartyApp sTbsVersion=" + zVF, true);
                                                m.cEf().a(context, 303, new Throwable("sTbsVersion: " + zVF + "; tbsCoreInstalledVer: " + i));
                                                return false;
                                            }
                                        }
                                        i = 0;
                                        zVF = i;
                                    }
                                    if (zVH != null) {
                                        return true;
                                    }
                                    if (x.hq(context)) {
                                        m.cEf().a(context, 304, new Throwable("isShareTbsCoreAvailable false!"));
                                        return false;
                                    }
                                    t.cEF();
                                    cEg = new File(t.hg(context), "tbs_sdk_extension_dex.jar");
                                    if (cEg.exists()) {
                                        TbsLog.e("QbSdk", "QbSdk init (false) tbs_sdk_extension_dex.jar is not exist!");
                                        i = t.cEF().gY(context);
                                        if (new File(cEg.getParentFile(), "tbs_jars_fusion_dex.jar").exists()) {
                                            if (i > 0) {
                                                m.cEf().a(context, 4131, new Exception("tbs_sdk_extension_dex not exist(with fusion dex)!" + i));
                                            } else {
                                                m.cEf().a(context, 4132, new Exception("tbs_sdk_extension_dex not exist(with fusion dex)!" + i));
                                            }
                                        } else if (i > 0) {
                                            m.cEf().a(context, 4121, new Exception("tbs_sdk_extension_dex not exist(without fusion dex)!" + i));
                                        } else {
                                            m.cEf().a(context, 4122, new Exception("tbs_sdk_extension_dex not exist(without fusion dex)!" + i));
                                        }
                                        return false;
                                    }
                                    if (x.cEQ() != null) {
                                    }
                                    TbsLog.i("QbSdk", "QbSdk init optDirExtension #1 is " + absolutePath);
                                    loadClass = new DexLoader(cEg.getParent(), context, new String[]{cEg.getAbsolutePath()}, absolutePath, null).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
                                    zVH = loadClass;
                                    constructor = loadClass.getConstructor(new Class[]{Context.class, Context.class});
                                    if (!x.hq(context)) {
                                        zVI = constructor.newInstance(new Object[]{context, context});
                                    } else if (x.cEQ() == null) {
                                        v.hn(context.getApplicationContext()).bd(GameJsApiGetOpenDeviceId.CTRL_BYTE, "host context is null!");
                                        return false;
                                    } else {
                                        zVI = zVH.getConstructor(new Class[]{Context.class, Context.class, String.class}).newInstance(new Object[]{context, null, x.cEQ()});
                                    }
                                    o.b(zVI, "putInfo", new Class[]{String.class, String.class, String.class, String.class}, new Object[]{c.bjM, c.Aai, c.Aaj, c.bpq});
                                    o.b(zVI, "setClientVersion", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(1)});
                                    return true;
                                }
                            }
                            i = sharedPreferences.getInt("tbs_preload_x5_counter", -1);
                            if (i >= 0) {
                                i++;
                                sharedPreferences.edit().putInt("tbs_preload_x5_counter", i).commit();
                                if (i <= 3) {
                                    i = sharedPreferences.getInt("tbs_preload_x5_version", -1);
                                    edit = sharedPreferences.edit();
                                    if (i != i4) {
                                        t.cEF();
                                        com.tencent.smtt.utils.f.e(t.hg(context), false);
                                        n.gF(context);
                                        cEg = n.cEg();
                                        if (cEg != null) {
                                            com.tencent.smtt.utils.f.e(cEg, false);
                                        }
                                        TbsLog.e("QbSdk", "QbSdk - preload_x5_check: tbs core " + i4 + " is deleted!");
                                    } else {
                                        TbsLog.e("QbSdk", "QbSdk - preload_x5_check -- reset exception core_ver:" + i4 + "; value:" + i);
                                    }
                                    edit.putInt("tbs_precheck_disable_version", i);
                                    edit.commit();
                                } else {
                                    if (i3 > 0 && i3 <= 3) {
                                        TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- before creation!");
                                        af.cFg().b(context, null);
                                        TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- after creation!");
                                        i2 = 0;
                                    }
                                    i = sharedPreferences.getInt("tbs_preload_x5_counter", -1);
                                    if (i > 0) {
                                        sharedPreferences.edit().putInt("tbs_preload_x5_counter", i - 1).commit();
                                    }
                                    TbsLog.i("QbSdk", "QbSdk -- preload_x5_check result:" + i2);
                                }
                            }
                            i = -1;
                            if (i <= 3) {
                                TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- before creation!");
                                af.cFg().b(context, null);
                                TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- after creation!");
                                i2 = 0;
                                i = sharedPreferences.getInt("tbs_preload_x5_counter", -1);
                                if (i > 0) {
                                    sharedPreferences.edit().putInt("tbs_preload_x5_counter", i - 1).commit();
                                }
                                TbsLog.i("QbSdk", "QbSdk -- preload_x5_check result:" + i2);
                            } else {
                                i = sharedPreferences.getInt("tbs_preload_x5_version", -1);
                                edit = sharedPreferences.edit();
                                if (i != i4) {
                                    TbsLog.e("QbSdk", "QbSdk - preload_x5_check -- reset exception core_ver:" + i4 + "; value:" + i);
                                } else {
                                    t.cEF();
                                    com.tencent.smtt.utils.f.e(t.hg(context), false);
                                    n.gF(context);
                                    cEg = n.cEg();
                                    if (cEg != null) {
                                        com.tencent.smtt.utils.f.e(cEg, false);
                                    }
                                    TbsLog.e("QbSdk", "QbSdk - preload_x5_check: tbs core " + i4 + " is deleted!");
                                }
                                edit.putInt("tbs_precheck_disable_version", i);
                                edit.commit();
                            }
                        }
                    } catch (Throwable th6) {
                        th32 = th6;
                        i4 = -1;
                        TbsLog.e("QbSdk", "tbs_preload_x5_counter Inc exception:" + Log.getStackTraceString(th32));
                        i = -1;
                        if (i <= 3) {
                            TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- before creation!");
                            af.cFg().b(context, null);
                            TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- after creation!");
                            i2 = 0;
                            i = sharedPreferences.getInt("tbs_preload_x5_counter", -1);
                            if (i > 0) {
                                sharedPreferences.edit().putInt("tbs_preload_x5_counter", i - 1).commit();
                            }
                            TbsLog.i("QbSdk", "QbSdk -- preload_x5_check result:" + i2);
                        } else {
                            i = sharedPreferences.getInt("tbs_preload_x5_version", -1);
                            edit = sharedPreferences.edit();
                            if (i != i4) {
                                TbsLog.e("QbSdk", "QbSdk - preload_x5_check -- reset exception core_ver:" + i4 + "; value:" + i);
                            } else {
                                t.cEF();
                                com.tencent.smtt.utils.f.e(t.hg(context), false);
                                n.gF(context);
                                cEg = n.cEg();
                                if (cEg != null) {
                                    com.tencent.smtt.utils.f.e(cEg, false);
                                }
                                TbsLog.e("QbSdk", "QbSdk - preload_x5_check: tbs core " + i4 + " is deleted!");
                            }
                            edit.putInt("tbs_precheck_disable_version", i);
                            edit.commit();
                        }
                        t.cEF();
                        hg = t.hg(context);
                        if (hg == null) {
                            TbsLog.e("QbSdk", "QbSdk init (false) optDir == null");
                            m.cEf().a(context, 312, new Throwable("QbSdk.init (false) TbsCoreShareDir is null"));
                            return false;
                        }
                        if (x.hq(context)) {
                            if (zVF != 0) {
                                i = t.cEF().b(true, context);
                                if (zVF != i) {
                                    zVH = null;
                                    zVI = null;
                                    TbsLog.e("QbSdk", "QbSdk init (false) not isThirdPartyApp tbsCoreInstalledVer=" + i, true);
                                    TbsLog.e("QbSdk", "QbSdk init (false) not isThirdPartyApp sTbsVersion=" + zVF, true);
                                    m.cEf().a(context, 303, new Throwable("sTbsVersion: " + zVF + "; tbsCoreInstalledVer: " + i));
                                    return false;
                                }
                            }
                            i = 0;
                            zVF = i;
                        }
                        if (zVH != null) {
                            return true;
                        }
                        if (x.hq(context)) {
                            m.cEf().a(context, 304, new Throwable("isShareTbsCoreAvailable false!"));
                            return false;
                        }
                        t.cEF();
                        cEg = new File(t.hg(context), "tbs_sdk_extension_dex.jar");
                        if (cEg.exists()) {
                            TbsLog.e("QbSdk", "QbSdk init (false) tbs_sdk_extension_dex.jar is not exist!");
                            i = t.cEF().gY(context);
                            if (new File(cEg.getParentFile(), "tbs_jars_fusion_dex.jar").exists()) {
                                if (i > 0) {
                                    m.cEf().a(context, 4131, new Exception("tbs_sdk_extension_dex not exist(with fusion dex)!" + i));
                                } else {
                                    m.cEf().a(context, 4132, new Exception("tbs_sdk_extension_dex not exist(with fusion dex)!" + i));
                                }
                            } else if (i > 0) {
                                m.cEf().a(context, 4121, new Exception("tbs_sdk_extension_dex not exist(without fusion dex)!" + i));
                            } else {
                                m.cEf().a(context, 4122, new Exception("tbs_sdk_extension_dex not exist(without fusion dex)!" + i));
                            }
                            return false;
                        }
                        if (x.cEQ() != null) {
                        }
                        TbsLog.i("QbSdk", "QbSdk init optDirExtension #1 is " + absolutePath);
                        loadClass = new DexLoader(cEg.getParent(), context, new String[]{cEg.getAbsolutePath()}, absolutePath, null).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
                        zVH = loadClass;
                        constructor = loadClass.getConstructor(new Class[]{Context.class, Context.class});
                        if (!x.hq(context)) {
                            zVI = constructor.newInstance(new Object[]{context, context});
                        } else if (x.cEQ() == null) {
                            v.hn(context.getApplicationContext()).bd(GameJsApiGetOpenDeviceId.CTRL_BYTE, "host context is null!");
                            return false;
                        } else {
                            zVI = zVH.getConstructor(new Class[]{Context.class, Context.class, String.class}).newInstance(new Object[]{context, null, x.cEQ()});
                        }
                        o.b(zVI, "putInfo", new Class[]{String.class, String.class, String.class, String.class}, new Object[]{c.bjM, c.Aai, c.Aaj, c.bpq});
                        o.b(zVI, "setClientVersion", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(1)});
                        return true;
                    }
                } catch (Throwable th7) {
                    th32 = th7;
                    sharedPreferences = null;
                    i4 = -1;
                    i3 = -1;
                    TbsLog.e("QbSdk", "tbs_preload_x5_counter Inc exception:" + Log.getStackTraceString(th32));
                    i = -1;
                    if (i <= 3) {
                        i = sharedPreferences.getInt("tbs_preload_x5_version", -1);
                        edit = sharedPreferences.edit();
                        if (i != i4) {
                            t.cEF();
                            com.tencent.smtt.utils.f.e(t.hg(context), false);
                            n.gF(context);
                            cEg = n.cEg();
                            if (cEg != null) {
                                com.tencent.smtt.utils.f.e(cEg, false);
                            }
                            TbsLog.e("QbSdk", "QbSdk - preload_x5_check: tbs core " + i4 + " is deleted!");
                        } else {
                            TbsLog.e("QbSdk", "QbSdk - preload_x5_check -- reset exception core_ver:" + i4 + "; value:" + i);
                        }
                        edit.putInt("tbs_precheck_disable_version", i);
                        edit.commit();
                    } else {
                        TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- before creation!");
                        af.cFg().b(context, null);
                        TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- after creation!");
                        i2 = 0;
                        i = sharedPreferences.getInt("tbs_preload_x5_counter", -1);
                        if (i > 0) {
                            sharedPreferences.edit().putInt("tbs_preload_x5_counter", i - 1).commit();
                        }
                        TbsLog.i("QbSdk", "QbSdk -- preload_x5_check result:" + i2);
                    }
                    t.cEF();
                    hg = t.hg(context);
                    if (hg == null) {
                        if (x.hq(context)) {
                            if (zVF != 0) {
                                i = 0;
                            } else {
                                i = t.cEF().b(true, context);
                                if (zVF != i) {
                                    zVH = null;
                                    zVI = null;
                                    TbsLog.e("QbSdk", "QbSdk init (false) not isThirdPartyApp tbsCoreInstalledVer=" + i, true);
                                    TbsLog.e("QbSdk", "QbSdk init (false) not isThirdPartyApp sTbsVersion=" + zVF, true);
                                    m.cEf().a(context, 303, new Throwable("sTbsVersion: " + zVF + "; tbsCoreInstalledVer: " + i));
                                    return false;
                                }
                            }
                            zVF = i;
                        }
                        if (zVH != null) {
                            return true;
                        }
                        if (x.hq(context)) {
                            t.cEF();
                            cEg = new File(t.hg(context), "tbs_sdk_extension_dex.jar");
                            if (cEg.exists()) {
                                if (x.cEQ() != null) {
                                }
                                TbsLog.i("QbSdk", "QbSdk init optDirExtension #1 is " + absolutePath);
                                loadClass = new DexLoader(cEg.getParent(), context, new String[]{cEg.getAbsolutePath()}, absolutePath, null).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
                                zVH = loadClass;
                                constructor = loadClass.getConstructor(new Class[]{Context.class, Context.class});
                                if (!x.hq(context)) {
                                    zVI = constructor.newInstance(new Object[]{context, context});
                                } else if (x.cEQ() == null) {
                                    zVI = zVH.getConstructor(new Class[]{Context.class, Context.class, String.class}).newInstance(new Object[]{context, null, x.cEQ()});
                                } else {
                                    v.hn(context.getApplicationContext()).bd(GameJsApiGetOpenDeviceId.CTRL_BYTE, "host context is null!");
                                    return false;
                                }
                                o.b(zVI, "putInfo", new Class[]{String.class, String.class, String.class, String.class}, new Object[]{c.bjM, c.Aai, c.Aaj, c.bpq});
                                o.b(zVI, "setClientVersion", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(1)});
                                return true;
                            }
                            TbsLog.e("QbSdk", "QbSdk init (false) tbs_sdk_extension_dex.jar is not exist!");
                            i = t.cEF().gY(context);
                            if (new File(cEg.getParentFile(), "tbs_jars_fusion_dex.jar").exists()) {
                                if (i > 0) {
                                    m.cEf().a(context, 4122, new Exception("tbs_sdk_extension_dex not exist(without fusion dex)!" + i));
                                } else {
                                    m.cEf().a(context, 4121, new Exception("tbs_sdk_extension_dex not exist(without fusion dex)!" + i));
                                }
                            } else if (i > 0) {
                                m.cEf().a(context, 4132, new Exception("tbs_sdk_extension_dex not exist(with fusion dex)!" + i));
                            } else {
                                m.cEf().a(context, 4131, new Exception("tbs_sdk_extension_dex not exist(with fusion dex)!" + i));
                            }
                            return false;
                        }
                        m.cEf().a(context, 304, new Throwable("isShareTbsCoreAvailable false!"));
                        return false;
                    }
                    TbsLog.e("QbSdk", "QbSdk init (false) optDir == null");
                    m.cEf().a(context, 312, new Throwable("QbSdk.init (false) TbsCoreShareDir is null"));
                    return false;
                }
            }
            try {
                t.cEF();
                hg = t.hg(context);
                if (hg == null) {
                    TbsLog.e("QbSdk", "QbSdk init (false) optDir == null");
                    m.cEf().a(context, 312, new Throwable("QbSdk.init (false) TbsCoreShareDir is null"));
                    return false;
                }
                if (x.hq(context)) {
                    if (zVF != 0) {
                        i = t.cEF().b(true, context);
                        if (zVF != i) {
                            zVH = null;
                            zVI = null;
                            TbsLog.e("QbSdk", "QbSdk init (false) not isThirdPartyApp tbsCoreInstalledVer=" + i, true);
                            TbsLog.e("QbSdk", "QbSdk init (false) not isThirdPartyApp sTbsVersion=" + zVF, true);
                            m.cEf().a(context, 303, new Throwable("sTbsVersion: " + zVF + "; tbsCoreInstalledVer: " + i));
                            return false;
                        }
                    }
                    i = 0;
                    zVF = i;
                }
                if (zVH != null) {
                    return true;
                }
                if (x.hq(context)) {
                    m.cEf().a(context, 304, new Throwable("isShareTbsCoreAvailable false!"));
                    return false;
                }
                t.cEF();
                cEg = new File(t.hg(context), "tbs_sdk_extension_dex.jar");
                if (cEg.exists()) {
                    TbsLog.e("QbSdk", "QbSdk init (false) tbs_sdk_extension_dex.jar is not exist!");
                    i = t.cEF().gY(context);
                    if (new File(cEg.getParentFile(), "tbs_jars_fusion_dex.jar").exists()) {
                        if (i > 0) {
                            m.cEf().a(context, 4131, new Exception("tbs_sdk_extension_dex not exist(with fusion dex)!" + i));
                        } else {
                            m.cEf().a(context, 4132, new Exception("tbs_sdk_extension_dex not exist(with fusion dex)!" + i));
                        }
                    } else if (i > 0) {
                        m.cEf().a(context, 4121, new Exception("tbs_sdk_extension_dex not exist(without fusion dex)!" + i));
                    } else {
                        m.cEf().a(context, 4122, new Exception("tbs_sdk_extension_dex not exist(without fusion dex)!" + i));
                    }
                    return false;
                }
                if (x.cEQ() != null) {
                }
                TbsLog.i("QbSdk", "QbSdk init optDirExtension #1 is " + absolutePath);
                loadClass = new DexLoader(cEg.getParent(), context, new String[]{cEg.getAbsolutePath()}, absolutePath, null).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
                zVH = loadClass;
                constructor = loadClass.getConstructor(new Class[]{Context.class, Context.class});
                if (!x.hq(context)) {
                    zVI = constructor.newInstance(new Object[]{context, context});
                } else if (x.cEQ() == null) {
                    v.hn(context.getApplicationContext()).bd(GameJsApiGetOpenDeviceId.CTRL_BYTE, "host context is null!");
                    return false;
                } else {
                    zVI = zVH.getConstructor(new Class[]{Context.class, Context.class, String.class}).newInstance(new Object[]{context, null, x.cEQ()});
                }
                o.b(zVI, "putInfo", new Class[]{String.class, String.class, String.class, String.class}, new Object[]{c.bjM, c.Aai, c.Aaj, c.bpq});
                o.b(zVI, "setClientVersion", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(1)});
                return true;
            } catch (Throwable th322) {
                TbsLog.e("QbSdk", "QbSdk init Throwable: " + Log.getStackTraceString(th322));
                m.cEf().a(context, 306, th322);
                return false;
            }
        }
    }

    static boolean r(Context context, boolean z) {
        int i = 1;
        boolean z2 = false;
        if (x.hq(context)) {
            x.cEZ();
            m.cEf().ao(context, HardCoderJNI.SCENE_QUIT_CHATTING);
        } else if (q(context, false)) {
            Object b = o.b(zVI, "canLoadX5Core", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(43603)});
            boolean am;
            if (b == null) {
                b = o.b(zVI, "canLoadX5", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(a.cDO())});
                if (b == null) {
                    m.cEf().ao(context, 308);
                } else if (!((b instanceof String) && ((String) b).equalsIgnoreCase("AuthenticationFail"))) {
                    if (b instanceof Boolean) {
                        zVF = h.cDW();
                        am = am(context, h.cDW());
                        if (((Boolean) b).booleanValue() && !am) {
                            z2 = true;
                        }
                        if (!z2) {
                            TbsLog.e("loaderror", "318");
                            TbsLog.w("loaderror", "isX5Disable:" + am);
                            TbsLog.w("loaderror", "(Boolean) ret:" + ((Boolean) b));
                        }
                    }
                }
            } else if (!((b instanceof String) && ((String) b).equalsIgnoreCase("AuthenticationFail"))) {
                if (b instanceof Bundle) {
                    Bundle bundle = (Bundle) b;
                    if (bundle.isEmpty()) {
                        m.cEf().a(context, 331, new Throwable(String.valueOf(b)));
                        TbsLog.e("loaderror", "empty bundle");
                    } else {
                        int i2;
                        try {
                            i2 = bundle.getInt("result_code", -1);
                        } catch (Exception e) {
                            TbsLog.e("QbSdk", "bundle.getInt(KEY_RESULT_CODE) error : " + e.toString());
                            i2 = -1;
                        }
                        am = i2 == 0;
                        String valueOf;
                        if (x.hq(context)) {
                            h.HR(x.cEV());
                            valueOf = String.valueOf(x.cEV());
                            zVG = valueOf;
                            if (valueOf.length() == 5) {
                                zVG = "0" + zVG;
                            }
                            if (zVG.length() != 6) {
                                zVG = "";
                            }
                        } else {
                            if (VERSION.SDK_INT >= 12) {
                                zVG = bundle.getString("tbs_core_version", "0");
                            } else {
                                valueOf = bundle.getString("tbs_core_version");
                                zVG = valueOf;
                                if (valueOf == null) {
                                    zVG = "0";
                                }
                            }
                            try {
                                zVF = Integer.parseInt(zVG);
                            } catch (NumberFormatException e2) {
                                zVF = 0;
                            }
                            h.HR(zVF);
                            if (zVF == 0) {
                                m.cEf().a(context, 307, new Throwable("sTbsVersion is 0"));
                            } else {
                                if ((zVF <= 0 || zVF > 25442) && zVF != 25472) {
                                    i = 0;
                                }
                                if (i != 0) {
                                    TbsLog.e("TbsDownload", "is_obsolete --> delete old core:" + zVF);
                                    t.cEF();
                                    com.tencent.smtt.utils.f.T(t.hg(context));
                                    m.cEf().a(context, 307, new Throwable("is_obsolete --> delete old core:" + zVF));
                                }
                            }
                        }
                        try {
                            zVN = bundle.getStringArray("tbs_jarfiles");
                            if (zVN instanceof String[]) {
                                zVQ = bundle.getString("tbs_librarypath");
                                b = null;
                                if (i2 != 0) {
                                    try {
                                        b = o.b(zVI, "getErrorCodeForLogReport", new Class[0], new Object[0]);
                                    } catch (Exception e3) {
                                    }
                                }
                                switch (i2) {
                                    case -2:
                                        if (!(b instanceof Integer)) {
                                            m.cEf().a(context, TencentLocation.ERROR_UNKNOWN, new Throwable("detail: " + b));
                                            z2 = am;
                                            break;
                                        }
                                        m.cEf().a(context, ((Integer) b).intValue(), new Throwable("detail: " + b));
                                        z2 = am;
                                        break;
                                    case -1:
                                        if (!(b instanceof Integer)) {
                                            m.cEf().a(context, 307, new Throwable("detail: " + b));
                                            z2 = am;
                                            break;
                                        }
                                        m.cEf().a(context, ((Integer) b).intValue(), new Throwable("detail: " + b));
                                        z2 = am;
                                        break;
                                    case 0:
                                        z2 = am;
                                        break;
                                    default:
                                        m.cEf().a(context, 415, new Throwable("detail: " + b + "errcode" + i2));
                                        z2 = am;
                                        break;
                                }
                            }
                            m.cEf().a(context, 307, new Throwable("sJarFiles not instanceof String[]: " + zVN));
                        } catch (Throwable th) {
                            m.cEf().a(context, 329, th);
                        }
                    }
                } else {
                    m.cEf().a(context, 330, new Throwable(String.valueOf(b)));
                    TbsLog.e("loaderror", "ret not instance of bundle");
                }
            }
            if (!z2) {
                TbsLog.e("loaderror", "319");
            }
        } else {
            TbsLog.e("QbSdk", "QbSdk.init failure!");
        }
        return z2;
    }

    public static void reset(Context context) {
        reset(context, false);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void reset(Context context, boolean z) {
        boolean z2 = true;
        TbsLog.e("QbSdk", "QbSdk reset!", true);
        try {
            p.stopDownload();
            if (z && !x.hq(context)) {
                t.cEF();
                int gX = t.gX(context);
                int gY = t.cEF().gY(context);
                if (gX > 43300) {
                }
            }
            z2 = false;
            p.gL(context);
            com.tencent.smtt.utils.f.e(context.getDir("tbs", 0), "core_share_decouple");
            TbsLog.i("QbSdk", "delete downloaded apk success", true);
            t.zXQ.set(Integer.valueOf(0));
            File file = new File(context.getFilesDir(), "bugly_switch.txt");
            if (file.exists()) {
                file.delete();
            }
            if (z2) {
                t.cEF();
                File hf = t.hf(context);
                t.cEF();
                com.tencent.smtt.utils.f.j(hf, t.hj(context));
                t.cEF();
                t.y(context, true);
                n.gF(context).fF(t.gX(context), 2);
            }
        } catch (Throwable th) {
            TbsLog.e("QbSdk", "QbSdk reset exception:" + Log.getStackTraceString(th));
        }
    }

    public static void resetDecoupleCore(Context context) {
        TbsLog.e("QbSdk", "QbSdk resetDecoupleCore!", true);
        try {
            t.cEF();
            com.tencent.smtt.utils.f.T(t.hf(context));
        } catch (Throwable th) {
            TbsLog.e("QbSdk", "QbSdk resetDecoupleCore exception:" + Log.getStackTraceString(th));
        }
    }

    public static void setCurrentID(String str) {
        if (str != null && str.startsWith(TID_QQNumber_Prefix)) {
            String substring = str.substring(3);
            zVX = "0000000000000000".substring(substring.length()) + substring;
        }
    }

    public static void setDeviceInfo(String str, String str2, String str3, String str4) {
        c.bjM = str;
        c.Aai = str2;
        c.Aaj = str3;
        c.bpq = str4;
    }

    public static void setDownloadWithoutWifi(boolean z) {
        zWd = z;
    }

    public static void setQQBuildNumber(String str) {
        zVY = str;
    }

    public static void setTBSInstallingStatus(boolean z) {
        zWe = z;
    }

    public static void setTbsListener(u uVar) {
        zWb = uVar;
    }

    public static void setTbsLogClient(t tVar) {
        TbsLog.setTbsLogClient(tVar);
    }

    public static int startMiniQBToLoadUrl(Context context, String str, HashMap<String, String> hashMap, ValueCallback<String> valueCallback) {
        m.cEf().ao(context, HardCoderJNI.SCENE_DB);
        if (context == null) {
            return -100;
        }
        af cFg = af.cFg();
        cFg.b(context, null);
        if (!cFg.cFh()) {
            m.cEf().ao(context, 502);
            return -102;
        } else if (context != null && context.getApplicationInfo().packageName.equals("com.nd.android.pandahome2") && getTbsVersion(context) < 25487) {
            return XWalkUpdater.ERROR_SET_VERNUM;
        } else {
            int a = cFg.cFi().a(context, str, hashMap, null, valueCallback);
            if (a == 0) {
                m.cEf().ao(context, 503);
                return a;
            }
            v.hn(context).bd(504, String.valueOf(a));
            return a;
        }
    }

    public static boolean startQBForDoc(Context context, String str, int i, int i2, String str2, Bundle bundle) {
        HashMap hashMap = new HashMap();
        hashMap.put(LOGIN_TYPE_KEY_PARTNER_ID, context.getApplicationContext().getApplicationInfo().processName);
        hashMap.put(LOGIN_TYPE_KEY_PARTNER_CALL_POS, Integer.toString(i));
        return com.tencent.smtt.sdk.a.c.a(context, str, i2, str2, hashMap, bundle);
    }

    public static boolean startQBForVideo(Context context, String str, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put(LOGIN_TYPE_KEY_PARTNER_ID, context.getApplicationInfo().processName);
        hashMap.put(LOGIN_TYPE_KEY_PARTNER_CALL_POS, Integer.toString(i));
        return com.tencent.smtt.sdk.a.c.a(context, str, hashMap);
    }

    public static boolean startQBToLoadurl(Context context, String str, int i, WebView webView) {
        HashMap hashMap = new HashMap();
        hashMap.put(LOGIN_TYPE_KEY_PARTNER_ID, context.getApplicationInfo().processName);
        hashMap.put(LOGIN_TYPE_KEY_PARTNER_CALL_POS, Integer.toString(i));
        if (webView == null) {
            try {
                String str2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
                if (str2 == "com.tencent.mm" || str2 == "com.tencent.mobileqq") {
                    af cFg = af.cFg();
                    if (cFg != null && cFg.cFh()) {
                        Object invokeStaticMethod = cFg.cFi().zZb.invokeStaticMethod("com.tencent.smtt.webkit.WebViewList", "getCurrentMainWebviewJustForQQandWechat", new Class[0], new Object[0]);
                        if (invokeStaticMethod != null) {
                            IX5WebViewBase iX5WebViewBase = (IX5WebViewBase) invokeStaticMethod;
                            if (iX5WebViewBase != null) {
                                webView = (WebView) iX5WebViewBase.getView().getParent();
                            }
                        }
                    }
                }
            } catch (Exception e) {
            }
        }
        return com.tencent.smtt.sdk.a.c.a(context, str, hashMap, "QbSdk.startQBToLoadurl", webView) == 0;
    }

    public static boolean startQbOrMiniQBToLoadUrl(Context context, String str, HashMap<String, String> hashMap, ab<String> abVar) {
        if (context == null) {
            return false;
        }
        af cFg = af.cFg();
        cFg.b(context, null);
        String str2 = "QbSdk.startMiniQBToLoadUrl";
        if (hashMap != null && "5".equals(hashMap.get(LOGIN_TYPE_KEY_PARTNER_CALL_POS)) && cFg.cFh()) {
            cFg.cFi().zZb.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getAdWebViewInfoFromX5Core", new Class[0], new Object[0]);
        }
        if (com.tencent.smtt.sdk.a.c.a(context, str, hashMap, str2, null) == 0) {
            return true;
        }
        if (cFg.cFh()) {
            if (context != null && context.getApplicationInfo().packageName.equals("com.nd.android.pandahome2") && getTbsVersion(context) < 25487) {
                return false;
            }
            if (cFg.cFi().a(context, str, hashMap, null, abVar) == 0) {
                return true;
            }
        }
        return false;
    }

    public static void unForceSysWebView() {
        zVK = false;
        TbsLog.e("QbSdk", "sys WebView: unForceSysWebView called");
    }

    public static boolean useSoftWare() {
        if (zVI == null) {
            return false;
        }
        Object b = o.b(zVI, "useSoftWare", new Class[0], new Object[0]);
        if (b == null) {
            b = o.b(zVI, "useSoftWare", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(a.cDO())});
        }
        return b == null ? false : ((Boolean) b).booleanValue();
    }
}
