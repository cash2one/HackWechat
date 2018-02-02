package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.mb;
import com.tencent.mm.protocal.c.mc;
import com.tencent.mm.sdk.platformtools.bh;

public final class a extends k implements com.tencent.mm.network.k {
    private b gJQ;
    private e gJT;

    public a(String str, String str2) {
        com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
        aVar.hmj = new mb();
        aVar.hmk = new mc();
        aVar.uri = "/cgi-bin/mmoc-bin/adplayinfo/channelpkginfo";
        this.gJQ = aVar.JZ();
        mb mbVar = (mb) this.gJQ.hmg.hmo;
        mbVar.vUM = str2;
        mbVar.vUJ = str;
        mbVar.vUN = bh.cgC();
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return this.gJQ.hmi;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
