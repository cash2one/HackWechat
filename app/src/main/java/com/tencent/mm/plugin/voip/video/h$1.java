package com.tencent.mm.plugin.voip.video;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

class h$1 implements OnCompletionListener {
    final /* synthetic */ h suJ;

    h$1(h hVar) {
        this.suJ = hVar;
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        if (System.currentTimeMillis() - this.suJ.suG > 70000) {
            this.suJ.suF = 4;
        }
    }
}
