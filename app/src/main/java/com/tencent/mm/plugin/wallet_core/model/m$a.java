package com.tencent.mm.plugin.wallet_core.model;

public enum m$a {
    ;

    static {
        sNl = 1;
        sNm = 2;
        sNn = 3;
        sNo = new int[]{sNl, sNm, sNn};
    }

    public static int[] bLk() {
        return (int[]) sNo.clone();
    }
}
