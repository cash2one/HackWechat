package com.tencent.mm.plugin.gwallet;

import android.content.Intent;
import com.tencent.mm.plugin.gwallet.a.b.a;
import com.tencent.mm.plugin.gwallet.a.c;
import com.tencent.mm.sdk.platformtools.x;

class GWalletUI$1 implements a {
    final /* synthetic */ GWalletUI nzK;

    GWalletUI$1(GWalletUI gWalletUI) {
        this.nzK = gWalletUI;
    }

    public final void a(c cVar) {
        x.d("MicroMsg.GWalletUI", "Setup finished.");
        if (cVar.isSuccess()) {
            if ("com.tencent.mm.gwallet.ACTION_PAY_REQUEST".equals(this.nzK.getIntent().getAction())) {
                GWalletUI.a(this.nzK);
                return;
            } else {
                this.nzK.fJ(this.nzK.getIntent().getBooleanExtra("is_direct", true));
                return;
            }
        }
        x.e("MicroMsg.GWalletUI", "Problem setting up in-app billing: " + cVar);
        Intent intent = new Intent();
        intent.putExtra("RESPONSE_CODE", cVar.aSn());
        GWalletUI.a(this.nzK, -1, intent);
    }
}
