package com.tencent.mm.ui.base;

import android.view.View;
import android.view.View.OnClickListener;

class MMFormVerifyCodeInputView$2 implements OnClickListener {
    final /* synthetic */ MMFormVerifyCodeInputView yaF;

    MMFormVerifyCodeInputView$2(MMFormVerifyCodeInputView mMFormVerifyCodeInputView) {
        this.yaF = mMFormVerifyCodeInputView;
    }

    public final void onClick(View view) {
        if (MMFormVerifyCodeInputView.e(this.yaF) != null) {
            MMFormVerifyCodeInputView.e(this.yaF).onClick(view);
        }
    }
}
