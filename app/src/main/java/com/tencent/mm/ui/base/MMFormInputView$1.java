package com.tencent.mm.ui.base;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mm.w.a.f;

class MMFormInputView$1 implements OnFocusChangeListener {
    final /* synthetic */ MMFormInputView yar;

    MMFormInputView$1(MMFormInputView mMFormInputView) {
        this.yar = mMFormInputView;
    }

    public final void onFocusChange(View view, boolean z) {
        if (view == MMFormInputView.a(this.yar)) {
            MMFormInputView.b(this.yar);
            if (z) {
                this.yar.setBackgroundResource(f.bDf);
            } else {
                this.yar.setBackgroundResource(f.bDg);
            }
            MMFormInputView.c(this.yar);
        }
        if (MMFormInputView.d(this.yar) != null) {
            MMFormInputView.d(this.yar).onFocusChange(view, z);
        }
    }
}
