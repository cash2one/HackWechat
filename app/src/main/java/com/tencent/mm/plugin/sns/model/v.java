package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiCreateAudioInstance;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.protocal.c.bkp;
import com.tencent.mm.protocal.c.bks;
import com.tencent.mm.protocal.c.bkt;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;

public final class v extends k implements com.tencent.mm.network.k {
    private int fut;
    private b gJQ;
    public e gJT;
    private long qUB;
    private int scene = 0;

    public v(int i, long j, String str, int i2, List<String> list, int i3) {
        x.d("MicroMsg.NetSceneSnsTagMemberOption", "opCode " + i + " tagName " + str + " memberList " + list.size() + " scene " + i3);
        this.fut = i;
        this.qUB = j;
        this.scene = i3;
        a aVar = new a();
        aVar.hmj = new bks();
        aVar.hmk = new bkt();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnstagmemberoption";
        aVar.hmi = JsApiCreateAudioInstance.CTRL_INDEX;
        aVar.hml = 115;
        aVar.hmm = 1000000115;
        this.gJQ = aVar.JZ();
        bks com_tencent_mm_protocal_c_bks = (bks) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_bks.vDW = i;
        com_tencent_mm_protocal_c_bks.wOd = j;
        com_tencent_mm_protocal_c_bks.niX = str;
        com_tencent_mm_protocal_c_bks.ksO = i2;
        com_tencent_mm_protocal_c_bks.rYW = this.scene;
        LinkedList linkedList = new LinkedList();
        for (String UA : list) {
            linkedList.add(new bdo().UA(UA));
        }
        com_tencent_mm_protocal_c_bks.ksP = linkedList;
        x.d("MicroMsg.NetSceneSnsTagMemberOption", "rr.req.rImpl " + com_tencent_mm_protocal_c_bks.toString());
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final int getType() {
        return JsApiCreateAudioInstance.CTRL_INDEX;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneSnsTagMemberOption", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (i2 == 0 && i3 == 0) {
            bkp com_tencent_mm_protocal_c_bkp = ((bkt) ((b) qVar).hmh.hmo).wOf;
            x.d("MicroMsg.NetSceneSnsTagMemberOption", "Resp.rImpl " + com_tencent_mm_protocal_c_bkp.toString());
            s eT = ae.bvB().eT(com_tencent_mm_protocal_c_bkp.wOd);
            eT.field_tagId = com_tencent_mm_protocal_c_bkp.wOd;
            eT.field_tagName = bh.az(com_tencent_mm_protocal_c_bkp.niX, "");
            switch (this.fut) {
                case 1:
                case 2:
                case 3:
                    eT.field_count = com_tencent_mm_protocal_c_bkp.ksO;
                    eT.bS(com_tencent_mm_protocal_c_bkp.ksP);
                    break;
            }
            ae.bvB().a(eT);
            this.gJT.a(i2, i3, str, this);
            return;
        }
        this.gJT.a(i2, i3, str, this);
    }
}
