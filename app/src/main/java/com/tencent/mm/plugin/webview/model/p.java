package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ali;
import com.tencent.mm.protocal.c.ana;
import com.tencent.mm.protocal.c.anb;
import com.tencent.mm.protocal.c.ann;
import com.tencent.mm.protocal.c.ano;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.List;

public final class p extends k implements com.tencent.mm.network.k {
    private final b gJQ;
    private e gJT;

    public p(List<ano> list) {
        a aVar = new a();
        aVar.hmj = new ana();
        aVar.hmk = new anb();
        aVar.uri = "/cgi-bin/mmux-bin/jslog";
        aVar.hmi = 1803;
        this.gJQ = aVar.JZ();
        ana com_tencent_mm_protocal_c_ana = (ana) this.gJQ.hmg.hmo;
        ann com_tencent_mm_protocal_c_ann = new ann();
        com_tencent_mm_protocal_c_ann.vOf = d.vAt;
        com_tencent_mm_protocal_c_ann.vOg = d.vAs;
        com_tencent_mm_protocal_c_ann.vOh = d.vAv;
        com_tencent_mm_protocal_c_ann.vOi = d.vAw;
        com_tencent_mm_protocal_c_ann.vOj = w.cfi();
        com_tencent_mm_protocal_c_ann.wuB = (int) (System.currentTimeMillis() / 1000);
        com_tencent_mm_protocal_c_ana.vGB = com_tencent_mm_protocal_c_ann;
        com_tencent_mm_protocal_c_ana.vGC.addAll(list);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneJsLog", "onGYNetEnd, netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (i2 == 0 && i3 == 0) {
            anb com_tencent_mm_protocal_c_anb = (anb) ((b) qVar).hmh.hmo;
            x.i("MicroMsg.NetSceneJsLog", "received InvalidLogList: ");
            StringBuilder stringBuilder = new StringBuilder("{ ");
            if (bh.cA(com_tencent_mm_protocal_c_anb.wun)) {
                stringBuilder.append("{  }");
            } else {
                Iterator it = com_tencent_mm_protocal_c_anb.wun.iterator();
                while (it.hasNext()) {
                    ali com_tencent_mm_protocal_c_ali = (ali) it.next();
                    stringBuilder.append(String.format(" { logId(%d), interval(%d) },", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_ali.wsx), Integer.valueOf(com_tencent_mm_protocal_c_ali.wsy)}));
                }
            }
            stringBuilder.append(" }");
            x.i("MicroMsg.NetSceneJsLog", stringBuilder.toString());
            e.a.bQA();
            e.co(com_tencent_mm_protocal_c_anb.wun);
        }
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1803;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        x.d("MicroMsg.NetSceneJsLog", "doScene");
        return a(eVar, this.gJQ, this);
    }
}
