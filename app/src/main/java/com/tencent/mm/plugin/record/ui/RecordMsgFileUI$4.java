package com.tencent.mm.plugin.record.ui;

class RecordMsgFileUI$4 implements Runnable {
    final /* synthetic */ RecordMsgFileUI pGq;

    RecordMsgFileUI$4(RecordMsgFileUI recordMsgFileUI) {
        this.pGq = recordMsgFileUI;
    }

    public final void run() {
        this.pGq.enableOptionMenu(true);
        RecordMsgFileUI.p(this.pGq);
    }
}
