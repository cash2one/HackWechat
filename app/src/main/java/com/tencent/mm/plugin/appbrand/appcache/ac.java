package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.plugin.appbrand.appstorage.g;
import com.tencent.mm.plugin.appbrand.appstorage.j;
import com.tencent.mm.plugin.appbrand.appstorage.l;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class ac implements InvocationHandler {
    private final Map<String, Method> iFP = new ConcurrentHashMap();
    private final a iFQ;

    public static l i(e eVar) {
        try {
            InvocationHandler acVar = new ac(ah.k(eVar));
            return (l) Proxy.newProxyInstance(l.class.getClassLoader(), new Class[]{l.class}, acVar);
        } catch (Exception e) {
            x.e("MicroMsg.AppBrand.WxaPkgFileSystemWithModuleInvokeAdapter", "createInstance e=%s", new Object[]{e});
            return new g();
        }
    }

    public final Object invoke(Object obj, Method method, Object[] objArr) {
        if (method.getReturnType().equals(Boolean.TYPE)) {
            return Boolean.TRUE;
        }
        if (Modifier.isStatic(method.getModifiers())) {
            return null;
        }
        o pJ;
        Method a;
        if (objArr != null && objArr.length > 0 && (objArr[0] instanceof String)) {
            pJ = this.iFQ.pJ((String) objArr[0]);
            if (pJ == null) {
                return method.getReturnType().equals(j.class) ? j.iIx : null;
            } else {
                a = a(method);
                if (a != null) {
                    return a.invoke(pJ, objArr);
                }
            }
        } else if (method.getReturnType().equals(Void.TYPE)) {
            Collection<o> aaj = this.iFQ.aaj();
            if (aaj != null) {
                a = a(method);
                if (a != null) {
                    for (o pJ2 : aaj) {
                        a.invoke(pJ2, objArr);
                    }
                }
            }
            return null;
        }
        return null;
    }

    private Method a(Method method) {
        Method method2 = (Method) this.iFP.get(method.getName());
        if (method2 == null) {
            method2 = o.class.getMethod(method.getName(), method.getParameterTypes());
            if (method2 != null) {
                this.iFP.put(method.getName(), method2);
            }
        }
        return method2;
    }

    private ac(k kVar) {
        this.iFQ = new a(kVar, (byte) 0);
    }
}
