package com.tencent.mm.plugin.chatroom.ui;

import com.tencent.mm.g.a.lj;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;

class RoomCardUI$2 extends c<lj> {
    final /* synthetic */ RoomCardUI lbL;

    RoomCardUI$2(RoomCardUI roomCardUI) {
        this.lbL = roomCardUI;
        this.xen = lj.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        lj ljVar = (lj) bVar;
        String str = ljVar.fCK.fCL;
        String str2 = ljVar.fCK.fCM;
        int i = ljVar.fCK.ret;
        if (i != 0 && str2 != null) {
            h.b(this.lbL, str2, str, true);
            if (RoomCardUI.g(this.lbL) != null) {
                ar.Hg();
                com.tencent.mm.z.c.EX().c(RoomCardUI.g(this.lbL));
            }
        } else if (i == 0) {
            if (RoomCardUI.h(this.lbL)) {
                RoomCardUI.a(this.lbL, RoomCardUI.b(this.lbL).getText().toString());
            } else {
                RoomCardUI.i(this.lbL);
            }
        }
        if (!(RoomCardUI.h(this.lbL) || RoomCardUI.j(this.lbL) == null || !RoomCardUI.j(this.lbL).isShowing())) {
            RoomCardUI.j(this.lbL).dismiss();
        }
        return false;
    }
}
