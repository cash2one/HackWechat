package com.tencent.mm.ui.account.mobile;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mm.sdk.platformtools.bh;

class MobileVerifyUI$7 implements TextWatcher {
    final /* synthetic */ MobileVerifyUI xVi;

    MobileVerifyUI$7(MobileVerifyUI mobileVerifyUI) {
        this.xVi = mobileVerifyUI;
    }

    public final void afterTextChanged(Editable editable) {
        if (bh.ov(this.xVi.xTy.getText().toString())) {
            this.xVi.xTy.setTextSize(15.0f);
            this.xVi.xTy.setGravity(16);
        } else {
            this.xVi.xTy.setTextSize(24.0f);
            this.xVi.xTy.setGravity(16);
        }
        if (this.xVi.xTy.getText() == null || this.xVi.xTy.getText().toString().length() <= 0) {
            this.xVi.sCT.setEnabled(false);
        } else {
            this.xVi.sCT.setEnabled(true);
        }
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
