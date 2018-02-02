package com.tencent.mm.plugin.record.ui;

import android.app.Dialog;

class RecordMsgFileUI$13 implements Runnable {
    final /* synthetic */ Dialog msk;
    final /* synthetic */ RecordMsgFileUI pGq;

    RecordMsgFileUI$13(RecordMsgFileUI recordMsgFileUI, Dialog dialog) {
        this.pGq = recordMsgFileUI;
        this.msk = dialog;
    }

    public final void run() {
        this.msk.dismiss();
    }
}
