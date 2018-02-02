package com.tencent.mm.pluginsdk.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mm.sdk.platformtools.bh;

class MMPhoneNumberEditText$2 implements TextWatcher {
    final /* synthetic */ MMPhoneNumberEditText vkr;

    MMPhoneNumberEditText$2(MMPhoneNumberEditText mMPhoneNumberEditText) {
        this.vkr = mMPhoneNumberEditText;
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        MMPhoneNumberEditText.c(this.vkr);
        if (!charSequence.toString().equals("") || MMPhoneNumberEditText.d(this.vkr)) {
            if (charSequence.toString().equals("") || !MMPhoneNumberEditText.d(this.vkr)) {
                if (MMPhoneNumberEditText.b(this.vkr) != null && this.vkr.isFocused()) {
                    MMPhoneNumberEditText.b(this.vkr).cai();
                }
            } else if (MMPhoneNumberEditText.b(this.vkr) != null && this.vkr.isFocused()) {
                MMPhoneNumberEditText.b(this.vkr).cah();
            }
        } else if (MMPhoneNumberEditText.b(this.vkr) != null && this.vkr.isFocused()) {
            MMPhoneNumberEditText.b(this.vkr).g(this.vkr);
        }
    }

    public final void afterTextChanged(Editable editable) {
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (bh.ov(charSequence.toString())) {
            MMPhoneNumberEditText.a(this.vkr, true);
        } else {
            MMPhoneNumberEditText.a(this.vkr, false);
        }
    }
}
