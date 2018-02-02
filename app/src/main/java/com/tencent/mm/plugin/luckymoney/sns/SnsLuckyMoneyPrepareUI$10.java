package com.tencent.mm.plugin.luckymoney.sns;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.mm.sdk.platformtools.af;

class SnsLuckyMoneyPrepareUI$10 implements OnFocusChangeListener {
    final /* synthetic */ boolean iiJ = false;
    final /* synthetic */ EditText iiL;
    final /* synthetic */ int iiN;
    final /* synthetic */ SnsLuckyMoneyPrepareUI ofF;

    SnsLuckyMoneyPrepareUI$10(SnsLuckyMoneyPrepareUI snsLuckyMoneyPrepareUI, boolean z, int i, EditText editText) {
        this.ofF = snsLuckyMoneyPrepareUI;
        this.iiN = i;
        this.iiL = editText;
    }

    public final void onFocusChange(View view, boolean z) {
        if (!view.isFocused() || this.iiJ) {
            new af().postDelayed(new 2(this), 200);
            return;
        }
        ((InputMethodManager) this.ofF.mController.xIM.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
        new af().postDelayed(new 1(this, view), 300);
    }
}
