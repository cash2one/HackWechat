package com.tencent.mm.plugin.wallet.a;

import com.tencent.mm.g.a.he;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;

public final class i extends c<he> {
    public i() {
        this.xen = he.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        int i = 0;
        he heVar = (he) bVar;
        if (!(heVar instanceof he)) {
            return false;
        }
        heVar.fxq.fxs = o.bLq().bLP();
        String azp = o.bLq().azp();
        if (bh.ov(azp)) {
            heVar.fxq.fxr = "";
        } else {
            String str = "";
            while (i < azp.length() - 1) {
                str = str + "*";
                i++;
            }
            heVar.fxq.fxr = str + azp.substring(azp.length() - 1, azp.length());
        }
        return true;
    }
}
