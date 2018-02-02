package com.tencent.mm.plugin.gallery.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.sdk.platformtools.x;

class AlbumPreviewUI$5 implements OnMenuItemClickListener {
    final /* synthetic */ AlbumPreviewUI mSQ;

    AlbumPreviewUI$5(AlbumPreviewUI albumPreviewUI) {
        this.mSQ = albumPreviewUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        x.i("MicroMsg.AlbumPreviewUI", "backBtn");
        this.mSQ.setResult(-2);
        if (AlbumPreviewUI.v(this.mSQ).Od) {
            AlbumPreviewUI.v(this.mSQ).aOs();
        } else {
            this.mSQ.finish();
        }
        return true;
    }
}
