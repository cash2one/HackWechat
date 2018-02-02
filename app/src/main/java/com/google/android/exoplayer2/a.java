package com.google.android.exoplayer2;

import com.google.android.exoplayer2.b.e;
import com.google.android.exoplayer2.i.f;
import com.google.android.exoplayer2.source.i;

public abstract class a implements r, s {
    private final int ach;
    public t aci;
    public i acj;
    public long ack;
    public boolean acl = true;
    public boolean acm;
    public int index;
    public int state;

    public a(int i) {
        this.ach = i;
    }

    public final int getTrackType() {
        return this.ach;
    }

    public final s hN() {
        return this;
    }

    public final void setIndex(int i) {
        this.index = i;
    }

    public f hO() {
        return null;
    }

    public final int getState() {
        return this.state;
    }

    public final void a(t tVar, Format[] formatArr, i iVar, long j, boolean z, long j2) {
        com.google.android.exoplayer2.i.a.an(this.state == 0);
        this.aci = tVar;
        this.state = 1;
        ac(z);
        a(formatArr, iVar, j2);
        a(j, z);
    }

    public final void start() {
        boolean z = true;
        if (this.state != 1) {
            z = false;
        }
        com.google.android.exoplayer2.i.a.an(z);
        this.state = 2;
        hV();
    }

    public final void a(Format[] formatArr, i iVar, long j) {
        com.google.android.exoplayer2.i.a.an(!this.acm);
        this.acj = iVar;
        this.acl = false;
        this.ack = j;
        a(formatArr, j);
    }

    public final i hP() {
        return this.acj;
    }

    public final boolean hQ() {
        return this.acl;
    }

    public final void hR() {
        this.acm = true;
    }

    public final boolean hS() {
        return this.acm;
    }

    public final void hT() {
        this.acj.kc();
    }

    public final void i(long j) {
        this.acm = false;
        this.acl = false;
        a(j, false);
    }

    public final void stop() {
        com.google.android.exoplayer2.i.a.an(this.state == 2);
        this.state = 1;
        onStopped();
    }

    public final void disable() {
        boolean z = true;
        if (this.state != 1) {
            z = false;
        }
        com.google.android.exoplayer2.i.a.an(z);
        this.state = 0;
        this.acj = null;
        this.acm = false;
        hW();
    }

    public int hU() {
        return 0;
    }

    public void c(int i, Object obj) {
    }

    public void ac(boolean z) {
    }

    public void a(Format[] formatArr, long j) {
    }

    public void a(long j, boolean z) {
    }

    public void hV() {
    }

    public void onStopped() {
    }

    public void hW() {
    }

    public final int a(k kVar, e eVar, boolean z) {
        int b = this.acj.b(kVar, eVar, z);
        if (b == -4) {
            if (eVar.iY()) {
                this.acl = true;
                if (this.acm) {
                    return -4;
                }
                return -3;
            }
            eVar.aig += this.ack;
        } else if (b == -5) {
            Format format = kVar.aeo;
            if (format.aej != Long.MAX_VALUE) {
                kVar.aeo = format.q(format.aej + this.ack);
            }
        }
        return b;
    }
}
