package com.tencent.mm.ui.chatting;

import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.plugin.biz.a.a;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.k.2;
import com.tencent.mm.y.i;
import com.tencent.mm.y.m;
import java.util.List;

class k$1 implements Runnable {
    final /* synthetic */ List juo;

    k$1(List list) {
        this.juo = list;
    }

    public final void run() {
        List<au> list = this.juo;
        if (!bh.cA(list)) {
            for (au auVar : list) {
                if (auVar.ciV()) {
                    List<m> list2 = ((a) g.h(a.class)).vL(auVar.field_content).hdX;
                    if (list2 != null) {
                        for (m mVar : list2) {
                            if (!bh.ov(mVar.hen) && i.fV(mVar.hei)) {
                                b.Jj().a(new 2(mVar), mVar.hen, null, ((com.tencent.mm.modelappbrand.g) g.h(com.tencent.mm.modelappbrand.g.class)).aZ(MMGIFException.D_GIF_ERR_IMAGE_DEFECT, 90));
                            }
                        }
                    }
                }
            }
        }
    }
}
