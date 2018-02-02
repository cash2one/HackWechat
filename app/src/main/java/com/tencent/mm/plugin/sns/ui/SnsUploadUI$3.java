package com.tencent.mm.plugin.sns.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.k.b;
import com.tencent.mm.plugin.report.service.f;
import com.tencent.mm.ui.tools.a.c;

class SnsUploadUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ SnsUploadUI rLR;

    SnsUploadUI$3(SnsUploadUI snsUploadUI) {
        this.rLR = snsUploadUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (!this.rLR.isFinishing() && System.currentTimeMillis() - SnsUploadUI.k(this.rLR) >= 500) {
            SnsUploadUI.a(this.rLR, System.currentTimeMillis());
            f.vz(22);
            c GN = c.d(SnsUploadUI.a(this.rLR)).GN(b.zA());
            GN.znM = true;
            GN.a(new 1(this));
        }
        return false;
    }
}
