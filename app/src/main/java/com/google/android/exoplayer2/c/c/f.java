package com.google.android.exoplayer2.c.c;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.a.h;
import com.google.android.exoplayer2.c.c.u.d;
import com.google.android.exoplayer2.c.k;
import com.google.android.exoplayer2.i.j;

public final class f implements h {
    private final String ael;
    private Format aeo;
    private long aig;
    private k alW;
    private final j amL = new j(new byte[15]);
    private int amN;
    private long amP;
    private String amW;
    private int ane;
    private int sampleSize;
    private int state;

    public f(String str) {
        this.amL.data[0] = Byte.MAX_VALUE;
        this.amL.data[1] = (byte) -2;
        this.amL.data[2] = Byte.MIN_VALUE;
        this.amL.data[3] = (byte) 1;
        this.state = 0;
        this.ael = str;
    }

    public final void jx() {
        this.state = 0;
        this.amN = 0;
        this.ane = 0;
    }

    public final void a(com.google.android.exoplayer2.c.f fVar, d dVar) {
        dVar.jF();
        this.amW = dVar.jH();
        this.alW = fVar.ck(dVar.jG());
    }

    public final void c(long j, boolean z) {
        this.aig = j;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(j jVar) {
        while (jVar.lF() > 0) {
            int i;
            switch (this.state) {
                case 0:
                    while (jVar.lF() > 0) {
                        this.ane <<= 8;
                        this.ane |= jVar.readUnsignedByte();
                        if (this.ane == 2147385345) {
                            this.ane = 0;
                            i = 1;
                            if (i == 0) {
                                break;
                            }
                            this.amN = 4;
                            this.state = 1;
                            break;
                        }
                    }
                    break;
                case 1:
                    byte[] bArr = this.amL.data;
                    int min = Math.min(jVar.lF(), 15 - this.amN);
                    jVar.readBytes(bArr, this.amN, min);
                    this.amN += min;
                    if (this.amN == 15) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    if (i == 0) {
                        break;
                    }
                    bArr = this.amL.data;
                    if (this.aeo == null) {
                        this.aeo = h.a(bArr, this.amW, this.ael);
                        this.alW.f(this.aeo);
                    }
                    this.sampleSize = h.g(bArr);
                    this.amP = (long) ((int) ((((long) h.f(bArr)) * 1000000) / ((long) this.aeo.sampleRate)));
                    this.amL.cR(0);
                    this.alW.a(this.amL, 15);
                    this.state = 2;
                    break;
                case 2:
                    i = Math.min(jVar.lF(), this.sampleSize - this.amN);
                    this.alW.a(jVar, i);
                    this.amN = i + this.amN;
                    if (this.amN != this.sampleSize) {
                        break;
                    }
                    this.alW.a(this.aig, 1, this.sampleSize, 0, null);
                    this.aig += this.amP;
                    this.state = 0;
                    break;
                default:
                    break;
            }
        }
    }

    public final void jy() {
    }
}
