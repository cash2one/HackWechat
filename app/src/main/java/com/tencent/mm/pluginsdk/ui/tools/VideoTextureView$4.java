package com.tencent.mm.pluginsdk.ui.tools;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnSeekCompleteListener;
import com.tencent.mm.sdk.platformtools.x;

class VideoTextureView$4 implements OnSeekCompleteListener {
    final /* synthetic */ VideoTextureView vyR;

    VideoTextureView$4(VideoTextureView videoTextureView) {
        this.vyR = videoTextureView;
    }

    public final void onSeekComplete(MediaPlayer mediaPlayer) {
        int currentPosition = mediaPlayer != null ? mediaPlayer.getCurrentPosition() : -1;
        x.i("MicroMsg.VideoTextureView", "video seek complete curPos[%d] mStartWhenPrepared[%b] pauseWhenUpdated[%b]", Integer.valueOf(currentPosition), Boolean.valueOf(VideoTextureView.g(this.vyR)), Boolean.valueOf(VideoTextureView.j(this.vyR)));
        if (!VideoTextureView.g(this.vyR)) {
            this.vyR.pause();
        } else if (!VideoTextureView.j(this.vyR)) {
            this.vyR.start();
        } else {
            return;
        }
        if (VideoTextureView.k(this.vyR) != null) {
            VideoTextureView.k(this.vyR).bW(VideoTextureView.g(this.vyR));
        }
        VideoTextureView.a(this.vyR, 0);
    }
}
