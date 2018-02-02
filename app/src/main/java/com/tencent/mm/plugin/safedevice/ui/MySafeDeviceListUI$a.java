package com.tencent.mm.plugin.safedevice.ui;

import com.tencent.mm.R;
import com.tencent.mm.plugin.safedevice.ui.SafeDeviceListPreference.a;
import com.tencent.mm.plugin.safedevice.ui.SafeDeviceListPreference.b;
import com.tencent.mm.sdk.platformtools.x;

class MySafeDeviceListUI$a implements a, b {
    final /* synthetic */ MySafeDeviceListUI pRA;

    private MySafeDeviceListUI$a(MySafeDeviceListUI mySafeDeviceListUI) {
        this.pRA = mySafeDeviceListUI;
    }

    public final void Iz(String str) {
        MySafeDeviceListUI.b(this.pRA).YO(str);
        MySafeDeviceListUI.f(this.pRA).sendEmptyMessage(0);
        this.pRA.addTextOptionMenu(0, this.pRA.getString(R.l.eGN), MySafeDeviceListUI.h(this.pRA));
        MySafeDeviceListUI.a(this.pRA, MySafeDeviceListUI.d(this.pRA) ^ -1);
        MySafeDeviceListUI.b(this.pRA, MySafeDeviceListUI.c(this.pRA));
    }

    public final void IA(String str) {
        x.e("MicroMsg.MySafeDeviceListUI", "delete safedevice failed" + str);
    }
}
