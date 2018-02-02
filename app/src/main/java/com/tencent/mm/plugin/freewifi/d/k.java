package com.tencent.mm.plugin.freewifi.d;

import com.tencent.mm.ae.b.a;
import com.tencent.mm.protocal.c.bdx;
import com.tencent.mm.protocal.c.co;
import com.tencent.mm.protocal.c.if;
import com.tencent.mm.protocal.c.ig;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class k extends c {
    protected final void aLV() {
        a aVar = new a();
        aVar.hmj = new if();
        aVar.hmk = new ig();
        aVar.uri = "/cgi-bin/mmo2o-bin/bizwificonnect";
        aVar.hmi = 1705;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
    }

    public final int getType() {
        return 1705;
    }

    public k(String str, bdx com_tencent_mm_protocal_c_bdx, int i, String str2) {
        aLV();
        if (!(8 == i && 9 == i)) {
            x.e("MicroMsg.FreeWifi.NetSceneScanAndReportNearFieldFreeWifi", "invalid channel, channel is :%d", new Object[]{Integer.valueOf(i)});
        }
        if ifVar = (if) this.gJQ.hmg.hmo;
        ifVar.vNg = str;
        ifVar.vOr = com_tencent_mm_protocal_c_bdx;
        ifVar.vDY = i;
        ifVar.vDZ = str2;
    }

    public final String aMj() {
        LinkedList linkedList = ((ig) this.gJQ.hmh.hmo).vOs;
        if (linkedList == null || linkedList.size() != 1) {
            return null;
        }
        return ((co) linkedList.get(0)).vHC;
    }
}
