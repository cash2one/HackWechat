package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiDestroyInstanceAudio;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.protocal.c.bkp;
import com.tencent.mm.protocal.c.bku;
import com.tencent.mm.protocal.c.bkv;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class w extends k implements com.tencent.mm.network.k {
    private int fut;
    private b gJQ;
    public e gJT;
    private long qUC = 0;

    public w(long j, String str) {
        x.d("MicroMsg.NetSceneSnsTagOption", "opcode 3" + " snsTagId " + j + " tagName " + str);
        this.qUC = j;
        this.fut = 3;
        a aVar = new a();
        aVar.hmj = new bku();
        aVar.hmk = new bkv();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnstagoption";
        aVar.hmi = JsApiDestroyInstanceAudio.CTRL_INDEX;
        aVar.hml = 114;
        aVar.hmm = 1000000114;
        this.gJQ = aVar.JZ();
        bku com_tencent_mm_protocal_c_bku = (bku) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_bku.vDW = 3;
        com_tencent_mm_protocal_c_bku.wOd = j;
        com_tencent_mm_protocal_c_bku.niX = str;
    }

    public final int getType() {
        return JsApiDestroyInstanceAudio.CTRL_INDEX;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneSnsTagOption", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (i2 == 0 && i3 == 0) {
            bkp com_tencent_mm_protocal_c_bkp = ((bkv) ((b) qVar).hmh.hmo).wOf;
            x.d("MicroMsg.NetSceneSnsTagOption", com_tencent_mm_protocal_c_bkp.toString());
            switch (this.fut) {
                case 1:
                case 2:
                    s eT = ae.bvB().eT(com_tencent_mm_protocal_c_bkp.wOd);
                    eT.field_tagId = com_tencent_mm_protocal_c_bkp.wOd;
                    eT.field_tagName = bh.az(com_tencent_mm_protocal_c_bkp.niX, "");
                    eT.field_count = com_tencent_mm_protocal_c_bkp.ksO;
                    eT.bS(com_tencent_mm_protocal_c_bkp.ksP);
                    ae.bvB().a(eT);
                    break;
                case 3:
                    x.d("MicroMsg.NetSceneSnsTagOption", "MM_SNS_TAG_DEL " + ae.bvB().eU(this.qUC));
                    break;
            }
            this.gJT.a(i2, i3, str, this);
            return;
        }
        this.gJT.a(i2, i3, str, this);
    }
}
