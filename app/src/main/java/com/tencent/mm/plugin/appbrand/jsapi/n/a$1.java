package com.tencent.mm.plugin.appbrand.jsapi.n;

import com.tencent.mm.plugin.appbrand.page.p$e;

class a$1 implements p$e {
    final /* synthetic */ a juM;

    a$1(a aVar) {
        this.juM = aVar;
    }

    public final void onDestroy() {
        a.a(this.juM).cleanup();
    }
}
