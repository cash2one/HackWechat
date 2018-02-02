package com.tencent.mm.plugin.g.a.a;

import com.tencent.mm.plugin.exdevice.j.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Arrays;

public final class h extends j {
    private static final byte[] kwx = new byte[]{(byte) 76, (byte) 0, (byte) 2, (byte) 21};
    public short kwA = (short) -1;
    public short kwB = (short) -1;
    public int kwC = 0;
    private byte[] kwy = null;
    public byte[] kwz = null;

    final boolean ac(byte[] bArr) {
        if (bh.bw(bArr)) {
            x.e("MicroMsg.exdevice.IBeaconTLVSectionB", "valueByte is null or nil");
            return false;
        } else if (26 != this.mLength) {
            x.d("MicroMsg.exdevice.IBeaconTLVSectionB", "IBEACON_TLV_SECTION_B_LENGTH != mLength(%d) ", new Object[]{Integer.valueOf(this.mLength)});
            return false;
        } else {
            a aVar = new a(bArr.length);
            aVar.J(bArr, bArr.length);
            byte[] bArr2 = new byte[4];
            aVar.I(bArr2, 4);
            if (Arrays.equals(bArr2, kwx)) {
                this.kwy = bArr2;
                this.kwz = new byte[16];
                aVar.I(this.kwz, 16);
                try {
                    this.kwA = aVar.readShort();
                    this.kwB = aVar.readShort();
                    bArr2 = new byte[1];
                    aVar.I(bArr2, 1);
                    this.kwC = bArr2[0];
                    return true;
                } catch (Throwable e) {
                    x.d("MicroMsg.exdevice.IBeaconTLVSectionB", "Read major/minor from autobuffer failed!!!");
                    x.printErrStackTrace("MicroMsg.exdevice.IBeaconTLVSectionB", e, "", new Object[0]);
                    return false;
                }
            }
            x.d("MicroMsg.exdevice.IBeaconTLVSectionB", "Cannot find ibeacon cookies!!!");
            return false;
        }
    }
}
