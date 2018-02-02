package com.tencent.mm.pluginsdk.ui.tools;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnInfoListener;
import com.tencent.mm.sdk.platformtools.x;

class VideoTextureView$6 implements OnInfoListener {
    final /* synthetic */ VideoTextureView vyR;

    VideoTextureView$6(VideoTextureView videoTextureView) {
        this.vyR = videoTextureView;
    }

    public final boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        x.d("MicroMsg.VideoTextureView", "onInfo [%d %d]", Integer.valueOf(i), Integer.valueOf(i2));
        if (VideoTextureView.l(this.vyR) != null) {
            VideoTextureView.l(this.vyR).ez(i, i2);
        }
        return false;
    }
}
