package com.tencent.mm.z;

import com.tencent.mm.sdk.platformtools.bh;

class bo$20 extends bo$a {
    final /* synthetic */ bo hhJ;

    bo$20(bo boVar) {
        this.hhJ = boVar;
        super(boVar);
    }

    public final boolean a(bm bmVar) {
        if (System.currentTimeMillis() - bmVar.hhB <= 3600000 || bh.getInt(bmVar.hhA, 0) <= 0) {
            return false;
        }
        bo.r(bmVar.key, bmVar.hhA);
        bmVar.hhA = "0";
        bmVar.hhB = System.currentTimeMillis();
        return true;
    }
}
