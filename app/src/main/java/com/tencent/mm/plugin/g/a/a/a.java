package com.tencent.mm.plugin.g.a.a;

public final class a {
    int[] kvS = null;

    public a(int[] iArr) {
        if (iArr.length == 0) {
            throw new NullPointerException("null == aDataGroup || 0 == aDataGroup.length");
        }
        this.kvS = iArr;
    }
}
