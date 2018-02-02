package com.tencent.mm.plugin.wallet_index.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.wallet_index.ui.WalletBrandUI.a;

class WalletBrandUI$a$1 implements OnClickListener {
    final /* synthetic */ a tbd;

    WalletBrandUI$a$1(a aVar) {
        this.tbd = aVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.tbd.tbb.setResult(0);
        this.tbd.tbb.finish();
    }
}
