package com.tencent.mm.wallet_core.ui;

import android.os.Build.VERSION;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.mm.ui.a.c;
import com.tencent.mm.wallet_core.ui.WalletBaseUI.6;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.z.q;

class WalletBaseUI$6$1 implements Runnable {
    final /* synthetic */ 6 zJe;
    final /* synthetic */ View zS;

    WalletBaseUI$6$1(6 6, View view) {
        this.zJe = 6;
        this.zS = view;
    }

    public final void run() {
        if (!this.zJe.zJd.ofs.isShown() && this.zS.isShown() && (this.zJe.iiK || this.zJe.zJd.zJc)) {
            this.zJe.zJd.zJc = true;
            this.zJe.zJd.cCb();
        }
        if ((this.zJe.iiM instanceof WalletFormView) && VERSION.SDK_INT >= 14) {
            WalletFormView walletFormView = (WalletFormView) this.zJe.iiM;
            if ((q.Gf() || walletFormView.zJL == 100) && (!q.Gf() || walletFormView.zJL == 0)) {
                this.zJe.zJd.mKeyboard.resetSecureAccessibility();
                this.zJe.iiL.setAccessibilityDelegate(null);
            } else {
                AccessibilityDelegate cVar = new c();
                this.zJe.zJd.mKeyboard.setSecureAccessibility(cVar);
                this.zJe.iiL.setAccessibilityDelegate(cVar);
            }
        }
        if ((this.zJe.iiM instanceof EditHintPasswdView) && VERSION.SDK_INT >= 14) {
            cVar = new c();
            this.zJe.zJd.mKeyboard.setSecureAccessibility(cVar);
            this.zJe.iiL.setAccessibilityDelegate(cVar);
        }
        this.zJe.zJd.HB(this.zJe.iiN);
        this.zJe.zJd.mKeyboard.setInputEditText((EditText) this.zS);
        ((InputMethodManager) this.zJe.zJd.mController.xIM.getSystemService("input_method")).hideSoftInputFromWindow(this.zS.getWindowToken(), 0);
    }
}
