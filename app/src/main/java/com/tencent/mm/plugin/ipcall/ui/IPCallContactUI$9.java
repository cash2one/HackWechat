package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class IPCallContactUI$9 implements OnCancelListener {
    final /* synthetic */ IPCallContactUI nIW;

    IPCallContactUI$9(IPCallContactUI iPCallContactUI) {
        this.nIW = iPCallContactUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.nIW.finish();
    }
}
