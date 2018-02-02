package com.tencent.mm.plugin.subapp.c;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.mm.sdk.platformtools.x;

class d$1 implements OnCompletionListener {
    final /* synthetic */ d rWp;

    d$1(d dVar) {
        this.rWp = dVar;
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        try {
            mediaPlayer.release();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SubCoreVoiceRemind", e, "", new Object[0]);
        }
    }
}
