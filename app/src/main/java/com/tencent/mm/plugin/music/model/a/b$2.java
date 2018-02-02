package com.tencent.mm.plugin.music.model.a;

import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;

class b$2 implements Runnable {
    final /* synthetic */ b oKy;

    b$2(b bVar) {
        this.oKy = bVar;
    }

    public final void run() {
        x.i("MicroMsg.Audio.AudioPlayerMgr", "stopAudioDelayRunnable, run");
        Iterator it = this.oKy.oKj.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (this.oKy.FU(str) == 0) {
                this.oKy.FW(str);
            }
        }
    }
}
