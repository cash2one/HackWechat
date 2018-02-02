package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.e;
import com.tencent.mm.wallet_core.d.g;

public class k extends c {
    private String mzr;
    private String sIG;
    private int scene;
    private String token;

    public final c a(Activity activity, Bundle bundle) {
        x.i("MicroMsg.WalletJSApiVerifyCodeProcess", "start WalletJSApiVerifyCodeProcess");
        this.sIG = bundle.getString("key_relation_key");
        this.mzr = bundle.getString("key_pwd1");
        this.token = bundle.getString("key_jsapi_token");
        this.scene = bundle.getInt("key_verify_scene");
        c(activity, WalletVerifyCodeUI.class, bundle);
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
    }

    public final void d(Activity activity, int i) {
    }

    public final void b(Activity activity, Bundle bundle) {
        x.i("MicroMsg.WalletJSApiVerifyCodeProcess", "end WalletJSApiVerifyCodeProcess");
        if (this.scene == 8) {
            a(activity, "wallet", ".pay.ui.WalletLoanRepaymentUI", -1, null, false);
            return;
        }
        a(activity, WalletCheckPwdUI.class, -1, null, false);
    }

    public final boolean c(Activity activity, Bundle bundle) {
        return false;
    }

    public final String aKG() {
        return null;
    }

    public final e a(MMActivity mMActivity, g gVar) {
        return new 1(this, mMActivity, gVar, gVar, mMActivity);
    }
}
