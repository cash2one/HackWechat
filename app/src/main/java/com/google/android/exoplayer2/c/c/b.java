package com.google.android.exoplayer2.c.c;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.a.a.a;
import com.google.android.exoplayer2.c.c.u.d;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.k;
import com.google.android.exoplayer2.i.i;
import com.google.android.exoplayer2.i.j;
import com.qq.taf.jce.JceStruct;

public final class b implements h {
    private final String ael;
    private Format aeo;
    long aig;
    private k alW;
    private final i amK;
    private final j amL;
    private String amM;
    private int amN;
    private boolean amO;
    private long amP;
    private int sampleSize;
    private int state;

    public b() {
        this(null);
    }

    public b(String str) {
        this.amK = new i(new byte[8]);
        this.amL = new j(this.amK.data);
        this.state = 0;
        this.ael = str;
    }

    public final void jx() {
        this.state = 0;
        this.amN = 0;
        this.amO = false;
    }

    public final void a(f fVar, d dVar) {
        dVar.jF();
        this.amM = dVar.jH();
        this.alW = fVar.ck(dVar.jG());
    }

    public final void c(long j, boolean z) {
        this.aig = j;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(j jVar) {
        while (jVar.lF() > 0) {
            int readUnsignedByte;
            switch (this.state) {
                case 0:
                    while (jVar.lF() > 0) {
                        if (this.amO) {
                            readUnsignedByte = jVar.readUnsignedByte();
                            if (readUnsignedByte == 119) {
                                this.amO = false;
                                Object obj = 1;
                                if (obj == null) {
                                    break;
                                }
                                this.state = 1;
                                this.amL.data[0] = JceStruct.STRUCT_END;
                                this.amL.data[1] = (byte) 119;
                                this.amN = 2;
                                break;
                            }
                            this.amO = readUnsignedByte == 11;
                        } else {
                            this.amO = jVar.readUnsignedByte() == 11;
                        }
                    }
                    break;
                case 1:
                    byte[] bArr = this.amL.data;
                    int min = Math.min(jVar.lF(), 8 - this.amN);
                    jVar.readBytes(bArr, this.amN, min);
                    this.amN += min;
                    if ((this.amN == 8 ? 1 : null) == null) {
                        break;
                    }
                    this.amK.cR(0);
                    a a = com.google.android.exoplayer2.a.a.a(this.amK);
                    if (!(this.aeo != null && a.aef == this.aeo.aef && a.sampleRate == this.aeo.sampleRate && a.mimeType == this.aeo.adV)) {
                        this.aeo = Format.a(this.amM, a.mimeType, -1, -1, a.aef, a.sampleRate, null, null, this.ael);
                        this.alW.f(this.aeo);
                    }
                    this.sampleSize = a.afs;
                    this.amP = (1000000 * ((long) a.sampleCount)) / ((long) this.aeo.sampleRate);
                    this.amL.cR(0);
                    this.alW.a(this.amL, 8);
                    this.state = 2;
                    break;
                case 2:
                    readUnsignedByte = Math.min(jVar.lF(), this.sampleSize - this.amN);
                    this.alW.a(jVar, readUnsignedByte);
                    this.amN = readUnsignedByte + this.amN;
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
