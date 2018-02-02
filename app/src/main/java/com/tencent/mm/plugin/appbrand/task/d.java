package com.tencent.mm.plugin.appbrand.task;

import android.app.Activity;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.task.AppBrandRemoteTaskController.a;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI1;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI2;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI3;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI4;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.Iterator;
import java.util.LinkedList;
import junit.framework.Assert;

public final class d {
    private static final LinkedList<e> jJW;
    private static final LinkedList<e> jJX;
    private static final e jJY = new b();
    private static final e jJZ = new a();

    static {
        LinkedList linkedList = new LinkedList();
        jJW = linkedList;
        linkedList.add(new e(AppBrandUI.class, AppBrandTaskPreloadReceiver.class));
        jJW.add(new e(AppBrandUI1.class, AppBrandTaskPreloadReceiver1.class));
        jJW.add(new e(AppBrandUI2.class, AppBrandTaskPreloadReceiver2.class));
        jJW.add(new e(AppBrandUI3.class, AppBrandTaskPreloadReceiver3.class));
        jJW.add(new e(AppBrandUI4.class, AppBrandTaskPreloadReceiver4.class));
        linkedList = new LinkedList();
        jJX = linkedList;
        linkedList.addAll(jJW);
        jJX.add(jJY);
        jJX.add(jJZ);
    }

    public static int b(Context context, AppBrandInitConfig appBrandInitConfig, AppBrandStatObject appBrandStatObject) {
        e eVar;
        int i;
        Context context2;
        if (appBrandInitConfig.iNR) {
            eVar = jJY;
            i = 1;
        } else {
            e ul = ul(appBrandInitConfig.appId);
            if (ul == null || ul == jJY) {
                if (appBrandInitConfig.iNS) {
                    ul = jJZ;
                } else {
                    ul = akv();
                }
                a(ul);
                eVar = ul;
                i = 1;
            } else {
                eVar = ul;
                i = 2;
            }
        }
        eVar.a(appBrandInitConfig.appId, appBrandInitConfig.iGA, null);
        if (context == null) {
            context2 = ac.getContext();
        } else {
            context2 = context;
        }
        Intent intent = new Intent(context2, eVar.jKd);
        intent.putExtra("key_appbrand_init_config", appBrandInitConfig);
        intent.putExtra("key_appbrand_stat_object", appBrandStatObject);
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        if (context2 instanceof Activity) {
            RunningTaskInfo ah = bh.ah(context2, ((Activity) context2).getTaskId());
            if (!(ah == null || ah.baseActivity == null || !bh.ou(ah.baseActivity.getClassName()).equals(eVar.jKc))) {
                intent.putExtra("key_appbrand_bring_ui_to_front_from_task_Base_by_task_top_ui", true);
                intent.addFlags(603979776);
            }
        }
        context2.startActivity(intent);
        if (i == 1) {
            uj(appBrandInitConfig.appId);
        }
        return i;
    }

    public static void aJ(String str, int i) {
        e ul = ul(str);
        if (ul != null && ((Integer) ul.jKf.get(str)).intValue() == i && ul.up(str) != null) {
            ul.up(str).ui(str);
        }
    }

    public static void lv(int i) {
        Iterator it;
        if (2 == i) {
            it = akw().iterator();
            while (it.hasNext()) {
                ((e) it.next()).akh();
            }
            aku();
            return;
        }
        it = akw().iterator();
        while (it.hasNext()) {
            e eVar = (e) it.next();
            eVar.akh();
            for (AppBrandRemoteTaskController appBrandRemoteTaskController : eVar.jKg.values()) {
                if (appBrandRemoteTaskController != null) {
                    appBrandRemoteTaskController.jJF = a.jJO;
                    appBrandRemoteTaskController.jJG = i;
                    appBrandRemoteTaskController.afp();
                }
            }
        }
    }

    public static void uj(String str) {
        e ul = ul(str);
        if (ul != null && ul.up(str) != null) {
            ul.up(str).ui(str);
        }
    }

    public static void aku() {
        if (com.tencent.mm.plugin.appbrand.appusage.a.aaB()) {
            akv().Eu();
        }
    }

    public static void uk(String str) {
        final e um = um(str);
        if (um != null) {
            ag.h(new Runnable() {
                public final void run() {
                    um.Eu();
                }
            }, 500);
        }
    }

    public static void onNetworkChange() {
        Iterator it = akw().iterator();
        while (it.hasNext()) {
            for (AppBrandRemoteTaskController appBrandRemoteTaskController : ((e) it.next()).jKg.values()) {
                if (appBrandRemoteTaskController != null) {
                    appBrandRemoteTaskController.jJF = a.jJS;
                    appBrandRemoteTaskController.afp();
                }
            }
        }
    }

    private static e akv() {
        e eVar;
        for (int i = 0; i < jJW.size(); i++) {
            if (((e) jJW.get(i)).jKf.keySet().isEmpty()) {
                eVar = (e) jJW.get(i);
                break;
            }
        }
        eVar = null;
        return eVar != null ? eVar : (e) jJW.getFirst();
    }

    private static e ul(String str) {
        Iterator it = akw().iterator();
        while (it.hasNext()) {
            e eVar = (e) it.next();
            if (eVar.jKf.keySet().contains(str)) {
                return eVar;
            }
        }
        return null;
    }

    static e um(String str) {
        Iterator it = akw().iterator();
        while (it.hasNext()) {
            e eVar = (e) it.next();
            if (eVar.jKc.equals(str)) {
                return eVar;
            }
        }
        Assert.assertTrue(true);
        return null;
    }

    static e bz(String str, String str2) {
        Iterator it = akw().iterator();
        while (it.hasNext()) {
            e eVar = (e) it.next();
            if (eVar.jKf.keySet().contains(str) && eVar.jKc.equals(str2)) {
                return eVar;
            }
        }
        return null;
    }

    public static boolean un(String str) {
        e ul = ul(str);
        if (!(ul == null || ul.up(str) == null)) {
            AppBrandRemoteTaskController up = ul.up(str);
            up.jJF = a.jJR;
            if (up.afp()) {
                return true;
            }
        }
        return false;
    }

    private static LinkedList<e> akw() {
        LinkedList<e> linkedList;
        synchronized (jJX) {
            linkedList = new LinkedList(jJX);
        }
        return linkedList;
    }

    static void uo(String str) {
        e ul = ul(str);
        if (ul != null) {
            ul.jKf.remove(str);
            ul.jKg.remove(str);
            if (ul.jKf.keySet().isEmpty()) {
                synchronized (jJX) {
                    jJX.remove(ul);
                    jJX.addFirst(ul);
                }
            }
        }
    }

    static void a(e eVar) {
        synchronized (jJX) {
            jJX.remove(eVar);
            jJX.addLast(eVar);
        }
    }
}
