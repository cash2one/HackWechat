package com.tencent.mm.ui.account.bind;

import android.text.InputFilter;
import android.text.Spanned;
import com.tencent.mm.sdk.platformtools.bh;

class BindMobileVerifyUI$1 implements InputFilter {
    final /* synthetic */ BindMobileVerifyUI xTG;

    BindMobileVerifyUI$1(BindMobileVerifyUI bindMobileVerifyUI) {
        this.xTG = bindMobileVerifyUI;
    }

    public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        return bh.N(charSequence);
    }
}
