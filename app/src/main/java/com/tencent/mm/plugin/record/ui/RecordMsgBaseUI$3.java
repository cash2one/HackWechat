package com.tencent.mm.plugin.record.ui;

import android.view.View;
import com.tencent.mm.bv.a;
import com.tencent.mm.sdk.platformtools.x;

class RecordMsgBaseUI$3 implements Runnable {
    final /* synthetic */ RecordMsgBaseUI pGf;
    final /* synthetic */ View pGg;

    RecordMsgBaseUI$3(RecordMsgBaseUI recordMsgBaseUI, View view) {
        this.pGf = recordMsgBaseUI;
        this.pGg = view;
    }

    public final void run() {
        View childAt = this.pGf.kGl.getChildAt(this.pGf.kGl.getLastVisiblePosition());
        if (childAt != null) {
            int bottom = childAt.getBottom();
            int bottom2 = this.pGf.kGl.getBottom();
            int fromDPToPix = a.fromDPToPix(this.pGf.mController.xIM, 64);
            x.d("MicroMsg.RecordMsgBaseUI", "lastBotm %s, listBotm %s, listEndmargin %s", new Object[]{Integer.valueOf(bottom), Integer.valueOf(bottom2), Integer.valueOf(fromDPToPix)});
            if (bottom < bottom2 - fromDPToPix) {
                x.d("MicroMsg.RecordMsgBaseUI", "offset %d", new Object[]{Integer.valueOf((bottom2 - bottom) - fromDPToPix)});
                this.pGg.setPadding(0, bottom, 0, 0);
            }
        }
        this.pGf.kGl.addFooterView(this.pGg, null, false);
    }
}
