package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.view.MenuItem;
import com.tencent.mm.plugin.appbrand.ui.autofill.b.2;
import com.tencent.mm.protocal.c.ec;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.p.d;

class b$2$2 implements d {
    final /* synthetic */ 2 jOa;

    b$2$2(2 2) {
        this.jOa = 2;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        ec ecVar = (ec) this.jOa.jNZ.jNM.vJv.get(menuItem.getItemId());
        if (ecVar == null) {
            x.e("MicroMsg.AppBrandIDCardVerifyPwdFrag", "not find phone_id, menuItem id :%d", new Object[]{Integer.valueOf(menuItem.getItemId())});
            return;
        }
        x.i("MicroMsg.AppBrandIDCardVerifyPwdFrag", "select menuItem id:%d, phone_id:%s, show_phone:%s, bank_type:%s", new Object[]{Integer.valueOf(menuItem.getItemId()), ecVar.vJt, ecVar.vJu, ecVar.oZz});
        this.jOa.jNZ.jNU = ecVar;
        this.jOa.jNZ.jNV.setText(ecVar.vJu);
    }
}
