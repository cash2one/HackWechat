package com.tencent.mm.plugin.wallet_core.ui;

import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

class j$10 implements OnCheckedChangeListener {
    final /* synthetic */ Button sTR;

    public j$10(Button button) {
        this.sTR = button;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            this.sTR.setEnabled(true);
            this.sTR.setClickable(true);
            return;
        }
        this.sTR.setEnabled(false);
        this.sTR.setClickable(false);
    }
}
