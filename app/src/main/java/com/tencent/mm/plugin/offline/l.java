package com.tencent.mm.plugin.offline;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.wallet_core.c;

public class l extends c {
    public final c a(Activity activity, Bundle bundle) {
        c(activity, WalletVerifyCodeUI.class, bundle);
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        if (activity instanceof WalletVerifyCodeUI) {
            b(activity, bundle);
        }
    }

    public final void d(Activity activity, int i) {
    }

    public final void b(Activity activity, Bundle bundle) {
        Intent intent = new Intent(activity, WalletOfflineCoinPurseUI.class);
        intent.addFlags(67108864);
        activity.startActivity(intent);
    }

    public final boolean c(Activity activity, Bundle bundle) {
        return false;
    }

    public final String aKG() {
        return "VerifyProcess";
    }
}
