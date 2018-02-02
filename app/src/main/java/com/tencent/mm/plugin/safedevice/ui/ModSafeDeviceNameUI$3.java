package com.tencent.mm.plugin.safedevice.ui;

import com.tencent.mm.ui.widget.MMEditText.b;

class ModSafeDeviceNameUI$3 implements b {
    final /* synthetic */ ModSafeDeviceNameUI pRr;

    ModSafeDeviceNameUI$3(ModSafeDeviceNameUI modSafeDeviceNameUI) {
        this.pRr = modSafeDeviceNameUI;
    }

    public final void bot() {
        if (ModSafeDeviceNameUI.a(this.pRr).getText().toString().trim().length() > 0) {
            this.pRr.enableOptionMenu(true);
        } else {
            this.pRr.enableOptionMenu(false);
        }
    }
}
