package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.mm.sdk.platformtools.af;

class LuckyMoneyPrepareUI$19 implements OnFocusChangeListener {
    final /* synthetic */ boolean iiJ = false;
    final /* synthetic */ EditText iiL;
    final /* synthetic */ int iiN;
    final /* synthetic */ LuckyMoneyPrepareUI ojC;

    LuckyMoneyPrepareUI$19(LuckyMoneyPrepareUI luckyMoneyPrepareUI, boolean z, int i, EditText editText) {
        this.ojC = luckyMoneyPrepareUI;
        this.iiN = i;
        this.iiL = editText;
    }

    public final void onFocusChange(View view, boolean z) {
        if (!view.isFocused() || this.iiJ) {
            new af().postDelayed(new Runnable(this) {
                final /* synthetic */ LuckyMoneyPrepareUI$19 ojG;

                {
                    this.ojG = r1;
                }

                public final void run() {
                    this.ojG.ojC.Xa();
                    ((InputMethodManager) this.ojG.ojC.mController.xIM.getSystemService("input_method")).showSoftInput(this.ojG.iiL, 0);
                }
            }, 200);
            return;
        }
        ((InputMethodManager) this.ojC.mController.xIM.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
        new af().postDelayed(new 1(this, view), 300);
    }
}
