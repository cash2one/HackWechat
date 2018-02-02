package com.tencent.mm.plugin.exdevice.ui;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.R;
import com.tencent.mm.plugin.exdevice.f.b.c;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.sport.b.d;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p$d;

class ExdeviceProfileUI$29 implements p$d {
    final /* synthetic */ ExdeviceProfileUI lVZ;

    ExdeviceProfileUI$29(ExdeviceProfileUI exdeviceProfileUI) {
        this.lVZ = exdeviceProfileUI;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 0:
                d.pY(26);
                ExdeviceProfileUI.s(this.lVZ);
                return;
            case 1:
                d.pY(27);
                ExdeviceProfileUI.r(this.lVZ);
                return;
            case 2:
                ExdeviceProfileUI.t(this.lVZ);
                return;
            case 3:
                h.a(this.lVZ.mController.xIM, this.lVZ.getString(R.l.edP), null, true, new 1(this), null);
                return;
            case 4:
                ExdeviceProfileUI.b(this.lVZ, true);
                d.pY(10);
                ad.aEs();
                c.b("", ExdeviceProfileUI.w(this.lVZ), ExdeviceProfileUI.u(this.lVZ), 3);
                return;
            case 5:
                Intent intent = new Intent();
                intent.putExtra("rawUrl", ExdeviceProfileUI.o(this.lVZ));
                com.tencent.mm.bm.d.b(this.lVZ, "webview", ".ui.tools.WebViewUI", intent);
                return;
            default:
                return;
        }
    }
}
