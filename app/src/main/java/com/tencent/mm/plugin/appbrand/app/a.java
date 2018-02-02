package com.tencent.mm.plugin.appbrand.app;

import com.tencent.mm.plugin.appbrand.appcache.t;
import com.tencent.mm.plugin.appbrand.launching.i;
import com.tencent.mm.sdk.e.e;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

final class a {
    static final Map<a, String[]> iCR = new HashMap();
    private static final Map<Class, Object> iCS = new HashMap();

    private static void a(a aVar, String[] strArr) {
        iCR.put(aVar, strArr);
    }

    static {
        a(new 1(), i.iEK);
        a(new a<t>() {
            public final /* synthetic */ Object b(e eVar) {
                return new t(eVar);
            }
        }, t.iEK);
        a(new 3(), com.tencent.mm.plugin.appbrand.appusage.e.iEK);
    }

    static void a(e eVar) {
        synchronized (iCS) {
            iCS.clear();
            for (a b : iCR.keySet()) {
                Object b2 = b.b(eVar);
                iCS.put(b2.getClass(), b2);
            }
        }
    }

    static void YX() {
        synchronized (iCS) {
            iCS.clear();
        }
    }

    static <T> T u(Class<T> cls) {
        T t;
        Assert.assertTrue("Cant pass Null class here", cls != null);
        synchronized (iCS) {
            t = iCS.get(cls);
        }
        return t;
    }
}
