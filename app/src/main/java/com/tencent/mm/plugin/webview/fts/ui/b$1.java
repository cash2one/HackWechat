package com.tencent.mm.plugin.webview.fts.ui;

import android.view.View;
import com.tencent.mm.sdk.platformtools.bc;

class b$1 extends bc<Boolean> {
    final /* synthetic */ int aar;
    final /* synthetic */ int jFs = 0;
    final /* synthetic */ float[] jFt;
    final /* synthetic */ int jhi;
    final /* synthetic */ b trB;
    final /* synthetic */ View zS;

    public b$1(b bVar, Boolean bool, View view, int i, int i2, float[] fArr, int i3) {
        this.trB = bVar;
        this.zS = view;
        this.jhi = i;
        this.jFt = fArr;
        this.aar = i3;
        super(1000, bool);
    }

    protected final /* synthetic */ Object run() {
        return Boolean.valueOf(this.trB.a(this.zS, this.jhi, this.jFs, this.jFt, this.aar));
    }
}
