package com.tencent.mm.wallet_core.ui;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.mm.sdk.platformtools.af;

class WalletBaseUI$6 implements OnFocusChangeListener {
    final /* synthetic */ boolean iiJ;
    final /* synthetic */ boolean iiK;
    final /* synthetic */ EditText iiL;
    final /* synthetic */ View iiM;
    final /* synthetic */ int iiN;
    final /* synthetic */ WalletBaseUI zJd;

    WalletBaseUI$6(WalletBaseUI walletBaseUI, boolean z, boolean z2, View view, EditText editText, int i) {
        this.zJd = walletBaseUI;
        this.iiJ = z;
        this.iiK = z2;
        this.iiM = view;
        this.iiL = editText;
        this.iiN = i;
    }

    public final void onFocusChange(View view, boolean z) {
        if (!view.isFocused() || this.iiJ) {
            new af().postDelayed(new 2(this), 200);
            return;
        }
        ((InputMethodManager) this.zJd.mController.xIM.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
        new af().postDelayed(new 1(this, view), 300);
    }
}
