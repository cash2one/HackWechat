package com.tencent.mm.plugin.collect.b;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.mm.sdk.platformtools.x;

class g$a$3 implements OnErrorListener {
    final /* synthetic */ MediaPlayer liw;
    final /* synthetic */ OnErrorListener lix;

    g$a$3(MediaPlayer mediaPlayer, OnErrorListener onErrorListener) {
        this.liw = mediaPlayer;
        this.lix = onErrorListener;
    }

    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        x.i("MicroMsg.F2fRcvVoiceListener", "onError, what: %d, extra: %d", Integer.valueOf(i), Integer.valueOf(i2));
        if (mediaPlayer != null) {
            try {
                mediaPlayer.release();
            } catch (Exception e) {
            }
        }
        if (this.liw != null) {
            this.liw.release();
        }
        if (this.lix != null) {
            this.lix.onError(mediaPlayer, i, i2);
        }
        return false;
    }
}
