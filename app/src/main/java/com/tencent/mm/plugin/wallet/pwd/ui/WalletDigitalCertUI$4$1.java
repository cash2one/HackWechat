package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.wallet.pwd.ui.WalletDigitalCertUI.4;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.e;
import com.tencent.mm.wallet_core.c.q;

class WalletDigitalCertUI$4$1 implements OnClickListener {
    final /* synthetic */ q sGM;
    final /* synthetic */ 4 sGN;

    WalletDigitalCertUI$4$1(4 4, q qVar) {
        this.sGN = 4;
        this.sGM = qVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.WalletDigitalCertUI", "del crt %s", this.sGM.wQi);
        this.sGN.sGL.l(new e(this.sGM.wQi));
    }
}
