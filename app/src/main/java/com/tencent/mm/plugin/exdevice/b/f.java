package com.tencent.mm.plugin.exdevice.b;

import com.tencent.mm.bq.a;
import com.tencent.mm.bq.b;
import com.tencent.mm.plugin.exdevice.e.k;
import com.tencent.mm.plugin.exdevice.e.l;
import com.tencent.mm.sdk.platformtools.x;

public final class f extends d {
    public f(long j, int i, int i2, byte[] bArr) {
        super(j, i, i2, bArr);
        x.i("MicroMsg.exdevice.ExDeviceCmdSendDataToManufacturer", "ExDeviceCmdSendDataToManufacturer deviceId = " + j + " seq = " + i + " cmdId = " + i2);
    }

    public final void b(int i, String str, byte[] bArr) {
        x.i("MicroMsg.exdevice.ExDeviceCmdSendDataToManufacturer", "setSendDataToManufacturerResponse ret = " + i + str);
        a lVar = new l();
        lVar.lOI = U(i, str);
        if (bArr == null) {
            bArr = new byte[0];
        }
        lVar.ksB = new b(bArr);
        this.lKc = lVar;
        this.lKa = (short) 20002;
    }

    protected final a an(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            x.e("MicroMsg.exdevice.ExDeviceCmdSendDataToManufacturer", "data is null");
            return null;
        }
        a kVar = new k();
        try {
            kVar.aF(bArr);
            this.lKd = kVar;
            x.i("MicroMsg.exdevice.ExDeviceCmdSendDataToManufacturer", "SendDataToManufacturerSvrRequest cmd has been received");
            return kVar;
        } catch (Throwable e) {
            x.e("MicroMsg.exdevice.ExDeviceCmdSendDataToManufacturer", "SendDataToManufacturerSvrRequest.parseFrom Failed!!! %s", new Object[]{e.getMessage()});
            x.printErrStackTrace("MicroMsg.exdevice.ExDeviceCmdSendDataToManufacturer", e, "", new Object[0]);
            return null;
        }
    }
}
