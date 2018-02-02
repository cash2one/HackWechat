package com.tencent.mm.view;

import com.tencent.mm.api.i;
import com.tencent.mm.api.n.a;
import com.tencent.mm.sdk.platformtools.x;

class a$7 implements a {
    final /* synthetic */ a zDj;

    a$7(a aVar) {
        this.zDj = aVar;
    }

    public final void a(i iVar) {
        x.i("MicroMsg.BaseDrawingView", "[onSelectedEmoji] emojiInfo:%s", new Object[]{iVar});
        this.zDj.cAl().c(iVar);
        onHide();
    }

    public final void onHide() {
        this.zDj.aC(true);
        this.zDj.nH(true);
        this.zDj.aB(true);
    }
}
