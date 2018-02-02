package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

class LuckyMoneyPrepareUI$20 implements OnClickListener {
    final /* synthetic */ boolean iiJ = false;
    final /* synthetic */ EditText iiL;
    final /* synthetic */ int iiN;
    final /* synthetic */ LuckyMoneyPrepareUI ojC;

    LuckyMoneyPrepareUI$20(LuckyMoneyPrepareUI luckyMoneyPrepareUI, boolean z, int i, EditText editText) {
        this.ojC = luckyMoneyPrepareUI;
        this.iiN = i;
        this.iiL = editText;
    }

    public final void onClick(View view) {
        if (!this.ojC.ofs.isShown() && !this.iiJ) {
            this.ojC.ofs.setVisibility(0);
            this.ojC.mKeyboard.setInputEditText((EditText) view);
            LuckyMoneyPrepareUI.b(this.ojC, this.iiN);
        } else if (this.iiJ) {
            this.ojC.ofs.setVisibility(8);
            ((InputMethodManager) this.ojC.mController.xIM.getSystemService("input_method")).showSoftInput(this.iiL, 0);
        }
    }
}
