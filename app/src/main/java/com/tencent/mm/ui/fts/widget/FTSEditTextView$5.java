package com.tencent.mm.ui.fts.widget;

import android.view.inputmethod.InputMethodManager;

class FTSEditTextView$5 implements Runnable {
    final /* synthetic */ FTSEditTextView zdZ;

    FTSEditTextView$5(FTSEditTextView fTSEditTextView) {
        this.zdZ = fTSEditTextView;
    }

    public final void run() {
        ((InputMethodManager) this.zdZ.getContext().getSystemService("input_method")).showSoftInput(FTSEditTextView.a(this.zdZ), 0);
    }
}
