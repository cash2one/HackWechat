package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Dialog;
import com.tencent.mm.plugin.setting.ui.setting.SettingsAboutSystemUI.10;

class SettingsAboutSystemUI$10$1 implements Runnable {
    final /* synthetic */ 10 qiw;

    SettingsAboutSystemUI$10$1(10 10) {
        this.qiw = 10;
    }

    public final void run() {
        ((Dialog) this.qiw.qio.getTag()).dismiss();
        SettingsAboutSystemUI.e(this.qiw.qin);
    }
}
