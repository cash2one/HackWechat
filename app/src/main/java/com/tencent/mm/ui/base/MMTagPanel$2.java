package com.tencent.mm.ui.base;

import android.text.Editable;
import android.text.TextWatcher;

class MMTagPanel$2 implements TextWatcher {
    final /* synthetic */ MMTagPanel ydR;

    MMTagPanel$2(MMTagPanel mMTagPanel) {
        this.ydR = mMTagPanel;
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
        String obj = editable.toString();
        if (MMTagPanel.e(this.ydR) != null) {
            MMTagPanel.e(this.ydR).yL(obj);
        }
        if (obj.length() > 0) {
            this.ydR.cpJ();
        }
    }
}
