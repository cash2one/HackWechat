package com.tencent.mm.ui.chatting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.z.ar;

class AppAttachDownloadUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ AppAttachDownloadUI ypv;

    AppAttachDownloadUI$1(AppAttachDownloadUI appAttachDownloadUI) {
        this.ypv = appAttachDownloadUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (AppAttachDownloadUI.a(this.ypv) != null) {
            ar.CG().c(AppAttachDownloadUI.a(this.ypv));
        }
        this.ypv.finish();
        return true;
    }
}
