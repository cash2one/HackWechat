package com.google.android.exoplayer2.e;

import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;

interface d$c {
    boolean a(String str, CodecCapabilities codecCapabilities);

    int getCodecCount();

    MediaCodecInfo getCodecInfoAt(int i);

    boolean jR();
}
