package com.tencent.mm.plugin.wallet.balance;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.plugin.wallet_core.b.b;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.c.o;

public class a extends b {
    public static int sxZ = 1;
    public static int sya = 2;

    public final c a(Activity activity, Bundle bundle) {
        o.Hz(14);
        return super.a(activity, bundle);
    }

    public final void d(Activity activity, int i) {
        o.cBv();
        if (activity != null) {
            activity.finish();
        }
    }

    public final void b(Activity activity, Bundle bundle) {
        o.cBv();
        if (bundle == null || !bundle.getBoolean("intent_bind_end", false)) {
            activity.finish();
            return;
        }
        Intent intent = new Intent();
        intent.putExtras(bundle);
        if (bundle.getInt("from_bind_ui", sya) == sxZ) {
            intent.putExtra("from_bind_ui", sxZ);
            a(activity, "wallet", ".balance.ui.WalletBalanceManagerUI", -1, intent, true);
            return;
        }
        intent.putExtra("from_bind_ui", sya);
        a(activity, "wallet", ".balance.ui.ltWalletLqtSaveFetchUI", -1, intent, true);
    }

    public final String aKG() {
        return "BalanceFetchCardProcess";
    }
}
