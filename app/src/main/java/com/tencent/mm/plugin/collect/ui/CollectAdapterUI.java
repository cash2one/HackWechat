package com.tencent.mm.plugin.collect.ui;

import android.os.Bundle;
import com.tencent.mm.ae.k;
import com.tencent.mm.bm.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(7)
public class CollectAdapterUI extends WalletBaseUI {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        uD(8);
        g.Dk();
        x.i("MicroMsg.CollectAdapterUI", "walletRegion: %s", new Object[]{Integer.valueOf(((Integer) g.Dj().CU().get(w.a.xrD, Integer.valueOf(0))).intValue())});
        if (((Integer) g.Dj().CU().get(w.a.xrD, Integer.valueOf(0))).intValue() == 8) {
            d.b(this, "collect", ".ui.CollectHKMainUI", getIntent());
        } else {
            d.b(this, "collect", ".ui.CollectMainUI", getIntent());
        }
        finish();
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        return false;
    }

    protected final int getLayoutId() {
        return -1;
    }
}
