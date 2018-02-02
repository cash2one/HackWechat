package com.tencent.mm.ui.fts.widget;

import android.view.View;
import android.view.View.OnClickListener;

class FTSEditTextView$4 implements OnClickListener {
    final /* synthetic */ FTSEditTextView zdZ;

    FTSEditTextView$4(FTSEditTextView fTSEditTextView) {
        this.zdZ = fTSEditTextView;
    }

    public final void onClick(View view) {
        this.zdZ.clearText();
        if (FTSEditTextView.h(this.zdZ) != null) {
            FTSEditTextView.h(this.zdZ).cs(view);
        }
    }
}
