package com.tencent.mm.ui.fts.widget;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

class FTSEditTextView$1 implements OnKeyListener {
    final /* synthetic */ FTSEditTextView zdZ;

    FTSEditTextView$1(FTSEditTextView fTSEditTextView) {
        this.zdZ = fTSEditTextView;
    }

    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && 67 == i) {
            int selectionStart = FTSEditTextView.a(this.zdZ).getSelectionStart();
            int selectionEnd = FTSEditTextView.a(this.zdZ).getSelectionEnd();
            if (selectionStart == 0 && selectionEnd == 0 && FTSEditTextView.b(this.zdZ).size() > 0 && FTSEditTextView.c(this.zdZ)) {
                FTSEditTextView.b(this.zdZ).remove(FTSEditTextView.b(this.zdZ).size() - 1);
                FTSEditTextView.d(this.zdZ);
                FTSEditTextView.e(this.zdZ);
            }
        }
        return false;
    }
}
