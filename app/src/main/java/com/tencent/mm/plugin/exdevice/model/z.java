package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.acs;
import com.tencent.mm.protocal.c.act;
import com.tencent.mm.protocal.c.acu;
import com.tencent.mm.protocal.c.acv;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class z extends k implements com.tencent.mm.network.k {
    private e gOB = null;
    b lMW = null;
    private String lNi = "";

    public z(LinkedList<act> linkedList, String str, String str2) {
        this.lNi = str2;
        a aVar = new a();
        aVar.hmj = new acu();
        aVar.hmk = new acv();
        aVar.uri = "/cgi-bin/micromsg-bin/getharddeviceoperticket";
        aVar.hmi = 543;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.lMW = aVar.JZ();
        acu com_tencent_mm_protocal_c_acu = (acu) this.lMW.hmg.hmo;
        if (!bh.ov(str)) {
            acs com_tencent_mm_protocal_c_acs = new acs();
            com_tencent_mm_protocal_c_acs.vLr = str;
            com_tencent_mm_protocal_c_acu.wls = com_tencent_mm_protocal_c_acs;
        }
        com_tencent_mm_protocal_c_acu.wlr = linkedList;
    }

    public final int getType() {
        return 543;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gOB = eVar2;
        return a(eVar, this.lMW, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.exdevice.NetsceneGetHardDeviceOperTicket", "GetHardDeviceOperTicket onGYNetEnd netId = %s, errType = %s, errCode = %s, errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (this.gOB != null) {
            this.gOB.a(i2, i3, str, this);
        }
    }
}
