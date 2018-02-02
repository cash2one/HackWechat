package com.tencent.mm.plugin.aj;

import com.tencent.mm.ipcinvoker.wx_extension.a.a;
import com.tencent.mm.ipcinvoker.wx_extension.a.a.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.c;

class d$1 implements Runnable {
    final /* synthetic */ d tjA;

    d$1(d dVar) {
        this.tjA = dVar;
    }

    public final void run() {
        a aVar = b.gNk;
        c fn = a.fn("100344");
        if (fn == null) {
            x.i("MicroMsg.WebViewPreLoadExport", "openSearchPreload item is null");
            return;
        }
        d dVar = this.tjA;
        boolean z = fn.isValid() && "1".equals(fn.chI().get("isOpen"));
        d.a(dVar, z);
        x.i("MicroMsg.WebViewPreLoadExport", "openSearchPreload :%b", new Object[]{Boolean.valueOf(d.a(this.tjA))});
        aVar = b.gNk;
        fn = a.fn("100346");
        if (fn == null) {
            x.i("MicroMsg.WebViewPreLoadExport", "openSearchPreload item is null");
            return;
        }
        dVar = this.tjA;
        if (fn.isValid() && "1".equals(fn.chI().get("isOpen"))) {
            z = true;
        } else {
            z = false;
        }
        d.b(dVar, z);
        x.i("MicroMsg.WebViewPreLoadExport", "openRecommendPreload :%b", new Object[]{Boolean.valueOf(d.b(this.tjA))});
    }
}
