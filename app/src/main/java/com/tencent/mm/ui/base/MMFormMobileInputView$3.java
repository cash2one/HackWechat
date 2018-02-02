package com.tencent.mm.ui.base;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mm.sdk.platformtools.bh;

class MMFormMobileInputView$3 implements TextWatcher {
    final /* synthetic */ MMFormMobileInputView yaz;

    MMFormMobileInputView$3(MMFormMobileInputView mMFormMobileInputView) {
        this.yaz = mMFormMobileInputView;
    }

    public final void afterTextChanged(Editable editable) {
        String obj = MMFormMobileInputView.a(this.yaz).getText().toString();
        if (bh.ov(obj)) {
            MMFormMobileInputView.a(this.yaz).setText("+");
            MMFormMobileInputView.a(this.yaz).setSelection(MMFormMobileInputView.a(this.yaz).getText().toString().length());
        } else if (!obj.contains("+")) {
            MMFormMobileInputView.a(this.yaz).setText("+" + obj);
            MMFormMobileInputView.a(this.yaz).setSelection(MMFormMobileInputView.a(this.yaz).getText().toString().length());
        } else if (obj.length() > 1) {
            obj = obj.substring(1);
            if (obj.length() > 4) {
                MMFormMobileInputView.a(this.yaz).setText(obj.substring(0, 4));
            }
        }
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
