package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mm.plugin.appbrand.report.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class p$3 implements OnLongClickListener {
    final /* synthetic */ p jEg;

    p$3(p pVar) {
        this.jEg = pVar;
    }

    public final boolean onLongClick(View view) {
        if (!(this.jEg.irP.iqH.scene == 1086 || this.jEg.jDO == null)) {
            if (this.jEg.jDO.getCount() > 0) {
                this.jEg.jDO.refresh();
                this.jEg.jDP.showAsDropDown(view);
                a.a(this.jEg.mAppId, this.jEg.getURL(), 21, "", bh.Wo(), 1, 0);
            } else {
                x.i("MicroMsg.AppBrandPageView", "AppBrandRecentView getCount < 0, appId: %s", new Object[]{this.jEg.mAppId});
            }
        }
        return true;
    }
}
