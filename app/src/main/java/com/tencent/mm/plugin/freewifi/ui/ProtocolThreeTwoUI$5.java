package com.tencent.mm.plugin.freewifi.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.freewifi.l;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.x;

class ProtocolThreeTwoUI$5 implements OnClickListener {
    final /* synthetic */ ProtocolThreeTwoUI mIW;

    ProtocolThreeTwoUI$5(ProtocolThreeTwoUI protocolThreeTwoUI) {
        this.mIW = protocolThreeTwoUI;
    }

    public final void onClick(View view) {
        l.q(d.aLF(), this.mIW.getIntent().getStringExtra("free_wifi_ap_key"), this.mIW.getIntent().getIntExtra("free_wifi_protocol_type", 0));
        x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.connectWifiBtn.setOnClickListener, desc=User click the connect button and starts the connect wifi process. state=%s", new Object[]{m.D(this.mIW.getIntent()), Integer.valueOf(m.E(this.mIW.getIntent())), d.pW(this.mIW.aMt())});
        if (this.mIW.aMt() == 2) {
            this.mIW.finish();
            return;
        }
        d.a(this.mIW.ssid, 1, this.mIW.getIntent());
        this.mIW.connect();
    }
}
