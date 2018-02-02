package com.tencent.mm.z;

import com.tencent.mm.z.bo.a;

class bo$17 extends a {
    final /* synthetic */ bo hhJ;

    bo$17(bo boVar) {
        this.hhJ = boVar;
        super(boVar, (byte) 0);
    }

    public final bm d(int i, Object... objArr) {
        bm bmVar = new bm();
        bmVar.key = i;
        if (objArr != null && objArr.length > 0) {
            bmVar.hhA = objArr[0];
        }
        bmVar.hhB = 0;
        return bmVar;
    }

    public final void a(bm bmVar, Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            bmVar.hhA = objArr[0];
        }
    }

    public final boolean a(bm bmVar) {
        if (System.currentTimeMillis() - bmVar.hhB <= 3600000 || bmVar.hhA.length() <= 0) {
            return false;
        }
        bo.r(bmVar.key, bmVar.hhA);
        bmVar.hhA = "";
        bmVar.hhB = System.currentTimeMillis();
        return true;
    }
}
