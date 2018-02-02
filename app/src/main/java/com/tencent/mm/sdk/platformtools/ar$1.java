package com.tencent.mm.sdk.platformtools;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;

class ar$1 implements OnErrorListener {
    final /* synthetic */ MediaPlayer liw;

    ar$1(MediaPlayer mediaPlayer) {
        this.liw = mediaPlayer;
    }

    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        x.i("MicroMsg.PlaySound", "onError, what: %d, extra: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (mediaPlayer != null) {
            try {
                mediaPlayer.release();
            } catch (Exception e) {
            }
        }
        if (this.liw != null) {
            this.liw.release();
        }
        return false;
    }
}
