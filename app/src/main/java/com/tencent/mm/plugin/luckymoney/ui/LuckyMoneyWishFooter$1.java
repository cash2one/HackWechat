package com.tencent.mm.plugin.luckymoney.ui;

import android.text.Editable;
import android.text.TextWatcher;

class LuckyMoneyWishFooter$1 implements TextWatcher {
    final /* synthetic */ LuckyMoneyWishFooter okD;

    LuckyMoneyWishFooter$1(LuckyMoneyWishFooter luckyMoneyWishFooter) {
        this.okD = luckyMoneyWishFooter;
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
        if (LuckyMoneyWishFooter.a(this.okD).getText() != null) {
            LuckyMoneyWishFooter.a(this.okD).requestFocus();
            boolean z = editable.length() > 0 && editable.toString().trim().length() > 0;
            if (z && this.okD.okB) {
                LuckyMoneyWishFooter.a(this.okD, true);
                this.okD.okB = false;
            }
            if (!z) {
                LuckyMoneyWishFooter.a(this.okD, false);
                this.okD.okB = true;
            }
        }
    }
}
