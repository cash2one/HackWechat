package com.tencent.mm.plugin.wallet_payu.pwd.a;

import android.os.Bundle;
import com.tencent.mm.ae.k;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.e;
import com.tencent.mm.wallet_core.d.g;

public class a extends e {
    private Bundle msB;

    public a(MMActivity mMActivity, g gVar, Bundle bundle) {
        super(mMActivity, gVar);
        this.msB = bundle;
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (kVar instanceof c) {
            c cVar = (c) kVar;
            if (bh.ov(cVar.token)) {
                x.w("MicroMsg.CommonCheckPwdController", "hy: check pwd failed");
            } else {
                x.d("MicroMsg.CommonCheckPwdController", "hy: check pwd pass");
                this.msB.putString("payu_reference", cVar.token);
                com.tencent.mm.wallet_core.a.j(this.zHU, this.msB);
            }
        }
        return false;
    }

    public final boolean k(Object... objArr) {
        this.msB.putString("key_pwd1", (String) objArr[0]);
        this.zHV.a(new c(this.msB.getString("key_pwd1")), true);
        return true;
    }
}
