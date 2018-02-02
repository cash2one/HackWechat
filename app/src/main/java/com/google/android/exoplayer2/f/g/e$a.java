package com.google.android.exoplayer2.f.g;

import android.text.Layout.Alignment;
import android.text.SpannableStringBuilder;

public final class e$a {
    Alignment avT;
    float avU;
    int avV;
    int avW;
    float avX;
    int avY;
    SpannableStringBuilder azE;
    long endTime;
    long startTime;
    float width;

    public e$a() {
        reset();
    }

    public final void reset() {
        this.startTime = 0;
        this.endTime = 0;
        this.azE = null;
        this.avT = null;
        this.avU = Float.MIN_VALUE;
        this.avV = Integer.MIN_VALUE;
        this.avW = Integer.MIN_VALUE;
        this.avX = Float.MIN_VALUE;
        this.avY = Integer.MIN_VALUE;
        this.width = Float.MIN_VALUE;
    }

    public final e le() {
        if (this.avX != Float.MIN_VALUE && this.avY == Integer.MIN_VALUE) {
            if (this.avT != null) {
                switch (e$1.azD[this.avT.ordinal()]) {
                    case 1:
                        this.avY = 0;
                        break;
                    case 2:
                        this.avY = 1;
                        break;
                    case 3:
                        this.avY = 2;
                        break;
                    default:
                        new StringBuilder("Unrecognized alignment: ").append(this.avT);
                        this.avY = 0;
                        break;
                }
            }
            this.avY = Integer.MIN_VALUE;
        }
        return new e(this.startTime, this.endTime, this.azE, this.avT, this.avU, this.avV, this.avW, this.avX, this.avY, this.width);
    }
}
