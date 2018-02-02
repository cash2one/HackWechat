package com.tencent.mm.plugin.music.model.g;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnSeekCompleteListener;
import com.tencent.mm.sdk.platformtools.x;

class d$2 implements OnSeekCompleteListener {
    final /* synthetic */ d oMm;

    d$2(d dVar) {
        this.oMm = dVar;
    }

    public final void onSeekComplete(MediaPlayer mediaPlayer) {
        if (this.oMm.hXM != null && this.oMm.hXM.isPlaying()) {
            x.i("MicroMsg.Music.MMMediaPlayer", "onSeekComplete");
            try {
                this.oMm.hXM.start();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", e, "start", new Object[0]);
            }
        }
    }
}
