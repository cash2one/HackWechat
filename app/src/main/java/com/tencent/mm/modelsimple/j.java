package com.tencent.mm.modelsimple;

import com.tencent.mm.a.n;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.o.a;
import com.tencent.mm.protocal.o.b;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;
import junit.framework.Assert;

public final class j extends k implements com.tencent.mm.network.k {
    public byte[] content;
    private e gJT;
    public String hMK = "";
    private q hnp;

    public j(List<String> list, byte[] bArr) {
        boolean z = true;
        boolean z2 = list.size() > 0 && bArr != null;
        Assert.assertTrue(z2);
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        String str = (String) list.get(0);
        for (int i = 1; i < list.size(); i++) {
            str = str + "," + ((String) list.get(i)).trim();
        }
        this.hnp = new a();
        a aVar = (a) this.hnp.Kb();
        aVar.fuL = 111;
        aVar.fDt = 0;
        aVar.hOH = currentTimeMillis;
        Assert.assertTrue(str != null);
        aVar.vBA = str;
        if (bArr == null) {
            z = false;
        }
        Assert.assertTrue(z);
        aVar.vBB = bArr;
        x.d("MicroMsg.NetSceneDirectSend", "NetSceneDirectSend: cmdId=111" + " seq=" + currentTimeMillis);
        x.d("MicroMsg.NetSceneDirectSend", "NetSceneDirectSend: lstReceiver=" + str + " status = " + n.p(bArr, 0));
    }

    public j(com.tencent.mm.protocal.k.e eVar) {
        b bVar = (b) eVar;
        this.hMK = bVar.hMK;
        this.content = bVar.content;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.hnp, this);
    }

    public final int getType() {
        return 10;
    }

    public final boolean Kd() {
        return true;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        this.gJT.a(i2, i3, str, this);
    }
}
