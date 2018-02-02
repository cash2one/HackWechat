package com.tencent.mm.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.report.service.g;

class SingleChatInfoUI$6 implements OnClickListener {
    final /* synthetic */ ProgressDialog lao;
    final /* synthetic */ SingleChatInfoUI xMD;

    SingleChatInfoUI$6(SingleChatInfoUI singleChatInfoUI, ProgressDialog progressDialog) {
        this.xMD = singleChatInfoUI;
        this.lao = progressDialog;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        g.pQN.h(14553, new Object[]{Integer.valueOf(6), Integer.valueOf(3), SingleChatInfoUI.d(this.xMD)});
        this.lao.show();
        SingleChatInfoUI.dE(false);
        SingleChatInfoUI.a(this.xMD, this.lao);
    }
}
