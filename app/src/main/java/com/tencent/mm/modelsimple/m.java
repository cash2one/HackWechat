package com.tencent.mm.modelsimple;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.j;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.x;

public final class m extends k implements com.tencent.mm.network.k {
    private e gJT;
    private final q hnp = new j();

    public final int getType() {
        return 381;
    }

    public final boolean Kg() {
        return false;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.hnp, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGetCert", "dkcert onGYNetEnd [%d,%d]", Integer.valueOf(i2), Integer.valueOf(i3));
        this.gJT.a(i2, i3, str, this);
    }
}
