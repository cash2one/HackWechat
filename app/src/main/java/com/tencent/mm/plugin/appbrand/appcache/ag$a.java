package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.plugin.appbrand.appcache.ag.c;
import com.tencent.mm.plugin.appbrand.config.m;
import com.tencent.mm.protocal.c.bsu;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.Map;

final class ag$a implements c {
    private ag$a() {
    }

    public final void u(Map<String, String> map) {
        if (map.get(".sysmsg.mmbizwxaconfig") != null) {
            int i = bh.getInt((String) map.get(".sysmsg.mmbizwxaconfig.command"), -1);
            int i2 = bh.getInt((String) map.get(".sysmsg.mmbizwxaconfig.type"), 0);
            String str = (String) map.get(".sysmsg.mmbizwxaconfig.appid");
            x.i("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "handle common config, command = %d, type = %d, appid = %s, configversion = %d", Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(bh.getInt((String) map.get(".sysmsg.mmbizwxaconfig.configversion"), 0)));
            LinkedList linkedList = new LinkedList();
            bsu com_tencent_mm_protocal_c_bsu = new bsu();
            com_tencent_mm_protocal_c_bsu.version = r1;
            com_tencent_mm_protocal_c_bsu.type = i2;
            linkedList.add(com_tencent_mm_protocal_c_bsu);
            m.a(str, linkedList, false);
            m.a(str, i2, i, new 1(this, str, i2), true);
        }
    }
}
