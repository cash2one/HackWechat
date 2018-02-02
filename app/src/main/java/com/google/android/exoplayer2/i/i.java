package com.google.android.exoplayer2.i;

import com.tencent.wcdb.FileUtils;

public final class i {
    public int aCq;
    public int aCr;
    private int aCs;
    public byte[] data;

    public i(byte[] bArr) {
        this(bArr, bArr.length);
    }

    public i(byte[] bArr, int i) {
        this.data = bArr;
        this.aCs = i;
    }

    public final void l(byte[] bArr, int i) {
        this.data = bArr;
        this.aCq = 0;
        this.aCr = 0;
        this.aCs = i;
    }

    public final int lA() {
        return ((this.aCs - this.aCq) * 8) - this.aCr;
    }

    public final int lB() {
        a.an(this.aCr == 0);
        return this.aCq;
    }

    public final void cR(int i) {
        this.aCq = i / 8;
        this.aCr = i - (this.aCq * 8);
        lE();
    }

    public final void cS(int i) {
        int i2 = i / 8;
        this.aCq += i2;
        this.aCr = (i - (i2 * 8)) + this.aCr;
        if (this.aCr > 7) {
            this.aCq++;
            this.aCr -= 8;
        }
        lE();
    }

    public final boolean lC() {
        boolean z;
        if ((this.data[this.aCq] & (FileUtils.S_IWUSR >> this.aCr)) != 0) {
            z = true;
        } else {
            z = false;
        }
        int i = this.aCr + 1;
        this.aCr = i;
        if (i == 8) {
            this.aCr = 0;
            this.aCq++;
        }
        lE();
        return z;
    }

    public final int cT(int i) {
        if (i == 0) {
            return 0;
        }
        this.aCr += i;
        int i2 = 0;
        while (this.aCr > 8) {
            this.aCr -= 8;
            byte[] bArr = this.data;
            int i3 = this.aCq;
            this.aCq = i3 + 1;
            i2 |= (bArr[i3] & 255) << this.aCr;
        }
        i2 = (i2 | ((this.data[this.aCq] & 255) >> (8 - this.aCr))) & (-1 >>> (32 - i));
        if (this.aCr == 8) {
            this.aCr = 0;
            this.aCq++;
        }
        lE();
        return i2;
    }

    public final void lD() {
        if (this.aCr != 0) {
            this.aCr = 0;
            this.aCq++;
            lE();
        }
    }

    public final void m(byte[] bArr, int i) {
        boolean z;
        if (this.aCr == 0) {
            z = true;
        } else {
            z = false;
        }
        a.an(z);
        System.arraycopy(this.data, this.aCq, bArr, 0, i);
        this.aCq += i;
        lE();
    }

    public final void lE() {
        boolean z = this.aCq >= 0 && (this.aCq < this.aCs || (this.aCq == this.aCs && this.aCr == 0));
        a.an(z);
    }
}
