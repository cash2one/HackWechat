package com.tencent.mm.plugin.wallet_payu.pwd.a;

import android.os.Bundle;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;

class g$1 extends a {
    final /* synthetic */ g tdo;

    g$1(g gVar, MMActivity mMActivity, g gVar2, Bundle bundle) {
        this.tdo = gVar;
        super(mMActivity, gVar2, bundle);
    }

    public final CharSequence um(int i) {
        if (i == 0) {
            return this.zHU.getString(i.uQU);
        }
        return super.um(i);
    }
}
