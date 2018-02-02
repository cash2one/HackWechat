package com.tencent.mm.plugin.exdevice.b;

import com.tencent.mm.bq.a;
import com.tencent.mm.bq.b;
import com.tencent.mm.plugin.exdevice.e.c;
import com.tencent.mm.plugin.exdevice.e.h;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;
import junit.framework.Assert;

public final class i extends j {
    public i(byte[] bArr, int i, long j) {
        a hVar = new h();
        hVar.lOG = new c();
        hVar.ksB = new b(bArr);
        hVar.ktN = i;
        this.lKc = hVar;
        this.kAq = j;
        this.lKa = (short) 30001;
    }

    public final byte[] aDI() {
        Assert.assertNotNull(this.lKc);
        try {
            return this.lKc.toByteArray();
        } catch (IOException e) {
            x.e("MicroMsg.exdevice.ExDevicePushManufacturerSvrSendData", "mResp.toByteArray() Failed!!! %s", new Object[]{e.getMessage()});
            return null;
        }
    }
}
