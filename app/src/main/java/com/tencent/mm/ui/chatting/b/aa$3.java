package com.tencent.mm.ui.chatting.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.report.service.g;

class aa$3 implements OnClickListener {
    final /* synthetic */ aa yCl;

    aa$3(aa aaVar) {
        this.yCl = aaVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        g.pQN.h(10997, Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
        dialogInterface.dismiss();
    }
}
