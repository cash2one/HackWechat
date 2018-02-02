package com.tencent.mm.protocal;

import com.tencent.mm.protocal.c.gk;
import com.tencent.mm.protocal.k.b;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public class l$a extends d implements b {
    public int netType;
    public int vBs = 0;

    public final byte[] Hq() {
        gk gkVar = new gk();
        gkVar.vLa = d.vAz;
        gkVar.vLF = 2;
        gkVar.vLG = this.netType;
        gkVar.vLH = this.vBs;
        x.i("MicroMsg.MMBgFg", "somr online:%d nettype:%d ver:%d devid:%d", new Object[]{Integer.valueOf(gkVar.vLH), Integer.valueOf(gkVar.vLG), Integer.valueOf(gkVar.vLa), Integer.valueOf(gkVar.vLF)});
        byte[] bArr = null;
        try {
            bArr = gkVar.toByteArray();
        } catch (Throwable e) {
            x.e("MicroMsg.MMBgFg", "MMBgfg toProtoBuf exception:%s", new Object[]{bh.i(e)});
        }
        return bArr;
    }

    public final int Hr() {
        return 0;
    }

    public final int getCmdId() {
        return 312;
    }

    public final boolean cdI() {
        return true;
    }

    public final boolean KH() {
        return false;
    }
}
