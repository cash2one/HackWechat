package com.tencent.mm.pluginsdk.ui.tools;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;

class VideoSurfaceView$2 implements OnPreparedListener {
    final /* synthetic */ VideoSurfaceView vyJ;

    VideoSurfaceView$2(VideoSurfaceView videoSurfaceView) {
        this.vyJ = videoSurfaceView;
    }

    public final void onPrepared(MediaPlayer mediaPlayer) {
        VideoSurfaceView.d(this.vyJ);
        if (VideoSurfaceView.e(this.vyJ) != null) {
            VideoSurfaceView.e(this.vyJ).hX();
        }
        VideoSurfaceView.a(this.vyJ, mediaPlayer.getVideoWidth());
        VideoSurfaceView.b(this.vyJ, mediaPlayer.getVideoHeight());
        VideoSurfaceView.c(this.vyJ);
        if (VideoSurfaceView.a(this.vyJ) == 0 || VideoSurfaceView.b(this.vyJ) == 0) {
            if (VideoSurfaceView.f(this.vyJ)) {
                VideoSurfaceView.g(this.vyJ).start();
                VideoSurfaceView.h(this.vyJ);
            }
        } else if (VideoSurfaceView.f(this.vyJ)) {
            VideoSurfaceView.g(this.vyJ).start();
            VideoSurfaceView.h(this.vyJ);
        }
    }
}
