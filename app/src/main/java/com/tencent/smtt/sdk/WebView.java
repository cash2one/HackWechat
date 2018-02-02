package com.tencent.smtt.sdk;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Rect;
import android.net.http.SslCertificate;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mm.plugin.appbrand.jsapi.a.e;
import com.tencent.smtt.export.external.TbsCoreSettings;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebSettingsExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase.FindListener;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase.HitTestResult;
import com.tencent.smtt.export.external.interfaces.IX5WebViewClient;
import com.tencent.smtt.sdk.a.b;
import com.tencent.smtt.sdk.a.c;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.f;
import com.tencent.smtt.utils.o;
import com.tencent.smtt.utils.r;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.channels.FileLock;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class WebView extends FrameLayout implements OnLongClickListener {
    public static final int GETPVERROR = -1;
    public static int NIGHT_MODE_ALPHA = 153;
    public static final int NIGHT_MODE_COLOR = -16777216;
    public static final int NORMAL_MODE_ALPHA = 255;
    public static final String SCHEME_GEO = "geo:0,0?q=";
    public static final String SCHEME_MAILTO = "mailto:";
    public static final String SCHEME_TEL = "tel:";
    public static boolean mSysWebviewCreated = false;
    private static Context tI = null;
    private static Paint zZD = null;
    private static boolean zZE = true;
    private static final Lock zZi = new ReentrantLock();
    private static OutputStream zZj = null;
    private static BroadcastReceiver zZs = null;
    private static r zZt = null;
    private static Method zZu = null;
    private static String zZx = null;
    private final String Ef;
    private Context mContext;
    public ae mWebViewCallbackClient;
    private final int zZA;
    private final String zZB;
    private final String zZC;
    private Object zZF;
    boolean zZk;
    IX5WebViewBase zZl;
    SystemWebView zZm;
    private WebSettings zZn;
    int zZo;
    private boolean zZp;
    private s zZq;
    private boolean zZr;
    private WebViewClient zZv;
    private WebChromeClient zZw;
    private final int zZy;
    private final int zZz;
    private OnLongClickListener ztW;

    public WebView(Context context) {
        this(context, null);
    }

    public WebView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WebView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, false);
    }

    @TargetApi(11)
    public WebView(Context context, AttributeSet attributeSet, int i, Map<String, Object> map, boolean z) {
        super(context, attributeSet, i);
        this.Ef = "WebView";
        this.zZk = false;
        this.zZn = null;
        this.mContext = null;
        this.zZo = 0;
        this.zZp = false;
        this.zZq = null;
        this.zZr = false;
        this.zZv = null;
        this.zZw = null;
        this.zZy = 1;
        this.zZz = 2;
        this.zZA = 3;
        this.zZB = "javascript:document.getElementsByTagName('HEAD').item(0).removeChild(document.getElementById('QQBrowserSDKNightMode'));";
        this.zZC = "javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);";
        this.zZF = null;
        this.ztW = null;
        this.zZq = new s();
        this.zZq.b("init_all", (byte) 1);
        if (QbSdk.getIsSysWebViewForcedByOuter() && x.hq(context)) {
            this.mContext = context;
            this.zZl = null;
            this.zZk = false;
            QbSdk.bG(context, "failed to createTBSWebview!");
            this.zZm = new SystemWebView(this, context, attributeSet);
            CookieManager.getInstance().p(context, false);
            CookieSyncManager.createInstance(this.mContext).startSync();
            try {
                Method declaredMethod = Class.forName("android.webkit.WebViewWorker").getDeclaredMethod("getHandler", new Class[0]);
                declaredMethod.setAccessible(true);
                ((Handler) declaredMethod.invoke(null, new Object[0])).getLooper().getThread().setUncaughtExceptionHandler(new SQLiteUncaughtExceptionHandler());
                mSysWebviewCreated = true;
            } catch (Exception e) {
            }
            CookieManager.getInstance().cDN();
            this.zZm.setFocusableInTouchMode(true);
            addView(this.zZm, new LayoutParams(-1, -1));
            TbsLog.i("WebView", "SystemWebView Created Success! #3");
            TbsLog.e("WebView", "sys WebView: IsSysWebViewForcedByOuter = true", true);
            m.cEf().a(context, e.CTRL_INDEX, new Throwable());
            return;
        }
        if (x.hq(context)) {
            TbsLog.setWriteLogJIT(true);
        } else {
            TbsLog.setWriteLogJIT(false);
        }
        this.zZq.b("tbslog_init", (byte) 1);
        TbsLog.initIfNeed(context);
        this.zZq.b("tbslog_init", (byte) 2);
        if (context == null) {
            throw new IllegalArgumentException("Invalid context argument");
        }
        if (zZt == null) {
            zZt = r.ia(context);
        }
        if (zZt.Abn) {
            TbsLog.e("WebView", "sys WebView: debug.conf force syswebview", true);
            QbSdk.bG(context, "debug.conf force syswebview!");
        }
        b(context, this.zZq);
        this.mContext = context;
        if (context != null) {
            tI = context.getApplicationContext();
        }
        if (!this.zZk || QbSdk.zVJ) {
            this.zZl = null;
            if (x.hq(this.mContext)) {
                this.zZm = new SystemWebView(this, context, attributeSet);
            } else {
                this.zZm = new SystemWebView(this, context);
            }
            TbsLog.i("WebView", "SystemWebView Created Success! #2");
            CookieManager.getInstance().p(context, false);
            CookieManager.getInstance().cDN();
            this.zZm.setFocusableInTouchMode(true);
            addView(this.zZm, new LayoutParams(-1, -1));
            setDownloadListener(null);
            hx(context);
            TbsLog.writeLogToDisk();
            t.gN(context);
        } else {
            this.zZq.b("init_x5_webview", (byte) 1);
            this.zZl = af.cFg().zZI.hD(context);
            this.zZq.b("init_x5_webview", (byte) 2);
            if (this.zZl == null || this.zZl.getView() == null) {
                TbsLog.e("WebView", "sys WebView: failed to createTBSWebview", true);
                this.zZl = null;
                this.zZk = false;
                QbSdk.bG(context, "failed to createTBSWebview!");
                b(context, this.zZq);
                if (x.hq(this.mContext)) {
                    this.zZm = new SystemWebView(this, context, attributeSet);
                } else {
                    this.zZm = new SystemWebView(this, context);
                }
                TbsLog.i("WebView", "SystemWebView Created Success! #1");
                CookieManager.getInstance().p(context, false);
                CookieManager.getInstance().cDN();
                this.zZm.setFocusableInTouchMode(true);
                addView(this.zZm, new LayoutParams(-1, -1));
                try {
                    if (VERSION.SDK_INT >= 11) {
                        removeJavascriptInterface("searchBoxJavaBridge_");
                        removeJavascriptInterface("accessibility");
                        removeJavascriptInterface("accessibilityTraversal");
                    }
                } catch (Throwable th) {
                }
                hx(context);
                TbsLog.writeLogToDisk();
                t.gN(context);
                return;
            }
            TbsLog.i("WebView", "X5 WebView Created Success!!");
            this.zZl.getView().setFocusableInTouchMode(true);
            e(attributeSet);
            addView(this.zZl.getView(), new LayoutParams(-1, -1));
            this.zZl.setDownloadListener(new b(this, null));
            IX5WebViewExtension x5WebViewExtension = this.zZl.getX5WebViewExtension();
            Object invokeStaticMethod = af.cFg().zZI.zZb.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createDefaultX5WebChromeClientExtension", new Class[0], new Object[0]);
            x5WebViewExtension.setWebViewClientExtension(new 1(this, invokeStaticMethod == null ? null : (IX5WebViewClientExtension) invokeStaticMethod));
        }
        try {
            if (VERSION.SDK_INT >= 11) {
                removeJavascriptInterface("searchBoxJavaBridge_");
                removeJavascriptInterface("accessibility");
                removeJavascriptInterface("accessibilityTraversal");
            }
        } catch (Throwable th2) {
        }
        if ("com.tencent.mobileqq".equals(this.mContext.getApplicationInfo().packageName) || "com.tencent.mm".equals(this.mContext.getApplicationInfo().packageName)) {
            h.nO(true);
            if (h.useSoftWare() && VERSION.SDK_INT >= 11) {
                setLayerType(1, null);
            }
        }
        if (this.zZq != null) {
            this.zZq.b("init_all", (byte) 2);
        }
        if (this.zZl != null) {
            TbsLog.writeLogToDisk();
            if (!x.hq(context)) {
                int i2 = o.gG(context).zXm.getInt("tbs_decouplecoreversion", 0);
                if (i2 > 0) {
                    t.cEF();
                    if (i2 != t.gX(context) && i2 == t.cEF().gY(context)) {
                        t.cEF().hc(context);
                        return;
                    }
                }
                StringBuilder append = new StringBuilder("webview construction #1 deCoupleCoreVersion is ").append(i2).append(" getTbsCoreShareDecoupleCoreVersion is ");
                t.cEF();
                TbsLog.i("WebView", append.append(t.gX(context)).append(" getTbsCoreInstalledVerInNolock is ").append(t.cEF().gY(context)).toString());
            }
        }
    }

    public WebView(Context context, AttributeSet attributeSet, int i, boolean z) {
        this(context, attributeSet, i, null, z);
    }

    private void b(Context context, s sVar) {
        if (QbSdk.zVU && x.hq(context)) {
            q.cED().gM(context);
        }
        if (sVar != null) {
            sVar.b("x5_core_engine_init_sync", (byte) 1);
        }
        af cFg = af.cFg();
        cFg.b(context, sVar);
        this.zZk = cFg.cFh();
    }

    private static long cFb() {
        long j;
        synchronized (QbSdk.zVT) {
            if (QbSdk.zVR) {
                QbSdk.sWifiConnectedTime += System.currentTimeMillis() - QbSdk.zVS;
                TbsLog.d("sdkreport", "pv report, WebView.getWifiConnectedTime QbSdk.sWifiConnectedTime=" + QbSdk.sWifiConnectedTime);
            }
            j = QbSdk.sWifiConnectedTime / 1000;
            QbSdk.sWifiConnectedTime = 0;
            QbSdk.zVS = System.currentTimeMillis();
        }
        return j;
    }

    static void cFc() {
        new 7().start();
    }

    private boolean dR(View view) {
        if (this.mContext != null && getTbsCoreVersion(this.mContext) > 36200) {
            return false;
        }
        Object b = o.b(this.zZF, "onLongClick", new Class[]{View.class}, new Object[]{view});
        return b != null ? ((Boolean) b).booleanValue() : false;
    }

    @Deprecated
    public static void disablePlatformNotifications() {
        if (!af.cFg().cFh()) {
            o.gd("android.webkit.WebView", "disablePlatformNotifications");
        }
    }

    private void e(AttributeSet attributeSet) {
        if (attributeSet != null) {
            try {
                int attributeCount = attributeSet.getAttributeCount();
                for (int i = 0; i < attributeCount; i++) {
                    if (attributeSet.getAttributeName(i).equalsIgnoreCase("scrollbars")) {
                        int[] intArray = getResources().getIntArray(16842974);
                        int attributeIntValue = attributeSet.getAttributeIntValue(i, -1);
                        if (attributeIntValue == intArray[1]) {
                            this.zZl.getView().setVerticalScrollBarEnabled(false);
                            this.zZl.getView().setHorizontalScrollBarEnabled(false);
                        } else if (attributeIntValue == intArray[2]) {
                            this.zZl.getView().setVerticalScrollBarEnabled(false);
                        } else if (attributeIntValue == intArray[3]) {
                            this.zZl.getView().setHorizontalScrollBarEnabled(false);
                        }
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    @Deprecated
    public static void enablePlatformNotifications() {
        if (!af.cFg().cFh()) {
            o.gd("android.webkit.WebView", "enablePlatformNotifications");
        }
    }

    public static String findAddress(String str) {
        return !af.cFg().cFh() ? android.webkit.WebView.findAddress(str) : null;
    }

    public static String getCrashExtraMessage(Context context) {
        String str = null;
        if (context == null) {
            return "";
        }
        String str2 = "tbs_core_version:" + QbSdk.getTbsVersion(context) + ";tbs_sdk_version:43603" + ";";
        StringBuilder stringBuilder = new StringBuilder();
        h nO = h.nO(true);
        if (nO.zWl == null || QbSdk.zVJ) {
            str = "system webview get nothing...";
        } else {
            aa aaVar = nO.zWl;
            Object invokeStaticMethod = aaVar.zZb.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "invokeStaticMethod", new Class[]{Boolean.TYPE, String.class, String.class, Class[].class, Object[].class}, new Object[]{Boolean.valueOf(true), "com.tencent.smtt.util.CrashTracker", "getCrashExtraInfo", null, new Object[0]});
            if (invokeStaticMethod == null) {
                invokeStaticMethod = aaVar.zZb.invokeStaticMethod("com.tencent.smtt.util.CrashTracker", "getCrashExtraInfo", null, new Object[0]);
            }
            if (invokeStaticMethod != null) {
                str = String.valueOf(invokeStaticMethod) + " ReaderPackName=" + w.zYE + " ReaderPackVersion=" + w.zYF;
            }
            if (str == null) {
                str = "X5 core get nothing...";
            }
        }
        stringBuilder.append(str);
        stringBuilder.append("\n");
        stringBuilder.append(str2);
        if (!x.hq(context) && QbSdk.zWg != null && QbSdk.zWg.containsKey(TbsCoreSettings.TBS_SETTINGS_WEAPP_ID_KEY) && QbSdk.zWg.containsKey(TbsCoreSettings.TBS_SETTINGS_WEAPP_NAME_KEY)) {
            str = "weapp_id:" + QbSdk.zWg.get(TbsCoreSettings.TBS_SETTINGS_WEAPP_ID_KEY) + ";weapp_name:" + QbSdk.zWg.get(TbsCoreSettings.TBS_SETTINGS_WEAPP_NAME_KEY) + ";";
            stringBuilder.append("\n");
            stringBuilder.append(str);
        }
        return stringBuilder.length() > 8192 ? stringBuilder.substring(stringBuilder.length() - 8192) : stringBuilder.toString();
    }

    public static PackageInfo getCurrentWebViewPackage() {
        if (af.cFg().cFh()) {
            return null;
        }
        if (VERSION.SDK_INT < 26) {
            return null;
        }
        try {
            return (PackageInfo) o.gd("android.webkit.WebView", "getCurrentWebViewPackage");
        } catch (Exception e) {
            return null;
        }
    }

    @Deprecated
    public static synchronized Object getPluginList() {
        Object gd;
        synchronized (WebView.class) {
            gd = !af.cFg().cFh() ? o.gd("android.webkit.WebView", "getPluginList") : null;
        }
        return gd;
    }

    public static int getTbsCoreVersion(Context context) {
        return QbSdk.getTbsVersion(context);
    }

    public static boolean getTbsNeedReboot() {
        cFc();
        return h.nO(true).getTbsNeedReboot();
    }

    public static int getTbsSDKVersion(Context context) {
        return 43603;
    }

    static void hA(Context context) {
        String str;
        int hz = hz(context);
        if (hz != -1) {
            str = "PV=" + String.valueOf(hz + 1);
        } else {
            str = "PV=1";
        }
        File file = new File(context.getDir("tbs", 0) + File.separator + "core_private", "pv.db");
        try {
            file.getParentFile().mkdirs();
            if (!(file.isFile() && file.exists())) {
                file.createNewFile();
            }
            OutputStream fileOutputStream = new FileOutputStream(file, false);
            zZj = fileOutputStream;
            fileOutputStream.write(str.getBytes());
            if (zZj != null) {
                zZj.flush();
            }
        } catch (Throwable th) {
        }
    }

    private static void hB(Context context) {
        try {
            File file = new File(context.getDir("tbs", 0) + File.separator + "core_private", "pv.db");
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception e) {
            TbsLog.i("getTbsCorePV", "TbsInstaller--getTbsCorePV Exception=" + e.toString());
        }
    }

    private void hx(Context context) {
        if (zZs == null) {
            zZs = new ConnectivityChangedReceiver(null);
            new 2(this, context).start();
        }
    }

    private static boolean hy(Context context) {
        try {
            if (context.getPackageName().indexOf("com.tencent.mobileqq") >= 0) {
                return true;
            }
        } catch (Throwable th) {
        }
        return false;
    }

    private static int hz(Context context) {
        Exception e;
        Throwable th;
        int i = -1;
        FileOutputStream c = f.c(context, true, "tbslock.txt");
        if (c != null) {
            FileLock a = f.a(c);
            if (a != null) {
                if (zZi.tryLock()) {
                    FileInputStream fileInputStream = null;
                    FileInputStream fileInputStream2;
                    try {
                        File file = new File(context.getDir("tbs", 0) + File.separator + "core_private", "pv.db");
                        if (file.exists()) {
                            Properties properties = new Properties();
                            fileInputStream2 = new FileInputStream(file);
                            try {
                                properties.load(fileInputStream2);
                                fileInputStream2.close();
                                String property = properties.getProperty("PV");
                                if (property == null) {
                                    try {
                                        fileInputStream2.close();
                                    } catch (IOException e2) {
                                        TbsLog.e("getTbsCorePV", "TbsInstaller--getTbsCorePV IOException=" + e2.toString());
                                    }
                                    zZi.unlock();
                                    f.a(a, c);
                                } else {
                                    i = Integer.parseInt(property);
                                    try {
                                        fileInputStream2.close();
                                    } catch (IOException e22) {
                                        TbsLog.e("getTbsCorePV", "TbsInstaller--getTbsCorePV IOException=" + e22.toString());
                                    }
                                    zZi.unlock();
                                    f.a(a, c);
                                }
                            } catch (Exception e3) {
                                e = e3;
                                try {
                                    TbsLog.e("getTbsCorePV", "TbsInstaller--getTbsCorePV Exception=" + e.toString());
                                    if (fileInputStream2 != null) {
                                        try {
                                            fileInputStream2.close();
                                        } catch (IOException e222) {
                                            TbsLog.e("getTbsCorePV", "TbsInstaller--getTbsCorePV IOException=" + e222.toString());
                                        }
                                    }
                                    zZi.unlock();
                                    f.a(a, c);
                                    return i;
                                } catch (Throwable th2) {
                                    th = th2;
                                    fileInputStream = fileInputStream2;
                                    if (fileInputStream != null) {
                                        try {
                                            fileInputStream.close();
                                        } catch (IOException e2222) {
                                            TbsLog.e("getTbsCorePV", "TbsInstaller--getTbsCorePV IOException=" + e2222.toString());
                                        }
                                    }
                                    zZi.unlock();
                                    f.a(a, c);
                                    throw th;
                                }
                            }
                        }
                        zZi.unlock();
                        f.a(a, c);
                    } catch (Exception e4) {
                        e = e4;
                        fileInputStream2 = null;
                        TbsLog.e("getTbsCorePV", "TbsInstaller--getTbsCorePV Exception=" + e.toString());
                        if (fileInputStream2 != null) {
                            fileInputStream2.close();
                        }
                        zZi.unlock();
                        f.a(a, c);
                        return i;
                    } catch (Throwable th3) {
                        th = th3;
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        zZi.unlock();
                        f.a(a, c);
                        throw th;
                    }
                }
                f.a(a, c);
            }
        }
        return i;
    }

    public static synchronized void setSysDayOrNight(boolean z) {
        synchronized (WebView.class) {
            if (z != zZE) {
                zZE = z;
                if (zZD == null) {
                    Paint paint = new Paint();
                    zZD = paint;
                    paint.setColor(NIGHT_MODE_COLOR);
                }
                if (z) {
                    if (zZD.getAlpha() != 255) {
                        zZD.setAlpha(255);
                    }
                } else if (zZD.getAlpha() != NIGHT_MODE_ALPHA) {
                    zZD.setAlpha(NIGHT_MODE_ALPHA);
                }
            }
        }
    }

    public static void setWebContentsDebuggingEnabled(boolean z) {
        af cFg = af.cFg();
        if (cFg != null && cFg.cFh()) {
            cFg.cFi().zZb.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webview_setWebContentsDebuggingEnabled", new Class[]{Boolean.TYPE}, new Object[]{Boolean.valueOf(z)});
        } else if (VERSION.SDK_INT >= 19) {
            try {
                Method declaredMethod = Class.forName("android.webkit.WebView").getDeclaredMethod("setWebContentsDebuggingEnabled", new Class[]{Boolean.TYPE});
                zZu = declaredMethod;
                if (declaredMethod != null) {
                    zZu.setAccessible(true);
                    zZu.invoke(null, new Object[]{Boolean.valueOf(z)});
                }
            } catch (Exception e) {
                TbsLog.e("QbSdk", "Exception:" + e.getStackTrace());
            }
        }
    }

    public void addJavascriptInterface(Object obj, String str) {
        if (this.zZk) {
            this.zZl.addJavascriptInterface(obj, str);
        } else {
            this.zZm.addJavascriptInterface(obj, str);
        }
    }

    public void addView(View view) {
        if (this.zZk) {
            View view2 = this.zZl.getView();
            try {
                Method c = o.c(view2, "addView", new Class[]{View.class});
                c.setAccessible(true);
                c.invoke(view2, new Object[]{view});
                return;
            } catch (Throwable th) {
                return;
            }
        }
        this.zZm.addView(view);
    }

    public boolean canGoBack() {
        return !this.zZk ? this.zZm.canGoBack() : this.zZl.canGoBack();
    }

    public boolean canGoBackOrForward(int i) {
        return !this.zZk ? this.zZm.canGoBackOrForward(i) : this.zZl.canGoBackOrForward(i);
    }

    public boolean canGoForward() {
        return !this.zZk ? this.zZm.canGoForward() : this.zZl.canGoForward();
    }

    @Deprecated
    public boolean canZoomIn() {
        if (this.zZk) {
            return this.zZl.canZoomIn();
        }
        if (VERSION.SDK_INT < 11) {
            return false;
        }
        Object f = o.f(this.zZm, "canZoomIn");
        return f == null ? false : ((Boolean) f).booleanValue();
    }

    @Deprecated
    public boolean canZoomOut() {
        if (this.zZk) {
            return this.zZl.canZoomOut();
        }
        if (VERSION.SDK_INT < 11) {
            return false;
        }
        Object f = o.f(this.zZm, "canZoomOut");
        return f == null ? false : ((Boolean) f).booleanValue();
    }

    @Deprecated
    public Picture capturePicture() {
        if (this.zZk) {
            return this.zZl.capturePicture();
        }
        Object f = o.f(this.zZm, "capturePicture");
        return f == null ? null : (Picture) f;
    }

    public void clearCache(boolean z) {
        if (this.zZk) {
            this.zZl.clearCache(z);
        } else {
            this.zZm.clearCache(z);
        }
    }

    public void clearFormData() {
        if (this.zZk) {
            this.zZl.clearFormData();
        } else {
            this.zZm.clearFormData();
        }
    }

    public void clearHistory() {
        if (this.zZk) {
            this.zZl.clearHistory();
        } else {
            this.zZm.clearHistory();
        }
    }

    @TargetApi(3)
    public void clearMatches() {
        if (this.zZk) {
            this.zZl.clearMatches();
        } else {
            this.zZm.clearMatches();
        }
    }

    public void clearSslPreferences() {
        if (this.zZk) {
            this.zZl.clearSslPreferences();
        } else {
            this.zZm.clearSslPreferences();
        }
    }

    @Deprecated
    public void clearView() {
        if (this.zZk) {
            this.zZl.clearView();
        } else {
            o.f(this.zZm, "clearView");
        }
    }

    public int computeHorizontalScrollExtent() {
        try {
            Method c;
            if (this.zZk) {
                c = o.c(this.zZl.getView(), "computeHorizontalScrollExtent", new Class[0]);
                c.setAccessible(true);
                return ((Integer) c.invoke(this.zZl.getView(), null)).intValue();
            }
            c = o.c(this.zZm, "computeHorizontalScrollExtent", new Class[0]);
            c.setAccessible(true);
            return ((Integer) c.invoke(this.zZm, null)).intValue();
        } catch (Exception e) {
            return -1;
        }
    }

    public int computeHorizontalScrollOffset() {
        try {
            Method c;
            if (this.zZk) {
                c = o.c(this.zZl.getView(), "computeHorizontalScrollOffset", new Class[0]);
                c.setAccessible(true);
                return ((Integer) c.invoke(this.zZl.getView(), null)).intValue();
            }
            c = o.c(this.zZm, "computeHorizontalScrollOffset", new Class[0]);
            c.setAccessible(true);
            return ((Integer) c.invoke(this.zZm, null)).intValue();
        } catch (Exception e) {
            return -1;
        }
    }

    public int computeHorizontalScrollRange() {
        try {
            if (this.zZk) {
                return ((Integer) o.b(this.zZl.getView(), "computeHorizontalScrollRange", new Class[0], new Object[0])).intValue();
            }
            Method c = o.c(this.zZm, "computeHorizontalScrollRange", new Class[0]);
            c.setAccessible(true);
            return ((Integer) c.invoke(this.zZm, null)).intValue();
        } catch (Exception e) {
            return -1;
        }
    }

    public void computeScroll() {
        if (this.zZk) {
            this.zZl.computeScroll();
        } else {
            this.zZm.computeScroll();
        }
    }

    public int computeVerticalScrollExtent() {
        try {
            Method c;
            if (this.zZk) {
                c = o.c(this.zZl.getView(), "computeVerticalScrollExtent", new Class[0]);
                c.setAccessible(true);
                return ((Integer) c.invoke(this.zZl.getView(), null)).intValue();
            }
            c = o.c(this.zZm, "computeVerticalScrollExtent", new Class[0]);
            c.setAccessible(true);
            return ((Integer) c.invoke(this.zZm, null)).intValue();
        } catch (Exception e) {
            return -1;
        }
    }

    public int computeVerticalScrollOffset() {
        try {
            Method c;
            if (this.zZk) {
                c = o.c(this.zZl.getView(), "computeVerticalScrollOffset", new Class[0]);
                c.setAccessible(true);
                return ((Integer) c.invoke(this.zZl.getView(), null)).intValue();
            }
            c = o.c(this.zZm, "computeVerticalScrollOffset", new Class[0]);
            c.setAccessible(true);
            return ((Integer) c.invoke(this.zZm, null)).intValue();
        } catch (Exception e) {
            return -1;
        }
    }

    public int computeVerticalScrollRange() {
        try {
            if (this.zZk) {
                return ((Integer) o.b(this.zZl.getView(), "computeVerticalScrollRange", new Class[0], new Object[0])).intValue();
            }
            Method c = o.c(this.zZm, "computeVerticalScrollRange", new Class[0]);
            c.setAccessible(true);
            return ((Integer) c.invoke(this.zZm, null)).intValue();
        } catch (Exception e) {
            return -1;
        }
    }

    public WebBackForwardList copyBackForwardList() {
        return this.zZk ? WebBackForwardList.a(this.zZl.copyBackForwardList()) : WebBackForwardList.a(this.zZm.copyBackForwardList());
    }

    public Object createPrintDocumentAdapter(String str) {
        Object obj = null;
        if (this.zZk) {
            try {
                return this.zZl.createPrintDocumentAdapter(str);
            } catch (Throwable th) {
                return obj;
            }
        } else if (VERSION.SDK_INT < 21) {
            return obj;
        } else {
            return o.b(this.zZm, "createPrintDocumentAdapter", new Class[]{String.class}, new Object[]{str});
        }
    }

    public void customDiskCachePathEnabled(boolean z, String str) {
        if (this.zZk && getX5WebViewExtension() != null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("enabled", z);
            bundle.putString("path", str);
            getX5WebViewExtension().invokeMiscMethod("customDiskCachePathEnabled", bundle);
        }
    }

    public void destroy() {
        if (!(this.zZp || this.zZo == 0)) {
            this.zZp = true;
            String str = "";
            String str2 = "";
            String str3 = "";
            if (this.zZk) {
                Bundle sdkQBStatisticsInfo = this.zZl.getX5WebViewExtension().getSdkQBStatisticsInfo();
                if (sdkQBStatisticsInfo != null) {
                    str = sdkQBStatisticsInfo.getString("guid");
                    str2 = sdkQBStatisticsInfo.getString("qua2");
                    str3 = sdkQBStatisticsInfo.getString("lc");
                }
            }
            if ("com.qzone".equals(this.mContext.getApplicationInfo().packageName)) {
                int hz = hz(this.mContext);
                if (hz == -1) {
                    hz = this.zZo;
                }
                this.zZo = hz;
                hB(this.mContext);
            }
            b.a(this.mContext, str, str2, str3, this.zZo, this.zZk, cFb());
            this.zZo = 0;
            this.zZp = false;
        }
        if (this.zZk) {
            this.zZl.destroy();
        } else {
            Object invoke;
            Field declaredField;
            try {
                Class cls = Class.forName("android.webkit.WebViewClassic");
                Method method = cls.getMethod("fromWebView", new Class[]{android.webkit.WebView.class});
                method.setAccessible(true);
                invoke = method.invoke(null, new Object[]{this.zZm});
                if (invoke != null) {
                    Field declaredField2 = cls.getDeclaredField("mListBoxDialog");
                    declaredField2.setAccessible(true);
                    Object obj = declaredField2.get(invoke);
                    if (obj != null) {
                        Dialog dialog = (Dialog) obj;
                        dialog.setOnCancelListener(null);
                        Class cls2 = Class.forName("android.app.Dialog");
                        declaredField = cls2.getDeclaredField("CANCEL");
                        declaredField.setAccessible(true);
                        int intValue = ((Integer) declaredField.get(dialog)).intValue();
                        Field declaredField3 = cls2.getDeclaredField("mListenersHandler");
                        declaredField3.setAccessible(true);
                        ((Handler) declaredField3.get(dialog)).removeMessages(intValue);
                    }
                }
            } catch (Exception e) {
            }
            this.zZm.destroy();
            try {
                declaredField = Class.forName("android.webkit.BrowserFrame").getDeclaredField("sConfigCallback");
                declaredField.setAccessible(true);
                ComponentCallbacks componentCallbacks = (ComponentCallbacks) declaredField.get(null);
                if (componentCallbacks != null) {
                    declaredField.set(null, null);
                    declaredField = Class.forName("android.view.ViewRoot").getDeclaredField("sConfigCallbacks");
                    declaredField.setAccessible(true);
                    invoke = declaredField.get(null);
                    if (invoke != null) {
                        List list = (List) invoke;
                        synchronized (list) {
                            list.remove(componentCallbacks);
                        }
                    }
                }
            } catch (Exception e2) {
            }
        }
        TbsLog.i("WebView", "X5 GUID = " + QbSdk.cDS());
    }

    public void documentHasImages(Message message) {
        if (this.zZk) {
            this.zZl.documentHasImages(message);
        } else {
            this.zZm.documentHasImages(message);
        }
    }

    public void dumpViewHierarchyWithProperties(BufferedWriter bufferedWriter, int i) {
        if (this.zZk) {
            this.zZl.dumpViewHierarchyWithProperties(bufferedWriter, i);
            return;
        }
        o.b(this.zZm, "dumpViewHierarchyWithProperties", new Class[]{BufferedWriter.class, Integer.TYPE}, new Object[]{bufferedWriter, Integer.valueOf(i)});
    }

    public void evaluateJavascript(String str, ab<String> abVar) {
        Method c;
        if (this.zZk) {
            try {
                c = o.c(this.zZl.getView(), "evaluateJavascript", new Class[]{String.class, ValueCallback.class});
                c.setAccessible(true);
                c.invoke(this.zZl.getView(), new Object[]{str, abVar});
            } catch (Exception e) {
                loadUrl(str);
            }
        } else if (VERSION.SDK_INT >= 19) {
            try {
                c = Class.forName("android.webkit.WebView").getDeclaredMethod("evaluateJavascript", new Class[]{String.class, ValueCallback.class});
                c.setAccessible(true);
                c.invoke(this.zZm, new Object[]{str, abVar});
            } catch (Exception e2) {
            }
        }
    }

    @Deprecated
    public int findAll(String str) {
        if (this.zZk) {
            return this.zZl.findAll(str);
        }
        Object b = o.b(this.zZm, "findAll", new Class[]{String.class}, new Object[]{str});
        return b == null ? 0 : ((Integer) b).intValue();
    }

    @TargetApi(16)
    public void findAllAsync(String str) {
        if (this.zZk) {
            this.zZl.findAllAsync(str);
        } else if (VERSION.SDK_INT >= 16) {
            o.b(this.zZm, "findAllAsync", new Class[]{String.class}, new Object[]{str});
        }
    }

    public View findHierarchyView(String str, int i) {
        if (this.zZk) {
            return this.zZl.findHierarchyView(str, i);
        }
        return (View) o.b(this.zZm, "findHierarchyView", new Class[]{String.class, Integer.TYPE}, new Object[]{str, Integer.valueOf(i)});
    }

    @TargetApi(3)
    public void findNext(boolean z) {
        if (this.zZk) {
            this.zZl.findNext(z);
        } else {
            this.zZm.findNext(z);
        }
    }

    public void flingScroll(int i, int i2) {
        if (this.zZk) {
            this.zZl.flingScroll(i, i2);
        } else {
            this.zZm.flingScroll(i, i2);
        }
    }

    @Deprecated
    public void freeMemory() {
        if (this.zZk) {
            this.zZl.freeMemory();
        } else {
            o.f(this.zZm, "freeMemory");
        }
    }

    public SslCertificate getCertificate() {
        return !this.zZk ? this.zZm.getCertificate() : this.zZl.getCertificate();
    }

    public int getContentHeight() {
        return !this.zZk ? this.zZm.getContentHeight() : this.zZl.getContentHeight();
    }

    public int getContentWidth() {
        if (this.zZk) {
            return this.zZl.getContentWidth();
        }
        Object f = o.f(this.zZm, "getContentWidth");
        return f == null ? 0 : ((Integer) f).intValue();
    }

    public Bitmap getFavicon() {
        return !this.zZk ? this.zZm.getFavicon() : this.zZl.getFavicon();
    }

    public HitTestResult getHitTestResult() {
        return !this.zZk ? new HitTestResult(this.zZm.getHitTestResult()) : new HitTestResult(this.zZl.getHitTestResult());
    }

    public String[] getHttpAuthUsernamePassword(String str, String str2) {
        return !this.zZk ? this.zZm.getHttpAuthUsernamePassword(str, str2) : this.zZl.getHttpAuthUsernamePassword(str, str2);
    }

    @TargetApi(3)
    public String getOriginalUrl() {
        return !this.zZk ? this.zZm.getOriginalUrl() : this.zZl.getOriginalUrl();
    }

    public int getProgress() {
        return !this.zZk ? this.zZm.getProgress() : this.zZl.getProgress();
    }

    public boolean getRendererPriorityWaivedWhenNotVisible() {
        try {
            if (this.zZk) {
                return false;
            }
            if (VERSION.SDK_INT < 26) {
                return false;
            }
            Object f = o.f(this.zZm, "getRendererPriorityWaivedWhenNotVisible");
            return f == null ? false : ((Boolean) f).booleanValue();
        } catch (Exception e) {
            return false;
        }
    }

    public int getRendererRequestedPriority() {
        try {
            if (this.zZk) {
                return 0;
            }
            if (VERSION.SDK_INT < 26) {
                return 0;
            }
            Object f = o.f(this.zZm, "getRendererRequestedPriority");
            return f == null ? 0 : ((Integer) f).intValue();
        } catch (Exception e) {
            return 0;
        }
    }

    @Deprecated
    public float getScale() {
        if (this.zZk) {
            return this.zZl.getScale();
        }
        Object f = o.f(this.zZm, "getScale");
        return f == null ? 0.0f : ((Float) f).floatValue();
    }

    public int getScrollBarDefaultDelayBeforeFade() {
        return getView() == null ? 0 : getView().getScrollBarDefaultDelayBeforeFade();
    }

    public int getScrollBarFadeDuration() {
        return getView() == null ? 0 : getView().getScrollBarFadeDuration();
    }

    public int getScrollBarSize() {
        return getView() == null ? 0 : getView().getScrollBarSize();
    }

    public int getScrollBarStyle() {
        return getView() == null ? 0 : getView().getScrollBarStyle();
    }

    public WebSettings getSettings() {
        if (this.zZn != null) {
            return this.zZn;
        }
        if (this.zZk) {
            WebSettings webSettings = new WebSettings(this.zZl.getSettings());
            this.zZn = webSettings;
            return webSettings;
        }
        webSettings = new WebSettings(this.zZm.getSettings());
        this.zZn = webSettings;
        return webSettings;
    }

    public IX5WebSettingsExtension getSettingsExtension() {
        return !this.zZk ? null : this.zZl.getX5WebViewExtension().getSettingsExtension();
    }

    public int getSysNightModeAlpha() {
        return NIGHT_MODE_ALPHA;
    }

    public String getTitle() {
        return !this.zZk ? this.zZm.getTitle() : this.zZl.getTitle();
    }

    public String getUrl() {
        return !this.zZk ? this.zZm.getUrl() : this.zZl.getUrl();
    }

    public View getView() {
        return !this.zZk ? this.zZm : this.zZl.getView();
    }

    public int getVisibleTitleHeight() {
        if (this.zZk) {
            return this.zZl.getVisibleTitleHeight();
        }
        Object f = o.f(this.zZm, "getVisibleTitleHeight");
        return f == null ? 0 : ((Integer) f).intValue();
    }

    public WebChromeClient getWebChromeClient() {
        return this.zZw;
    }

    public IX5WebChromeClientExtension getWebChromeClientExtension() {
        return !this.zZk ? null : this.zZl.getX5WebViewExtension().getWebChromeClientExtension();
    }

    public int getWebScrollX() {
        return this.zZk ? this.zZl.getView().getScrollX() : this.zZm.getScrollX();
    }

    public int getWebScrollY() {
        return this.zZk ? this.zZl.getView().getScrollY() : this.zZm.getScrollY();
    }

    public WebViewClient getWebViewClient() {
        return this.zZv;
    }

    public IX5WebViewClientExtension getWebViewClientExtension() {
        return !this.zZk ? null : this.zZl.getX5WebViewExtension().getWebViewClientExtension();
    }

    public HitTestResult getX5HitTestResult() {
        return !this.zZk ? null : this.zZl.getHitTestResult();
    }

    public IX5WebViewExtension getX5WebViewExtension() {
        return !this.zZk ? null : this.zZl.getX5WebViewExtension();
    }

    @Deprecated
    public View getZoomControls() {
        return !this.zZk ? (View) o.f(this.zZm, "getZoomControls") : this.zZl.getZoomControls();
    }

    public void goBack() {
        if (this.zZk) {
            this.zZl.goBack();
        } else {
            this.zZm.goBack();
        }
    }

    public void goBackOrForward(int i) {
        if (this.zZk) {
            this.zZl.goBackOrForward(i);
        } else {
            this.zZm.goBackOrForward(i);
        }
    }

    public void goForward() {
        if (this.zZk) {
            this.zZl.goForward();
        } else {
            this.zZm.goForward();
        }
    }

    public void invokeZoomPicker() {
        if (this.zZk) {
            this.zZl.invokeZoomPicker();
        } else {
            this.zZm.invokeZoomPicker();
        }
    }

    public boolean isDayMode() {
        return zZE;
    }

    public boolean isPrivateBrowsingEnabled() {
        if (this.zZk) {
            return this.zZl.isPrivateBrowsingEnable();
        }
        if (VERSION.SDK_INT < 11) {
            return false;
        }
        Object f = o.f(this.zZm, "isPrivateBrowsingEnabled");
        return f == null ? false : ((Boolean) f).booleanValue();
    }

    public void loadData(String str, String str2, String str3) {
        if (this.zZk) {
            this.zZl.loadData(str, str2, str3);
        } else {
            this.zZm.loadData(str, str2, str3);
        }
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (this.zZk) {
            this.zZl.loadDataWithBaseURL(str, str2, str3, str4, str5);
        } else {
            this.zZm.loadDataWithBaseURL(str, str2, str3, str4, str5);
        }
    }

    public void loadUrl(String str) {
        if (this.zZk && this.zZq != null) {
            this.zZq.bb(this.zZl.hashCode(), str);
        }
        if (str != null && !showDebugView(str)) {
            if (this.zZk) {
                this.zZl.loadUrl(str);
            } else {
                this.zZm.loadUrl(str);
            }
        }
    }

    @TargetApi(8)
    public void loadUrl(String str, Map<String, String> map) {
        if (this.zZk && this.zZq != null) {
            this.zZq.bb(this.zZl.hashCode(), str);
        }
        if (str != null && !showDebugView(str)) {
            if (this.zZk) {
                this.zZl.loadUrl(str, map);
            } else if (VERSION.SDK_INT >= 8) {
                this.zZm.loadUrl(str, map);
            }
        }
    }

    protected void onDetachedFromWindow() {
        if (!(this.zZp || this.zZo == 0)) {
            this.zZp = true;
            String str = "";
            String str2 = "";
            String str3 = "";
            if (this.zZk) {
                Bundle sdkQBStatisticsInfo = this.zZl.getX5WebViewExtension().getSdkQBStatisticsInfo();
                if (sdkQBStatisticsInfo != null) {
                    str = sdkQBStatisticsInfo.getString("guid");
                    str2 = sdkQBStatisticsInfo.getString("qua2");
                    str3 = sdkQBStatisticsInfo.getString("lc");
                }
            }
            if ("com.qzone".equals(this.mContext.getApplicationInfo().packageName)) {
                int hz = hz(this.mContext);
                if (hz == -1) {
                    hz = this.zZo;
                }
                this.zZo = hz;
                hB(this.mContext);
            }
            b.a(this.mContext, str, str2, str3, this.zZo, this.zZk, cFb());
            this.zZo = 0;
            this.zZp = false;
        }
        super.onDetachedFromWindow();
    }

    public boolean onLongClick(View view) {
        return this.ztW != null ? !this.ztW.onLongClick(view) ? dR(view) : true : dR(view);
    }

    public void onPause() {
        if (this.zZk) {
            this.zZl.onPause();
        } else {
            o.f(this.zZm, "onPause");
        }
    }

    public void onResume() {
        if (this.zZk) {
            this.zZl.onResume();
        } else {
            o.f(this.zZm, "onResume");
        }
    }

    @TargetApi(11)
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (VERSION.SDK_INT >= 21 && hy(this.mContext) && isHardwareAccelerated() && i > 0 && i2 > 0) {
            getLayerType();
        }
    }

    protected void onVisibilityChanged(View view, int i) {
        if (this.mContext == null) {
            super.onVisibilityChanged(view, i);
            return;
        }
        if (zZx == null) {
            zZx = this.mContext.getApplicationInfo().packageName;
        }
        if (zZx == null || !(zZx.equals("com.tencent.mm") || zZx.equals("com.tencent.mobileqq"))) {
            if (!(i == 0 || this.zZp || this.zZo == 0)) {
                this.zZp = true;
                String str = "";
                String str2 = "";
                String str3 = "";
                if (this.zZk) {
                    Bundle sdkQBStatisticsInfo = this.zZl.getX5WebViewExtension().getSdkQBStatisticsInfo();
                    if (sdkQBStatisticsInfo != null) {
                        str = sdkQBStatisticsInfo.getString("guid");
                        str2 = sdkQBStatisticsInfo.getString("qua2");
                        str3 = sdkQBStatisticsInfo.getString("lc");
                    }
                }
                if ("com.qzone".equals(this.mContext.getApplicationInfo().packageName)) {
                    int hz = hz(this.mContext);
                    if (hz == -1) {
                        hz = this.zZo;
                    }
                    this.zZo = hz;
                    hB(this.mContext);
                }
                b.a(this.mContext, str, str2, str3, this.zZo, this.zZk, cFb());
                this.zZo = 0;
                this.zZp = false;
            }
            super.onVisibilityChanged(view, i);
            return;
        }
        super.onVisibilityChanged(view, i);
    }

    public boolean overlayHorizontalScrollbar() {
        return !this.zZk ? this.zZm.overlayHorizontalScrollbar() : this.zZl.overlayHorizontalScrollbar();
    }

    public boolean overlayVerticalScrollbar() {
        return this.zZk ? this.zZl.overlayVerticalScrollbar() : this.zZm.overlayVerticalScrollbar();
    }

    public boolean pageDown(boolean z) {
        return !this.zZk ? this.zZm.pageDown(z) : this.zZl.pageDown(z, -1);
    }

    public boolean pageUp(boolean z) {
        return !this.zZk ? this.zZm.pageUp(z) : this.zZl.pageUp(z, -1);
    }

    public void pauseTimers() {
        if (this.zZk) {
            this.zZl.pauseTimers();
        } else {
            this.zZm.pauseTimers();
        }
    }

    @TargetApi(5)
    public void postUrl(String str, byte[] bArr) {
        if (this.zZk) {
            this.zZl.postUrl(str, bArr);
        } else {
            this.zZm.postUrl(str, bArr);
        }
    }

    @Deprecated
    public void refreshPlugins(boolean z) {
        if (this.zZk) {
            this.zZl.refreshPlugins(z);
            return;
        }
        o.b(this.zZm, "refreshPlugins", new Class[]{Boolean.TYPE}, new Object[]{Boolean.valueOf(z)});
    }

    public void reload() {
        if (this.zZk) {
            this.zZl.reload();
        } else {
            this.zZm.reload();
        }
    }

    @TargetApi(11)
    public void removeJavascriptInterface(String str) {
        if (!this.zZk) {
            if (VERSION.SDK_INT >= 11) {
                o.b(this.zZm, "removeJavascriptInterface", new Class[]{String.class}, new Object[]{str});
                return;
            }
            this.zZl.removeJavascriptInterface(str);
        }
    }

    public void removeView(View view) {
        if (this.zZk) {
            View view2 = this.zZl.getView();
            try {
                Method c = o.c(view2, "removeView", new Class[]{View.class});
                c.setAccessible(true);
                c.invoke(view2, new Object[]{view});
                return;
            } catch (Throwable th) {
                return;
            }
        }
        this.zZm.removeView(view);
    }

    public void reportInitPerformance(long j, int i, long j2, long j3) {
        TbsLog.i("sdkreport", "reportInitPerformance initType is " + j + " isX5Core is " + this.zZk + " isPerformanceDataRecorded" + this.zZr);
        if (this.zZk && this.zZq != null) {
            this.zZq.at("init_type", j);
            this.zZq.at("time_oncreate", j2);
            this.zZq.at("webview_type", (long) i);
            this.zZq.at("time_webaccelerator", j3);
            this.zZq.bb(this.zZl.hashCode(), getUrl());
        }
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        if (this.zZk) {
            View view2 = this.zZl.getView();
            if (!(view2 instanceof ViewGroup)) {
                return false;
            }
            ViewGroup viewGroup = (ViewGroup) view2;
            if (view != this) {
                view2 = view;
            }
            return viewGroup.requestChildRectangleOnScreen(view2, rect, z);
        }
        android.webkit.WebView webView = this.zZm;
        if (view == this) {
            view = this.zZm;
        }
        return webView.requestChildRectangleOnScreen(view, rect, z);
    }

    public void requestFocusNodeHref(Message message) {
        if (this.zZk) {
            this.zZl.requestFocusNodeHref(message);
        } else {
            this.zZm.requestFocusNodeHref(message);
        }
    }

    public void requestImageRef(Message message) {
        if (this.zZk) {
            this.zZl.requestImageRef(message);
        } else {
            this.zZm.requestImageRef(message);
        }
    }

    @Deprecated
    public boolean restorePicture(Bundle bundle, File file) {
        if (this.zZk) {
            return this.zZl.restorePicture(bundle, file);
        }
        Object b = o.b(this.zZm, "restorePicture", new Class[]{Bundle.class, File.class}, new Object[]{bundle, file});
        return b == null ? false : ((Boolean) b).booleanValue();
    }

    public WebBackForwardList restoreState(Bundle bundle) {
        return !this.zZk ? WebBackForwardList.a(this.zZm.restoreState(bundle)) : WebBackForwardList.a(this.zZl.restoreState(bundle));
    }

    public void resumeTimers() {
        if (this.zZk) {
            this.zZl.resumeTimers();
        } else {
            this.zZm.resumeTimers();
        }
    }

    @Deprecated
    public void savePassword(String str, String str2, String str3) {
        if (this.zZk) {
            this.zZl.savePassword(str, str2, str3);
            return;
        }
        o.b(this.zZm, "savePassword", new Class[]{String.class, String.class, String.class}, new Object[]{str, str2, str3});
    }

    @Deprecated
    public boolean savePicture(Bundle bundle, File file) {
        if (this.zZk) {
            return this.zZl.savePicture(bundle, file);
        }
        Object b = o.b(this.zZm, "savePicture", new Class[]{Bundle.class, File.class}, new Object[]{bundle, file});
        return b == null ? false : ((Boolean) b).booleanValue();
    }

    public WebBackForwardList saveState(Bundle bundle) {
        return !this.zZk ? WebBackForwardList.a(this.zZm.saveState(bundle)) : WebBackForwardList.a(this.zZl.saveState(bundle));
    }

    @TargetApi(11)
    public void saveWebArchive(String str) {
        if (this.zZk) {
            this.zZl.saveWebArchive(str);
        } else if (VERSION.SDK_INT >= 11) {
            o.b(this.zZm, "saveWebArchive", new Class[]{String.class}, new Object[]{str});
        }
    }

    @TargetApi(11)
    public void saveWebArchive(String str, boolean z, ab<String> abVar) {
        if (this.zZk) {
            this.zZl.saveWebArchive(str, z, abVar);
        } else if (VERSION.SDK_INT >= 11) {
            o.b(this.zZm, "saveWebArchive", new Class[]{String.class, Boolean.TYPE, ValueCallback.class}, new Object[]{str, Boolean.valueOf(z), abVar});
        }
    }

    public void setARModeEnable(boolean z) {
        try {
            if (this.zZk) {
                getSettingsExtension().setARModeEnable(z);
            }
        } catch (Throwable th) {
        }
    }

    public void setBackgroundColor(int i) {
        if (this.zZk) {
            this.zZl.setBackgroundColor(i);
        } else {
            this.zZm.setBackgroundColor(i);
        }
        super.setBackgroundColor(i);
    }

    @Deprecated
    public void setCertificate(SslCertificate sslCertificate) {
        if (this.zZk) {
            this.zZl.setCertificate(sslCertificate);
        } else {
            this.zZm.setCertificate(sslCertificate);
        }
    }

    public void setDayOrNight(boolean z) {
        try {
            if (this.zZk) {
                getSettingsExtension().setDayOrNight(z);
            }
            setSysDayOrNight(z);
            getView().postInvalidate();
        } catch (Throwable th) {
        }
    }

    public void setDownloadListener(final DownloadListener downloadListener) {
        if (this.zZk) {
            this.zZl.setDownloadListener(new b(this, downloadListener));
        } else {
            this.zZm.setDownloadListener(new DownloadListener() {
                public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                    if (downloadListener == null) {
                        c.a(WebView.this.mContext, str, null, null);
                    } else {
                        downloadListener.onDownloadStart(str, str2, str3, str4, j);
                    }
                }
            });
        }
    }

    @TargetApi(16)
    public void setFindListener(FindListener findListener) {
        if (this.zZk) {
            this.zZl.setFindListener(findListener);
        } else if (VERSION.SDK_INT >= 16) {
            this.zZm.setFindListener(new 3(this, findListener));
        }
    }

    public void setHorizontalScrollbarOverlay(boolean z) {
        if (this.zZk) {
            this.zZl.setHorizontalScrollbarOverlay(z);
        } else {
            this.zZm.setHorizontalScrollbarOverlay(z);
        }
    }

    public void setHttpAuthUsernamePassword(String str, String str2, String str3, String str4) {
        if (this.zZk) {
            this.zZl.setHttpAuthUsernamePassword(str, str2, str3, str4);
        } else {
            this.zZm.setHttpAuthUsernamePassword(str, str2, str3, str4);
        }
    }

    public void setInitialScale(int i) {
        if (this.zZk) {
            this.zZl.setInitialScale(i);
        } else {
            this.zZm.setInitialScale(i);
        }
    }

    @Deprecated
    public void setMapTrackballToArrowKeys(boolean z) {
        if (this.zZk) {
            this.zZl.setMapTrackballToArrowKeys(z);
            return;
        }
        o.b(this.zZm, "setMapTrackballToArrowKeys", new Class[]{Boolean.TYPE}, new Object[]{Boolean.valueOf(z)});
    }

    public void setNetworkAvailable(boolean z) {
        if (this.zZk) {
            this.zZl.setNetworkAvailable(z);
        } else if (VERSION.SDK_INT >= 3) {
            this.zZm.setNetworkAvailable(z);
        }
    }

    public void setOnLongClickListener(OnLongClickListener onLongClickListener) {
        if (this.zZk) {
            View view = this.zZl.getView();
            try {
                if (this.zZF == null) {
                    Method c = o.c(view, "getListenerInfo", new Class[0]);
                    c.setAccessible(true);
                    Object invoke = c.invoke(view, null);
                    Field declaredField = invoke.getClass().getDeclaredField("mOnLongClickListener");
                    declaredField.setAccessible(true);
                    this.zZF = declaredField.get(invoke);
                }
                this.ztW = onLongClickListener;
                getView().setOnLongClickListener(this);
                return;
            } catch (Throwable th) {
                return;
            }
        }
        this.zZm.setOnLongClickListener(onLongClickListener);
    }

    public void setOnTouchListener(OnTouchListener onTouchListener) {
        getView().setOnTouchListener(onTouchListener);
    }

    public void setPictureListener(PictureListener pictureListener) {
        if (this.zZk) {
            if (pictureListener == null) {
                this.zZl.setPictureListener(null);
            } else {
                this.zZl.setPictureListener(new 6(this, pictureListener));
            }
        } else if (pictureListener == null) {
            this.zZm.setPictureListener(null);
        } else {
            this.zZm.setPictureListener(new 5(this, pictureListener));
        }
    }

    public void setRendererPriorityPolicy(int i, boolean z) {
        try {
            if (!this.zZk && VERSION.SDK_INT >= 26) {
                o.b(this.zZm, "setRendererPriorityPolicy", new Class[]{Integer.TYPE, Boolean.TYPE}, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)});
            }
        } catch (Exception e) {
        }
    }

    public void setScrollBarStyle(int i) {
        if (this.zZk) {
            this.zZl.getView().setScrollBarStyle(i);
        } else {
            this.zZm.setScrollBarStyle(i);
        }
    }

    public void setSysNightModeAlpha(int i) {
        NIGHT_MODE_ALPHA = i;
    }

    public void setVerticalScrollbarOverlay(boolean z) {
        if (this.zZk) {
            this.zZl.setVerticalScrollbarOverlay(z);
        } else {
            this.zZm.setVerticalScrollbarOverlay(z);
        }
    }

    public boolean setVideoFullScreen(Context context, boolean z) {
        if (!context.getApplicationInfo().processName.contains("com.tencent.android.qqdownloader") || this.zZl == null) {
            return false;
        }
        Bundle bundle = new Bundle();
        if (z) {
            bundle.putInt("DefaultVideoScreen", 2);
        } else {
            bundle.putInt("DefaultVideoScreen", 1);
        }
        this.zZl.getX5WebViewExtension().invokeMiscMethod("setVideoParams", bundle);
        return true;
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        if (getView() != null) {
            getView().setVisibility(i);
        }
    }

    public void setWebChromeClient(WebChromeClient webChromeClient) {
        WebChromeClient webChromeClient2 = null;
        if (this.zZk) {
            IX5WebViewBase iX5WebViewBase = this.zZl;
            if (webChromeClient != null) {
                IX5WebChromeClient iX5WebChromeClient;
                ag agVar = af.cFg().zZI;
                if (agVar.zZb == null) {
                    iX5WebChromeClient = null;
                } else {
                    Object invokeStaticMethod = agVar.zZb.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createDefaultX5WebChromeClient", new Class[0], new Object[0]);
                    iX5WebChromeClient = invokeStaticMethod == null ? null : (IX5WebChromeClient) invokeStaticMethod;
                }
                Object iVar = new i(iX5WebChromeClient, this, webChromeClient);
            }
            iX5WebViewBase.setWebChromeClient(r1);
        } else {
            android.webkit.WebView webView = this.zZm;
            if (webChromeClient != null) {
                webChromeClient2 = new SystemWebChromeClient(this, webChromeClient);
            }
            webView.setWebChromeClient(webChromeClient2);
        }
        this.zZw = webChromeClient;
    }

    public void setWebChromeClientExtension(IX5WebChromeClientExtension iX5WebChromeClientExtension) {
        if (this.zZk) {
            this.zZl.getX5WebViewExtension().setWebChromeClientExtension(iX5WebChromeClientExtension);
        }
    }

    public void setWebViewCallbackClient(ae aeVar) {
        this.mWebViewCallbackClient = aeVar;
        if (this.zZk && getX5WebViewExtension() != null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("flag", true);
            getX5WebViewExtension().invokeMiscMethod("setWebViewCallbackClientFlag", bundle);
        }
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        WebViewClient webViewClient2 = null;
        if (this.zZk) {
            IX5WebViewBase iX5WebViewBase = this.zZl;
            if (webViewClient != null) {
                Object invokeStaticMethod = af.cFg().zZI.zZb.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createDefaultX5WebViewClient", new Class[0], new Object[0]);
                Object jVar = new j(invokeStaticMethod == null ? null : (IX5WebViewClient) invokeStaticMethod, this, webViewClient);
            }
            iX5WebViewBase.setWebViewClient(r1);
        } else {
            android.webkit.WebView webView = this.zZm;
            if (webViewClient != null) {
                webViewClient2 = new SystemWebViewClient(this, webViewClient);
            }
            webView.setWebViewClient(webViewClient2);
        }
        this.zZv = webViewClient;
    }

    public void setWebViewClientExtension(IX5WebViewClientExtension iX5WebViewClientExtension) {
        if (this.zZk) {
            this.zZl.getX5WebViewExtension().setWebViewClientExtension(iX5WebViewClientExtension);
        }
    }

    @SuppressLint({"NewApi"})
    public boolean showDebugView(String str) {
        String toLowerCase = str.toLowerCase();
        if (toLowerCase.startsWith("http://debugtbs.qq.com")) {
            getView().setVisibility(4);
            com.tencent.smtt.utils.e.hQ(this.mContext).a(toLowerCase, this, this.mContext, r.cEE().getLooper());
            return true;
        } else if (!toLowerCase.startsWith("http://debugx5.qq.com") || this.zZk) {
            return false;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("<!DOCTYPE html><html><body>");
            stringBuilder.append("<head>");
            stringBuilder.append("<title>无法打开debugx5</title>");
            stringBuilder.append("<meta name=\"viewport\" content=\"width=device-width, user-scalable=no\" />");
            stringBuilder.append("</head>");
            stringBuilder.append("<br/><br /><h2>debugx5页面仅在使用了X5内核时有效，由于当前没有使用X5内核，无法打开debugx5！</h2><br />");
            stringBuilder.append("尝试<a href=\"http://debugtbs.qq.com?10000\">进入DebugTbs安装或打开X5内核</a>");
            stringBuilder.append("</body></html>");
            loadDataWithBaseURL(null, stringBuilder.toString(), "text/html", ProtocolPackage.ServerEncoding, null);
            return true;
        }
    }

    public boolean showFindDialog(String str, boolean z) {
        return false;
    }

    public void stopLoading() {
        if (this.zZk) {
            this.zZl.stopLoading();
        } else {
            this.zZm.stopLoading();
        }
    }

    public void super_computeScroll() {
        if (this.zZk) {
            try {
                o.f(this.zZl.getView(), "super_computeScroll");
                return;
            } catch (Throwable th) {
                return;
            }
        }
        this.zZm.super_computeScroll();
    }

    public boolean super_dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.zZk) {
            return this.zZm.super_dispatchTouchEvent(motionEvent);
        }
        try {
            Object b = o.b(this.zZl.getView(), "super_dispatchTouchEvent", new Class[]{MotionEvent.class}, new Object[]{motionEvent});
            return b == null ? false : ((Boolean) b).booleanValue();
        } catch (Throwable th) {
            return false;
        }
    }

    public boolean super_onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.zZk) {
            return this.zZm.super_onInterceptTouchEvent(motionEvent);
        }
        try {
            Object b = o.b(this.zZl.getView(), "super_onInterceptTouchEvent", new Class[]{MotionEvent.class}, new Object[]{motionEvent});
            return b == null ? false : ((Boolean) b).booleanValue();
        } catch (Throwable th) {
            return false;
        }
    }

    public void super_onOverScrolled(int i, int i2, boolean z, boolean z2) {
        if (this.zZk) {
            try {
                o.b(this.zZl.getView(), "super_onOverScrolled", new Class[]{Integer.TYPE, Integer.TYPE, Boolean.TYPE, Boolean.TYPE}, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)});
                return;
            } catch (Throwable th) {
                return;
            }
        }
        this.zZm.super_onOverScrolled(i, i2, z, z2);
    }

    public void super_onScrollChanged(int i, int i2, int i3, int i4) {
        if (this.zZk) {
            try {
                o.b(this.zZl.getView(), "super_onScrollChanged", new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
                return;
            } catch (Throwable th) {
                return;
            }
        }
        this.zZm.super_onScrollChanged(i, i2, i3, i4);
    }

    public boolean super_onTouchEvent(MotionEvent motionEvent) {
        if (!this.zZk) {
            return this.zZm.super_onTouchEvent(motionEvent);
        }
        try {
            Object b = o.b(this.zZl.getView(), "super_onTouchEvent", new Class[]{MotionEvent.class}, new Object[]{motionEvent});
            return b == null ? false : ((Boolean) b).booleanValue();
        } catch (Throwable th) {
            return false;
        }
    }

    public boolean super_overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        if (!this.zZk) {
            return this.zZm.super_overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
        }
        try {
            Object b = o.b(this.zZl.getView(), "super_overScrollBy", new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Boolean.TYPE}, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Boolean.valueOf(z)});
            return b == null ? false : ((Boolean) b).booleanValue();
        } catch (Throwable th) {
            return false;
        }
    }

    public void switchNightMode(boolean z) {
        if (z != zZE) {
            zZE = z;
            if (z) {
                TbsLog.e("QB_SDK", "deleteNightMode");
                loadUrl("javascript:document.getElementsByTagName('HEAD').item(0).removeChild(document.getElementById('QQBrowserSDKNightMode'));");
                return;
            }
            TbsLog.e("QB_SDK", "nightMode");
            loadUrl("javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);");
        }
    }

    public void switchToNightMode() {
        TbsLog.e("QB_SDK", "switchToNightMode 01");
        if (!zZE) {
            TbsLog.e("QB_SDK", "switchToNightMode");
            loadUrl("javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);");
        }
    }

    public boolean zoomIn() {
        return !this.zZk ? this.zZm.zoomIn() : this.zZl.zoomIn();
    }

    public boolean zoomOut() {
        return !this.zZk ? this.zZm.zoomOut() : this.zZl.zoomOut();
    }
}
