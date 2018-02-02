package com.tencent.mm.booter.notification.a;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.mm.sdk.platformtools.x;

class f$4 implements OnErrorListener {
    final /* synthetic */ AudioManager gAC;
    final /* synthetic */ f gAz;

    f$4(f fVar, AudioManager audioManager) {
        this.gAz = fVar;
        this.gAC = audioManager;
    }

    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        x.i("MicroMsg.Notification.Tool.Sound", "WiredHeadset play sound error, player: %s", new Object[]{this.gAz.gAw});
        this.gAC.setMode(0);
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        if (this.gAz.gAw != null) {
            this.gAz.gAw.release();
        }
        return false;
    }
}
