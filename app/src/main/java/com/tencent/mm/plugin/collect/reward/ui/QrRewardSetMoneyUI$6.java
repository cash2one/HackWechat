package com.tencent.mm.plugin.collect.reward.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mm.sdk.platformtools.ag;

class QrRewardSetMoneyUI$6 implements TextWatcher {
    final /* synthetic */ QrRewardSetMoneyUI llg;

    QrRewardSetMoneyUI$6(QrRewardSetMoneyUI qrRewardSetMoneyUI) {
        this.llg = qrRewardSetMoneyUI;
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
        if (indexOf >= 0 && length - indexOf > 3) {
            editable.delete(indexOf + 3, length);
        } else if (indexOf > 6) {
            editable.delete(6, indexOf);
        } else if (indexOf == -1 && length > 6) {
            editable.delete(6, length);
        }
        ag.K(QrRewardSetMoneyUI.d(this.llg));
        ag.h(QrRewardSetMoneyUI.d(this.llg), 50);
    }
}
