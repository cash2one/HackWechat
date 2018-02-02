package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.g.a.bo;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;

class WalletPasswordSettingUI$5 implements OnClickListener {
    final /* synthetic */ WalletPasswordSettingUI sHq;

    WalletPasswordSettingUI$5(WalletPasswordSettingUI walletPasswordSettingUI) {
        this.sHq = walletPasswordSettingUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        b boVar = new bo();
        boVar.fqI = new 1(this, boVar);
        a.xef.a(boVar, this.sHq.getMainLooper());
    }
}
