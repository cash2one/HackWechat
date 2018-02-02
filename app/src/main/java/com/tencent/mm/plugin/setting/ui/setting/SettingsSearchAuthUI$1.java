package com.tencent.mm.plugin.setting.ui.setting;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.fts.widget.a.a;

class SettingsSearchAuthUI$1 implements a {
    final /* synthetic */ SettingsSearchAuthUI qkQ;

    SettingsSearchAuthUI$1(SettingsSearchAuthUI settingsSearchAuthUI) {
        this.qkQ = settingsSearchAuthUI;
    }

    public final void bpZ() {
        x.i("MicroMsg.SettingsSearchAuthUI", "click search back");
        this.qkQ.finish();
    }
}
