package com.tencent.mm.plugin.ipcall.ui;

import android.view.View;
import com.tencent.mm.ui.base.MMSlideDelView.f;

class IPCallMsgUI$2 implements f {
    final /* synthetic */ IPCallMsgUI nKK;

    IPCallMsgUI$2(IPCallMsgUI iPCallMsgUI) {
        this.nKK = iPCallMsgUI;
    }

    public final void t(View view, int i) {
        IPCallMsgUI.a(this.nKK).performItemClick(view, i, 0);
    }
}
