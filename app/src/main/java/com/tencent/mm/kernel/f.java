package com.tencent.mm.kernel;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public final class f {
    private static volatile boolean gQC = false;

    private static class a implements InvocationHandler {
        public int level;

        private a() {
            this.level = 0;
        }

        public final Object invoke(Object obj, Method method, Object[] objArr) {
            Class returnType = method.getReturnType();
            if (returnType.equals(Integer.TYPE)) {
                return Integer.valueOf(0);
            }
            if (returnType.equals(Long.TYPE)) {
                return Long.valueOf(0);
            }
            if (returnType.equals(Double.TYPE)) {
                return Double.valueOf(0.0d);
            }
            if (returnType.equals(Float.TYPE)) {
                return Float.valueOf(0.0f);
            }
            if (returnType.equals(Short.TYPE)) {
                return Integer.valueOf(0);
            }
            if (returnType.equals(Byte.TYPE)) {
                return Integer.valueOf(0);
            }
            if (returnType.equals(Character.TYPE)) {
                return Integer.valueOf(0);
            }
            if (returnType.equals(Boolean.TYPE)) {
                return Boolean.valueOf(false);
            }
            if (returnType.equals(Boolean.class)) {
                return Boolean.valueOf(false);
            }
            if (returnType.isInterface()) {
                return f.a(returnType, this.level + 1);
            }
            return null;
        }
    }

    private interface b {
    }

    public static boolean aA(Object obj) {
        if (obj instanceof b) {
            return true;
        }
        return false;
    }

    public static <T> T n(Class<T> cls) {
        if (gQC) {
            return a(cls, 0);
        }
        return null;
    }

    private static <T> T a(Class<T> cls, int i) {
        if (!gQC) {
            return null;
        }
        if (i > 3) {
            j.e("MMSkeleton.DummyMode", "dummy level > 3, return null.", new Object[0]);
            return null;
        } else if (!cls.isInterface()) {
            return null;
        } else {
            try {
                InvocationHandler aVar = new a();
                aVar.level = i;
                j.i("MMSkeleton.DummyMode", "dummy instance(%s) for class(%s), dummy level %s", Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls, b.class}, aVar), cls, Integer.valueOf(i));
                return Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls, b.class}, aVar);
            } catch (Throwable th) {
                j.printErrStackTrace("MMSkeleton.DummyMode", th, "", new Object[0]);
                return null;
            }
        }
    }
}
