package com.tencent.mm.booter.notification.a;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.mm.sdk.platformtools.x;

class f$5 implements OnCompletionListener {
    final /* synthetic */ f gAz;

    f$5(f fVar) {
        this.gAz = fVar;
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        x.i("MicroMsg.Notification.Tool.Sound", "WiredHeadset play sound finish, player: %s", new Object[]{this.gAz.gAw});
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        if (this.gAz.gAw != null) {
            this.gAz.gAw.release();
        }
    }
}
