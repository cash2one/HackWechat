package com.google.android.exoplayer2.h;

import com.google.android.exoplayer2.h.q.a;
import com.google.android.exoplayer2.h.q.f;

public final class o extends a {
    private final t<? super f> aAB;
    private final boolean aBp;
    private final int aBq;
    private final int aBr;
    private final String aBs;

    protected final /* synthetic */ q a(f fVar) {
        return new n(this.aBs, this.aAB, this.aBq, this.aBr, this.aBp, fVar);
    }

    public o(String str, t<? super f> tVar) {
        this(str, tVar, (byte) 0);
    }

    private o(String str, t<? super f> tVar, byte b) {
        this.aBs = str;
        this.aAB = tVar;
        this.aBq = 8000;
        this.aBr = 8000;
        this.aBp = false;
    }
}
