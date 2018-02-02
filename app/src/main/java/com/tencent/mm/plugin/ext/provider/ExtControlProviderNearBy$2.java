package com.tencent.mm.plugin.ext.provider;

import com.tencent.mm.modelgeo.c;

class ExtControlProviderNearBy$2 implements Runnable {
    final /* synthetic */ ExtControlProviderNearBy maO;

    ExtControlProviderNearBy$2(ExtControlProviderNearBy extControlProviderNearBy) {
        this.maO = extControlProviderNearBy;
    }

    public final void run() {
        if (ExtControlProviderNearBy.a(this.maO) == null) {
            ExtControlProviderNearBy.a(this.maO, c.OP());
        }
        ExtControlProviderNearBy.a(this.maO).a(ExtControlProviderNearBy.b(this.maO), true);
    }
}
