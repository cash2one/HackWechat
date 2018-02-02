package com.tencent.mm.plugin.label.ui.widget;

import android.view.inputmethod.InputMethodManager;

class InputClearablePreference$4 implements Runnable {
    final /* synthetic */ InputClearablePreference nQr;

    InputClearablePreference$4(InputClearablePreference inputClearablePreference) {
        this.nQr = inputClearablePreference;
    }

    public final void run() {
        if (InputClearablePreference.b(this.nQr) != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) InputClearablePreference.b(this.nQr).getContext().getSystemService("input_method");
            InputClearablePreference.b(this.nQr).requestFocus();
            inputMethodManager.showSoftInput(InputClearablePreference.b(this.nQr), 0);
            InputClearablePreference.b(this.nQr).setCursorVisible(false);
            InputClearablePreference.b(this.nQr).setCursorVisible(true);
        }
    }
}
