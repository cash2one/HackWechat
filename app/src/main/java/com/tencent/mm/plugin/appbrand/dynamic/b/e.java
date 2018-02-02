package com.tencent.mm.plugin.appbrand.dynamic.b;

import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class e {
    private static volatile e iSO;
    private Map<String, SoftReference<WxaPkgWrappingInfo>> gMU = new ConcurrentHashMap();

    private static e acS() {
        if (iSO == null) {
            synchronized (e.class) {
                if (iSO == null) {
                    iSO = new e();
                }
            }
        }
        return iSO;
    }

    private e() {
    }

    public static boolean a(String str, WxaPkgWrappingInfo wxaPkgWrappingInfo) {
        if (str == null || str.length() == 0 || wxaPkgWrappingInfo == null) {
            return false;
        }
        acS().gMU.put(str, new SoftReference(wxaPkgWrappingInfo));
        return true;
    }

    public static WxaPkgWrappingInfo rq(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        SoftReference softReference = (SoftReference) acS().gMU.get(str);
        return softReference != null ? (WxaPkgWrappingInfo) softReference.get() : null;
    }

    public static void removeAll() {
        acS().gMU.clear();
    }
}
