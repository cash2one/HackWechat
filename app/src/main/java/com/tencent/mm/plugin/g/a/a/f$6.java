package com.tencent.mm.plugin.g.a.a;

import com.tencent.mm.sdk.platformtools.x;
import java.util.UUID;

class f$6 implements Runnable {
    final /* synthetic */ f kwp;
    final /* synthetic */ UUID kwr;

    public f$6(f fVar, UUID uuid) {
        this.kwp = fVar;
        this.kwr = uuid;
    }

    public final void run() {
        if (!f.a(this.kwp, this.kwr)) {
            x.e("MicroMsg.exdevice.IBeaconServer", "startRanging failed!!!");
        }
    }
}
