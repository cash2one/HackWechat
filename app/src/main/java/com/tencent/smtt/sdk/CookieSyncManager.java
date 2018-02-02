package com.tencent.smtt.sdk;

import android.content.Context;
import java.lang.reflect.Field;

public class CookieSyncManager {
    private static android.webkit.CookieSyncManager zVi;
    private static CookieSyncManager zVj;
    private static boolean zVk = false;

    private CookieSyncManager(Context context) {
        af cFg = af.cFg();
        if (cFg != null && cFg.cFh()) {
            cFg.cFi().zZb.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_createInstance", new Class[]{Context.class}, new Object[]{context});
            zVk = true;
        }
    }

    public static synchronized CookieSyncManager createInstance(Context context) {
        CookieSyncManager cookieSyncManager;
        synchronized (CookieSyncManager.class) {
            zVi = android.webkit.CookieSyncManager.createInstance(context);
            if (zVj == null || !zVk) {
                zVj = new CookieSyncManager(context.getApplicationContext());
            }
            cookieSyncManager = zVj;
        }
        return cookieSyncManager;
    }

    public static synchronized CookieSyncManager getInstance() {
        CookieSyncManager cookieSyncManager;
        synchronized (CookieSyncManager.class) {
            if (zVj == null) {
                throw new IllegalStateException("CookieSyncManager::createInstance() needs to be called before CookieSyncManager::getInstance()");
            }
            cookieSyncManager = zVj;
        }
        return cookieSyncManager;
    }

    public void startSync() {
        af cFg = af.cFg();
        if (cFg == null || !cFg.cFh()) {
            zVi.startSync();
            try {
                Field declaredField = Class.forName("android.webkit.WebSyncManager").getDeclaredField("mSyncThread");
                declaredField.setAccessible(true);
                ((Thread) declaredField.get(zVi)).setUncaughtExceptionHandler(new SQLiteUncaughtExceptionHandler());
                return;
            } catch (Exception e) {
                return;
            }
        }
        cFg.cFi().zZb.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_startSync", new Class[0], new Object[0]);
    }

    public void stopSync() {
        af cFg = af.cFg();
        if (cFg == null || !cFg.cFh()) {
            zVi.stopSync();
        } else {
            cFg.cFi().zZb.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_stopSync", new Class[0], new Object[0]);
        }
    }

    public void sync() {
        af cFg = af.cFg();
        if (cFg == null || !cFg.cFh()) {
            zVi.sync();
        } else {
            cFg.cFi().zZb.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_Sync", new Class[0], new Object[0]);
        }
    }
}
