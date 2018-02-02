package com.google.android.gms.analytics.internal;

public enum z {
    NONE,
    GZIP;

    public static z aF(String str) {
        return "GZIP".equalsIgnoreCase(str) ? GZIP : NONE;
    }
}
