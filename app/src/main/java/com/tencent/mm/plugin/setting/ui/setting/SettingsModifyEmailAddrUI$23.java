package com.tencent.mm.plugin.setting.ui.setting;

import android.text.InputFilter;
import android.text.Spanned;

class SettingsModifyEmailAddrUI$23 implements InputFilter {
    final /* synthetic */ SettingsModifyEmailAddrUI qjX;

    SettingsModifyEmailAddrUI$23(SettingsModifyEmailAddrUI settingsModifyEmailAddrUI) {
        this.qjX = settingsModifyEmailAddrUI;
    }

    public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        return charSequence.length() <= 0 ? spanned.subSequence(i3, i4) : "";
    }
}
