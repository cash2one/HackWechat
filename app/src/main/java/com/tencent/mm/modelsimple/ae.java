package com.tencent.mm.modelsimple;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bfv;
import com.tencent.mm.protocal.c.bfw;
import java.util.LinkedList;

public final class ae extends k implements com.tencent.mm.network.k {
    private final b gJQ;
    private e gJT;

    public ae(int[] iArr) {
        a aVar = new a();
        aVar.hmj = new bfv();
        aVar.hmk = new bfw();
        aVar.uri = "/cgi-bin/micromsg-bin/sendinviteemail";
        aVar.hmi = 116;
        aVar.hml = 41;
        aVar.hmm = 1000000041;
        this.gJQ = aVar.JZ();
        LinkedList linkedList = new LinkedList();
        for (int valueOf : iArr) {
            linkedList.add(Integer.valueOf(valueOf));
        }
        ((bfv) this.gJQ.hmg.hmo).wKF = linkedList;
        ((bfv) this.gJQ.hmg.hmo).wKE = linkedList.size();
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final int getType() {
        return 116;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        this.gJT.a(i2, i3, str, this);
    }
}
