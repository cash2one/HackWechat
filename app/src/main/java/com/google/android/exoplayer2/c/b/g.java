package com.google.android.exoplayer2.c.b;

import com.google.android.exoplayer2.i.j;

final class g {
    public f amA;
    public int amB;
    public j amC;
    public boolean amD;
    public long amE;
    public c amn;
    public long amo;
    public long amp;
    public long amq;
    public int amr;
    public long[] ams;
    public int[] amt;
    public int[] amu;
    public int[] amv;
    public long[] amw;
    public boolean[] amx;
    public boolean amy;
    public boolean[] amz;
    public int sampleCount;

    g() {
    }

    public final void ct(int i) {
        if (this.amC == null || this.amC.asN < i) {
            this.amC = new j(i);
        }
        this.amB = i;
        this.amy = true;
        this.amD = true;
    }

    public final long cu(int i) {
        return this.amw[i] + ((long) this.amv[i]);
    }
}
