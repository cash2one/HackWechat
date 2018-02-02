package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mm.sdk.platformtools.bh;

class BankRemitMoneyInputUI$1 implements TextWatcher {
    final /* synthetic */ BankRemitMoneyInputUI pJw;

    BankRemitMoneyInputUI$1(BankRemitMoneyInputUI bankRemitMoneyInputUI) {
        this.pJw = bankRemitMoneyInputUI;
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
        if (editable.toString().startsWith(".")) {
            editable.insert(0, "0");
        }
        String obj = editable.toString();
        int indexOf = obj.indexOf(".");
        int length = obj.length();
        if (indexOf >= 0 && length - indexOf > 2) {
            editable.delete(indexOf + 3, length);
        }
        obj = editable.toString();
        if (bh.ov(obj) || bh.getDouble(obj, 0.0d) <= 0.0d) {
            BankRemitMoneyInputUI.a(this.pJw).setVisibility(8);
        } else {
            BankRemitMoneyInputUI.a(this.pJw).setVisibility(0);
        }
        BankRemitMoneyInputUI.a(this.pJw, obj);
        BankRemitMoneyInputUI.b(this.pJw);
    }
}
