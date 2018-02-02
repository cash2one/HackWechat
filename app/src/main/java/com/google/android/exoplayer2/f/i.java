package com.google.android.exoplayer2.f;

import com.google.android.exoplayer2.b.f;
import java.util.List;

public abstract class i extends f implements d {
    private long aej;
    private d awd;

    public abstract void release();

    public final void a(long j, d dVar, long j2) {
        this.aig = j;
        this.awd = dVar;
        if (j2 == Long.MAX_VALUE) {
            j2 = this.aig;
        }
        this.aej = j2;
    }

    public final int kJ() {
        return this.awd.kJ();
    }

    public final long cH(int i) {
        return this.awd.cH(i) + this.aej;
    }

    public final int L(long j) {
        return this.awd.L(j - this.aej);
    }

    public final List<a> M(long j) {
        return this.awd.M(j - this.aej);
    }

    public final void clear() {
        super.clear();
        this.awd = null;
    }
}
