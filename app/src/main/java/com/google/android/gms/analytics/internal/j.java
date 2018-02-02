package com.google.android.gms.analytics.internal;

import com.google.android.gms.c.v;
import com.google.android.gms.common.internal.w;

final class j {
    private final v aFD;
    long aFE;

    public j(v vVar) {
        w.ag(vVar);
        this.aFD = vVar;
    }

    public j(v vVar, long j) {
        w.ag(vVar);
        this.aFD = vVar;
        this.aFE = j;
    }

    public final boolean V(long j) {
        return this.aFE == 0 || this.aFD.elapsedRealtime() - this.aFE > j;
    }

    public final void start() {
        this.aFE = this.aFD.elapsedRealtime();
    }
}
