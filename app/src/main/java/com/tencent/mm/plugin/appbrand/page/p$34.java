package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import android.view.View.OnClickListener;

class p$34 implements OnClickListener {
    final /* synthetic */ p jEg;

    p$34(p pVar) {
        this.jEg = pVar;
    }

    public final void onClick(View view) {
        t tVar = this.jEg.jDS;
        tVar.getView().scrollTo(tVar.getView().getScrollX(), 0);
        j.aG(this.jEg.mAppId, this.jEg.hashCode());
    }
}
