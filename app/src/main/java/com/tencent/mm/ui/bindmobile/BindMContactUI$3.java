package com.tencent.mm.ui.bindmobile;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

class BindMContactUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ BindMContactUI ylT;

    BindMContactUI$3(BindMContactUI bindMContactUI) {
        this.ylT = bindMContactUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        BindMContactUI.a(this.ylT, BindMContactUI.d(this.ylT).getText().toString().trim() + bh.Dm(BindMContactUI.b(this.ylT).getText().toString()));
        if (!a.Rb(BindMContactUI.e(this.ylT)) || bh.Dm(BindMContactUI.b(this.ylT).getText().toString()).length() <= 0) {
            h.h(this.ylT, R.l.dLg, R.l.dGO);
        } else {
            x.i("MicroMsg.BindMContactUI", "do next, send sms to self");
            BindMContactUI.b(this.ylT, BindMContactUI.e(this.ylT));
        }
        return true;
    }
}
