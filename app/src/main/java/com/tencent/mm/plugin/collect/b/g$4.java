package com.tencent.mm.plugin.collect.b;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.mm.sdk.platformtools.x;

class g$4 implements OnCompletionListener {
    final /* synthetic */ g liu;

    g$4(g gVar) {
        this.liu = gVar;
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        x.i("MicroMsg.F2fRcvVoiceListener", "no need to play money this time");
        g.e(this.liu);
        g.d(this.liu);
        g.h(this.liu);
        if (g.f(this.liu).isEmpty()) {
            g.ayM();
        } else {
            g.g(this.liu);
        }
    }
}
