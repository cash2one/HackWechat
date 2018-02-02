package com.google.android.exoplayer2;

import com.google.android.exoplayer2.i.t;
import java.util.UUID;

public final class b {
    public static final int CHANNEL_OUT_7POINT1_SURROUND;
    public static final UUID acn = new UUID(0, 0);
    public static final UUID aco = new UUID(1186680826959645954L, -5988876978535335093L);
    public static final UUID acp = new UUID(-1301668207276963122L, -6645017420763422227L);
    public static final UUID acq = new UUID(-7348484286925749626L, -6083546864340672619L);

    static {
        int i;
        if (t.SDK_INT < 23) {
            i = 1020;
        } else {
            i = 6396;
        }
        CHANNEL_OUT_7POINT1_SURROUND = i;
    }

    public static long j(long j) {
        return (j == -9223372036854775807L || j == Long.MIN_VALUE) ? j : j / 1000;
    }

    public static long k(long j) {
        return (j == -9223372036854775807L || j == Long.MIN_VALUE) ? j : j * 1000;
    }
}
