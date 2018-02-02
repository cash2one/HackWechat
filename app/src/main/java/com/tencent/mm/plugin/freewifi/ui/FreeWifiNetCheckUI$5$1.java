package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiNetCheckUI.5;
import com.tencent.mm.sdk.platformtools.bh;

class FreeWifiNetCheckUI$5$1 implements e {
    final /* synthetic */ 5 mIh;

    FreeWifiNetCheckUI$5$1(5 5) {
        this.mIh = 5;
    }

    public final void a(int i, int i2, String str, k kVar) {
        String aMj = ((com.tencent.mm.plugin.freewifi.d.k) kVar).aMj();
        if (bh.ov(aMj)) {
            this.mIh.mIe.finish();
            FreeWifiNetCheckUI.c(this.mIh.mIe);
            return;
        }
        FreeWifiNetCheckUI.a(this.mIh.mIe, aMj);
        this.mIh.mIe.getIntent().putExtra("free_wifi_ap_key", aMj);
        FreeWifiNetCheckUI.d(this.mIh.mIe);
        FreeWifiNetCheckUI.e(this.mIh.mIe);
    }
}
