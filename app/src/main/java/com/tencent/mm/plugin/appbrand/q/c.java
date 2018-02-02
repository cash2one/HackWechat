package com.tencent.mm.plugin.appbrand.q;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.e$h;
import com.tencent.mm.vending.h.g;
import com.tencent.mm.vending.h.h;
import com.tencent.wcdb.FileUtils;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public final class c {
    private static volatile ag hmW;
    private static final Object jRO = new Object();
    private static final char[] jRP = new char[]{'<', '>', '\"', '\'', '&', ' ', '\''};
    private static final String[] jRQ = new String[]{"&lt;", "&gt;", "&quot;", "&apos;", "&amp;", "&nbsp;", "&#39;"};
    private static final Set<Object> jbB = new HashSet();

    public static void alH() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(e$h.xEp, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
        intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
        ac.getContext().sendBroadcast(intent);
    }

    public static long alI() {
        return bh.Wo();
    }

    public static String getMMString(int i, Object... objArr) {
        return ac.getResources().getString(i, objArr);
    }

    public static <T> T bj(T t) {
        if (t != null) {
            jbB.add(t);
        }
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
                    g.aao("SubCoreAppBrand#WorkerThread");
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
                    hmW = new ag("SubCoreAppBrand#WorkerThread");
                    g.a("SubCoreAppBrand#WorkerThread", new h(hmW.oAt.getLooper(), "SubCoreAppBrand#WorkerThread"));
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

    public static String uE(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = str.length();
        int i = 0;
        while (i < length) {
            int i2 = 0;
            while (i2 < jRP.length) {
                String str2 = jRQ[i2];
                int i3 = 0;
                while (i3 < str2.length() && i + i3 < length && str2.charAt(i3) == str.charAt(i + i3)) {
                    i3++;
                }
                if (i3 == str2.length()) {
                    break;
                }
                i2++;
            }
            if (i2 != jRP.length) {
                stringBuffer.append(jRP[i2]);
                i = jRQ[i2].length() + i;
            } else {
                stringBuffer.append(str.charAt(i));
                i++;
            }
        }
        return stringBuffer.toString();
    }

    public static String uF(String str) {
        if (str == null) {
            return null;
        }
        return str.replace(' ', '\n').replace(' ', '\n');
    }

    public static String b(ComponentName componentName) {
        String str = "[UNKNOWN]";
        if (componentName != null) {
            PackageManager packageManager = ac.getContext().getPackageManager();
            if (packageManager != null) {
                try {
                    ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, FileUtils.S_IWUSR);
                    if (activityInfo != null) {
                        str = activityInfo.taskAffinity;
                    }
                } catch (Exception e) {
                    x.e("MicroMsg.AppBrandUtil", "getActivityTaskAffinity e = %s", new Object[]{e});
                }
            }
        }
        return str;
    }

    public static int c(Context context, float f) {
        return Math.round(context.getResources().getDisplayMetrics().density * f);
    }
}
