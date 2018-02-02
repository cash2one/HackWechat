package com.tencent.mm.plugin.luckymoney.sns;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.g.a.py;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.e;
import com.tencent.mm.wallet_core.d.g;

public class a extends c {
    static /* synthetic */ void sa(int i) {
        b pyVar = new py();
        pyVar.fHF.key = i;
        pyVar.fHF.value = 1;
        pyVar.fHF.fHG = true;
        com.tencent.mm.sdk.b.a.xef.m(pyVar);
    }

    public final c a(Activity activity, Bundle bundle) {
        if (activity instanceof SnsLuckyMoneyFreePwdSetting) {
            c(activity, WalletCheckPwdUI.class, bundle);
        }
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        b(activity, bundle);
    }

    public final void d(Activity activity, int i) {
        b(activity, null);
    }

    public final void b(Activity activity, Bundle bundle) {
        Intent intent = new Intent();
        if (bundle == null) {
            bundle = new Bundle();
        }
        intent.putExtras(bundle);
        a(activity, "luckymoney", ".sns.SnsLuckyMoneyFreePwdSetting", -1, intent, true);
    }

    public final boolean c(Activity activity, Bundle bundle) {
        return false;
    }

    public final String aKG() {
        return "LuckyFreePwdProcess";
    }

    public final e a(MMActivity mMActivity, g gVar) {
        return mMActivity instanceof WalletCheckPwdUI ? new 1(this, mMActivity, gVar) : super.a(mMActivity, gVar);
    }
}
