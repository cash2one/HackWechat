package com.tencent.mm.pluginsdk.ui.tools;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

class VideoSurfaceView$3 implements OnCompletionListener {
    final /* synthetic */ VideoSurfaceView vyJ;

    VideoSurfaceView$3(VideoSurfaceView videoSurfaceView) {
        this.vyJ = videoSurfaceView;
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        if (VideoSurfaceView.e(this.vyJ) != null) {
            VideoSurfaceView.e(this.vyJ).cf(VideoSurfaceView.g(this.vyJ).getCurrentPosition(), VideoSurfaceView.g(this.vyJ).getDuration());
            VideoSurfaceView.e(this.vyJ).vh();
        }
    }
}
