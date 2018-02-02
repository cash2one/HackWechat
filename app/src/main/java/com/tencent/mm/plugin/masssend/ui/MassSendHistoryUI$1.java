package com.tencent.mm.plugin.masssend.ui;

import com.tencent.mm.plugin.masssend.ui.c.e;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class MassSendHistoryUI$1 implements e {
    final /* synthetic */ MassSendHistoryUI onL;

    MassSendHistoryUI$1(MassSendHistoryUI massSendHistoryUI) {
        this.onL = massSendHistoryUI;
    }

    public final String Ei(String str) {
        ar.Hg();
        if (c.isSDCardAvailable()) {
            String ou = bh.ou(str);
            if (!MassSendHistoryUI.a(this.onL).isPlaying() || !ou.equals(MassSendHistoryUI.b(this.onL).ons)) {
                return !MassSendHistoryUI.a(this.onL, ou) ? "" : ou;
            } else {
                MassSendHistoryUI.aYM();
                this.onL.releaseWakeLock();
                MassSendHistoryUI.a(this.onL).aL(false);
                return "";
            }
        }
        u.fI(this.onL);
        return "";
    }
}
