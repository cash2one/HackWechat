package com.tencent.mm.plugin.music.model.notification;

import android.content.Intent;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;

public final class b {
    public c jeX;
    public MMMusicPlayerService oLT;
    volatile boolean oLZ = false;

    final synchronized void bev() {
        if (this.oLT == null || !this.oLZ) {
            this.oLZ = true;
            Intent intent = new Intent();
            intent.setClass(ac.getContext(), MMMusicPlayerService.class);
            boolean bindService = ac.getContext().bindService(intent, new 2(this), 1);
            x.i("MicroMsg.Music.MMMusicNotificationHelper", "isOk:%b", new Object[]{Boolean.valueOf(bindService)});
        }
    }
}
