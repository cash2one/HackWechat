package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.mm.g.a.oh;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tenpay.ndk.Encrypt;

class WalletBankcardIdUI$2 extends c<oh> {
    final /* synthetic */ WalletBankcardIdUI sRo;

    WalletBankcardIdUI$2(WalletBankcardIdUI walletBankcardIdUI) {
        this.sRo = walletBankcardIdUI;
        this.xen = oh.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        oh ohVar = (oh) bVar;
        if (ohVar instanceof oh) {
            Encrypt encrypt = new Encrypt();
            String randomKey = encrypt.getRandomKey();
            WalletBankcardIdUI.a(this.sRo, encrypt.desedeEncode(ohVar.fGh.cardId, randomKey), randomKey, ohVar.fGh.fGi);
            this.sRo.finish();
            return true;
        }
        x.f("Micromsg.WalletInputCardIDUI", "mismatched scanBandkCardResultEvent event");
        return false;
    }
}
