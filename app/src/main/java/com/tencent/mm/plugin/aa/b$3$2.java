package com.tencent.mm.plugin.aa;

import android.widget.Toast;
import com.tencent.mm.plugin.aa.a.j;
import com.tencent.mm.plugin.aa.b.3;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;

class b$3$2 implements a<Void, Boolean> {
    final /* synthetic */ j ifD;
    final /* synthetic */ 3 ifE;

    b$3$2(3 3, j jVar) {
        this.ifE = 3;
        this.ifD = jVar;
    }

    public final /* synthetic */ Object call(Object obj) {
        x.i("MicroMsg.SubCoreAA", "close aa success: %s", new Object[]{(Boolean) obj});
        this.ifD.WL().WK();
        Toast.makeText(ac.getContext(), a$i.uIg, 0).show();
        return zBS;
    }
}
