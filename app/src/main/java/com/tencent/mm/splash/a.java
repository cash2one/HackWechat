package com.tencent.mm.splash;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.system.OsConstants;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.loader.stub.d;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.lang.reflect.Field;
import java.util.List;

public final class a {
    private static String xll;
    private static String xlm;
    private static File xln;
    private static long xlo;
    @SuppressLint({"HandlerLeak"})
    private static Handler xlp = new Handler(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            a aVar = (a) message.obj;
            if (a.chi()) {
                if (!a.fN(a.xlo)) {
                    a.b(aVar);
                    return;
                } else if (a.fe(e.xlz)) {
                    if (!a.fh(e.xlz)) {
                        e.chy().e(675, 18, 1);
                    }
                    e.chy().e(675, 17, 1);
                    aVar.chm();
                } else {
                    e.chy().e(675, 25, 1);
                    aVar.chl();
                    return;
                }
            } else if (!a.chj()) {
                e.chy().e(675, 15, 1);
                aVar.chl();
            } else if (a.fe(e.xlz)) {
                e.chy().e(675, 16, 1);
                aVar.buv();
            } else {
                e.chy().e(675, 26, 1);
                e.chy().e(675, 15, 1);
                aVar.chl();
            }
            a.xlo = 0;
        }
    };

    public interface a {
        void buv();

        void chl();

        void chm();
    }

    static /* synthetic */ boolean fN(long j) {
        return System.currentTimeMillis() - j > 180000;
    }

    public static void d(Application application) {
        xll = new File(application.getFilesDir(), "dexopt_service").getAbsolutePath();
    }

    public static String chh() {
        if (xll == null) {
            throw new IllegalStateException("data directory should not be null, give one.");
        }
        File file = new File(xll);
        if (!(file.exists() || file.mkdirs())) {
            e.a("WxSplash.DexOpt", "data directory create failed.", new Object[0]);
        }
        return xll;
    }

    public static boolean fe(Context context) {
        e.a("WxSplash.DexOpt", "if need dexopt %s", Boolean.valueOf(com.tencent.mm.f.a.ax(context)));
        return com.tencent.mm.f.a.ax(context);
    }

    public static void ff(Context context) {
        if (!com.tencent.mm.f.a.oG) {
            boolean ay;
            e.chy().e(675, 22, 1);
            try {
                ay = com.tencent.mm.f.a.ay(context);
            } catch (Throwable th) {
                e.a(th, "multidex install failed");
                ay = false;
            }
            e.a("WxSplash.DexOpt", "install multidex result %s", Boolean.valueOf(ay));
            if (!ay) {
                e.a("WxSplash.DexOpt", "install multidex failed, kill self.", new Object[0]);
                e.chs();
            }
        }
    }

    public static void fg(Context context) {
        e.a("WxSplash.DexOpt", "start dex opt service", new Object[0]);
        String r = d.r(context, Process.myPid());
        r.replace(':', '_');
        xlm = "DexOpt_Request_" + r;
        e.chy().e(675, 14, 1);
        try {
            Wn(xlm);
        } catch (Throwable e) {
            Throwable th = e;
            if (VERSION.SDK_INT <= 19 && th.getClass().getCanonicalName().equals("libcore.io.ErrnoException")) {
                try {
                    Field field = th.getClass().getField("errno");
                    field.setAccessible(true);
                    if (((Integer) field.get(th)).intValue() == OsConstants.ENOSPC) {
                        int i;
                        File file = new File(chh());
                        if (file.exists()) {
                            e.a("WxSplash.DexOpt", "check dexopt directory size %s.", Integer.valueOf(file.listFiles().length));
                            i = file.listFiles().length < 10000 ? 1 : 0;
                        } else {
                            i = 1;
                        }
                        if (i != 0) {
                            com.tencent.mm.f.a.aw(context);
                        } else {
                            e.a("WxSplash.DexOpt", "check dexopt directory size not ok, clean it and throw exception.", new Object[0]);
                            file = new File(chh());
                            if (file.exists()) {
                                b.h(file);
                            }
                        }
                    }
                } catch (Throwable e2) {
                    x.printErrStackTrace("WxSplash.DexOpt", e2, "", new Object[0]);
                }
            }
            throw new RuntimeException(th);
        }
        context.startService(new Intent(context, DexOptService.class));
    }

    private static synchronized void Wn(String str) {
        synchronized (a.class) {
            String chh = chh();
            File file = new File(chh);
            if (!file.exists()) {
                file.mkdirs();
            }
            file = new File(chh + "/" + str);
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            xln = file;
        }
    }

    private static boolean fh(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager != null) {
            List<RunningServiceInfo> runningServices = activityManager.getRunningServices(Integer.MAX_VALUE);
            if (runningServices == null) {
                e.a("WxSplash.DexOpt", "dexopt service may dead, get running services return null.", new Object[0]);
                return false;
            }
            for (RunningServiceInfo runningServiceInfo : runningServices) {
                if ("com.tencent.mm.splash.DexOptService".equals(runningServiceInfo.service.getClassName())) {
                    return true;
                }
            }
        }
        e.a("WxSplash.DexOpt", "dexopt service may dead", new Object[0]);
        return false;
    }

    public static boolean fi(Context context) {
        long j = 0;
        long currentTimeMillis = System.currentTimeMillis();
        e.a("WxSplash.DexOpt", "block checking dex opt result.", new Object[0]);
        while (chi()) {
            j++;
            Thread.sleep(100);
            if (j >= 5) {
                j = 0;
                if (System.currentTimeMillis() - currentTimeMillis > 180000) {
                    e.a("WxSplash.DexOpt", "block checking dex opt timeout.", new Object[0]);
                    if (fe(context)) {
                        if (!fh(context)) {
                            e.chy().e(675, 18, 1);
                        }
                        e.chy().e(675, 17, 1);
                        return false;
                    }
                    e.chy().e(675, 25, 1);
                    e.chy().e(675, 15, 1);
                    return true;
                }
            }
        }
        if (!chj()) {
            e.chy().e(675, 15, 1);
            return true;
        } else if (fe(context)) {
            e.chy().e(675, 16, 1);
            return false;
        } else {
            e.chy().e(675, 26, 1);
            e.chy().e(675, 15, 1);
            return true;
        }
    }

    public static void a(a aVar) {
        b(aVar);
    }

    private static void b(a aVar) {
        if (xlo == 0) {
            xlo = System.currentTimeMillis();
        }
        Message obtain = Message.obtain();
        obtain.what = 0;
        obtain.obj = aVar;
        xlp.sendMessageDelayed(obtain, 100);
    }

    private static boolean chi() {
        if (xln != null) {
            return xln.exists();
        }
        throw new IllegalStateException("tmp file field should not be null");
    }

    private static boolean chj() {
        return new File(chh() + "/DexOpt_Failed").exists();
    }
}
