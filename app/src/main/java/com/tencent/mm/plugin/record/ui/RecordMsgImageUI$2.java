package com.tencent.mm.plugin.record.ui;

class RecordMsgImageUI$2 implements Runnable {
    final /* synthetic */ RecordMsgImageUI pGz;

    RecordMsgImageUI$2(RecordMsgImageUI recordMsgImageUI) {
        this.pGz = recordMsgImageUI;
    }

    public final void run() {
        RecordMsgImageUI.a(this.pGz).notifyDataSetChanged();
    }
}
