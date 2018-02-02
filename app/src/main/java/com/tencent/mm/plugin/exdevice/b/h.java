package com.tencent.mm.plugin.exdevice.b;

import com.tencent.mm.bq.a;
import com.tencent.mm.plugin.exdevice.e.c;
import com.tencent.mm.plugin.exdevice.e.n;
import com.tencent.mm.sdk.platformtools.x;

public final class h extends j {
    public h(int i, int i2, long j) {
        a nVar = new n();
        nVar.lOG = new c();
        nVar.lOK = i;
        nVar.lOL = i2;
        this.lKc = nVar;
        this.kAq = j;
    }

    public final byte[] aDI() {
        byte[] bArr = null;
        try {
            bArr = this.lKc.toByteArray();
        } catch (Exception e) {
            x.e("MicroMsg.exdevice.ExDeviceCmdSwitchViewPush", "mResp.toByteArray() Failed!!! %s", new Object[]{e.getMessage()});
        }
        return bArr;
    }

    public final int aDK() {
        n nVar = (n) this.lKc;
        if (nVar != null) {
            return nVar.lOK;
        }
        x.e("MicroMsg.exdevice.ExDeviceCmdSwitchViewPush", "null = pushReq");
        return -1;
    }
}
