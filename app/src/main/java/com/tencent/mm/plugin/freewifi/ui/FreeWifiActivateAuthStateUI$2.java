package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.freewifi.d.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.g.b;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class FreeWifiActivateAuthStateUI$2 implements b {
    final /* synthetic */ FreeWifiActivateAuthStateUI mGi;

    FreeWifiActivateAuthStateUI$2(FreeWifiActivateAuthStateUI freeWifiActivateAuthStateUI) {
        this.mGi = freeWifiActivateAuthStateUI;
    }

    public final void bn(String str, int i) {
        x.i("MicroMsg.FreeWifi.FreeWifiActivateAuthStateUI", "get ap auth data : %s, url : %s, mac : %s", new Object[]{str, this.mGi.mFa, d.aLB()});
        if (!bh.ov(str)) {
            String str2 = str;
            new a(this.mGi.mFa, this.mGi.ssid, r3, this.mGi.mGr, str2, "", i, m.D(this.mGi.getIntent())).b(new e(this) {
                final /* synthetic */ FreeWifiActivateAuthStateUI$2 mGj;

                {
                    this.mGj = r1;
                }

                public final void a(int i, int i2, String str, k kVar) {
                    x.i("MicroMsg.FreeWifi.FreeWifiActivateAuthStateUI", "errType : %d, errCode : %d, errMsg : %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                    this.mGj.mGi.mGt = false;
                    if (i == 0 && i2 == 0) {
                        x.i("MicroMsg.FreeWifi.FreeWifiActivateAuthStateUI", "authUrl : %s", new Object[]{((a) kVar).aLW()});
                        j.aLT().a(this.mGj.mGi.ssid, r0, this.mGj.mGi.getIntent());
                    } else if (i2 == -2014) {
                        d.a(this.mGj.mGi.ssid, -2014, this.mGj.mGi.getIntent());
                    } else {
                        d.a(this.mGj.mGi.ssid, 3, this.mGj.mGi.getIntent());
                    }
                }
            });
        }
    }
}
