package com.tencent.mm.plugin.setting.ui.setting;

import com.tencent.mm.g.a.nv;
import com.tencent.mm.z.ba.a;

class SettingsChattingUI$3 implements a {
    final /* synthetic */ SettingsChattingUI qji;

    SettingsChattingUI$3(SettingsChattingUI settingsChattingUI) {
        this.qji = settingsChattingUI;
    }

    public final boolean HB() {
        return SettingsChattingUI.c(this.qji);
    }

    public final void HA() {
        if (SettingsChattingUI.a(this.qji) != null) {
            SettingsChattingUI.a(this.qji).dismiss();
            SettingsChattingUI.a(this.qji, null);
        }
        com.tencent.mm.sdk.b.a.xef.m(new nv());
    }
}
