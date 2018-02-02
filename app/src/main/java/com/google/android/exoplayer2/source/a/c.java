package com.google.android.exoplayer2.source.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.h.f;
import com.google.android.exoplayer2.h.i;
import com.google.android.exoplayer2.i.t;
import java.util.Arrays;

public abstract class c extends a {
    private int asN;
    private volatile boolean asO;
    public byte[] data;

    public abstract void d(byte[] bArr, int i);

    public c(f fVar, i iVar, Format format, int i, Object obj, byte[] bArr) {
        super(fVar, iVar, 3, format, i, obj, -9223372036854775807L, -9223372036854775807L);
        this.data = bArr;
    }

    public final long kp() {
        return (long) this.asN;
    }

    public final void kq() {
        this.asO = true;
    }

    public final boolean kr() {
        return this.asO;
    }

    public final void ks() {
        int i = 0;
        try {
            this.aiB.a(this.asH);
            this.asN = 0;
            while (i != -1 && !this.asO) {
                if (this.data == null) {
                    this.data = new byte[16384];
                } else if (this.data.length < this.asN + 16384) {
                    this.data = Arrays.copyOf(this.data, this.data.length + 16384);
                }
                i = this.aiB.read(this.data, this.asN, 16384);
                if (i != -1) {
                    this.asN += i;
                }
            }
            if (!this.asO) {
                d(this.data, this.asN);
            }
            t.a(this.aiB);
        } catch (Throwable th) {
            t.a(this.aiB);
        }
    }
}
