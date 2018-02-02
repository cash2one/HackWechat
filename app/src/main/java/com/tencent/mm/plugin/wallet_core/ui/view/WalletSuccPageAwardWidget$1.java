package com.tencent.mm.plugin.wallet_core.ui.view;

import android.graphics.Bitmap;
import com.tencent.mm.aq.a.c.i;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class WalletSuccPageAwardWidget$1 implements i {
    final /* synthetic */ WalletSuccPageAwardWidget sYo;

    WalletSuccPageAwardWidget$1(WalletSuccPageAwardWidget walletSuccPageAwardWidget) {
        this.sYo = walletSuccPageAwardWidget;
    }

    public final void a(String str, Bitmap bitmap, Object... objArr) {
        x.i("MicroMsg.WalletSuccPageAwardWidget", "load background_img_whole finish, url: %s, bitmap: %s", new Object[]{str, bitmap});
        if (bitmap != null && WalletSuccPageAwardWidget.a(this.sYo) != null && !bh.ov(WalletSuccPageAwardWidget.a(this.sYo).Avj) && WalletSuccPageAwardWidget.a(this.sYo).Avj.equals(str)) {
            ag.y(new 1(this, bitmap));
        }
    }
}
