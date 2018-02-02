package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.mm.plugin.mmsight.ui.MMSightCircularProgressBar.a;
import com.tencent.mm.sdk.platformtools.x;

class MMSightRecordButton$1 implements a {
    final /* synthetic */ a oBs;
    final /* synthetic */ MMSightRecordButton oBt;

    MMSightRecordButton$1(MMSightRecordButton mMSightRecordButton, a aVar) {
        this.oBt = mMSightRecordButton;
        this.oBs = aVar;
    }

    public final void bbs() {
        x.k("MicroMsg.MMSightRecordButton", "outer, onProgressFinish", new Object[0]);
        this.oBt.bbt();
        MMSightRecordButton.a(this.oBt, new 1(this));
    }
}
