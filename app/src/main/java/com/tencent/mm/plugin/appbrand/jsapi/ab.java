package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Build.VERSION;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.v;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

final class ab extends l {
    private static final int CTRL_INDEX = 97;
    private static final String NAME = "getPublicLibVersion";

    ab() {
    }

    public final String a(j jVar, JSONObject jSONObject) {
        return n(jVar.irP);
    }

    public final String a(p pVar) {
        return n(pVar.irP);
    }

    private String n(e eVar) {
        boolean z = true;
        AppBrandSysConfig appBrandSysConfig = eVar.iqx;
        if (appBrandSysConfig == null) {
            return e("fail", null);
        }
        Map hashMap = new HashMap();
        hashMap.put("appDebug", Boolean.valueOf(appBrandSysConfig.iOI.iGK != 0));
        hashMap.put("appMd5", bh.ou(appBrandSysConfig.iOI.fqR));
        hashMap.put("appVersion", Integer.valueOf(appBrandSysConfig.iOI.iGL));
        WxaPkgWrappingInfo ZP = v.ZP();
        String str = "libDebug";
        if (ZP.iGK == 0) {
            z = false;
        }
        hashMap.put(str, Boolean.valueOf(z));
        hashMap.put("libMd5", bh.ou(ZP.fqR));
        hashMap.put("libVersion", Integer.valueOf(ZP.iGL));
        hashMap.put("clientVersion", Integer.valueOf(d.vAz));
        hashMap.put("system", "android");
        hashMap.put("systemVersion", Integer.valueOf(VERSION.SDK_INT));
        hashMap.put("x5Version", Integer.valueOf(com.tencent.xweb.x5.sdk.d.getTbsVersion(ac.getContext())));
        return e("ok", hashMap);
    }
}
