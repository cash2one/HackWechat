package com.tencent.mm.splash;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.app.Instrumentation;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.splash.a.a;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class e {
    static c xlA;
    private static Set<SplashActivity> xlB = new HashSet();
    private static boolean xlC = false;
    private static volatile boolean xlD = false;
    private static boolean xlE = false;
    private static k xlF;
    private static boolean xlG = false;
    static b xlH;
    private static Class<? extends SplashActivity> xlI;
    private static Class<? extends Activity> xlJ;
    private static j xlK = new j();
    private static boolean xlL = false;
    @SuppressLint({"HandlerLeak"})
    private static Handler xlM = new Handler(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 0) {
                e.chw();
                return;
            }
            a.fg(e.xlz);
            a.a(new a(this) {
                final /* synthetic */ AnonymousClass3 xlO;

                {
                    this.xlO = r1;
                }

                public final void chl() {
                    e.chw();
                }

                public final void buv() {
                    e.a("WxSplash.Splash", "dexopt service return failed. kill self.", new Object[0]);
                    e.chs();
                }

                public final void chm() {
                    e.a("WxSplash.Splash", "dexopt service return timeout. kill self.", new Object[0]);
                    e.chs();
                }
            });
        }
    };
    public static final ArrayList<f> xlx = new ArrayList();
    public static final ArrayList<Message> xly = new ArrayList();
    static Application xlz;

    static /* synthetic */ void ajM() {
        xlD = true;
        a("WxSplash.Splash", "pending early replay %s", Boolean.valueOf(xlD));
        chu();
    }

    static /* synthetic */ void uc() {
        boolean z = true;
        try {
            Object cc = cc(xlz);
            String str = "WxSplash.Splash";
            String str2 = "spy, activityThread %s";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(cc == i.xmh);
            a(str, str2, objArr);
            Field declaredField = cc.getClass().getDeclaredField("mH");
            declaredField.setAccessible(true);
            Handler handler = (Handler) declaredField.get(cc);
            str = "WxSplash.Splash";
            str2 = "spy, ActivityThread_mH %s";
            objArr = new Object[1];
            objArr[0] = Boolean.valueOf(handler == i.xmi);
            a(str, str2, objArr);
            Field declaredField2 = Handler.class.getDeclaredField("mCallback");
            declaredField2.setAccessible(true);
            Callback callback = (Callback) declaredField2.get(handler);
            String str3 = "WxSplash.Splash";
            str = "spy, callback %s %s";
            Object[] objArr2 = new Object[2];
            if (callback != i.xmn) {
                z = false;
            }
            objArr2[0] = Boolean.valueOf(z);
            objArr2[1] = callback;
            a(str3, str, objArr2);
        } catch (Throwable e) {
            a(e, "spy failed.");
        }
    }

    static void a(SplashActivity splashActivity) {
        xlB.add(splashActivity);
    }

    static void b(SplashActivity splashActivity) {
        xlB.remove(splashActivity);
    }

    public static String U(Activity activity) {
        if (activity instanceof f) {
            return ((f) activity).xlS;
        }
        return "";
    }

    public static void a(k kVar) {
        xlF = kVar;
    }

    public static void E(Class<? extends SplashActivity> cls) {
        xlI = cls;
    }

    public static void F(Class<? extends Activity> cls) {
        xlJ = cls;
    }

    public static void a(b bVar) {
        xlH = bVar;
    }

    public static void a(c cVar) {
        xlA = cVar;
    }

    public static void fk(Context context) {
        Object obj = 1;
        try {
            ComponentName fc = bh.fc(ac.getContext());
            if (fc != null && fc.getPackageName().equals(ac.getPackageName()) && fc.getClassName().equals(ac.cfq())) {
                a("WxSplash.Splash", "it is LauncherUI", new Object[0]);
            } else if (fc == null || !fc.getPackageName().startsWith("com.excelliance")) {
                obj = null;
            } else {
                a("WxSplash.Splash", "it is dual open", new Object[0]);
            }
            if (obj == null) {
                a("WxSplash.Splash", "do nothing and return.", new Object[0]);
                return;
            }
            xlK.e(675, 36, 1);
            String chh = a.chh();
            File file = new File(chh);
            if (!file.exists()) {
                file.mkdirs();
            }
            file = new File(chh + "/main-process-blocking");
            if (file.exists()) {
                file.delete();
            }
            if (file.createNewFile()) {
                Intent intent = new Intent(context, xlJ);
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                context.startActivity(intent);
            }
        } catch (Throwable e) {
            a(e, "request fig leaf failed.");
        }
    }

    public static synchronized boolean e(Application application) {
        boolean z;
        synchronized (e.class) {
            if (xlE) {
                a("WxSplash.Splash", "Splash has hacked before.", new Object[0]);
                z = true;
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                xlz = application;
                xlK.e(675, 4, 1);
                try {
                    Class cls = Class.forName("android.app.ActivityManagerNative");
                    Method declaredMethod = cls.getDeclaredMethod("getDefault", new Class[0]);
                    declaredMethod.setAccessible(true);
                    Object invoke = declaredMethod.invoke(cls, new Object[0]);
                    if (invoke != null) {
                        a("WxSplash.Splash", "getDefault %s", invoke);
                        if (invoke.getClass().getCanonicalName().startsWith("com.morgoo.droidplugin")) {
                            xlK.e(675, 33, 1);
                            a("WxSplash.Splash", "found using droidplugin", new Object[0]);
                        }
                        if (Proxy.isProxyClass(invoke.getClass())) {
                            a("WxSplash.Splash", "found ActivityManager is a Proxy class, " + invoke.getClass(), new Object[0]);
                        }
                    }
                    try {
                        String canonicalName;
                        Object obj;
                        RuntimeException runtimeException;
                        int[] iArr;
                        Field declaredField;
                        Handler handler;
                        Field declaredField2;
                        Callback callback;
                        g gVar;
                        Method declaredMethod2;
                        Field declaredField3;
                        Object cc = cc(application);
                        Field declaredField4 = cc.getClass().getDeclaredField("mInstrumentation");
                        declaredField4.setAccessible(true);
                        Instrumentation instrumentation = (Instrumentation) declaredField4.get(cc);
                        if (Object.class != instrumentation.getClass().getSuperclass()) {
                            canonicalName = instrumentation.getClass().getCanonicalName();
                            if (canonicalName.startsWith("android.support.test") || canonicalName.startsWith("android.test")) {
                                a("WxSplash.Splash", "android instrument test is running, do not need splash.", new Object[0]);
                                obj = 1;
                                if (obj != null) {
                                    z = false;
                                } else if (instrumentation == null) {
                                    throw new NullPointerException("Instrumentation original should not be null.");
                                } else if (Object.class == instrumentation.getClass().getSuperclass()) {
                                    xlK.e(675, 7, 1);
                                    a("WxSplash.Splash", "Instrumentation original's super class is not Object, maybe hacked by others. orig: %s, super: %s.", instrumentation.getClass(), instrumentation.getClass().getSuperclass());
                                    canonicalName = instrumentation.getClass().getCanonicalName();
                                    runtimeException = new RuntimeException("invalid environment for hack, " + instrumentation.getClass());
                                    iArr = new int[]{40, 41, 42, 43, 44, 45, 46};
                                    if (canonicalName.startsWith(new String[]{"com.excelliance", "com.lbe", "com.beike", "com.lody", "com.doubleagent", "com.svm", "com.morgoo"}[0])) {
                                        xlK.e(675, 30, 1);
                                        a("WxSplash.Splash", "invalid environment for hack, dual open.", new Object[0]);
                                    }
                                    xlK.e(675, 0, 1);
                                    throw runtimeException;
                                } else {
                                    if (instrumentation instanceof h) {
                                        declaredField4.set(cc, new h(instrumentation));
                                    } else {
                                        a("WxSplash.Splash", "instrumentation is splash hacked, why? failed before?", new Object[0]);
                                    }
                                    i.xmh = cc;
                                    declaredField = cc.getClass().getDeclaredField("mH");
                                    declaredField.setAccessible(true);
                                    handler = (Handler) declaredField.get(cc);
                                    if (handler != null) {
                                        throw new RuntimeException("mH is null!");
                                    }
                                    i.xmi = handler;
                                    declaredField2 = Handler.class.getDeclaredField("mCallback");
                                    declaredField2.setAccessible(true);
                                    callback = (Callback) declaredField2.get(handler);
                                    i.xmo = declaredField2;
                                    if (callback != null) {
                                        a("WxSplash.Splash", "Handler.Callback original is not null, maybe hacked by others. orig: %s", callback);
                                        xlK.e(675, 8, 1);
                                    }
                                    if (callback == null && (callback instanceof g)) {
                                        a("WxSplash.Splash", "callback is splash hacked, why? failed before?", new Object[0]);
                                    } else {
                                        gVar = new g(application, callback);
                                        declaredField2.setAccessible(true);
                                        declaredField2.set(handler, gVar);
                                        i.xmn = gVar;
                                    }
                                    handler = new Handler();
                                    g.Y(new Runnable() {
                                        public final void run() {
                                            e.xlL = true;
                                            handler.removeCallbacksAndMessages(null);
                                            e.a("WxSplash.Splash", "verify mH callback hack, result ok.", new Object[0]);
                                        }
                                    });
                                    i.xmi.sendEmptyMessage(987654321);
                                    handler.postDelayed(new Runnable() {
                                        public final void run() {
                                            if (!e.xlL) {
                                                e.a("WxSplash.Splash", "verify mH callback hack, result failed!.", new Object[0]);
                                                e.chy().e(675, 32, 1);
                                                e.uc();
                                            }
                                        }
                                    }, 2000);
                                    if (!com.tencent.mm.f.a.oG) {
                                        declaredMethod2 = cc.getClass().getDeclaredMethod("installContentProviders", new Class[]{Context.class, List.class});
                                        declaredMethod2.setAccessible(true);
                                        i.xmm = declaredMethod2;
                                        declaredField = cc.getClass().getDeclaredField("mBoundApplication");
                                        declaredField.setAccessible(true);
                                        invoke = declaredField.get(cc);
                                        i.xmj = invoke;
                                        declaredField3 = invoke.getClass().getDeclaredField("restrictedBackupMode");
                                        declaredField3.setAccessible(true);
                                        declaredField3.set(invoke, Boolean.valueOf(true));
                                        declaredField3 = invoke.getClass().getDeclaredField("providers");
                                        declaredField3.setAccessible(true);
                                        i.xml = (List) declaredField3.get(invoke);
                                    }
                                    xlE = true;
                                    xlC = true;
                                    a("WxSplash.Splash", "splash hack success.", new Object[0]);
                                    a("WxSplash.Splash", "we need splash. time spent %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                                    z = true;
                                }
                            }
                        }
                        obj = null;
                        if (obj != null) {
                            z = false;
                        } else if (instrumentation == null) {
                            throw new NullPointerException("Instrumentation original should not be null.");
                        } else if (Object.class == instrumentation.getClass().getSuperclass()) {
                            if (instrumentation instanceof h) {
                                a("WxSplash.Splash", "instrumentation is splash hacked, why? failed before?", new Object[0]);
                            } else {
                                declaredField4.set(cc, new h(instrumentation));
                            }
                            i.xmh = cc;
                            declaredField = cc.getClass().getDeclaredField("mH");
                            declaredField.setAccessible(true);
                            handler = (Handler) declaredField.get(cc);
                            if (handler != null) {
                                i.xmi = handler;
                                declaredField2 = Handler.class.getDeclaredField("mCallback");
                                declaredField2.setAccessible(true);
                                callback = (Callback) declaredField2.get(handler);
                                i.xmo = declaredField2;
                                if (callback != null) {
                                    a("WxSplash.Splash", "Handler.Callback original is not null, maybe hacked by others. orig: %s", callback);
                                    xlK.e(675, 8, 1);
                                }
                                if (callback == null) {
                                }
                                gVar = new g(application, callback);
                                declaredField2.setAccessible(true);
                                declaredField2.set(handler, gVar);
                                i.xmn = gVar;
                                handler = new Handler();
                                g.Y(/* anonymous class already generated */);
                                i.xmi.sendEmptyMessage(987654321);
                                handler.postDelayed(/* anonymous class already generated */, 2000);
                                if (com.tencent.mm.f.a.oG) {
                                    declaredMethod2 = cc.getClass().getDeclaredMethod("installContentProviders", new Class[]{Context.class, List.class});
                                    declaredMethod2.setAccessible(true);
                                    i.xmm = declaredMethod2;
                                    declaredField = cc.getClass().getDeclaredField("mBoundApplication");
                                    declaredField.setAccessible(true);
                                    invoke = declaredField.get(cc);
                                    i.xmj = invoke;
                                    declaredField3 = invoke.getClass().getDeclaredField("restrictedBackupMode");
                                    declaredField3.setAccessible(true);
                                    declaredField3.set(invoke, Boolean.valueOf(true));
                                    declaredField3 = invoke.getClass().getDeclaredField("providers");
                                    declaredField3.setAccessible(true);
                                    i.xml = (List) declaredField3.get(invoke);
                                }
                                xlE = true;
                                xlC = true;
                                a("WxSplash.Splash", "splash hack success.", new Object[0]);
                                a("WxSplash.Splash", "we need splash. time spent %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                                z = true;
                            } else {
                                throw new RuntimeException("mH is null!");
                            }
                        } else {
                            xlK.e(675, 7, 1);
                            a("WxSplash.Splash", "Instrumentation original's super class is not Object, maybe hacked by others. orig: %s, super: %s.", instrumentation.getClass(), instrumentation.getClass().getSuperclass());
                            canonicalName = instrumentation.getClass().getCanonicalName();
                            runtimeException = new RuntimeException("invalid environment for hack, " + instrumentation.getClass());
                            iArr = new int[]{40, 41, 42, 43, 44, 45, 46};
                            if (canonicalName.startsWith(new String[]{"com.excelliance", "com.lbe", "com.beike", "com.lody", "com.doubleagent", "com.svm", "com.morgoo"}[0])) {
                                xlK.e(675, 30, 1);
                                a("WxSplash.Splash", "invalid environment for hack, dual open.", new Object[0]);
                            }
                            xlK.e(675, 0, 1);
                            throw runtimeException;
                        }
                    } catch (Throwable e) {
                        a(e, "splash hack error!");
                        z = false;
                    }
                } catch (Throwable e2) {
                    a(e2, "validateEnvironment found some thing.");
                }
            }
        }
        return z;
    }

    public static void cho() {
        boolean z = true;
        if (xlE) {
            try {
                Callback callback = (Callback) i.xmo.get(i.xmi);
                String str = "WxSplash.Splash";
                String str2 = "double check, callback %s %s";
                Object[] objArr = new Object[2];
                if (callback != i.xmn) {
                    z = false;
                }
                objArr[0] = Boolean.valueOf(z);
                objArr[1] = callback;
                a(str, str2, objArr);
                if (callback != i.xmn) {
                    a("WxSplash.Splash", "double check found problem!", new Object[0]);
                    Field field = i.xmo;
                    i.xmn.oTm = callback;
                    field.setAccessible(true);
                    field.set(i.xmi, i.xmn);
                    xlK.e(675, 31, 1);
                    i.xmi.sendEmptyMessage(987654321);
                }
            } catch (Throwable e) {
                a(e, "double check exception.");
            }
        }
    }

    public static boolean chp() {
        return true;
    }

    public static boolean chq() {
        if (xlC) {
            return true;
        }
        return false;
    }

    public static boolean chr() {
        return xlD;
    }

    public static void chs() {
        Process.killProcess(Process.myPid());
    }

    public static void cht() {
        if (com.tencent.mm.f.a.oG) {
            xlM.sendEmptyMessage(0);
        } else {
            xlM.postDelayed(new Runnable() {
                public final void run() {
                    com.tencent.mm.sdk.f.e.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass4 xlP;

                        {
                            this.xlP = r1;
                        }

                        public final void run() {
                            e.xlM.sendEmptyMessage(a.fe(e.xlz) ? 1 : 0);
                        }
                    }, "checking-need-dexopt");
                }
            }, 150);
        }
    }

    private static void chu() {
        a("WxSplash.Splash", "Gonna replay %s pending message(s).", Integer.valueOf(xly.size()));
        Iterator it = xly.iterator();
        while (it.hasNext()) {
            i.xmi.sendMessage((Message) it.next());
        }
        xly.clear();
    }

    private static void chv() {
        a("WxSplash.Splash", "splash done, do finally things. ", new Object[0]);
        xlC = false;
        for (SplashActivity splashActivity : xlB) {
            a("WxSplash.Splash", "iterate splash activity %s.", splashActivity);
            splashActivity.chC();
        }
        a("WxSplash.Splash", "resend all %s pending message. ", Integer.valueOf(xly.size()));
        if (!xlD) {
            chu();
        }
        xlF = null;
        a("WxSplash.Splash", "we need splash no more.", new Object[0]);
        synchronized (e.class) {
            xlG = false;
        }
        j jVar = xlK;
        if (jVar.mStartTimestamp > 0) {
            long currentTimeMillis = System.currentTimeMillis() - jVar.mStartTimestamp;
            if (com.tencent.mm.f.a.oG) {
                jVar.e(676, 1, 1);
                jVar.e(676, 3, currentTimeMillis);
                return;
            }
            jVar.e(676, 0, 1);
            jVar.e(676, 2, currentTimeMillis);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized void chw() {
        synchronized (e.class) {
            a.ff(xlz);
            synchronized (e.class) {
                if (xlG) {
                } else {
                    xlG = true;
                    if (!xlE) {
                        a("WxSplash.Splash", "not hacked, return.", new Object[0]);
                    } else if (com.tencent.mm.f.a.oG) {
                        a("WxSplash.Splash", "not hack content provider, return.", new Object[0]);
                    } else if (!(i.xml == null || i.xml.size() == 0)) {
                        xlK.e(675, 10, 1);
                        Object obj = i.xmh;
                        Field declaredField = obj.getClass().getDeclaredField("mInitialApplication");
                        declaredField.setAccessible(true);
                        Object obj2 = declaredField.get(obj);
                        i.xmk = (Application) obj2;
                        if (obj2 == null) {
                            a("WxSplash.Splash", "mInitialApplication is null, use mine. ", new Object[0]);
                            obj2 = xlz;
                        }
                        try {
                            Class.forName("com.tencent.mm.plugin.base.stub.WXCommProvider");
                            Class.forName("com.tencent.mm.plugin.base.stub.WXCommProvider$1");
                            a("WxSplash.Splash", "WXCommProvider is ok", new Object[0]);
                            a("WxSplash.Splash", "before delay install ContentProviders. ", new Object[0]);
                            i.xmm.invoke(obj, new Object[]{obj2, i.xml});
                            a("WxSplash.Splash", "delay install ContentProviders. ", new Object[0]);
                            i.xml.clear();
                        } catch (Throwable e) {
                            xlK.e(675, 11, 1);
                            a(e, "install provider failed!");
                        }
                    }
                    if (xlF == null) {
                        chv();
                    } else {
                        xlF.b(new k.a() {
                            public final void chA() {
                                e.ajM();
                            }

                            public final void done() {
                                e.a("WxSplash.Splash", "told me done.", new Object[0]);
                                e.chv();
                            }
                        });
                    }
                }
            }
        }
    }

    public static Class<? extends Activity> chx() {
        return xlI;
    }

    private static Object cc(Context context) {
        Method method = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]);
        method.setAccessible(true);
        Object invoke = method.invoke(null, new Object[0]);
        if (invoke != null) {
            return invoke;
        }
        Field field = context.getClass().getField("mLoadedApk");
        field.setAccessible(true);
        invoke = field.get(context);
        Field declaredField = invoke.getClass().getDeclaredField("mActivityThread");
        declaredField.setAccessible(true);
        return declaredField.get(invoke);
    }

    public static void a(String str, String str2, Object... objArr) {
        if (xlH != null) {
            xlH.a(str, str2, objArr);
        }
    }

    public static void a(Throwable th, String str) {
        if (xlH != null) {
            xlH.a(th, str);
        }
    }

    public static j chy() {
        return xlK;
    }
}
