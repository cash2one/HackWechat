package com.tencent.mm.plugin.freewifi.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.freewifi.model.d;

class FreeWifiActivateStateUI$5 implements OnClickListener {
    final /* synthetic */ FreeWifiActivateStateUI mGy;

    FreeWifiActivateStateUI$5(FreeWifiActivateStateUI freeWifiActivateStateUI) {
        this.mGy = freeWifiActivateStateUI;
    }

    public final void onClick(View view) {
        if (this.mGy.aMt() == 2) {
            this.mGy.finish();
            return;
        }
        d.a(this.mGy.ssid, 1, this.mGy.getIntent());
        this.mGy.mGt = false;
        this.mGy.aMz();
    }
}
