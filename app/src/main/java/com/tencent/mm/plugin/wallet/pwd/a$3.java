package com.tencent.mm.plugin.wallet.pwd;

import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wallet.pwd.a.f;
import com.tencent.mm.plugin.wallet.pwd.a.h;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.e;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;

class a$3 extends e {
    final /* synthetic */ a sGp;

    a$3(a aVar, MMActivity mMActivity, g gVar) {
        this.sGp = aVar;
        super(mMActivity, gVar);
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (i != 0 || i2 != 0 || !(kVar instanceof f)) {
            return false;
        }
        a.d(this.sGp).putString("kreq_token", ((f) kVar).token);
        return true;
    }

    public final boolean k(Object... objArr) {
        p pVar = (p) objArr[1];
        pVar.flag = TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL;
        this.zHV.a(new h(pVar), true, 1);
        return true;
    }
}
