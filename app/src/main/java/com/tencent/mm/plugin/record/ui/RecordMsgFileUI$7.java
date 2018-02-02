package com.tencent.mm.plugin.record.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.record.b.h;

class RecordMsgFileUI$7 implements OnClickListener {
    final /* synthetic */ RecordMsgFileUI pGq;

    RecordMsgFileUI$7(RecordMsgFileUI recordMsgFileUI) {
        this.pGq = recordMsgFileUI;
    }

    public final void onClick(View view) {
        String c = h.c(RecordMsgFileUI.a(this.pGq), RecordMsgFileUI.b(this.pGq));
        new Intent().setAction("android.intent.action.VIEW");
        if (4 == RecordMsgFileUI.c(this.pGq)) {
            RecordMsgFileUI.d(this.pGq);
            RecordMsgFileUI.e(this.pGq);
            return;
        }
        RecordMsgFileUI.a(this.pGq, c);
    }
}
