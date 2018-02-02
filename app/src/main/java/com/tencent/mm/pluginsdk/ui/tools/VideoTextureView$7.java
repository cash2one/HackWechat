package com.tencent.mm.pluginsdk.ui.tools;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class VideoTextureView$7 implements OnCompletionListener {
    final /* synthetic */ VideoTextureView vyR;

    VideoTextureView$7(VideoTextureView videoTextureView) {
        this.vyR = videoTextureView;
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        x.i("MicroMsg.VideoTextureView", "video on completion");
        VideoTextureView.b(this.vyR, bh.Wo());
        if (VideoTextureView.d(this.vyR) != null) {
            VideoTextureView.d(this.vyR).vh();
        }
    }
}
