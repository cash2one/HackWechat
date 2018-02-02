package com.tencent.mm.pluginsdk.ui;

import android.view.View;
import android.view.View.OnFocusChangeListener;

class MMPhoneNumberEditText$3 implements OnFocusChangeListener {
    final /* synthetic */ MMPhoneNumberEditText vkr;

    MMPhoneNumberEditText$3(MMPhoneNumberEditText mMPhoneNumberEditText) {
        this.vkr = mMPhoneNumberEditText;
    }

    public final void onFocusChange(View view, boolean z) {
        if (MMPhoneNumberEditText.e(this.vkr) != null) {
            MMPhoneNumberEditText.e(this.vkr).onFocusChange(view, z);
        }
        MMPhoneNumberEditText.c(this.vkr);
    }
}
