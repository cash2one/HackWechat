package com.tencent.mm.plugin.collect.reward.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mm.sdk.platformtools.bh;

class QrRewardGrantUI$1 implements TextWatcher {
    final /* synthetic */ QrRewardGrantUI lkb;

    QrRewardGrantUI$1(QrRewardGrantUI qrRewardGrantUI) {
        this.lkb = qrRewardGrantUI;
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
        length = (int) Math.round(bh.getDouble(editable.toString(), 0.0d) * 100.0d);
        QrRewardGrantUI.a(this.lkb, length);
        QrRewardGrantUI.b(this.lkb, length);
    }
}
