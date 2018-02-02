package com.tencent.mm.vending.b;

import com.tencent.mm.vending.e.a;
import com.tencent.mm.vending.h.d;
import junit.framework.Assert;

public final class b<_Callback> implements a {
    public d ffh;
    private int mPriority = -1;
    private a zBM;
    public _Callback zBN;
    private int zBO;

    public final b<_Callback> a(com.tencent.mm.vending.e.b bVar) {
        Assert.assertNotNull(bVar);
        bVar.keep(this);
        return this;
    }

    public b(_Callback _Callback, a aVar) {
        Assert.assertNotNull("Callback should not be null!", _Callback);
        this.zBO = _Callback.hashCode();
        this.zBN = _Callback;
        this.zBM = aVar;
    }

    public final int hashCode() {
        return this.zBO;
    }

    public final boolean equals(Object obj) {
        return obj != null && obj.hashCode() == this.zBO;
    }

    public final void dead() {
        Assert.assertNotNull(this.zBM);
        this.zBM.b(this);
    }
}
