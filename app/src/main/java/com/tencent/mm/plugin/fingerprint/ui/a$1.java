package com.tencent.mm.plugin.fingerprint.ui;

import com.tencent.mm.ae.k;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.e;
import com.tencent.mm.wallet_core.d.g;

class a$1 extends e {
    final /* synthetic */ a mzN;

    a$1(a aVar, MMActivity mMActivity, g gVar) {
        this.mzN = aVar;
        super(mMActivity, gVar);
    }

    public final boolean k(Object... objArr) {
        a.a(this.mzN).putString("pwd", (String) objArr[0]);
        x.i("MicroMsg.FingerPrintAuthProcess", "this is onNext");
        return false;
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        return false;
    }
}
