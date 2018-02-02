package com.tencent.tinker.loader.hotplug.handler;

import android.content.ComponentName;
import android.content.Intent;
import com.tencent.tinker.loader.hotplug.IncrementComponentManager;
import com.tencent.tinker.loader.hotplug.interceptor.ServiceBinderInterceptor.BinderInvocationHandler;
import java.lang.reflect.Method;

public class PMSInterceptHandler implements BinderInvocationHandler {
    public final Object invoke(Object obj, Method method, Object[] objArr) {
        String name = method.getName();
        if ("getActivityInfo".equals(name)) {
            return c(obj, method, objArr);
        }
        if ("resolveIntent".equals(name)) {
            return d(obj, method, objArr);
        }
        return method.invoke(obj, objArr);
    }

    private static Object c(Object obj, Method method, Object[] objArr) {
        Class[] exceptionTypes = method.getExceptionTypes();
        try {
            Object invoke = method.invoke(obj, objArr);
            if (invoke != null) {
                return invoke;
            }
            ComponentName componentName;
            for (int i = 0; i < objArr.length; i++) {
                if (objArr[i] instanceof ComponentName) {
                    new StringBuilder("locate componentName field of ").append(method.getName()).append(" done at idx: ").append(i);
                    componentName = (ComponentName) objArr[i];
                    break;
                }
            }
            componentName = null;
            if (componentName != null) {
                return IncrementComponentManager.abG(componentName.getClassName());
            }
            new StringBuilder("failed to locate componentName field of ").append(method.getName()).append(", notice any crashes or mistakes after resolve works.");
            return null;
        } catch (Throwable e) {
            Throwable targetException = e.getTargetException();
            if (exceptionTypes == null || exceptionTypes.length <= 0) {
                return null;
            }
            if (targetException == null) {
                targetException = e;
            }
            throw targetException;
        } catch (Throwable th) {
            return null;
        }
    }

    private static Object d(Object obj, Method method, Object[] objArr) {
        Class[] exceptionTypes = method.getExceptionTypes();
        try {
            Object invoke = method.invoke(obj, objArr);
            if (invoke != null) {
                return invoke;
            }
            Intent intent;
            for (int i = 0; i < objArr.length; i++) {
                if (objArr[i] instanceof Intent) {
                    new StringBuilder("locate intent field of ").append(method.getName()).append(" done at idx: ").append(i);
                    intent = (Intent) objArr[i];
                    break;
                }
            }
            intent = null;
            if (intent != null) {
                return IncrementComponentManager.ap(intent);
            }
            new StringBuilder("failed to locate intent field of ").append(method.getName()).append(", notice any crashes or mistakes after resolve works.");
            return null;
        } catch (Throwable e) {
            Throwable targetException = e.getTargetException();
            if (exceptionTypes == null || exceptionTypes.length <= 0) {
                return null;
            }
            if (targetException == null) {
                targetException = e;
            }
            throw targetException;
        } catch (Throwable th) {
            return null;
        }
    }
}
