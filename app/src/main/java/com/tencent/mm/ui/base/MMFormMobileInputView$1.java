package com.tencent.mm.ui.base;

import android.view.View;
import android.view.View.OnFocusChangeListener;

class MMFormMobileInputView$1 implements OnFocusChangeListener {
    final /* synthetic */ MMFormMobileInputView yaz;

    MMFormMobileInputView$1(MMFormMobileInputView mMFormMobileInputView) {
        this.yaz = mMFormMobileInputView;
    }

    public final void onFocusChange(View view, boolean z) {
        if (view == MMFormMobileInputView.a(this.yaz) || view == MMFormMobileInputView.b(this.yaz)) {
            this.yaz.mk(z);
        }
    }
}
