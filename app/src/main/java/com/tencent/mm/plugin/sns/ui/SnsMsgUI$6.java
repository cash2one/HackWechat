package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class SnsMsgUI$6 implements OnClickListener {
    final /* synthetic */ SnsMsgUI rDE;

    SnsMsgUI$6(SnsMsgUI snsMsgUI) {
        this.rDE = snsMsgUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        SnsMsgUI.a(this.rDE, true);
    }
}
