package com.tencent.mars.mm;

import com.tencent.mars.mm.MMLogic.ReportInfo;
import com.tencent.mm.sdk.platformtools.x;

class MMLogic$1 implements Runnable {
    final /* synthetic */ ReportInfo val$item;

    MMLogic$1(ReportInfo reportInfo) {
        this.val$item = reportInfo;
    }

    public final void run() {
        int access$100 = MMLogic.access$100(this.val$item.actionId);
        if (access$100 == 0) {
            x.e("C2Java", "ActionId Can not convert");
            return;
        }
        this.val$item.actionId = (long) access$100;
    }
}
