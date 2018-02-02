package com.tencent.mm.plugin.record.ui;

import com.tencent.mm.plugin.messenger.a.f;
import com.tencent.mm.sdk.platformtools.ag;
import java.util.List;

class RecordMsgImageUI$11 implements Runnable {
    final /* synthetic */ Runnable fgd;
    final /* synthetic */ String mpC;
    final /* synthetic */ List pGr;
    final /* synthetic */ RecordMsgImageUI pGz;

    RecordMsgImageUI$11(RecordMsgImageUI recordMsgImageUI, List list, String str, Runnable runnable) {
        this.pGz = recordMsgImageUI;
        this.pGr = list;
        this.mpC = str;
        this.fgd = runnable;
    }

    public final void run() {
        for (String str : this.pGr) {
            f.aZh().a(this.pGz.mController.xIM, str, RecordMsgImageUI.j(this.pGz), 0, "", "");
            f.aZh().dj(this.mpC, str);
        }
        ag.y(this.fgd);
    }

    public final String toString() {
        return super.toString() + "|onActivityResult";
    }
}
