package com.google.android.exoplayer2.i;

public final class q {
    private long aCG;
    public volatile long aCH = -9223372036854775807L;
    public long amG;

    public q(long j) {
        P(j);
    }

    public final synchronized void P(long j) {
        a.an(this.aCH == -9223372036854775807L);
        this.amG = j;
    }

    public final long lQ() {
        if (this.amG == Long.MAX_VALUE) {
            return 0;
        }
        return this.aCH != -9223372036854775807L ? this.aCG : -9223372036854775807L;
    }

    public final long Q(long j) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        long j2;
        if (this.aCH != -9223372036854775807L) {
            long T = T(this.aCH);
            long j3 = (4294967296L + T) / 8589934592L;
            j2 = ((j3 - 1) * 8589934592L) + j;
            j3 = (j3 * 8589934592L) + j;
            if (Math.abs(j2 - T) >= Math.abs(j3 - T)) {
                j2 = j3;
            }
        } else {
            j2 = j;
        }
        return R(S(j2));
    }

    public final long R(long j) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (this.aCH != -9223372036854775807L) {
            this.aCH = j;
        } else {
            if (this.amG != Long.MAX_VALUE) {
                this.aCG = this.amG - j;
            }
            synchronized (this) {
                this.aCH = j;
                notifyAll();
            }
        }
        return this.aCG + j;
    }

    public final synchronized void lR() {
        while (this.aCH == -9223372036854775807L) {
            wait();
        }
    }

    public static long S(long j) {
        return (1000000 * j) / 90000;
    }

    public static long T(long j) {
        return (90000 * j) / 1000000;
    }
}
