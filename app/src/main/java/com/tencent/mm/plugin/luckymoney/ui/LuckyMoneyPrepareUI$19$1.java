package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.19;

class LuckyMoneyPrepareUI$19$1 implements Runnable {
    final /* synthetic */ 19 ojG;
    final /* synthetic */ View zS;

    LuckyMoneyPrepareUI$19$1(19 19, View view) {
        this.ojG = 19;
        this.zS = view;
    }

    public final void run() {
        if (!this.ojG.ojC.ofs.isShown() && this.zS.isShown()) {
            this.ojG.ojC.ofs.setVisibility(0);
        }
        this.ojG.ojC.mKeyboard.setXMode(this.ojG.iiN);
        this.ojG.ojC.mKeyboard.setInputEditText((EditText) this.zS);
        ((InputMethodManager) this.ojG.ojC.mController.xIM.getSystemService("input_method")).hideSoftInputFromWindow(this.zS.getWindowToken(), 0);
    }
}
