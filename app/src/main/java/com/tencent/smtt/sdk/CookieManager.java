package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.tencent.smtt.sdk.v.b;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class CookieManager {
    public static String LOGTAG = "CookieManager";
    private static CookieManager zUV;
    ArrayList<b> zUW;
    String zUX;
    int zUY = a.zVb;
    private boolean zUZ = false;
    private boolean zVa = false;

    public enum a {
        ;

        static {
            zVb = 1;
            zVc = 2;
            zVd = 3;
            zVe = new int[]{zVb, zVc, zVd};
        }
    }

    private CookieManager() {
    }

    public static CookieManager getInstance() {
        if (zUV == null) {
            synchronized (CookieManager.class) {
                if (zUV == null) {
                    zUV = new CookieManager();
                }
            }
        }
        return zUV;
    }

    public static int getROMCookieDBVersion(Context context) {
        return (VERSION.SDK_INT >= 11 ? context.getSharedPreferences("cookiedb_info", 4) : context.getSharedPreferences("cookiedb_info", 0)).getInt("db_version", -1);
    }

    public static void setROMCookieDBVersion(Context context, int i) {
        Editor edit = (VERSION.SDK_INT >= 11 ? context.getSharedPreferences("cookiedb_info", 4) : context.getSharedPreferences("cookiedb_info", 0)).edit();
        edit.putInt("db_version", i);
        edit.commit();
    }

    public boolean acceptCookie() {
        af cFg = af.cFg();
        if (cFg == null || !cFg.cFh()) {
            return android.webkit.CookieManager.getInstance().acceptCookie();
        }
        Object invokeStaticMethod = cFg.cFi().zZb.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_acceptCookie", new Class[0], new Object[0]);
        return invokeStaticMethod == null ? false : ((Boolean) invokeStaticMethod).booleanValue();
    }

    public synchronized boolean acceptThirdPartyCookies(WebView webView) {
        boolean booleanValue;
        af cFg = af.cFg();
        Object invokeStaticMethod;
        if (cFg != null && cFg.cFh()) {
            invokeStaticMethod = cFg.cFi().zZb.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_acceptThirdPartyCookies", new Class[]{Object.class}, new Object[]{webView.getView()});
            booleanValue = invokeStaticMethod != null ? ((Boolean) invokeStaticMethod).booleanValue() : true;
        } else if (VERSION.SDK_INT < 21) {
            booleanValue = true;
        } else {
            invokeStaticMethod = o.b(android.webkit.CookieManager.getInstance(), "acceptThirdPartyCookies", new Class[]{WebView.class}, webView.getView());
            booleanValue = invokeStaticMethod != null ? ((Boolean) invokeStaticMethod).booleanValue() : false;
        }
        return booleanValue;
    }

    final synchronized void cDN() {
        this.zVa = true;
        if (!(this.zUW == null || this.zUW.size() == 0)) {
            af cFg = af.cFg();
            Iterator it;
            b bVar;
            if (cFg != null && cFg.cFh()) {
                it = this.zUW.iterator();
                while (it.hasNext()) {
                    bVar = (b) it.next();
                    switch (bVar.zVf) {
                        case 1:
                            setCookie(bVar.url, bVar.value, bVar.zVg);
                            break;
                        case 2:
                            setCookie(bVar.url, bVar.value);
                            break;
                        default:
                            break;
                    }
                }
            }
            it = this.zUW.iterator();
            while (it.hasNext()) {
                bVar = (b) it.next();
                switch (bVar.zVf) {
                    case 1:
                        if (VERSION.SDK_INT < 21) {
                            break;
                        }
                        o.b(android.webkit.CookieManager.getInstance(), "setCookie", new Class[]{String.class, String.class, ValueCallback.class}, bVar.url, bVar.value, bVar.zVg);
                        break;
                    case 2:
                        android.webkit.CookieManager.getInstance().setCookie(bVar.url, bVar.value);
                        break;
                    default:
                        break;
                }
            }
            this.zUW.clear();
        }
    }

    public void flush() {
        af cFg = af.cFg();
        if (cFg != null && cFg.cFh()) {
            cFg.cFi().zZb.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_flush", new Class[0], new Object[0]);
        } else if (VERSION.SDK_INT >= 21) {
            o.b(android.webkit.CookieManager.getInstance(), "flush", new Class[0], new Object[0]);
        }
    }

    public String getCookie(String str) {
        af cFg = af.cFg();
        if (cFg == null || !cFg.cFh()) {
            try {
                return android.webkit.CookieManager.getInstance().getCookie(str);
            } catch (Throwable th) {
                return null;
            }
        }
        Object invokeStaticMethod = cFg.cFi().zZb.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getCookie", new Class[]{String.class}, new Object[]{str});
        return invokeStaticMethod == null ? null : (String) invokeStaticMethod;
    }

    public boolean hasCookies() {
        af cFg = af.cFg();
        if (cFg == null || !cFg.cFh()) {
            return android.webkit.CookieManager.getInstance().hasCookies();
        }
        Object invokeStaticMethod = cFg.cFi().zZb.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_hasCookies", new Class[0], new Object[0]);
        return invokeStaticMethod == null ? false : ((Boolean) invokeStaticMethod).booleanValue();
    }

    protected final synchronized void p(Context context, boolean z) {
        int i = 0;
        synchronized (this) {
            if (!(this.zUY == a.zVb || context == null || !q.cED().bH(context, "cookie_switch.txt") || this.zUZ)) {
                long currentTimeMillis = System.currentTimeMillis();
                long j = 0;
                TbsLog.i(LOGTAG, "compatiableCookieDatabaseIfNeed,isX5Inited:true" + ",useX5:" + z);
                if (QbSdk.getIsSysWebViewForcedByOuter() || QbSdk.zVJ) {
                    z = false;
                }
                boolean bH = q.cED().bH(context, "usex5.txt");
                TbsLog.i(LOGTAG, "usex5 : mUseX5LastProcess->" + bH + ",useX5:" + z);
                q.cED().m(context, "usex5.txt", z);
                if (bH != z) {
                    int i2;
                    v.hn(context);
                    b cEJ = v.cEJ();
                    if (TextUtils.isEmpty(this.zUX)) {
                        cEJ.setErrorCode(701);
                        i2 = 0;
                    } else if (t.cEF().ha(context) <= 0 || t.cEF().ha(context) >= 36001) {
                        boolean z2;
                        int gB;
                        if (bH) {
                            gB = k.gB(context);
                            if (gB > 0) {
                                i2 = getROMCookieDBVersion(context);
                                if (i2 <= 0) {
                                    i = i2;
                                    i2 = gB;
                                    z2 = true;
                                } else {
                                    i = i2;
                                    i2 = gB;
                                    z2 = false;
                                }
                            }
                            i2 = gB;
                            z2 = false;
                        } else {
                            gB = k.gB(context);
                            if (gB > 0) {
                                Object bL = t.cEF().bL(context, "cookies_database_version");
                                if (!TextUtils.isEmpty(bL)) {
                                    try {
                                        i = Integer.parseInt(bL);
                                        i2 = gB;
                                        z2 = false;
                                    } catch (Exception e) {
                                    }
                                }
                            }
                            i2 = gB;
                            z2 = false;
                        }
                        if (!z2 && (i2 <= 0 || i <= 0)) {
                            cEJ.setErrorCode(702);
                        } else if (i >= i2) {
                            cEJ.setErrorCode(703);
                        } else {
                            k.a(context, this.zUY, this.zUX, z2);
                            cEJ.setErrorCode(704);
                            j = System.currentTimeMillis() - currentTimeMillis;
                        }
                    }
                    cEJ.abl("x5->sys:" + bH + " from:" + i2 + " to:" + i + ",timeused:" + j);
                    v.hn(context).a(com.tencent.smtt.sdk.v.a.zYk, cEJ);
                }
            }
        }
    }

    public void removeAllCookie() {
        if (this.zUW != null) {
            this.zUW.clear();
        }
        af cFg = af.cFg();
        if (cFg == null || !cFg.cFh()) {
            android.webkit.CookieManager.getInstance().removeAllCookie();
        } else {
            cFg.cFi().zZb.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeAllCookie", new Class[0], new Object[0]);
        }
    }

    public void removeAllCookies(ab<Boolean> abVar) {
        if (this.zUW != null) {
            this.zUW.clear();
        }
        af cFg = af.cFg();
        if (cFg != null && cFg.cFh()) {
            cFg.cFi().zZb.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeAllCookies", new Class[]{ValueCallback.class}, new Object[]{abVar});
        } else if (VERSION.SDK_INT >= 21) {
            o.b(android.webkit.CookieManager.getInstance(), "removeAllCookies", new Class[]{ValueCallback.class}, abVar);
        }
    }

    public void removeExpiredCookie() {
        af cFg = af.cFg();
        if (cFg == null || !cFg.cFh()) {
            android.webkit.CookieManager.getInstance().removeExpiredCookie();
        } else {
            cFg.cFi().zZb.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeExpiredCookie", new Class[0], new Object[0]);
        }
    }

    public void removeSessionCookie() {
        af cFg = af.cFg();
        if (cFg == null || !cFg.cFh()) {
            android.webkit.CookieManager.getInstance().removeSessionCookie();
        } else {
            cFg.cFi().zZb.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeSessionCookie", new Class[0], new Object[0]);
        }
    }

    public void removeSessionCookies(ab<Boolean> abVar) {
        af cFg = af.cFg();
        if (cFg != null && cFg.cFh()) {
            cFg.cFi().zZb.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeSessionCookies", new Class[]{ValueCallback.class}, new Object[]{abVar});
        } else if (VERSION.SDK_INT >= 21) {
            o.b(android.webkit.CookieManager.getInstance(), "removeSessionCookies", new Class[]{ValueCallback.class}, abVar);
        }
    }

    public synchronized void setAcceptCookie(boolean z) {
        af cFg = af.cFg();
        if (cFg == null || !cFg.cFh()) {
            try {
                android.webkit.CookieManager.getInstance().setAcceptCookie(z);
            } catch (Throwable th) {
            }
        } else {
            cFg.cFi().zZb.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setAcceptCookie", new Class[]{Boolean.TYPE}, new Object[]{Boolean.valueOf(z)});
        }
    }

    public synchronized void setAcceptThirdPartyCookies(WebView webView, boolean z) {
        af cFg = af.cFg();
        if (cFg != null && cFg.cFh()) {
            cFg.cFi().zZb.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setAcceptThirdPartyCookies", new Class[]{Object.class, Boolean.TYPE}, new Object[]{webView.getView(), Boolean.valueOf(z)});
        } else if (VERSION.SDK_INT >= 21) {
            o.b(android.webkit.CookieManager.getInstance(), "setAcceptThirdPartyCookies", new Class[]{WebView.class, Boolean.TYPE}, webView.getView(), Boolean.valueOf(z));
        }
    }

    public synchronized void setCookie(String str, String str2) {
        setCookie(str, str2, false);
    }

    public synchronized void setCookie(String str, String str2, ab<Boolean> abVar) {
        af cFg = af.cFg();
        if (cFg == null || !cFg.cFh()) {
            if (!af.cFg().zWo) {
                b bVar = new b(this);
                bVar.zVf = 1;
                bVar.url = str;
                bVar.value = str2;
                bVar.zVg = abVar;
                if (this.zUW == null) {
                    this.zUW = new ArrayList();
                }
                this.zUW.add(bVar);
            }
            if (this.zVa && VERSION.SDK_INT >= 21) {
                o.b(android.webkit.CookieManager.getInstance(), "setCookie", new Class[]{String.class, String.class, ValueCallback.class}, str, str2, abVar);
            }
        } else {
            cFg.cFi().zZb.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setCookie", new Class[]{String.class, String.class, ValueCallback.class}, new Object[]{str, str2, abVar});
        }
    }

    public synchronized void setCookie(String str, String str2, boolean z) {
        af cFg = af.cFg();
        if (cFg == null || !cFg.cFh()) {
            if (this.zVa || z) {
                android.webkit.CookieManager.getInstance().setCookie(str, str2);
            }
            if (!af.cFg().zWo) {
                b bVar = new b(this);
                bVar.zVf = 2;
                bVar.url = str;
                bVar.value = str2;
                bVar.zVg = null;
                if (this.zUW == null) {
                    this.zUW = new ArrayList();
                }
                this.zUW.add(bVar);
            }
        } else {
            cFg.cFi().zZb.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setCookie", new Class[]{String.class, String.class}, new Object[]{str, str2});
        }
    }

    public boolean setCookieCompatialbeMode$4fb4c7d(Context context, int i, String str, boolean z) {
        System.currentTimeMillis();
        if (context == null || !q.cED().bH(context, "cookie_switch.txt")) {
            return false;
        }
        this.zUY = i;
        if (str != null) {
            this.zUX = str;
        }
        if (!(this.zUY == a.zVb || !z || af.cFg().zWo)) {
            af.cFg().b(context, null);
        }
        return true;
    }

    public void setCookies(Map<String, String[]> map) {
        boolean z;
        af cFg = af.cFg();
        if (cFg == null || !cFg.cFh()) {
            z = false;
        } else {
            Object invokeStaticMethod = cFg.cFi().zZb.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setCookies", new Class[]{Map.class}, new Object[]{map});
            z = invokeStaticMethod == null ? false : ((Boolean) invokeStaticMethod).booleanValue();
        }
        if (!z) {
            for (String str : map.keySet()) {
                for (String cookie : (String[]) map.get(str)) {
                    setCookie(str, cookie);
                }
            }
        }
    }
}
