package com.tencent.mm.vending.base;

import com.tencent.mm.vending.base.Vending.a;
import com.tencent.mm.vending.base.Vending.i;

final class Vending$c<_Index> {
    a<_Index> zBq;
    i zBr;

    private Vending$c() {
        this.zBq = new a((byte) 0);
    }

    public final void reset() {
        this.zBq.object = null;
        this.zBr = null;
    }
}
