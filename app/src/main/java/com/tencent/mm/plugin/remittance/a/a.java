package com.tencent.mm.plugin.remittance.a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.plugin.remittance.ui.RemittanceAdapterUI;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c;

public class a extends c {
    public c a(Activity activity, Bundle bundle) {
        x.d("MicroMsg.RemittanceProcess", "start Process : RemittanceProcess");
        c(activity, RemittanceAdapterUI.class, bundle);
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
    }

    public final void b(Activity activity, Bundle bundle) {
        super.ah(activity);
    }

    public final void d(Activity activity, int i) {
        C(activity);
    }

    public final boolean c(Activity activity, Bundle bundle) {
        return false;
    }

    public final String aKG() {
        return "RemittanceProcess";
    }
}
