package com.tencent.mm.wallet_core.ui;

import android.view.inputmethod.InputMethodManager;
import com.tencent.mm.wallet_core.ui.WalletBaseUI.6;

class WalletBaseUI$6$2 implements Runnable {
    final /* synthetic */ 6 zJe;

    WalletBaseUI$6$2(6 6) {
        this.zJe = 6;
    }

    public final void run() {
        this.zJe.zJd.Xa();
        if (this.zJe.iiJ) {
            ((InputMethodManager) this.zJe.zJd.mController.xIM.getSystemService("input_method")).showSoftInput(this.zJe.iiL, 0);
        }
    }
}
