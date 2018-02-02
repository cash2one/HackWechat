package com.tencent.mm.plugin.brandservice.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.apr;
import com.tencent.mm.protocal.c.apu;
import com.tencent.mm.protocal.c.apv;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class l extends k implements com.tencent.mm.network.k {
    public b gJQ;
    private e gJT;

    public l(String str, LinkedList<apr> linkedList) {
        a aVar = new a();
        aVar.hmj = new apu();
        aVar.hmk = new apv();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/setrecvtmpmsgoption";
        aVar.hmi = 1030;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        apu com_tencent_mm_protocal_c_apu = (apu) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_apu.wrU = str;
        com_tencent_mm_protocal_c_apu.wwz = linkedList;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.brandservice.NetSceneSetRecvTmpMsgOption", "onGYNetEnd code(%d, %d)", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1030;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        x.i("MicroMsg.brandservice.NetSceneSetRecvTmpMsgOption", "do scene");
        return a(eVar, this.gJQ, this);
    }
}
