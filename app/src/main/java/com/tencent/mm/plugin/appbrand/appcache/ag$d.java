package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.protocal.c.car;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

final class ag$d implements ag$c {
    private ag$d() {
    }

    public final void u(Map<String, String> map) {
        if (map.get(".sysmsg.AppPublicLibraryNotify") != null) {
            int i = bh.getInt((String) map.get(".sysmsg.AppPublicLibraryNotify.Version"), 0);
            String str = (String) map.get(".sysmsg.AppPublicLibraryNotify.MD5");
            String str2 = (String) map.get(".sysmsg.AppPublicLibraryNotify.URL");
            int i2 = bh.getInt((String) map.get(".sysmsg.AppPublicLibraryNotify.ForceUpdate"), 0);
            if (bh.ov(str2) || bh.ov(str) || i <= 0) {
                x.i("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "handle library notify, invalid params: url = %s, md5 = %s, version = %d", new Object[]{str2, str, Integer.valueOf(i)});
                return;
            }
            x.i("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "handle library notify, version = %d, md5 = %s, url = %s, forceUpdate = %d", new Object[]{Integer.valueOf(i), str, str2, Integer.valueOf(i2)});
            car com_tencent_mm_protocal_c_car = new car();
            com_tencent_mm_protocal_c_car.version = i;
            com_tencent_mm_protocal_c_car.fqR = str;
            com_tencent_mm_protocal_c_car.url = str2;
            com_tencent_mm_protocal_c_car.wFT = i2;
            w.a(com_tencent_mm_protocal_c_car);
        }
    }
}
