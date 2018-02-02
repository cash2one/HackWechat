package com.google.android.exoplayer2.i;

import android.os.SystemClock;
import com.google.android.exoplayer2.b;
import com.google.android.exoplayer2.p;

public final class o implements f {
    private long aCE;
    public long aCF;
    private p acX = p.aev;
    public boolean started;

    public final void stop() {
        if (this.started) {
            K(iN());
            this.started = false;
        }
    }

    public final void K(long j) {
        this.aCE = j;
        if (this.started) {
            this.aCF = SystemClock.elapsedRealtime();
        }
    }

    public final void a(f fVar) {
        K(fVar.iN());
        this.acX = fVar.iU();
    }

    public final long iN() {
        long j = this.aCE;
        if (!this.started) {
            return j;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.aCF;
        if (this.acX.aew == 1.0f) {
            return j + b.k(elapsedRealtime);
        }
        return j + (elapsedRealtime * ((long) this.acX.aex));
    }

    public final p b(p pVar) {
        if (this.started) {
            K(iN());
        }
        this.acX = pVar;
        return pVar;
    }

    public final p iU() {
        return this.acX;
    }
}
