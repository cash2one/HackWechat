package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.g.a.rp;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.af;

class ac$3 extends c<rp> {
    final /* synthetic */ ac yCz;

    ac$3(ac acVar) {
        this.yCz = acVar;
        this.xen = rp.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        rp rpVar = (rp) bVar;
        if (rpVar instanceof rp) {
            String str = rpVar.fJv.id;
            int i = rpVar.fJv.ret;
            new af().postDelayed(new 1(this, i, str), (long) (i == 5 ? MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN : 0));
        }
        return false;
    }
}
