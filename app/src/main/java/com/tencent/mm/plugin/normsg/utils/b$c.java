package com.tencent.mm.plugin.normsg.utils;

import android.os.Build.VERSION;
import android.os.Handler.Callback;
import android.os.IBinder;
import android.os.IInterface;
import com.tencent.mm.plugin.normsg.utils.b.a;
import com.tencent.mm.plugin.normsg.utils.b.b;
import com.tencent.mm.plugin.normsg.utils.b.e;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

final class b$c extends e {
    final /* synthetic */ b oTi;
    private InvocationHandler oTq = new InvocationHandler(this) {
        final /* synthetic */ b$c oTr;

        {
            this.oTr = r1;
        }

        public final Object invoke(Object obj, Method method, Object[] objArr) {
            Object b;
            synchronized (this.oTr.oTi) {
                if (b.bfV().equals(method.getName())) {
                    b = b.b(this.oTr.oTi);
                } else {
                    try {
                        b = method.invoke(this.oTr.oTt.asBinder(), objArr);
                    } catch (InvocationTargetException e) {
                        r2 = e.getTargetException();
                        r0 = method.getExceptionTypes();
                        Class[] exceptionTypes;
                        if (exceptionTypes != null && exceptionTypes.length > 0) {
                            for (Class isAssignableFrom : method.getExceptionTypes()) {
                                Throwable targetException;
                                if (isAssignableFrom.isAssignableFrom(targetException.getClass())) {
                                    throw targetException;
                                }
                            }
                        }
                        b.a(this.oTr.oTi, targetException);
                        b = b.b(method);
                    } catch (Throwable th) {
                        b.a(this.oTr.oTi, th);
                        b = b.b(method);
                    }
                }
            }
            return b;
        }
    };

    b$c(b bVar, IInterface iInterface) {
        this.oTi = bVar;
        super(bVar, iInterface);
    }

    public final Object invoke(Object obj, Method method, Object[] objArr) {
        if (b.bz().equals(method.getName()) && objArr != null && objArr.length >= 2) {
            Object obj2 = objArr[1];
            try {
                if (g.findClass(b.aqF()).isAssignableFrom(obj2.getClass())) {
                    WeakReference weakReference = (WeakReference) g.e(obj2, b.el());
                    Object obj3 = weakReference.get();
                    if (obj3 == null) {
                        x.e("MicroMsg.AED", "lost viewRootImpl instance, give up intercepting.");
                    } else {
                        Object e = VERSION.SDK_INT < 16 ? obj3 : g.e(g.a(obj3, b.bfS(), null, new Object[0]), "mHandler");
                        Callback callback = (Callback) g.e(e, b.bfT());
                        if (!(callback instanceof b)) {
                            g.a(e, b.bfT(), new b(this.oTi, obj3, callback));
                        }
                        synchronized (b.a(this.oTi)) {
                            IBinder iBinder = (IBinder) b.a(this.oTi).get(obj3);
                            if (iBinder == null) {
                                iBinder = new a(this.oTi, weakReference.get(), ((IInterface) obj2).asBinder());
                                b.a(this.oTi).put(obj3, iBinder);
                            }
                            objArr[1] = (IInterface) g.a(b.aqF() + "$Stub", "asInterface", g.b(new Class[]{IBinder.class}), new Object[]{iBinder});
                        }
                    }
                } else {
                    throw new IllegalStateException("mismatched conn class: " + obj2.getClass() + ", give up intercepting.");
                }
            } catch (Throwable th) {
                x.printErrStackTrace("MicroMsg.AED", th, "unexpected exception.", new Object[0]);
                b.a(this.oTi, th);
                objArr[1] = obj2;
            }
        }
        return super.invoke(obj, method, objArr);
    }

    public final IBinder asBinder() {
        return (IBinder) Proxy.newProxyInstance(b.bfU(), new Class[]{IBinder.class}, this.oTq);
    }
}
