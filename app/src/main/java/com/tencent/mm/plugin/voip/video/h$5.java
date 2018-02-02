package com.tencent.mm.plugin.voip.video;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

class h$5 implements OnCompletionListener {
    final /* synthetic */ h suJ;

    h$5(h hVar) {
        this.suJ = hVar;
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        mediaPlayer.release();
        if (System.currentTimeMillis() - this.suJ.suH > 5000) {
            this.suJ.suF = 8;
        }
    }
}
