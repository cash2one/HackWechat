package com.tencent.mm.plugin.fingerprint.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.e;
import com.tencent.mm.wallet_core.d.g;

public class a extends c {
    public final c a(Activity activity, Bundle bundle) {
        x.i("MicroMsg.FingerPrintAuthProcess", "FingerPrintAuthProcess start,forward to WalletCheckPwdUI");
        c(activity, WalletCheckPwdUI.class, bundle);
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        if (activity instanceof WalletCheckPwdUI) {
            x.i("MicroMsg.FingerPrintAuthProcess", "forward to FingerPrintAuthUI");
            c(activity, FingerPrintAuthUI.class, bundle);
        } else if (activity instanceof FingerPrintAuthUI) {
            b(activity, bundle);
        }
    }

    public final void d(Activity activity, int i) {
        b(activity, new Bundle());
    }

    public final void b(Activity activity, Bundle bundle) {
        Intent intent = new Intent();
        x.i("MicroMsg.FingerPrintAuthProcess", "FingerPrintAuthProcess end");
        a(activity, "wallet", ".pwd.ui.WalletPasswordSettingUI", 0, intent, true);
    }

    public final boolean c(Activity activity, Bundle bundle) {
        return false;
    }

    public final String aKG() {
        return "FingerprintAuth";
    }

    public final e a(MMActivity mMActivity, g gVar) {
        if (mMActivity instanceof WalletCheckPwdUI) {
            return new 1(this, mMActivity, gVar);
        }
        return super.a(mMActivity, gVar);
    }
}
