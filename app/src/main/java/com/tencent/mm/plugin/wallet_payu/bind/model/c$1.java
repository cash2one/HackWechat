package com.tencent.mm.plugin.wallet_payu.bind.model;

import android.os.Bundle;
import com.tencent.mm.plugin.wallet_payu.pwd.a.a;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;

class c$1 extends a {
    final /* synthetic */ c tbD;

    c$1(c cVar, MMActivity mMActivity, g gVar, Bundle bundle) {
        this.tbD = cVar;
        super(mMActivity, gVar, bundle);
    }

    public final CharSequence um(int i) {
        if (i == 0) {
            return this.zHU.getString(i.uQQ);
        }
        return super.um(i);
    }
}
