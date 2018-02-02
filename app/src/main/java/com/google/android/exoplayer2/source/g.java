package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.b.e;
import com.google.android.exoplayer2.c.k$a;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.i.t;
import com.google.android.exoplayer2.k;

public final class g {
    private int[] aix = new int[this.arV];
    private long[] aiz = new long[this.arV];
    private int arV = 1000;
    public int[] arW = new int[this.arV];
    private int[] arX = new int[this.arV];
    private k$a[] arY = new k$a[this.arV];
    private Format[] arZ = new Format[this.arV];
    public int asa;
    public int asb;
    public int asc;
    public long asd = Long.MIN_VALUE;
    public long ase = Long.MIN_VALUE;
    public boolean asf = true;
    public boolean asg = true;
    public Format ash;
    public int asi;
    public int length;
    private long[] offsets = new long[this.arV];

    public final synchronized boolean kg() {
        return this.asc != this.length;
    }

    public final synchronized Format kh() {
        return this.asg ? null : this.ash;
    }

    public final synchronized long ki() {
        return this.ase;
    }

    public final synchronized void rewind() {
        this.asc = 0;
    }

    public final synchronized int a(k kVar, e eVar, boolean z, boolean z2, Format format, a aVar) {
        int i = -4;
        synchronized (this) {
            if (kg()) {
                int cD = cD(this.asc);
                if (z || this.arZ[cD] != format) {
                    kVar.aeo = this.arZ[cD];
                    i = -5;
                } else {
                    Object obj = (eVar.aif == null && eVar.aih == 0) ? 1 : null;
                    if (obj != null) {
                        i = -3;
                    } else {
                        eVar.aig = this.aiz[cD];
                        eVar.flags = this.arX[cD];
                        aVar.size = this.aix[cD];
                        aVar.oJ = this.offsets[cD];
                        aVar.amk = this.arY[cD];
                        this.asc++;
                    }
                }
            } else if (z2) {
                eVar.flags = 4;
            } else if (this.ash == null || (!z && this.ash == format)) {
                i = -3;
            } else {
                kVar.aeo = this.ash;
                i = -5;
            }
        }
        return i;
    }

    public final synchronized boolean a(long j, boolean z, boolean z2) {
        boolean z3 = false;
        synchronized (this) {
            int cD = cD(this.asc);
            if (kg() && j >= this.aiz[cD] && (j <= this.ase || z2)) {
                int a = a(cD, this.length - this.asc, j, true);
                if (a != -1) {
                    this.asc += a;
                    z3 = true;
                }
            }
        }
        return z3;
    }

    public final synchronized void kj() {
        if (kg()) {
            this.asc = this.length;
        }
    }

    public final synchronized long b(long j, boolean z, boolean z2) {
        long j2;
        if (this.length == 0 || j < this.aiz[this.asb]) {
            j2 = -1;
        } else {
            int i;
            int a;
            if (z2) {
                if (this.asc != this.length) {
                    i = this.asc + 1;
                    a = a(this.asb, i, j, false);
                    if (a != -1) {
                        j2 = -1;
                    } else {
                        j2 = cB(a);
                    }
                }
            }
            i = this.length;
            a = a(this.asb, i, j, false);
            if (a != -1) {
                j2 = cB(a);
            } else {
                j2 = -1;
            }
        }
        return j2;
    }

    public final synchronized long kk() {
        long j;
        if (this.asc == 0) {
            j = -1;
        } else {
            j = cB(this.asc);
        }
        return j;
    }

    public final synchronized long kl() {
        long j;
        if (this.length == 0) {
            j = -1;
        } else {
            j = cB(this.length);
        }
        return j;
    }

    public final synchronized boolean i(Format format) {
        boolean z = false;
        synchronized (this) {
            if (format == null) {
                this.asg = true;
            } else {
                this.asg = false;
                if (!t.h(format, this.ash)) {
                    this.ash = format;
                    z = true;
                }
            }
        }
        return z;
    }

    public final synchronized void a(long j, int i, long j2, int i2, k$a com_google_android_exoplayer2_c_k_a) {
        if (this.asf) {
            if ((i & 1) != 0) {
                this.asf = false;
            }
        }
        a.an(!this.asg);
        E(j);
        int cD = cD(this.length);
        this.aiz[cD] = j;
        this.offsets[cD] = j2;
        this.aix[cD] = i2;
        this.arX[cD] = i;
        this.arY[cD] = com_google_android_exoplayer2_c_k_a;
        this.arZ[cD] = this.ash;
        this.arW[cD] = this.asi;
        this.length++;
        if (this.length == this.arV) {
            cD = this.arV + 1000;
            Object obj = new int[cD];
            Object obj2 = new long[cD];
            Object obj3 = new long[cD];
            Object obj4 = new int[cD];
            Object obj5 = new int[cD];
            Object obj6 = new k$a[cD];
            Object obj7 = new Format[cD];
            int i3 = this.arV - this.asb;
            System.arraycopy(this.offsets, this.asb, obj2, 0, i3);
            System.arraycopy(this.aiz, this.asb, obj3, 0, i3);
            System.arraycopy(this.arX, this.asb, obj4, 0, i3);
            System.arraycopy(this.aix, this.asb, obj5, 0, i3);
            System.arraycopy(this.arY, this.asb, obj6, 0, i3);
            System.arraycopy(this.arZ, this.asb, obj7, 0, i3);
            System.arraycopy(this.arW, this.asb, obj, 0, i3);
            int i4 = this.asb;
            System.arraycopy(this.offsets, 0, obj2, i3, i4);
            System.arraycopy(this.aiz, 0, obj3, i3, i4);
            System.arraycopy(this.arX, 0, obj4, i3, i4);
            System.arraycopy(this.aix, 0, obj5, i3, i4);
            System.arraycopy(this.arY, 0, obj6, i3, i4);
            System.arraycopy(this.arZ, 0, obj7, i3, i4);
            System.arraycopy(this.arW, 0, obj, i3, i4);
            this.offsets = obj2;
            this.aiz = obj3;
            this.arX = obj4;
            this.aix = obj5;
            this.arY = obj6;
            this.arZ = obj7;
            this.arW = obj;
            this.asb = 0;
            this.length = this.arV;
            this.arV = cD;
        }
    }

    private synchronized void E(long j) {
        this.ase = Math.max(this.ase, j);
    }

    public final synchronized boolean F(long j) {
        boolean z = true;
        boolean z2 = false;
        synchronized (this) {
            if (this.length == 0) {
                if (j <= this.asd) {
                    z = false;
                }
            } else if (Math.max(this.asd, cC(this.asc)) >= j) {
                z = false;
            } else {
                int i = this.length;
                int cD = cD(this.length - 1);
                while (i > this.asc && this.aiz[cD] >= j) {
                    i--;
                    cD--;
                    if (cD == -1) {
                        cD = this.arV - 1;
                    }
                }
                cD = (this.asa + this.length) - (this.asa + i);
                if (cD >= 0 && cD <= this.length - this.asc) {
                    z2 = true;
                }
                a.am(z2);
                this.length -= cD;
                this.ase = Math.max(this.asd, cC(this.length));
            }
        }
        return z;
    }

    private int a(int i, int i2, long j, boolean z) {
        int i3 = -1;
        int i4 = 0;
        while (i4 < i2 && this.aiz[i] <= j) {
            if (!(z && (this.arX[i] & 1) == 0)) {
                i3 = i4;
            }
            int i5 = i + 1;
            if (i5 == this.arV) {
                i5 = 0;
            }
            i4++;
            i = i5;
        }
        return i3;
    }

    private long cB(int i) {
        this.asd = Math.max(this.asd, cC(i));
        this.length -= i;
        this.asa += i;
        this.asb += i;
        if (this.asb >= this.arV) {
            this.asb -= this.arV;
        }
        this.asc -= i;
        if (this.asc < 0) {
            this.asc = 0;
        }
        if (this.length != 0) {
            return this.offsets[this.asb];
        }
        int i2 = (this.asb == 0 ? this.arV : this.asb) - 1;
        return ((long) this.aix[i2]) + this.offsets[i2];
    }

    private long cC(int i) {
        long j = Long.MIN_VALUE;
        if (i == 0) {
            return Long.MIN_VALUE;
        }
        int i2 = 0;
        int cD = cD(i - 1);
        while (i2 < i) {
            long max = Math.max(j, this.aiz[cD]);
            if ((this.arX[cD] & 1) != 0) {
                return max;
            }
            int i3 = cD - 1;
            if (i3 == -1) {
                i3 = this.arV - 1;
            }
            i2++;
            cD = i3;
            j = max;
        }
        return j;
    }

    public final int cD(int i) {
        int i2 = this.asb + i;
        return i2 < this.arV ? i2 : i2 - this.arV;
    }
}
