package com.tencent.mm.plugin.gallery.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.gallery.model.c;

class AlbumPreviewUI$14 implements OnClickListener {
    final /* synthetic */ AlbumPreviewUI mSQ;

    AlbumPreviewUI$14(AlbumPreviewUI albumPreviewUI) {
        this.mSQ = albumPreviewUI;
    }

    public final void onClick(View view) {
        AlbumPreviewUI.h(this.mSQ);
        Intent intent = new Intent(this.mSQ, ImagePreviewUI.class);
        c.w(AlbumPreviewUI.a(this.mSQ).mRK);
        intent.putStringArrayListExtra("preview_image_list", AlbumPreviewUI.a(this.mSQ).aOm());
        intent.putExtra("max_select_count", AlbumPreviewUI.i(this.mSQ));
        intent.putExtra("send_raw_img", AlbumPreviewUI.d(this.mSQ));
        intent.putExtra("GalleryUI_FromUser", AlbumPreviewUI.j(this.mSQ));
        intent.putExtra("GalleryUI_ToUser", AlbumPreviewUI.k(this.mSQ));
        this.mSQ.startActivityForResult(intent, 0);
    }
}
