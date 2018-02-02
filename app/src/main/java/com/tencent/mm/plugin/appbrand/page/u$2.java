package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import com.tencent.mm.sdk.platformtools.bc;

class u$2 extends bc<Boolean> {
    final /* synthetic */ int aar;
    final /* synthetic */ u jFr;
    final /* synthetic */ int jFs;
    final /* synthetic */ float[] jFt;
    final /* synthetic */ boolean jFu;
    final /* synthetic */ int jhi;
    final /* synthetic */ View zS;

    u$2(u uVar, Boolean bool, View view, int i, int i2, float[] fArr, int i3, boolean z) {
        this.jFr = uVar;
        this.zS = view;
        this.jhi = i;
        this.jFs = i2;
        this.jFt = fArr;
        this.aar = i3;
        this.jFu = z;
        super(1000, bool);
    }

    protected final /* synthetic */ Object run() {
        return Boolean.valueOf(this.jFr.b(this.zS, this.jhi, this.jFs, this.jFt, this.aar, this.jFu));
    }
}
