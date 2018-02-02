package com.tencent.mm.ui.fts.widget;

import android.text.Editable;
import android.text.TextWatcher;

class FTSEditTextView$2 implements TextWatcher {
    final /* synthetic */ FTSEditTextView zdZ;

    FTSEditTextView$2(FTSEditTextView fTSEditTextView) {
        this.zdZ = fTSEditTextView;
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        String bTC = this.zdZ.bTC();
        if (bTC != FTSEditTextView.f(this.zdZ) && !bTC.equals(FTSEditTextView.f(this.zdZ))) {
            FTSEditTextView.a(this.zdZ, bTC);
            if (bTC.length() > 0) {
                FTSEditTextView.g(this.zdZ).setVisibility(0);
            } else {
                FTSEditTextView.g(this.zdZ).setVisibility(8);
            }
            FTSEditTextView.e(this.zdZ);
        }
    }

    public final void afterTextChanged(Editable editable) {
    }
}
