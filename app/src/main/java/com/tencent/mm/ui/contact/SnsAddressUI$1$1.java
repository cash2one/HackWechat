package com.tencent.mm.ui.contact;

import com.tencent.mm.ui.contact.SnsAddressUI.1;

class SnsAddressUI$1$1 implements Runnable {
    final /* synthetic */ 1 yUG;

    SnsAddressUI$1$1(1 1) {
        this.yUG = 1;
    }

    public final void run() {
        if (!this.yUG.yUF.getIntent().getBooleanExtra("stay_in_wechat", true)) {
            this.yUG.yUF.moveTaskToBack(true);
        }
    }
}
