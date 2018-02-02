package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.mm.sdk.platformtools.bh;

public final class b {
    int fFy;
    int mvv;
    int nUr;
    byte[] otM;
    byte[] otN;
    int otO = 0;
    int otP = 0;
    long otQ = bh.Wq();
    int otR;
    int otS;
    int otT;
    int otU;
    boolean otV;
    boolean otW;

    public interface a {
        void a(b bVar);
    }

    public b(int i, int i2, int i3, int i4, int i5, boolean z, boolean z2, int i6, byte[] bArr) {
        this.otT = i3;
        this.nUr = i4;
        this.mvv = i5;
        this.otR = i;
        this.otS = i2;
        this.otW = z2;
        this.otV = z;
        this.fFy = i6;
        this.otM = bArr;
        this.otO = bArr.length;
        this.otN = j.ouM.h(Integer.valueOf(((i4 * i5) * 3) / 2));
    }
}
