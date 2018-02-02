package com.tencent.mm.plugin.exdevice.ui;

import android.view.MenuItem;
import com.tencent.mm.plugin.exdevice.h.b;
import com.tencent.mm.plugin.exdevice.ui.ExdeviceManageDeviceUI.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.p$d;

class ExdeviceManageDeviceUI$a$1 implements p$d {
    final /* synthetic */ a lUT;

    ExdeviceManageDeviceUI$a$1(a aVar) {
        this.lUT = aVar;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        int itemId = menuItem.getItemId();
        x.d("MicroMsg.ExdeviceManageDeviceUI", "onMenuItemSelected, itemId(%d), count(%d).", new Object[]{Integer.valueOf(itemId), Integer.valueOf(this.lUT.getCount())});
        if (itemId >= 0 && itemId < r1) {
            a.a(this.lUT, itemId);
            a.a(this.lUT, (b) a.a(this.lUT).get(itemId));
            this.lUT.notifyDataSetChanged();
        }
    }
}
