package com.tencent.mm.ag;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.anh;
import com.tencent.mm.sdk.platformtools.x;

public final class u extends k implements com.tencent.mm.network.k {
    public b gJQ;
    private e gJT;
    public String hqf;

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneKFGetDefaultList", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 672;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        x.i("MicroMsg.NetSceneKFGetDefaultList", "do scene");
        return a(eVar, this.gJQ, this);
    }

    public final anh Mb() {
        if (this.gJQ == null || this.gJQ.hmh.hmo == null) {
            return null;
        }
        return (anh) this.gJQ.hmh.hmo;
    }
}
