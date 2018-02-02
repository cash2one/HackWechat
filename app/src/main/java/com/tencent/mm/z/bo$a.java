package com.tencent.mm.z;

import com.tencent.mm.sdk.platformtools.bh;

abstract class bo$a {
    final /* synthetic */ bo hhJ;

    public abstract boolean a(bm bmVar);

    private bo$a(bo boVar) {
        this.hhJ = boVar;
    }

    public bm d(int i, Object... objArr) {
        int i2 = 1;
        if (objArr != null && objArr.length > 0) {
            i2 = bh.o(objArr[0], 1);
        }
        bm bmVar = new bm();
        bmVar.key = i;
        bmVar.hhA = String.valueOf(i2);
        bmVar.hhB = 0;
        return bmVar;
    }

    public void a(bm bmVar, Object... objArr) {
        int i = 1;
        if (objArr != null && objArr.length > 0) {
            i = bh.o(objArr[0], 1);
        }
        bmVar.hhA = (i + bh.getInt(bmVar.hhA, 0));
    }
}
