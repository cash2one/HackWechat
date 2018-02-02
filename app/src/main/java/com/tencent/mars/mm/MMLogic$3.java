package com.tencent.mars.mm;

import com.tencent.mm.network.aa;
import com.tencent.mm.sdk.platformtools.bh;

class MMLogic$3 implements Runnable {
    final /* synthetic */ String val$_info;

    MMLogic$3(String str) {
        this.val$_info = str;
    }

    public final void run() {
        aa.VS().onPush(268369923, bh.ov(this.val$_info) ? null : this.val$_info.getBytes());
    }
}
