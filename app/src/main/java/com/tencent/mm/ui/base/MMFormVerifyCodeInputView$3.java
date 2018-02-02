package com.tencent.mm.ui.base;

import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.w.a.k;

class MMFormVerifyCodeInputView$3 implements a {
    final /* synthetic */ MMFormVerifyCodeInputView yaF;

    MMFormVerifyCodeInputView$3(MMFormVerifyCodeInputView mMFormVerifyCodeInputView) {
        this.yaF = mMFormVerifyCodeInputView;
    }

    public final boolean uF() {
        MMFormVerifyCodeInputView.f(this.yaF);
        MMFormVerifyCodeInputView.h(this.yaF).setText(this.yaF.getContext().getString(k.gYF, new Object[]{Integer.valueOf(MMFormVerifyCodeInputView.g(this.yaF))}));
        if (MMFormVerifyCodeInputView.g(this.yaF) == 0) {
            MMFormVerifyCodeInputView.i(this.yaF).TG();
            MMFormVerifyCodeInputView.a(this.yaF, MMFormVerifyCodeInputView.j(this.yaF));
            MMFormVerifyCodeInputView.k(this.yaF).setVisibility(0);
            MMFormVerifyCodeInputView.h(this.yaF).setVisibility(8);
        }
        return true;
    }
}
