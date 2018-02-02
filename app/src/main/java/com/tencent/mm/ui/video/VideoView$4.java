package com.tencent.mm.ui.video;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.mm.sdk.platformtools.x;

class VideoView$4 implements OnErrorListener {
    final /* synthetic */ VideoView zqr;

    VideoView$4(VideoView videoView) {
        this.zqr = videoView;
    }

    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        x.d("MicroMsg.VideoView", "Error: " + i + "," + i2);
        if (VideoView.m(this.zqr) == null || !VideoView.m(this.zqr).onError(VideoView.e(this.zqr), i, i2)) {
            this.zqr.getWindowToken();
        }
        return true;
    }
}
