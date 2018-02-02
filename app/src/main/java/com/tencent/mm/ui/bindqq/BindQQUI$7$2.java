package com.tencent.mm.ui.bindqq;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.mm.R;
import com.tencent.mm.modelsimple.h;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.bindqq.BindQQUI.2;
import com.tencent.mm.ui.bindqq.BindQQUI.7;
import com.tencent.mm.z.ar;

class BindQQUI$7$2 implements d {
    final /* synthetic */ 7 ymI;

    BindQQUI$7$2(7 7) {
        this.ymI = 7;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 0:
                Context context = this.ymI.ymH;
                ar.CG().a(new h(h.hMG), 0);
                context.getString(R.l.dGO);
                context.tipDialog = com.tencent.mm.ui.base.h.a(context, context.getString(R.l.eLF), true, new 2(context));
                return;
            default:
                return;
        }
    }
}
