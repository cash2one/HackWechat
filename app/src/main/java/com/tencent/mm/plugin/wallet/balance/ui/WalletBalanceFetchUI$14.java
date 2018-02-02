package com.tencent.mm.plugin.wallet.balance.ui;

import android.text.Editable;
import android.text.TextWatcher;

class WalletBalanceFetchUI$14 implements TextWatcher {
    final /* synthetic */ WalletBalanceFetchUI szH;

    WalletBalanceFetchUI$14(WalletBalanceFetchUI walletBalanceFetchUI) {
        this.szH = walletBalanceFetchUI;
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
        if (editable.toString().startsWith(".")) {
            editable.insert(0, "0");
        }
        String obj = editable.toString();
        int indexOf = obj.indexOf(".");
        obj.length();
        int lastIndexOf = obj.lastIndexOf(".");
        int length = obj.length();
        if (indexOf >= 0 && length - indexOf > 3) {
            editable.delete(indexOf + 3, length);
        } else if (lastIndexOf != indexOf) {
            editable.delete(lastIndexOf, length);
        }
        WalletBalanceFetchUI.g(this.szH);
    }
}
