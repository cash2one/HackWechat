package com.tencent.mm.plugin.appbrand.ipc;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Constructor;

final class AppBrandProxyUIProcessTask$a {
    static <_Model extends AppBrandProxyUIProcessTask> _Model rZ(String str) {
        try {
            Constructor declaredConstructor = Class.forName(str).getDeclaredConstructor(new Class[0]);
            declaredConstructor.setAccessible(true);
            return (AppBrandProxyUIProcessTask) declaredConstructor.newInstance(new Object[0]);
        } catch (Throwable e) {
            x.e("MicroMsg.AppBrand.IpcProxyUIModelFactory", "create mode object using className(%s), exp = %s", new Object[]{str, bh.i(e)});
            return null;
        }
    }
}
