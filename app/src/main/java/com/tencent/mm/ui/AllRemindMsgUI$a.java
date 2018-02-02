package com.tencent.mm.ui;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

class AllRemindMsgUI$a implements e, Runnable {
    final /* synthetic */ AllRemindMsgUI xDG;

    AllRemindMsgUI$a(AllRemindMsgUI allRemindMsgUI) {
        this.xDG = allRemindMsgUI;
    }

    public final void run() {
        ar.CG().a(new s(), 0);
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.emoji.AllRemindMsgUI", "[onSceneEnd] errType:%s,errCode:%s,errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i != 0 || i2 != 0) {
            x.e("MicroMsg.emoji.AllRemindMsgUI", "[onSceneEnd] errType:%s,errCode:%s,errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            AllRemindMsgUI.c(this.xDG).setVisibility(0);
            AllRemindMsgUI.e(this.xDG).setVisibility(8);
        } else if (kVar.getType() == 866) {
            com.tencent.mm.sdk.f.e.post(new 1(this, kVar), "MicroMsg.emoji.AllRemindMsgUI[onSceneEnd]");
        }
    }
}
