package com.tencent.mm.protocal;

import com.tencent.mm.protocal.c.en;
import com.tencent.mm.protocal.k.b;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.sdk.platformtools.x;

public class j$a extends d implements b {
    public en vBc = new en();
    public byte[] vBd;

    public final byte[] Hq() {
        this.vBc.wIV = k.a(this);
        x.d("MicroMsg.MMBakchatCreateQRcodeOffline.Req", "key:%s  AddrCount:%s  AddrList:%s, PCName:%s, PCAcctName:%s, Scene:%s, DataSize:%s, WifiName:%s, Tickit:%s", new Object[]{this.vBd, Integer.valueOf(this.vBc.vJO), this.vBc.vJP, this.vBc.vJQ, this.vBc.vJR, Integer.valueOf(this.vBc.rYW), Long.valueOf(this.vBc.kti), this.vBc.vJS, this.vBc.vJT});
        return this.vBc.toByteArray();
    }

    public final int Hr() {
        return 1000;
    }

    public final int getCmdId() {
        return 1000;
    }
}
