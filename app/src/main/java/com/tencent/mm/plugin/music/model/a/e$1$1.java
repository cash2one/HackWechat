package com.tencent.mm.plugin.music.model.a;

import com.tencent.mm.plugin.music.model.a.e.1;
import com.tencent.mm.sdk.platformtools.x;

class e$1$1 implements Runnable {
    final /* synthetic */ 1 oKR;

    e$1$1(1 1) {
        this.oKR = 1;
    }

    public final void run() {
        x.i("MicroMsg.Audio.QQAudioPlayer", "onSeekComplete");
        if (this.oKR.oKQ.hkt != 0) {
            x.i("MicroMsg.Audio.QQAudioPlayer", "seek complete to startTime :%d", new Object[]{Integer.valueOf(this.oKR.oKQ.hkt)});
            this.oKR.oKQ.hkt = 0;
            1.a(this.oKR);
            return;
        }
        1 1 = this.oKR;
        x.i("MicroMsg.Audio.QQAudioPlayer", "_onSeekComplete");
        1.oKQ.bdX();
        if (1.oKQ.Qq()) {
            x.i("MicroMsg.Audio.QQAudioPlayer", "seek end, send play event!");
            1.oKQ.bdU();
        }
    }
}
