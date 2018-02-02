package com.tencent.mm.plugin.wallet.pwd.ui;

import com.tencent.mm.g.a.oh;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tenpay.ndk.Encrypt;

class WalletForgotPwdUI$7 extends c<oh> {
    final /* synthetic */ WalletForgotPwdUI sGW;

    WalletForgotPwdUI$7(WalletForgotPwdUI walletForgotPwdUI) {
        this.sGW = walletForgotPwdUI;
        this.xen = oh.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        oh ohVar = (oh) bVar;
        if (ohVar instanceof oh) {
            Encrypt encrypt = new Encrypt();
            String randomKey = encrypt.getRandomKey();
            WalletForgotPwdUI.a(this.sGW, encrypt.desedeEncode(ohVar.fGh.cardId, randomKey), randomKey, ohVar.fGh.fGi);
            return true;
        }
        x.f("MicroMsg.WalletForgotPwdUI", "mismatched scanBandkCardResultEvent event");
        return false;
    }
}
