package com.tencent.mm.ag.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.hk;
import com.tencent.mm.protocal.c.zd;
import com.tencent.mm.protocal.c.ze;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class p extends k implements com.tencent.mm.network.k {
    public b gJQ;
    private e gJT;
    Map<String, String> hrv = new HashMap();

    public p(LinkedList<hk> linkedList) {
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            hk hkVar = (hk) it.next();
            String str = hkVar.vNk;
            String str2 = hkVar.vNq;
            if (!(str2 == null || str == null)) {
                this.hrv.put(str, str2);
            }
        }
        a aVar = new a();
        aVar.hmj = new zd();
        aVar.hmk = new ze();
        aVar.uri = "/cgi-bin/mmocbiz-bin/getbizchatinfolist";
        aVar.hmi = 1365;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        ((zd) this.gJQ.hmg.hmo).wjc = linkedList;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.brandservice.NetSceneGetBizChatInfoList", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1365;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        x.i("MicroMsg.brandservice.NetSceneGetBizChatInfoList", "do scene");
        return a(eVar, this.gJQ, this);
    }
}
