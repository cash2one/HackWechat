package com.tencent.mm.plugin.wenote.model;

import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.vc;
import com.tencent.mm.protocal.c.vi;
import com.tencent.mm.protocal.c.vj;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class b extends k implements com.tencent.mm.network.k {
    private final com.tencent.mm.ae.b gJQ;
    private e gJT = null;
    public int tQf = 1;
    private String tQg = "";
    private vc tQh = null;
    private LinkedList<vc> tQi = new LinkedList();
    public int tQj = 0;

    public b(int i, int i2, String str, LinkedList<vc> linkedList, vc vcVar) {
        this.tQi = linkedList;
        this.tQh = vcVar;
        this.tQg = str;
        this.tQf = i2;
        this.tQj = i;
        a aVar = new a();
        aVar.hmj = new vi();
        aVar.hmk = new vj();
        aVar.uri = "/cgi-bin/micromsg-bin/favsecurity ";
        aVar.hmi = 921;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        vi viVar = (vi) this.gJQ.hmg.hmo;
        viVar.nhx = this.tQf;
        viVar.wfa = this.tQh;
        viVar.weZ = this.tQi;
        viVar.weY = this.tQg;
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneCheckNoteSecurity", "netId %d errType %d errCode %d errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        vj vjVar = (vj) ((com.tencent.mm.ae.b) qVar).hmh.hmo;
        if (i2 != 0) {
            x.i("MicroMsg.NetSceneCheckNoteSecurity", "NetSceneCheckNoteSecurity,errType:%d,fail", new Object[]{Integer.valueOf(i2)});
            this.gJT.a(i2, -1, str, this);
        } else if (vjVar == null || vjVar.wJr == null) {
            x.i("MicroMsg.NetSceneCheckNoteSecurity", "NetSceneCheckNoteSecurity,response == null,ok");
            this.gJT.a(i2, 0, str, this);
        } else if (vjVar.wJr.vJU != 0) {
            x.i("MicroMsg.NetSceneCheckNoteSecurity", "NetSceneCheckNoteSecurity,baseresponse.ret != 0,ok");
            this.gJT.a(i2, 0, str, this);
        } else if (vjVar.wfb > 0) {
            x.i("MicroMsg.NetSceneCheckNoteSecurity", "NetSceneCheckNoteSecurity,SecurityResult > 0,fail");
            this.gJT.a(i2, -1, str, this);
        } else {
            x.i("MicroMsg.NetSceneCheckNoteSecurity", "NetSceneCheckNoteSecurity,SecurityResult = 0,fail");
            this.gJT.a(i2, 0, str, this);
        }
    }

    protected final int a(q qVar) {
        return com.tencent.mm.ae.k.b.hmP;
    }

    public final int getType() {
        return 921;
    }
}
