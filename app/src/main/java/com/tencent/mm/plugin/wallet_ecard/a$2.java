package com.tencent.mm.plugin.wallet_ecard;

import android.content.Context;
import com.tencent.mm.g.a.ld;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class a$2 extends c<ld> {
    final /* synthetic */ a sYN;

    a$2(a aVar) {
        this.sYN = aVar;
        this.xen = ld.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ld ldVar = (ld) bVar;
        int i = 1;
        if (ldVar.fCu.scene > 0) {
            i = ldVar.fCu.scene;
        }
        Context context = (Context) ldVar.fCu.fqH.get();
        if (context != null) {
            com.tencent.mm.plugin.wallet_ecard.a.b.a(i, null, "WEB_DEBIT", null, context, null);
        }
        return false;
    }
}
