package com.tencent.mm.z;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.z.bo.a;

class bo$19 extends a {
    final /* synthetic */ bo hhJ;

    bo$19(bo boVar) {
        this.hhJ = boVar;
        super(boVar, (byte) 0);
    }

    public final boolean a(bm bmVar) {
        if (System.currentTimeMillis() - bmVar.hhB <= 86400000 || bh.getInt(bmVar.hhA, 0) <= 0) {
            return false;
        }
        bo.r(bmVar.key, "1");
        bmVar.hhA = "0";
        bmVar.hhB = System.currentTimeMillis();
        return true;
    }
}
