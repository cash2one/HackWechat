package com.tencent.mm.plugin.luckymoney.sns;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

class SnsLuckyMoneyPrepareUI$21 implements OnClickListener {
    final /* synthetic */ EditText iiL;
    final /* synthetic */ SnsLuckyMoneyPrepareUI ofF;
    final /* synthetic */ EditText ofM;

    SnsLuckyMoneyPrepareUI$21(SnsLuckyMoneyPrepareUI snsLuckyMoneyPrepareUI, EditText editText, EditText editText2) {
        this.ofF = snsLuckyMoneyPrepareUI;
        this.iiL = editText;
        this.ofM = editText2;
    }

    public final void onClick(View view) {
        this.iiL.setOnClickListener(null);
        this.ofM.setOnClickListener(null);
        this.ofF.z(this.ofF.ofq, 2);
        this.ofF.z(this.ofF.ofp, 0);
        this.ofF.mKeyboard.setXMode(0);
        this.ofF.mKeyboard.setInputEditText((EditText) view);
        SnsLuckyMoneyPrepareUI.k(this.ofF);
    }
}
