package com.tencent.mm.ui.video;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import com.tencent.mm.sdk.platformtools.x;

class VideoView$1 implements OnVideoSizeChangedListener {
    final /* synthetic */ VideoView zqr;

    VideoView$1(VideoView videoView) {
        this.zqr = videoView;
    }

    public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        VideoView.a(this.zqr, mediaPlayer.getVideoWidth());
        VideoView.b(this.zqr, mediaPlayer.getVideoHeight());
        x.v("MicroMsg.VideoView", "on size change size:( " + VideoView.a(this.zqr) + " , " + VideoView.b(this.zqr) + " )");
        this.zqr.cyx();
    }
}
