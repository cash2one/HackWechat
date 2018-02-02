package com.tencent.mm.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

class WalletBaseUI$7 implements OnClickListener {
    final /* synthetic */ boolean iiJ;
    final /* synthetic */ EditText iiL;
    final /* synthetic */ int iiN;
    final /* synthetic */ WalletBaseUI zJd;

    WalletBaseUI$7(WalletBaseUI walletBaseUI, boolean z, int i, EditText editText) {
        this.zJd = walletBaseUI;
        this.iiJ = z;
        this.iiN = i;
        this.iiL = editText;
    }

    public final void onClick(View view) {
        if (!this.zJd.ofs.isShown() && !this.iiJ) {
            this.zJd.cCb();
            this.zJd.HB(this.iiN);
        } else if (this.iiJ) {
            this.zJd.Xa();
            ((InputMethodManager) this.zJd.mController.xIM.getSystemService("input_method")).showSoftInput(this.iiL, 0);
        }
    }
}
