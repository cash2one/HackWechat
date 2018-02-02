package com.tencent.mm.plugin.collect.ui;

import android.content.Intent;
import com.tencent.mm.plugin.wallet_core.ui.l.a;
import com.tencent.tmassistantsdk.downloadservice.Downloads;

class CollectMainUI$14 implements a {
    final /* synthetic */ CollectMainUI lnh;

    CollectMainUI$14(CollectMainUI collectMainUI) {
        this.lnh = collectMainUI;
    }

    public final void aze() {
        Intent intent = new Intent();
        intent.setClass(this.lnh.mController.xIM, CollectCreateQRCodeUI.class);
        intent.putExtra("key_currency_unit", this.lnh.lmD);
        this.lnh.startActivityForResult(intent, Downloads.RECV_BUFFER_SIZE);
    }
}
