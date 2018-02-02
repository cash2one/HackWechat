package com.tencent.mm.plugin.label.ui.widget;

import android.view.View;
import android.view.View.OnClickListener;

class InputClearablePreference$2 implements OnClickListener {
    final /* synthetic */ InputClearablePreference nQr;

    InputClearablePreference$2(InputClearablePreference inputClearablePreference) {
        this.nQr = inputClearablePreference;
    }

    public final void onClick(View view) {
        if (InputClearablePreference.b(this.nQr) != null) {
            InputClearablePreference.b(this.nQr).setText("");
            InputClearablePreference.b(this.nQr, "");
        }
    }
}
