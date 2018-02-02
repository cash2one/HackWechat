package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.ui.base.h;

class SnsUploadUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ SnsUploadUI rLR;

    SnsUploadUI$2(SnsUploadUI snsUploadUI) {
        this.rLR = snsUploadUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (SnsUploadUI.j(this.rLR) == 9) {
            this.rLR.setResult(0, new Intent());
            this.rLR.finish();
        } else {
            h.a(this.rLR, j.qMF, 0, j.dDM, j.dEn, new 1(this), null, c.brm);
        }
        return true;
    }
}
