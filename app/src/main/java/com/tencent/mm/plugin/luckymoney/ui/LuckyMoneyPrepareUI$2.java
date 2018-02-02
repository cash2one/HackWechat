package com.tencent.mm.plugin.luckymoney.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

class LuckyMoneyPrepareUI$2 implements TextWatcher {
    final /* synthetic */ EditText ofM;
    final /* synthetic */ LuckyMoneyPrepareUI ojC;

    LuckyMoneyPrepareUI$2(LuckyMoneyPrepareUI luckyMoneyPrepareUI, EditText editText) {
        this.ojC = luckyMoneyPrepareUI;
        this.ofM = editText;
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
        this.ofM.setContentDescription(editable.toString());
    }
}
