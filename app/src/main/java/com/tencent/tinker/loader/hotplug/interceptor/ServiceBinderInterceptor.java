package com.tencent.tinker.loader.hotplug.interceptor;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.IInterface;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ServiceBinderInterceptor extends Interceptor<IBinder> {
    private static Class<?> Akp;
    private static Field Akq;
    private static Method Akr;
    private final Context Akm;
    private final String Akn;
    private final BinderInvocationHandler Ako;

    public interface BinderInvocationHandler {
        Object invoke(Object obj, Method method, Object[] objArr);
    }

    private static class FakeClientBinderHandler implements InvocationHandler {
        private final BinderInvocationHandler Ako;
        private final IBinder Akt;

        FakeClientBinderHandler(IBinder iBinder, BinderInvocationHandler binderInvocationHandler) {
            this.Akt = iBinder;
            this.Ako = binderInvocationHandler;
        }

        public Object invoke(Object obj, Method method, Object[] objArr) {
            if (!"queryLocalInterface".equals(method.getName())) {
                return method.invoke(this.Akt, objArr);
            }
            String interfaceDescriptor = this.Akt.getInterfaceDescriptor();
            if (interfaceDescriptor.equals("android.app.IActivityManager")) {
                interfaceDescriptor = "android.app.ActivityManagerNative";
            } else {
                interfaceDescriptor = interfaceDescriptor + "$Stub";
            }
            IInterface iInterface = (IInterface) ShareReflectUtil.c(Class.forName(interfaceDescriptor), "asInterface", IBinder.class).invoke(null, new Object[]{this.Akt});
            return ServiceBinderInterceptor.a(ServiceBinderInterceptor.O(iInterface.getClass()), new FakeInterfaceHandler(iInterface, (IBinder) obj, this.Ako));
        }
    }

    private static class FakeInterfaceHandler implements InvocationHandler {
        private final BinderInvocationHandler Ako;
        private final IBinder Akt;
        private final IInterface Aku;

        FakeInterfaceHandler(IInterface iInterface, IBinder iBinder, BinderInvocationHandler binderInvocationHandler) {
            this.Aku = iInterface;
            this.Akt = iBinder;
            this.Ako = binderInvocationHandler;
        }

        public Object invoke(Object obj, Method method, Object[] objArr) {
            if ("asBinder".equals(method.getName())) {
                return this.Akt;
            }
            return this.Ako.invoke(this.Aku, method, objArr);
        }
    }

    protected final /* synthetic */ Object cA(Object obj) {
        IBinder iBinder = (IBinder) obj;
        if (iBinder != null) {
            return ITinkerHotplugProxy.class.isAssignableFrom(iBinder.getClass()) ? iBinder : (IBinder) a(O(iBinder.getClass()), new FakeClientBinderHandler(iBinder, this.Ako));
        } else {
            throw new IllegalStateException("target is null.");
        }
    }

    protected final /* synthetic */ Object cHd() {
        return (IBinder) Akr.invoke(null, new Object[]{this.Akn});
    }

    protected final /* synthetic */ void cz(Object obj) {
        IBinder iBinder = (IBinder) obj;
        ((Map) Akq.get(null)).put(this.Akn, iBinder);
        Field a;
        IInterface iInterface;
        if ("activity".equals(this.Akn)) {
            Object obj2;
            try {
                obj2 = ShareReflectUtil.d(Class.forName("android.app.ActivityManagerNative"), "gDefault").get(null);
            } catch (Throwable th) {
                obj2 = ShareReflectUtil.d(Class.forName("android.app.ActivityManager"), "IActivityManagerSingleton").get(null);
            }
            a = ShareReflectUtil.a(obj2, "mInstance");
            iInterface = (IInterface) a.get(obj2);
            if (iInterface != null && !ITinkerHotplugProxy.class.isAssignableFrom(iInterface.getClass())) {
                iInterface = iBinder.queryLocalInterface(iBinder.getInterfaceDescriptor());
                if (iInterface == null || !ITinkerHotplugProxy.class.isAssignableFrom(iInterface.getClass())) {
                    throw new IllegalStateException("fakeBinder does not return fakeInterface, binder: " + iBinder + ", itf: " + iInterface);
                }
                a.set(obj2, iInterface);
            }
        } else if ("package".equals(this.Akn)) {
            Context context = this.Akm;
            a = ShareReflectUtil.d(Class.forName("android.app.ActivityThread"), "sPackageManager");
            iInterface = (IInterface) a.get(null);
            if (!(iInterface == null || ITinkerHotplugProxy.class.isAssignableFrom(iInterface.getClass()))) {
                iInterface = iBinder.queryLocalInterface(iBinder.getInterfaceDescriptor());
                if (iInterface == null || !ITinkerHotplugProxy.class.isAssignableFrom(iInterface.getClass())) {
                    throw new IllegalStateException("fakeBinder does not return fakeInterface, binder: " + iBinder + ", itf: " + iInterface);
                }
                a.set(null, iInterface);
            }
            a = ShareReflectUtil.d(Class.forName("android.app.ApplicationPackageManager"), "mPM");
            PackageManager packageManager = context.getPackageManager();
            iInterface = (IInterface) a.get(packageManager);
            if (iInterface != null && !ITinkerHotplugProxy.class.isAssignableFrom(iInterface.getClass())) {
                iInterface = iBinder.queryLocalInterface(iBinder.getInterfaceDescriptor());
                if (iInterface == null || !ITinkerHotplugProxy.class.isAssignableFrom(iInterface.getClass())) {
                    throw new IllegalStateException("fakeBinder does not return fakeInterface, binder: " + iBinder + ", itf: " + iInterface);
                }
                a.set(packageManager, iInterface);
            }
        }
    }

    static {
        Akp = null;
        Akq = null;
        Akr = null;
        synchronized (ServiceBinderInterceptor.class) {
            if (Akp == null) {
                try {
                    Class cls = Class.forName("android.os.ServiceManager");
                    Akp = cls;
                    Akq = ShareReflectUtil.d(cls, "sCache");
                    Akr = ShareReflectUtil.c(Akp, "getService", String.class);
                } catch (Throwable th) {
                }
            }
        }
    }

    public ServiceBinderInterceptor(Context context, String str, BinderInvocationHandler binderInvocationHandler) {
        Context context2 = context;
        while (context2 != null && (context2 instanceof ContextWrapper)) {
            context2 = ((ContextWrapper) context2).getBaseContext();
        }
        this.Akm = context2;
        this.Akn = str;
        this.Ako = binderInvocationHandler;
    }

    private static <T> T a(Class<?>[] clsArr, InvocationHandler invocationHandler) {
        T newProxyInstance;
        Throwable th;
        Object obj;
        Object obj2 = new Class[(clsArr.length + 1)];
        System.arraycopy(clsArr, 0, obj2, 0, clsArr.length);
        obj2[clsArr.length] = ITinkerHotplugProxy.class;
        try {
            newProxyInstance = Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), obj2, invocationHandler);
        } catch (Throwable th2) {
            RuntimeException runtimeException = new RuntimeException("cl: " + obj, th);
        }
        return newProxyInstance;
    }

    private static Class<?>[] O(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        Set hashSet = new HashSet(10);
        while (!Object.class.equals(cls)) {
            hashSet.addAll(Arrays.asList(cls.getInterfaces()));
            cls = cls.getSuperclass();
        }
        return (Class[]) hashSet.toArray(new Class[hashSet.size()]);
    }
}
