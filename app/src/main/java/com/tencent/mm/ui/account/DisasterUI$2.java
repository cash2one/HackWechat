package com.tencent.mm.ui.account;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;

class DisasterUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ DisasterUI xNz;

    DisasterUI$2(DisasterUI disasterUI) {
        this.xNz = disasterUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        g.pQN.h(13939, new Object[]{Integer.valueOf(3)});
        x.i("MicroMsg.DisasterUI", "summerdiz back");
        this.xNz.finish();
        return true;
    }
}
