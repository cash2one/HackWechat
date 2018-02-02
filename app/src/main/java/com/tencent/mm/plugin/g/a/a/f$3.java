package com.tencent.mm.plugin.g.a.a;

import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;

class f$3 implements a {
    final /* synthetic */ f kwp;

    f$3(f fVar) {
        this.kwp = fVar;
    }

    public final boolean uF() {
        if (f.f(this.kwp).size() <= 0) {
            return false;
        }
        x.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]mSelfAdaptionTimer now stop");
        f.j(this.kwp);
        if (f.i(this.kwp).cfK()) {
            f.i(this.kwp).J(2000, 2000);
        }
        return true;
    }
}
