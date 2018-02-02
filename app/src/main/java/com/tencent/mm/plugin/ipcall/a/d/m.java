package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bgl;
import com.tencent.mm.protocal.c.bgm;
import com.tencent.mm.protocal.c.bwm;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class m extends k implements com.tencent.mm.network.k {
    private b gJQ = null;
    private e gJT;
    private bgl nFN = null;
    public bgm nFO = null;

    public m(int i, int i2, LinkedList<bwm> linkedList) {
        a aVar = new a();
        aVar.hmj = new bgl();
        aVar.hmk = new bgm();
        aVar.hmi = 871;
        aVar.uri = "/cgi-bin/micromsg-bin/sendwcofeedback";
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        this.nFN = (bgl) this.gJQ.hmg.hmo;
        this.nFN.wze = i2;
        this.nFN.wKQ = linkedList;
        this.nFN.wKP = linkedList.size();
        this.nFN.wKR = i;
        x.i("MicroMsg.NetSceneIPCallSendFeedback", "NetSceneIPCallSendFeedback roomid=%d, level=%d, feedbackCount=%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(linkedList.size())});
    }

    public final int getType() {
        return 871;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneIPCallSendFeedback", "onGYNetEnd, errType: %d, errCode: %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.nFO = (bgm) ((b) qVar).hmh.hmo;
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }
}
