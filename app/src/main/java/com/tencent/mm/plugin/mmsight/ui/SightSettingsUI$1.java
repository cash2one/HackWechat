package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.mm.sdk.platformtools.x;

class SightSettingsUI$1 implements Runnable {
    final /* synthetic */ SightSettingsUI oDm;

    SightSettingsUI$1(SightSettingsUI sightSettingsUI) {
        this.oDm = sightSettingsUI;
    }

    public final void run() {
        x.i("MicroMsg.SightSettingsUI", "has connect");
        SightSettingsUI.a(this.oDm);
    }
}
