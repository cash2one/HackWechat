package com.tencent.mm.pluginsdk.ui.tools;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import com.tencent.mm.sdk.platformtools.x;

class VideoTextureView$5 implements OnBufferingUpdateListener {
    final /* synthetic */ VideoTextureView vyR;

    VideoTextureView$5(VideoTextureView videoTextureView) {
        this.vyR = videoTextureView;
    }

    public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        x.d("MicroMsg.VideoTextureView", "onBufferingUpdate percent[%d]", new Object[]{Integer.valueOf(i)});
        VideoTextureView.c(this.vyR, i);
    }
}
