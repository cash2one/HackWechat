package com.tencent.mm.ag.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.alg;
import com.tencent.mm.protocal.c.alh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class t extends k implements com.tencent.mm.network.k {
    Object data;
    public b gJQ;
    private e gJT;
    public String hrt;

    public t(String str, String str2, LinkedList<String> linkedList, Object obj) {
        a aVar = new a();
        aVar.hmj = new alg();
        aVar.hmk = new alh();
        aVar.uri = "/cgi-bin/mmocbiz-bin/initiatebizchat";
        aVar.hmi = 1389;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        alg com_tencent_mm_protocal_c_alg = (alg) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_alg.vYi = str;
        if (str2 == null) {
            str2 = "";
        }
        com_tencent_mm_protocal_c_alg.wsv = str2;
        com_tencent_mm_protocal_c_alg.wsw = linkedList;
        this.data = obj;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneInitiateBizChat", "onGYNetEnd code(%d, %d)", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1389;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        x.i("MicroMsg.NetSceneInitiateBizChat", "do scene");
        return a(eVar, this.gJQ, this);
    }

    public final alh MB() {
        if (this.gJQ == null || this.gJQ.hmh.hmo == null) {
            return null;
        }
        return (alh) this.gJQ.hmh.hmo;
    }
}
