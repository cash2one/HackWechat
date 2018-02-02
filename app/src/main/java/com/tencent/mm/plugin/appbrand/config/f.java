package com.tencent.mm.plugin.appbrand.config;

import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.Map;

public final class f implements a {
    private static f iOa;
    public final Map<String, AppBrandInitConfig> iOb = new android.support.v4.e.a();
    public final Map<String, String> iOc = new android.support.v4.e.a();

    private f() {
    }

    public static void init() {
        synchronized (f.class) {
            iOa = new f();
            q.abY().c(iOa);
        }
    }

    public static void release() {
        synchronized (f.class) {
            iOa = null;
        }
    }

    public static f abV() {
        f fVar;
        synchronized (f.class) {
            fVar = iOa;
        }
        return fVar;
    }

    public final void a(String str, l lVar) {
        if ("single".equals(str)) {
            if (String.class.isInstance(lVar.obj)) {
                String valueOf = String.valueOf(lVar.obj);
                if (!bh.ov(valueOf)) {
                    qF(valueOf);
                }
            }
        } else if ("batch".equals(str)) {
            synchronized (this.iOb) {
                this.iOb.clear();
            }
        }
    }

    public final String qE(String str) {
        if (bh.ov(str)) {
            return null;
        }
        String str2;
        synchronized (this.iOc) {
            str2 = (String) this.iOc.get(str);
        }
        return str2;
    }

    private AppBrandInitConfig qF(String str) {
        if (bh.ov(str)) {
            return null;
        }
        synchronized (this.iOc) {
            String str2 = (String) this.iOc.get(str);
        }
        if (!bh.ov(str2)) {
            return qG(str2);
        }
        AppBrandInitConfig a = a(com.tencent.mm.plugin.appbrand.app.f.Zh().e(str, new String[]{"appId", "appInfo", "brandIconURL", "nickname"}));
        if (a == null) {
            return a;
        }
        synchronized (this.iOc) {
            this.iOc.put(str, a.appId);
        }
        return a;
    }

    public static AppBrandInitConfig a(WxaAttributes wxaAttributes) {
        if (wxaAttributes == null) {
            return null;
        }
        AppBrandInitConfig appBrandInitConfig = new AppBrandInitConfig();
        appBrandInitConfig.username = wxaAttributes.field_username;
        appBrandInitConfig.appId = wxaAttributes.field_appId;
        appBrandInitConfig.frn = wxaAttributes.field_nickname;
        appBrandInitConfig.iconUrl = wxaAttributes.field_brandIconURL;
        appBrandInitConfig.fnv = wxaAttributes.abZ().hoL;
        appBrandInitConfig.iNR = wxaAttributes.abZ().iPo > 0;
        return appBrandInitConfig;
    }

    public final AppBrandInitConfig qG(String str) {
        if (bh.ov(str)) {
            return null;
        }
        synchronized (this.iOb) {
            AppBrandInitConfig appBrandInitConfig = (AppBrandInitConfig) this.iOb.remove(str);
        }
        if (appBrandInitConfig != null) {
            return appBrandInitConfig;
        }
        return a(com.tencent.mm.plugin.appbrand.app.f.Zh().f(str, new String[]{"appInfo", "brandIconURL", "nickname"}));
    }
}
