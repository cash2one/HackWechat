package com.tencent.mm.plugin.ext.openapi.provider;

import com.tencent.mm.g.a.et;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bc;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class ExtControlProviderOpenApi$2 extends bc<Integer> {
    final /* synthetic */ String[] gIP;
    final /* synthetic */ ExtControlProviderOpenApi lZX;

    ExtControlProviderOpenApi$2(ExtControlProviderOpenApi extControlProviderOpenApi, String[] strArr) {
        this.lZX = extControlProviderOpenApi;
        this.gIP = strArr;
        super(20000, null, true);
    }

    protected final /* synthetic */ Object run() {
        return Vy();
    }

    private Integer Vy() {
        try {
            x.d("MicroMsg.ExtControlProviderOpenApi", "syncTaskCur run ");
            final b etVar = new et();
            etVar.fto.version = bh.getInt(this.gIP[0], 0);
            etVar.fto.ssid = this.gIP[1];
            etVar.fto.bssid = this.gIP[2];
            etVar.fto.ftq = bh.getInt(this.gIP[3], 0);
            etVar.fqI = new Runnable(this) {
                final /* synthetic */ ExtControlProviderOpenApi$2 mab;

                public final void run() {
                    x.i("MicroMsg.ExtControlProviderOpenApi", "connectWifi run");
                    if (etVar != null && etVar.ftp != null && etVar.ftp.ftr != 0) {
                        x.i("MicroMsg.ExtControlProviderOpenApi", "connectWifi errcode = %s,errmsg = %s", Integer.valueOf(etVar.ftp.fts), etVar.ftp.ftt);
                        this.mab.bX(Integer.valueOf(etVar.ftp.fts));
                    }
                }
            };
            if (!a.xef.m(etVar)) {
                x.i("MicroMsg.ExtControlProviderOpenApi", "connectWifi publish getWifiListEvent fail");
                bX(Integer.valueOf(8));
            }
        } catch (Exception e) {
            x.e("MicroMsg.ExtControlProviderOpenApi", "exception in connectWifi syncTaskInt.", e);
            bX(Integer.valueOf(12));
        }
        return Integer.valueOf(0);
    }
}
