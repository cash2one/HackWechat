package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.g;

class CleanMsgUI$3 implements OnClickListener {
    final /* synthetic */ CleanMsgUI lhh;

    CleanMsgUI$3(CleanMsgUI cleanMsgUI) {
        this.lhh = cleanMsgUI;
    }

    public final void onClick(View view) {
        this.lhh.startActivityForResult(new Intent(this.lhh, CleanChattingUI.class), 0);
        g.pQN.a(714, 12, 1, false);
    }
}
