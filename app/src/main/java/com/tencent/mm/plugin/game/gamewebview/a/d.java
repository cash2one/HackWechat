package com.tencent.mm.plugin.game.gamewebview.a;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.view.Window;
import android.webkit.URLUtil;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.plugin.game.gamewebview.ipc.CommonLogicTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GWMainProcessTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameWebViewMainProcessService;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.modeltools.f;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMFragmentActivity.a;
import com.tencent.mm.ui.ae;
import com.tencent.mm.z.ar;
import com.tencent.smtt.sdk.WebView;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

public final class d {
    private static volatile ag hmW;
    private static final Object jRO = new Object();
    private static final Set<Object> jbB = new HashSet();

    public static ag Dm() {
        if (hmW == null) {
            synchronized (jRO) {
                if (hmW == null) {
                    hmW = new ag("SubCoreAppBrand#WorkerThread");
                }
            }
        }
        return hmW;
    }

    public static void runOnUiThread(Runnable runnable) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            ag.y(runnable);
        } else {
            runnable.run();
        }
    }

    public static boolean uz(String str) {
        return !bh.ov(str) && (URLUtil.isHttpsUrl(str) || URLUtil.isHttpUrl(str));
    }

    public static String X(Context context, String str) {
        return s.aL(context, str) + " GameWebView";
    }

    public static void m(Map map) {
        for (Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if ((key instanceof String) && (value instanceof Map)) {
                m((Map) value);
                map.put(key, new JSONObject((Map) value));
            }
        }
    }

    public static String BA(String str) {
        return e(str, null);
    }

    public static String e(String str, Map<String, ? extends Object> map) {
        Map hashMap = new HashMap();
        hashMap.put("err_msg", str);
        if (map != null) {
            hashMap.putAll(map);
        }
        m(hashMap);
        return new JSONObject(hashMap).toString();
    }

    public static WebViewJSSDKFileItem BB(String str) {
        if (bh.ov(str)) {
            x.e("MicroMsg.GameWebViewUtil", "get by local id error, local id is null or nil");
            return null;
        } else if (ac.cfw()) {
            return f.bRB().Oo(str);
        } else {
            GWMainProcessTask commonLogicTask = new CommonLogicTask();
            commonLogicTask.type = 3;
            Bundle bundle = new Bundle();
            bundle.putString("localId", str);
            commonLogicTask.msB = bundle;
            GameWebViewMainProcessService.b(commonLogicTask);
            return (WebViewJSSDKFileItem) commonLogicTask.msB.getParcelable("item");
        }
    }

    public static String BC(String str) {
        String str2 = null;
        try {
            Matcher matcher = Pattern.compile("(?i)^.*filename=\"?([^\"]+)\"?.*$").matcher(str);
            if (matcher.find() && matcher.groupCount() == 1) {
                str2 = matcher.group(1);
            }
        } catch (Exception e) {
            x.e("MicroMsg.GameWebViewUtil", "getFileNameFromContentDisposition error " + e.getMessage());
        }
        return str2;
    }

    public static JSONObject sc(String str) {
        if (bh.ov(str)) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (Exception e) {
            x.e("MicroMsg.GameWebViewUtil", e.getMessage());
            return null;
        }
    }

    public static boolean aOD() {
        if (ac.cfw()) {
            return ar.Hj();
        }
        GWMainProcessTask commonLogicTask = new CommonLogicTask();
        commonLogicTask.type = 6;
        GameWebViewMainProcessService.b(commonLogicTask);
        return commonLogicTask.msB.getBoolean("has_set_uin", false);
    }

    public static int ak(int i, String str) {
        if (i == 0) {
            if (str == null || str.length() <= 0) {
                i = 0;
            } else {
                i = 1;
            }
        }
        x.i("MicroMsg.GameWebViewUtil", "KGetA8KeyScene = %s", new Object[]{Integer.valueOf(i)});
        return i;
    }

    public static void cH(Context context) {
        if (context instanceof Activity) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(16973825, new int[]{16842936, 16842937});
            int resourceId = obtainStyledAttributes.getResourceId(0, 0);
            int resourceId2 = obtainStyledAttributes.getResourceId(1, 0);
            obtainStyledAttributes.recycle();
            ((Activity) context).overridePendingTransition(resourceId, resourceId2);
        }
    }

    public static void cI(Context context) {
        if (context instanceof Activity) {
            ((Activity) context).overridePendingTransition(a.xKk, a.xKl);
        }
    }

    public static void b(Context context, int i, String str) {
        if (context instanceof Activity) {
            Window window = ((Activity) context).getWindow();
            if (VERSION.SDK_INT >= 23 && !h.zj()) {
                int systemUiVisibility = window.getDecorView().getSystemUiVisibility();
                if ("black".equals(str)) {
                    systemUiVisibility |= 8192;
                } else {
                    systemUiVisibility &= -8193;
                }
                window.getDecorView().setSystemUiVisibility(systemUiVisibility);
            } else if (VERSION.SDK_INT < 21) {
                return;
            } else {
                if ("black".equals(str)) {
                    i = ae.d(i, WebView.NIGHT_MODE_COLOR, 0.78f);
                }
            }
            window.setStatusBarColor(i);
        }
    }
}
