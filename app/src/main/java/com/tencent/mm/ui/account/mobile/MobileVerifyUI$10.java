package com.tencent.mm.ui.account.mobile;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

class MobileVerifyUI$10 implements OnEditorActionListener {
    final /* synthetic */ MobileVerifyUI xVi;

    MobileVerifyUI$10(MobileVerifyUI mobileVerifyUI) {
        this.xVi = mobileVerifyUI;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6 && i != 5) {
            return false;
        }
        MobileVerifyUI.e(this.xVi);
        return true;
    }
}
