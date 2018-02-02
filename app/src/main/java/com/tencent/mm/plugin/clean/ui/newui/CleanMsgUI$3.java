package com.tencent.mm.plugin.clean.ui.newui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.g;

class CleanMsgUI$3 implements OnClickListener {
    final /* synthetic */ CleanMsgUI lhT;

    CleanMsgUI$3(CleanMsgUI cleanMsgUI) {
        this.lhT = cleanMsgUI;
    }

    public final void onClick(View view) {
        this.lhT.startActivityForResult(new Intent(this.lhT, CleanChattingUI.class), 0);
        g.pQN.a(282, 4, 1, false);
    }
}
