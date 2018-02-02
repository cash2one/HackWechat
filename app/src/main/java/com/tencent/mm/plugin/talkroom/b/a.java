package com.tencent.mm.plugin.talkroom.b;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bng;
import com.tencent.mm.protocal.c.bnh;
import com.tencent.mm.protocal.c.ss;
import com.tencent.mm.protocal.c.st;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

public final class a extends f {
    private final b gJQ;
    private e gJT;
    public int nDx;
    public long nDy;
    private final String nUx;
    public int sbS;
    public int sbT;
    public LinkedList<bng> sbV;
    private int sceneType = 0;
    public LinkedList<bnh> sco;

    public a(String str, int i) {
        com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
        this.sceneType = i;
        aVar.hmj = new ss();
        aVar.hmk = new st();
        aVar.uri = "/cgi-bin/micromsg-bin/entertalkroom";
        aVar.hmi = 332;
        aVar.hml = 147;
        aVar.hmm = 1000000147;
        this.gJQ = aVar.JZ();
        ((ss) this.gJQ.hmg.hmo).wbg = str;
        ((ss) this.gJQ.hmg.hmo).rYW = i;
        this.nUx = str;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.d("MicroMsg.NetSceneEnterTalkRoom", "doScene %d", new Object[]{Integer.valueOf(this.sceneType)});
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final int getType() {
        return 332;
    }

    public final String bEY() {
        return this.nUx;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneEnterTalkRoom", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        if (i2 == 0 && i3 == 0) {
            st stVar = (st) this.gJQ.hmh.hmo;
            x.i("MicroMsg.NetSceneEnterTalkRoom", "resp %s", new Object[]{stVar.toString()});
            this.nDx = stVar.wbh;
            this.nDy = stVar.wbi;
            this.sbS = stVar.wbj;
            this.sbT = stVar.wbl;
            this.sco = aj(stVar.vGF);
            this.sbV = ak(stVar.vJP);
            this.gJT.a(i2, i3, str, this);
            return;
        }
        this.gJT.a(i2, i3, str, this);
    }

    private static LinkedList<bnh> aj(LinkedList<bnh> linkedList) {
        LinkedList<bnh> linkedList2 = new LinkedList();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            bnh com_tencent_mm_protocal_c_bnh = (bnh) it.next();
            if (!bh.ov(com_tencent_mm_protocal_c_bnh.ksU)) {
                linkedList2.add(com_tencent_mm_protocal_c_bnh);
            }
        }
        return linkedList2;
    }

    private static LinkedList<bng> ak(LinkedList<bng> linkedList) {
        LinkedList<bng> linkedList2 = new LinkedList();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            linkedList2.add((bng) it.next());
        }
        return linkedList2;
    }

    public final int bEZ() {
        return this.sceneType;
    }
}
