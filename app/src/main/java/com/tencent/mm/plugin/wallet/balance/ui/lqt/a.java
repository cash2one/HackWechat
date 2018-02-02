package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import com.tencent.mm.pluginsdk.ui.d.m;

public final class a extends m {
    private a sAo;

    public a(a aVar) {
        super(2, null);
        this.sAo = aVar;
    }

    public final void onClick(View view) {
        if (this.sAo != null) {
            this.sAo.WO();
        }
    }
}
