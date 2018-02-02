package com.tencent.mm.plugin.aa;

import android.widget.Toast;
import com.tencent.mm.plugin.aa.a.j;
import com.tencent.mm.plugin.aa.b.3;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.g.d.a;

class b$3$1 implements a {
    final /* synthetic */ j ifD;
    final /* synthetic */ 3 ifE;

    b$3$1(3 3, j jVar) {
        this.ifE = 3;
        this.ifD = jVar;
    }

    public final void aW(Object obj) {
        if (obj instanceof String) {
            Toast.makeText(ac.getContext(), obj.toString(), 0).show();
        } else {
            x.e("MicroMsg.SubCoreAA", "close aa failed: %s", new Object[]{obj});
            Toast.makeText(ac.getContext(), i.uIh, 1).show();
        }
        this.ifD.WL().WK();
    }
}
