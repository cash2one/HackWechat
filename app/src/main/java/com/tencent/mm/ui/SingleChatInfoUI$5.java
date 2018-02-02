package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.report.service.g;

class SingleChatInfoUI$5 implements OnClickListener {
    final /* synthetic */ SingleChatInfoUI xMD;

    SingleChatInfoUI$5(SingleChatInfoUI singleChatInfoUI) {
        this.xMD = singleChatInfoUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        g.pQN.h(14553, new Object[]{Integer.valueOf(6), Integer.valueOf(4), SingleChatInfoUI.d(this.xMD)});
        SingleChatInfoUI.dE(true);
        if (SingleChatInfoUI.e(this.xMD)) {
            this.xMD.finish();
            return;
        }
        LauncherUI cmG = LauncherUI.cmG();
        if (cmG != null) {
            cmG.startChatting(SingleChatInfoUI.f(this.xMD).field_username, null, true);
        }
    }
}
