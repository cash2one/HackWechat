package com.google.android.exoplayer2.a;

public final class f$h extends Exception {
    public final int errorCode;

    public f$h(int i) {
        super("AudioTrack write failed: " + i);
        this.errorCode = i;
    }
}
