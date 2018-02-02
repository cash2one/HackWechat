package com.google.android.exoplayer2;

public final class w$a {
    public int adN;
    public Object ady;
    public Object aeW;
    public long aeX;
    public long[] aeY;
    public int[] aeZ;
    public long aes;
    public int[] afa;
    public int[] afb;
    public long[][] afc;
    public long afd;

    public final int iw() {
        return this.aeY == null ? 0 : this.aeY.length;
    }

    public final boolean bX(int i) {
        return this.aeZ[i] != -1 && this.afb[i] == this.aeZ[i];
    }

    public final int r(long j) {
        if (this.aeY == null) {
            return -1;
        }
        int length = this.aeY.length - 1;
        while (length >= 0 && (this.aeY[length] == Long.MIN_VALUE || this.aeY[length] > j)) {
            length--;
        }
        if (length < 0 || bX(length)) {
            return -1;
        }
        return length;
    }

    public final int s(long j) {
        if (this.aeY == null) {
            return -1;
        }
        int i = 0;
        while (i < this.aeY.length && this.aeY[i] != Long.MIN_VALUE && (j >= this.aeY[i] || bX(i))) {
            i++;
        }
        return i >= this.aeY.length ? -1 : i;
    }

    public final boolean an(int i, int i2) {
        return i2 < this.afa[i];
    }

    public final long ao(int i, int i2) {
        if (i2 >= this.afc[i].length) {
            return -9223372036854775807L;
        }
        return this.afc[i][i2];
    }
}
