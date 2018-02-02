package com.tencent.mm.plugin.mall.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.platformtools.x;

class MallIndexBaseUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ MallIndexBaseUI oma;

    MallIndexBaseUI$1(MallIndexBaseUI mallIndexBaseUI) {
        this.oma = mallIndexBaseUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        Intent intent = new Intent();
        intent.addFlags(67108864);
        intent.putExtra("preferred_tab", 3);
        d.a(this.oma, "com.tencent.mm.ui.LauncherUI", intent);
        this.oma.finish();
        if (!f.ccT()) {
            g.pQN.h(14954, new Object[]{f.ccU(), "open_wcpay_specific_view:ok"});
            f.ccV();
        }
        g.pQN.h(14419, new Object[]{this.oma.ned, Integer.valueOf(6)});
        x.i("MicroMsg.MallIndexBaseUI", "set BackBtn");
        return true;
    }
}
