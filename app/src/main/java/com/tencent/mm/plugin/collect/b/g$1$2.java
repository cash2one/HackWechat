package com.tencent.mm.plugin.collect.b;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.mm.plugin.collect.b.g.1;
import com.tencent.mm.sdk.platformtools.x;

class g$1$2 implements OnErrorListener {
    final /* synthetic */ 1 liv;

    g$1$2(1 1) {
        this.liv = 1;
    }

    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        x.e("MicroMsg.F2fRcvVoiceListener", "play money error: %s, %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        g.d(this.liv.liu);
        g.a(this.liv.liu, null);
        g.e(this.liv.liu);
        if (g.f(this.liv.liu).isEmpty()) {
            g.ayM();
        } else {
            g.g(this.liv.liu);
        }
        return false;
    }
}
