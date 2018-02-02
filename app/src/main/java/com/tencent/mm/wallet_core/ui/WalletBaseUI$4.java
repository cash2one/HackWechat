package com.tencent.mm.wallet_core.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.c;

class WalletBaseUI$4 implements OnClickListener {
    final /* synthetic */ WalletBaseUI zJd;

    WalletBaseUI$4(WalletBaseUI walletBaseUI) {
        this.zJd = walletBaseUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zJd.cBZ();
        c ag = a.ag(this.zJd);
        if (ag == null) {
            this.zJd.finish();
        } else if (!ag.h(this.zJd, this.zJd.vf)) {
            ag.b(this.zJd, this.zJd.vf);
        }
    }
}
