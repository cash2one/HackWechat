package com.tencent.mm.plugin.card.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.auy;
import com.tencent.mm.protocal.c.bcj;
import com.tencent.mm.protocal.c.bck;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

public final class ah extends k implements com.tencent.mm.network.k {
    private final b gJQ;
    private e gJT;

    public ah(LinkedList<auy> linkedList) {
        a aVar = new a();
        aVar.hmj = new bcj();
        aVar.hmk = new bck();
        aVar.uri = "/cgi-bin/micromsg-bin/reportdynamiccardcodeaction";
        aVar.hmi = 1275;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        ((bcj) this.gJQ.hmg.hmo).wIB = linkedList;
        if (linkedList != null) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                auy com_tencent_mm_protocal_c_auy = (auy) it.next();
                x.d("MicroMsg.NetSceneReportDynamicCardCodeAction", "ReportDynamicCardCodeActionReq operate card_id=%s,code_id=%s,operate_timestamp=%d,operate_type=%d", new Object[]{com_tencent_mm_protocal_c_auy.fGU, com_tencent_mm_protocal_c_auy.kLC, Integer.valueOf(com_tencent_mm_protocal_c_auy.wCK), Integer.valueOf(com_tencent_mm_protocal_c_auy.wCL)});
            }
        }
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneReportDynamicCardCodeAction", "onGYNetEnd, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1275;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
