package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMSlideDelView.e;

class SnsMsgUI$12 implements e {
    final /* synthetic */ SnsMsgUI rDE;

    SnsMsgUI$12(SnsMsgUI snsMsgUI) {
        this.rDE = snsMsgUI;
    }

    public final void bo(Object obj) {
        if (obj == null) {
            x.e("MicroMsg.SnsMsgUI", "onItemDel object null");
            return;
        }
        try {
            SnsMsgUI.a(this.rDE, bh.VI(obj.toString()));
        } catch (Throwable e) {
            x.e("MicroMsg.SnsMsgUI", "onItemDel object not int");
            x.printErrStackTrace("MicroMsg.SnsMsgUI", e, "", new Object[0]);
        }
    }
}
