package com.tencent.mm.plugin.talkroom.b;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.agn;
import com.tencent.mm.protocal.c.ago;
import com.tencent.mm.protocal.c.bnh;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

public final class c extends f {
    private final b gJQ;
    private e gJT;
    private final String nUx;
    public int sbS;
    private int sceneType = 0;
    public LinkedList<bnh> sco;

    public c(int i, long j, String str, int i2) {
        this.sceneType = i2;
        a aVar = new a();
        aVar.hmj = new agn();
        aVar.hmk = new ago();
        aVar.uri = "/cgi-bin/micromsg-bin/gettalkroommember";
        aVar.hmi = 336;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        agn com_tencent_mm_protocal_c_agn = (agn) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_agn.wbh = i;
        com_tencent_mm_protocal_c_agn.wbi = j;
        this.nUx = str;
        com_tencent_mm_protocal_c_agn.rYW = i2;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.d("MicroMsg.NetSceneGetTalkRoomMember", "doScene");
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final int getType() {
        return 336;
    }

    public final String bEY() {
        return this.nUx;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGetTalkRoomMember", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        if (i2 == 0 && i3 == 0) {
            ago com_tencent_mm_protocal_c_ago = (ago) this.gJQ.hmh.hmo;
            x.i("MicroMsg.NetSceneGetTalkRoomMember", "resp %s", new Object[]{com_tencent_mm_protocal_c_ago.toString()});
            this.sbS = com_tencent_mm_protocal_c_ago.wbj;
            this.sco = aj(com_tencent_mm_protocal_c_ago.vGF);
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

    public final int bEZ() {
        return this.sceneType;
    }
}
