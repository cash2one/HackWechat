package com.tencent.mm.ipcinvoker.e;

import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public final class b {
    public static <T> T e(String str, Class<?> cls) {
        T t = null;
        if (str == null || str.length() == 0) {
            x.e("IPC.ReflectUtil", "newInstance failed, class is null or nil.");
        } else if (cls == null) {
            x.e("IPC.ReflectUtil", "newInstance failed, parent class is null.");
        } else {
            try {
                Class cls2 = Class.forName(str);
                if (cls.isAssignableFrom(cls2)) {
                    Constructor declaredConstructor = cls2.getDeclaredConstructor(new Class[0]);
                    declaredConstructor.setAccessible(true);
                    t = declaredConstructor.newInstance(new Object[0]);
                } else {
                    x.e("IPC.ReflectUtil", "%s isAssignableFrom %s return false", new Object[]{cls, cls2});
                }
            } catch (ClassNotFoundException e) {
                x.e("IPC.ReflectUtil", "reflect error : %s", new Object[]{e});
            } catch (IllegalAccessException e2) {
                x.e("IPC.ReflectUtil", "reflect error : %s", new Object[]{e2});
            } catch (InstantiationException e3) {
                x.e("IPC.ReflectUtil", "reflect error : %s", new Object[]{e3});
            } catch (NoSuchMethodException e4) {
                x.e("IPC.ReflectUtil", "reflect error : %s", new Object[]{e4});
            } catch (InvocationTargetException e5) {
                x.e("IPC.ReflectUtil", "reflect error : %s", new Object[]{e5});
            }
        }
        return t;
    }

    public static <T> T b(Class<?> cls, Class<?> cls2) {
        T t = null;
        if (cls == null) {
            x.e("IPC.ReflectUtil", "newInstance failed, class is null or nil.");
        } else if (cls2 == null) {
            x.e("IPC.ReflectUtil", "newInstance failed, parent class is null.");
        } else {
            try {
                if (cls2.isAssignableFrom(cls)) {
                    Constructor declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
                    declaredConstructor.setAccessible(true);
                    t = declaredConstructor.newInstance(new Object[0]);
                } else {
                    x.e("IPC.ReflectUtil", "%s isAssignableFrom %s return false", new Object[]{cls2, cls});
                }
            } catch (IllegalAccessException e) {
                x.e("IPC.ReflectUtil", "reflect error : %s", new Object[]{e});
            } catch (InstantiationException e2) {
                x.e("IPC.ReflectUtil", "reflect error : %s", new Object[]{e2});
            } catch (NoSuchMethodException e3) {
                x.e("IPC.ReflectUtil", "reflect error : %s", new Object[]{e3});
            } catch (InvocationTargetException e4) {
                x.e("IPC.ReflectUtil", "reflect error : %s", new Object[]{e4});
            }
        }
        return t;
    }

    public static <T> T e(Class<?> cls) {
        T t = null;
        if (cls == null) {
            x.e("IPC.ReflectUtil", "newInstance failed, class is null or nil.");
        } else {
            try {
                Constructor declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
                declaredConstructor.setAccessible(true);
                t = declaredConstructor.newInstance(new Object[0]);
            } catch (IllegalAccessException e) {
                x.e("IPC.ReflectUtil", "reflect error : %s", new Object[]{e});
            } catch (InstantiationException e2) {
                x.e("IPC.ReflectUtil", "reflect error : %s", new Object[]{e2});
            } catch (NoSuchMethodException e3) {
                x.e("IPC.ReflectUtil", "reflect error : %s", new Object[]{e3});
            } catch (InvocationTargetException e4) {
                x.e("IPC.ReflectUtil", "reflect error : %s", new Object[]{e4});
            }
        }
        return t;
    }
}
