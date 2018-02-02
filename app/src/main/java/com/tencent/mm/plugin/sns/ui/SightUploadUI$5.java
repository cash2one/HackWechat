package com.tencent.mm.plugin.sns.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.k.b;
import com.tencent.mm.ui.tools.a.c;

class SightUploadUI$5 implements OnMenuItemClickListener {
    final /* synthetic */ SightUploadUI rxb;

    SightUploadUI$5(SightUploadUI sightUploadUI) {
        this.rxb = sightUploadUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (!this.rxb.isFinishing()) {
            SightUploadUI.a(this.rxb, SightUploadUI.a(this.rxb).getText().toString());
            int i = SightUploadUI.a(this.rxb).rBy;
            c GN = c.d(SightUploadUI.a(this.rxb)).GN(b.zA());
            GN.znM = true;
            GN.a(new 1(this, i));
        }
        return false;
    }
}
