package com.tencent.mm.plugin.exdevice.b;

import com.tencent.mm.bq.a;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends d {
    public b(long j, int i, int i2, byte[] bArr) {
        super(j, i, i2, bArr);
        x.i("MicroMsg.exdevice.ExDeviceCmdAuth", "ExDeviceCmdAuth deviceId = " + j + " seq = " + i + " cmdId = " + i2);
    }

    public final void a(int i, String str, byte[] bArr) {
        x.i("MicroMsg.exdevice.ExDeviceCmdAuth", "------setAuthResponse------ret = " + i + "errMsg = " + str);
        a bVar = new com.tencent.mm.plugin.exdevice.e.b();
        bVar.lOI = U(i, str);
        bVar.lOp = com.tencent.mm.bq.b.bc(bArr);
        this.lKc = bVar;
        this.lKa = (short) 20001;
    }

    protected final a an(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            x.e("MicroMsg.exdevice.ExDeviceCmdAuth", "paras body is null");
            return null;
        }
        a aVar = new com.tencent.mm.plugin.exdevice.e.a();
        try {
            aVar.aF(bArr);
            this.lKd = aVar;
            x.i("MicroMsg.exdevice.ExDeviceCmdAuth", "------AuthRequest------ ClientVersion = " + aVar.lOi + " DeviceName = " + aVar.ksY + " Language = " + aVar.lOo + " TimeZone = " + aVar.lOn);
            return aVar;
        } catch (Throwable e) {
            x.e("MicroMsg.exdevice.ExDeviceCmdAuth", "AuthRequest.parseFrom Failed!!! %s", new Object[]{e.getMessage()});
            x.printErrStackTrace("MicroMsg.exdevice.ExDeviceCmdAuth", e, "", new Object[0]);
            return null;
        }
    }
}
