package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class IPCallDialUI$4 implements OnClickListener {
    final /* synthetic */ IPCallDialUI nJK;

    IPCallDialUI$4(IPCallDialUI iPCallDialUI) {
        this.nJK = iPCallDialUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.nJK.finish();
    }
}
