package com.tencent.mm.plugin.appbrand.launching.a;

enum b {
    WALLET("weapp://wallet/", 1019),
    SEARCH_NATIVE_FEATURE("weapp://search/", 1005);
    
    final String hMi;
    final int scene;

    private b(String str, int i) {
        this.hMi = str;
        this.scene = i;
    }

    static String aie() {
        return "";
    }

    static int aif() {
        return 0;
    }

    static String aig() {
        return "";
    }
}
