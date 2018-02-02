package com.tencent.mm.ui.video;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

class VideoView$3 implements OnCompletionListener {
    final /* synthetic */ VideoView zqr;

    VideoView$3(VideoView videoView) {
        this.zqr = videoView;
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        if (VideoView.l(this.zqr) != null) {
            VideoView.l(this.zqr).onCompletion(VideoView.e(this.zqr));
        }
    }
}
