package com.tencent.mm.plugin.voip_cs.ui;

import com.tencent.mm.compatible.b.f.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

class VoipCSMainUI$2 implements a {
    final /* synthetic */ VoipCSMainUI sxP;

    VoipCSMainUI$2(VoipCSMainUI voipCSMainUI) {
        this.sxP = voipCSMainUI;
    }

    public final void er(int i) {
        x.d("MicroMsg.voipcs.VoipCSMainUI", "onBluetoothHeadsetStateChange status: %d", Integer.valueOf(i));
        switch (i) {
            case 1:
                VoipCSMainUI.c(this.sxP).jf(false);
                return;
            case 2:
                ar.Hh().xJ();
                VoipCSMainUI.c(this.sxP).jf(true);
                return;
            case 3:
                ar.Hh().xI();
                return;
            case 4:
                ar.Hh().xJ();
                VoipCSMainUI.c(this.sxP).jf(true);
                return;
            default:
                return;
        }
    }
}
