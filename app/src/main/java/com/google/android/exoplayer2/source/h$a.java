package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.h.a;

final class h$a {
    public final long alc;
    public final long asw;
    public boolean asx;
    public a asy;
    public h$a asz;

    public h$a(long j, int i) {
        this.asw = j;
        this.alc = ((long) i) + j;
    }

    public final int I(long j) {
        return ((int) (j - this.asw)) + this.asy.offset;
    }

    public final h$a kn() {
        this.asy = null;
        h$a com_google_android_exoplayer2_source_h_a = this.asz;
        this.asz = null;
        return com_google_android_exoplayer2_source_h_a;
    }
}
