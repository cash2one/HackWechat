package com.tencent.mm.booter.notification.a;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.mm.sdk.platformtools.x;

class f$8 implements OnErrorListener {
    final /* synthetic */ f gAz;

    f$8(f fVar) {
        this.gAz = fVar;
    }

    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        x.i("MicroMsg.Notification.Tool.Sound", "play sound error, player: %s", new Object[]{this.gAz.gAw});
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        if (this.gAz.gAw != null) {
            this.gAz.gAw.release();
            x.i("MicroMsg.Notification.Tool.Sound", "play sound real error, player: %s,playerIsInit:%s", new Object[]{this.gAz.gAw, Boolean.valueOf(this.gAz.gAv)});
        }
        return false;
    }
}
