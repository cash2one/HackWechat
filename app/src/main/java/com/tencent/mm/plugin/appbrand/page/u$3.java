package com.tencent.mm.plugin.appbrand.page;

import com.tencent.mm.sdk.platformtools.bc;

class u$3 extends bc<Boolean> {
    final /* synthetic */ u jFr;
    final /* synthetic */ int jhi;

    u$3(u uVar, Boolean bool, int i) {
        this.jFr = uVar;
        this.jhi = i;
        super(1000, bool);
    }

    protected final /* synthetic */ Object run() {
        return Boolean.valueOf(this.jFr.ll(this.jhi));
    }
}
