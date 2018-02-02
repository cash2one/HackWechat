package com.tencent.mm.plugin.wallet.pay.ui;

import com.tencent.mm.plugin.wallet.a.h;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI.27;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.ui.a;
import com.tencent.mm.plugin.wallet_core.ui.i.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.t;

class WalletPayUI$27$1 implements b {
    final /* synthetic */ 27 sGl;

    WalletPayUI$27$1(27 27) {
        this.sGl = 27;
    }

    public final void a(FavorPayInfo favorPayInfo) {
        this.sGl.sGh.sEQ = favorPayInfo;
        String str = "MicroMsg.WalletPayUI";
        String str2 = "WalletFavorDialog onSelectionDone %s";
        Object[] objArr = new Object[1];
        objArr[0] = favorPayInfo == null ? "" : favorPayInfo.toString();
        x.i(str, str2, objArr);
        if (this.sGl.sGh.sEQ != null) {
            int i;
            boolean z;
            if (this.sGl.sGh.sEO == null) {
                i = 0;
            } else {
                i = this.sGl.sGh.sEO.fCV;
            }
            if (this.sGl.sGh.sEO == null) {
                str = "";
            } else {
                str = this.sGl.sGh.sEO.fuH;
            }
            t.d(i, str, 15, this.sGl.sGh.sEQ.sMT);
            if (this.sGl.sGh.szl == null || a.a(this.sGl.sGh.sEQ, this.sGl.sGh.szl)) {
                this.sGl.sGh.sFM.setVisibility(8);
                this.sGl.sGh.pNB.setOnClickListener(new 1(this));
                z = true;
            } else {
                h Ni = this.sGl.sGh.sFy.Ni(this.sGl.sGh.sEQ.sMT);
                if (Ni != null && this.sGl.sGh.szl.bKP()) {
                    p.bJN();
                    Bankcard bankcard = p.bJO().szU;
                    double d = Ni.sDp;
                    if (bankcard != null && bankcard.sLf < d) {
                        x.i("MicroMsg.WalletPayUI", "balance not meet");
                        this.sGl.sGh.sFM.setVisibility(8);
                        this.sGl.sGh.pNB.setOnClickListener(new 2(this));
                        z = true;
                    }
                }
                z = false;
            }
            x.i("MicroMsg.WalletPayUI", "needBindBankCard %s", new Object[]{Boolean.valueOf(z)});
            if (!z) {
                this.sGl.sGh.sFL.setVisibility(8);
                this.sGl.sGh.sFM.setVisibility(0);
                this.sGl.sGh.pNB.setOnClickListener(new 3(this));
            }
            this.sGl.sGh.bKl();
        }
    }
}
