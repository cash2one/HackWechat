package com.tencent.mm.pluginsdk.ui.tools;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import com.tencent.mm.sdk.platformtools.x;

class VideoTextureView$3 implements OnPreparedListener {
    final /* synthetic */ VideoTextureView vyR;

    VideoTextureView$3(VideoTextureView videoTextureView) {
        this.vyR = videoTextureView;
    }

    public final void onPrepared(MediaPlayer mediaPlayer) {
        if (mediaPlayer == VideoTextureView.a(this.vyR) || mediaPlayer == null) {
            int videoHeight;
            VideoTextureView.f(this.vyR);
            VideoTextureView.a(this.vyR, mediaPlayer != null ? mediaPlayer.getVideoWidth() : 0);
            VideoTextureView videoTextureView = this.vyR;
            if (mediaPlayer != null) {
                videoHeight = mediaPlayer.getVideoHeight();
            } else {
                videoHeight = 0;
            }
            VideoTextureView.b(videoTextureView, videoHeight);
            x.i("MicroMsg.VideoTextureView", "on prepared. size [%d, %d] mStartWhenPrepared %b ", Integer.valueOf(VideoTextureView.b(this.vyR)), Integer.valueOf(VideoTextureView.c(this.vyR)), Boolean.valueOf(VideoTextureView.g(this.vyR)));
            VideoTextureView.e(this.vyR);
            if (VideoTextureView.b(this.vyR) == 0 || VideoTextureView.c(this.vyR) == 0) {
                if (VideoTextureView.g(this.vyR)) {
                    VideoTextureView.a(this.vyR).start();
                    VideoTextureView.i(this.vyR);
                    VideoTextureView.a(this.vyR).setLooping(VideoTextureView.h(this.vyR));
                }
            } else if (VideoTextureView.g(this.vyR)) {
                VideoTextureView.a(this.vyR).start();
                VideoTextureView.a(this.vyR).setLooping(VideoTextureView.h(this.vyR));
                VideoTextureView.i(this.vyR);
            }
            if (VideoTextureView.d(this.vyR) != null) {
                VideoTextureView.d(this.vyR).hX();
                return;
            }
            return;
        }
        x.w("MicroMsg.VideoTextureView", "another player callback, release now.[%s, %s]", mediaPlayer, VideoTextureView.a(this.vyR));
        VideoTextureView.a(this.vyR, mediaPlayer);
    }
}
