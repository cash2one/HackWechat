package com.tencent.mm.plugin.wallet_payu.security_question.model;

import android.os.Bundle;
import com.tencent.mm.ae.k;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.e;
import com.tencent.mm.wallet_core.d.g;

public final class a extends e {
    private Bundle msB;

    public a(MMActivity mMActivity, g gVar, Bundle bundle) {
        super(mMActivity, gVar);
        this.msB = bundle;
    }

    public final boolean p(Object... objArr) {
        this.zHV.a(new c(this.msB.getString("payu_reference")), true);
        return true;
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if ((kVar instanceof c) && i == 0 && i2 == 0) {
            c cVar = (c) kVar;
            this.msB.putParcelable("key_security_question", new PayUSecurityQuestion(cVar.id, cVar.tdH));
            return false;
        } else if (!(kVar instanceof b)) {
            return false;
        } else {
            b bVar = (b) kVar;
            if (i != 0 || i2 != 0 || !bVar.mfl) {
                return false;
            }
            this.msB.putString("payu_reference", bVar.tdG);
            com.tencent.mm.wallet_core.a.j(this.zHU, this.msB);
            return true;
        }
    }

    public final boolean k(Object... objArr) {
        PayUSecurityQuestion payUSecurityQuestion = (PayUSecurityQuestion) this.msB.getParcelable("key_security_question");
        String string = this.msB.getString("key_question_answer");
        this.zHV.a(new b(this.msB.getString("payu_reference"), payUSecurityQuestion.id, string), true);
        return false;
    }
}
