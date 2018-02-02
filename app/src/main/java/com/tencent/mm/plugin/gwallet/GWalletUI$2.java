package com.tencent.mm.plugin.gwallet;

import android.content.Intent;
import com.jg.EType;
import com.jg.JgMethodChecked;
import com.tencent.mm.plugin.gwallet.a.b.b;
import com.tencent.mm.plugin.gwallet.a.c;
import com.tencent.mm.sdk.platformtools.x;

class GWalletUI$2 implements b {
    final /* synthetic */ GWalletUI nzK;

    GWalletUI$2(GWalletUI gWalletUI) {
        this.nzK = gWalletUI;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @JgMethodChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.INTENTCHECK})
    public final void b(c cVar, Intent intent) {
        int i = 1;
        x.d("MicroMsg.GWalletUI", "Purchase finished: " + cVar + ", purchase: " + intent);
        if (intent == null) {
            intent = new Intent("com.tencent.mm.gwallet.ACTION_PAY_RESPONSE");
            intent.putExtra("RESPONSE_CODE", cVar.aSn());
        } else {
            intent.setAction("com.tencent.mm.gwallet.ACTION_PAY_RESPONSE");
        }
        this.nzK.sendBroadcast(intent);
        if (!cVar.isSuccess()) {
            int i2;
            if (cVar.nAh == 7) {
                i2 = 1;
            } else {
                i2 = 0;
            }
        }
        i = 0;
        if (i != 0) {
            GWalletUI.a(this.nzK, 0, null);
        }
    }
}
