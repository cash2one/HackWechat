package com.tencent.mm.plugin.chatroom.d;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ajj;
import com.tencent.mm.protocal.c.oo;
import com.tencent.mm.protocal.c.op;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.m;
import java.util.Iterator;
import java.util.LinkedList;

public final class e extends k implements com.tencent.mm.network.k {
    private LinkedList<ajj> fAI;
    private final b gJQ;
    private com.tencent.mm.ae.e gJT;

    public e(LinkedList<ajj> linkedList) {
        this.fAI = linkedList;
        a aVar = new a();
        aVar.hmj = new oo();
        aVar.hmk = new op();
        aVar.uri = "/cgi-bin/micromsg-bin/collectchatroom";
        aVar.hmi = 181;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        oo ooVar = (oo) this.gJQ.hmg.hmo;
        ooVar.vXv = linkedList;
        ooVar.vXu = linkedList.size();
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ae.e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final int getType() {
        return 181;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneCollectChatRoom", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (qVar.Hp().vBp != 0) {
            this.gJT.a(i2, i3, str, this);
            return;
        }
        if (this.fAI != null) {
            Iterator it = this.fAI.iterator();
            while (it.hasNext()) {
                ajj com_tencent_mm_protocal_c_ajj = (ajj) it.next();
                x.d("MicroMsg.NetSceneCollectChatRoom", "del groupcard Name :" + com_tencent_mm_protocal_c_ajj.wqG);
                m.gg(com_tencent_mm_protocal_c_ajj.wqG);
            }
        }
        this.gJT.a(i2, i3, str, this);
    }
}
