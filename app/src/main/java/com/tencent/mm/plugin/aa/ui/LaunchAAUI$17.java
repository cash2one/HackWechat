package com.tencent.mm.plugin.aa.ui;

import android.text.Editable;
import android.text.TextWatcher;

class LaunchAAUI$17 implements TextWatcher {
    final /* synthetic */ LaunchAAUI ijW;

    LaunchAAUI$17(LaunchAAUI launchAAUI) {
        this.ijW = launchAAUI;
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
        LaunchAAUI.c(this.ijW);
    }
}
