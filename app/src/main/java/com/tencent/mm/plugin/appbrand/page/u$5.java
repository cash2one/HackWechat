package com.tencent.mm.plugin.appbrand.page;

import com.tencent.mm.sdk.platformtools.bc;

class u$5 extends bc<Boolean> {
    final /* synthetic */ int aar;
    final /* synthetic */ u jFr;
    final /* synthetic */ float[] jFt;
    final /* synthetic */ Boolean jFv;
    final /* synthetic */ int jhi;

    u$5(u uVar, Boolean bool, int i, float[] fArr, int i2, Boolean bool2) {
        this.jFr = uVar;
        this.jhi = i;
        this.jFt = fArr;
        this.aar = i2;
        this.jFv = bool2;
        super(1000, bool);
    }

    protected final /* synthetic */ Object run() {
        return Boolean.valueOf(this.jFr.b(this.jhi, this.jFt, this.aar, this.jFv));
    }
}
