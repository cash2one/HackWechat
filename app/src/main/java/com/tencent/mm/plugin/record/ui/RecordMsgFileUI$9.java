package com.tencent.mm.plugin.record.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.record.b.h;

class RecordMsgFileUI$9 implements OnClickListener {
    final /* synthetic */ RecordMsgFileUI pGq;

    RecordMsgFileUI$9(RecordMsgFileUI recordMsgFileUI) {
        this.pGq = recordMsgFileUI;
    }

    public final void onClick(View view) {
        if (f.ze()) {
            h.a(RecordMsgFileUI.a(this.pGq), RecordMsgFileUI.b(this.pGq), true);
            RecordMsgFileUI.f(this.pGq);
            return;
        }
        com.tencent.mm.ui.base.h.h(this.pGq.mController.xIM, R.l.efU, R.l.dGO);
    }
}
