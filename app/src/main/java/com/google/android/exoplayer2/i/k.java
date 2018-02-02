package com.google.android.exoplayer2.i;

import com.tencent.wcdb.FileUtils;

public final class k {
    private int aCq;
    private int aCr;
    private int aCs;
    private byte[] data;

    public k(byte[] bArr, int i, int i2) {
        k(bArr, i, i2);
    }

    public final void k(byte[] bArr, int i, int i2) {
        this.data = bArr;
        this.aCq = i;
        this.aCs = i2;
        this.aCr = 0;
        lE();
    }

    public final void lL() {
        int i = this.aCr + 1;
        this.aCr = i;
        if (i == 8) {
            this.aCr = 0;
            this.aCq = (cX(this.aCq + 1) ? 2 : 1) + this.aCq;
        }
        lE();
    }

    public final void cS(int i) {
        int i2 = this.aCq;
        int i3 = i / 8;
        this.aCq += i3;
        this.aCr = (i - (i3 * 8)) + this.aCr;
        if (this.aCr > 7) {
            this.aCq++;
            this.aCr -= 8;
        }
        i2++;
        while (i2 <= this.aCq) {
            if (cX(i2)) {
                this.aCq++;
                i2 += 2;
            }
            i2++;
        }
        lE();
    }

    public final boolean cW(int i) {
        int i2 = this.aCq;
        int i3 = i / 8;
        int i4 = this.aCq + i3;
        i3 = (this.aCr + i) - (i3 * 8);
        if (i3 > 7) {
            i4++;
            i3 -= 8;
        }
        i2++;
        while (i2 <= i4 && i4 < this.aCs) {
            if (cX(i2)) {
                i4++;
                i2 += 2;
            }
            i2++;
        }
        return i4 < this.aCs || (i4 == this.aCs && i3 == 0);
    }

    public final boolean lC() {
        boolean z = (this.data[this.aCq] & (FileUtils.S_IWUSR >> this.aCr)) != 0;
        lL();
        return z;
    }

    public final int cT(int i) {
        int i2 = 2;
        this.aCr += i;
        int i3 = 0;
        while (this.aCr > 8) {
            this.aCr -= 8;
            i3 |= (this.data[this.aCq] & 255) << this.aCr;
            this.aCq = (cX(this.aCq + 1) ? 2 : 1) + this.aCq;
        }
        i3 = (i3 | ((this.data[this.aCq] & 255) >> (8 - this.aCr))) & (-1 >>> (32 - i));
        if (this.aCr == 8) {
            this.aCr = 0;
            int i4 = this.aCq;
            if (!cX(this.aCq + 1)) {
                i2 = 1;
            }
            this.aCq = i4 + i2;
        }
        lE();
        return i3;
    }

    public final boolean lM() {
        boolean z;
        int i = this.aCq;
        int i2 = this.aCr;
        int i3 = 0;
        while (this.aCq < this.aCs && !lC()) {
            i3++;
        }
        if (this.aCq == this.aCs) {
            z = true;
        } else {
            z = false;
        }
        this.aCq = i;
        this.aCr = i2;
        if (z || !cW((i3 * 2) + 1)) {
            return false;
        }
        return true;
    }

    public final int lN() {
        int lO = lO();
        return (lO % 2 == 0 ? -1 : 1) * ((lO + 1) / 2);
    }

    public final int lO() {
        int i = 0;
        int i2 = 0;
        while (!lC()) {
            i2++;
        }
        int i3 = (1 << i2) - 1;
        if (i2 > 0) {
            i = cT(i2);
        }
        return i3 + i;
    }

    private boolean cX(int i) {
        return 2 <= i && i < this.aCs && this.data[i] == (byte) 3 && this.data[i - 2] == (byte) 0 && this.data[i - 1] == (byte) 0;
    }

    private void lE() {
        boolean z = this.aCq >= 0 && (this.aCq < this.aCs || (this.aCq == this.aCs && this.aCr == 0));
        a.an(z);
    }
}
