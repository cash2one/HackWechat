package com.tencent.mm.plugin.wallet_payu.create.a;

import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wallet_payu.security_question.model.d;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.e;
import com.tencent.mm.wallet_core.d.g;

class c$3 extends e {
    final /* synthetic */ c tca;

    c$3(c cVar, MMActivity mMActivity, g gVar) {
        this.tca = cVar;
        super(mMActivity, gVar);
    }

    public final boolean p(Object... objArr) {
        this.zHV.a(new d(), true);
        return false;
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (!(kVar instanceof d) || i != 0 || i2 != 0) {
            return false;
        }
        this.tca.msB.putParcelableArrayList("key_security_question_list", ((d) kVar).tdI);
        return true;
    }

    public final boolean k(Object... objArr) {
        return false;
    }
}
