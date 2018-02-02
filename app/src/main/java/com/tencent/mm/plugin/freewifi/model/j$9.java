package com.tencent.mm.plugin.freewifi.model;

import android.net.wifi.ScanResult;
import com.tencent.mm.g.a.og;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.h.a;
import com.tencent.mm.protocal.c.bdx;
import com.tencent.mm.protocal.c.cn;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;

class j$9 extends c<og> {
    final /* synthetic */ j mEM;

    j$9(j jVar) {
        this.mEM = jVar;
        this.xen = og.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        og ogVar = (og) bVar;
        int networkType = d.getNetworkType();
        if (!(networkType == 0 || networkType == -1)) {
            x.i("MicroMsg.FreeWifi.SubCoreFreeWifi", "networkType is " + networkType + ", start to scan and report near field wifi, to get a pushed message for connecting wifi.");
            final String str = ogVar.fGf.userName;
            h.b.aLL().a(new a(this) {
                final /* synthetic */ j$9 mEO;

                public final void aQ(List<ScanResult> list) {
                    if (list != null && list.size() != 0) {
                        bdx com_tencent_mm_protocal_c_bdx = new bdx();
                        com_tencent_mm_protocal_c_bdx.wJM = new LinkedList();
                        for (ScanResult scanResult : list) {
                            if (scanResult != null) {
                                cn cnVar = new cn();
                                cnVar.mac = scanResult.BSSID;
                                cnVar.vHB = scanResult.level;
                                cnVar.ssid = scanResult.SSID;
                                com_tencent_mm_protocal_c_bdx.wJM.add(cnVar);
                            }
                        }
                        String aLi = m.aLi();
                        k.a aLe = k.aLe();
                        aLe.mCu = aLi;
                        aLe.mCw = k.b.mCO.mDi;
                        aLe.mCx = k.b.mCO.name;
                        aLe.fCR = 8;
                        aLe.aLg().aLf();
                        new com.tencent.mm.plugin.freewifi.d.k(str, com_tencent_mm_protocal_c_bdx, 8, aLi).b(null);
                    }
                }
            });
        }
        return false;
    }
}
