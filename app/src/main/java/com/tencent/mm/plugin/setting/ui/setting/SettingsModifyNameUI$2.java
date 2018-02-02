package com.tencent.mm.plugin.setting.ui.setting;

import android.text.Editable;
import android.text.TextWatcher;

class SettingsModifyNameUI$2 implements TextWatcher {
    final /* synthetic */ SettingsModifyNameUI qkd;

    SettingsModifyNameUI$2(SettingsModifyNameUI settingsModifyNameUI) {
        this.qkd = settingsModifyNameUI;
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.qkd.enableOptionMenu(true);
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
    }
}
