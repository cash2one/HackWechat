package com.tencent.mm.pluginsdk.i.a.b;

enum i$a {
    ENCRYPTION(1),
    COMPRESSION(2);
    
    final int fDt;

    private i$a(int i) {
        this.fDt = i;
    }

    static boolean BI(int i) {
        return (ENCRYPTION.fDt & i) > 0;
    }

    static boolean BJ(int i) {
        return (COMPRESSION.fDt & i) > 0;
    }

    static int bZp() {
        return ENCRYPTION.fDt | 0;
    }

    static int BK(int i) {
        return COMPRESSION.fDt | i;
    }
}
