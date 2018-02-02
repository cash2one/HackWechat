package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.view.View;
import com.tencent.mm.plugin.wxpay.a$c;
import com.tencent.mm.pluginsdk.ui.d.m;
import com.tencent.mm.sdk.platformtools.ac;

public final class l extends m {
    private a sVi;

    public l(a aVar) {
        this(aVar, (byte) 0);
    }

    private l(a aVar, byte b) {
        super(2, null);
        this.sVi = aVar;
    }

    public final void onClick(View view) {
        if (this.sVi != null) {
            this.sVi.aze();
        }
    }

    protected final void zs(int i) {
        Context context = ac.getContext();
        super.zs(i);
        if (i == 5) {
            eA(context.getResources().getColor(a$c.white), context.getResources().getColor(a$c.lnH));
        }
    }
}
