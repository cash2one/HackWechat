package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.plugin.appbrand.b.b.a;
import com.tencent.mm.plugin.appbrand.page.h;
import com.tencent.mm.plugin.appbrand.page.h.1;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.util.HashMap;
import java.util.Map;

class e$1 implements a {
    final /* synthetic */ e irf;

    e$1(e eVar) {
        this.irf = eVar;
    }

    public final void a(com.tencent.mm.plugin.appbrand.b.a aVar) {
        Object obj;
        e eVar = this.irf;
        Map hashMap = new HashMap();
        switch (1.iGZ[aVar.ordinal()]) {
            case 1:
                obj = "background";
                break;
            case 2:
                obj = "active";
                break;
            case 3:
                obj = "suspend";
                break;
            default:
                return;
        }
        hashMap.put(DownloadInfo.STATUS, obj);
        new h().v(hashMap).a(eVar.iqB).afs();
    }
}
