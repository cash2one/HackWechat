package com.tencent.mm.plugin.clean.ui.newui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.clean.c.d;
import com.tencent.mm.plugin.clean.c.e;
import com.tencent.mm.plugin.clean.ui.newui.CleanMsgUI.6;

class CleanMsgUI$6$1 implements OnClickListener {
    final /* synthetic */ 6 lhV;

    CleanMsgUI$6$1(6 6) {
        this.lhV = 6;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        CleanMsgUI.a(this.lhV.lhT, new e(d.ayi(), this.lhV.lhT, CleanMsgUI.ayD()));
        CleanMsgUI.b(this.lhV.lhT).start();
        CleanMsgUI.c(this.lhV.lhT).show();
    }
}
