package com.tencent.mm.plugin.qqmail.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;

class AttachDownloadPage$2 implements OnMenuItemClickListener {
    final /* synthetic */ AttachDownloadPage pqt;

    AttachDownloadPage$2(AttachDownloadPage attachDownloadPage) {
        this.pqt = attachDownloadPage;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        h.a(this.pqt, "", new String[]{this.pqt.getString(R.l.eAd)}, "", false, new 1(this));
        return true;
    }
}
