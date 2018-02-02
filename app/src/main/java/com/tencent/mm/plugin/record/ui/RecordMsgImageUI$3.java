package com.tencent.mm.plugin.record.ui;

import com.tencent.mm.g.a.mr;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class RecordMsgImageUI$3 extends c<mr> {
    final /* synthetic */ RecordMsgImageUI pGz;

    RecordMsgImageUI$3(RecordMsgImageUI recordMsgImageUI) {
        this.pGz = recordMsgImageUI;
        this.xen = mr.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        mr mrVar = (mr) bVar;
        RecordMsgImageUI.i(this.pGz).put(mrVar.fED.filePath, mrVar);
        if (RecordMsgImageUI.k(this.pGz) != null && RecordMsgImageUI.k(this.pGz).rKB.isShowing()) {
            RecordMsgImageUI.d(this.pGz);
        }
        return true;
    }
}
