package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.protocal.c.aut;
import com.tencent.mm.protocal.c.auu;
import com.tencent.mm.sdk.platformtools.x;

public final class q extends k implements com.tencent.mm.network.k {
    private e gJT;
    private b hNJ;
    private aut sze;
    public auu szf;

    public q(String str, String str2) {
        a aVar = new a();
        aVar.hmj = new aut();
        aVar.hmk = new auu();
        aVar.uri = "/cgi-bin/mmpay-bin/openlqbaccount";
        aVar.hml = 0;
        aVar.hmm = 0;
        this.hNJ = aVar.JZ();
        this.sze = (aut) this.hNJ.hmg.hmo;
        this.sze.vLI = str;
        this.sze.wCI = str2;
        x.i("MicroMsg.NetSceneOpenLqbAccount", "NetSceneOpenLqbAccount, eCardType: %s, extraData: %s", str, str2);
    }

    public final int getType() {
        return 2996;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.hNJ, this);
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneOpenLqbAccount", "onGYNetEnd, errType: %s, errCode: %s", Integer.valueOf(i2), Integer.valueOf(i3));
        this.szf = (auu) ((b) qVar).hmh.hmo;
        x.i("MicroMsg.NetSceneOpenLqbAccount", "onGYNetEnd, retcode: %s, retmsg: %s", Integer.valueOf(this.szf.kLO), this.szf.kLP);
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }
}
