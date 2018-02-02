package com.tencent.mm.z;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.z.bo.a;

class bo$6 extends a {
    final /* synthetic */ bo hhJ;

    bo$6(bo boVar) {
        this.hhJ = boVar;
        super(boVar, (byte) 0);
    }

    public final boolean a(bm bmVar) {
        if (System.currentTimeMillis() - bmVar.hhB <= 1800000 || bh.getInt(bmVar.hhA, 0) <= 0) {
            return false;
        }
        bo.r(bmVar.key, bmVar.hhA);
        bmVar.hhA = "0";
        bmVar.hhB = System.currentTimeMillis();
        return true;
    }
}
