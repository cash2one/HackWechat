package com.google.android.exoplayer2.a;

import com.google.android.exoplayer2.i.a;
import java.util.Arrays;

final class k {
    float aew;
    private int ahA;
    short[] ahB;
    private int ahC;
    private short[] ahD;
    private int ahE;
    private int ahF;
    int ahG;
    int ahH;
    int ahI;
    int ahJ;
    private int ahK;
    private int ahL;
    private int ahM;
    private int ahN;
    final int aht;
    private final int ahu;
    private final int ahv;
    final int ahw = (this.ahv * 2);
    private final short[] ahx = new short[this.ahw];
    private int ahy = this.ahw;
    short[] ahz;
    float pitch;
    private final int sampleRate;

    public k(int i, int i2) {
        this.sampleRate = i;
        this.aht = i2;
        this.ahu = i / 400;
        this.ahv = i / 65;
        this.ahz = new short[(this.ahw * i2)];
        this.ahA = this.ahw;
        this.ahB = new short[(this.ahw * i2)];
        this.ahC = this.ahw;
        this.ahD = new short[(this.ahw * i2)];
        this.ahE = 0;
        this.ahF = 0;
        this.ahK = 0;
        this.aew = 1.0f;
        this.pitch = 1.0f;
    }

    private void bY(int i) {
        if (this.ahH + i > this.ahA) {
            this.ahA += (this.ahA / 2) + i;
            this.ahB = Arrays.copyOf(this.ahB, this.ahA * this.aht);
        }
    }

    final void bZ(int i) {
        if (this.ahG + i > this.ahy) {
            this.ahy += (this.ahy / 2) + i;
            this.ahz = Arrays.copyOf(this.ahz, this.ahy * this.aht);
        }
    }

    private void a(short[] sArr, int i, int i2) {
        bY(i2);
        System.arraycopy(sArr, this.aht * i, this.ahB, this.ahH * this.aht, this.aht * i2);
        this.ahH += i2;
    }

    private void b(short[] sArr, int i, int i2) {
        int i3 = this.ahw / i2;
        int i4 = this.aht * i2;
        int i5 = i * this.aht;
        for (int i6 = 0; i6 < i3; i6++) {
            int i7 = 0;
            for (int i8 = 0; i8 < i4; i8++) {
                i7 += sArr[((i6 * i4) + i5) + i8];
            }
            this.ahx[i6] = (short) (i7 / i4);
        }
    }

    private int a(short[] sArr, int i, int i2, int i3) {
        int i4 = 255;
        int i5 = 1;
        int i6 = i * this.aht;
        int i7 = 0;
        int i8 = 0;
        int i9 = i2;
        while (i9 <= i3) {
            int i10 = 0;
            int i11 = 0;
            while (i10 < i9) {
                int abs = Math.abs(sArr[i6 + i10] - sArr[(i6 + i9) + i10]) + i11;
                i10++;
                i11 = abs;
            }
            if (i11 * i8 < i5 * i9) {
                i5 = i11;
                i8 = i9;
            }
            if (i11 * i4 > i7 * i9) {
                i7 = i9;
            } else {
                i11 = i7;
                i7 = i4;
            }
            i9++;
            i4 = i7;
            i7 = i11;
        }
        this.ahM = i5 / i8;
        this.ahN = i7 / i4;
        return i8;
    }

    final void iW() {
        int i;
        int min;
        int a;
        int i2;
        int i3 = this.ahH;
        float f = this.aew / this.pitch;
        if (((double) f) <= 1.00001d && ((double) f) >= 0.99999d) {
            a(this.ahz, 0, this.ahG);
            this.ahG = 0;
        } else if (this.ahG >= this.ahw) {
            int i4 = this.ahG;
            i = 0;
            do {
                if (this.ahJ > 0) {
                    min = Math.min(this.ahw, this.ahJ);
                    a(this.ahz, i, min);
                    this.ahJ -= min;
                    i += min;
                } else {
                    short[] sArr = this.ahz;
                    min = this.sampleRate > 4000 ? this.sampleRate / 4000 : 1;
                    if (this.aht == 1 && min == 1) {
                        min = a(sArr, i, this.ahu, this.ahv);
                    } else {
                        b(sArr, i, min);
                        a = a(this.ahx, 0, this.ahu / min, this.ahv / min);
                        if (min != 1) {
                            i2 = a * min;
                            a = i2 - (min * 4);
                            i2 += min * 4;
                            if (a < this.ahu) {
                                min = this.ahu;
                            } else {
                                min = a;
                            }
                            if (i2 > this.ahv) {
                                a = this.ahv;
                            } else {
                                a = i2;
                            }
                            if (this.aht == 1) {
                                min = a(sArr, i, min, a);
                            } else {
                                b(sArr, i, 1);
                                min = a(this.ahx, 0, min, a);
                            }
                        } else {
                            min = a;
                        }
                    }
                    a = this.ahM;
                    Object obj = (a == 0 || this.ahK == 0) ? null : this.ahN > a * 3 ? null : a * 2 <= this.ahL * 3 ? null : 1;
                    int i5 = obj != null ? this.ahK : min;
                    this.ahL = this.ahM;
                    this.ahK = min;
                    if (((double) f) > 1.0d) {
                        short[] sArr2 = this.ahz;
                        if (f >= 2.0f) {
                            min = (int) (((float) i5) / (f - 1.0f));
                        } else {
                            this.ahJ = (int) ((((float) i5) * (2.0f - f)) / (f - 1.0f));
                            min = i5;
                        }
                        bY(min);
                        a(min, this.aht, this.ahB, this.ahH, sArr2, i, sArr2, i + i5);
                        this.ahH += min;
                        i += min + i5;
                    } else {
                        int i6;
                        Object obj2 = this.ahz;
                        if (f < 0.5f) {
                            i6 = (int) ((((float) i5) * f) / (1.0f - f));
                        } else {
                            this.ahJ = (int) ((((float) i5) * ((2.0f * f) - 1.0f)) / (1.0f - f));
                            i6 = i5;
                        }
                        bY(i5 + i6);
                        System.arraycopy(obj2, this.aht * i, this.ahB, this.ahH * this.aht, this.aht * i5);
                        a(i6, this.aht, this.ahB, this.ahH + i5, obj2, i + i5, obj2, i);
                        this.ahH += i5 + i6;
                        i += i6;
                    }
                }
            } while (this.ahw + i <= i4);
            min = this.ahG - i;
            System.arraycopy(this.ahz, this.aht * i, this.ahz, 0, this.aht * min);
            this.ahG = min;
        }
        if (this.pitch != 1.0f) {
            float f2 = this.pitch;
            if (this.ahH != i3) {
                a = (int) (((float) this.sampleRate) / f2);
                i2 = this.sampleRate;
                int i7 = a;
                while (true) {
                    if (i7 <= 16384 && i2 <= 16384) {
                        break;
                    }
                    i2 /= 2;
                    i7 /= 2;
                }
                min = this.ahH - i3;
                if (this.ahI + min > this.ahC) {
                    this.ahC += (this.ahC / 2) + min;
                    this.ahD = Arrays.copyOf(this.ahD, this.ahC * this.aht);
                }
                System.arraycopy(this.ahB, this.aht * i3, this.ahD, this.ahI * this.aht, this.aht * min);
                this.ahH = i3;
                this.ahI = min + this.ahI;
                for (a = 0; a < this.ahI - 1; a++) {
                    while ((this.ahE + 1) * i7 > this.ahF * i2) {
                        bY(1);
                        for (min = 0; min < this.aht; min++) {
                            sArr2 = this.ahB;
                            i = (this.ahH * this.aht) + min;
                            short[] sArr3 = this.ahD;
                            int i8 = (this.aht * a) + min;
                            short s = sArr3[i8];
                            short s2 = sArr3[i8 + this.aht];
                            int i9 = (this.ahE + 1) * i7;
                            i8 = i9 - (this.ahF * i2);
                            int i10 = i9 - (this.ahE * i7);
                            sArr2[i] = (short) (((s2 * (i10 - i8)) + (s * i8)) / i10);
                        }
                        this.ahF++;
                        this.ahH++;
                    }
                    this.ahE++;
                    if (this.ahE == i2) {
                        this.ahE = 0;
                        a.an(this.ahF == i7);
                        this.ahF = 0;
                    }
                }
                min = this.ahI - 1;
                if (min != 0) {
                    System.arraycopy(this.ahD, this.aht * min, this.ahD, 0, (this.ahI - min) * this.aht);
                    this.ahI -= min;
                }
            }
        }
    }

    private static void a(int i, int i2, short[] sArr, int i3, short[] sArr2, int i4, short[] sArr3, int i5) {
        for (int i6 = 0; i6 < i2; i6++) {
            int i7 = (i3 * i2) + i6;
            int i8 = (i5 * i2) + i6;
            int i9 = (i4 * i2) + i6;
            for (int i10 = 0; i10 < i; i10++) {
                sArr[i7] = (short) (((sArr2[i9] * (i - i10)) + (sArr3[i8] * i10)) / i);
                i7 += i2;
                i9 += i2;
                i8 += i2;
            }
        }
    }
}
