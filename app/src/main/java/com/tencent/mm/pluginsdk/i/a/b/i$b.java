package com.tencent.mm.pluginsdk.i.a.b;

enum i$b {
    DoNothing(0),
    DoCache(1),
    DoDecrypt(2),
    DoDelete(4);
    
    final int fDt;

    private i$b(int i) {
        this.fDt = i;
    }

    static boolean BL(int i) {
        return i == DoNothing.fDt;
    }

    static boolean BM(int i) {
        return (DoCache.fDt & i) > 0;
    }

    static boolean BN(int i) {
        return (DoDecrypt.fDt & i) > 0;
    }

    static boolean BO(int i) {
        return (DoDelete.fDt & i) > 0;
    }

    static int RT(String str) {
        if ("cache".equals(str)) {
            return DoCache.fDt;
        }
        if ("delete".equals(str)) {
            return DoDelete.fDt;
        }
        if ("decrypt".equals(str)) {
            return DoDecrypt.fDt;
        }
        return DoNothing.fDt;
    }
}
