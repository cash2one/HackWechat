package com.tencent.mm.ui.bindmobile;

import android.text.InputFilter;
import android.text.Spanned;
import com.tencent.mm.sdk.platformtools.bh;

class BindMContactVerifyUI$1 implements InputFilter {
    final /* synthetic */ BindMContactVerifyUI ylV;

    BindMContactVerifyUI$1(BindMContactVerifyUI bindMContactVerifyUI) {
        this.ylV = bindMContactVerifyUI;
    }

    public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        return bh.N(charSequence);
    }
}
