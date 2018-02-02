package com.tencent.mm.ui;

import com.tencent.mm.sdk.platformtools.x;

class HomeUI$20 implements Runnable {
    final /* synthetic */ HomeUI xGv;

    HomeUI$20(HomeUI homeUI) {
        this.xGv = homeUI;
    }

    public final void run() {
        x.i("MicroMsg.LauncherUI.HomeUI", "contentView.post, padding: %s", new Object[]{Integer.valueOf(HomeUI.c(this.xGv).getPaddingTop())});
    }
}
