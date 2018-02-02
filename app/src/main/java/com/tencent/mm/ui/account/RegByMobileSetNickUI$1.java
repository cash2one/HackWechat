package com.tencent.mm.ui.account;

import android.content.Context;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelsimple.y;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;

class RegByMobileSetNickUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ RegByMobileSetNickUI xRe;

    RegByMobileSetNickUI$1(RegByMobileSetNickUI regByMobileSetNickUI) {
        this.xRe = regByMobileSetNickUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        String trim = RegByMobileSetNickUI.a(this.xRe).getText().toString().trim();
        if (trim == null || trim.length() <= 0) {
            h.h(this.xRe, R.l.eSF, R.l.eDR);
        } else {
            this.xRe.aWs();
            k yVar = new y("", this.xRe.getIntent().getExtras().getString("regbymobile_pwd"), trim, 0, "", RegByMobileSetNickUI.b(this.xRe), this.xRe.getIntent().getExtras().getString("regbymobile_ticket"), 4);
            ar.CG().a(yVar, 0);
            RegByMobileSetNickUI regByMobileSetNickUI = this.xRe;
            Context context = this.xRe;
            this.xRe.getString(R.l.dGO);
            RegByMobileSetNickUI.a(regByMobileSetNickUI, h.a(context, this.xRe.getString(R.l.eEh), true, new 1(this, yVar)));
        }
        return true;
    }
}
