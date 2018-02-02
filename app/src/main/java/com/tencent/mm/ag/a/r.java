package com.tencent.mm.ag.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ij;
import com.tencent.mm.protocal.c.zj;
import com.tencent.mm.protocal.c.zk;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class r extends k implements com.tencent.mm.network.k {
    Object data;
    public b gJQ;
    private e gJT;
    Map<String, String> hrw = new HashMap();

    public r(LinkedList<ij> linkedList, Object obj) {
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ij ijVar = (ij) it.next();
            LinkedList linkedList2 = ijVar.vOD;
            String str = ijVar.vNq;
            if (!(str == null || linkedList2 == null || linkedList2.size() <= 0)) {
                Iterator it2 = linkedList2.iterator();
                while (it2.hasNext()) {
                    this.hrw.put((String) it2.next(), str);
                }
            }
        }
        a aVar = new a();
        aVar.hmj = new zj();
        aVar.hmk = new zk();
        aVar.uri = "/cgi-bin/mmocbiz-bin/getbizchatuserinfolist";
        aVar.hmi = 1353;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        ((zj) this.gJQ.hmg.hmo).wje = linkedList;
        this.data = obj;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.brandservice.NetSceneGetBizChatUserInfoList", "onGYNetEnd code(%d, %d)", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1353;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        x.i("MicroMsg.brandservice.NetSceneGetBizChatUserInfoList", "do scene");
        return a(eVar, this.gJQ, this);
    }
}
