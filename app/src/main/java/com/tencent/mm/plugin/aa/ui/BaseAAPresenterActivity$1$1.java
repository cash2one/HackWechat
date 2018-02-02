package com.tencent.mm.plugin.aa.ui;

import android.os.Build.VERSION;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.mm.plugin.aa.ui.BaseAAPresenterActivity.1;
import com.tencent.mm.ui.a.c;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.z.q;

class BaseAAPresenterActivity$1$1 implements Runnable {
    final /* synthetic */ 1 iiP;
    final /* synthetic */ View zS;

    BaseAAPresenterActivity$1$1(1 1, View view) {
        this.iiP = 1;
        this.zS = view;
    }

    public final void run() {
        if (!BaseAAPresenterActivity.a(this.iiP.iiO).isShown() && this.zS.isShown()) {
            if (this.iiP.iiK) {
                this.iiP.iiO.cCb();
            } else if (!BaseAAPresenterActivity.b(this.iiP.iiO)) {
                this.iiP.iiO.cCb();
            }
            BaseAAPresenterActivity.c(this.iiP.iiO);
            BaseAAPresenterActivity.a(this.iiP.iiO, this.iiP.iiL);
        }
        if ((this.iiP.iiM instanceof WalletFormView) && VERSION.SDK_INT >= 14) {
            WalletFormView walletFormView = (WalletFormView) this.iiP.iiM;
            if ((q.Gf() || walletFormView.zJL == 100) && (!q.Gf() || walletFormView.zJL == 0)) {
                BaseAAPresenterActivity.e(this.iiP.iiO).resetSecureAccessibility();
                this.iiP.iiL.setAccessibilityDelegate(null);
            } else {
                AccessibilityDelegate cVar = new c();
                BaseAAPresenterActivity.d(this.iiP.iiO).setSecureAccessibility(cVar);
                this.iiP.iiL.setAccessibilityDelegate(cVar);
            }
        }
        if ((this.iiP.iiM instanceof EditHintPasswdView) && VERSION.SDK_INT >= 14) {
            cVar = new c();
            BaseAAPresenterActivity.f(this.iiP.iiO).setSecureAccessibility(cVar);
            this.iiP.iiL.setAccessibilityDelegate(cVar);
        }
        BaseAAPresenterActivity.a(this.iiP.iiO, this.iiP.iiN);
        BaseAAPresenterActivity.g(this.iiP.iiO).setInputEditText((EditText) this.zS);
        ((InputMethodManager) this.iiP.iiO.mController.xIM.getSystemService("input_method")).hideSoftInputFromWindow(this.zS.getWindowToken(), 0);
    }
}
