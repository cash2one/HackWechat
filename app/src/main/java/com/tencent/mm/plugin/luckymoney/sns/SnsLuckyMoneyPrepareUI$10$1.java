package com.tencent.mm.plugin.luckymoney.sns;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI.10;

class SnsLuckyMoneyPrepareUI$10$1 implements Runnable {
    final /* synthetic */ 10 ofI;
    final /* synthetic */ View zS;

    SnsLuckyMoneyPrepareUI$10$1(10 10, View view) {
        this.ofI = 10;
        this.zS = view;
    }

    public final void run() {
        if (!this.ofI.ofF.ofs.isShown() && this.zS.isShown()) {
            SnsLuckyMoneyPrepareUI.k(this.ofI.ofF);
        }
        this.ofI.ofF.mKeyboard.setXMode(this.ofI.iiN);
        this.ofI.ofF.mKeyboard.setInputEditText((EditText) this.zS);
        ((InputMethodManager) this.ofI.ofF.mController.xIM.getSystemService("input_method")).hideSoftInputFromWindow(this.zS.getWindowToken(), 0);
    }
}
