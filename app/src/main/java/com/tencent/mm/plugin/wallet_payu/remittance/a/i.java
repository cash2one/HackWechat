package com.tencent.mm.plugin.wallet_payu.remittance.a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.plugin.remittance.a.a;
import com.tencent.mm.plugin.wallet_payu.remittance.ui.PayURemittanceAdapterUI;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c;

public class i extends a {
    public final c a(Activity activity, Bundle bundle) {
        x.d("MicroMsg.PayURemittanceProcess", "start Process : PayURemittanceProcess");
        c(activity, PayURemittanceAdapterUI.class, bundle);
        return this;
    }
}
