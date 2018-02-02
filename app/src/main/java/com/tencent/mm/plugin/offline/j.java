package com.tencent.mm.plugin.offline;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoUI;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.wallet_core.c;

public class j extends c {
    public final c a(Activity activity, Bundle bundle) {
        String str;
        String str2 = "";
        if (bundle != null) {
            if (bh.ov(bundle.getString("key_trans_id"))) {
                Orders orders = (Orders) bundle.getParcelable("key_orders");
                if (!(orders == null || orders.sNW == null || orders.sNW.size() <= 0)) {
                    str = ((Commodity) orders.sNW.get(0)).fuI;
                }
            } else {
                str = "key_trans_id";
            }
            g.Dk();
            g.Di().gPJ.a(new com.tencent.mm.plugin.offline.a.g("offlineshowpage", "push", str), 0);
            c(activity, WalletOrderInfoUI.class, bundle);
            g.Dk();
            g.Dj().CU().a(a.USERINFO_ADDRESS_HAS_SHOW_WALLETOFFLINE2_DIALOG_BOOLEAN_SYNC, Boolean.valueOf(true));
            return this;
        }
        str = str2;
        g.Dk();
        g.Di().gPJ.a(new com.tencent.mm.plugin.offline.a.g("offlineshowpage", "push", str), 0);
        c(activity, WalletOrderInfoUI.class, bundle);
        g.Dk();
        g.Dj().CU().a(a.USERINFO_ADDRESS_HAS_SHOW_WALLETOFFLINE2_DIALOG_BOOLEAN_SYNC, Boolean.valueOf(true));
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        if (activity instanceof WalletOrderInfoUI) {
            C(activity);
        }
    }

    public final void d(Activity activity, int i) {
        C(activity);
    }

    public final void b(Activity activity, Bundle bundle) {
        ah(activity);
    }

    public final boolean c(Activity activity, Bundle bundle) {
        return false;
    }

    public final String aKG() {
        return "ShowOrderSuccessProcess";
    }
}
