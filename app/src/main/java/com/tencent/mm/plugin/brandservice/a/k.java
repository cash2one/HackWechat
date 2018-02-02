package com.tencent.mm.plugin.brandservice.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ah;
import com.tencent.mm.protocal.c.bgt;
import com.tencent.mm.protocal.c.bgu;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;

public final class k extends com.tencent.mm.ae.k implements com.tencent.mm.network.k {
    private final b gJQ;
    private e gJT;

    public k(List<b> list) {
        a aVar = new a();
        aVar.hmj = new bgt();
        aVar.hmk = new bgu();
        aVar.uri = "/cgi-bin/micromsg-bin/setapplist";
        aVar.hmi = 386;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        bgt com_tencent_mm_protocal_c_bgt = (bgt) this.gJQ.hmg.hmo;
        LinkedList linkedList = new LinkedList();
        for (b bVar : list) {
            ah ahVar = new ah();
            ahVar.ksU = bVar.userName;
            linkedList.add(ahVar);
        }
        com_tencent_mm_protocal_c_bgt.ksO = linkedList.size();
        com_tencent_mm_protocal_c_bgt.ksP = linkedList;
        x.i("MicroMsg.BrandService.NetSceneSetAppList", "info: upload size %d, toString %s", new Object[]{Integer.valueOf(linkedList.size()), linkedList.toString()});
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.BrandService.NetSceneSetAppList", "on scene end code(%d, %d)", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            x.i("MicroMsg.BrandService.NetSceneSetAppList", "ok, hash code is %d", new Object[]{Integer.valueOf(((bgu) this.gJQ.hmh.hmo).wif)});
            com.tencent.mm.plugin.brandservice.a.f(196610, Integer.valueOf(r0.wif));
            com.tencent.mm.plugin.brandservice.a.f(196611, Boolean.valueOf(false));
        } else {
            com.tencent.mm.plugin.brandservice.a.f(196611, Boolean.valueOf(true));
        }
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 386;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        x.i("MicroMsg.BrandService.NetSceneSetAppList", "do scene");
        return a(eVar, this.gJQ, this);
    }
}
