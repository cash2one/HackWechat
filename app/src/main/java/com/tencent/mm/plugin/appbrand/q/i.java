package com.tencent.mm.plugin.appbrand.q;

public final class i implements k {
    final k jSa;
    int jSb = 0;
    int jSc = -1;
    int jSd = -1;
    Object jSe = null;

    public i(k kVar) {
        this.jSa = kVar;
    }

    public final void alK() {
        if (this.jSb != 0) {
            switch (this.jSb) {
                case 1:
                    this.jSa.bN(this.jSc, this.jSd);
                    break;
                case 2:
                    this.jSa.bO(this.jSc, this.jSd);
                    break;
                case 3:
                    this.jSa.d(this.jSc, this.jSd, this.jSe);
                    break;
            }
            this.jSe = null;
            this.jSb = 0;
        }
    }

    public final void bN(int i, int i2) {
        if (this.jSb != 1 || i < this.jSc || i > this.jSc + this.jSd) {
            alK();
            this.jSc = i;
            this.jSd = i2;
            this.jSb = 1;
            return;
        }
        this.jSd += i2;
        this.jSc = Math.min(i, this.jSc);
    }

    public final void bO(int i, int i2) {
        if (this.jSb != 2 || this.jSc < i || this.jSc > i + i2) {
            alK();
            this.jSc = i;
            this.jSd = i2;
            this.jSb = 2;
            return;
        }
        this.jSd += i2;
        this.jSc = i;
    }

    public final void bP(int i, int i2) {
        alK();
        this.jSa.bP(i, i2);
    }

    public final void d(int i, int i2, Object obj) {
        if (this.jSb != 3 || i > this.jSc + this.jSd || i + i2 < this.jSc || this.jSe != obj) {
            alK();
            this.jSc = i;
            this.jSd = i2;
            this.jSe = obj;
            this.jSb = 3;
            return;
        }
        int i3 = this.jSc + this.jSd;
        this.jSc = Math.min(i, this.jSc);
        this.jSd = Math.max(i3, i + i2) - this.jSc;
    }
}
