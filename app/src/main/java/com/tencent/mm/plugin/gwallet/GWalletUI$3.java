package com.tencent.mm.plugin.gwallet;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.gwallet.a.b.2;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.af;
import java.util.List;

class GWalletUI$3 extends BroadcastReceiver {
    final /* synthetic */ GWalletUI nzK;

    GWalletUI$3(GWalletUI gWalletUI) {
        this.nzK = gWalletUI;
    }

    public final void onReceive(Context context, Intent intent) {
        if ("com.tencent.mm.gwallet.ACTION_CONSUME_REQUEST".equals(intent.getAction())) {
            List stringArrayListExtra = intent.getStringArrayListExtra("tokens");
            boolean booleanExtra = intent.getBooleanExtra("IS_FAILED_CONSUME", false);
            if (stringArrayListExtra == null || stringArrayListExtra.size() == 0) {
                GWalletUI.a(this.nzK, 0, null);
            } else {
                e.post(new 2(GWalletUI.b(this.nzK), stringArrayListExtra, new 1(this, booleanExtra), new af()), "IabHelper_consumeAsync");
            }
        }
    }
}
