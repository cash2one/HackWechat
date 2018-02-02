package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.launching.precondition.g;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.a;
import com.tencent.mm.sdk.platformtools.ag;

class p$2 implements a {
    final /* synthetic */ p jEg;

    p$2(p pVar) {
        this.jEg = pVar;
    }

    public final boolean a(View view, com.tencent.mm.plugin.appbrand.widget.recentview.a aVar, float f, float f2) {
        ag.h(new Runnable(this) {
            final /* synthetic */ p$2 jEh;

            {
                this.jEh = r1;
            }

            public final void run() {
                this.jEh.jEg.jDP.dismiss();
            }
        }, 100);
        if (aVar.type != 1) {
            return false;
        }
        LocalUsageInfo localUsageInfo = aVar.kfb;
        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
        appBrandStatObject.scene = 1090;
        appBrandStatObject.fnp = this.jEg.mAppId;
        g.jzg.a(this.jEg.mContext, localUsageInfo.username, null, null, localUsageInfo.iKd, -1, appBrandStatObject, null, null);
        return true;
    }

    public final boolean b(View view, com.tencent.mm.plugin.appbrand.widget.recentview.a aVar, float f, float f2) {
        return false;
    }
}
