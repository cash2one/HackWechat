package com.tencent.mm.ui.chatting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.z.ar;

class ImageDownloadUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ ImageDownloadUI yxh;

    ImageDownloadUI$1(ImageDownloadUI imageDownloadUI) {
        this.yxh = imageDownloadUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        ar.CG().c(ImageDownloadUI.a(this.yxh));
        this.yxh.finish();
        return true;
    }
}
