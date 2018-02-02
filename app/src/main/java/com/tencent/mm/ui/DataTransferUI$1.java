package com.tencent.mm.ui;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;

class DataTransferUI$1 extends af {
    final /* synthetic */ DataTransferUI xET;

    DataTransferUI$1(DataTransferUI dataTransferUI) {
        this.xET = dataTransferUI;
    }

    public final void handleMessage(Message message) {
        if (DataTransferUI.a(this.xET) != null && DataTransferUI.a(this.xET).isShowing()) {
            x.e("MicroMsg.DataTransferUI", "dialog has shown for a long time, auto dismiss it...");
            DataTransferUI.a(this.xET).dismiss();
            this.xET.finish();
        }
    }
}
