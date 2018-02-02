package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.plugin.appbrand.appcache.ah.e;
import com.tencent.xweb.m;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

interface ah$b<T> {

    public static class a {
        static final Map<Class, ah$b> iGq;

        static {
            Map hashMap = new HashMap();
            iGq = hashMap;
            hashMap.put(InputStream.class, new ah$c());
            iGq.put(m.class, new e((byte) 0));
            iGq.put(String.class, new ah$d());
            iGq.put(byte[].class, new com.tencent.mm.plugin.appbrand.appcache.ah.a((byte) 0));
        }
    }

    T c(String str, InputStream inputStream);
}
