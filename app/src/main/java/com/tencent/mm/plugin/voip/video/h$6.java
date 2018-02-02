package com.tencent.mm.plugin.voip.video;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.mm.sdk.platformtools.x;

class h$6 implements OnErrorListener {
    final /* synthetic */ h suJ;

    h$6(h hVar) {
        this.suJ = hVar;
    }

    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            this.suJ.suF = 5;
            x.w("MicroMsg.RingPlayer", "RingPlayer playSound :onError", mediaPlayer, Integer.valueOf(i), Integer.valueOf(i2));
        }
        return false;
    }
}
