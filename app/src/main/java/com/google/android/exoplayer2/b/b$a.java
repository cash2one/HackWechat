package com.google.android.exoplayer2.b;

import android.annotation.TargetApi;
import android.media.MediaCodec.CryptoInfo;
import android.media.MediaCodec.CryptoInfo.Pattern;

@TargetApi(24)
final class b$a {
    public final CryptoInfo ahU;
    public final Pattern ahW;

    private b$a(CryptoInfo cryptoInfo) {
        this.ahU = cryptoInfo;
        this.ahW = new Pattern(0, 0);
    }
}
