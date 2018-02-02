package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bei;
import com.tencent.mm.protocal.c.bej;
import com.tencent.mm.sdk.platformtools.x;

public final class t extends k implements com.tencent.mm.network.k {
    private b gJQ = null;
    private e gJT = null;

    public t(String str, String str2, String str3) {
        a aVar = new a();
        aVar.hmj = new bei();
        aVar.hmk = new bej();
        aVar.uri = "/cgi-bin/mmoc-bin/hardware/searchbleharddevice";
        aVar.hmi = 1706;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        bei com_tencent_mm_protocal_c_bei = (bei) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_bei.mac = str;
        if (str2 == null) {
            str2 = "";
        }
        com_tencent_mm_protocal_c_bei.userName = str2;
        if (str3 == null) {
            str3 = "";
        }
        com_tencent_mm_protocal_c_bei.category = str3;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.exdevice.NetSceneSearchBLEHardDevice", "onGYNetEnd netId = " + i + " errType = " + i2 + " errCode = " + i3 + str);
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1706;
    }

    public final bej aEg() {
        return (bej) this.gJQ.hmh.hmo;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
