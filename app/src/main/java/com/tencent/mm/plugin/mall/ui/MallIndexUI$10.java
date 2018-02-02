package com.tencent.mm.plugin.mall.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bm.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;

class MallIndexUI$10 implements OnClickListener {
    final /* synthetic */ MallIndexUI omF;

    MallIndexUI$10(MallIndexUI mallIndexUI) {
        this.omF = mallIndexUI;
    }

    public final void onClick(View view) {
        x.i("MicorMsg.MallIndexUI", "onClick lqtEntrance, isLqbOpen: %s, lqbOpenUrl: %s", new Object[]{Boolean.valueOf(MallIndexUI.e(this.omF)), MallIndexUI.f(this.omF)});
        g.Dk();
        g.Dj().CU().a(a.xvU, Integer.valueOf(-1));
        MallIndexUI.g(this.omF).setVisibility(8);
        if (MallIndexUI.e(this.omF)) {
            d.y(this.omF.mController.xIM, "wallet", ".balance.ui.lqt.WalletLqtDetailUI");
        } else if (!bh.ov(MallIndexUI.f(this.omF))) {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", MallIndexUI.f(this.omF));
            x.d("MicorMsg.MallIndexUI", "raw url: %s", new Object[]{intent.getStringExtra("rawUrl")});
            d.b(this.omF, "webview", ".ui.tools.WebViewUI", intent);
        }
    }
}
