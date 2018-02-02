package com.google.android.exoplayer2.f.e;

import android.text.Layout.Alignment;
import com.google.android.exoplayer2.i.a;

final class d {
    String ayS;
    int ayT;
    boolean ayU;
    boolean ayV;
    int ayW = -1;
    int ayX = -1;
    int ayY = -1;
    int ayZ = -1;
    int aza = -1;
    float azb;
    d azc;
    Alignment azd;
    int backgroundColor;
    String id;

    public final int getStyle() {
        int i = 0;
        if (this.ayY == -1 && this.ayZ == -1) {
            return -1;
        }
        int i2 = this.ayY == 1 ? 1 : 0;
        if (this.ayZ == 1) {
            i = 2;
        }
        return i2 | i;
    }

    public final d aj(boolean z) {
        boolean z2;
        int i = 1;
        if (this.azc == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        a.an(z2);
        if (!z) {
            i = 0;
        }
        this.ayW = i;
        return this;
    }

    public final d ak(boolean z) {
        boolean z2;
        int i = 1;
        if (this.azc == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        a.an(z2);
        if (!z) {
            i = 0;
        }
        this.ayX = i;
        return this;
    }

    public final d cL(int i) {
        a.an(this.azc == null);
        this.ayT = i;
        this.ayU = true;
        return this;
    }

    public final d cM(int i) {
        this.backgroundColor = i;
        this.ayV = true;
        return this;
    }

    public final d b(d dVar) {
        if (dVar != null) {
            if (!this.ayU && dVar.ayU) {
                cL(dVar.ayT);
            }
            if (this.ayY == -1) {
                this.ayY = dVar.ayY;
            }
            if (this.ayZ == -1) {
                this.ayZ = dVar.ayZ;
            }
            if (this.ayS == null) {
                this.ayS = dVar.ayS;
            }
            if (this.ayW == -1) {
                this.ayW = dVar.ayW;
            }
            if (this.ayX == -1) {
                this.ayX = dVar.ayX;
            }
            if (this.azd == null) {
                this.azd = dVar.azd;
            }
            if (this.aza == -1) {
                this.aza = dVar.aza;
                this.azb = dVar.azb;
            }
            if (!this.ayV && dVar.ayV) {
                cM(dVar.backgroundColor);
            }
        }
        return this;
    }
}
