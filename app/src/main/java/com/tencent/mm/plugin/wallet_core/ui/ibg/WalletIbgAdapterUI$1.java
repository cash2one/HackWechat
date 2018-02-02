package com.tencent.mm.plugin.wallet_core.ui.ibg;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.model.x.a;

class WalletIbgAdapterUI$1 implements OnClickListener {
    final /* synthetic */ WalletIbgAdapterUI sWZ;

    WalletIbgAdapterUI$1(WalletIbgAdapterUI walletIbgAdapterUI) {
        this.sWZ = walletIbgAdapterUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        a.eg(this.sWZ);
        Toast.makeText(this.sWZ, this.sWZ.getString(i.uYn), 1).show();
        this.sWZ.finish();
    }
}
