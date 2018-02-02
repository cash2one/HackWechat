package com.tencent.mm.plugin.record.ui;

import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;

class RecordMsgFileUI$6 implements Runnable {
    final /* synthetic */ RecordMsgFileUI pGq;

    RecordMsgFileUI$6(RecordMsgFileUI recordMsgFileUI) {
        this.pGq = recordMsgFileUI;
    }

    public final void run() {
        RecordMsgFileUI.g(this.pGq);
        h.bu(this.pGq.mController.xIM, this.pGq.getString(R.l.dYZ));
    }
}
