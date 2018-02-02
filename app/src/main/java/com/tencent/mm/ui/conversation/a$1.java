package com.tencent.mm.ui.conversation;

import com.tencent.mm.g.a.ae;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class a$1 extends c<ae> {
    final /* synthetic */ a yVT;

    a$1(a aVar) {
        this.yVT = aVar;
        this.xen = ae.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ae aeVar = (ae) bVar;
        com.tencent.mm.pluginsdk.ui.b.b bVar2 = aeVar.fnV.fnX;
        if (bVar2 != null && bVar2.getView() != null) {
            x.i("MicroMsg.BannerHelper", "now add banner:%s, hc:%d", new Object[]{bVar2, Integer.valueOf(this.yVT.hashCode())});
            if (!aeVar.fnV.fnW) {
                switch (aeVar.fnV.level) {
                    case 1:
                        this.yVT.yVL.add(bVar2);
                        break;
                    case 2:
                        this.yVT.yVM.add(bVar2);
                        break;
                    default:
                        this.yVT.yVN.add(bVar2);
                        break;
                }
            }
            this.yVT.yVK.add(bVar2);
        } else {
            x.w("MicroMsg.BannerHelper", "banner is null, event:%s", new Object[]{aeVar});
        }
        return false;
    }
}
