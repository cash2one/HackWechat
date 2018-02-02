package com.tencent.mm.plugin.gallery.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class AlbumPreviewUI$17 implements OnClickListener {
    final /* synthetic */ AlbumPreviewUI mSQ;

    AlbumPreviewUI$17(AlbumPreviewUI albumPreviewUI) {
        this.mSQ = albumPreviewUI;
    }

    public final void onClick(View view) {
        AlbumPreviewUI.u(this.mSQ);
        AlbumPreviewUI.v(this.mSQ).aOs();
        x.d("MicroMsg.AlbumPreviewUI", "click folder times[%d]", Integer.valueOf(AlbumPreviewUI.w(this.mSQ)));
    }
}
