package com.google.android.exoplayer2.i;

import android.os.SystemClock;

final class p implements b {
    p() {
    }

    public final long elapsedRealtime() {
        return SystemClock.elapsedRealtime();
    }
}
