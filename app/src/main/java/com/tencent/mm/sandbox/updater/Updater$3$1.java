package com.tencent.mm.sandbox.updater;

import android.content.Intent;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.afn;
import com.tencent.mm.protocal.c.afo;
import com.tencent.mm.sandbox.updater.Updater.3;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.util.Map;

class Updater$3$1 implements e {
    final /* synthetic */ com.tencent.mm.network.e gPR;
    final /* synthetic */ 3 xdr;

    Updater$3$1(3 3, com.tencent.mm.network.e eVar) {
        this.xdr = 3;
        this.gPR = eVar;
    }

    public final void a(int i, int i2, String str, k kVar) {
        ar.CG().b(221, Updater.f(this.xdr.xdq));
        Updater.a(this.xdr.xdq, null);
        if (i == 0 && i2 == 0) {
            long j;
            t tVar = (t) kVar;
            if (((afn) tVar.hMV.hmg.hmo).ktN == 0) {
                String str2 = ((afo) tVar.hMV.hmh.hmo).nje;
                if (!bh.ov(str2)) {
                    Map y = bi.y(str2, "resourcecontrolinfo");
                    if (y != null) {
                        str2 = (String) y.get(".resourcecontrolinfo.enableupdate");
                        String str3 = (String) y.get(".resourcecontrolinfo.expiredtime");
                        x.i("MicroMsg.NetSceneGetResourceControlInfo", "summerupdate getDisableUpdateTime values[%s]", new Object[]{y});
                        if (bh.getInt(str2, 1) == 0) {
                            j = bh.getLong(str3, 0);
                            if (j > System.currentTimeMillis() / 1000) {
                                x.i("MicroMsg.Updater", "summerupdate checkcontrol time[%d] > now[%d] control not auto download and ret", new Object[]{Long.valueOf(j), Long.valueOf(System.currentTimeMillis() / 1000)});
                                g.pQN.a(405, 0, 1, true);
                                return;
                            }
                        }
                    }
                }
            }
            j = 0;
            if (j > System.currentTimeMillis() / 1000) {
                x.i("MicroMsg.Updater", "summerupdate checkcontrol time[%d] > now[%d] control not auto download and ret", new Object[]{Long.valueOf(j), Long.valueOf(System.currentTimeMillis() / 1000)});
                g.pQN.a(405, 0, 1, true);
                return;
            }
        }
        x.i("MicroMsg.Updater", "summerupdate gonna start UpdaterService after checkcontrol");
        g.pQN.a(405, 59, 1, true);
        Intent intent = new Intent(this.xdr.xdq.getContext(), UpdaterService.class);
        Updater.a(this.xdr.xdq, intent, this.gPR, this.xdr.xdp);
        intent.putExtra("intent_extra_run_in_foreground", true);
        intent.putExtra("intent_extra_download_mode", 2);
        this.xdr.xdq.getContext().startService(intent);
    }
}
