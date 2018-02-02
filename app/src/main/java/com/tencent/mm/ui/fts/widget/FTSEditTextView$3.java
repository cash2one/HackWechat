package com.tencent.mm.ui.fts.widget;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

class FTSEditTextView$3 implements OnEditorActionListener {
    final /* synthetic */ FTSEditTextView zdZ;

    FTSEditTextView$3(FTSEditTextView fTSEditTextView) {
        this.zdZ = fTSEditTextView;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (3 != i || FTSEditTextView.h(this.zdZ) == null) {
            return false;
        }
        return FTSEditTextView.h(this.zdZ).akL();
    }
}
