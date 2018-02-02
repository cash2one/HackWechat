package com.tencent.mm.plugin.address.b.b;

import android.app.Dialog;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;

public final class a implements e {
    private HashSet<k> ilQ;
    private HashSet<k> ilR;
    private Dialog ilS;

    public final void a(int i, int i2, String str, k kVar) {
        if (this.ilR.contains(kVar)) {
            this.ilR.remove(kVar);
            x.d("MicroMsg.InvoiceNetSceneMgr", "has find scene ");
        } else if (this.ilQ.contains(kVar)) {
            this.ilQ.remove(kVar);
            x.d("MicroMsg.InvoiceNetSceneMgr", "has find forcescenes ");
        }
        if (this.ilR.isEmpty() && this.ilQ.isEmpty() && this.ilS != null) {
            this.ilS.dismiss();
            this.ilS = null;
        }
    }
}
