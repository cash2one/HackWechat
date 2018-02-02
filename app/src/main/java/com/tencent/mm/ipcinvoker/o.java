package com.tencent.mm.ipcinvoker;

import com.tencent.mm.ipcinvoker.c.a;
import com.tencent.mm.ipcinvoker.e.b;
import com.tencent.mm.ipcinvoker.extension.e;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class o {
    private static Map<String, e> gMS = new ConcurrentHashMap();

    public static <T> T d(String str, Class<?> cls) {
        try {
            Class cls2 = Class.forName(str);
            if (!cls.isAssignableFrom(cls2)) {
                x.e("IPC.ObjectStore", "%s isAssignableFrom %s return false", new Object[]{cls, cls2});
                return null;
            } else if (!cls2.isAnnotationPresent(a.class)) {
                return b.e(str, cls);
            } else {
                e eVar = (e) gMS.get(str);
                if (eVar == null) {
                    eVar = new e(cls2);
                    gMS.put(str, eVar);
                }
                return eVar.get();
            }
        } catch (Exception e) {
            return null;
        }
    }

    public static <T> T a(Class<?> cls, Class<?> cls2) {
        try {
            if (!cls2.isAssignableFrom(cls)) {
                x.e("IPC.ObjectStore", "%s isAssignableFrom %s return false", new Object[]{cls2, cls});
                return null;
            } else if (!cls.isAnnotationPresent(a.class)) {
                return b.b(cls, cls2);
            } else {
                String name = cls.getName();
                e eVar = (e) gMS.get(name);
                if (eVar == null) {
                    eVar = new e(cls);
                    gMS.put(name, eVar);
                }
                return eVar.get();
            }
        } catch (Exception e) {
            return null;
        }
    }

    public static <T> T e(String str, Class<?> cls) {
        return b.e(str, cls);
    }
}
