package com.tencent.mm.app;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.app.WeChatSplashStartup.2;

class WeChatSplashStartup$2$1 implements OnClickListener {
    final /* synthetic */ Runnable fgd;
    final /* synthetic */ 2 fge;

    WeChatSplashStartup$2$1(2 2, Runnable runnable) {
        this.fge = 2;
        this.fgd = runnable;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.fgd.run();
    }
}
