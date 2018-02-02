package com.google.android.exoplayer2.c.c;

import com.google.android.exoplayer2.i.a;
import java.util.Arrays;

final class n {
    private boolean anv;
    private final int aov;
    boolean aow;
    public byte[] aox = new byte[131];
    public int aoy;

    public n(int i) {
        this.aov = i;
        this.aox[2] = (byte) 1;
    }

    public final void reset() {
        this.anv = false;
        this.aow = false;
    }

    public final void cw(int i) {
        boolean z = true;
        a.an(!this.anv);
        if (i != this.aov) {
            z = false;
        }
        this.anv = z;
        if (this.anv) {
            this.aoy = 3;
            this.aow = false;
        }
    }

    public final void f(byte[] bArr, int i, int i2) {
        if (this.anv) {
            int i3 = i2 - i;
            if (this.aox.length < this.aoy + i3) {
                this.aox = Arrays.copyOf(this.aox, (this.aoy + i3) * 2);
            }
            System.arraycopy(bArr, i, this.aox, this.aoy, i3);
            this.aoy = i3 + this.aoy;
        }
    }

    public final boolean cx(int i) {
        if (!this.anv) {
            return false;
        }
        this.aoy -= i;
        this.anv = false;
        this.aow = true;
        return true;
    }
}
