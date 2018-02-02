package com.tencent.mm.plugin.appbrand.app;

import com.tencent.mm.g.a.o;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class f$17 extends c<o> {
    final /* synthetic */ f iDI;

    f$17(f fVar) {
        this.iDI = fVar;
        this.xen = o.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        boolean fx = f.Zl().iHy.fx("AppBrandCommonKVData", "update AppBrandCommonKVData set value = '0' where key like '%_unreadCount'");
        x.i("MicroMsg.AppBrandCommonKVDataStorage", "sql:%s, updateRet : %b", new Object[]{"update AppBrandCommonKVData set value = '0' where key like '%_unreadCount'", Boolean.valueOf(fx)});
        return true;
    }
}
