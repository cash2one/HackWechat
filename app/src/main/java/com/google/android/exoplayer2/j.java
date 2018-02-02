package com.google.android.exoplayer2;

import java.util.HashSet;

public final class j {
    private static final HashSet<String> adQ = new HashSet();
    private static String adR = "goog.exo.core";

    public static synchronized String in() {
        String str;
        synchronized (j.class) {
            str = adR;
        }
        return str;
    }

    public static synchronized void K(String str) {
        synchronized (j.class) {
            if (adQ.add(str)) {
                adR += ", " + str;
            }
        }
    }
}
