package com.tencent.mm.modelstat;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bb;
import com.tencent.mm.protocal.c.bc;
import com.tencent.mm.protocal.c.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class i extends k implements com.tencent.mm.network.k {
    private final b gJQ;
    private e gOB;

    public i(int i, String str, int i2) {
        a aVar = new a();
        aVar.hmj = new bb();
        aVar.hmk = new bc();
        aVar.uri = "/cgi-bin/mmoc-bin/ad/addatareport";
        aVar.hmi = 1295;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        bb bbVar = (bb) this.gJQ.hmg.hmo;
        bh bhVar = new bh();
        bhVar.vGy = i;
        bhVar.vGz = new com.tencent.mm.bq.b(str.getBytes());
        bhVar.vGA = (long) i2;
        bbVar.vGj.add(bhVar);
        x.i("MicroMsg.NetSceneAdDataReport", "init logId:%d, logStr:%s", new Object[]{Integer.valueOf(i), str});
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        bc bcVar = (bc) this.gJQ.hmh.hmo;
        x.i("MicroMsg.NetSceneAdDataReport", "onGYNetEnd, errType = %d, errCode = %d, ret=%d, msg=%s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(bcVar.ret), bcVar.fpb});
        this.gOB.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1295;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gOB = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
