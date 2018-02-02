package com.tencent.mm.plugin.remittance.ui;

import android.content.Intent;
import com.tencent.mm.bm.d;
import com.tencent.mm.sdk.platformtools.bh;

class RemittanceResultNewUI$4 implements Runnable {
    final /* synthetic */ RemittanceResultNewUI pPA;

    RemittanceResultNewUI$4(RemittanceResultNewUI remittanceResultNewUI) {
        this.pPA = remittanceResultNewUI;
    }

    public final void run() {
        if (RemittanceResultNewUI.c(this.pPA) == 33 || RemittanceResultNewUI.c(this.pPA) == 32 || RemittanceResultNewUI.c(this.pPA) == 48) {
            this.pPA.finish();
        } else if (bh.ov(RemittanceResultNewUI.d(this.pPA)) || RemittanceResultNewUI.e(this.pPA)) {
            this.pPA.finish();
        } else {
            Intent intent = new Intent();
            intent.putExtra("Chat_User", RemittanceResultNewUI.d(this.pPA));
            intent.putExtra("finish_direct", false);
            d.a(this.pPA, ".ui.chatting.ChattingUI", intent);
        }
    }
}
