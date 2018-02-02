package com.tencent.mm.booter.notification.a;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.mm.sdk.platformtools.x;

class f$3 implements OnCompletionListener {
    final /* synthetic */ AudioManager gAC;
    final /* synthetic */ f gAz;

    f$3(f fVar, AudioManager audioManager) {
        this.gAz = fVar;
        this.gAC = audioManager;
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        x.i("MicroMsg.Notification.Tool.Sound", "WiredHeadset play sound finish, player: %s", new Object[]{this.gAz.gAw});
        this.gAC.setMode(0);
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        if (this.gAz.gAw != null) {
            this.gAz.gAw.release();
        }
    }
}
