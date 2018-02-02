package com.tencent.mm.pluginsdk.ui.tools;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import com.tencent.mm.sdk.platformtools.x;

class VideoSurfaceView$1 implements OnVideoSizeChangedListener {
    final /* synthetic */ VideoSurfaceView vyJ;

    VideoSurfaceView$1(VideoSurfaceView videoSurfaceView) {
        this.vyJ = videoSurfaceView;
    }

    public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        VideoSurfaceView.a(this.vyJ, mediaPlayer.getVideoWidth());
        VideoSurfaceView.b(this.vyJ, mediaPlayer.getVideoHeight());
        x.v("MicroMsg.VideoSurfaceView", "on size change size:( " + VideoSurfaceView.a(this.vyJ) + " , " + VideoSurfaceView.b(this.vyJ) + " )");
        VideoSurfaceView.c(this.vyJ);
    }
}
