package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.appbrand.c;
import com.tencent.mm.plugin.appbrand.report.a;
import com.tencent.mm.sdk.platformtools.bh;

class p$33 implements OnClickListener {
    final /* synthetic */ p jEg;

    p$33(p pVar) {
        this.jEg = pVar;
    }

    public final void onClick(View view) {
        c.a(this.jEg.mAppId, c.c.iqj);
        this.jEg.irP.close();
        a.a(this.jEg.mAppId, this.jEg.getURL(), 22, "", bh.Wo(), 1, 0);
    }
}
