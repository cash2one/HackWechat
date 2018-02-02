package com.tencent.mm.plugin.exdevice.b;

import com.tencent.mm.bq.a;
import com.tencent.mm.sdk.platformtools.x;

public abstract class d extends c {
    protected a lKd = null;
    private short lKe = (short) -1;
    private short lKf = (short) -1;

    protected abstract a an(byte[] bArr);

    public d(long j, int i, int i2, byte[] bArr) {
        x.i("MicroMsg.exdevice.ExDeviceCmdBaseReqResp", "onDeviceRequest deviceId = " + j + " seq = " + i + " cmdId = " + i2);
        this.kAq = j;
        this.lKe = (short) i2;
        this.lKf = (short) i;
        an(bArr);
    }

    public final short aDG() {
        return this.lKe;
    }

    public final short aDH() {
        return this.lKf;
    }

    public final a aDJ() {
        return this.lKd;
    }

    public final byte[] aDI() {
        try {
            return this.lKc.toByteArray();
        } catch (Throwable e) {
            x.e("MicroMsg.exdevice.ExDeviceCmdBaseReqResp", "mResp.toByteArray() Failed!!! %s", new Object[]{e.getMessage()});
            x.printErrStackTrace("MicroMsg.exdevice.ExDeviceCmdBaseReqResp", e, "", new Object[0]);
            return null;
        }
    }
}
