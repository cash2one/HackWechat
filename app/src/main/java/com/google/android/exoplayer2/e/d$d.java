package com.google.android.exoplayer2.e;

import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecList;
import com.google.android.exoplayer2.e.d.c;

final class d$d implements c {
    private d$d() {
    }

    public final int getCodecCount() {
        return MediaCodecList.getCodecCount();
    }

    public final MediaCodecInfo getCodecInfoAt(int i) {
        return MediaCodecList.getCodecInfoAt(i);
    }

    public final boolean jR() {
        return false;
    }

    public final boolean a(String str, CodecCapabilities codecCapabilities) {
        return "video/avc".equals(str);
    }
}
