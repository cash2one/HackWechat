package com.tencent.mm.plugin.welab.ui;

import com.tencent.mm.ui.widget.MMSwitchBtn.a;

class WelabAppInfoUI$2 implements a {
    final /* synthetic */ WelabAppInfoUI tPR;

    WelabAppInfoUI$2(WelabAppInfoUI welabAppInfoUI) {
        this.tPR = welabAppInfoUI;
    }

    public final void cw(boolean z) {
        if (WelabAppInfoUI.a(this.tPR).field_Switch == 2) {
            WelabAppInfoUI.a(this.tPR).field_Switch = 1;
        } else if (WelabAppInfoUI.a(this.tPR).field_Switch == 1) {
            WelabAppInfoUI.a(this.tPR).field_Switch = 2;
        }
    }
}
