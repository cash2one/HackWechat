package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.mt;
import com.tencent.mm.protocal.c.mu;
import com.tencent.mm.protocal.c.pd;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class l extends k implements com.tencent.mm.network.k {
    b gJQ;
    private e gJT;
    private ArrayList<Long> poT;

    public l(ArrayList<Long> arrayList) {
        this.poT = arrayList;
        a aVar = new a();
        aVar.hmj = new mt();
        aVar.hmk = new mu();
        aVar.uri = "/cgi-bin/micromsg-bin/checkconversationfile";
        aVar.hmi = 483;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneCheckConversationFile", "onGYNetEnd, netId: %d, errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if ((i2 != 0 || i3 != 0) && this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        } else if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 483;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        mt mtVar = (mt) this.gJQ.hmg.hmo;
        mtVar.ksO = this.poT.size();
        LinkedList linkedList = new LinkedList();
        Iterator it = this.poT.iterator();
        while (it.hasNext()) {
            long longValue = ((Long) it.next()).longValue();
            pd pdVar = new pd();
            pdVar.vHe = longValue;
            linkedList.add(pdVar);
            x.i("MicroMsg.NetSceneCheckConversationFile", "MsgId: %d", new Object[]{Long.valueOf(longValue)});
        }
        mtVar.vVw = linkedList;
        x.i("MicroMsg.NetSceneCheckConversationFile", "Count = %d, MsgInfoList.size = %d", new Object[]{Integer.valueOf(mtVar.ksO), Integer.valueOf(mtVar.vVw.size())});
        return a(eVar, this.gJQ, this);
    }
}
