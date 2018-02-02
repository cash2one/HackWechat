package com.tencent.mm.plugin.wallet_index.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;

class WalletBrandUI$1 implements OnCancelListener {
    final /* synthetic */ k flZ;
    final /* synthetic */ WalletBrandUI tbb;

    WalletBrandUI$1(WalletBrandUI walletBrandUI, k kVar) {
        this.tbb = walletBrandUI;
        this.flZ = kVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.Dk();
        g.Di().gPJ.c(this.flZ);
        this.tbb.finish();
    }
}
