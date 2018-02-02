package com.tencent.mm.plugin.wenote.model.nativenote.c;

public final class b {
    public float iQK = -1.0f;
    public float iQL = -1.0f;
    public int kTK = 0;
    public float tUC = -1.0f;
    public float tUD = -1.0f;
    public int tUE = -1;
    public float tUF = -1.0f;
    public float tUG = -1.0f;
    public float tUH = -1.0f;
    public float tUI = -1.0f;
    public int tUJ = -1;

    public final void a(int i, float f, float f2, float f3, float f4, int i2) {
        this.kTK = i;
        this.tUC = f;
        this.tUD = f2;
        this.iQK = f3;
        this.iQL = f4;
        if (this.kTK == 1) {
            this.tUE = i2;
        } else {
            this.tUE = 0;
        }
    }

    public final void reset() {
        this.kTK = 0;
        this.tUC = -1.0f;
        this.tUD = -1.0f;
        this.iQK = -1.0f;
        this.iQL = -1.0f;
        this.tUE = -1;
        this.tUF = -1.0f;
        this.tUG = -1.0f;
        this.tUH = -1.0f;
        this.tUI = -1.0f;
        this.tUJ = -1;
    }

    public final int getType() {
        int i;
        int i2 = 0;
        if (this.tUC < 0.0f || this.tUD < 0.0f || this.iQK < 0.0f || this.iQL < 0.0f || this.tUE < 0) {
            i = 0;
        } else {
            i = 1;
        }
        if (i == 0) {
            return 0;
        }
        if (this.tUF >= 0.0f && this.tUG >= 0.0f && this.tUH >= 0.0f && this.tUI >= 0.0f && this.tUJ >= 0) {
            i2 = 1;
        }
        if (i2 == 0) {
            return 1;
        }
        i2 = Math.abs((int) (this.iQK - this.tUH));
        int abs = Math.abs((int) (this.iQL - this.tUI));
        if (i2 > 30 || abs > 30 || this.tUE != this.tUJ) {
            return 3;
        }
        return 2;
    }
}
