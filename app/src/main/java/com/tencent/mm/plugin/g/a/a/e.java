package com.tencent.mm.plugin.g.a.a;

import com.tencent.mm.plugin.exdevice.j.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class e {
    private final g kvX = new g();
    public final h kvY = new h();

    public final boolean ab(byte[] bArr) {
        if (bh.bw(bArr)) {
            x.e("MicroMsg.exdevice.IBeaconProtocal", "dataIn is null or nil");
            return false;
        }
        a aVar = new a(bArr.length);
        aVar.J(bArr, bArr.length);
        boolean a = this.kvX.a(aVar);
        if (a) {
            a = this.kvY.a(aVar);
            if (a) {
                return a;
            }
            x.d("MicroMsg.exdevice.IBeaconProtocal", "mSectionB.ParseTLV Failed!!!");
            return a;
        }
        x.d("MicroMsg.exdevice.IBeaconProtocal", "mSectionA.ParseTLV Failed!!!");
        return a;
    }
}
