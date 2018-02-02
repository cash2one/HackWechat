package com.tencent.mm.plugin.freewifi.model;

import com.tencent.mm.ae.d;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.freewifi.i;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.e.1;
import com.tencent.mm.protocal.c.bw;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.bs.a;

class j$4 implements a {
    final /* synthetic */ j mEM;

    j$4(j jVar) {
        this.mEM = jVar;
    }

    public final void a(d.a aVar) {
        e aLU = j.aLU();
        bw bwVar = aVar.hmq;
        if (1 != i.a.aLd().getInt("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_RECV_FREEWIFI_SYSMSG", 0)) {
            i.a.aLd().bm("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_RECV_FREEWIFI_SYSMSG", 1);
        }
        if (bwVar == null || bwVar.vGZ == null) {
            x.e("MicroMsg.FreeWifi.FreeWifiMessageService", "cmdAddMsg is null");
            return;
        }
        String a = n.a(bwVar.vGZ);
        x.i("MicroMsg.FreeWifi.FreeWifiMessageService", "freewifi push message cmdAM.NewMsgId=%d, msgContent=%s", Long.valueOf(bwVar.vHe), a);
        if (m.AA(a)) {
            x.e("MicroMsg.FreeWifi.FreeWifiMessageService", "msgContent is empty. return.");
            return;
        }
        com.tencent.mm.plugin.freewifi.c.a AH = com.tencent.mm.plugin.freewifi.c.a.AH(a);
        if (AH == null) {
            x.e("MicroMsg.FreeWifi.FreeWifiMessageService", "parse schemaMsg failed. return.");
            return;
        }
        new com.tencent.mm.plugin.freewifi.d.d(m.AD("MicroMsg.FreeWifi.FreeWifiMessageService"), m.AE("MicroMsg.FreeWifi.FreeWifiMessageService"), m.AF("MicroMsg.FreeWifi.FreeWifiMessageService"), AH.mDQ, AH.mDN, AH.mDR, AH.ssid, AH.bssid).b(new 1(aLU, bwVar));
    }
}
