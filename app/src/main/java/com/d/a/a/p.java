package com.d.a.a;

import android.os.SystemClock;

class p {
    final long bjx;
    final long bjy;
    final int what;

    private p(int i, long j, long j2) {
        this.what = i;
        this.bjx = j;
        this.bjy = j2;
    }

    p(int i) {
        this(i, System.currentTimeMillis(), SystemClock.elapsedRealtime());
    }
}
