package com.tencent.mm.plugin.voip_cs.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import com.tencent.mm.plugin.voip_cs.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;

class VoipCSMainUI$4 extends BroadcastReceiver {
    final /* synthetic */ VoipCSMainUI sxP;

    VoipCSMainUI$4(VoipCSMainUI voipCSMainUI) {
        this.sxP = voipCSMainUI;
    }

    public final void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        PowerManager powerManager = (PowerManager) ac.getContext().getSystemService("power");
        if ("android.intent.action.USER_PRESENT".equals(action) && powerManager.isScreenOn()) {
            x.d("MicroMsg.voipcs.VoipCSMainUI", "on user present home");
            VoipCSMainUI.e(this.sxP).fvI = false;
        } else if ("android.intent.action.SCREEN_ON".equals(action)) {
            x.d("MicroMsg.voipcs.VoipCSMainUI", "screen on...");
            VoipCSMainUI.e(this.sxP).fvI = false;
            if (!VoipCSMainUI.f(this.sxP).bHv() && b.bIT().swV == 2) {
                VoipCSMainUI.f(this.sxP).bJb();
            }
        } else if ("android.intent.action.SCREEN_OFF".equals(action)) {
            x.d("MicroMsg.voipcs.VoipCSMainUI", "screen off...");
            VoipCSMainUI.e(this.sxP).fvI = true;
            if (!VoipCSMainUI.f(this.sxP).bHv()) {
                VoipCSMainUI.f(this.sxP).stopRing();
            }
        }
    }
}
