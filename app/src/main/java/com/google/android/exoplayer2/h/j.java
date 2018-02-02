package com.google.android.exoplayer2.h;

import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.i.t;
import java.util.Arrays;

public final class j implements b {
    private final boolean aAN;
    private final int aAO;
    private final byte[] aAP;
    private final a[] aAQ;
    private int aAR;
    private int aAS;
    private a[] aAT;
    private int acx;

    public j() {
        this(true, 65536);
    }

    private j(boolean z, int i) {
        a.am(true);
        a.am(true);
        this.aAN = true;
        this.aAO = 65536;
        this.aAS = 0;
        this.aAT = new a[100];
        this.aAP = null;
        this.aAQ = new a[1];
    }

    public final synchronized void reset() {
        if (this.aAN) {
            cP(0);
        }
    }

    public final synchronized void cP(int i) {
        Object obj = i < this.acx ? 1 : null;
        this.acx = i;
        if (obj != null) {
            lm();
        }
    }

    public final synchronized a ll() {
        a aVar;
        this.aAR++;
        if (this.aAS > 0) {
            a[] aVarArr = this.aAT;
            int i = this.aAS - 1;
            this.aAS = i;
            aVar = aVarArr[i];
            this.aAT[this.aAS] = null;
        } else {
            aVar = new a(new byte[this.aAO], 0);
        }
        return aVar;
    }

    public final synchronized void a(a aVar) {
        this.aAQ[0] = aVar;
        a(this.aAQ);
    }

    public final synchronized void a(a[] aVarArr) {
        if (this.aAS + aVarArr.length >= this.aAT.length) {
            this.aAT = (a[]) Arrays.copyOf(this.aAT, Math.max(this.aAT.length * 2, this.aAS + aVarArr.length));
        }
        for (a aVar : aVarArr) {
            boolean z;
            if (aVar.data == this.aAP || aVar.data.length == this.aAO) {
                z = true;
            } else {
                z = false;
            }
            a.am(z);
            a[] aVarArr2 = this.aAT;
            int i = this.aAS;
            this.aAS = i + 1;
            aVarArr2[i] = aVar;
        }
        this.aAR -= aVarArr.length;
        notifyAll();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void lm() {
        int i = 0;
        synchronized (this) {
            int max = Math.max(0, t.at(this.acx, this.aAO) - this.aAR);
            if (max < this.aAS) {
                if (this.aAP != null) {
                    int i2 = this.aAS - 1;
                    while (i <= i2) {
                        a aVar = this.aAT[i];
                        if (aVar.data == this.aAP) {
                            i++;
                        } else {
                            a aVar2 = this.aAT[i2];
                            if (aVar2.data != this.aAP) {
                                i2--;
                            } else {
                                int i3 = i + 1;
                                this.aAT[i] = aVar2;
                                i = i2 - 1;
                                this.aAT[i2] = aVar;
                                i2 = i;
                                i = i3;
                            }
                        }
                    }
                    max = Math.max(max, i);
                }
                Arrays.fill(this.aAT, max, this.aAS, null);
                this.aAS = max;
            }
        }
    }

    public final synchronized int lr() {
        return this.aAR * this.aAO;
    }

    public final int ln() {
        return this.aAO;
    }
}
