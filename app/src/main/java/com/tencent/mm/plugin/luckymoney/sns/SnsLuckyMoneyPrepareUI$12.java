package com.tencent.mm.plugin.luckymoney.sns;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

class SnsLuckyMoneyPrepareUI$12 implements OnClickListener {
    final /* synthetic */ boolean iiJ = false;
    final /* synthetic */ EditText iiL;
    final /* synthetic */ int iiN;
    final /* synthetic */ SnsLuckyMoneyPrepareUI ofF;

    SnsLuckyMoneyPrepareUI$12(SnsLuckyMoneyPrepareUI snsLuckyMoneyPrepareUI, boolean z, int i, EditText editText) {
        this.ofF = snsLuckyMoneyPrepareUI;
        this.iiN = i;
        this.iiL = editText;
    }

    public final void onClick(View view) {
        if (!this.ofF.ofs.isShown() && !this.iiJ) {
            SnsLuckyMoneyPrepareUI.k(this.ofF);
            SnsLuckyMoneyPrepareUI.b(this.ofF, this.iiN);
        } else if (this.iiJ) {
            this.ofF.Xa();
            ((InputMethodManager) this.ofF.mController.xIM.getSystemService("input_method")).showSoftInput(this.iiL, 0);
        }
    }
}
