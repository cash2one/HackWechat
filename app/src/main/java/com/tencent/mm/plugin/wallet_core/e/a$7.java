package com.tencent.mm.plugin.wallet_core.e;

import android.content.Context;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;

class a$7 implements e {
    final /* synthetic */ a sYx;
    final /* synthetic */ Context val$context;

    a$7(a aVar, Context context) {
        this.sYx = aVar;
        this.val$context = context;
    }

    public final void a(int i, int i2, String str, k kVar) {
        g.Dk();
        g.Di().gPJ.b(1650, this);
        this.sYx.sYv = null;
        if (this.sYx.sYw != null) {
            this.sYx.b(this.val$context, this.sYx.sYw);
            this.sYx.sYw = null;
        }
    }
}
