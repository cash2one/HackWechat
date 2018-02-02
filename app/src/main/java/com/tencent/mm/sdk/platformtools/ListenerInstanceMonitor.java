package com.tencent.mm.sdk.platformtools;

import android.app.Activity;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.f.e;
import java.io.Closeable;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

public final class ListenerInstanceMonitor {
    private static final Map<Object, Set<a>> xeN = new WeakHashMap();
    private static final byte[] xeO = new byte[0];
    private static Field xeP;
    private static HandlerThread xeQ;
    private static af xeR;
    private static volatile boolean xeS;
    private static final String xeT = Activity.class.getName();
    private static Field xeU = null;
    private static final Runnable xeV = new Runnable() {
        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            synchronized (ListenerInstanceMonitor.xeV) {
                if (!ListenerInstanceMonitor.xeS) {
                    return;
                }
            }
            synchronized (ListenerInstanceMonitor.xeO) {
                for (Entry value : ListenerInstanceMonitor.xeN.entrySet()) {
                    Iterator it = ((Set) value.getValue()).iterator();
                    while (it.hasNext()) {
                        a aVar = (a) it.next();
                        Object obj = aVar.xeW.get();
                        Activity activity = (Activity) aVar.xeX.get();
                        if (activity == null) {
                            x.i("MicroMsg.ListenerInstanceMonitor", "[tomys] monitor task: Ok, ui [%s] was recycled.", aVar.xeY.getName());
                            it.remove();
                        } else if (AnonymousClass1.T(activity) && obj == null) {
                            if (aVar.xfb > 3) {
                                it.remove();
                                obj = (e.DEBUG || b.ceK() || b.ceI()) ? 1 : null;
                                r1 = aVar.xeX.get() == null ? aVar.xeZ != null ? "ui of class [" + aVar.xeY.getName() + "] held by\n [" + aVar.cfd() + "] is recycled" : "ui of class [" + aVar.xeY.getName() + "] which is subclass of\n listener or callback and held by other 'Manager' class is recycled" : aVar.xeZ != null ? "ui of class [" + aVar.xeY.getName() + "] held by\n [" + aVar.cfd() + "] is leaked.\n Perhaps you should remove the holder from any 'Manager' class when the leaked ui was destroyed." : "ui of class [" + aVar.xeY.getName() + "] which is subclass of\n listener or callback and held by other 'Manager' class is leaked.\n Perhaps you should remove any instance of this class from any 'Manager'";
                                Throwable listenerLeakedException = new ListenerLeakedException(r1, aVar.xfa);
                                if (obj != null) {
                                    throw listenerLeakedException;
                                }
                                x.printErrStackTrace("MicroMsg.ListenerInstanceMonitor", listenerLeakedException, "", new Object[0]);
                            } else {
                                aVar.xfb++;
                                x.w("MicroMsg.ListenerInstanceMonitor", "[tomys] monitor task: ui [%s] was recycled, but its instance is still exists in %s time(s) check.", aVar.xeY.getName(), Integer.valueOf(aVar.xfb));
                            }
                        }
                    }
                }
            }
            synchronized (ListenerInstanceMonitor.xeV) {
                if (ListenerInstanceMonitor.xeS) {
                    ListenerInstanceMonitor.xeR.postDelayed(this, 10000);
                }
            }
        }

        private static boolean T(Activity activity) {
            boolean z;
            Window window = activity.getWindow();
            if (ListenerInstanceMonitor.xeU == null) {
                try {
                    ListenerInstanceMonitor.xeU = Window.class.getDeclaredField("mDestroyed");
                    ListenerInstanceMonitor.xeU.setAccessible(true);
                } catch (Throwable th) {
                    x.printErrStackTrace("MicroMsg.ListenerInstanceMonitor", th, "unexpected exception.", new Object[0]);
                    return false;
                }
            }
            try {
                z = ListenerInstanceMonitor.xeU.getBoolean(window);
            } catch (Throwable th2) {
                z = false;
            }
            if (!z) {
                return false;
            }
            for (StackTraceElement stackTraceElement : Looper.getMainLooper().getThread().getStackTrace()) {
                if (ListenerInstanceMonitor.xeT.equals(stackTraceElement.getClassName()) && "performDestroy".equals(stackTraceElement.getMethodName())) {
                    return false;
                }
            }
            return z;
        }
    };

    private static final class ListenerLeakedException extends RuntimeException {
        ListenerLeakedException(String str, Throwable th) {
            super(str + "\n See stacktrace to find where is the holder(listener) being added.");
            setStackTrace(th.getStackTrace());
        }

        public final Throwable fillInStackTrace() {
            return this;
        }
    }

    private static class a {
        final WeakReference<Object> xeW = new WeakReference(new Object());
        WeakReference<Activity> xeX;
        Class<?> xeY;
        Field xeZ;
        Throwable xfa;
        int xfb;

        a(Activity activity, Field field, Throwable th) {
            this.xeX = new WeakReference(activity);
            this.xeY = activity.getClass();
            this.xeZ = field;
            this.xfa = th;
            this.xfb = 0;
        }

        public final String toString() {
            return cfd() + "@" + cfc().replace('\n', '|');
        }

        private String cfc() {
            Throwable th;
            Writer stringWriter = new StringWriter();
            Closeable printWriter;
            try {
                printWriter = new PrintWriter(stringWriter);
                try {
                    this.xfa.printStackTrace(printWriter);
                    bh.d(printWriter);
                    return stringWriter.toString();
                } catch (Throwable th2) {
                    th = th2;
                    bh.d(printWriter);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                printWriter = null;
                bh.d(printWriter);
                throw th;
            }
        }

        final String cfd() {
            if (this.xeZ == null) {
                return "#null#";
            }
            Object declaringClass = this.xeZ.getDeclaringClass();
            if (!declaringClass.isAnonymousClass()) {
                return "field " + this.xeZ.getName() + " defined in " + declaringClass.getName();
            }
            Type genericSuperclass = declaringClass.getGenericSuperclass();
            if (Object.class.equals(genericSuperclass)) {
                declaringClass = declaringClass.getGenericInterfaces()[0];
            } else if (genericSuperclass != null) {
                Type type = genericSuperclass;
            }
            return "field " + this.xeZ.getName() + " define in anonymous class of " + declaringClass.toString().replace('<', '#').replace('>', '#');
        }

        public final int hashCode() {
            int hashCode;
            int hashCode2;
            int i = 0;
            Object obj = this.xeX.get();
            if (obj != null) {
                hashCode = obj.hashCode();
            } else {
                hashCode = 0;
            }
            if (this.xeZ != null) {
                hashCode2 = this.xeZ.hashCode();
            } else {
                hashCode2 = 0;
            }
            if (this.xfa != null) {
                i = this.xfa.hashCode();
            }
            return (hashCode + hashCode2) + i;
        }

        public final boolean equals(Object obj) {
            boolean z = true;
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            Object obj2 = this.xeX.get();
            Object obj3 = aVar.xeX.get();
            boolean equals = (obj2 == null && obj3 == null) ? true : (obj2 == null || obj3 == null) ? false : obj2.equals(obj3);
            if (!equals) {
                return false;
            }
            Field field = this.xeZ;
            Field field2 = aVar.xeZ;
            equals = (field == null && field2 == null) ? true : (field == null || field2 == null) ? false : field.equals(field2);
            if (!equals) {
                return false;
            }
            Throwable th = this.xfa;
            Throwable th2 = aVar.xfa;
            if (!(th == null && th2 == null)) {
                z = (th == null || th2 == null) ? false : th.equals(th2);
            }
            return z;
        }
    }

    static {
        xeP = null;
        xeQ = null;
        xeR = null;
        xeS = false;
        if (!e.DEBUG && !b.ceK() && !b.ceI()) {
            x.w("MicroMsg.ListenerInstanceMonitor", "Not debug, assist or monkey env, keep disabled.");
        } else if (ac.cfw()) {
            try {
                Field declaredField = View.class.getDeclaredField("mContext");
                xeP = declaredField;
                declaredField.setAccessible(true);
                synchronized (xeV) {
                    if (!xeS) {
                        HandlerThread Wf = e.Wf("ListenerInstanceMonitor");
                        xeQ = Wf;
                        Wf.start();
                        af afVar = new af(xeQ.getLooper());
                        xeR = afVar;
                        afVar.postDelayed(xeV, 10000);
                        xeS = true;
                    }
                }
            } catch (Throwable th) {
                x.printErrStackTrace("MicroMsg.ListenerInstanceMonitor", th, "init failed, keep disabled.", new Object[0]);
            }
        } else {
            x.w("MicroMsg.ListenerInstanceMonitor", "Not mm process, keep disabled.");
        }
    }

    public static void bU(Object obj) {
        if (obj != null) {
            Throwable th = new Throwable();
            for (Class cls = obj.getClass(); !Object.class.equals(cls); cls = cls.getSuperclass()) {
                if (Activity.class.isAssignableFrom(cls)) {
                    a(obj, null, th);
                } else if (View.class.isAssignableFrom(cls)) {
                    b(obj, null, th);
                } else {
                    for (Field field : cls.getDeclaredFields()) {
                        Class type = field.getType();
                        if (Activity.class.isAssignableFrom(type)) {
                            a(obj, field, th);
                        } else if (View.class.isAssignableFrom(type)) {
                            b(obj, field, th);
                        }
                    }
                }
            }
        }
    }

    private static void a(Object obj, Field field, Throwable th) {
        Activity activity;
        if (field != null) {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            try {
                activity = (Activity) field.get(obj);
                if (activity == null) {
                    return;
                }
            } catch (Throwable th2) {
                return;
            }
        } else if (obj instanceof Activity) {
            activity = (Activity) obj;
        } else {
            return;
        }
        a(obj, activity, field, th);
    }

    private static void b(Object obj, Field field, Throwable th) {
        if (field == null) {
            if (obj instanceof View) {
                Object obj2 = (View) obj;
            } else {
                return;
            }
        } else if (xeP != null) {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            try {
                View view = (View) field.get(obj);
                if (view == null) {
                    return;
                }
            } catch (Throwable th2) {
                return;
            }
        } else {
            return;
        }
        try {
            obj2 = xeP.get(obj2);
            if (obj2 instanceof Activity) {
                a(obj, (Activity) obj2, field, th);
            }
        } catch (Throwable th3) {
        }
    }

    private static void a(Object obj, Activity activity, Field field, Throwable th) {
        int length;
        g gVar = null;
        if (obj.getClass().isAnnotationPresent(g.class)) {
            gVar = (g) obj.getClass().getAnnotation(g.class);
        } else {
            for (Method method : obj.getClass().getDeclaredMethods()) {
                if (method.isAnnotationPresent(g.class)) {
                    gVar = (g) method.getAnnotation(g.class);
                    break;
                }
            }
        }
        if (gVar != null) {
            int i;
            Class cls = activity.getClass();
            Class[] ceR = gVar.ceR();
            if (ceR != null && ceR.length > 0) {
                length = ceR.length;
                i = 0;
                while (i < length) {
                    if (!cls.equals(ceR[i])) {
                        i++;
                    }
                }
                i = 0;
                if (i != 0) {
                    x.w("MicroMsg.ListenerInstanceMonitor", "Activity %s held by %s is ignored !!", activity, obj);
                    return;
                }
            }
            i = 1;
            if (i != 0) {
                x.w("MicroMsg.ListenerInstanceMonitor", "Activity %s held by %s is ignored !!", activity, obj);
                return;
            }
        }
        synchronized (xeO) {
            Set set = (Set) xeN.get(obj);
            if (set == null) {
                set = new HashSet();
                xeN.put(obj, set);
            }
            set.add(new a(activity, field, th));
        }
    }

    public static void bV(Object obj) {
        if (obj != null) {
            synchronized (xeO) {
                xeN.remove(obj);
            }
        }
    }
}
