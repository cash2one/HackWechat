package com.tencent.mm.network;

import com.tencent.mars.mm.MMLogic;
import com.tencent.mm.sdk.platformtools.bc;

class t$4 extends bc<Object> {
    final /* synthetic */ t hZT;
    final /* synthetic */ String[] hZV;
    final /* synthetic */ String[] hZW;
    final /* synthetic */ int[] hZX;

    t$4(t tVar, String[] strArr, String[] strArr2, int[] iArr) {
        this.hZT = tVar;
        this.hZV = strArr;
        this.hZW = strArr2;
        this.hZX = iArr;
        super(1000, null);
    }

    protected final Object run() {
        MMLogic.setHostInfo(this.hZV, this.hZW, this.hZX);
        return null;
    }
}
