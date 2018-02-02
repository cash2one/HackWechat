package com.tencent.mm.plugin.shake.ui;

import android.view.MenuItem;
import com.tencent.mm.plugin.shake.b.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.p.d;

class ShakeMsgListUI$6 implements d {
    final /* synthetic */ ShakeMsgListUI qqQ;

    ShakeMsgListUI$6(ShakeMsgListUI shakeMsgListUI) {
        this.qqQ = shakeMsgListUI;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        g a = ShakeMsgListUI.a(this.qqQ);
        x.i("MicroMsg.ShakeMessageStorage", "delBySvrId = " + a.gJP.delete(a.getTableName(), "svrid = '" + String.valueOf(ShakeMsgListUI.i(this.qqQ)) + "'", null));
        ShakeMsgListUI.b(this.qqQ).a(null, null);
    }
}
