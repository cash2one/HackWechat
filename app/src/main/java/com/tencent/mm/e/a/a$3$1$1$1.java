package com.tencent.mm.e.a;

import com.tencent.mm.compatible.b.f;
import com.tencent.mm.e.a.a.3.1.1;
import com.tencent.mm.sdk.platformtools.ar.a;
import com.tencent.mm.sdk.platformtools.x;

class a$3$1$1$1 implements a {
    final /* synthetic */ 1 fjL;

    a$3$1$1$1(1 1) {
        this.fjL = 1;
    }

    public final void vh() {
        x.i("MicroMsg.SceneVoicePlayer", "play sound end onCompletion");
        if (!this.fjL.fjK.fjJ.fjH.isPlaying()) {
            f.xG().b(this.fjL.fjK.fjJ.fjH);
            x.i("MicroMsg.SceneVoicePlayer", "onCompletion() continuousPlay:%s", Boolean.valueOf(this.fjL.fjK.fjJ.fjH.fjv));
            if (!this.fjL.fjK.fjJ.fjH.fjv) {
                f.xG().xJ();
            }
            this.fjL.fjK.fjJ.fjH.fjv = false;
            this.fjL.fjK.fjJ.fjH.fjy = false;
            f.xG().setMode(0);
            x.i("MicroMsg.SceneVoicePlayer", "onCompletion() resetSpeaker");
        }
    }
}
