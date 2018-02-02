package com.tencent.mm.plugin.collect.b;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.mm.sdk.platformtools.x;

class g$2 implements OnErrorListener {
    final /* synthetic */ g liu;

    g$2(g gVar) {
        this.liu = gVar;
    }

    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        x.e("MicroMsg.F2fRcvVoiceListener", "prefix play error");
        g.d(this.liu);
        g.h(this.liu);
        g.e(this.liu);
        if (g.f(this.liu).isEmpty()) {
            g.ayM();
        } else {
            g.g(this.liu);
        }
        return false;
    }
}
