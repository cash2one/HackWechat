package com.d.a.a;

import java.util.Arrays;

final class l {
    float biG;
    long biK;
    private final float[] biL = new float[3];
    private int biM;
    private long biN;
    long biO;

    l() {
    }

    final void a(float f, int i, long j) {
        long j2 = j - this.biN;
        if (j2 > this.biK) {
            Arrays.fill(this.biL, 0.0f);
            this.biM = 0;
            this.biN = 0;
            this.biO = 0;
            this.biG = 0.0f;
        } else {
            this.biO = j2 + this.biO;
        }
        this.biL[0] = this.biL[1];
        this.biL[1] = this.biL[2];
        this.biL[2] = f;
        if (this.biL[2] != 0.0f) {
            float f2 = this.biL[0] != 0.0f ? ((this.biL[0] + this.biL[1]) + this.biL[2]) / 3.0f : this.biL[1] != 0.0f ? (this.biL[1] + this.biL[2]) / 2.0f : this.biL[2];
            this.biG = ((((float) i) / (f2 + (this.biL[2] * 3.0f))) * y.bmO) + ((y.bmP * ((float) (i - this.biM))) / ((float) ((this.biM + i) + 1)));
        }
        this.biM = i;
        this.biN = j;
    }
}
