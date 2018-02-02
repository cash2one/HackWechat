package com.tencent.mm.plugin.wallet_index.ui;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_index.b.a.a.a;
import com.tencent.mm.plugin.wallet_index.b.a.b;
import com.tencent.mm.plugin.wallet_index.b.a.c;
import com.tencent.mm.plugin.wallet_index.ui.a.1;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

class a$1$1 implements a {
    final /* synthetic */ boolean nzN;
    final /* synthetic */ 1 taI;

    a$1$1(1 1, boolean z) {
        this.taI = 1;
        this.nzN = z;
    }

    public final void a(com.tencent.mm.plugin.wallet_index.c.a aVar, b bVar) {
        x.d("MicroMsg.GoogleWallet", "Query inventory finished.");
        if (aVar.isFailure() || bVar == null) {
            x.w("MicroMsg.GoogleWallet", "Failed to query inventory: " + aVar);
            return;
        }
        x.d("MicroMsg.GoogleWallet", "Query inventory was successful.");
        a.a(this.taI.taH, bVar);
        c c = a.c(this.taI.taH);
        c.taN.addAll(new ArrayList(bVar.tab.keySet()));
        List<c> arrayList = new ArrayList(bVar.tab.values());
        if (arrayList.size() > 0) {
            for (c cVar : arrayList) {
                x.i("MicroMsg.GoogleWallet", "do NetSceneVerifyPurchase. productId:" + cVar.lyH + ",billNo:" + cVar.tah);
                g.Dk();
                g.Di().gPJ.a(a.c(this.taI.taH).a(cVar, true), 0);
            }
            return;
        }
        com.tencent.mm.plugin.wallet_index.c.a aL;
        x.d("MicroMsg.GoogleWallet", "purchases is null. consume null ");
        if (this.nzN) {
            x.d("MicroMsg.GoogleWallet", "result ok");
            aL = com.tencent.mm.plugin.wallet_index.c.a.aL(0, "");
        } else {
            x.d("MicroMsg.GoogleWallet", "unknown_purchase");
            aL = com.tencent.mm.plugin.wallet_index.c.a.aL(5, "");
        }
        if (a.d(this.taI.taH) != null) {
            a.d(this.taI.taH).a(aL, null);
        }
    }
}
