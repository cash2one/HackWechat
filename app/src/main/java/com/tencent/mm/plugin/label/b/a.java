package com.tencent.mm.plugin.label.b;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.c;
import com.tencent.mm.protocal.c.anu;
import com.tencent.mm.protocal.c.bn;
import com.tencent.mm.protocal.c.bo;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class a extends k implements com.tencent.mm.network.k {
    private final b gJQ;
    private e gJT;
    private LinkedList<anu> nOD = new LinkedList();

    public a(String str) {
        com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
        aVar.hmj = new bn();
        aVar.hmk = new bo();
        aVar.uri = "/cgi-bin/micromsg-bin/addcontactlabel";
        aVar.hmi = 635;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        if (!bh.ov(str)) {
            anu com_tencent_mm_protocal_c_anu = new anu();
            com_tencent_mm_protocal_c_anu.wuH = str;
            this.nOD.add(com_tencent_mm_protocal_c_anu);
        }
    }

    public a(List<String> list) {
        com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
        aVar.hmj = new bn();
        aVar.hmk = new bo();
        aVar.uri = "/cgi-bin/micromsg-bin/addcontactlabel";
        aVar.hmi = 635;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        if (list != null && list.size() > 0) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                anu com_tencent_mm_protocal_c_anu = new anu();
                com_tencent_mm_protocal_c_anu.wuH = (String) list.get(i);
                this.nOD.add(com_tencent_mm_protocal_c_anu);
            }
        }
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.d("MicroMsg.Label.NetSceneAddContactLabel", "cpan[doScene].");
        this.gJT = eVar2;
        bn bnVar = (bn) this.gJQ.hmg.hmo;
        if (this.nOD == null || this.nOD.size() <= 0) {
            x.e("MicroMsg.Label.NetSceneAddContactLabel", "cpan[doScene] label list is null.");
            eVar2.a(3, -1, "[doScene]empty contact list.", this);
            return 0;
        }
        bnVar.vGK = this.nOD;
        bnVar.vGJ = this.nOD.size();
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.Label.NetSceneAddContactLabel", "cpan[onGYNetEnd] netId:%d errType:%d errCode:%d errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        bo aUY = aUY();
        if (aUY != null) {
            LinkedList linkedList = aUY.vGK;
            List arrayList = new ArrayList();
            int size = linkedList.size();
            for (int i4 = 0; i4 < size; i4++) {
                anu com_tencent_mm_protocal_c_anu = (anu) linkedList.get(i4);
                z zVar = new z();
                zVar.field_labelID = com_tencent_mm_protocal_c_anu.wuI;
                zVar.field_labelName = com_tencent_mm_protocal_c_anu.wuH;
                zVar.field_labelPYFull = c.ol(com_tencent_mm_protocal_c_anu.wuH);
                zVar.field_labelPYShort = c.om(com_tencent_mm_protocal_c_anu.wuH);
                zVar.field_isTemporary = false;
                arrayList.add(zVar);
            }
            com.tencent.mm.plugin.label.e.aUW().cE(arrayList);
            com.tencent.mm.plugin.label.e.aUW().cF(arrayList);
        }
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 635;
    }

    public final bo aUY() {
        return (bo) this.gJQ.hmh.hmo;
    }
}
