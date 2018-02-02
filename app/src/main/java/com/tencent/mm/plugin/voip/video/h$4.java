package com.tencent.mm.plugin.voip.video;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.mm.sdk.platformtools.x;

class h$4 implements OnErrorListener {
    final /* synthetic */ h suJ;

    h$4(h hVar) {
        this.suJ = hVar;
    }

    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        this.suJ.suF = 1;
        x.w("MicroMsg.RingPlayer", "RingPlayer startPlayCustomRing MediaPlayer onError, what: " + i + ":extra:" + i2);
        return false;
    }
}
