package com.tencent.mm.pluginsdk.ui.tools;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import com.tencent.mm.sdk.platformtools.x;

class VideoTextureView$2 implements OnVideoSizeChangedListener {
    final /* synthetic */ VideoTextureView vyR;

    VideoTextureView$2(VideoTextureView videoTextureView) {
        this.vyR = videoTextureView;
    }

    public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        try {
            if (mediaPlayer != VideoTextureView.a(this.vyR)) {
                x.w("MicroMsg.VideoTextureView", "another player on video size changed, return now.[%s, %s]", new Object[]{mediaPlayer, VideoTextureView.a(this.vyR)});
                return;
            }
            VideoTextureView.a(this.vyR, mediaPlayer.getVideoWidth());
            VideoTextureView.b(this.vyR, mediaPlayer.getVideoHeight());
            x.i("MicroMsg.VideoTextureView", "on size change size:( " + VideoTextureView.b(this.vyR) + " , " + VideoTextureView.c(this.vyR) + " )");
            if (VideoTextureView.d(this.vyR) != null) {
                VideoTextureView.d(this.vyR).cg(VideoTextureView.b(this.vyR), VideoTextureView.c(this.vyR));
            }
            VideoTextureView.e(this.vyR);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.VideoTextureView", e, "on video size changed error[%d, %d]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        }
    }
}
