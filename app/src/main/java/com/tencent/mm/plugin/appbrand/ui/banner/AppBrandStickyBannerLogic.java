package com.tencent.mm.plugin.appbrand.ui.banner;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Deprecated
public enum AppBrandStickyBannerLogic {
    ;

    public static final class a {
        private static final Watcher jOr = null;
        private static final Set<f> jOs = null;
        private static final HashMap<String, Boolean> jOt = null;
        private static final HashMap<String, f> jOu = null;
        private static final c jOv = null;
        private static final Map<String, String> jOw = null;

        static {
            jOr = new Watcher();
            jOs = new HashSet();
            jOt = new HashMap();
            jOu = new HashMap();
            jOv = new c();
            jOw = new HashMap();
        }

        static void aL(String str, int i) {
            synchronized (jOs) {
                for (f ak : jOs) {
                    ak.ak(str, i);
                }
            }
        }

        public static void a(Context context, String str, int i, String str2, String str3) {
            if (!bh.ov(str)) {
                Context context2;
                String str4;
                if (context == null) {
                    context2 = ac.getContext();
                } else {
                    context2 = context;
                }
                Intent addFlags = new Intent().setClassName(context2, "com.tencent.mm.ui.LauncherUI").addFlags(SQLiteDatabase.CREATE_IF_NECESSARY).addFlags(67108864).addFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
                synchronized (jOw) {
                    str4 = (String) jOw.get(str);
                }
                b.a(addFlags, str, i, str2, str3, bh.ou(str4));
                context2.startActivity(addFlags);
                if (context2 instanceof Activity) {
                    try {
                        ((Activity) context2).moveTaskToBack(false);
                    } catch (Exception e) {
                        x.e("MicroMsg.AppBrandStickyBannerLogic.ClientLogic", "stickOnChatting e = %s", new Object[]{e.getMessage()});
                    }
                }
            }
        }

        public static boolean aM(String str, int i) {
            AppBrandStickyBannerLogic.access$200();
            return false;
        }

        public static void c(f fVar) {
            if (fVar != null) {
                synchronized (jOs) {
                    jOs.remove(fVar);
                }
            }
        }

        public static void d(f fVar) {
            jOr.jOA = ac.Br();
            AppBrandMainProcessService.a(jOr);
            if (fVar != null) {
                synchronized (jOs) {
                    jOs.add(fVar);
                }
            }
        }

        public static void Y(String str, boolean z) {
            jOt.put(str, Boolean.valueOf(z));
            f 1 = new 1(str);
            d(1);
            jOu.put(str, 1);
        }

        public static void uv(String str) {
            jOt.remove(str);
            x.i("MicroMsg.AppBrandStickyBannerLogic", "release(%s)", new Object[]{str});
        }

        public static void uw(String str) {
            if (!bh.ov(str)) {
                int i = com.tencent.mm.plugin.appbrand.a.oS(str).iOI.iGK;
                if (i >= 0) {
                    i.se(str);
                    AppBrandMainProcessService.a(OperateTask.aO(str, i));
                }
            }
        }

        public static void bD(String str, String str2) {
            if (!bh.ov(str)) {
                synchronized (jOw) {
                    jOw.put(str, bh.ou(str2));
                }
                AppBrandSysConfig oS = com.tencent.mm.plugin.appbrand.a.oS(str);
                if (oS != null) {
                    AppBrandMainProcessService.a(OperateTask.p(str, oS.iOI.iGK, str2));
                }
            }
        }
    }
}
