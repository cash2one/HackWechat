package com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

class a$a implements InvocationHandler {
    final /* synthetic */ a jvP;

    a$a(a aVar) {
        this.jvP = aVar;
    }

    public final Object invoke(Object obj, Method method, Object[] objArr) {
        if (method.getName().compareTo("onSuccess") != 0 && method.getName().compareTo("onFailure") == 0) {
            int intValue = (objArr == null || !(objArr[0] instanceof Integer)) ? -1 : ((Integer) objArr[0]).intValue();
            this.jvP.mHandler.post(new 1(this, intValue));
        }
        return null;
    }
}
