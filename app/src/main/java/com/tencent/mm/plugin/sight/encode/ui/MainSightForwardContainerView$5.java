package com.tencent.mm.plugin.sight.encode.ui;

import com.tencent.mm.g.a.pi;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class MainSightForwardContainerView$5 extends c<pi> {
    final /* synthetic */ MainSightForwardContainerView qwN;

    MainSightForwardContainerView$5(MainSightForwardContainerView mainSightForwardContainerView) {
        this.qwN = mainSightForwardContainerView;
        this.xen = pi.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        pi piVar = (pi) bVar;
        String str = "MicroMsg.MainSightContainerView";
        String str2 = "on sight send result back[%d], type %d, waitSend %B, isForSns %B";
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(hashCode());
        objArr[1] = Integer.valueOf(piVar.fHh.type);
        objArr[2] = Boolean.valueOf(MainSightForwardContainerView.g(this.qwN) != null);
        objArr[3] = Boolean.valueOf(MainSightForwardContainerView.h(this.qwN));
        x.i(str, str2, objArr);
        switch (piVar.fHh.type) {
            case 0:
                MainSightForwardContainerView.i(this.qwN);
                if (!MainSightForwardContainerView.h(this.qwN)) {
                    if (!piVar.fHh.fHj) {
                        this.qwN.postDelayed(new 1(this), 500);
                        break;
                    }
                    g.pQN.h(11443, new Object[]{Integer.valueOf(1), Integer.valueOf(4), Integer.valueOf(0)});
                    this.qwN.ih(true);
                    break;
                }
                if (piVar.fHh.fHj) {
                    g.pQN.h(11443, new Object[]{Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(0)});
                }
                this.qwN.aBM();
                break;
        }
        return false;
    }
}
