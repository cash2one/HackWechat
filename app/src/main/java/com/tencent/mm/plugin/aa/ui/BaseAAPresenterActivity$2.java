package com.tencent.mm.plugin.aa.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

class BaseAAPresenterActivity$2 implements OnClickListener {
    final /* synthetic */ boolean iiJ;
    final /* synthetic */ EditText iiL;
    final /* synthetic */ int iiN;
    final /* synthetic */ BaseAAPresenterActivity iiO;

    BaseAAPresenterActivity$2(BaseAAPresenterActivity baseAAPresenterActivity, boolean z, EditText editText, int i) {
        this.iiO = baseAAPresenterActivity;
        this.iiJ = z;
        this.iiL = editText;
        this.iiN = i;
    }

    public final void onClick(View view) {
        if (!BaseAAPresenterActivity.h(this.iiO).isShown() && !this.iiJ) {
            this.iiO.cCb();
            BaseAAPresenterActivity.a(this.iiO, this.iiL);
            BaseAAPresenterActivity.b(this.iiO, this.iiN);
        } else if (this.iiJ) {
            this.iiO.Xa();
            ((InputMethodManager) this.iiO.mController.xIM.getSystemService("input_method")).showSoftInput(this.iiL, 0);
        }
    }
}
