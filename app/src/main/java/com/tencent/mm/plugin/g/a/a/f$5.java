package com.tencent.mm.plugin.g.a.a;

import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;

class f$5 implements a {
    final /* synthetic */ f kwp;

    f$5(f fVar) {
        this.kwp = fVar;
    }

    public final boolean uF() {
        x.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]time out ,let's stop this new method scan");
        f.k(this.kwp);
        return false;
    }
}
