package com.google.android.exoplayer2.video;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.OnFrameRenderedListener;
import android.os.Handler;

@TargetApi(23)
final class c$b implements OnFrameRenderedListener {
    final /* synthetic */ c aDJ;

    private c$b(c cVar, MediaCodec mediaCodec) {
        this.aDJ = cVar;
        mediaCodec.setOnFrameRenderedListener(this, new Handler());
    }

    public final void onFrameRendered(MediaCodec mediaCodec, long j, long j2) {
        if (this == this.aDJ.aDF) {
            this.aDJ.lU();
        }
    }
}
