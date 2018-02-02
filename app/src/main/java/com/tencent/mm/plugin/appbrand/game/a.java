package com.tencent.mm.plugin.appbrand.game;

import com.tencent.mm.plugin.appbrand.appcache.ah;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.p.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

final class a {
    static String a(e eVar, String str, boolean z) {
        String uy;
        x.i("MicroMsg.GameFileUtils", "Ready to getJsString js! filePath: %s,isAsset:%s", new Object[]{str, Boolean.valueOf(z)});
        if (z) {
            uy = c.uy(str);
        } else {
            uy = ah.a(eVar, str);
        }
        if (bh.ov(uy)) {
            x.e("MicroMsg.GameFileUtils", "js code is null, filePath : " + str);
        }
        return uy;
    }
}
