package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.support.b.a;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.LinkedList;
import java.util.List;

final class b {
    static final String[] jmD;

    static {
        List linkedList = new LinkedList();
        for (Field field : a.class.getDeclaredFields()) {
            try {
                if (Modifier.isFinal(field.getModifiers()) && Modifier.isStatic(field.getModifiers()) && field.getName().startsWith("TAG_")) {
                    linkedList.add((String) field.get(null));
                }
            } catch (Exception e) {
            }
        }
        jmD = (String[]) linkedList.toArray(new String[linkedList.size()]);
    }

    static void a(a aVar, a aVar2) {
        for (String str : jmD) {
            String attribute = aVar.getAttribute(str);
            if (attribute != null) {
                aVar2.setAttribute(str, attribute);
            }
        }
        aVar2.saveAttributes();
    }
}
