package com.tencent.mm.ui.fts.widget;

import android.view.View;
import android.view.View.OnFocusChangeListener;

class FTSEditTextView$7 implements OnFocusChangeListener {
    final /* synthetic */ FTSEditTextView zdZ;

    FTSEditTextView$7(FTSEditTextView fTSEditTextView) {
        this.zdZ = fTSEditTextView;
    }

    public final void onFocusChange(View view, boolean z) {
        if (FTSEditTextView.h(this.zdZ) != null) {
            FTSEditTextView.h(this.zdZ).hL(z);
        }
    }
}
