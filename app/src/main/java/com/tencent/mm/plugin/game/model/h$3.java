package com.tencent.mm.plugin.game.model;

import com.tencent.mm.aq.a.c.c;
import com.tencent.mm.plugin.game.model.h.a;
import com.tencent.mm.protocal.c.aqy;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

class h$3 implements c {
    final /* synthetic */ aqy nbB;
    final /* synthetic */ List nbC;
    final /* synthetic */ a nbD;

    h$3(aqy com_tencent_mm_protocal_c_aqy, List list, a aVar) {
        this.nbB = com_tencent_mm_protocal_c_aqy;
        this.nbC = list;
        this.nbD = aVar;
    }

    public final void a(boolean z, Object... objArr) {
        if (z) {
            x.i("MicroMsg.GameCommOpertionProcessor", "menu icon download success! thumburl:%s", new Object[]{this.nbB.pbP});
            h.b(this.nbC, this.nbD);
        }
    }
}
