package com.tencent.mm.plugin.voip_cs.ui;

import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.plugin.voip.HeadsetPlugReceiver.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;

class VoipCSMainUI$3 implements a {
    final /* synthetic */ VoipCSMainUI sxP;

    VoipCSMainUI$3(VoipCSMainUI voipCSMainUI) {
        this.sxP = voipCSMainUI;
    }

    public final void fY(boolean z) {
        x.d("MicroMsg.voipcs.VoipCSMainUI", "onHeadsetState, on:%b", Boolean.valueOf(z));
        if (VoipCSMainUI.d(this.sxP) == z) {
            x.d("MicroMsg.voipcs.VoipCSMainUI", "same status, no changed");
            return;
        }
        VoipCSMainUI.a(this.sxP, z);
        if (z) {
            VoipCSMainUI.c(this.sxP).jf(false);
            Toast.makeText(ac.getContext(), ac.getContext().getString(R.l.eVV), 0).show();
            return;
        }
        VoipCSMainUI.c(this.sxP).jf(true);
        Toast.makeText(ac.getContext(), ac.getContext().getString(R.l.eVW), 0).show();
    }
}
