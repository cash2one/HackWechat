package com.tencent.mm.plugin.normsg.utils;

import android.os.IBinder;
import android.os.IInterface;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class b$e implements InvocationHandler {
    final /* synthetic */ b oTi;
    protected final IInterface oTt;

    b$e(b bVar, IInterface iInterface) {
        this.oTi = bVar;
        this.oTt = iInterface;
    }

    public Object invoke(Object obj, Method method, Object[] objArr) {
        try {
            if ("asBinder".equals(method.getName())) {
                return asBinder();
            }
            return method.invoke(this.oTt, objArr);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw targetException;
            }
            Class[] exceptionTypes = method.getExceptionTypes();
            if (exceptionTypes != null && exceptionTypes.length > 0) {
                for (Class isAssignableFrom : method.getExceptionTypes()) {
                    if (isAssignableFrom.isAssignableFrom(targetException.getClass())) {
                        throw targetException;
                    }
                }
            }
            b.a(this.oTi, targetException);
            return b.b(method);
        } catch (Throwable th) {
            b.a(this.oTi, th);
            return b.b(method);
        }
    }

    public IBinder asBinder() {
        return this.oTt.asBinder();
    }
}
