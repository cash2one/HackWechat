package com.tencent.mm.plugin.wallet_core.ui.view;

import android.graphics.Bitmap;
import android.graphics.NinePatch;
import android.graphics.drawable.NinePatchDrawable;
import com.tencent.mm.aq.a.c.i;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class WalletSuccPageAwardWidget$3 implements i {
    final /* synthetic */ WalletSuccPageAwardWidget sYo;

    WalletSuccPageAwardWidget$3(WalletSuccPageAwardWidget walletSuccPageAwardWidget) {
        this.sYo = walletSuccPageAwardWidget;
    }

    public final void a(String str, Bitmap bitmap, Object... objArr) {
        x.i("MicroMsg.WalletSuccPageAwardWidget", "load background_img finish, url: %s, bitmap: %s", new Object[]{str, bitmap});
        if (bitmap != null && WalletSuccPageAwardWidget.f(this.sYo) != null && !bh.ov(WalletSuccPageAwardWidget.f(this.sYo).Avv) && WalletSuccPageAwardWidget.f(this.sYo).Avv.equals(str)) {
            ag.y(new 1(this, new NinePatchDrawable(this.sYo.getResources(), new NinePatch(bitmap, WalletSuccPageAwardWidget.L(bitmap), "widget_bg"))));
        }
    }
}
