package com.tencent.mm.pluginsdk.ui.tools;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.mm.sdk.platformtools.x;

class VideoTextureView$8 implements OnErrorListener {
    final /* synthetic */ VideoTextureView vyR;

    VideoTextureView$8(VideoTextureView videoTextureView) {
        this.vyR = videoTextureView;
    }

    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        x.w("MicroMsg.VideoTextureView", "Error: " + i + "," + i2);
        if (VideoTextureView.d(this.vyR) != null) {
            VideoTextureView.d(this.vyR).onError(i, i2);
        }
        return true;
    }
}
