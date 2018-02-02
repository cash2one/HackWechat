package com.tencent.mm.ui.video;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;

class VideoView$2 implements OnPreparedListener {
    final /* synthetic */ VideoView zqr;

    VideoView$2(VideoView videoView) {
        this.zqr = videoView;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onPrepared(MediaPlayer mediaPlayer) {
        VideoView.c(this.zqr);
        if (VideoView.d(this.zqr) != null) {
            VideoView.d(this.zqr).onPrepared(VideoView.e(this.zqr));
        }
        VideoView.a(this.zqr, mediaPlayer.getVideoWidth());
        VideoView.b(this.zqr, mediaPlayer.getVideoHeight());
        this.zqr.cyx();
        if (VideoView.a(this.zqr) == 0 || VideoView.b(this.zqr) == 0) {
            if (VideoView.j(this.zqr) != 0) {
                VideoView.e(this.zqr).seekTo(VideoView.j(this.zqr));
                VideoView.k(this.zqr);
            }
            if (VideoView.f(this.zqr)) {
                VideoView.e(this.zqr).start();
                VideoView.g(this.zqr);
            }
        } else {
            if (VideoView.f(this.zqr)) {
                VideoView.e(this.zqr).start();
                VideoView.g(this.zqr);
            }
            if (VideoView.h(this.zqr) == VideoView.a(this.zqr) && VideoView.i(this.zqr) == VideoView.b(this.zqr)) {
                if (VideoView.j(this.zqr) != 0) {
                    VideoView.e(this.zqr).seekTo(VideoView.j(this.zqr));
                    VideoView.k(this.zqr);
                }
                if (!(VideoView.f(this.zqr) || this.zqr.isPlaying() || VideoView.j(this.zqr) != 0)) {
                    VideoView videoView = this.zqr;
                    int i;
                    if (videoView.qxO == null || !videoView.vyC) {
                        i = 0;
                    } else {
                        i = videoView.qxO.getCurrentPosition();
                    }
                }
            }
        }
        VideoView.e(this.zqr).isPlaying();
    }
}
