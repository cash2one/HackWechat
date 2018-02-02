package com.d.a.a;

import java.lang.reflect.Array;

final class j {
    private final b bhA = new b((byte) 0);
    private double[] bhy = new double[4];
    final b bhz = new b((byte) 0);

    j() {
    }

    protected final void a(long j, double d, double d2, float f, boolean z, boolean z2) {
        double d3 = (double) j;
        double[] dArr = new double[]{d, d2};
        double d4 = (double) (f * f);
        double[] dArr2 = new double[]{0.0d, 0.0d};
        int i = z ? 3 : 5;
        double[] dArr3 = new double[]{d, d2};
        this.bhz.bip = true;
        this.bhz.biw[0] = 3.0d;
        this.bhz.biw[1] = 1.2d;
        this.bhz.biu = 0.5d;
        this.bhz.bhO = 1.2d;
        this.bhz.bhU = 4.0d;
        this.bhz.bhV = 0;
        this.bhz.bhX = true;
        this.bhz.bhW = i;
        this.bhz.bhP = false;
        this.bhz.bhS = false;
        this.bhz.bid = 40.0d;
        this.bhz.bie = 0.15707963267948966d;
        this.bhz.bif = 1.0d;
        this.bhz.biv[0] = 400.0d;
        this.bhz.biv[1] = 1.0d;
        this.bhz.bii = z2;
        this.bhz.bij = false;
        this.bhz.bhY = true;
        this.bhz.bhZ = 0.3333333333333333d;
        this.bhz.bia = 5.0d;
        this.bhz.bib = 0.5d;
        this.bhz.bic = 1.0d;
        this.bhz.biq = 0.5d;
        this.bhz.bir = 1.0d;
        this.bhz.bis = 0;
        this.bhz.bit = 2;
        this.bhz.bix = false;
        this.bhz.big[0] = dArr3[0];
        this.bhz.big[1] = dArr3[1];
        double[] dArr4 = new double[2];
        a(0, dArr, dArr4);
        this.bhz.bhB = d3;
        this.bhz.bik[0] = dArr4[0];
        this.bhz.bik[1] = dArr4[1];
        this.bhz.bik[2] = dArr2[0];
        this.bhz.bik[3] = dArr2[1];
        this.bhz.bim = 0.0d;
        this.bhz.bin = 1.0d;
        this.bhz.bio = 1.005d;
        this.bhz.bil[0][0] = d4;
        this.bhz.bil[0][1] = 0.0d;
        this.bhz.bil[0][2] = 0.0d;
        this.bhz.bil[0][3] = 0.0d;
        this.bhz.bil[1][0] = 0.0d;
        this.bhz.bil[1][1] = d4;
        this.bhz.bil[1][2] = 0.0d;
        this.bhz.bil[1][3] = 0.0d;
        this.bhz.bil[2][0] = 0.0d;
        this.bhz.bil[2][1] = 0.0d;
        this.bhz.bil[2][2] = 1.0d;
        this.bhz.bil[2][3] = 0.0d;
        this.bhz.bil[3][0] = 0.0d;
        this.bhz.bil[3][1] = 0.0d;
        this.bhz.bil[3][2] = 0.0d;
        this.bhz.bil[3][3] = 1.0d;
        ax(z);
    }

    protected final void ax(boolean z) {
        boolean z2;
        if (z) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (this.bhz.bip != z2) {
            this.bhz.bip = z2;
            if (z2) {
                this.bhz.bhO = this.bhz.biw[1];
                this.bhz.bif = this.bhz.biv[1];
                a(this.bhz.bhB, true);
                return;
            }
            this.bhz.bhO = this.bhz.biw[0];
            this.bhz.bif = this.bhz.biv[0];
            a(this.bhz.bhB, true);
        }
    }

    protected final void a(a aVar) {
        if (aVar.bhG > 0.0d) {
            double d;
            if (this.bhz.bhP) {
                d = aVar.bhB - this.bhz.bhR;
                if (d < -10.0d) {
                    return;
                }
                if (d <= 0.0d) {
                    aVar.bhB = this.bhz.bhR + 0.5d;
                }
            }
            r12 = new double[2];
            a(0, new double[]{aVar.bhC, aVar.bhD}, r12);
            aVar.bhE[0] = r12[0];
            aVar.bhE[1] = r12[1];
            double[][] dArr;
            double[] dArr2;
            double d2;
            double sqrt;
            double d3;
            Object obj;
            int i;
            int i2;
            if (this.bhz.bip) {
                if (aVar.mType != 3 || this.bhz.bhP) {
                    double d4;
                    double d5;
                    double[] dArr3;
                    if (aVar.mType == 3) {
                        d4 = aVar.bhB - this.bhz.bhR;
                        if (d4 > 0.0d) {
                            dArr = (double[][]) Array.newInstance(Double.TYPE, new int[]{2, 2});
                            dArr2 = new double[2];
                            d5 = r12[0] - this.bhz.bhQ[0];
                            d2 = r12[1] - this.bhz.bhQ[1];
                            if (this.bhz.bii) {
                                d5 = (d5 * Math.cos(this.bhz.bim)) - (Math.sin(this.bhz.bim) * d2);
                                d2 = (d2 * Math.cos(this.bhz.bim)) + (Math.sin(this.bhz.bim) * d5);
                            }
                            sqrt = Math.sqrt((d5 * d5) + (d2 * d2));
                            d3 = sqrt / this.bhz.bid;
                            d3 *= d3;
                            if (d3 <= 0.0625d) {
                                d3 = 0.0625d;
                            }
                            sqrt *= this.bhz.bie;
                            sqrt *= sqrt;
                            if (sqrt <= 0.0625d) {
                                sqrt = 0.0625d;
                            }
                            d3 = (d3 + sqrt) / d4;
                            b(new double[]{this.bhz.bil[2][2], this.bhz.bil[2][3], this.bhz.bil[3][2], this.bhz.bil[3][3]}, this.bhy);
                            dArr[0][0] = this.bhy[0];
                            dArr[0][1] = this.bhy[1];
                            dArr[1][0] = this.bhy[2];
                            dArr[1][1] = this.bhy[3];
                            sqrt = (d5 / d4) - this.bhz.bik[2];
                            double d6 = (d2 / d4) - this.bhz.bik[3];
                            if (Math.sqrt((((sqrt * d6) * dArr[1][0]) + (((sqrt * sqrt) * dArr[0][0]) + ((sqrt * d6) * dArr[0][1]))) + ((d6 * d6) * dArr[1][1])) > 2.0d) {
                                this.bhz.bil[2][2] = this.bhz.bif;
                                this.bhz.bil[2][3] = 0.0d;
                                this.bhz.bil[3][2] = 0.0d;
                                this.bhz.bil[3][3] = this.bhz.bif;
                                dArr[0][0] = 1.0d / this.bhz.bif;
                                dArr[0][1] = 0.0d;
                                dArr[1][0] = 0.0d;
                                dArr[1][1] = 1.0d / this.bhz.bif;
                            }
                            dArr2[0] = (dArr[0][0] * this.bhz.bik[2]) + (dArr[0][1] * this.bhz.bik[3]);
                            dArr2[1] = (dArr[1][0] * this.bhz.bik[2]) + (dArr[1][1] * this.bhz.bik[3]);
                            dArr3 = dArr[0];
                            dArr3[0] = dArr3[0] + (1.0d / d3);
                            dArr3 = dArr[1];
                            dArr3[1] = dArr3[1] + (1.0d / d3);
                            dArr2[0] = (d5 / (d4 * d3)) + dArr2[0];
                            dArr2[1] = (d2 / (d3 * d4)) + dArr2[1];
                            b(new double[]{dArr[0][0], dArr[0][1], dArr[1][0], dArr[1][1]}, this.bhy);
                            this.bhz.bil[2][2] = this.bhy[0];
                            this.bhz.bil[2][3] = this.bhy[1];
                            this.bhz.bil[3][2] = this.bhy[2];
                            this.bhz.bil[3][3] = this.bhy[3];
                            this.bhz.bik[2] = (this.bhz.bil[2][2] * dArr2[0]) + (this.bhz.bil[2][3] * dArr2[1]);
                            this.bhz.bik[3] = (this.bhz.bil[3][2] * dArr2[0]) + (this.bhz.bil[3][3] * dArr2[1]);
                            a(aVar.bhB, false);
                        }
                    } else {
                        dArr3 = new double[2];
                        double[] dArr4 = new double[2];
                        a(aVar.bhB, false);
                        if (this.bhz.bhY) {
                            Object obj2;
                            if (this.bhz.bhS) {
                                dArr3[0] = this.bhz.bik[0] - this.bhz.bhT[0];
                                dArr3[1] = this.bhz.bik[1] - this.bhz.bhT[1];
                                dArr4[0] = r12[0] - this.bhz.bhT[0];
                                dArr4[1] = r12[1] - this.bhz.bhT[1];
                                d5 = Math.sqrt((dArr3[0] * dArr3[0]) + (dArr3[1] * dArr3[1]));
                                d3 = Math.sqrt((dArr4[0] * dArr4[0]) + (dArr4[1] * dArr4[1]));
                                if (d3 > this.bhz.bia && d5 > this.bhz.bia) {
                                    d2 = d3 / d5;
                                    d = d3 - d5;
                                    d4 = Math.sqrt(this.bhz.bil[0][0] + this.bhz.bil[1][1]);
                                    if (d5 > 3.0d * this.bhz.bia) {
                                        if (d < 0.0d) {
                                            d = -d;
                                        }
                                        d2 = d / d4;
                                        d = Math.atan2(dArr4[1], dArr4[0]) - Math.atan2(dArr3[1], dArr3[0]);
                                        if (d > 3.141592653589793d) {
                                            d -= 6.283185307179586d;
                                        } else if (d < -3.141592653589793d) {
                                            d += 6.283185307179586d;
                                        }
                                        if (d < 0.0d) {
                                            d = -d;
                                        }
                                        d /= Math.sqrt(this.bhz.bin);
                                        d = Math.sqrt((d * d) + (d2 * d2));
                                        if (d < this.bhz.bhU) {
                                            this.bhz.bis = 0;
                                        } else if (d2 < this.bhz.bhU) {
                                            b bVar = this.bhz;
                                            int i3 = bVar.bis + 1;
                                            bVar.bis = i3;
                                            if (i3 >= this.bhz.bit) {
                                                this.bhz.bis = 0;
                                                d = d2;
                                            }
                                        }
                                        if (d > this.bhz.bhU) {
                                            obj2 = null;
                                            obj = null;
                                        } else {
                                            i = 1;
                                            i2 = 1;
                                        }
                                    } else if (d2 < this.bhz.bhZ || 1.0d / d2 < this.bhz.bhZ) {
                                        obj2 = null;
                                        obj = null;
                                    } else {
                                        obj2 = null;
                                        i2 = 1;
                                    }
                                } else if ((d3 >= this.bhz.bia || aVar.mType != 2) && (d3 >= this.bhz.bia * 0.5d || aVar.mType != 1)) {
                                    obj2 = null;
                                    i2 = 1;
                                } else {
                                    obj2 = null;
                                    obj = null;
                                }
                            } else {
                                d3 = 0.0d;
                                d5 = 0.0d;
                                obj2 = 1;
                                obj = 1;
                            }
                            if (obj != null) {
                                if (this.bhz.bhS) {
                                    if (d3 < d5) {
                                        d = this.bhz.bib;
                                    } else {
                                        d = this.bhz.bic;
                                    }
                                    d += (d5 / d3) * (1.0d - d);
                                    r12[0] = this.bhz.bhT[0] + (dArr4[0] * d);
                                    r12[1] = (d * dArr4[1]) + this.bhz.bhT[1];
                                }
                                if (obj2 != null) {
                                    a(r12);
                                } else {
                                    this.bhz.bhT[0] = r12[0];
                                    this.bhz.bhT[1] = r12[1];
                                }
                                this.bhz.bik[0] = r12[0];
                                this.bhz.bik[1] = r12[1];
                                this.bhz.bil[0][0] = aVar.bhG * aVar.bhG;
                                this.bhz.bil[0][1] = 0.0d;
                                this.bhz.bil[1][0] = 0.0d;
                                this.bhz.bil[1][1] = aVar.bhG * aVar.bhG;
                            }
                        } else {
                            b.a(this.bhA, this.bhz);
                            b(aVar.bhB, false);
                            if (!this.bhA.bhX) {
                                d2 = r12[0] - this.bhA.bik[0];
                                d5 = r12[1] - this.bhA.bik[1];
                                dArr = (double[][]) Array.newInstance(Double.TYPE, new int[]{2, 2});
                                d3 = 1.0d / ((this.bhA.bil[0][0] * this.bhA.bil[1][1]) - (this.bhA.bil[0][1] * this.bhA.bil[1][0]));
                                dArr[0][0] = this.bhA.bil[1][1] * d3;
                                dArr[1][1] = this.bhA.bil[0][0] * d3;
                                dArr[0][1] = (-this.bhA.bil[0][1]) * d3;
                                dArr[1][0] = d3 * (-this.bhA.bil[1][0]);
                                d = Math.sqrt((dArr[1][1] * (d5 * d5)) + ((((d2 * 2.0d) * d5) * dArr[1][0]) + ((d2 * d2) * dArr[0][0])));
                            } else if (this.bhz.bhS) {
                                d = this.bhz.bhT[0] - this.bhA.bik[0];
                                d2 = this.bhz.bhT[1] - this.bhA.bik[1];
                                d5 = this.bhz.bhT[0] - r12[0];
                                d3 = this.bhz.bhT[1] - r12[1];
                                d = Math.sqrt((d * d) + (d2 * d2)) - Math.sqrt((d5 * d5) + (d3 * d3));
                                d = Math.abs(d) / Math.sqrt((this.bhz.bil[0][0] * this.bhz.bil[0][0]) + (this.bhz.bil[1][1] * this.bhz.bil[1][1]));
                            } else {
                                d = 0.0d;
                            }
                            if (d > this.bhz.bhU) {
                                b.a(this.bhA, this.bhz);
                                b(aVar.bhB, true);
                                if (this.bhz.bhX) {
                                    d = this.bhz.bhT[0] - this.bhA.bik[0];
                                    d2 = this.bhz.bhT[1] - this.bhA.bik[1];
                                    d5 = this.bhz.bhT[0] - r12[0];
                                    d3 = this.bhz.bhT[1] - r12[1];
                                    d = Math.sqrt((d * d) + (d2 * d2)) - Math.sqrt((d5 * d5) + (d3 * d3));
                                    d = Math.abs(d) / Math.sqrt((this.bhA.bil[0][0] * this.bhA.bil[0][0]) + (this.bhA.bil[1][1] * this.bhA.bil[1][1]));
                                } else {
                                    d2 = r12[0] - this.bhA.bik[0];
                                    d5 = r12[1] - this.bhA.bik[1];
                                    dArr = (double[][]) Array.newInstance(Double.TYPE, new int[]{2, 2});
                                    d3 = 1.0d / ((this.bhA.bil[0][0] * this.bhA.bil[1][1]) - (this.bhA.bil[0][1] * this.bhA.bil[1][0]));
                                    dArr[0][0] = this.bhA.bil[1][1] * d3;
                                    dArr[1][1] = this.bhA.bil[0][0] * d3;
                                    dArr[0][1] = (-this.bhA.bil[0][1]) * d3;
                                    dArr[1][0] = d3 * (-this.bhA.bil[1][0]);
                                    d = Math.sqrt((dArr[1][1] * (d5 * d5)) + ((((d2 * 2.0d) * d5) * dArr[1][0]) + ((d2 * d2) * dArr[0][0])));
                                }
                                if (d <= this.bhA.bhU) {
                                    b.a(this.bhz, this.bhA);
                                    this.bhz.bhV = 0;
                                    a(r12);
                                } else if (this.bhz.bhV < this.bhz.bhW) {
                                    this.bhz.bhV++;
                                } else {
                                    b.a(this.bhz, this.bhA);
                                    this.bhz.bhV = 0;
                                }
                            } else {
                                b.a(this.bhz, this.bhA);
                                this.bhz.bhV = 0;
                                a(r12);
                            }
                            this.bhz.bik[0] = r12[0];
                            this.bhz.bik[1] = r12[1];
                            this.bhz.bil[0][0] = aVar.bhG * aVar.bhG;
                            this.bhz.bil[0][1] = 0.0d;
                            this.bhz.bil[1][0] = 0.0d;
                            this.bhz.bil[1][1] = aVar.bhG * aVar.bhG;
                        }
                    }
                }
                if (aVar.mType == 3) {
                    this.bhz.bhQ[0] = r12[0];
                    this.bhz.bhQ[1] = r12[1];
                    this.bhz.bhR = aVar.bhB;
                    this.bhz.bhP = true;
                }
            } else if (aVar.mType != 3) {
                Object obj3;
                double[] dArr5 = new double[2];
                double[] dArr6 = new double[2];
                double[] dArr7 = new double[2];
                a(aVar.bhB, false);
                if (this.bhz.bhS) {
                    dArr = (double[][]) Array.newInstance(Double.TYPE, new int[]{2, 2});
                    dArr5[0] = aVar.bhE[0] - this.bhz.bik[0];
                    dArr5[1] = aVar.bhE[1] - this.bhz.bik[1];
                    b(new double[]{this.bhz.bil[0][0], this.bhz.bil[0][1], this.bhz.bil[1][0], this.bhz.bil[1][1]}, this.bhy);
                    dArr[0][0] = this.bhy[0];
                    dArr[0][1] = this.bhy[1];
                    dArr[1][0] = this.bhy[2];
                    dArr[1][1] = this.bhy[3];
                    if (Math.sqrt((((dArr5[0] * dArr5[0]) * dArr[0][0]) + (((2.0d * dArr5[0]) * dArr5[1]) * dArr[1][0])) + ((dArr5[1] * dArr5[1]) * dArr[1][1])) > this.bhz.bhU) {
                        b bVar2 = this.bhz;
                        i = bVar2.bhV + 1;
                        bVar2.bhV = i;
                        if (i >= this.bhz.bhW) {
                            obj3 = 1;
                            obj = null;
                            this.bhz.bhV = 0;
                        } else {
                            obj3 = null;
                            obj = null;
                        }
                    } else {
                        this.bhz.bhV = 0;
                        obj3 = 1;
                        obj = 1;
                    }
                } else {
                    obj3 = 1;
                    obj = null;
                    this.bhz.bhV = 0;
                }
                if (obj3 == null) {
                    return;
                }
                if (obj == null) {
                    this.bhz.bik[0] = aVar.bhE[0];
                    this.bhz.bik[1] = aVar.bhE[1];
                    this.bhz.bik[2] = 0.0d;
                    this.bhz.bik[3] = 0.0d;
                    this.bhz.bil[0][0] = aVar.bhG * aVar.bhG;
                    this.bhz.bil[0][1] = 0.0d;
                    this.bhz.bil[0][2] = 0.0d;
                    this.bhz.bil[0][3] = 0.0d;
                    this.bhz.bil[1][0] = 0.0d;
                    this.bhz.bil[1][1] = this.bhz.bil[0][0];
                    this.bhz.bil[1][2] = 0.0d;
                    this.bhz.bil[1][2] = 0.0d;
                    this.bhz.bil[2][0] = 0.0d;
                    this.bhz.bil[2][1] = 0.0d;
                    this.bhz.bil[2][2] = this.bhz.bif;
                    this.bhz.bil[2][3] = 0.0d;
                    this.bhz.bil[3][0] = 0.0d;
                    this.bhz.bil[3][1] = 0.0d;
                    this.bhz.bil[3][2] = 0.0d;
                    this.bhz.bil[3][3] = this.bhz.bif;
                    this.bhz.bhT[0] = aVar.bhE[0];
                    this.bhz.bhT[1] = aVar.bhE[1];
                    this.bhz.bhS = true;
                    return;
                }
                dArr = (double[][]) Array.newInstance(Double.TYPE, new int[]{4, 4});
                double[] dArr8 = new double[]{this.bhz.bik[0] - this.bhz.bhT[0], this.bhz.bik[1] - this.bhz.bhT[1]};
                dArr7[0] = aVar.bhE[0] - this.bhz.bhT[0];
                dArr7[1] = aVar.bhE[1] - this.bhz.bhT[1];
                d3 = Math.sqrt((dArr7[0] * dArr7[0]) + (dArr7[1] * dArr7[1]));
                sqrt = Math.sqrt((dArr6[1] * dArr6[1]) + (dArr6[0] * dArr6[0]));
                if (d3 < sqrt) {
                    d2 = this.bhz.biq;
                } else {
                    d2 = this.bhz.bir;
                }
                if (a(this.bhz.bil, dArr)) {
                    int i4;
                    double d7 = 1.0d / (aVar.bhG * aVar.bhG);
                    double[] dArr9 = new double[4];
                    if (this.bhz.bix) {
                        d2 += (sqrt / d3) * (1.0d - d2);
                        dArr8[0] = this.bhz.bhT[0] + (dArr7[0] * d2);
                        dArr8[1] = (d2 * dArr7[1]) + this.bhz.bhT[1];
                    } else {
                        dArr8[0] = (this.bhz.bik[0] * (1.0d - d2)) + (aVar.bhE[0] * d2);
                        dArr8[1] = (d2 * aVar.bhE[1]) + (this.bhz.bik[1] * (1.0d - d2));
                    }
                    for (i = 0; i < 4; i++) {
                        dArr9[i] = 0.0d;
                        for (i4 = 0; i4 < 4; i4++) {
                            dArr9[i] = dArr9[i] + (dArr[i][i4] * this.bhz.bik[i4]);
                        }
                    }
                    dArr2 = dArr[0];
                    dArr2[0] = dArr2[0] + d7;
                    dArr2 = dArr[1];
                    dArr2[1] = dArr2[1] + d7;
                    if (a(dArr, this.bhz.bil)) {
                        dArr9[0] = dArr9[0] + (dArr8[0] * d7);
                        dArr9[1] = dArr9[1] + (dArr8[1] * d7);
                        for (i4 = 0; i4 < 4; i4++) {
                            this.bhz.bik[i4] = 0.0d;
                            for (i2 = 0; i2 < 4; i2++) {
                                dArr5 = this.bhz.bik;
                                dArr5[i4] = dArr5[i4] + (this.bhz.bil[i4][i2] * dArr9[i2]);
                            }
                        }
                        this.bhz.bhT[0] = dArr8[0];
                        this.bhz.bhT[1] = dArr8[1];
                    }
                }
            }
        }
    }

    private void a(double d, boolean z) {
        double d2;
        double d3;
        double d4 = d - this.bhz.bhB;
        double d5 = d4 * d4;
        if (z) {
            this.bhz.bil[2][2] = this.bhz.bif;
            this.bhz.bil[2][3] = 0.0d;
            this.bhz.bil[3][2] = 0.0d;
            this.bhz.bil[3][3] = this.bhz.bif;
        } else {
            d2 = 1.0d;
            if (d4 > 0.5d) {
                d3 = 0.0d;
                while (d3 < d4) {
                    d3 = 1.0d + d3;
                    d2 = this.bhz.bhO * d2;
                }
            }
            double[] dArr = this.bhz.bil[2];
            dArr[2] = dArr[2] * d2;
            dArr = this.bhz.bil[2];
            dArr[3] = dArr[3] * d2;
            dArr = this.bhz.bil[3];
            dArr[2] = dArr[2] * d2;
            dArr = this.bhz.bil[3];
            dArr[3] = d2 * dArr[3];
        }
        if (d4 > 0.5d) {
            d3 = 1.0d;
            for (d2 = 0.0d; d2 < d4; d2 += 1.0d) {
                d3 *= this.bhz.bio;
            }
            b bVar = this.bhz;
            bVar.bin = d3 * bVar.bin;
        }
        this.bhz.bik[0] = this.bhz.bik[0] + (this.bhz.bik[2] * d4);
        this.bhz.bik[1] = this.bhz.bik[1] + (this.bhz.bik[3] * d4);
        if (this.bhz.bip) {
            this.bhz.bil[0][0] = this.bhz.bil[0][0] + (this.bhz.bil[2][2] * d5);
            this.bhz.bil[0][1] = this.bhz.bil[0][1] + (this.bhz.bil[2][3] * d5);
            this.bhz.bil[1][0] = this.bhz.bil[1][0] + (this.bhz.bil[3][2] * d5);
            this.bhz.bil[1][1] = this.bhz.bil[1][1] + (this.bhz.bil[3][3] * d5);
        } else {
            this.bhz.bil[0][0] = (this.bhz.bil[0][0] + ((this.bhz.bil[0][2] + this.bhz.bil[2][0]) * d4)) + (this.bhz.bil[2][2] * d5);
            this.bhz.bil[1][1] = (this.bhz.bil[1][1] + ((this.bhz.bil[1][3] + this.bhz.bil[3][1]) * d4)) + (this.bhz.bil[3][3] * d5);
            this.bhz.bil[0][2] = this.bhz.bil[0][2] + (this.bhz.bil[2][2] * d4);
            this.bhz.bil[2][0] = this.bhz.bil[2][0] + (this.bhz.bil[2][2] * d4);
            this.bhz.bil[1][3] = this.bhz.bil[1][3] + (this.bhz.bil[3][3] * d4);
            this.bhz.bil[3][1] = this.bhz.bil[3][1] + (this.bhz.bil[3][3] * d4);
        }
        this.bhz.bhB = d;
    }

    private void b(double d, boolean z) {
        double d2;
        double d3;
        double d4 = d - this.bhA.bhB;
        double d5 = d4 * d4;
        if (z) {
            this.bhA.bil[2][2] = this.bhA.bif;
            this.bhA.bil[2][3] = 0.0d;
            this.bhA.bil[3][2] = 0.0d;
            this.bhA.bil[3][3] = this.bhA.bif;
        } else {
            d2 = 1.0d;
            if (d4 > 0.5d) {
                d3 = 0.0d;
                while (d3 < d4) {
                    d3 = 1.0d + d3;
                    d2 = this.bhA.bhO * d2;
                }
            }
            double[] dArr = this.bhA.bil[2];
            dArr[2] = dArr[2] * d2;
            dArr = this.bhA.bil[2];
            dArr[3] = dArr[3] * d2;
            dArr = this.bhA.bil[3];
            dArr[2] = dArr[2] * d2;
            dArr = this.bhA.bil[3];
            dArr[3] = d2 * dArr[3];
        }
        if (d4 > 0.5d) {
            d3 = 1.0d;
            for (d2 = 0.0d; d2 < d4; d2 += 1.0d) {
                d3 *= this.bhA.bio;
            }
            b bVar = this.bhA;
            bVar.bin = d3 * bVar.bin;
        }
        this.bhA.bik[0] = this.bhA.bik[0] + (this.bhA.bik[2] * d4);
        this.bhA.bik[1] = this.bhA.bik[1] + (this.bhA.bik[3] * d4);
        if (this.bhA.bip) {
            this.bhA.bil[0][0] = this.bhA.bil[0][0] + (this.bhA.bil[2][2] * d5);
            this.bhA.bil[0][1] = this.bhA.bil[0][1] + (this.bhA.bil[2][3] * d5);
            this.bhA.bil[1][0] = this.bhA.bil[1][0] + (this.bhA.bil[3][2] * d5);
            this.bhA.bil[1][1] = this.bhA.bil[1][1] + (this.bhA.bil[3][3] * d5);
        } else {
            this.bhA.bil[0][0] = (this.bhA.bil[0][0] + ((this.bhA.bil[0][2] + this.bhA.bil[2][0]) * d4)) + (this.bhA.bil[2][2] * d5);
            this.bhA.bil[1][1] = (this.bhA.bil[1][1] + ((this.bhA.bil[1][3] + this.bhA.bil[3][1]) * d4)) + (this.bhA.bil[3][3] * d5);
            this.bhA.bil[0][2] = this.bhA.bil[0][2] + (this.bhA.bil[2][2] * d4);
            this.bhA.bil[2][0] = this.bhA.bil[2][0] + (this.bhA.bil[2][2] * d4);
            this.bhA.bil[1][3] = this.bhA.bil[1][3] + (this.bhA.bil[3][3] * d4);
            this.bhA.bil[3][1] = this.bhA.bil[3][1] + (this.bhA.bil[3][3] * d4);
        }
        this.bhA.bhB = d;
    }

    private void a(double[] dArr) {
        if (this.bhz.bii && this.bhz.bhS) {
            double[] dArr2 = new double[2];
            r1 = new double[2];
            double d = this.bhz.biu;
            dArr2[0] = this.bhz.bik[0] - this.bhz.bhT[0];
            dArr2[1] = this.bhz.bik[1] - this.bhz.bhT[1];
            r1[0] = dArr[0] - this.bhz.bhT[0];
            r1[1] = dArr[1] - this.bhz.bhT[1];
            double sqrt = Math.sqrt((dArr2[0] * dArr2[0]) + (dArr2[1] * dArr2[1]));
            double sqrt2 = Math.sqrt((r1[0] * r1[0]) + (r1[1] * r1[1]));
            if (sqrt > this.bhz.bia && sqrt2 > this.bhz.bia) {
                Object obj;
                double atan2 = Math.atan2(r1[1], r1[0]) - Math.atan2(dArr2[1], dArr2[0]);
                if (atan2 > 3.141592653589793d) {
                    atan2 -= 6.283185307179586d;
                } else if (atan2 < -3.141592653589793d) {
                    atan2 += 6.283185307179586d;
                }
                b bVar = this.bhz;
                bVar.bim = (d * atan2) + bVar.bim;
                if (atan2 * atan2 > 4.0d * this.bhz.bin) {
                    obj = 1;
                } else {
                    obj = null;
                }
                d = Math.sqrt(this.bhz.bil[0][0] + this.bhz.bil[1][1]);
                if (sqrt >= sqrt2) {
                    sqrt = sqrt2;
                }
                sqrt = d / sqrt;
                if (obj != null) {
                    this.bhz.bin = sqrt * sqrt;
                } else {
                    this.bhz.bin = 1.0d / ((1.0d / (sqrt * sqrt)) + (1.0d / this.bhz.bin));
                }
            }
        }
        this.bhz.bhT[0] = dArr[0];
        this.bhz.bhT[1] = dArr[1];
        this.bhz.bhS = true;
    }

    void a(int i, double[] dArr, double[] dArr2) {
        switch (i) {
            case 0:
                dArr2[0] = ((dArr[1] - this.bhz.big[1]) * 6378137.0d) * Math.cos(this.bhz.big[0]);
                dArr2[1] = (dArr[0] - this.bhz.big[0]) * 6378137.0d;
                return;
            case 1:
                dArr2[0] = (dArr[1] / 6378137.0d) + this.bhz.big[0];
                dArr2[1] = (dArr[0] / (Math.cos(this.bhz.big[0]) * 6378137.0d)) + this.bhz.big[1];
                return;
            default:
                return;
        }
    }

    private static void b(double[] dArr, double[] dArr2) {
        double d = 1.0d / ((dArr[0] * dArr[3]) - (dArr[1] * dArr[2]));
        dArr2[0] = dArr[3] * d;
        dArr2[3] = dArr[0] * d;
        dArr2[1] = (-dArr[1]) * d;
        dArr2[2] = d * (-dArr[2]);
    }

    private static boolean a(double[][] dArr, double[][] dArr2) {
        double[][] dArr3 = (double[][]) Array.newInstance(Double.TYPE, new int[]{4, 4});
        dArr3[0][0] = ((((((dArr[1][1] * dArr[2][2]) * dArr[3][3]) - ((dArr[1][1] * dArr[2][3]) * dArr[3][2])) - ((dArr[2][1] * dArr[1][2]) * dArr[3][3])) + ((dArr[2][1] * dArr[1][3]) * dArr[3][2])) + ((dArr[3][1] * dArr[1][2]) * dArr[2][3])) - ((dArr[3][1] * dArr[1][3]) * dArr[2][2]);
        dArr3[1][0] = (((((((-dArr[1][0]) * dArr[2][2]) * dArr[3][3]) + ((dArr[1][0] * dArr[2][3]) * dArr[3][2])) + ((dArr[2][0] * dArr[1][2]) * dArr[3][3])) - ((dArr[2][0] * dArr[1][3]) * dArr[3][2])) - ((dArr[3][0] * dArr[1][2]) * dArr[2][3])) + ((dArr[3][0] * dArr[1][3]) * dArr[2][2]);
        dArr3[2][0] = ((((((dArr[1][0] * dArr[2][1]) * dArr[3][3]) - ((dArr[1][0] * dArr[2][3]) * dArr[3][1])) - ((dArr[2][0] * dArr[1][1]) * dArr[3][3])) + ((dArr[2][0] * dArr[1][3]) * dArr[3][1])) + ((dArr[3][0] * dArr[1][1]) * dArr[2][3])) - ((dArr[3][0] * dArr[1][3]) * dArr[2][1]);
        dArr3[3][0] = (((((((-dArr[1][0]) * dArr[2][1]) * dArr[3][2]) + ((dArr[1][0] * dArr[2][2]) * dArr[3][1])) + ((dArr[2][0] * dArr[1][1]) * dArr[3][2])) - ((dArr[2][0] * dArr[1][2]) * dArr[3][1])) - ((dArr[3][0] * dArr[1][1]) * dArr[2][2])) + ((dArr[3][0] * dArr[1][2]) * dArr[2][1]);
        dArr3[0][1] = (((((((-dArr[0][1]) * dArr[2][2]) * dArr[3][3]) + ((dArr[0][1] * dArr[2][3]) * dArr[3][2])) + ((dArr[2][1] * dArr[0][2]) * dArr[3][3])) - ((dArr[2][1] * dArr[0][3]) * dArr[3][2])) - ((dArr[3][1] * dArr[0][2]) * dArr[2][3])) + ((dArr[3][1] * dArr[0][3]) * dArr[2][2]);
        dArr3[1][1] = ((((((dArr[0][0] * dArr[2][2]) * dArr[3][3]) - ((dArr[0][0] * dArr[2][3]) * dArr[3][2])) - ((dArr[2][0] * dArr[0][2]) * dArr[3][3])) + ((dArr[2][0] * dArr[0][3]) * dArr[3][2])) + ((dArr[3][0] * dArr[0][2]) * dArr[2][3])) - ((dArr[3][0] * dArr[0][3]) * dArr[2][2]);
        dArr3[2][1] = (((((((-dArr[0][0]) * dArr[2][1]) * dArr[3][3]) + ((dArr[0][0] * dArr[2][3]) * dArr[3][1])) + ((dArr[2][0] * dArr[0][1]) * dArr[3][3])) - ((dArr[2][0] * dArr[0][3]) * dArr[3][1])) - ((dArr[3][0] * dArr[0][1]) * dArr[2][3])) + ((dArr[3][0] * dArr[0][3]) * dArr[2][1]);
        dArr3[3][1] = ((((((dArr[0][0] * dArr[2][1]) * dArr[3][2]) - ((dArr[0][0] * dArr[2][2]) * dArr[3][1])) - ((dArr[2][0] * dArr[0][1]) * dArr[3][2])) + ((dArr[2][0] * dArr[0][2]) * dArr[3][1])) + ((dArr[3][0] * dArr[0][1]) * dArr[2][2])) - ((dArr[3][0] * dArr[0][2]) * dArr[2][1]);
        dArr3[0][2] = ((((((dArr[0][1] * dArr[1][2]) * dArr[3][3]) - ((dArr[0][1] * dArr[1][3]) * dArr[3][2])) - ((dArr[1][1] * dArr[0][2]) * dArr[3][3])) + ((dArr[1][1] * dArr[0][3]) * dArr[3][2])) + ((dArr[3][1] * dArr[0][2]) * dArr[1][3])) - ((dArr[3][1] * dArr[0][3]) * dArr[1][2]);
        dArr3[1][2] = (((((((-dArr[0][0]) * dArr[1][2]) * dArr[3][3]) + ((dArr[0][0] * dArr[1][3]) * dArr[3][2])) + ((dArr[1][0] * dArr[0][2]) * dArr[3][3])) - ((dArr[1][0] * dArr[0][3]) * dArr[3][2])) - ((dArr[3][0] * dArr[0][2]) * dArr[1][3])) + ((dArr[3][0] * dArr[0][3]) * dArr[1][2]);
        dArr3[2][2] = ((((((dArr[0][0] * dArr[1][1]) * dArr[3][3]) - ((dArr[0][0] * dArr[1][3]) * dArr[3][1])) - ((dArr[1][0] * dArr[0][1]) * dArr[3][3])) + ((dArr[1][0] * dArr[0][3]) * dArr[3][1])) + ((dArr[3][0] * dArr[0][1]) * dArr[1][3])) - ((dArr[3][0] * dArr[0][3]) * dArr[1][1]);
        dArr3[3][2] = (((((((-dArr[0][0]) * dArr[1][1]) * dArr[3][2]) + ((dArr[0][0] * dArr[1][2]) * dArr[3][1])) + ((dArr[1][0] * dArr[0][1]) * dArr[3][2])) - ((dArr[1][0] * dArr[0][2]) * dArr[3][1])) - ((dArr[3][0] * dArr[0][1]) * dArr[1][2])) + ((dArr[3][0] * dArr[0][2]) * dArr[1][1]);
        dArr3[0][3] = (((((((-dArr[0][1]) * dArr[1][2]) * dArr[2][3]) + ((dArr[0][1] * dArr[1][3]) * dArr[2][2])) + ((dArr[1][1] * dArr[0][2]) * dArr[2][3])) - ((dArr[1][1] * dArr[0][3]) * dArr[2][2])) - ((dArr[2][1] * dArr[0][2]) * dArr[1][3])) + ((dArr[2][1] * dArr[0][3]) * dArr[1][2]);
        dArr3[1][3] = ((((((dArr[0][0] * dArr[1][2]) * dArr[2][3]) - ((dArr[0][0] * dArr[1][3]) * dArr[2][2])) - ((dArr[1][0] * dArr[0][2]) * dArr[2][3])) + ((dArr[1][0] * dArr[0][3]) * dArr[2][2])) + ((dArr[2][0] * dArr[0][2]) * dArr[1][3])) - ((dArr[2][0] * dArr[0][3]) * dArr[1][2]);
        dArr3[2][3] = (((((((-dArr[0][0]) * dArr[1][1]) * dArr[2][3]) + ((dArr[0][0] * dArr[1][3]) * dArr[2][1])) + ((dArr[1][0] * dArr[0][1]) * dArr[2][3])) - ((dArr[1][0] * dArr[0][3]) * dArr[2][1])) - ((dArr[2][0] * dArr[0][1]) * dArr[1][3])) + ((dArr[2][0] * dArr[0][3]) * dArr[1][1]);
        dArr3[3][3] = ((((((dArr[0][0] * dArr[1][1]) * dArr[2][2]) - ((dArr[0][0] * dArr[1][2]) * dArr[2][1])) - ((dArr[1][0] * dArr[0][1]) * dArr[2][2])) + ((dArr[1][0] * dArr[0][2]) * dArr[2][1])) + ((dArr[2][0] * dArr[0][1]) * dArr[1][2])) - ((dArr[2][0] * dArr[0][2]) * dArr[1][1]);
        double d = (((dArr[0][0] * dArr3[0][0]) + (dArr[0][1] * dArr3[1][0])) + (dArr[0][2] * dArr3[2][0])) + (dArr[0][3] * dArr3[3][0]);
        if (d == 0.0d) {
            return false;
        }
        double d2 = 1.0d / d;
        for (int i = 0; i < 4; i++) {
            for (int i2 = 0; i2 < 4; i2++) {
                dArr2[i][i2] = dArr3[i][i2] * d2;
            }
        }
        return true;
    }
}
