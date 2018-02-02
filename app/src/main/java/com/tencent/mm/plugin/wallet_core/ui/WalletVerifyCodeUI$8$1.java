package com.tencent.mm.plugin.wallet_core.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mm.plugin.appbrand.jsapi.av;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI.8;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.a;

class WalletVerifyCodeUI$8$1 implements OnClickListener {
    final /* synthetic */ 8 sWS;

    WalletVerifyCodeUI$8$1(8 8) {
        this.sWS = 8;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.WalletVertifyCodeUI", "forwardProcess2 and finish to reset mobile num!");
        Bundle bundle = this.sWS.sWR.vf;
        bundle.putInt("key_err_code", av.CTRL_INDEX);
        a.j(this.sWS.sWR, bundle);
        this.sWS.sWR.finish();
    }
}
