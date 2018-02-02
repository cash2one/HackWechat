package com.tencent.mm.plugin.music.model.a;

import com.tencent.mm.sdk.platformtools.x;

class e$a implements Runnable {
    boolean isStop;
    final /* synthetic */ e oKQ;

    private e$a(e eVar) {
        this.oKQ = eVar;
        this.isStop = true;
    }

    public final void run() {
        x.i("MicroMsg.Audio.QQAudioPlayer", "start run play progress task");
        while (!this.isStop) {
            try {
                if (this.oKQ.oKD != null && this.oKQ.Qq()) {
                    this.oKQ.beg();
                }
            } catch (Exception e) {
                x.e("MicroMsg.Audio.QQAudioPlayer", "PlayProgressTask run exception:" + e.getMessage());
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e2) {
            }
        }
    }
}
