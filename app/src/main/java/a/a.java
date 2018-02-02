package a;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public final class a {
    private final boolean Auz = false;
    private final Object object;

    public static a cB(Object obj) {
        return new a(obj);
    }

    private a(Object obj) {
        this.object = obj;
    }

    public final a n(String str, Object... objArr) {
        Class[] clsArr = new Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            clsArr[i] = obj == null ? a.class : obj.getClass();
        }
        try {
            return a(a(str, clsArr), this.object, objArr);
        } catch (NoSuchMethodException e) {
            Class cJr = cJr();
            for (Method method : cJr.getMethods()) {
                if (a(method, str, clsArr)) {
                    break;
                }
            }
            Class cls = cJr;
            loop2:
            while (true) {
                for (Method method2 : cls.getDeclaredMethods()) {
                    if (a(method2, str, clsArr)) {
                        break loop2;
                    }
                }
                Class superclass = cls.getSuperclass();
                if (superclass == null) {
                    throw new NoSuchMethodException("No similar method " + str + " with params " + Arrays.toString(clsArr) + " could be found on type " + cJr() + ".");
                }
                cls = superclass;
            }
            return a(method2, this.object, objArr);
        } catch (Throwable e2) {
            throw new b(e2);
        }
    }

    private Method a(String str, Class<?>[] clsArr) {
        Method method;
        Class cJr = cJr();
        try {
            method = cJr.getMethod(str, clsArr);
        } catch (NoSuchMethodException e) {
            do {
                try {
                    method = cJr.getDeclaredMethod(str, clsArr);
                } catch (NoSuchMethodException e2) {
                    cJr = cJr.getSuperclass();
                    if (cJr != null) {
                        throw new NoSuchMethodException();
                    }
                }
            } while (cJr != null);
            throw new NoSuchMethodException();
        }
        return method;
    }

    private static boolean a(Method method, String str, Class<?>[] clsArr) {
        if (!method.getName().equals(str)) {
            return false;
        }
        boolean z;
        Class[] parameterTypes = method.getParameterTypes();
        if (parameterTypes.length == clsArr.length) {
            int i = 0;
            while (i < clsArr.length) {
                if (clsArr[i] == a.class || Q(parameterTypes[i]).isAssignableFrom(Q(clsArr[i]))) {
                    i++;
                }
            }
            z = true;
            return z;
        }
        z = false;
        if (z) {
        }
    }

    public final int hashCode() {
        return this.object.hashCode();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof a) {
            return this.object.equals(((a) obj).object);
        }
        return false;
    }

    public final String toString() {
        return this.object.toString();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static a a(Method method, Object obj, Object... objArr) {
        if (method != null) {
            try {
                if (method instanceof Member) {
                    Member member = method;
                    if (Modifier.isPublic(member.getModifiers())) {
                    }
                }
                if (!method.isAccessible()) {
                    method.setAccessible(true);
                }
            } catch (Throwable e) {
                throw new b(e);
            }
        }
        if (method.getReturnType() != Void.TYPE) {
            return cB(method.invoke(obj, objArr));
        }
        method.invoke(obj, objArr);
        return cB(obj);
    }

    private Class<?> cJr() {
        if (this.Auz) {
            return (Class) this.object;
        }
        return this.object.getClass();
    }

    private static Class<?> Q(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        if (!cls.isPrimitive()) {
            return cls;
        }
        if (Boolean.TYPE == cls) {
            return Boolean.class;
        }
        if (Integer.TYPE == cls) {
            return Integer.class;
        }
        if (Long.TYPE == cls) {
            return Long.class;
        }
        if (Short.TYPE == cls) {
            return Short.class;
        }
        if (Byte.TYPE == cls) {
            return Byte.class;
        }
        if (Double.TYPE == cls) {
            return Double.class;
        }
        if (Float.TYPE == cls) {
            return Float.class;
        }
        if (Character.TYPE == cls) {
            return Character.class;
        }
        if (Void.TYPE == cls) {
            return Void.class;
        }
        return cls;
    }
}
