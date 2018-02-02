package com.tencent.mm.booter.notification.a;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.mm.sdk.platformtools.x;

class f$6 implements OnErrorListener {
    final /* synthetic */ f gAz;

    f$6(f fVar) {
        this.gAz = fVar;
    }

    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        x.i("MicroMsg.Notification.Tool.Sound", "WiredHeadset play sound error, player: %s", new Object[]{this.gAz.gAw});
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        if (this.gAz.gAw != null) {
            this.gAz.gAw.release();
        }
        return false;
    }
}
