package com.tencent.mm.plugin.location.model.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.td;
import com.tencent.mm.protocal.c.te;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends k implements com.tencent.mm.network.k {
    public final b gJQ;
    private e gJT;
    private Runnable hOe;

    public a(String str) {
        com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
        aVar.hmj = new td();
        aVar.hmk = new te();
        aVar.uri = "/cgi-bin/micromsg-bin/exittrackroom";
        aVar.hmi = 491;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        ((td) this.gJQ.hmg.hmo).wbr = str;
        x.d("MicroMsg.NetSceneExitTrackRoom", "trackRoomId:" + str);
    }

    public final int getType() {
        return 491;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneExitTrackRoom", "onGYNetEnd errType %d errCode%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
        if (this.hOe != null) {
            this.hOe.run();
        }
    }
}
