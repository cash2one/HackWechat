package com.tencent.mm.ui.base;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mm.w.a.f;

class MMFormVerifyCodeInputView$1 implements OnFocusChangeListener {
    final /* synthetic */ MMFormVerifyCodeInputView yaF;

    MMFormVerifyCodeInputView$1(MMFormVerifyCodeInputView mMFormVerifyCodeInputView) {
        this.yaF = mMFormVerifyCodeInputView;
    }

    public final void onFocusChange(View view, boolean z) {
        if (view == MMFormVerifyCodeInputView.a(this.yaF)) {
            MMFormVerifyCodeInputView.b(this.yaF);
            if (z) {
                this.yaF.setBackgroundResource(f.bDf);
            } else {
                this.yaF.setBackgroundResource(f.bDg);
            }
            MMFormVerifyCodeInputView.c(this.yaF);
        }
        if (MMFormVerifyCodeInputView.d(this.yaF) != null) {
            MMFormVerifyCodeInputView.d(this.yaF).onFocusChange(view, z);
        }
    }
}
