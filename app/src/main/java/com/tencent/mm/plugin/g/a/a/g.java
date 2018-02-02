package com.tencent.mm.plugin.g.a.a;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class g extends j {
    private byte kww = (byte) 0;

    final boolean ac(byte[] bArr) {
        if (bh.bw(bArr)) {
            x.e("MicroMsg.exdevice.IBeaconTLVSectionA", "valueByte is null or nil");
            return false;
        } else if (2 != this.mLength) {
            x.d("MicroMsg.exdevice.IBeaconTLVSectionA", "IBEACON_TLV_SECTION_A_LENGTH != mLength(%d)", new Object[]{Integer.valueOf(this.mLength)});
            return false;
        } else {
            this.kww = bArr[0];
            return true;
        }
    }
}
