package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.wallet_core.c;

public class b extends com.tencent.mm.plugin.wallet_core.b.b {
    public final c a(Activity activity, Bundle bundle) {
        return super.a(activity, bundle);
    }

    public final void d(Activity activity, int i) {
        if (activity != null) {
            activity.finish();
        }
    }

    public final void b(Activity activity, Bundle bundle) {
        if (bundle == null || !bundle.getBoolean("intent_bind_end", false)) {
            activity.finish();
            return;
        }
        Activity activity2 = activity;
        a(activity2, "wallet", ".balance.ui.lqt.WalletLqtSaveFetchUI", -1, new Intent(), true);
    }

    public final String aKG() {
        return "BalanceFetchCardProcess";
    }
}
