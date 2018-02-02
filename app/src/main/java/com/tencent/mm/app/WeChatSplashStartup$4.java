package com.tencent.mm.app;

import com.tencent.mm.blink.a;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.kernel.api.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class WeChatSplashStartup$4 implements g {
    final /* synthetic */ WeChatSplashStartup fga;

    WeChatSplashStartup$4(WeChatSplashStartup weChatSplashStartup) {
        this.fga = weChatSplashStartup;
    }

    public final void ul() {
        com.tencent.mm.kernel.g.Dk().b((g) this);
        a.wj();
        WeChatSplashStartup.a(this.fga);
        if (this.fga.profile.DS()) {
            try {
                ac.getContext().getSharedPreferences("system_config_prefs", 0).edit().putInt("launch_last_status", 2).commit();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.WeChatSplashStartup", e, "%s", e.getMessage());
            }
        }
        if (this.fga.profile.DS()) {
            com.tencent.mm.kernel.a Dh = com.tencent.mm.kernel.g.Dh();
            x.i("MMKernel.CoreAccount", "summerhardcoder hasInitialized[%b] mHardCoderStartPerformance[%d] stack[%s]", Boolean.valueOf(Dh.Cy()), Integer.valueOf(Dh.gPp), bh.cgy());
            if (Dh.Cy() && Dh.gPp != 0) {
                HardCoderJNI.stopPerformace(HardCoderJNI.hcBootEnable, Dh.gPp);
                x.i("MMKernel.CoreAccount", "summerhardcoder stopPerformace[%s] stack[%s]", Integer.valueOf(Dh.gPp), bh.cgy());
                Dh.gPp = 0;
            }
        }
    }

    public final void aG(boolean z) {
    }
}
