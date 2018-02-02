package com.tencent.mm.plugin.messenger.a;

import android.view.View;
import com.tencent.mm.pluginsdk.ui.applet.k;
import com.tencent.mm.pluginsdk.ui.d.m;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public abstract class a extends m {
    private long oon = -1;

    public abstract void bJ(View view);

    public a(int i, k kVar) {
        super(1, null);
    }

    public void onClick(View view) {
        if (bh.bA(this.oon) > 1000) {
            super.onClick(view);
            bJ(view);
        } else {
            x.w("MicroMsg.AvoidDuplicatedPressableSpan", "hy: too often click");
            this.ozA = false;
        }
        this.oon = bh.Wq();
    }
}
