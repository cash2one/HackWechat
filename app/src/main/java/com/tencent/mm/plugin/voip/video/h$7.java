package com.tencent.mm.plugin.voip.video;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.mm.z.ar;

class h$7 implements OnCompletionListener {
    final /* synthetic */ h suJ;

    public h$7(h hVar) {
        this.suJ = hVar;
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        mediaPlayer.release();
        if (System.currentTimeMillis() - this.suJ.suH > 5000) {
            this.suJ.suF = 8;
            ar.Hh().setMode(0);
        }
    }
}
