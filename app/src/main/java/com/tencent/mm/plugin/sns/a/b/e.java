package com.tencent.mm.plugin.sns.a.b;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ann;
import com.tencent.mm.protocal.c.ano;
import com.tencent.mm.protocal.c.bi;
import com.tencent.mm.protocal.c.bj;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public final class e extends k implements com.tencent.mm.network.k {
    private b gJQ;
    public com.tencent.mm.ae.e gJT;
    public List<ano> jNH;

    public e(List<ano> list) {
        int i = 0;
        a aVar = new a();
        this.jNH = list;
        aVar.hmj = new bi();
        aVar.hmk = new bj();
        aVar.uri = "/cgi-bin/mmux-bin/adlog";
        aVar.hmi = 1802;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        bi biVar = (bi) this.gJQ.hmg.hmo;
        ann com_tencent_mm_protocal_c_ann = new ann();
        com_tencent_mm_protocal_c_ann.vOf = d.vAt;
        com_tencent_mm_protocal_c_ann.vOg = d.vAs;
        com_tencent_mm_protocal_c_ann.vOh = d.vAv;
        com_tencent_mm_protocal_c_ann.vOi = d.vAw;
        com_tencent_mm_protocal_c_ann.vOj = w.cfi();
        com_tencent_mm_protocal_c_ann.wuB = (int) (System.currentTimeMillis() / 1000);
        biVar.vGB = com_tencent_mm_protocal_c_ann;
        while (i < list.size()) {
            biVar.vGC.add(list.get(i));
            i++;
        }
        x.i("MicroMsg.NetSceneAdLog", "report count: " + biVar.vGC.size());
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ae.e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final int getType() {
        return 1802;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneAdLog", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (i2 == 0 && i3 == 0) {
            int i4 = ((bj) ((b) qVar).hmh.hmo).vGD;
            g.Dk();
            g.Dj().CU().a(com.tencent.mm.storage.w.a.xoY, Integer.valueOf(i4));
        }
        this.gJT.a(i2, i3, str, this);
    }
}
