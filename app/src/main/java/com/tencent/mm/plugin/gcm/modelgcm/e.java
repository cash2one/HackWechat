package com.tencent.mm.plugin.gcm.modelgcm;

import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.gcm.modelgcm.c.a;

public final class e extends k implements com.tencent.mm.network.k {
    private com.tencent.mm.ae.e gJT = null;
    private q hnp;
    private String nyt = null;
    private int uin = 0;

    public e(String str, int i) {
        this.nyt = str;
        this.uin = i;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ae.e eVar2) {
        this.gJT = eVar2;
        this.hnp = new a();
        ((a) this.hnp).uin = this.uin;
        ((a) this.hnp.Kb()).nyp.vDV = this.nyt;
        return a(eVar, this.hnp, this);
    }

    public final int getType() {
        return 623;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        this.gJT.a(i2, i3, str, this);
    }
}
