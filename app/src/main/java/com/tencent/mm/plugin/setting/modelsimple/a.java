package com.tencent.mm.plugin.setting.modelsimple;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bor;
import com.tencent.mm.protocal.c.by;
import com.tencent.mm.protocal.c.bz;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class a extends k implements com.tencent.mm.network.k {
    private e gJT;
    private List<String> maE;

    public a(List<String> list) {
        this.maE = list;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        this.hmC = i;
        if (!(i2 == 0 && i3 == 0)) {
            x.e("MicroMsg.NetSceneGetTrustedFriends", "errType:%d, errCode:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        }
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 583;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
        com.tencent.mm.bq.a byVar = new by();
        Collection arrayList = new ArrayList();
        if (this.maE != null) {
            for (int i = 0; i < this.maE.size(); i++) {
                bor com_tencent_mm_protocal_c_bor = new bor();
                com_tencent_mm_protocal_c_bor.ksU = (String) this.maE.get(i);
                arrayList.add(com_tencent_mm_protocal_c_bor);
            }
        }
        byVar.vHk.addAll(arrayList);
        aVar.hmj = byVar;
        aVar.hmk = new bz();
        aVar.uri = "/cgi-bin/micromsg-bin/addtrustedfriends";
        aVar.hmi = 583;
        aVar.hml = 0;
        aVar.hml = 0;
        return a(eVar, aVar.JZ(), this);
    }
}
