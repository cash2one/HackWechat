package com.tencent.mm.pluginsdk.ui.tools;

import android.media.MediaPlayer;
import com.tencent.mm.sdk.platformtools.x;

class VideoTextureView$1 extends Thread {
    final /* synthetic */ MediaPlayer liw;
    final /* synthetic */ VideoTextureView vyR;

    VideoTextureView$1(VideoTextureView videoTextureView, MediaPlayer mediaPlayer) {
        this.vyR = videoTextureView;
        this.liw = mediaPlayer;
    }

    public final void run() {
        try {
            if (this.liw != null) {
                x.i("MicroMsg.VideoTextureView", "%d another thread to release player[%s]", Integer.valueOf(this.vyR.hashCode()), this.liw);
                this.liw.stop();
                this.liw.release();
            }
        } catch (Exception e) {
        }
    }
}
