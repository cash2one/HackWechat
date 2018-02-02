package com.tencent.mm.wallet_core.ui.formview;

import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.wallet_core.ui.formview.a.c;

class a$1 extends c {
    a$1() {
        super((byte) 0);
    }

    public final boolean c(WalletFormView walletFormView, String str) {
        if (bh.ov(str) || str.length() > 5) {
            return false;
        }
        walletFormView.setSelection(0);
        if (walletFormView.zJG != null) {
            walletFormView.zJG.setBankcardTailNum(str);
        }
        walletFormView.pEC = 24 - str.length();
        walletFormView.setFilters(new InputFilter[]{new LengthFilter(walletFormView.pEC)});
        return true;
    }

    public final boolean d(WalletFormView walletFormView, String str) {
        if (bh.ov(str) || str.length() > 5) {
            return false;
        }
        walletFormView.setSelection(0);
        if (walletFormView.zJG != null) {
            walletFormView.zJG.set3DesEncrptData(str);
        }
        walletFormView.pEC = 24 - str.length();
        walletFormView.setFilters(new InputFilter[]{new LengthFilter(walletFormView.pEC)});
        return true;
    }

    public final boolean h(WalletFormView walletFormView) {
        return walletFormView.zJG == null ? false : walletFormView.zJG.isBankcardNum();
    }

    public final boolean bmH() {
        return true;
    }

    public final String e(WalletFormView walletFormView, String str) {
        return bh.az(str, "").replaceAll(" ", "");
    }
}
