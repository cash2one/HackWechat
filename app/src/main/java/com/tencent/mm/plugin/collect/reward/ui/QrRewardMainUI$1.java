package com.tencent.mm.plugin.collect.reward.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class QrRewardMainUI$1 implements TextWatcher {
    final /* synthetic */ QrRewardMainUI lkA;
    int lkz = 0;

    QrRewardMainUI$1(QrRewardMainUI qrRewardMainUI) {
        this.lkA = qrRewardMainUI;
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
        x.d("MicroMsg.QrRewardMainUI", "s: %s, %s", new Object[]{editable.toString(), Integer.valueOf(editable.length())});
        CharSequence obj = editable.toString();
        if (bh.ov(obj)) {
            this.lkz = 0;
        } else if (this.lkz == 0) {
            if (((a) g.h(a.class)).w(obj) || ((a) g.h(a.class)).x(obj)) {
                this.lkz = editable.length();
            } else {
                this.lkz = 1;
            }
        }
        editable.delete(this.lkz, editable.length());
    }
}
