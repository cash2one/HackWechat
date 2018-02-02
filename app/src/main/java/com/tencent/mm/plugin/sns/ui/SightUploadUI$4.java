package com.tencent.mm.plugin.sns.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.ui.base.h;

class SightUploadUI$4 implements OnMenuItemClickListener {
    final /* synthetic */ SightUploadUI rxb;

    SightUploadUI$4(SightUploadUI sightUploadUI) {
        this.rxb = sightUploadUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        h.a(this.rxb.mController.xIM, null, new String[]{this.rxb.getString(j.qJQ)}, null, new 1(this));
        return false;
    }
}
