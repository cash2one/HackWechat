package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.a;

class k$1 implements a {
    final /* synthetic */ k Afe;
    private int position = 0;

    k$1(k kVar) {
        this.Afe = kVar;
    }

    public final byte readByte() {
        byte[] bArr = this.Afe.data;
        int i = this.position;
        this.position = i + 1;
        return bArr[i];
    }
}
