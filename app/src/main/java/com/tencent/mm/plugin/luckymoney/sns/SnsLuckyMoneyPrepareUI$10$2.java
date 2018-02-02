package com.tencent.mm.plugin.luckymoney.sns;

import android.view.inputmethod.InputMethodManager;
import com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI.10;

class SnsLuckyMoneyPrepareUI$10$2 implements Runnable {
    final /* synthetic */ 10 ofI;

    SnsLuckyMoneyPrepareUI$10$2(10 10) {
        this.ofI = 10;
    }

    public final void run() {
        this.ofI.ofF.Xa();
        ((InputMethodManager) this.ofI.ofF.mController.xIM.getSystemService("input_method")).showSoftInput(this.ofI.iiL, 0);
    }
}
