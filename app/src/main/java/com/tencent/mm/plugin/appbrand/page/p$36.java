package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.appbrand.report.a;
import com.tencent.mm.sdk.platformtools.bh;

class p$36 implements OnClickListener {
    final /* synthetic */ p jEg;

    p$36(p pVar) {
        this.jEg = pVar;
    }

    public final void onClick(View view) {
        this.jEg.irP.iqC.aiR();
        a.a(this.jEg.mAppId, this.jEg.getURL(), 12, "", bh.Wo(), 1, 0);
    }
}
