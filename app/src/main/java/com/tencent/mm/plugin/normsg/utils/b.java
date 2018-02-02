package com.tencent.mm.plugin.normsg.utils;

import android.content.Context;
import android.os.Binder;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.RemoteException;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import com.tencent.mm.sdk.platformtools.x;
import java.io.FileDescriptor;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class b {
    private static final ClassLoader oSD = b.class.getClassLoader();
    private static final String oSE = c.GG("\u001f~\u0010t\u0006i\u0000dJ<U0Gi\bk\bm\u001em\u0004f\u000fc\n~\u0007)`!B!D7D-O&J#W.c\u0002l\rj\u000f}Y\n~\u000bi");
    private static final String oSF = c.GG("\u0011p\u001ez\bg\u000ejD+Xv%@2D-N+f\u0007i\bo\nx");
    private static final String oSG = c.GG("\u0007t7V5]8");
    private static final String oSH = c.GG("\u0017v\u0005L\"V3A'F%@");
    private static final String oSI = c.GG("\ng$E)E'F%N");
    private static final String oSJ = c.GG("\u000ec5\\9N\u001cs\u001ch!L<P");
    private static final String oSK = c.GG("Ñ°ÞºÈ§Îªòþ§Æ¥Æ£Ð£Ê¨Á­Ä°Éç®ïïùãèíà©Ç³Ö¤Å¦Ò»Ôºùøóäâ");
    private static final String oSL = c.GG("Ù¸Ü¸ùùïõþûö¿Ñ¥À²Ó°Ä­Â¬ïîåòô");
    private static final String oSM = c.GG("éëÞ½Þ»È»Ò°ÙµÜ¨ÑöçôãåÈ§É½Ï Ì Å·");
    private static final String oSN = c.GG("\u001ak\u001e{\tp<S0Q=t\u001an\u000by\u001f~\u001dx");
    private static final String oSO = c.GG("?Y0^:l\u0005`\u0017U,m\u000em\b{\ba\u0003j\u0006o\u001bb+O");
    private static final String oSP = c.GG("+M$J.o\fo\ny\nc\u0001h\u0004m\u0019`.A%@\tg\u0001n,U\u0014w\u0014q\u0002q\u0018z\u0013\u0016b\u001bR6");
    private static final String oSQ = c.GG("!G.@$e\u0006e\u0000s\u0000i\u000bb\u000eg\u0013j$K/J\u0003m\u000bd&_\t`\u0005r;_");
    private static final String oSR = c.GG("÷ðÕ¶Õ°Ã°Ù»Ò¾×£Úûú³Ý»Ô§åÊ£Æ±ø");
    private static final String oSS = c.GG("±×¾Ð´õõãùò÷ú´Û¿ÚýôÅ¼èõ");
    private static final String oST = c.GG("\rk\u0002l\bN!B7D");
    private static final String oSU = c.GG("\"D+H=N\u001dx\u0019k\b`");
    private static final String oSV = c.GG("m\u001dx\nl\u0003q\u001c]>]8K8Q3Z6_+R\u0013p\u0004m\u0002l");
    private static final String oSW = c.GG("Ì¿Ú®èïÊ©Ê¯Ü¯Æ¤Í¡È¼Åäå¬Â¤Ëüúâ");
    private static final String oSX = c.GG("¬ßºÎáëªÉªÏ¼Ï¦Ä­Á¨Ü¥ëàÌ¢Ä«Øïéñ");
    private static final String oSY = c.GG("îøÜ¹Ë­Â°Ýÿùùò÷êÒ±Å¬Ã­ÿéð");
    private volatile boolean gSX;
    public final Queue<g> oSZ;
    private final Map<Object, IBinder> oTa;
    private final Map<IBinder, Integer> oTb;
    private final Handler oTc;
    private IInterface oTd;

    private final class b implements Callback {
        final /* synthetic */ b oTi;
        private final WeakReference<Object> oTl;
        private final Callback oTm;

        b(b bVar, Object obj, Callback callback) {
            this.oTi = bVar;
            this.oTl = new WeakReference(obj);
            this.oTm = callback;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean handleMessage(Message message) {
            Object obj = this.oTl.get();
            if (obj == null) {
                x.e("MicroMsg.AED", "lost viewRootImpl instance, give up intercepting.");
                return o(message);
            }
            try {
                View view = (View) g.a(obj, "getView", null, new Object[0]);
                if (view == null) {
                    x.e("MicroMsg.AED", "cannot find root view, give up intercepting.");
                    return o(message);
                }
                IInterface iInterface;
                switch (message.what) {
                    case 1:
                    case 2:
                    case 3:
                    case 5:
                    case 6:
                    case 1020:
                        iInterface = (IInterface) g.e(message.obj, "arg1");
                        break;
                    case 4:
                    case 1023:
                        iInterface = (IInterface) g.e(message.obj, "arg2");
                        break;
                    case 1021:
                    case 1022:
                        iInterface = (IInterface) message.obj;
                        break;
                    default:
                        iInterface = null;
                        break;
                }
                if (iInterface == null) {
                    x.w("MicroMsg.AED", "callback is null, give up intercepting, op: %s", new Object[]{Integer.valueOf(message.what)});
                    return o(message);
                } else if (Proxy.isProxyClass(iInterface.getClass()) && (Proxy.getInvocationHandler(iInterface) instanceof e)) {
                    x.w("MicroMsg.AED", "reused callback, skip rest works.");
                    return o(message);
                } else {
                    int i;
                    View view2;
                    int intValue;
                    switch (message.what) {
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 1020:
                        case 1021:
                        case 1023:
                            switch (message.what) {
                                case 1:
                                case 3:
                                case 6:
                                    i = message.arg2;
                                    break;
                                case 2:
                                case 4:
                                case 1020:
                                case 1023:
                                    i = ((Integer) g.e(message.obj, "argi1")).intValue();
                                    break;
                                case 5:
                                    i = ((Integer) g.e(message.obj, "argi2")).intValue();
                                    break;
                                case 1021:
                                    i = message.arg1;
                                    break;
                                default:
                                    i = 0;
                                    break;
                            }
                            view2 = (View) g.a(view, b.oSO, g.b(new Class[]{Integer.TYPE}), new Object[]{Integer.valueOf(i)});
                            break;
                        case 1022:
                            if (message.what == 1022) {
                                i = message.arg1;
                            } else {
                                i = 0;
                            }
                            view2 = view.findViewById(i);
                            break;
                        default:
                            view2 = null;
                            break;
                    }
                    switch (message.what) {
                        case 1:
                        case 2:
                        case 4:
                        case 6:
                        case 1020:
                            intValue = ((Integer) g.e(message.obj, "argi3")).intValue();
                            break;
                        case 3:
                        case 5:
                            intValue = ((Integer) g.e(message.obj, "argi1")).intValue();
                            break;
                        case 1021:
                        case 1022:
                            intValue = message.arg2;
                            break;
                        case 1023:
                            intValue = ((Integer) g.e(message.obj, "argi2")).intValue();
                            break;
                        default:
                            intValue = 0;
                            break;
                    }
                    final Integer num = (Integer) this.oTi.oTb.remove(iInterface.asBinder());
                    if (num == null) {
                        x.w("MicroMsg.AED", "callback %s's binder is unmarked, give up intercept.", new Object[]{iInterface.getClass().getName()});
                        return o(message);
                    }
                    switch (message.what) {
                        case 1:
                        case 1020:
                            switch (message.what) {
                                case 1:
                                case 1020:
                                    i = ((Integer) g.e(message.obj, "argi2")).intValue();
                                    break;
                                default:
                                    i = 0;
                                    break;
                            }
                            if (!this.oTi.b(i, num.intValue(), view2)) {
                                g.a(iInterface, b.oSY, g.b(new Class[]{Boolean.TYPE, Integer.TYPE}), new Object[]{Boolean.valueOf(false), Integer.valueOf(intValue)});
                                return true;
                            }
                            break;
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 1021:
                        case 1022:
                        case 1023:
                            IInterface iInterface2 = (IInterface) Proxy.newProxyInstance(b.oSD, iInterface.getClass().getInterfaces(), new e(this, iInterface) {
                                final /* synthetic */ b oTp;

                                public final Object invoke(Object obj, Method method, Object[] objArr) {
                                    String name = method.getName();
                                    if (b.oSW.equals(name)) {
                                        List arrayList = new ArrayList();
                                        if (objArr[0] != null) {
                                            arrayList.add((AccessibilityNodeInfo) objArr[0]);
                                        }
                                        b.a(this.oTp.oTi, num.intValue(), view2, arrayList);
                                        if (arrayList.isEmpty()) {
                                            objArr[0] = null;
                                        } else {
                                            objArr[0] = arrayList.get(0);
                                        }
                                    } else if (b.oSX.equals(name)) {
                                        List list = (List) objArr[0];
                                        if (list == null) {
                                            list = new ArrayList();
                                        }
                                        b.a(this.oTp.oTi, num.intValue(), view2, list);
                                    }
                                    return super.invoke(obj, method, objArr);
                                }
                            });
                            switch (message.what) {
                                case 1:
                                case 2:
                                case 3:
                                case 5:
                                case 6:
                                case 1020:
                                    g.a(message.obj, "arg1", iInterface2);
                                    break;
                                case 4:
                                case 1023:
                                    g.a(message.obj, "arg2", iInterface2);
                                    break;
                                case 1021:
                                case 1022:
                                    message.obj = iInterface2;
                                    break;
                                default:
                                    break;
                            }
                    }
                    return o(message);
                }
            } catch (Throwable th) {
                b.a(this.oTi, th);
            }
        }

        private boolean o(Message message) {
            if (this.oTm != null) {
                return this.oTm.handleMessage(message);
            }
            return false;
        }
    }

    private class d extends Binder {
        final /* synthetic */ b oTi;
        protected final IBinder oTs;

        d(b bVar, IBinder iBinder) {
            this.oTi = bVar;
            this.oTs = iBinder;
        }

        public String getInterfaceDescriptor() {
            try {
                return this.oTs.getInterfaceDescriptor();
            } catch (RemoteException e) {
                return "<failure>";
            }
        }

        public boolean pingBinder() {
            return this.oTs.pingBinder();
        }

        public boolean isBinderAlive() {
            return this.oTs.isBinderAlive();
        }

        public IInterface queryLocalInterface(String str) {
            return null;
        }

        public void dump(FileDescriptor fileDescriptor, String[] strArr) {
            try {
                this.oTs.dump(fileDescriptor, strArr);
            } catch (RemoteException e) {
            }
        }

        public void dumpAsync(FileDescriptor fileDescriptor, String[] strArr) {
            try {
                this.oTs.dumpAsync(fileDescriptor, strArr);
            } catch (RemoteException e) {
            }
        }

        protected boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            boolean z = false;
            try {
                if (this.oTs.isBinderAlive()) {
                    z = this.oTs.transact(i, parcel, parcel2, i2);
                }
            } catch (RemoteException e) {
                throw e;
            } catch (Throwable th) {
                b.a(this.oTi, th);
            }
            return z;
        }

        public void linkToDeath(DeathRecipient deathRecipient, int i) {
            try {
                this.oTs.linkToDeath(deathRecipient, i);
            } catch (RemoteException e) {
                deathRecipient.binderDied();
            }
        }

        public boolean unlinkToDeath(DeathRecipient deathRecipient, int i) {
            return this.oTs.unlinkToDeath(deathRecipient, i);
        }
    }

    static /* synthetic */ void a(b bVar, int i, View view, List list) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            bVar.b(i, view, list);
            return;
        }
        Object obj = new boolean[]{null};
        bVar.oTc.post(new 1(bVar, i, view, list, obj));
        synchronized (obj) {
            while (!obj[0]) {
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                }
            }
        }
    }

    static /* synthetic */ void a(b bVar, Throwable th) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            bVar.h(th);
            return;
        }
        Object obj = new boolean[]{null};
        bVar.oTc.post(new 3(bVar, th, obj));
        synchronized (obj) {
            while (!obj[0]) {
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                }
            }
        }
    }

    static /* synthetic */ Object b(Method method) {
        Class returnType = method.getReturnType();
        if (returnType.isPrimitive()) {
            return Boolean.TYPE.isAssignableFrom(returnType) ? Boolean.valueOf(false) : Integer.valueOf(0);
        } else {
            if (Number.class.isAssignableFrom(returnType)) {
                return Integer.valueOf(0);
            }
            if (Character.class.isAssignableFrom(returnType)) {
                return Character.valueOf('\u0000');
            }
            return Boolean.class.isAssignableFrom(returnType) ? Boolean.valueOf(false) : null;
        }
    }

    public static b bfR() {
        return h.oTu;
    }

    public final synchronized void initialize(Context context) {
        f fVar;
        if (!this.gSX) {
            if (VERSION.SDK_INT < 15) {
                throw new f("unsupported system, api: " + VERSION.SDK_INT);
            }
            try {
                IBinder iBinder = (IBinder) g.a(oSF, "getService", g.b(new Class[]{String.class}), new Object[]{"accessibility"});
                IInterface iInterface = (IInterface) g.a(oSE, oSH, g.b(new Class[]{IBinder.class}), new Object[]{iBinder});
                this.oTd = (IInterface) Proxy.newProxyInstance(oSD, iInterface.getClass().getInterfaces(), new c(this, iInterface));
                ((Map) g.dE(oSF, oSG)).put("accessibility", this.oTd.asBinder());
                try {
                    Object e;
                    Object a = g.a(AccessibilityManager.class, "getInstance", g.b(new Class[]{Context.class}), new Object[]{context});
                    try {
                        e = g.e(a, "mLock");
                    } catch (Throwable th) {
                        e = null;
                    }
                    if (e != null) {
                        synchronized (e) {
                            g.a(a, "mService", this.oTd);
                        }
                    } else {
                        g.a(a, "mService", this.oTd);
                    }
                    this.gSX = true;
                } catch (Throwable th2) {
                    fVar = new f(th2);
                }
            } catch (Throwable th22) {
                fVar = new f(th22);
            }
        }
    }

    public final synchronized void El() {
        if (!this.gSX) {
            throw new IllegalStateException("you must call initialize first.");
        }
    }

    private void b(int i, View view, List<AccessibilityNodeInfo> list) {
        for (g a : this.oSZ) {
            a.a(i, view, list);
        }
    }

    private boolean b(int i, int i2, View view) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return c(i, i2, view);
        }
        final Object obj = new boolean[]{true, false};
        final int i3 = i;
        final int i4 = i2;
        final View view2 = view;
        this.oTc.post(new Runnable(this) {
            final /* synthetic */ b oTi;

            public final void run() {
                obj[0] = this.oTi.c(i3, i4, view2);
                synchronized (obj) {
                    obj[1] = true;
                    obj.notifyAll();
                }
            }
        });
        synchronized (obj) {
            while (!obj[1]) {
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                }
            }
        }
        return obj[0];
    }

    private boolean c(int i, int i2, View view) {
        for (g a : this.oSZ) {
            if (!a.a(i, i2, view)) {
                return false;
            }
        }
        return true;
    }

    private void h(Throwable th) {
        for (g f : this.oSZ) {
            f.f(th);
        }
    }

    private b() {
        this.oSZ = new ConcurrentLinkedQueue();
        this.oTa = new WeakHashMap();
        this.oTb = new ConcurrentHashMap();
        this.oTc = new Handler(Looper.getMainLooper());
        this.oTd = null;
        this.gSX = false;
    }
}
