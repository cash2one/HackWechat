package com.google.android.gms.common;

import java.util.Arrays;

class j$ab extends j$a {
    private final byte[] aQq;

    j$ab(byte[] bArr) {
        super(Arrays.copyOfRange(bArr, 0, 25));
        this.aQq = bArr;
    }

    final byte[] getBytes() {
        return this.aQq;
    }
}
