package com.tencent.mm.plugin.card.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.abo;
import com.tencent.mm.protocal.c.abp;
import com.tencent.mm.protocal.c.azg;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class ae extends k implements com.tencent.mm.network.k {
    private final b gJQ;
    private e gJT;
    public azg kMe;

    public ae(LinkedList<String> linkedList, int i) {
        a aVar = new a();
        aVar.hmj = new abo();
        aVar.hmk = new abp();
        aVar.uri = "/cgi-bin/micromsg-bin/getdynamiccardcode";
        aVar.hmi = 1382;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        abo com_tencent_mm_protocal_c_abo = (abo) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_abo.wkw = linkedList;
        com_tencent_mm_protocal_c_abo.scene = i;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetDynamicCardCode", "onGYNetEnd, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            this.kMe = ((abp) this.gJQ.hmh.hmo).wkx;
        }
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1382;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
