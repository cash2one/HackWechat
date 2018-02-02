package com.tencent.mm.plugin.wallet.pwd.ui;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.af.a;

class WalletPasswordSettingUI$1 implements a {
    final /* synthetic */ WalletPasswordSettingUI sHq;

    WalletPasswordSettingUI$1(WalletPasswordSettingUI walletPasswordSettingUI) {
        this.sHq = walletPasswordSettingUI;
    }

    public final boolean handleMessage(Message message) {
        switch (message.what) {
            case 1:
                WalletPasswordSettingUI.a(this.sHq);
                break;
            case 2:
                WalletPasswordSettingUI.b(this.sHq);
                break;
        }
        return false;
    }
}
