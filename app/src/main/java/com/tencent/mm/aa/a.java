package com.tencent.mm.aa;

import android.os.Bundle;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelsimple.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public class a implements e, com.tencent.mm.ui.account.h.a {
    public void k(Bundle bundle) {
        String string = bundle.getString("access_token");
        String string2 = bundle.getString("expires");
        x.i("MicroMsg.RefreshTokenListener", "onComplete : newToken = " + string + ", expires = " + string2);
        if (string2 != null) {
            ar.Hg();
            c.CU().set(65832, string2);
        }
        ar.Hg();
        c.CU().set(65830, string);
        ar.Hg();
        c.CU().set(65831, Long.valueOf(System.currentTimeMillis()));
        ar.CG().a(183, this);
        ar.CG().a(new g(2, string), 0);
    }

    public void onError(int i, String str) {
        x.e("MicroMsg.RefreshTokenListener", "onError : errType = " + i + ", errMsg = " + str);
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == 183) {
            ar.CG().b(183, this);
            if (i == 0 && i2 == 0) {
                x.i("MicroMsg.RefreshTokenListener", "update token success");
            } else {
                x.e("MicroMsg.RefreshTokenListener", "update token fail");
            }
        }
    }
}
