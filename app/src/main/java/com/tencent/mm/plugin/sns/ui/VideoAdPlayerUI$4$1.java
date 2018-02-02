package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.ui.VideoAdPlayerUI.4;

class VideoAdPlayerUI$4$1 implements Runnable {
    final /* synthetic */ 4 rNz;
    final /* synthetic */ Intent val$intent;

    VideoAdPlayerUI$4$1(4 4, Intent intent) {
        this.rNz = 4;
        this.val$intent = intent;
    }

    public final void run() {
        a.ifs.j(this.val$intent, this.rNz.rNx);
    }
}
