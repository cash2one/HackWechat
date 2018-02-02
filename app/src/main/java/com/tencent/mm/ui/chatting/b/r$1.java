package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.pluginsdk.g.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h.c;

class r$1 implements c {
    final /* synthetic */ r yAB;

    public r$1(r rVar) {
        this.yAB = rVar;
    }

    public final void jl(int i) {
        switch (i) {
            case 0:
                x.d("MicroMsg.ChattingUI.LocationImp", "summerper checkPermission checkLocation[%b]", new Object[]{Boolean.valueOf(a.a(this.yAB.fhr.csq().thisActivity(), "android.permission.ACCESS_COARSE_LOCATION", 67, null, null))});
                if (a.a(this.yAB.fhr.csq().thisActivity(), "android.permission.ACCESS_COARSE_LOCATION", 67, null, null)) {
                    this.yAB.ctS();
                    return;
                }
                return;
            case 1:
                x.d("MicroMsg.ChattingUI.LocationImp", "summerper checkPermission checkLocation[%b]", new Object[]{Boolean.valueOf(a.a(this.yAB.fhr.csq().thisActivity(), "android.permission.ACCESS_COARSE_LOCATION", 68, null, null))});
                if (a.a(this.yAB.fhr.csq().thisActivity(), "android.permission.ACCESS_COARSE_LOCATION", 68, null, null)) {
                    this.yAB.ctT();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
