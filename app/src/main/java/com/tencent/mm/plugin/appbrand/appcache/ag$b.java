package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.appcache.ag.c;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.plugin.appbrand.config.r;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

final class ag$b implements c {
    private ag$b() {
    }

    public final void u(Map<String, String> map) {
        d(".sysmsg.AppBrandNotify.DebugInfoList.DebugInfo", map);
        int i = 0;
        do {
            i++;
        } while (d(".sysmsg.AppBrandNotify.DebugInfoList.DebugInfo" + i, map));
    }

    private boolean d(String str, Map<String, String> map) {
        x.d("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "optDebugInfo, prefix = %s", str);
        if (map.get(str) == null) {
            return false;
        }
        String str2 = (String) map.get(str + ".AppID");
        String str3 = (String) map.get(str + ".UserName");
        int i = bh.getInt((String) map.get(str + ".Type"), 1);
        String str4 = (String) map.get(str + ".URL");
        long j = bh.getLong((String) map.get(str + ".StartTime"), bh.Wo());
        x.i("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "handle debug notify, appId = %s, username = %s, debugType = %d, url = %s, start = %d, end = %d, md5 = %s, updated = %b", str2, str3, Integer.valueOf(i), str4, Long.valueOf(j), Long.valueOf(bh.getLong((String) map.get(str + ".EndTime"), 7200 + j)), r7, Boolean.valueOf(f.Zo().a(str2, i, str4, (String) map.get(str + ".MD5"), j, r10)));
        if (f.Zo().a(str2, i, str4, (String) map.get(str + ".MD5"), j, r10)) {
            if (999 != i) {
                r.qY(str3);
                ag.y(new 1(this, str2, i, q.qR(str2)));
            } else {
                j.iEs.cn(false);
            }
            f.Zm().s(str3, i, 0);
        }
        return true;
    }
}
