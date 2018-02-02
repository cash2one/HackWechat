package com.tencent.mm.plugin.collect.b;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.mm.plugin.collect.b.g.a;
import com.tencent.mm.plugin.collect.b.g.b;
import com.tencent.mm.sdk.platformtools.x;

class g$1 implements OnCompletionListener {
    final /* synthetic */ b lit;
    final /* synthetic */ g liu;

    g$1(g gVar, b bVar) {
        this.liu = gVar;
        this.lit = bVar;
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        x.i("MicroMsg.F2fRcvVoiceListener", "start play money");
        if (g.a(this.liu) != null && g.b(this.liu) && g.c(this.liu) == null) {
            g.a(this.liu, a.a(this.lit.fileName, new OnCompletionListener(this) {
                final /* synthetic */ g$1 liv;

                {
                    this.liv = r1;
                }

                public final void onCompletion(MediaPlayer mediaPlayer) {
                    x.i("MicroMsg.F2fRcvVoiceListener", "play done");
                    g.d(this.liv.liu);
                    g.a(this.liv.liu, null);
                    g.e(this.liv.liu);
                    if (g.f(this.liv.liu).isEmpty()) {
                        g.ayM();
                    } else {
                        g.g(this.liv.liu);
                    }
                }
            }, new 2(this)));
        } else {
            x.i("MicroMsg.F2fRcvVoiceListener", "has played");
        }
        g.h(this.liu);
    }
}
