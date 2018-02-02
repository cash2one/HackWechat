package com.tencent.mm.plugin.music.model.a;

import com.tencent.mm.plugin.music.model.a.e.1;
import com.tencent.mm.sdk.platformtools.x;

class e$1$3 implements Runnable {
    final /* synthetic */ int iVx;
    final /* synthetic */ 1 oKR;

    e$1$3(1 1, int i) {
        this.oKR = 1;
        this.iVx = i;
    }

    public final void run() {
        String str = this.oKR.oKQ.fnF;
        x.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged state %d, %s", new Object[]{Integer.valueOf(this.iVx), str});
        if (this.iVx == 3) {
            x.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged PREPARING!");
            1.b(this.oKR);
            this.oKR.oKQ.oKN = System.currentTimeMillis();
        } else if (this.iVx == 2) {
            x.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged PREPARED!");
            x.i("MicroMsg.Audio.QQAudioPlayer", "preparing cost time :%d!", new Object[]{Long.valueOf(System.currentTimeMillis() - this.oKR.oKQ.oKN)});
            1.a(this.oKR);
        } else if (this.iVx == 4) {
            x.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged STARTED! audioId:%s", new Object[]{this.oKR.oKQ.fnF});
            x.i("MicroMsg.Audio.QQAudioPlayer", "start cost time :%d!", new Object[]{Long.valueOf(System.currentTimeMillis() - this.oKR.oKQ.oKN)});
            1.c(this.oKR);
        } else if (this.iVx == 5) {
            x.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged PAUSED!");
            1.d(this.oKR);
        } else if (this.iVx == 6) {
            x.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged STOPPED! audioId:%s", new Object[]{this.oKR.oKQ.fnF});
            1.e(this.oKR);
        } else if (this.iVx == 7) {
            x.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged PLAYBACKCOMPLETED!");
            1.f(this.oKR);
        } else if (this.iVx == 8) {
            x.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged END!");
            1.beh();
        } else if (this.iVx == 9) {
            x.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged ERROR!");
        }
    }
}
