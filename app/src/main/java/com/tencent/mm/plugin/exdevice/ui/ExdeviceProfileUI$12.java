package com.tencent.mm.plugin.exdevice.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ui.widget.g;

class ExdeviceProfileUI$12 implements OnMenuItemClickListener {
    final /* synthetic */ ExdeviceProfileUI lVZ;

    ExdeviceProfileUI$12(ExdeviceProfileUI exdeviceProfileUI) {
        this.lVZ = exdeviceProfileUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        g gVar = new g(this.lVZ.mController.xIM, g.ztp, false);
        gVar.rKC = new 1(this);
        gVar.rKD = ExdeviceProfileUI.n(this.lVZ);
        gVar.bUk();
        return true;
    }
}
