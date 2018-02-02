package com.google.android.exoplayer2.source.b.a;

public final class b$a implements Comparable<Long> {
    public final long aes;
    public final boolean ami;
    public final int auQ;
    public final long auR;
    public final String auS;
    public final String auT;
    public final long auU;
    public final long auV;
    public final String url;

    public final /* synthetic */ int compareTo(Object obj) {
        Long l = (Long) obj;
        if (this.auR > l.longValue()) {
            return 1;
        }
        return this.auR < l.longValue() ? -1 : 0;
    }

    public b$a(String str, long j, long j2) {
        this(str, 0, -1, -9223372036854775807L, false, null, null, j, j2);
    }

    public b$a(String str, long j, int i, long j2, boolean z, String str2, String str3, long j3, long j4) {
        this.url = str;
        this.aes = j;
        this.auQ = i;
        this.auR = j2;
        this.ami = z;
        this.auS = str2;
        this.auT = str3;
        this.auU = j3;
        this.auV = j4;
    }
}
