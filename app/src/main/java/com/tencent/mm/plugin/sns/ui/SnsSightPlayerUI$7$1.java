package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.ui.SnsSightPlayerUI.7;

class SnsSightPlayerUI$7$1 implements Runnable {
    final /* synthetic */ 7 rGy;
    final /* synthetic */ Intent val$intent;

    SnsSightPlayerUI$7$1(7 7, Intent intent) {
        this.rGy = 7;
        this.val$intent = intent;
    }

    public final void run() {
        a.ifs.j(this.val$intent, this.rGy.rGv);
        this.rGy.rGv.finish();
    }
}
