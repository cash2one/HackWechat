package com.google.android.exoplayer2.c.c;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.c.u.d;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.k;
import com.google.android.exoplayer2.i.j;

public final class l implements h {
    private k alW;
    private boolean anh;
    private long anj;
    private final j aop = new j(10);
    private int aoq;
    private int sampleSize;

    public final void jx() {
        this.anh = false;
    }

    public final void a(f fVar, d dVar) {
        dVar.jF();
        this.alW = fVar.ck(dVar.jG());
        this.alW.f(Format.g(dVar.jH(), "application/id3"));
    }

    public final void c(long j, boolean z) {
        if (z) {
            this.anh = true;
            this.anj = j;
            this.sampleSize = 0;
            this.aoq = 0;
        }
    }

    public final void b(j jVar) {
        if (this.anh) {
            int lF = jVar.lF();
            if (this.aoq < 10) {
                int min = Math.min(lF, 10 - this.aoq);
                System.arraycopy(jVar.data, jVar.position, this.aop.data, this.aoq, min);
                if (min + this.aoq == 10) {
                    this.aop.cR(0);
                    if (73 == this.aop.readUnsignedByte() && 68 == this.aop.readUnsignedByte() && 51 == this.aop.readUnsignedByte()) {
                        this.aop.cV(3);
                        this.sampleSize = this.aop.lH() + 10;
                    } else {
                        this.anh = false;
                        return;
                    }
                }
            }
            lF = Math.min(lF, this.sampleSize - this.aoq);
            this.alW.a(jVar, lF);
            this.aoq = lF + this.aoq;
        }
    }

    public final void jy() {
        if (this.anh && this.sampleSize != 0 && this.aoq == this.sampleSize) {
            this.alW.a(this.anj, 1, this.sampleSize, 0, null);
            this.anh = false;
        }
    }
}
