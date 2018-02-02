package com.google.android.gms.analytics;

public final class e {
    static String l(String str, int i) {
        if (i > 0) {
            return str + i;
        }
        com.google.android.gms.analytics.internal.e.b("index out of range for prefix", str);
        return "";
    }
}
