package com.tencent.mm.plugin.g.a.a;

import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;

class f$2 implements a {
    final /* synthetic */ f kwp;

    f$2(f fVar) {
        this.kwp = fVar;
    }

    public final boolean uF() {
        if (f.f(this.kwp).size() > 0) {
            x.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]mSelfAdaptionTimer now start");
            if (f.g(this.kwp).booleanValue()) {
                x.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]mSelfAdaptionTimer restart bleScan ok");
            } else {
                x.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]mSelfAdaptionTimer restart bleScan fail");
            }
            f.dQ(ac.getContext().getSharedPreferences("com.tencent.mm_exdevice_ibeacon_isNewScanning", 4).getBoolean("isNewScanning", false));
            if (!f.apF()) {
                if (!f.h(this.kwp).cfK()) {
                    f.h(this.kwp).TG();
                }
                if (!f.i(this.kwp).cfK()) {
                    f.i(this.kwp).TG();
                }
            }
        }
        return false;
    }
}
