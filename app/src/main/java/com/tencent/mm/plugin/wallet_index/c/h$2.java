package com.tencent.mm.plugin.wallet_index.c;

import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.lm;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class h$2 extends c<lm> {
    final /* synthetic */ h tax;

    h$2(h hVar) {
        this.tax = hVar;
        this.xen = lm.class.getName().hashCode();
    }

    private boolean a(lm lmVar) {
        this.tax.tat = lmVar;
        String str = lmVar.fCP.url;
        int i = lmVar.fCP.scene;
        int i2 = lmVar.fCP.fCR;
        int i3 = lmVar.fCP.fqd;
        String str2 = lmVar.fCP.bhd == null ? "" : lmVar.fCP.bhd;
        this.tax.taq = 1;
        x.d("MicroMsg.WalletGetA8KeyRedirectListener", "auth native, url: %s, a8key_scene: %d, channel: %d, sourceType: %d, source: %s", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str2});
        k kVar = new com.tencent.mm.wallet_core.tenpay.model.k(str, i, this.tax.taq, i2, i3, str2);
        g.Dk();
        g.Di().gPJ.a(385, this.tax);
        g.Dk();
        g.Di().gPJ.a(kVar, 0);
        return false;
    }
}
