package com.tencent.mm.ag.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bpe;
import com.tencent.mm.protocal.c.bpf;
import com.tencent.mm.protocal.c.hj;
import com.tencent.mm.sdk.platformtools.x;

public final class w extends k implements com.tencent.mm.network.k {
    Object data;
    public b gJQ;
    private e gJT;

    public w(String str, hj hjVar, Object obj) {
        a aVar = new a();
        aVar.hmj = new bpe();
        aVar.hmk = new bpf();
        aVar.uri = "/cgi-bin/mmocbiz-bin/updatebizchat";
        aVar.hmi = 1356;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        bpe com_tencent_mm_protocal_c_bpe = (bpe) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_bpe.vNq = str;
        com_tencent_mm_protocal_c_bpe.wgJ = hjVar;
        this.data = obj;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.brandservice.NetSceneUpdateBizChat", "onGYNetEnd code(%d, %d)", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1356;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        x.i("MicroMsg.brandservice.NetSceneUpdateBizChat", "do scene");
        return a(eVar, this.gJQ, this);
    }
}
