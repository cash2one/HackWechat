package com.tencent.mm.plugin.music.model.notification;

import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class MMMusicPlayerService$1 implements Runnable {
    final /* synthetic */ MMMusicPlayerService oMd;

    MMMusicPlayerService$1(MMMusicPlayerService mMMusicPlayerService) {
        this.oMd = mMMusicPlayerService;
    }

    public final void run() {
        x.i("MicroMsg.Music.MMMusicPlayerService", "quit");
        ag.K(MMMusicPlayerService.a(this.oMd));
        this.oMd.stopSelf();
    }
}
