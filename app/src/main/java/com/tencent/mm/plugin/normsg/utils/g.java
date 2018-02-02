package com.tencent.mm.plugin.normsg.utils;

import android.util.LruCache;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public final class g {
    private static final LruCache<String, LruCache<String, Field>> oTJ = new LruCache(50);
    private static final LruCache<String, LruCache<String, Method>> oTK = new LruCache(50);
    private static final LruCache<String, LruCache<String, Constructor<?>>> oTL = new LruCache(50);

    public static class a extends RuntimeException {
        a(Throwable th) {
            super(th);
        }
    }

    public static Class<?> findClass(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable th) {
            a aVar = new a(th);
        }
    }

    public static <T> T e(Object obj, String str) {
        try {
            return b(obj.getClass(), str).get(obj);
        } catch (Throwable th) {
            a aVar = new a(th);
        }
    }

    public static <T> T dE(String str, String str2) {
        return a(findClass(str), str2);
    }

    private static <T> T a(Class<?> cls, String str) {
        try {
            return b(cls, str).get(null);
        } catch (Throwable th) {
            a aVar = new a(th);
        }
    }

    public static <T> void a(Object obj, String str, T t) {
        try {
            b(obj.getClass(), str).set(obj, t);
        } catch (Throwable th) {
            a aVar = new a(th);
        }
    }

    public static <T> T a(Object obj, String str, Class<?>[] clsArr, Object... objArr) {
        try {
            return a(obj.getClass(), str, (Class[]) clsArr).invoke(obj, objArr);
        } catch (Throwable th) {
            a aVar = new a(th);
        }
    }

    public static <T> T a(String str, String str2, Class<?>[] clsArr, Object... objArr) {
        return a(findClass(str), str2, (Class[]) clsArr, objArr);
    }

    public static <T> T a(Class<?> cls, String str, Class<?>[] clsArr, Object... objArr) {
        try {
            return a((Class) cls, str, (Class[]) clsArr).invoke(null, objArr);
        } catch (Throwable th) {
            a aVar = new a(th);
        }
    }

    public static Class<?>[] b(Class<?>... clsArr) {
        return clsArr;
    }

    private static Field b(Class<?> cls, String str) {
        LruCache lruCache;
        LruCache lruCache2 = (LruCache) oTJ.get(cls.getName());
        if (lruCache2 == null) {
            lruCache2 = new LruCache(30);
            oTJ.put(cls.getName(), lruCache2);
            lruCache = lruCache2;
        } else {
            lruCache = lruCache2;
        }
        Field field = (Field) lruCache.get(str);
        if (field == null) {
            while (true) {
                try {
                    break;
                } catch (Throwable th) {
                    if (cls.getSuperclass() != null && cls != Object.class) {
                        cls = cls.getSuperclass();
                    }
                }
            }
            field = cls.getDeclaredField(str);
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            lruCache.put(str, field);
        }
        return field;
    }

    private static Method a(Class<?> cls, String str, Class<?>... clsArr) {
        LruCache lruCache;
        LruCache lruCache2 = (LruCache) oTK.get(cls.getName());
        if (lruCache2 == null) {
            lruCache2 = new LruCache(30);
            oTK.put(cls.getName(), lruCache2);
            lruCache = lruCache2;
        } else {
            lruCache = lruCache2;
        }
        String str2 = str + "#" + (clsArr != null ? Arrays.toString(clsArr) : "[]");
        Method method = (Method) lruCache.get(str2);
        if (method == null) {
            while (true) {
                try {
                    break;
                } catch (Throwable th) {
                    if (cls.getSuperclass() != null && cls != Object.class) {
                        cls = cls.getSuperclass();
                    }
                }
            }
            method = cls.getDeclaredMethod(str, clsArr);
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            lruCache.put(str2, method);
        }
        return method;
    }
}
