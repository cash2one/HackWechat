package com.tencent.mm.plugin.talkroom.component;

import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.sdk.platformtools.bc;

class g$6 extends bc<byte[]> {
    final /* synthetic */ String lbm;
    final /* synthetic */ int[] saE;
    final /* synthetic */ g sav;

    g$6(g gVar, int[] iArr, String str) {
        this.sav = gVar;
        this.saE = iArr;
        this.lbm = str;
        super(3000, null);
    }

    protected final /* synthetic */ Object run() {
        PByteArray pByteArray = new PByteArray();
        this.saE[0] = g.a(this.sav).GetStatis(pByteArray, this.lbm);
        return pByteArray.value;
    }
}
