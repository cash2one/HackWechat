package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import com.tencent.mm.g.a.kg;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class FlipView$6 extends c<kg> {
    final /* synthetic */ FlipView rsJ;

    FlipView$6(FlipView flipView) {
        this.rsJ = flipView;
        this.xen = kg.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        kg kgVar = (kg) bVar;
        if (FlipView.i(this.rsJ)) {
            if (kgVar != null && (kgVar instanceof kg)) {
                x.i("MicroMsg.FlipView", "notify Event: %d", new Object[]{Integer.valueOf(kgVar.fBC.fBA)});
                if (kgVar.fBC.activity == ((Activity) FlipView.e(this.rsJ)) && kgVar.fBC.fov.equals(FlipView.f(this.rsJ))) {
                    switch (kgVar.fBC.fBA) {
                        case 0:
                        case 1:
                        case 2:
                            break;
                        case 3:
                            ((Activity) FlipView.e(this.rsJ)).finish();
                            break;
                        default:
                            break;
                    }
                }
                x.e("MicroMsg.FlipView", "not the same");
            } else {
                x.e("MicroMsg.FlipView", "event is null or not a instant of NotifyDealQBarStrResultEvent");
            }
        } else {
            x.i("MicroMsg.FlipView", "no need to scan image");
        }
        return false;
    }
}
