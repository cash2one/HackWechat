package com.tencent.mm.plugin.g.a.a;

import com.tencent.mm.sdk.platformtools.x;
import java.util.UUID;

class f$7 implements Runnable {
    final /* synthetic */ f kwp;
    final /* synthetic */ UUID kwr;

    public f$7(f fVar, UUID uuid) {
        this.kwp = fVar;
        this.kwr = uuid;
    }

    public final void run() {
        if (!f.b(this.kwp, this.kwr)) {
            x.e("MicroMsg.exdevice.IBeaconServer", "stopRanging failed!!!");
        }
    }
}
