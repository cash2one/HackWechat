package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class IPCallTalkUI$3 implements OnClickListener {
    final /* synthetic */ IPCallTalkUI nNp;

    IPCallTalkUI$3(IPCallTalkUI iPCallTalkUI) {
        this.nNp = iPCallTalkUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.nNp.finish();
    }
}
