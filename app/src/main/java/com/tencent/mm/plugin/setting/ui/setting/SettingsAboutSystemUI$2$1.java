package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Dialog;
import com.tencent.mm.plugin.setting.ui.setting.SettingsAboutSystemUI.2;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class SettingsAboutSystemUI$2$1 implements Runnable {
    final /* synthetic */ int qiq;
    final /* synthetic */ 2 qir;

    SettingsAboutSystemUI$2$1(2 2, int i) {
        this.qir = 2;
        this.qiq = i;
    }

    public final void run() {
        ((Dialog) this.qir.qio.getTag()).dismiss();
        ar.Hg();
        c.CU().set(327686, Integer.valueOf(this.qiq));
        ar.Hg();
        c.CU().lH(true);
        SettingsAboutSystemUI.f(this.qir.qin);
    }
}
