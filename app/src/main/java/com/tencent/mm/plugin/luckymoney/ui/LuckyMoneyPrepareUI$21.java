package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.mm.sdk.platformtools.af;

class LuckyMoneyPrepareUI$21 implements OnClickListener {
    final /* synthetic */ boolean iiJ = false;
    final /* synthetic */ EditText iiL;
    final /* synthetic */ View iiM;
    final /* synthetic */ int iiN;
    final /* synthetic */ LuckyMoneyPrepareUI ojC;

    LuckyMoneyPrepareUI$21(LuckyMoneyPrepareUI luckyMoneyPrepareUI, boolean z, EditText editText, View view, int i) {
        this.ojC = luckyMoneyPrepareUI;
        this.iiL = editText;
        this.iiM = view;
        this.iiN = i;
    }

    public final void onClick(View view) {
        if (!this.ojC.ofs.isShown() || this.iiJ) {
            if (!this.ojC.ofs.isShown() && !this.iiJ) {
                ((InputMethodManager) this.ojC.mController.xIM.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                new af().postDelayed(new Runnable(this) {
                    final /* synthetic */ LuckyMoneyPrepareUI$21 ojH;

                    {
                        this.ojH = r1;
                    }

                    public final void run() {
                        this.ojH.ojC.ofs.setVisibility(0);
                        this.ojH.iiM.requestFocus();
                        if (this.ojH.ojC.mKeyboard != null) {
                            this.ojH.ojC.mKeyboard.setInputEditText(this.ojH.iiL);
                        }
                        LuckyMoneyPrepareUI.b(this.ojH.ojC, this.ojH.iiN);
                    }
                }, 200);
            } else if (this.iiJ) {
                this.ojC.ofs.setVisibility(8);
                ((InputMethodManager) this.ojC.mController.xIM.getSystemService("input_method")).showSoftInput(this.iiL, 0);
            }
        } else if (this.ojC.mKeyboard != null) {
            this.ojC.mKeyboard.setInputEditText(this.iiL);
        }
    }
}
