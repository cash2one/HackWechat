package com.google.android.gms.c;

import android.util.Base64;

public final class s {
    public static String j(byte[] bArr) {
        return bArr == null ? null : Base64.encodeToString(bArr, 0);
    }

    public static String k(byte[] bArr) {
        return bArr == null ? null : Base64.encodeToString(bArr, 10);
    }
}
