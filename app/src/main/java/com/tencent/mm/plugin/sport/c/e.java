package com.tencent.mm.plugin.sport.c;

import android.os.Build;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bxt;
import com.tencent.mm.protocal.c.bxu;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.be;

public final class e extends k implements com.tencent.mm.network.k {
    private com.tencent.mm.ae.e gJT;
    private b hFi;
    bxu rTS;

    public e() {
        a aVar = new a();
        aVar.hmi = 1947;
        aVar.uri = "/cgi-bin/mmoc-bin/hardware/getwxsportconfig";
        aVar.hmj = new bxt();
        aVar.hmk = new bxu();
        this.hFi = aVar.JZ();
        bxt com_tencent_mm_protocal_c_bxt = (bxt) this.hFi.hmg.hmo;
        com_tencent_mm_protocal_c_bxt.ksY = d.vAx;
        com_tencent_mm_protocal_c_bxt.vJA = be.cjW();
        com_tencent_mm_protocal_c_bxt.vOg = Build.BRAND;
        com_tencent_mm_protocal_c_bxt.vOf = Build.MODEL;
        com_tencent_mm_protocal_c_bxt.wYt = d.vAu;
        com_tencent_mm_protocal_c_bxt.vOh = d.vAv;
        com_tencent_mm_protocal_c_bxt.vOi = d.vAw;
        com_tencent_mm_protocal_c_bxt.wYu = "0x26060235";
        com_tencent_mm_protocal_c_bxt.wYv = Build.MANUFACTURER;
        x.i("MicroMsg.Sport.NetSceneGetWeSportConfig", "request params=[%s, %s, %s, %s, %s, %s, %s, %s, %s]", new Object[]{com_tencent_mm_protocal_c_bxt.vJA, com_tencent_mm_protocal_c_bxt.vOg, com_tencent_mm_protocal_c_bxt.vOf, com_tencent_mm_protocal_c_bxt.ksY, com_tencent_mm_protocal_c_bxt.vOi, com_tencent_mm_protocal_c_bxt.vOh, com_tencent_mm_protocal_c_bxt.vOi, com_tencent_mm_protocal_c_bxt.wYu, com_tencent_mm_protocal_c_bxt.wYv});
    }

    public final int getType() {
        return 1947;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ae.e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.hFi, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.Sport.NetSceneGetWeSportConfig", "onGYNetEnd %d %d %d %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            this.rTS = (bxu) this.hFi.hmh.hmo;
            this.gJT.a(i2, i3, str, this);
            return;
        }
        this.gJT.a(i2, i3, str, this);
    }
}
