package com.tencent.mm.ui.base;

import android.view.View;
import android.view.View.OnFocusChangeListener;

class MMAutoCompleteTextView$3 implements OnFocusChangeListener {
    final /* synthetic */ MMAutoCompleteTextView xZu;

    MMAutoCompleteTextView$3(MMAutoCompleteTextView mMAutoCompleteTextView) {
        this.xZu = mMAutoCompleteTextView;
    }

    public final void onFocusChange(View view, boolean z) {
        MMAutoCompleteTextView.b(this.xZu);
    }
}
