package com.tencent.mm.ui.account.mobile;

import android.text.InputFilter;
import android.text.Spanned;
import com.tencent.mm.sdk.platformtools.bh;

class MobileVerifyUI$5 implements InputFilter {
    final /* synthetic */ MobileVerifyUI xVi;

    MobileVerifyUI$5(MobileVerifyUI mobileVerifyUI) {
        this.xVi = mobileVerifyUI;
    }

    public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        return bh.N(charSequence);
    }
}
