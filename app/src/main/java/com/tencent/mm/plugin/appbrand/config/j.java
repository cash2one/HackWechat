package com.tencent.mm.plugin.appbrand.config;

import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.sdk.platformtools.x;

public enum j {
    ;

    public static long qJ(String str) {
        long j;
        AppBrandSysConfig oS = a.oS(str);
        String str2 = "MicroMsg.AppServiceSettingRemoteManager";
        String str3 = "getMaxFileStorageSize, (null == config) = %b, MaxFileStorageSize = %d";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(oS == null);
        objArr[1] = Long.valueOf(oS == null ? -1 : oS.iOw);
        x.i(str2, str3, objArr);
        if (oS == null || oS.iOw <= 0) {
            j = 10;
        } else {
            j = oS.iOw;
        }
        return j * 1048576;
    }
}
