package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.mm.pluginsdk.ui.h.d;
import com.tencent.mm.sdk.platformtools.x;

public final class o {
    d jtg = d.vjY;
    int kDP;
    int kDQ;
    int videoHeight;
    int videoWidth;
    int vyS;
    int vyT;
    boolean vyi;

    final void reset() {
        this.kDQ = 0;
        this.kDP = 0;
        this.videoHeight = 0;
        this.videoWidth = 0;
        this.vyT = 0;
        this.vyS = 0;
    }

    public final void a(d dVar) {
        x.i("MicroMsg.ViewSizeCache", "set scale type old[%s] new[%s]", new Object[]{this.jtg, dVar});
        this.jtg = dVar;
        reset();
    }

    final boolean u(int i, int i2, int i3, int i4) {
        if (this.kDP == i && this.kDQ == i2 && this.videoWidth == i3 && this.videoHeight == i4) {
            return true;
        }
        this.kDP = i;
        this.kDQ = i2;
        this.videoWidth = i3;
        this.videoHeight = i4;
        float f = (((float) this.videoWidth) * 1.0f) / ((float) this.videoHeight);
        float f2 = (((float) this.kDP) * 1.0f) / ((float) this.kDQ);
        if (this.jtg != d.vjY) {
            if (this.jtg == d.vka) {
                if (this.kDP < this.kDQ) {
                    this.vyT = (int) (((float) this.kDP) / f);
                    this.vyS = this.kDP;
                    if (this.vyT > this.kDQ) {
                        this.vyS = (int) (((float) this.kDQ) * f);
                        this.vyT = this.kDQ;
                    }
                } else {
                    this.vyS = (int) (((float) this.kDQ) * f);
                    this.vyT = this.kDQ;
                    if (this.vyS > this.kDP) {
                        this.vyT = (int) (((float) this.kDP) / f);
                        this.vyS = this.kDP;
                    }
                }
            } else if (this.jtg == d.vjZ) {
                this.vyT = this.kDQ;
                this.vyS = this.kDP;
            } else if (this.jtg == d.vkb) {
                if (this.kDP > this.kDQ) {
                    this.vyT = (int) (((float) this.kDP) / f);
                    this.vyS = this.kDP;
                    if (this.vyT < this.kDQ) {
                        this.vyS = (int) (((float) this.kDQ) * f);
                        this.vyT = this.kDQ;
                    }
                } else {
                    this.vyS = (int) (((float) this.kDQ) * f);
                    this.vyT = this.kDQ;
                    if (this.vyS < this.kDP) {
                        this.vyT = (int) (((float) this.kDP) / f);
                        this.vyS = this.kDP;
                    }
                }
            }
            x.d("MicroMsg.ViewSizeCache", "screen[%d, %d], video[%d, %d], measure[%d, %d] scale[%f, %f]", new Object[]{Integer.valueOf(this.kDP), Integer.valueOf(this.kDQ), Integer.valueOf(this.videoWidth), Integer.valueOf(this.videoHeight), Integer.valueOf(this.vyS), Integer.valueOf(this.vyT), Float.valueOf(f2), Float.valueOf(f)});
            return false;
        }
        if (this.vyi) {
            if (((double) Math.abs(f - f2)) > 0.05d) {
                if (this.kDP < this.kDQ) {
                    this.vyT = (int) (((float) this.kDP) / f);
                    this.vyS = this.kDP;
                } else {
                    this.vyS = (int) (((float) this.kDQ) * f);
                    this.vyT = this.kDQ;
                }
            } else if (this.kDP > this.kDQ) {
                this.vyT = (int) (((float) this.kDP) / f);
                this.vyS = this.kDP;
            } else {
                this.vyS = (int) (((float) this.kDQ) * f);
                this.vyT = this.kDQ;
            }
        } else if (this.kDP < this.kDQ) {
            this.vyT = (int) (((float) this.kDP) / f);
            this.vyS = this.kDP;
        } else {
            this.vyS = (int) (((float) this.kDQ) * f);
            this.vyT = this.kDQ;
        }
        x.d("MicroMsg.ViewSizeCache", "screen[%d, %d], video[%d, %d], measure[%d, %d] scale[%f, %f]", new Object[]{Integer.valueOf(this.kDP), Integer.valueOf(this.kDQ), Integer.valueOf(this.videoWidth), Integer.valueOf(this.videoHeight), Integer.valueOf(this.vyS), Integer.valueOf(this.vyT), Float.valueOf(f2), Float.valueOf(f)});
        return false;
    }
}
