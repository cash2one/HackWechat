package com.tencent.mm.plugin.appbrand.widget.recentview;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.r;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

class BaseAppBrandRecentView$c implements Runnable {
    final /* synthetic */ BaseAppBrandRecentView kfw;

    private BaseAppBrandRecentView$c(BaseAppBrandRecentView baseAppBrandRecentView) {
        this.kfw = baseAppBrandRecentView;
    }

    public final void run() {
        r rVar = (r) g.h(r.class);
        this.kfw.anX();
        List<LocalUsageInfo> jE = rVar.jE(12);
        this.kfw.anY().clear();
        if (jE != null) {
            LocalUsageInfo aje = this.kfw.kfd != null ? this.kfw.kfd.aje() : null;
            for (LocalUsageInfo localUsageInfo : jE) {
                if (aje == null || !localUsageInfo.username.equals(aje.username) || localUsageInfo.iKd != aje.iKd) {
                    this.kfw.anY().add(new a(localUsageInfo));
                    if (this.kfw.anY().size() > this.kfw.anX()) {
                        break;
                    }
                }
            }
        }
        this.kfw.af(this.kfw.anY());
        x.i("MicroMsg.BaseAppBrandRecentView", "[UpdateAppBrandRecentDataTask] type:%s data size:%s", new Object[]{this.kfw.getType(), Integer.valueOf(this.kfw.anY().size())});
        ag.y(new 1(this));
    }
}
