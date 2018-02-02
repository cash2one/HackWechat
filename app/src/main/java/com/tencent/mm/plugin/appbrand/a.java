package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.b;
import com.tencent.mm.plugin.appbrand.ui.h;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.HashMap;
import java.util.Map;

public final class a {
    private static final Map<String, e> ipV = new HashMap();
    private static Map<String, android.support.v4.app.a.a> ipW = new HashMap();
    private static final Map<String, AppBrandStatObject> ipX = new HashMap();
    private static Map<String, h> ipY = new HashMap();

    public static void a(String str, e eVar) {
        if (!bh.ov(str)) {
            synchronized (ipV) {
                ipV.put(str, eVar);
            }
            if (eVar != null && eVar.iqw != null) {
                b.aH(str, eVar.iqw.fnv);
            }
        }
    }

    public static e oQ(String str) {
        if (bh.ov(str)) {
            return null;
        }
        e eVar;
        synchronized (ipV) {
            eVar = (e) ipV.get(str);
        }
        return eVar;
    }

    public static void a(String str, android.support.v4.app.a.a aVar) {
        ipW.put(str, aVar);
    }

    public static void a(String str, int i, String[] strArr, int[] iArr) {
        if (ipW.containsKey(str)) {
            ((android.support.v4.app.a.a) ipW.remove(str)).onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    public static void oR(String str) {
        ipW.remove(str);
    }

    public static AppBrandSysConfig oS(String str) {
        return oQ(str) == null ? null : oQ(str).iqx;
    }

    public static void a(String str, AppBrandStatObject appBrandStatObject) {
        synchronized (ipX) {
            ipX.put(str, appBrandStatObject);
        }
    }

    public static AppBrandStatObject oT(String str) {
        AppBrandStatObject appBrandStatObject;
        synchronized (ipX) {
            appBrandStatObject = (AppBrandStatObject) ipX.get(str);
        }
        return appBrandStatObject;
    }

    public static void a(String str, h hVar) {
        ipY.put(str, hVar);
    }

    public static h oU(String str) {
        return (h) ipY.get(str);
    }

    public static void oV(String str) {
        ipY.remove(str);
    }
}
