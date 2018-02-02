package com.tencent.mm.e.a;

import com.tencent.mm.compatible.util.b.a;
import com.tencent.mm.sdk.platformtools.x;

class a$1 implements a {
    final /* synthetic */ a fjH;

    a$1(a aVar) {
        this.fjH = aVar;
    }

    public final void es(int i) {
        x.i("MicroMsg.SceneVoicePlayer", "on audio focus chage: %s", new Object[]{Integer.valueOf(i)});
        if (i == -2 || i == -3) {
            if (this.fjH.isPlaying()) {
                x.v("MicroMsg.SceneVoicePlayer", "alvinluo current fileName: %s, lastFileName: %s", new Object[]{a.a(this.fjH), a.bz()});
                if (a.a(this.fjH) == null || a.a(this.fjH).equals(a.bz())) {
                    this.fjH.aK(false);
                }
            }
        } else if (i == 1 || i == 2 || i == 3) {
            this.fjH.vc();
        } else if (i == -1) {
            this.fjH.aL(false);
        }
    }
}
