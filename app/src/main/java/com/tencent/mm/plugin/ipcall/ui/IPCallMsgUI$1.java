package com.tencent.mm.plugin.ipcall.ui;

import android.view.View;
import com.tencent.mm.ui.base.MMSlideDelView.c;

class IPCallMsgUI$1 implements c {
    final /* synthetic */ IPCallMsgUI nKK;

    IPCallMsgUI$1(IPCallMsgUI iPCallMsgUI) {
        this.nKK = iPCallMsgUI;
    }

    public final int ci(View view) {
        return IPCallMsgUI.a(this.nKK).getPositionForView(view);
    }
}
