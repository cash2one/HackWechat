package com.tencent.mm.booter.notification.a;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.mm.sdk.platformtools.x;

class f$7 implements OnCompletionListener {
    final /* synthetic */ f gAz;

    f$7(f fVar) {
        this.gAz = fVar;
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        x.i("MicroMsg.Notification.Tool.Sound", "play sound finish, player: %s", new Object[]{this.gAz.gAw});
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        if (this.gAz.gAw != null) {
            this.gAz.gAw.release();
            x.i("MicroMsg.Notification.Tool.Sound", "play sound real finish, player: %s,playerIsInit:%s", new Object[]{this.gAz.gAw, Boolean.valueOf(this.gAz.gAv)});
        }
    }
}
