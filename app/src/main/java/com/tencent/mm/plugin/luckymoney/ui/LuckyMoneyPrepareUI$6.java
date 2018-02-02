package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;

class LuckyMoneyPrepareUI$6 implements OnFocusChangeListener {
    final /* synthetic */ EditText iiL;
    final /* synthetic */ EditText ofM;
    final /* synthetic */ LuckyMoneyPrepareUI ojC;

    LuckyMoneyPrepareUI$6(LuckyMoneyPrepareUI luckyMoneyPrepareUI, EditText editText, EditText editText2) {
        this.ojC = luckyMoneyPrepareUI;
        this.iiL = editText;
        this.ofM = editText2;
    }

    public final void onFocusChange(View view, boolean z) {
        this.iiL.setOnClickListener(null);
        this.ofM.setOnClickListener(null);
        this.ojC.z(LuckyMoneyPrepareUI.b(this.ojC), 2);
        this.ojC.z(LuckyMoneyPrepareUI.a(this.ojC), 0);
    }
}
