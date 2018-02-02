package com.tencent.mm.plugin.freewifi.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.freewifi.l;
import com.tencent.mm.plugin.freewifi.model.d;

class FreeWifiStateUI$5 implements OnClickListener {
    final /* synthetic */ FreeWifiStateUI mIt;

    FreeWifiStateUI$5(FreeWifiStateUI freeWifiStateUI) {
        this.mIt = freeWifiStateUI;
    }

    public final void onClick(View view) {
        l.q(d.aLF(), this.mIt.getIntent().getStringExtra("free_wifi_ap_key"), this.mIt.getIntent().getIntExtra("free_wifi_protocol_type", 0));
        if (this.mIt.aMt() == 2) {
            this.mIt.finish();
            return;
        }
        d.a(this.mIt.ssid, 1, this.mIt.getIntent());
        this.mIt.mGt = false;
        this.mIt.aMz();
    }
}
