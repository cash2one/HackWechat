package com.tencent.mm.plugin.exdevice.ui;

import android.text.Editable;
import android.text.TextWatcher;

class ExdeviceConnectWifiUI$11 implements TextWatcher {
    final /* synthetic */ ExdeviceConnectWifiUI lTI;

    ExdeviceConnectWifiUI$11(ExdeviceConnectWifiUI exdeviceConnectWifiUI) {
        this.lTI = exdeviceConnectWifiUI;
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
        if (editable.length() > 31) {
            ExdeviceConnectWifiUI.i(this.lTI).setVisibility(0);
            ExdeviceConnectWifiUI.j(this.lTI).setEnabled(false);
            return;
        }
        ExdeviceConnectWifiUI.i(this.lTI).setVisibility(8);
        ExdeviceConnectWifiUI.j(this.lTI).setEnabled(true);
    }
}
