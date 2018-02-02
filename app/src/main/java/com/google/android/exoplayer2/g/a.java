package com.google.android.exoplayer2.g;

import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.l;
import java.util.Arrays;

public abstract class a implements e {
    private int aen;
    public final Format[] arZ;
    protected final l azU;
    protected final int[] azV;
    private final long[] azW;
    public final int length;

    public a(l lVar, int... iArr) {
        int i = 0;
        com.google.android.exoplayer2.i.a.an(iArr.length > 0);
        this.azU = (l) com.google.android.exoplayer2.i.a.Y(lVar);
        this.length = iArr.length;
        this.arZ = new Format[this.length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            this.arZ[i2] = lVar.arZ[iArr[i2]];
        }
        Arrays.sort(this.arZ, new a((byte) 0));
        this.azV = new int[this.length];
        while (i < this.length) {
            this.azV[i] = lVar.j(this.arZ[i]);
            i++;
        }
        this.azW = new long[this.length];
    }

    public final l lg() {
        return this.azU;
    }

    public final int length() {
        return this.azV.length;
    }

    public final Format cN(int i) {
        return this.arZ[i];
    }

    public final int cO(int i) {
        return this.azV[i];
    }

    public final int indexOf(int i) {
        for (int i2 = 0; i2 < this.length; i2++) {
            if (this.azV[i2] == i) {
                return i2;
            }
        }
        return -1;
    }

    public final Format lh() {
        return this.arZ[kv()];
    }

    public final int li() {
        return this.azV[kv()];
    }

    public final boolean f(int i, long j) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean g = g(i, elapsedRealtime);
        int i2 = 0;
        while (i2 < this.length && !g) {
            if (i2 == i || g(i2, elapsedRealtime)) {
                g = false;
            } else {
                g = true;
            }
            i2++;
        }
        if (!g) {
            return false;
        }
        this.azW[i] = Math.max(this.azW[i], elapsedRealtime + j);
        return true;
    }

    public final boolean g(int i, long j) {
        return this.azW[i] > j;
    }

    public int hashCode() {
        if (this.aen == 0) {
            this.aen = (System.identityHashCode(this.azU) * 31) + Arrays.hashCode(this.azV);
        }
        return this.aen;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        if (this.azU == aVar.azU && Arrays.equals(this.azV, aVar.azV)) {
            return true;
        }
        return false;
    }
}
