package com.google.android.gms.tagmanager;

import java.util.Arrays;

class ap$b {
    final String aXw;
    final byte[] bdf;

    ap$b(String str, byte[] bArr) {
        this.aXw = str;
        this.bdf = bArr;
    }

    public final String toString() {
        return "KeyAndSerialized: key = " + this.aXw + " serialized hash = " + Arrays.hashCode(this.bdf);
    }
}
