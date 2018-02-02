package com.tencent.mm.protocal;

import com.tencent.mm.protocal.c.ep;
import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.sdk.platformtools.x;

public class j$b extends e implements c {
    public ep vBe = new ep();

    public final int E(byte[] bArr) {
        this.vBe = (ep) new ep().aF(bArr);
        x.d("MicroMsg.MMBakchatCreateQRcodeOffline.Resp", "Ret:%d, QRCodeBuffer:%s, QRCodeUrl:%s", new Object[]{Integer.valueOf(this.vBe.vJU), this.vBe.vJV, this.vBe.vJW});
        return this.vBe.vJU;
    }

    public final int getCmdId() {
        return 1000;
    }
}
