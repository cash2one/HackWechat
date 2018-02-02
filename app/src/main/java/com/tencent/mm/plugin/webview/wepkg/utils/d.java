package com.tencent.mm.plugin.webview.wepkg.utils;

import android.content.SharedPreferences;
import android.net.Uri;
import android.webkit.URLUtil;
import com.tencent.mm.a.g;
import com.tencent.mm.plugin.webview.wepkg.ipc.WepkgMainProcessService;
import com.tencent.mm.plugin.webview.wepkg.ipc.WepkgMainProcessTask;
import com.tencent.mm.plugin.webview.wepkg.model.WepkgCrossProcessTask;
import com.tencent.mm.plugin.webview.wepkg.model.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

public final class d {
    private static volatile ag hmW;
    private static final Object jRO = new Object();
    private static final Set<Object> jbB = new HashSet();

    public static long alI() {
        return bh.Wo();
    }

    public static <T> T bj(T t) {
        jbB.add(t);
        return t;
    }

    public static void bk(Object obj) {
        if (obj != null) {
            jbB.remove(obj);
        }
    }

    public static void alJ() {
        if (hmW != null) {
            synchronized (jRO) {
                if (hmW != null) {
                    hmW.oAt.quit();
                    hmW = null;
                }
            }
        }
    }

    public static ag Dm() {
        if (hmW == null) {
            synchronized (jRO) {
                if (hmW == null) {
                    hmW = new ag("WebviewCache#WorkerThread");
                }
            }
        }
        return hmW;
    }

    public static String Qp(String str) {
        if (bh.ov(str)) {
            return "";
        }
        return b.OBJECT_ROOT_DIR_PATH + str + "/";
    }

    public static String eX(String str, String str2) {
        if (bh.ov(str) || bh.ov(str2)) {
            return "";
        }
        return Qp(str) + str2;
    }

    public static void a(String str, a aVar) {
        long currentTimeMillis = System.currentTimeMillis();
        WepkgMainProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
        wepkgCrossProcessTask.pK = 1001;
        wepkgCrossProcessTask.tMW = str;
        if (ac.cfw()) {
            Dm().F(new 1(wepkgCrossProcessTask, aVar));
            return;
        }
        wepkgCrossProcessTask.jcI = new 2(currentTimeMillis, aVar, wepkgCrossProcessTask);
        wepkgCrossProcessTask.afi();
        WepkgMainProcessService.a(wepkgCrossProcessTask);
    }

    public static String Qq(String str) {
        if (bh.ov(str)) {
            return "";
        }
        try {
            return bh.ou(Uri.parse(str).getQueryParameter("wechat_pkgid"));
        } catch (UnsupportedOperationException e) {
            x.e("MicroMsg.Wepkg.WepkgUtil", e.getMessage());
            return "";
        }
    }

    public static String Qr(String str) {
        if (bh.ov(str)) {
            return "";
        }
        return Uri.parse(str).getHost();
    }

    public static String Qs(String str) {
        if (bh.ov(str) || !URLUtil.isNetworkUrl(str)) {
            return "";
        }
        try {
            String replaceFirst = str.replaceFirst(Uri.parse(str).getScheme() + "://", "");
            try {
                if (replaceFirst.contains("?")) {
                    return replaceFirst.substring(0, replaceFirst.indexOf("?"));
                }
                return replaceFirst;
            } catch (Exception e) {
                return replaceFirst;
            }
        } catch (Exception e2) {
            return str;
        }
    }

    public static boolean Qt(String str) {
        if (bh.ov(Qq(str))) {
            return false;
        }
        SharedPreferences sharedPreferences = ac.getContext().getSharedPreferences("we_pkg_sp", 4);
        if (sharedPreferences != null && sharedPreferences.getBoolean("disable_we_pkg", false)) {
            x.i("MicroMsg.Wepkg.WepkgUtil", "disable wepkg");
            a.b("EnterWeb", str, Qq(str), null, 0, 0, a.Bi(11));
            return false;
        } else if (!b.tNW) {
            return true;
        } else {
            x.i("MicroMsg.Wepkg.WepkgUtil", "config wepkg disable");
            a.b("EnterWeb", str, Qq(str), null, 0, 0, a.Bi(12));
            return false;
        }
    }

    public static String eY(String str, String str2) {
        return g.s((str + "_" + str2).getBytes());
    }

    public static boolean Qu(String str) {
        try {
            File file = new File(str);
            if (!(file.exists() && file.isDirectory())) {
                file.mkdirs();
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean bVo() {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        int i = gregorianCalendar.get(11);
        int i2 = gregorianCalendar.get(12);
        if (i >= 12 && i < 14) {
            return true;
        }
        if (i == 14) {
            if (i2 <= 30) {
                return true;
            }
        } else if (i >= 18 && i <= 24) {
            return true;
        }
        return false;
    }
}
