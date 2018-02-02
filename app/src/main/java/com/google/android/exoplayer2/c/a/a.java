package com.google.android.exoplayer2.c.a;

final class a implements com.google.android.exoplayer2.c.a.b.a {
    private final long aes;
    private final long aiS;
    private final int bitrate;

    public a(long j, int i, long j2) {
        this.aiS = j;
        this.bitrate = i;
        this.aes = j2 == -1 ? -9223372036854775807L : y(j2);
    }

    public final boolean jr() {
        return this.aes != -9223372036854775807L;
    }

    public final long y(long j) {
        return ((Math.max(0, j - this.aiS) * 1000000) * 8) / ((long) this.bitrate);
    }
}
