package com.tencent.mm.bg.b;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiOpenWeRunSetting;
import com.tencent.mm.protocal.c.bcr;
import com.tencent.mm.protocal.c.bcs;
import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class a extends k implements com.tencent.mm.network.k {
    private b gJQ;
    private e gJT;

    public a(int i, LinkedList<bdo> linkedList, bdo com_tencent_mm_protocal_c_bdo, bdo com_tencent_mm_protocal_c_bdo2) {
        com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
        aVar.hmj = new bcr();
        aVar.hmk = new bcs();
        aVar.uri = "/cgi-bin/micromsg-bin/reportvoiceresult";
        aVar.hmi = JsApiOpenWeRunSetting.CTRL_INDEX;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        bcr com_tencent_mm_protocal_c_bcr = (bcr) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_bcr.wIP = i;
        com_tencent_mm_protocal_c_bcr.wIQ = linkedList;
        com_tencent_mm_protocal_c_bcr.wIR = com_tencent_mm_protocal_c_bdo;
        com_tencent_mm_protocal_c_bcr.wIS = com_tencent_mm_protocal_c_bdo2;
    }

    public final int getType() {
        return JsApiOpenWeRunSetting.CTRL_INDEX;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneNewVoiceInputReport", "onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " errMsg:" + str);
        this.gJT.a(i2, i3, str, this);
    }
}
