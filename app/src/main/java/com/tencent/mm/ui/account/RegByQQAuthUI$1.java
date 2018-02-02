package com.tencent.mm.ui.account;

import android.content.Context;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelsimple.y;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;

class RegByQQAuthUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ RegByQQAuthUI xRG;

    RegByQQAuthUI$1(RegByQQAuthUI regByQQAuthUI) {
        this.xRG = regByQQAuthUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        RegByQQAuthUI.a(this.xRG, RegByQQAuthUI.a(this.xRG).getText().toString().trim());
        if (RegByQQAuthUI.b(this.xRG).equals("")) {
            h.h(this.xRG, R.l.eSF, R.l.dEN);
        } else {
            k yVar = new y("", RegByQQAuthUI.c(this.xRG), RegByQQAuthUI.b(this.xRG), RegByQQAuthUI.d(this.xRG), "", "", RegByQQAuthUI.e(this.xRG), 2);
            ar.CG().a(yVar, 0);
            RegByQQAuthUI regByQQAuthUI = this.xRG;
            Context context = this.xRG;
            this.xRG.getString(R.l.dGO);
            RegByQQAuthUI.a(regByQQAuthUI, h.a(context, this.xRG.getString(R.l.eEh), true, new 1(this, yVar)));
        }
        return true;
    }
}
