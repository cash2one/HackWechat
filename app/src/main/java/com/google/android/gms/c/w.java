package com.google.android.gms.c;

import android.os.SystemClock;

public final class w implements v {
    private static w aXN;

    public static synchronized v pH() {
        v vVar;
        synchronized (w.class) {
            if (aXN == null) {
                aXN = new w();
            }
            vVar = aXN;
        }
        return vVar;
    }

    public final long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    public final long elapsedRealtime() {
        return SystemClock.elapsedRealtime();
    }
}
